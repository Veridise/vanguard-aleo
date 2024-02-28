from typing import Any, Union
from enum import Enum

# primitive type of all Aleo components
class AleoNode:
    # FIXME: prevent direct initialization that is compatible with Enum child class
    # NOTE: need both args and kwargs as child class also inherits Enum
    def __init__(self, *args, **kwargs):
        self.iden = 4 # indentation for str function

class AleoProgramId(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["program_id", name, ".", domain]:
                assert name[0] == "program_name", f"Unsupported program name, got: {name}"
                assert domain[0] == "program_domain", f"Unsupported program domain, got: {domain}"
                _name = AleoIdentifier.from_json(name[1])
                _domain = AleoIdentifier.from_json(domain[1])
                return AleoProgramId(_name, _domain)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, name, domain, **kwargs):
        super().__init__(**kwargs)
        self.name = name
        self.domain = domain

    def __str__(self):
        return f"{self.name}.{self.domain}"
    
    def __hash__(self):
        return hash(self.__str__())
    
    # NOTE: program id behaves like string but keeps its type
    def __eq__(self, other):
        if type(self) is type(other) or isinstance(other, str):
            return str(self) == str(other)
        else:
            return False

class AleoModifier(AleoNode, Enum):

    DEFAULT = -1
    PRIVATE = 0
    PUBLIC = 1
    CONSTANT = 2
    RECORD = 3
    FUTURE = 4

    @staticmethod
    def from_json(s):
        match s:
            case None:
                return AleoModifier.DEFAULT
            case ".private":
                return AleoModifier.PRIVATE
            case ".public":
                return AleoModifier.PUBLIC
            case ".constant":
                return AleoModifier.CONSTANT
            case ".record":
                return AleoModifier.RECORD
            case ".future":
                return AleoModifier.FUTURE
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {s}")
    
    def __str__(self):
        match self.value:
            case AleoModifier.DEFAULT.value:
                return ""
            case AleoModifier.PRIVATE.value:
                return ".private"
            case AleoModifier.PUBLIC.value:
                return ".public"
            case AleoModifier.CONSTANT.value:
                return ".constant"
            case AleoModifier.RECORD.value:
                return ".record"
            case AleoModifier.FUTURE.value:
                return ".future"
            case _:
                raise NotImplementedError(f"Unsupported modifier, got: {self.value}")
        
class AleoIdentifier(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case [label, *vs] if label in {"lowercase_identifier", "identifier"}:
                ls = []
                for p in vs:
                    match p:
                        case ["letter", ["lowercase_letter", s]]:
                            ls.append(s)
                        case ["letter", ["uppercase_letter", s]]:
                            ls.append(s)
                        case ["lowercase_letter", s]:
                            ls.append(s)
                        case ["uppercase_letter", s]:
                            ls.append(s)
                        case ["digit", s]:
                            ls.append(s)
                        case "_":
                            ls.append("_")
                        case _:
                            raise NotImplementedError(f"Unsupported json component, got: {p}")
                return AleoIdentifier("".join(ls))
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, id, visibility=AleoModifier.DEFAULT, **kwargs):
        super().__init__(**kwargs)
        self.id = id
        self.visibility = visibility
    
    def __str__(self):
        return f"{self.id}{self.visibility}"
    
    # NOTE: when used as key, visibility does not hash
    def __hash__(self):
        return hash(f"{self.id}")
    
    # NOTE: identifier behaves like string but keeps its type
    # NOTE: when used as key, visibility does not hash
    def __eq__(self, other):
        if type(self) is type(other):
            return f"{self.id}" == f"{other.id}"
        elif isinstance(other, str):
            return f"{self.id}" == other
        else:
            return False
    
class AleoRegister(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["register", "r", *vs]:
                # vs: digits
                ls = []
                for p in vs:
                    assert p[0] == "digit", f"Unsupported register, got: {node}"
                    ls.append(p[1])
                return AleoRegister(int("".join(ls)))
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, idx, **kwargs):
        super().__init__(**kwargs)
        self.idx = idx
    
    def __str__(self):
        return f"r{self.idx}"
    
    def __hash__(self):
        return hash(self.__str__())
    
    # NOTE: behaves like string but keeps its type
    def __eq__(self, other):
        if type(self) is type(other) or isinstance(other, str):
            return str(self) == str(other)
        elif isinstance(other, AleoRegisterAccess):
            # NOTE: AleoRegister and AleoRegisterAccess can share key
            return str(self) == str(other)
        else:
            return False

class AleoRegisterAccessor(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["register_accessor", ["access_by_field", *_]]:
                return AleoAccessByField.from_json(node[1])
            case ["register_accessor", ["access_by_index", *_]]:
                return AleoAccessByIndex.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, **kwargs):
        assert type(self) is not AleoRegisterAccessor, "This class cannot be directly instantiated"
        super().__init__(**kwargs)

    def __str__(self):
        raise TypeError()

