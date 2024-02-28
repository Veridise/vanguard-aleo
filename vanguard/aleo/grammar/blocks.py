from typing import Any, Union
from pathlib import Path

from ..common import aleo2json

from .instructions import *
from .literals import *
from .types import *
from .misc import *

class AleoEnvironment(AleoNode):
    def __init__(self, build_path, main_file: str="main.aleo"):
        self.programs: dict[str, AleoProgram] = {}
        self.main = None
        self.load(build_path, main_file=main_file)

    # load the entire project
    def load(self, build_path: Union[str, Path], main_file: str="main.aleo"):
        path = build_path if isinstance(build_path, Path) else Path(build_path)
        # look for main.aleo and deploy
        print(f"# [debug] deploy: {main_file}")
        main_path = path / main_file
        main_json = aleo2json(main_path)
        self.main = self.deploy(main_json)
        # look for imports and deploy
        imports_path = path / "imports"
        for fp_path in list(imports_path.glob("*.aleo")):
            print(f"# [debug] deploy: {fp_path.name}")
            fp_json = aleo2json(fp_path)
            self.deploy(fp_json)

    # deploy a single Aleo program
    def deploy(self, node: list) -> str:
        assert node[0] == "start", f"Unsupported source of start, got: {node}"
        p = AleoProgram.from_json(node[1])
        self.programs[p.id] = p
        return p
    
    def resolve_function(self, pid, callee):
        _pid = None
        _fid = None
        match callee:
            case AleoIdentifier():
                _pid = pid
                _fid = callee
            case AleoLocator():
                _pid = callee.pid
                _fid = callee.id
            case _:
                raise NotImplementedError(f"Unsupported callee, got: {callee}")
        assert _pid in self.programs.keys(), f"Cannot locate program, got: {_pid}"
        if _fid in self.programs[_pid].functions.keys() or _fid in self.programs[_pid].closures.keys():
            return (_pid, _fid)
        else:
            raise NotImplementedError(f"Cannot locate function/closure, got: {_fid}")
    
    def mget(self, pid: str, id: Union[AleoRegister, AleoRegisterAccess], ctx: dict=None):
        match id:

            case AleoRegister() | AleoIdentifier():
                # flat
                if ctx is None or id not in ctx.keys():
                    return self.programs[pid].mem[id]
                else:
                    return ctx[id]
                
            case AleoRegisterAccess():
                # potentially nested
                # determine the base
                base = None
                if ctx is None or id.reg not in ctx.keys():
                    # NOTE: check first layer, if not matched, proceed at ctx
                    base = self.programs[pid].mem[id.reg]
                else:
                    base = ctx[id.reg]
                # walk down the path
                for p in id.accs:
                    match p:
                        case AleoAccessByField():
                            base = base[f"{p.field}"]
                        case AleoAccessByIndex():
                            base = base[p.index.value]
                        case _:
                            raise NotImplementedError(f"Unsupported accessor, got: {p}")
                return base
            
            # if literal, directly resolve
            case AleoLiteral():
                return id
            
            case _:
                raise NotImplementedError(f"Unsupported type of id, got: {id} of type {type(id)}")
            

    def mset(self, pid: str, id: Union[AleoRegister, AleoRegisterAccess], val: AleoLiteral, ctx: dict=None):
        match id:

            case AleoRegister() | AleoIdentifier():
                # flat
                if ctx is None or id not in ctx.keys():
                    self.programs[pid].mem[id] = val
                else:
                    ctx[id] = val
            
            case AleoRegisterAccess() if len(id.accs) == 0:
                # no accessor, same as single register
                if ctx is None or id not in ctx.keys():
                    self.programs[pid].mem[id.reg] = val
                else:
                    ctx[id.reg] = val

            case AleoRegisterAccess():
                # potentially nested
                # determine the last but one base
                lbobase = None
                if ctx is None or id.reg not in ctx.keys():
                    # NOTE: check first layer, if not matched, proceed at ctx
                    lbobase = self.programs[pid].mem[id.reg]
                else:
                    lbobase = ctx[id.reg]
                # walk down the path, with the last one left
                for p in id.accs[:-1]:
                    match p:
                        case AleoAccessByField():
                            lbobase = lbobase[f"{p.field}"]
                        case AleoAccessByIndex():
                            lbobase = lbobase[p.index.value]
                        case _:
                            raise NotImplementedError(f"Unsupported accessor, got: {p}")
                # set the last
                lbobase[id.accs[-1]] = val
            
            case _:
                raise NotImplementedError(f"Unsupported type of id, got: {id}")

