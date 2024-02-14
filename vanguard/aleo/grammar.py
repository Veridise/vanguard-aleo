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

    def locate_fc(self, pid: str, node: Union[str, dict, list]):
        """Locate a function/closure from the environment"""
        match node:
            case s if isinstance(s, str):
                assert pid in self.programs.keys(), f"Can't find program {pid}"
                assert s in self.programs[pid].functions.keys() or\
                       s in self.programs[pid].closures.keys(),\
                       f"Can't find function/closure {s} in program {pid}"
                return (pid, s)
            case ["locator", ["program_id", ["program_name", p], ["program_domain", d]], f]:
                pid = f"{p}.{d}"
                assert pid in self.programs.keys(), f"Can't find program {pid}"
                assert f in self.programs[pid].functions.keys() or\
                       f in self.programs[pid].closures.keys(),\
                        f"Can't find function/closure {f} in program {pid}"
                return (pid, f)
            case _: 
                raise NotImplementedError(f"Unsupported function locator, got: {node}")

    def resolve(self, node: Union[dict, list], kfn=lambda x:x, vfn=lambda x:x):
        """Resolve given node into key of memory/ctx or literal value"""
        match node:
            case s if isinstance(s, str):
                # this is usually identifier
                return ("key", kfn(s))
            case ["boolean_literal", v0]:
                return ("val", vfn(v0))
            case ["address_literal", v0]:
                return ("val", vfn(v0))
            case ["register_access", r0]:
                return ("key", kfn(r0))
            case ["unsigned_literal", v0, t0]:
                return ("val", vfn(v0))
            case ["field_literal", v0, t0]:
                return ("val", vfn(v0))
            case ["register_access", r0, ["register_accessor", ["u32_literal", r1]]]:
                # access path for array with literal accessor
                # e.g., r1[0u32]
                return ("path", kfn(r0), kfn(r1))
            case ["register_access", r0, ["register_accessor", r1]]:
                # access path for array with other accessor, or structr/record with accessor
                # e.g., r1.a, r1[r2]
                return ("path", kfn(r0), kfn(r1))
            case _:
                raise NotImplementedError(f"Unsupported node to resolve, got: {node}")
            
    def rget(self, pid: str, node: Union[dict, list], ctx: dict = None, kfn=lambda x:x, vfn=lambda x:x):
        """Resolve and then get"""
        pt = self.resolve(node, kfn=kfn, vfn=vfn)
        match pt:
            case ("key", r0):
                return self.mget(pid, r0, ctx=ctx)
            case ("val", v0):
                return v0
            case ("path", v0, v1):
                # v1 is accessor, which is plain text already
                item = self.mget(pid, v0, ctx=ctx)
                acc = v1
                return item[acc]
            case _:
                raise NotImplementedError(f"Unsupported node, got: {node}")
            
    def rset(self, pid: str, node: Union[dict, list], val: Any, ctx: dict = None, kfn=lambda x:x, vfn=lambda x:x):
        """Resolve and then set"""
        pt = self.resolve(node, kfn=kfn, vfn=vfn)
        match pt:
            case ("key", r0):
                self.mset(pid, r0, val, ctx=ctx)
            case _:
                raise NotImplementedError(f"Unsupported node, got: {node}")

    def mget(self, pid: str, id: str, ctx: dict = None):
        if ctx is None:
            return self.programs[pid].mem[id]
        else:
            if id in ctx.keys():
                return ctx[id]
            else:
                return self.programs[pid].mem[id]

    def mset(self, pid: str, id: str, val: Any, ctx: dict = None):
        if ctx is None:
            self.programs[pid].mem[id] = val
        else:
            if id in ctx.keys():
                ctx[id] = val
            else:
                self.programs[pid].mem[id] = val

    def deploy(self, json: dict) -> str:
        """Deploy a program with attach environment and return
        Args:
          - pid (str): program id
          - json (dict / JSON): raw json output of aleo2json
        Rets:
          - pid of the program deployed
        """
        p = AleoProgram(src=json)
        self.programs[p.id] = p
        return p.id

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

        # other components
        self.struct_constructors = {} # name -> (list -> dict)
        self.record_constructors = {} # name -> (list -> dict)

        # load program from a path or json
        if isinstance(src, dict) or isinstance(src, list):
            self.json = src
            # load and initialize program
            self.ejson = simplify_json(self.json)
            self.load(self.ejson)
            self.init()
        elif isinstance(src, str) or isinstance(src, Path):
            self.json = aleo2json(src)
            # load and initialize program
            self.ejson = simplify_json(self.json)
            self.load(self.ejson)
            self.init()
        elif src is None:
            # empty program
            pass
        else:
            raise NotImplementedError(f"Unsupported source of program, got: {src}")
        
    def init(self):
        """Initialize program components"""
        # load mapping into memory
        for dname in self.mappings.keys():
            self.mem[dname] = {}

        # initialize struct constructors
        for dname in self.structs.keys():
            sfields = list(self.structs[dname].keys())
            # NOTE: err with insufficient args length, ignore extra args
            # beware of lambda local
            # see: https://stackoverflow.com/questions/10452770/python-lambdas-binding-to-local-values
            self.struct_constructors[dname] = \
                lambda *args: { sfields[i] : args[i] for i in range(len(sfields)) }
            
        # initialize record constructors
        for dname in self.records.keys():
            rfields = list(self.records[dname].keys())
            # NOTE: err with insufficient args length, ignore extra args
            # beware of lambda local
            # see: https://stackoverflow.com/questions/10452770/python-lambdas-binding-to-local-values
            self.record_constructors[dname] = \
                lambda *args: { rfields[i] : args[i] for i in range(len(rfields)) }
            
        # TODO: initialize more later

    
    def load(self, node: Union[dict, list]):
        """Load program from easy json
        Args:
          - node: easy json
        """
        for p in node:
            match p:
                case "program":
                    pass

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
                    
                    fs = None
                    if v1 is not None:
                        # also format the finalize block to have the same structure as function
                        fs = { "inputs": [], "instructions": [] }
                        for p0 in v1:
                            match p0:
                                case z if isinstance(z, str) and z in {"finalize", name}:
                                    pass
                                case ["command", cmd]:
                                    if cmd[0] == "instruction":
                                        fs["instructions"].append(cmd[1])
                                    else:
                                        fs["instructions"].append(cmd)
                                case ["finalize_input", var, type]:
                                    fs["inputs"].append((var, type))
                                case _:
                                    raise NotImplementedError(f"Unsupported finalize component, got: {p0}")

                    s["finalize"] = fs
                    self.functions[name] = s

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
                    self.closures[name] = s

                case _:
                    raise NotImplementedError(f"Unsupported json component, got: {p}")

    def reset_memory(self):
        self.mem = {}