class AleoAccessByField(AleoRegisterAccessor):

    @staticmethod
    def from_json(node):
        match node:
            case ["access_by_field", ".", id]:
                _id = AleoIdentifier.from_json(id)
                return AleoAccessByField(_id)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, field, **kwargs):
        super().__init__(**kwargs)
        self.field = field

    def __str__(self):
        return f".{self.field}"
    
    def __hash__(self):
        return hash(self.__str__())
    
    # NOTE: behaves like string but keeps its type
    def __eq__(self, other):
        if type(self) is type(other) or isinstance(other, str):
            return str(self) == str(other)
        else:
            return False

class AleoAccessByIndex(AleoRegisterAccessor):

    @staticmethod
    def from_json(node):
        from .literals import AleoU32Literal
        match node:
            case ["access_by_index", "[", u32, "]"]:
                _u32 = AleoU32Literal.from_json(u32)
                return AleoAccessByIndex(_u32)
            case ["access_by_index", "[", *digits, "]"]:
                _u32 = AleoU32Literal.from_json(["u32_literal", None] + digits + ["u32"])
                return AleoAccessByIndex(_u32)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, index, **kwargs):
        super().__init__(**kwargs)
        self.index = index

    def __str__(self):
        return f"[{self.index}]"
    
    def __hash__(self):
        return hash(self.__str__())
    
    # NOTE: behaves like string but keeps its type
    def __eq__(self, other):
        if type(self) is type(other) or isinstance(other, str):
            return str(self) == str(other)
        else:
            return False

class AleoRegisterAccess(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["register_access", register, *vs]:
                # vs: register accessors
                r = AleoRegister.from_json(register)
                _accs = [AleoRegisterAccessor.from_json(p) for p in vs]
                return AleoRegisterAccess(r, _accs)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, reg, accs, **kwargs):
        super().__init__(**kwargs)
        self.reg = reg
        self.accs = accs

    def __str__(self):
        return "".join([f"{self.reg}"] + [f"{p}" for p in self.accs])
    
    def __hash__(self):
        return hash(self.__str__())
    
    # NOTE: behaves like string but keeps its type
    def __eq__(self, other):
        if type(self) is type(other) or isinstance(other, str):
            return str(self) == str(other)
        elif isinstance(other, AleoRegister):
            # NOTE: AleoRegister and AleoRegisterAccess can share key
            return str(self) == str(other)
        else:
            return False


class AleoOperand(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["operand", ["literal", *_]]:
                from .literals import AleoLiteral
                return AleoLiteral.from_json(node[1])
            case ["operand", ["register_access", *_]]:
                return AleoRegisterAccess.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, **kwargs):
        assert type(self) is not AleoOperand, "This class cannot be directly instantiated"
        super().__init__(**kwargs)

    def __str__(self):
        raise TypeError()

class AleoCastDestination(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["cast_destination", dest] if isinstance(dest, str) and dest in {"group.x", "group.y"}:
                return AleoDestinationGroup.from_json(dest)
            case ["cast_destination", ["register_type", *_]]:
                from .types import AleoRegisterType
                return AleoRegisterType.from_json(node[1])
            case ["cast_destination", ["locator", *_]]:
                return AleoLocator.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, **kwargs):
        assert type(self) is not AleoCastDestination, "This class cannot be directly instantiated"
        super().__init__(**kwargs)

    def __str__(self):
        raise TypeError()

class AleoDestinationGroup(AleoNode, Enum):

    X = 0
    Y = 1

    @staticmethod
    def from_json(s):
        match s:
            case "group.x":
                return AleoDestinationGroup.X
            case "group.y":
                return AleoDestinationGroup.Y
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {s}")
    
    def __str__(self):
        match self.value:
            case AleoDestinationGroup.X.value:
                return "group.x"
            case AleoDestinationGroup.Y.value:
                return "group.y"
            case _:
                raise NotImplementedError(f"Unsupported destination group, got: {self.value}")
            
class AleoUnaryOp(AleoNode, Enum):

    ABS = 0
    ABSW = 1
    DOUBLE = 2
    INV = 3
    NEG = 4
    NOT = 5
    SQUARE = 6
    SQRT = 7

    @staticmethod
    def from_json(s):
        match s:
            case ["unary_op", op]:
                _s = op.replace(".", "").upper()
                for p in AleoUnaryOp:
                    if _s == p.name:
                        return p
                raise NotImplementedError(f"Unsupported unary op, got: {op}")
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {s}")
    
    def __str__(self):
        for p in AleoUnaryOp:
            if self.value == p.value:
                if p in {AleoUnaryOp.ABSW}:
                    return p.name[:-1].lower() + ".w"
                else:
                    return p.name.lower()
        raise NotImplementedError(f"Unsupported unary op, got: {self.value}")
            