class AleoProgram(AleoNode):
    """A virtual machine that prepare Aleo program for future use and provides common functionalities
    """
    @staticmethod
    def from_json(node):
        _id = None
        _imports = {}
        _structs = {}
        _records = {}
        _mappings = {}
        _functions = {}
        _closures = {}
        for p in node:
            match p:
                case "program" | ";":
                    pass
                case ["program_id", *_]:
                    tmp0 = AleoProgramId.from_json(p)
                    _id = tmp0
                case ["import", *_]:
                    tmp0 = AleoImport.from_json(p)
                    _imports[tmp0.id] = tmp0
                case ["struct", *_]:
                    tmp0 = AleoStruct.from_json(p)
                    _structs[tmp0.id] = tmp0
                case ["record", *_]:
                    tmp0 = AleoRecord.from_json(p)
                    _records[tmp0.id] = tmp0
                case ["mapping", *_]:
                    tmp0 = AleoMapping.from_json(p)
                    _mappings[tmp0.id] = tmp0
                case ["function", *_]:
                    tmp0 = AleoFunction.from_json(p)
                    _functions[tmp0.id] = tmp0
                case ["closure", *_]:
                    tmp0 = AleoClosure.from_json(p)
                    _closures[tmp0.id] = tmp0
                case _:
                    raise NotImplementedError(f"Unsupported json component, got: {p}")
        return AleoProgram(_id, _imports, _structs, _records, _mappings, _functions, _closures)
        
    def __init__(self, id, imports, structs, records, mappings, functions, closures, **kwargs):
        super().__init__(**kwargs)
        self.id = id
        self.imports = imports
        self.structs = structs
        self.records = records
        self.mappings = mappings
        self.functions = functions
        self.closures = closures

        # initialize memory
        self.reset_memory()
        # initialize mapping
        for key in self.mappings.keys():
            self.mem[key] = {}

    def reset_memory(self):
        self.mem = {}

    def __str__(self):
        _imports = "\n".join([str(p) for p in self.imports.values()])
        _id = f"program {self.id};"
        _structs = "\n\n".join([str(p) for p in self.structs.values()])
        _records = "\n\n".join([str(p) for p in self.records.values()])
        _mappings = "\n\n".join([str(p) for p in self.mappings.values()])
        _closures = "\n\n".join([str(p) for p in self.closures.values()])
        _functions = "\n\n".join([str(p) for p in self.functions.values()])
        _components = "\n\n".join(filter(None, [_imports, _id, _structs, _records, _mappings, _closures, _functions]))
        return f"{_components}"

class AleoImport(AleoNode):
    @staticmethod
    def from_json(node):
        for p in node:
            match p:
                case "import" | ";":
                    pass
                case ["program_id", *_]:
                    _id = AleoProgramId.from_json(p)
                    return AleoImport(_id)
                case _:
                    raise NotImplementedError(f"Unsupported json component of import, got: {p}")
    
    def __init__(self, id, **kwargs):
        super().__init__(**kwargs)
        self.id = id

    def __str__(self):
        return f"import {self.id};"

