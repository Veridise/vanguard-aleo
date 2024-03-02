from typing import Any, Union

from .misc import *
from .types import *

class AleoCommand(AleoNode):

    @staticmethod
    def from_json(node):
        match node:
            case ["command", ["instruction", *_]]:
                return AleoInstruction.from_json(node[1])
            case ["command", ["set", *_]]:
                return AleoSet.from_json(node[1])
            case ["command", ["random", *_]]:
                return AleoRandom.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, **kwargs):
        assert type(self) is not AleoCommand, "This class cannot be directly instantiated"
        super().__init__(**kwargs)

    def __str__(self):
        raise TypeError()
    

class AleoSet(AleoCommand):

    @staticmethod
    def from_json(node):
        match node:
            case ["set", "set", operand0, "into", id, "[", operand1, "]", ";"]:
                _src = AleoOperand.from_json(operand0)
                _id = AleoIdentifier.from_json(id)
                _tgt = AleoOperand.from_json(operand1)
                return AleoSet(_src, _id, _tgt)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, src, id, tgt, **kwargs):
        super().__init__(**kwargs)
        self.src = src
        self.id = id
        self.tgt = tgt

    def __str__(self):
        return f"set {self.src} into {self.id}[{self.tgt}];"

class AleoRandom(AleoCommand):

    @staticmethod
    def from_json(node):
        match node:
            case ["random", "rand.chacha", *operands, "into", regacc, "as", type, ";"]:
                _operands = [AleoOperand.from_json(p) for p in operands]
                _regacc = AleoRegisterAccess.from_json(regacc)
                _type = None
                match type:
                    case ["arithmetic_type", *_]:
                        _type = AleoArithmeticType.from_json(type)
                    case ["address_type", *_]:
                        _type = AleoAddressType.from_json(type)
                    case ["signature_type", *_]:
                        _type = AleoSignatureType.from_json(type)
                    case ["boolean_type", *_]:
                        _type = AleoBooleanType.from_json(type)
                    case _:
                        raise NotImplementedError(f"Unsupported type of random, got: {node}")
                return AleoRandom(_operands, _regacc, _type)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, operands, regacc, type, **kwargs):
        super().__init__(**kwargs)
        self.operands = operands
        self.regacc = regacc
        self.type = type

    def __str__(self):
        _operands = " ".join([str(p) for p in self.operands])
        return f"random.chacha {_operands} into {self.regacc} as {self.type};"