class AleoBinaryOp(AleoNode, Enum):

    ADD = 0
    ADDW = 1
    SUB = 2
    SUBW = 3
    MUL = 4
    MULW = 5
    DIV = 6
    DIVW = 7
    REM = 8
    REMW = 9
    POW  = 10
    POWW = 11
    SHL = 12
    SHLW = 13
    SHR = 14
    SHRW = 15
    MOD = 16
    AND = 17
    OR = 18
    XOR = 19
    NAND = 20
    NOR = 21
    GT = 22
    GTE = 23
    LT = 24
    LTE = 25

    @staticmethod
    def from_json(s):
        match s:
            case ["binary_op", op]:
                _s = op.replace(".", "").upper()
                for p in AleoBinaryOp:
                    if _s == p.name:
                        return p
                raise NotImplementedError(f"Unsupported binary op, got: {op}")
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {s}")
    
    def __str__(self):
        for p in AleoBinaryOp:
            if self.value == p.value:
                if p in {AleoBinaryOp.ADDW, AleoBinaryOp.SUBW, AleoBinaryOp.MULW, AleoBinaryOp.DIVW,
                         AleoBinaryOp.REMW, AleoBinaryOp.POWW, AleoBinaryOp.SHLW, AleoBinaryOp.SHRW}:
                    return p.name[:-1].lower() + ".w"
                else:
                    return p.name.lower()
        raise NotImplementedError(f"Unsupported binary op, got: {self.value}")
    
class AleoIsOp(AleoNode, Enum):

    NEQ = 0
    EQ = 1

    @staticmethod
    def from_json(s):
        match s:
            case ["is_op", "is.eq"]:
                return AleoIsOp.EQ
            case ["is_op", "is.neq"]:
                return AleoIsOp.NEQ
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {s}")
    
    def __str__(self):
        match self.value:
            case AleoIsOp.NEQ.value:
                return "is.neq"
            case AleoIsOp.EQ.value:
                return "is.eq"
            case _:
                raise NotImplementedError(f"Unsupported is op, got: {self.value}")
            
class AleoAssertOp(AleoNode, Enum):

    NEQ = 0
    EQ = 1

    @staticmethod
    def from_json(s):
        match s:
            case ["assert_op", "assert.eq"]:
                return AleoAssertOp.EQ
            case ["assert_op", "assert.neq"]:
                return AleoAssertOp.NEQ
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {s}")
    
    def __str__(self):
        match self.value:
            case AleoAssertOp.NEQ.value:
                return "assert.neq"
            case AleoAssertOp.EQ.value:
                return "assert.eq"
            case _:
                raise NotImplementedError(f"Unsupported assert op, got: {self.value}")
            
class AleoLocator(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["locator", pid, "/", id]:
                _pid = AleoProgramId.from_json(pid)
                _id = AleoIdentifier.from_json(id)
                return AleoLocator(_pid, _id)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, pid, id, visibility=AleoModifier.DEFAULT, **kwargs):
        super().__init__(**kwargs)
        self.pid = pid
        self.id = id
        self.visibility = visibility

    def __str__(self):
        return f"{self.pid}/{self.id}{self.visibility}"
    
class AleoHash1Op(AleoNode, Enum):

    BHP256 = 0
    BHP512 = 1
    BHP768 = 2
    BHP1024 = 3

    PED64 = 4
    PED128 = 5
    
    PSD2 = 6
    PSD4 = 7
    PSD8 = 8

    KECCAK256 = 9
    KECCAK384 = 10
    KECCAK512 = 11

    SHA3_256 = 12
    SHA3_384 = 13
    SHA3_512 = 14


    @staticmethod
    def from_json(s):
        match s:
            case ["hash1_op", "hash.bhp", "256"]:
                return AleoHash1Op.BHP256
            case ["hash1_op", "hash.bhp", "512"]:
                return AleoHash1Op.BHP512
            case ["hash1_op", "hash.bhp", "768"]:
                return AleoHash1Op.BHP768
            case ["hash1_op", "hash.bhp", "1024"]:
                return AleoHash1Op.BHP1024
            case ["hash1_op", "hash.ped", "64"]:
                return AleoHash1Op.PED64
            case ["hash1_op", "hash.ped", "128"]:
                return AleoHash1Op.PED128
            case ["hash1_op", "hash.psd", "2"]:
                return AleoHash1Op.PSD2
            case ["hash1_op", "hash.psd", "4"]:
                return AleoHash1Op.PSD4
            case ["hash1_op", "hash.psd", "8"]:
                return AleoHash1Op.PSD8
            case ["hash1_op", "hash.keccak", "256"]:
                return AleoHash1Op.KECCAK256
            case ["hash1_op", "hash.keccak", "384"]:
                return AleoHash1Op.KECCAK384
            case ["hash1_op", "hash.keccak", "512"]:
                return AleoHash1Op.KECCAK512
            case ["hash1_op", "hash.sha3_", "256"]:
                return AleoHash1Op.SHA3_256
            case ["hash1_op", "hash.sha3_", "384"]:
                return AleoHash1Op.SHA3_384
            case ["hash1_op", "hash.sha3_", "512"]:
                return AleoHash1Op.SHA3_512
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {s}")
    
    def __str__(self):
        return f"hash.{self.name.lower()}"