class AleoStruct(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["struct", "struct", id, ":", *tuples]:
                _id = AleoIdentifier.from_json(id)
                _fields = {}
                for p in tuples:
                    assert p[0] == "tuple", f"Unsupported struct member, got: {p}"
                    match p:
                        case ["tuple", name, "as", type, ";"]:
                            n = AleoIdentifier.from_json(name)
                            t = AleoPlaintextType.from_json(type)
                            _fields[n] = t
                        case _:
                            raise NotImplementedError(f"Unsupported json component of tuple, got: {p}")
                return AleoStruct(_id, _fields)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, id, fields, **kwargs):
        super().__init__(**kwargs)
        self.id = id
        self.fields = fields

    def __str__(self):
        _iden = " "*self.iden
        _id = f"struct {self.id}:"
        _fields = "\n".join([f"{_iden}{k} as {v};" for k,v in self.fields.items()])
        return f"{_id}\n{_fields}"
    
    def instantiate(self, params: list):
        _keys = list(self.fields.keys())
        return { _keys[i] : params[i]  for i in range(len(_keys)) }

class AleoMapping(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["mapping", "mapping", id, ":", key, val]:
                _id = AleoIdentifier.from_json(id)
                assert key[0] == "mapping_key" and key[3][0] == "mapping_type", f"Unsupported mapping key, got: {key}"
                assert val[0] == "mapping_value" and val[3][0] == "mapping_type", f"Unsupported mapping value, got: {val}"
                _ktype = AleoPlaintextType.from_json(key[3][1])
                _ktype.visibility = AleoModifier.from_json(key[3][2])
                _vtype = AleoPlaintextType.from_json(val[3][1])
                _vtype.visibility = AleoModifier.from_json(val[3][2])
                return AleoMapping(_id, _ktype, _vtype)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, id, ktype, vtype, **kwargs):
        super().__init__(**kwargs)
        self.id = id
        self.ktype = ktype
        self.vtype = vtype

    def __str__(self):
        _iden = " "*self.iden
        _id = f"mapping {self.id}:"
        _ktype = f"{_iden}key as {self.ktype};"
        _vtype = f"{_iden}value as {self.vtype};"
        return f"{_id}\n{_ktype}\n{_vtype}"

class AleoRecord(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["record", "record", id, ":", "owner", "as", otype, ";", *entries]:
                _id = AleoIdentifier.from_json(id)
                _fields = {}
                # type of owner is always address type; here it's inferred, so we directly construct it
                _fields["owner"] = AleoAddressType(visibility=AleoModifier.from_json("."+otype.split(".")[1]))
                for p in entries:
                    assert p[0] == "entry" and p[3][0] == "entry_type", f"Unsupported entry, got: {p}"
                    name = AleoIdentifier.from_json(p[1])
                    type = AleoPlaintextType.from_json(p[3][1])
                    vis = AleoModifier.from_json(p[3][2])
                    type.visibility = vis
                    _fields[name] = type
                return AleoRecord(_id, _fields)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, id, fields, **kwargs):
        super().__init__(**kwargs)
        self.id = id
        self.fields = fields

    def __str__(self):
        _iden = " "*self.iden
        _id = f"record {self.id}:"
        _fields = "\n".join([f"{_iden}{k} as {v};" for k,v in self.fields.items()])
        return f"{_id}\n{_fields}"
    
    def instantiate(self, params: list):
        _keys = list(self.fields.keys())
        return { _keys[i] : params[i]  for i in range(len(_keys)) }