class AleoInstruction(AleoCommand):

    @staticmethod
    def from_json(inst):
        match inst:
            case ["instruction", ["cast", *_]] | ["instruction", ["cast.lossy", *_]]:
                return AleoCast.from_json(inst[1])
            case ["instruction", ["unary", *_]]:
                return AleoUnary.from_json(inst[1])
            case ["instruction", ["binary", *_]]:
                return AleoBinary.from_json(inst[1])
            case ["instruction", ["is", *_]]:
                return AleoIs.from_json(inst[1])
            case ["instruction", ["assert", *_]]:
                return AleoAssert.from_json(inst[1])
            case ["instruction", ["call", *_]]:
                return AleoCall.from_json(inst[1])
            case ["instruction", ["xasync", *_]]:
                return AleoAsync.from_json(inst[1])
            case ["instruction", ["ternary", *_]]:
                return AleoTernary.from_json(inst[1])
            case ["instruction", ["hash", *_]]:
                return AleoHash.from_json(inst[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {inst}")
            
    def __init__(self, **kwargs):
        assert type(self) is not AleoInstruction, "This class cannot be directly instantiated"
        super().__init__(**kwargs)

    def __str__(self):
        raise TypeError()

class AleoCast(AleoInstruction):

    @staticmethod
    def from_json(node):
        match node:
            case ["cast", op, *operands, "into", regacc, "as", dest, ";"]:
                _lossy = None
                assert op[0] == "cast_op", f"Unsupported cast operator, got: {node}"
                if op[1] == "cast":
                    _lossy = False
                elif op[1] == "cast.lossy":
                    _lossy = True
                else:
                    raise NotImplementedError(f"Unsupported cast operator, got: {node}")
                _operands = []
                for p in operands:
                    _operands.append(AleoOperand.from_json(p))
                _regacc = AleoRegisterAccess.from_json(regacc)
                _dest = AleoCastDestination.from_json(dest)
                return AleoCast(_lossy, _operands, _regacc, _dest)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")

    def __init__(self, lossy, operands, regacc, dest, **kwargs):
        super().__init__(**kwargs)
        self.lossy = lossy
        self.operands = operands
        self.regacc = regacc
        self.dest = dest

    def __str__(self):
        _operands = " ".join([str(p) for p in self.operands])
        if self.lossy:
            return f"cast.lossy {_operands} into {self.regacc} as {self.dest};"
        else:
            return f"cast {_operands} into {self.regacc} as {self.dest};"
        
class AleoUnary(AleoInstruction):

    @staticmethod
    def from_json(node):
        match node:
            case ["unary", op, operand, "into", regacc, ";"]:
                _op = AleoUnaryOp.from_json(op)
                _operand = AleoOperand.from_json(operand)
                _regacc = AleoRegisterAccess.from_json(regacc)
                return AleoUnary(_op, _operand, _regacc)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, op, operand, regacc, **kwargs):
        self.op = op
        self.operand = operand
        self.regacc = regacc

    def __str__(self):
        return f"{self.op} {self.operand} into {self.regacc};"


class AleoBinary(AleoInstruction):

    @staticmethod
    def from_json(node):
        match node:
            case ["binary", op, *operands, "into", regacc, ";"]:
                assert len(operands) == 2, f"Unsupported number of operands, expected: 2, got: {len(operands)}"
                _op = AleoBinaryOp.from_json(op)
                _operands = []
                for p in operands:
                    _operands.append(AleoOperand.from_json(p))
                _regacc = AleoRegisterAccess.from_json(regacc)
                return AleoBinary(_op, _operands, _regacc)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, op, operands, regacc, **kwargs):
        super().__init__(**kwargs)
        self.op = op
        self.operands = operands
        self.regacc = regacc

    def __str__(self):
        _operands = " ".join([str(p) for p in self.operands])
        return f"{self.op} {_operands} into {self.regacc};"

class AleoTernary(AleoInstruction):

    @staticmethod
    def from_json(node):
        match node:
            case ["ternary", "ternary", *operands, "into", regacc, ";"]:
                assert len(operands) == 3, f"Unsupported number or operands, expected: 3, got: {len(operands)}"
                _operands = [AleoOperand.from_json(p) for p in operands]
                _regacc = AleoRegisterAccess.from_json(regacc)
                return AleoTernary(_operands, _regacc)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, operands, regacc, **kwargs):
        super().__init__(**kwargs)
        self.operands = operands
        self.regacc = regacc

    def __str__(self):
        _operands = " ".join([str(p) for p in self.operands])
        return f"ternary {_operands} into {self.regacc};"

class AleoIs(AleoInstruction):

    @staticmethod
    def from_json(node):
        match node:
            case ["is", op, *operands, "into", regacc, ";"]:
                assert len(operands) == 2, f"Unsupported number of operands, expected: 2, got: {len(operands)}"
                _op = AleoIsOp.from_json(op)
                _operands = []
                for p in operands:
                    _operands.append(AleoOperand.from_json(p))
                _regacc = AleoRegisterAccess.from_json(regacc)
                return AleoIs(_op, _operands, _regacc)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, op, operands, regacc, **kwargs):
        super().__init__(**kwargs)
        self.op = op
        self.operands = operands
        self.regacc = regacc
    
    def __str__(self):
        _operands = " ".join([str(p) for p in self.operands])
        return f"{self.op} {_operands} into {self.regacc};"

