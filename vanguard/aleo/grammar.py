from .common import assert_range, trim_inst

class AleoProgram:
    """A virtual machine that prepare Aleo program for future use and provides common functionalities
    """

    def __init__(self, json=None):
        self.json = json

        # simplified json and functions to execute
        self.sjson = None

        # program storage
        self.initialized = False
        self.id = None
        self.network = None
        self.identifiers = {} # id (str) -> type (str)
        self.imports = {}
        self.mappings = {}
        self.structs = {}
        self.records = {}
        self.closures = {}
        self.functions = {}

        if self.json is not None:
            # load and initialize program
            self.sjson = self.simplify_json(self.json, self.simplification_functions_1st) # 1st pass
            self.sjson = self.simplify_json(self.sjson, self.simplification_functions_2nd) # 2nd pass
            self.load_program(self.sjson)

    def assert_node_field(self, node, field, val=None):
        assert field in node.keys(), f"Can't find filed {field} in node"
        if val is not None:
            assert node[field] == val, f"Mismatch of {field} of node, expected: {val}, got: {node[field]}"

    def assert_range(self, value, range):
        assert value in range, f"Value {value} is not in range {range}"

    def simplify_json(self, node, func):
        """Generate a simplified version of json for vm program loading via post-order traversal
        Args:
          - node: node to process
        Rets: copy of modified node
        """
        new_node = None
        # post-order traversal
        if isinstance(node, list):
            new_node = [self.simplify_json(v, func) for v in node]
        elif isinstance(node, dict):
            new_node = {
                k: self.simplify_json(v, func)
                for k,v in node.items()
            }
        else:
            new_node = node
        # process self
        return func(new_node)
    
    def simplification_functions_1st(self, node):
        match node:
            # simplify ProgramID
            case {
                "type": "ProgramCore",
                "id": {
                    "type": "ProgramID",
                    "name": name,
                    "network": network,
                },
                **rest,
            }:
                return {
                    "id": name,
                    "network": network,
                    **rest,
                }
            
            # simplify ProgramDefinition
            case {
                "type": "ProgramDefinition",
                "definition": type,
            }:
                return type

            # simplify ProgramID in imports
            case {
                "type": "Import",
                "program_id": {
                    "type": "ProgramID",
                    "name": name,
                    "network": network,
                }
            }:
                return {
                    "id": name,
                    "network": network,
                }
            
            # simplify type name: Literal
            case {
                "type": "PlaintextType",
                "vtype": "Literal",
                "value": {
                    "type": "LiteralType",
                    "name": type,
                }
            }:
                return type
            
            # simplify type name: Struct
            case {
                "type": "PlaintextType",
                "vtype": "Struct",
                "value": type,
            }:
                return type

            # default: no simplification
            case _:
                return node
            
    def simplification_functions_2nd(self, node):
        match node:
            # simplify mapping
            case {
                "type": "Mapping",
                "name": name,
                "key": {"type": "MapKey", "plaintext_type": kid},
                "value": {"type": "MapValue", "visibility": visibility, "plaintext_type": vid},
            }:
                return {
                    "key": kid,
                    "value": vid,
                    "visibility": visibility,
                }
            
            # simplify struct
            case {
                "type": "StructType",
                "members": {**ms},
                **rest,
            }:
                return {
                    "members": {**ms}
                }
            
            # simplify record
            case {
                "type": "RecordType",
                "owner": owner,
                "entries": entries,
                **rest,
            }:
                return {
                    "owner": owner,
                    "entries": entries,
                }
            
            # default: no simplification
            case _:
                return node
        
    def load_program(self, node):
        """Load program from simplified json
        Args:
          - node: simplified json
        """
        self.id = node["id"]
        self.network = node["network"]
        self.identifiers = node["identifiers"]
        self.imports = node["imports"]
        self.mappings = node["mappings"]
        self.structs = node["structs"]
        self.records = node["records"]
        self.closures = node["closures"]
        self.functions = node["functions"]

        self.initialized = True
    
    def get_function_arguments(self, func, vis, arg):
        """Return a list of private/public inputs/outputs of a given function
        Args:
          - func: target function to analyze
          - vis: private or public
          - arg: input or output
        """
        assert_range(func, self.functions.keys())
        assert_range(arg, set(["inputs", "outputs"]))
        argkw = arg[:-1] # input/output
        assert_range(vis, set(["private", "public"]))

        node = self.functions[func]
        vars = []
        for inst in node[arg]:
            tokens = trim_inst(inst["str"]).split()
            match tokens:

                # visibility and status postfix
                case [kw, r, "as", t] if kw == argkw and (t.endswith(".public") or t.endswith(".private") or t.endswith(".future")):
                    if t.endswith(f".{vis}"):
                        vars.append(r)
                    # for cases that end with ".future", it's used as execution status of the "finalize" function
                    # and this doesn't count as a regular output that can be queried in this function

                # record type
                case [kw, r, "as", t] if kw == argkw:
                    ts = t.split(".")
                    if len(ts) == 2:
                        if self.records[ts[0]]["owner"] == vis:
                            vars.append(r)
                    else:
                        raise NotImplementedError(f"Unknown type, got: {t}")
                
                # others
                case _:
                    raise NotImplementedError(f"Unknown input/output pattern, got: {inst['str']}")
        
        return vars