class AleoFunction(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["function", "function", id, ":", *vs, finalize]:
                # vs: input/output/instruction
                _id = AleoIdentifier.from_json(id)
                _instructions = []
                _inputs = []
                _outputs = []
                for p in vs:
                    match p:
                        case ["instruction", *_]:
                            _instructions.append(AleoInstruction.from_json(p))
                        case ["function_output", "output", operand, "as", vtype, ";"]:
                            key = AleoOperand.from_json(operand)
                            val = AleoValueType.from_json(vtype)
                            _outputs.append((key, val))
                        case ["function_input", "input", reg, "as", vtype, ";"]:
                            key = AleoRegister.from_json(reg)
                            val = AleoValueType.from_json(vtype)
                            _inputs.append((key, val))
                        case _:
                            raise NotImplementedError(f"Unsupported function component, got: {p}")
                _finalize = None if finalize is None else AleoFinalize.from_json(finalize)
                return AleoFunction(_id, _instructions, _inputs, _outputs, _finalize)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, id, instructions, inputs, outputs, finalize, **kwargs):
        super().__init__(**kwargs)
        self.id = id
        self.instructions = instructions
        self.inputs = inputs
        self.outputs = outputs
        self.finalize = finalize
    
    def __str__(self):
        _iden = " "*self.iden
        _id = f"function {self.id}:"
        _inputs = "\n".join([f"{_iden}input {p[0]} as {p[1]};" for p in self.inputs])
        _outputs = "\n".join([f"{_iden}output {p[0]} as {p[1]};" for p in self.outputs])
        _instructions = "\n".join([f"{_iden}{p}" for p in self.instructions])
        _components = "\n".join(filter(None, [_id, _inputs, _instructions, _outputs]))
        return f"{_components}"
    
class AleoFinalize(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["finalize", "finalize", id, ":", *vs]:
                # vs: input/instruction(command)
                _id = AleoIdentifier.from_json(id)
                _instructions = []
                _inputs = []
                for p in vs:
                    match p:
                        case ["command", *vs]:
                            _instructions.append(AleoCommand.from_json(p))
                        case ["finalize_input", "input", reg, "as", ftype, ";"]:
                            key = AleoRegister.from_json(reg)
                            val = AleoFinalizeType.from_json(ftype)
                            _inputs.append((key, val))
                        case _:
                            raise NotImplementedError(f"Unsupported finalize component, got: {p}")
                return AleoFinalize(_id, _instructions, _inputs)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, id, instructions, inputs, **kwargs):
        super().__init__(**kwargs)
        self.id = id
        self.instructions = instructions
        self.inputs = inputs

    def __str__(self):
        _iden = " "*self.iden
        _id = f"finalize {self.id}:"
        _inputs = "\n".join([f"{_iden}input {p[0]} as {p[1]};" for p in self.inputs])
        _instructions = "\n".join([f"{_iden}{p}" for p in self.instructions])
        _components = "\n".join(filter(None, [_id, _inputs, _instructions]))
        return f"{_components}"

class AleoClosure(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["closure", "closure", id, ":", *vs]:
                # vs: input/output/instruction
                _id = AleoIdentifier.from_json(id)
                _instructions = []
                _inputs = []
                _outputs = []
                for p in vs:
                    match p:
                        case ["instruction", *_]:
                            _instructions.append(AleoInstruction.from_json(p))
                        case ["closure_input", "input", reg, "as", rtype, ";"]:
                            key = AleoRegister.from_json(reg)
                            val = AleoRegisterType.from_json(rtype)
                            _inputs.append((key, val))
                        case ["closure_output", "output", operand, "as", rtype, ";"]:
                            key = AleoOperand.from_json(operand)
                            val = AleoRegisterType.from_json(rtype)
                            _outputs.append((key, val))
                        case _:
                            raise NotImplementedError(f"Unsupported closure component, got: {p}")
                return AleoClosure(_id, _instructions, _inputs, _outputs)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")

    def __init__(self, id, instructions, inputs, outputs, **kwargs):
        super().__init__(**kwargs)
        self.id = id
        self.instructions = instructions
        self.inputs = inputs
        self.outputs = outputs

    def __str__(self):
        _iden = " "*self.iden
        _id = f"closure {self.id}:"
        _inputs = "\n".join([f"{_iden}input {p[0]} as {p[1]};" for p in self.inputs])
        _outputs = "\n".join([f"{_iden}output {p[0]} as {p[1]};" for p in self.outputs])
        _instructions = "\n".join([f"{_iden}{p}" for p in self.instructions])
        _components = "\n".join(filter(None, [_id, _inputs, _outputs, _instructions]))
        return f"{_components}"