class AleoAssert(AleoInstruction):

    @staticmethod
    def from_json(node):
        match node:
            case ["assert", op, *operands, ";"]:
                _op = AleoAssertOp.from_json(op)
                _operands = [AleoOperand.from_json(p) for p in operands]
                return AleoAssert(_op, _operands)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, op, operands, **kwargs):
        super().__init__(**kwargs)
        self.op = op
        self.operands = operands

    def __str__(self):
        _operands = " ".join([str(p) for p in self.operands])
        return f"{self.op} {_operands};"

class AleoCall(AleoInstruction):

    @staticmethod
    def from_json(node):
        match node:
            # FIXME: there's another pattern without "into", add it when necessary
            case ["call", "call", *vs, ";"] if "into" in node:
                # extract call components
                idx_into = vs.index("into")
                callee = vs[0]
                operands = vs[1:idx_into]
                regaccs = vs[idx_into+1:]
                _callee = None
                if callee[0] == "locator":
                    _callee = AleoLocator.from_json(callee)
                elif callee[0] == "identifier":
                    _callee = AleoIdentifier.from_json(callee)
                else:
                    raise NotImplementedError(f"Unsupported callee of call, got: {node}")
                _operands = [AleoOperand.from_json(p) for p in operands]
                _regaccs = [AleoRegisterAccess.from_json(p) for p in regaccs]
                return AleoCall(_callee, _operands, _regaccs)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, callee, operands, regaccs, **kwargs):
        super().__init__(**kwargs)
        self.callee = callee
        self.operands = operands
        self.regaccs = regaccs
    
    def __str__(self):
        _operands = " ".join([str(p) for p in self.operands])
        _regaccs = " ".join([str(p) for p in self.regaccs])
        return f"call {self.callee} {_operands} into {_regaccs};"

class AleoAsync(AleoInstruction):

    @staticmethod
    def from_json(node):
        match node:
            case ["xasync", "async", callee, *operands, "into", regacc, ";"]:
                _callee = AleoIdentifier.from_json(callee)
                _operands = [AleoOperand.from_json(p) for p in operands]
                _regacc = AleoRegisterAccess.from_json(regacc)
                return AleoAsync(_callee, _operands, _regacc)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, callee, operands, regacc, **kwargs):
        super().__init__(**kwargs)
        self.callee = callee
        self.operands = operands
        self.regacc = regacc

    def __str__(self):
        _operands = " ".join([str(p) for p in self.operands])
        return f"async {self.callee} {_operands} into {self.regacc};"
    
class AleoHash(AleoInstruction):

    @staticmethod
    def from_json(node):
        match node:
            case ["hash", ["hash1", *_]]:
                return AleoHash1.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, **kwargs):
        assert type(self) is not AleoInstruction, "This class cannot be directly instantiated"
        super().__init__(**kwargs)

    def __str__(self):
        raise TypeError()
    
class AleoHash1(AleoHash):

    @staticmethod
    def from_json(node):
        match node:
            case ["hash1", op, operand, "into", regacc, "as", type, ";"]:
                _op = AleoHash1Op.from_json(op)
                _operand = AleoOperand.from_json(operand)
                _regacc = AleoRegisterAccess.from_json(regacc)
                _type = None
                match type:
                    case ["arithmetic_type", *_]:
                        _type = AleoArithmeticType.from_json(type)
                    case ["address_type", *_]:
                        _type = AleoAddressType.from_json(type)
                    case ["signature_type", *_]:
                        _type = AleoSignatureType.from_json(type)
                    case ["array_type", *_]:
                        _type = AleoArrayType.from_json(type)
                    case ["identifier", *_]:
                        _type = AleoIdentifier.from_json(type)
                    case _:
                        raise NotImplementedError(f"Unsupported hash type, got: {node}")
                return AleoHash1(_op, _operand, _regacc, _type)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, op, operand, regacc, type, **kwargs):
        super().__init__(**kwargs)
        self.op = op
        self.operand = operand
        self.regacc = regacc
        self.type = type

    def __str__(self):
        return f"{self.op} {self.operand} into {self.regacc} as {self.type}"