from typing import Any, Union
from pathlib import Path

from .common import aleo2json, simplify_json

class AleoEnvironment:
    def __init__(self, build_path, main_file: str="main.aleo"):
        self.programs: dict[str, AleoProgram] = {}
        self.main_id = None
        self.load(build_path, main_file=main_file)

    def load(self, build_path: Union[str, Path], main_file: str="main.aleo"):
        path = build_path if isinstance(build_path, Path) else Path(build_path)
        # look for main.aleo and deploy
        print(f"# [debug] deploy: {main_file}")
        main_path = path / main_file
        main_json = aleo2json(main_path)
        self.main_id = self.deploy(main_json)
        # look for imports and deploy
        imports_path = path / "imports"
        for fp_path in list(imports_path.glob("*.aleo")):
            print(f"# [debug] deploy: {fp_path.name}")
            fp_json = aleo2json(fp_path)
            self.deploy(fp_json)

    def deploy(self, json: dict) -> str:
        """Deploy a program with attach environment and return
        Args:
          - pid (str): program id
          - json (dict / JSON): raw json output of aleo2json
        Rets:
          - pid of the program deployed
        """
        p = AleoProgram(env=self, src=json)
        self.programs[p.id] = p
        return p.id
    
    def locate_function(self, bpid: str, fn: str):
        """Return a path to the target function/closure
        Args:
          - bpid (str): base program id to use if the function name doesn't contain pid
          - fn (str): target function name to locate
        Rets:
          - (AleoProgram, dict): target program and function object
        """
        pfn = parse_word(fn)
        match pfn:
            case ("identifier", v0):
                # internal function
                p0 = self.programs[bpid]
                f0 = p0.closures[v0] if v0 in p0.closures.keys() else p0.functions[v0]
                return (p0, f0)
            case ("external", l0, v0):
                # external function
                p0 = self.programs[l0]
                f0 = p0.closures[v0] if v0 in p0.closures.keys() else p0.functions[v0]
                return (p0, f0)
            case _:
                raise NotImplementedError(f"Unsupported function to locate, got: {pfn}")
    
    def evaluate_word(self, pid: str, ctx: dict[str, Any], id: str, callback=None):
        """Evaluate an identifier or a literal
        Args:
          - pid (str): program id
          - ctx (dict): extra local context for the (function/finalize/...) block
          - id (str): identifier
          - callback: function to apply for literal evaluated
        """
        p = parse_word(id)
        match p:
            case ("boolean", v0):
                return v0 if callback is None else callback(p)
            case ("address", v0):
                return v0 if callback is None else callback(p)
            case ("number", t0, v0):
                return v0 if callback is None else callback(p)
            case _:
                # requires memory access, dispatch
                return self.memory_get(pid, ctx, id)

    def memory_get(self, pid: str, ctx: dict[str, Any], id: str):
        """Memory access of given identifier
        Args:
          - pid (str): program id
          - ctx (dict): extra local context for the (function/finalize/...) block
          - id (str): identifier
        """
        # fetch target memory
        mem = self.programs[pid].mem
        p = parse_word(id)
        match p:
            case ("register", s0):
                return ctx[s0] if s0 in ctx.keys() else mem[s0]
            case ("array", id0, od0):
                # on Aleo bytecode level there won't be nested access to array
                pod0 = parse_word(od0)
                vod0 = None
                if pod0[0] == "number" and (pod0[1] not in {"field", "group", "scalar"}):
                    vod0 = ctx[id0][pod0[2]] if id0 in ctx.keys() else mem[id0][pod0[2]]
                elif pod0[0] == "register":
                    # evaluate register into number
                    v0 = ctx[pod0[1]] if pod0[1] in ctx.keys() else mem[pod0[1]]
                    vod0 = ctx[id0][v0] if id0 in ctx.keys() else mem[id0][v0]
                else:
                    raise NotImplementedError(f"Unsupported instance for array access, got: {pod0}")
                # get value stored
                return ctx[id0][vod0] if id0 in ctx.keys() else mem[id0][vod0]
            case _:
                raise NotImplementedError(f"Unsupported instance for memory access, got: {p}")

    def memory_set(self, pid: str, ctx: dict[str, Any], id: str, val: Any):
        """Memory write of given identifier
        Args:
          - pid (str): program id
          - ctx (dict): extra local context for the (function/finalize/...) block
          - id (str): identifier
          - val (Any): value to set
        """
        # FIXME: in actual Aleo bytecode, you can't set a register, but only a mapping
        #        this function extends the capability to register, but can be removed later
        # fetch target memory
        mem = self.programs[pid].mem
        p = parse_word(id)
        match p:
            case ("register", s0):
                if s0 in ctx.keys():
                    ctx[s0] = val
                else:
                    mem[s0] = val
            case ("array", id0, od0):
                # on Aleo bytecode level there won't be nested access to array
                pod0 = parse_word(od0)
                vod0 = None
                if pod0[0] == "number" and (pod0[1] not in {"field", "group", "scalar"}):
                    vod0 = ctx[id0][pod0[2]] if id0 in ctx.keys() else mem[id0][pod0[2]]
                elif pod0[0] == "register":
                    # evaluate register into number
                    v0 = ctx[pod0[1]] if pod0[1] in ctx.keys() else mem[pod0[1]]
                    vod0 = ctx[id0][v0] if id0 in ctx.keys() else mem[id0][v0]
                else:
                    raise NotImplementedError(f"Unsupported instance for array access, got: {pod0}")
                # set value
                if id0 in ctx.keys():
                    ctx[id0][vod0] = val
                else:
                    mem[id0][vod0] = val
            case _:
                raise NotImplementedError(f"Unsupported instance for memory write, got: {p}")

