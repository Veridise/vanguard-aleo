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
            case ["command", ["contains", *_]]:
                return AleoContains.from_json(node[1])
            case ["command", ["get", *_]]:
                return AleoGet.from_json(node[1])
            case ["command", ["get_or_use", *_]]:
                return AleoGetOrUse.from_json(node[1])
            case ["command", ["remove", *_]]:
                return AleoRemove.from_json(node[1])
            case ["command", ["xawait", *_]]:
                return AleoAwait.from_json(node[1])
            case ["command", ["branch", *_]]:
                return AleoBranch.from_json(node[1])
            case ["command", ["position", *_]]:
                return AleoPosition.from_json(node[1])
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
            case ["random", ["random_op", *_], *operands, "into", regacc, "as", type, ";"]:
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
    
class AleoContains(AleoCommand):

    @staticmethod
    def from_json(node):
        match node:
            case ["contains", "contains", id, "[", operand, "]", "into", regacc, ";"]:
                  _id = AleoIdentifier.from_json(id)
                  _operand = AleoOperand.from_json(operand)
                  _regacc = AleoRegisterAccess.from_json(regacc)
                  return AleoContains(_id, _operand, _regacc)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")

    def __init__(self, id, operand, regacc, **kwargs):
        super().__init__(**kwargs)
        self.id = id
        self.operand = operand
        self.regacc = regacc

    def __str__(self):
        return f"contains {self.id}[{self.operand}] into {self.regacc};"
    
class AleoGet(AleoCommand):
    
    @staticmethod
    def from_json(node):
        match node:
            case ["get", "get", id, "[", operand, "]", "into", regacc, ";"]:
                _id = AleoIdentifier.from_json(id)
                _operand = AleoOperand.from_json(operand)
                _regacc = AleoRegisterAccess.from_json(regacc)
                return AleoGet(_id, _operand, _regacc)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, id, operand, regacc, **kwargs):
        super().__init__(**kwargs)
        self.id = id
        self.operand = operand
        self.regacc = regacc

    def __str__(self):
        return f"get {self.id}[{self.operand}] into {self.regacc};"
    
class AleoGetOrUse(AleoCommand):

    @staticmethod
    def from_json(node):
        match node:
            case ["get_or_use", ["get_or_use_op", *_], id, "[", operand, "]", default, "into", regacc, ";"]:
                _id = AleoIdentifier.from_json(id)
                _operand = AleoOperand.from_json(operand)
                _default = AleoOperand.from_json(default)
                _regacc = AleoRegisterAccess.from_json(regacc)
                return AleoGetOrUse(_id, _operand, _default, _regacc)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, id, operand, default, regacc):
        self.id = id
        self.operand = operand
        self.default = default
        self.regacc = regacc

    def __str__(self):
        return f"get.or_use {self.id}[{self.operand}] {self.default} into {self.regacc};"
    
class AleoRemove(AleoCommand):

    @staticmethod
    def from_json(node):
        match node:
            case ["remove", "remove", id, "[", operand, "]", ";"]:
                _id = AleoIdentifier.from_json(id)
                _operand = AleoOperand.from_json(operand)
                return AleoRemove(_id, _operand)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, id, operand, **kwargs):
        super().__init__(**kwargs)
        self.id = id
        self.operand = operand

    def __str__(self):
        return f"remove {self.id}[{self.operand}];"
    
class AleoAwait(AleoCommand):

    @staticmethod
    def from_json(node):
        match node:
            case ["xawait", "await", regacc, ";"]:
                _regacc = AleoRegisterAccess.from_json(regacc)
                return AleoAwait(_regacc)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, regacc, **kwargs):
        super().__init__(**kwargs)
        self.regacc = regacc

    def __str__(self):
        return f"await {self.regacc};"
    
class AleoBranch(AleoCommand):

    @staticmethod
    def from_json(node):
        match node:
            case ["branch", op, *operands, "to", label, ";"]:
                assert len(operands) == 2, f"Unsupported number of operands, expected: 2, got: {len(operands)}"
                _op = AleoBranchOp.from_json(op)
                _operands = [ AleoOperand.from_json(p) for p in operands ]
                _label = AleoLabel.from_json(label)
                return AleoBranch(_op, _operands, _label)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, op, operands, label, **kwargs):
        super().__init__(**kwargs)
        self.op = op
        self.operands = operands
        self.label = label

    def __str__(self):
        _operands = " ".join([str(p) for p in self.operands])
        return f"{self.op} {_operands} to {self.label};"
    
class AleoPosition(AleoCommand):

    @staticmethod
    def from_json(node):
        match node:
            case ["position", "position", label, ";"]:
                _label = AleoLabel.from_json(label)
                return AleoPosition(_label)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, label, **kwargs):
        super().__init__(**kwargs)
        self.label = label

    def __str__(self):
        return f"position {self.label};"

class AleoInstruction(AleoCommand):

    @staticmethod
    def from_json(inst):
        match inst:
            case ["instruction", ["cast", *_]]:
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
            case ["instruction", ["sign_verify", *_]]:
                return AleoSignVerify.from_json(inst[1])
            case ["instruction", ["commit", *_e]]:
                return AleoCommit.from_json(inst[1])
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
                match op:
                    case ["cast_op", "cast"]:
                        _lossy = False
                    case ["cast_op", "cast", ".", "lossy"]:
                        _lossy = True
                    case _:
                        raise NotImplementedError(f"Unsupported cast operator, got: {op}")
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
        super().__init__(**kwargs)
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
                assert len(operands) == 2, f"Unsupported number of operands, expected: 2, got: {len(operands)}"
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
    
class AleoSignVerify(AleoInstruction):

    @staticmethod
    def from_json(node):
        match node:
            case ["sign_verify", ["sign_verify_op", *_], *operands, "into", regacc, ";"]:
                assert len(operands) == 3, f"Unsupported number of operands, expected: 3, got: {len(operands)}"
                _operands = [ AleoOperand.from_json(p) for p in operands ]
                _regacc = AleoRegisterAccess.from_json(regacc)
                return AleoSignVerify(_operands, _regacc)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, operands, regacc, **kwargs):
        super().__init__(**kwargs)
        self.operands = operands
        self.regacc = regacc
    
    def __str__(self):
        _operands = " ".join([f"{p}" for p in self.operands])
        return f"sign.verify {_operands} into {self.regacc};"

class AleoCommit(AleoInstruction):

    @staticmethod
    def from_json(node):
        match node:
            case ["commit", op, *operands, "into", regacc, "as", type, ";"]:
                _op = AleoCommitOp.from_json(op)
                _operands = [ AleoOperand.from_json(p) for p in operands ]
                _regacc = AleoRegisterAccess.from_json(regacc)
                # special parsing for types, as they don't inherit the same super class
                _type = None
                match type:
                    case ["address_type", *_]:
                        _type = AleoAddressType.from_json(type)
                    case ["field_type", *_]:
                        _type = AleoFieldType.from_json(type)
                    case ["group_type", *_]:
                        _type = AleoGroupType.from_json(type)
                    case _:
                        raise NotImplementedError(f"Unsupported type for commit, got: {type}")
                return AleoCommit(_op, _operands, _regacc, _type)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, op, operands, regacc, type, **kwargs):
        super().__init__(**kwargs)
        self.op = op
        self.operands = operands
        self.regacc = regacc
        self.type = type

    def __str__(self):
        _operands = " ".join([f"{p}" for p in self.operands])
        return f"{self.op} {_operands} into {self.regacc} as {self.type};"