class AleoProgram:
    """A virtual machine that prepare Aleo program for future use and provides common functionalities
    """

    def __init__(self, src: Union[dict, list, str, Path]=None):
        self.mem = {} # runtime memory

        self.json = None # original json
        self.ejson = None # easy json

        self.name = None
        self.domain = None
        self.id = None

        # component mappings
        self.identifiers = {}
        self.imports = {} # id -> (name, domain)
        self.mappings = {} # name -> ( (key, type, visibility), (value, type, visibility) )
        self.structs = {} # name -> { field -> type }
        self.records = {} # name -> { field -> (type, visibility) }
        self.closures = {}
        self.functions = {} # name -> { "inputs": [ (var, type) ], "outputs": [ (ref, type) ], "instructions": [ ... ] }

        # load program from a path or json
        if isinstance(src, dict) or isinstance(src, list):
            self.json = src
            # load and initialize program
            self.ejson = simplify_json(self.json)
            self.load(self.ejson)
        elif isinstance(src, str) or isinstance(src, Path):
            self.json = aleo2json(src)
            # load and initialize program
            self.ejson = simplify_json(self.json)
            self.load(self.ejson)
        elif src is None:
            # empty program
            pass
        else:
            raise NotImplementedError(f"Unsupported source of program, got: {src}")
        
        # return id
        return self.id
    
    def load(self, node: Union[dict, list]):
        """Load program from easy json
        Args:
          - node: easy json
        """
        for p in node:
            match p:

                case ["program_id", v0, v1]:
                    self.name = v0[1]
                    self.domain = v1[1]
                    # NOTE: by observation, program id is file name
                    self.id = f"{self.name}.{self.domain}"

                case ["import", *vs]:
                    for p0 in vs:
                        assert p0[0] == "program_id", f"Unsupported import, got: {p0}"
                        name0 = p0[1][1]
                        domain0 = p0[2][1]
                        id0 = f"{name0}.{domain0}"
                        self.imports[id0] = (name0, domain0)

                case ["struct", v0, *vs]:
                    # v0: name | vs: members
                    s = {}
                    name = v0
                    for p0 in vs:
                        assert p0[0] == "tuple", f"Unsupported struct member, got: {p0}"
                        name0 = p0[1]
                        type0 = p0[2]
                        s[name0] = type0
                    self.structs[name] = s

                case ["record", v0, v1, *vs]:
                    # v0: name | v1: owner's modifier | vs: members
                    s = {}
                    name = v0
                    s["owner"] = ( ["address_type", "address"], v1.split(".")[1] )
                    for p0 in vs:
                        assert p0[0] == "entry" and p0[2][0] == "entry_type", f"Unsupported entry, got: {p0}"
                        name0 = p0[1]
                        type0 = p0[2][1]
                        vis0 = p0[2][2]
                        s[name0] = (type0, vis0)
                    self.records[name] = s
                
                case ["mapping", v0, v1, v2]:
                    # v0: name | v1: key | v2: value
                    s = {}
                    name = v0
                    assert v1[0] == "mapping_key" and v1[2][0] == "mapping_type", f"Unsupported mapping key, got: {v1}"
                    assert v2[0] == "mapping_value" and v2[2][0] == "mapping_type", f"Unsupported mapping value, got: {v2}"
                    k = (v1[1], v1[2][1], v1[2][2])
                    v = (v2[1], v2[2][1], v2[2][2])
                    self.mappings[name] = (k,v)
                
                case ["function", v0, *vs, v1]:
                    # v0: name | vs: input/output/instruction | v1: finalize or None
                    s = { "inputs": [], "outputs": [], "instructions": [] }
                    name = v0
                    for p0 in vs:
                        match p0:
                            case ["instruction", inst]:
                                s["instructions"].append(inst)
                            case ["function_output", ref, type]:
                                s["outputs"].append((ref, type))
                            case ["function_input", var, type]:
                                s["inputs"].append((var, type))
                            case _:
                                raise NotImplementedError(f"Unsupported function component, got: {p0}")
                    s["finalize"] = v1

                case ["closure", v0, *vs]:
                    # v0: name | vs: input/output/instruction
                    s = { "inputs": [], "outputs": [], "instructions": [] }
                    name = v0
                    for p0 in vs:
                        match p0:
                            case ["instruction", inst]:
                                s["instructions"].append(inst)
                            case ["closure_output", ref, type]:
                                s["outputs"].append((ref, type))
                            case ["closure_input", var, type]:
                                s["inputs"].append((var, type))
                            case _: 
                                raise NotImplementedError(f"Unsupported closure component, got: {p0}")

                case _:
                    raise NotImplementedError(f"Unsupported json component, got: {p}")

    def reset_memory(self):
        self.mem = {}