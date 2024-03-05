from typing import Any, Union

from .misc import *

class AleoLiteral(AleoOperand):

    @staticmethod
    def from_json(node):
        match node:
            case ["literal", ["boolean_literal", *_]]:
                return AleoBooleanLiteral.from_json(node[1])
            case ["literal", ["arithmetic_literal", *_]]:
                return AleoArithmeticLiteral.from_json(node[1])
            case ["literal", ["address_literal", *_]]:
                return AleoAddressLiteral.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, value, _type, **kwargs):
        assert type(self) is not AleoLiteral, "This class cannot be directly instantiated"
        super().__init__(**kwargs)
        self.value = value
        self.type = _type

    def __str__(self):
        raise TypeError

class AleoAddressLiteral(AleoLiteral):

    @staticmethod
    def from_json(node):
        match node:
            case ["address_literal", addr]:
                from .types import AleoAddressType
                assert addr.startswith("aleo1"), f"Address prefixes mismatch, expected: aleo1, got: {addr}"
                return AleoAddressLiteral(addr[5:], AleoAddressType())
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)

    def __str__(self):
        return f"{self.type}{self.value}"

class AleoArithmeticLiteral(AleoLiteral):

    @staticmethod
    def from_json(node):
        match node:
            case ["arithmetic_literal", ["integer_literal", *_]]:
                return AleoIntegerLiteral.from_json(node[1])
            case ["arithmetic_literal", ["field_literal", *_]]:
                return AleoFieldLiteral.from_json(node[1])
            case ["arithmetic_literal", ["group_literal", *_]]:
                return AleoGroupLiteral.from_json(node[1])
            case ["arithmetic_literal", ["scalar_literal", *_]]:
                return AleoScalarLiteral.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, *args, **kwargs):
        assert type(self) is not AleoArithmeticLiteral, "This class cannot be directly instantiated"
        super().__init__(*args, **kwargs)

    def __str__(self):
        raise TypeError()

class AleoBooleanLiteral(AleoLiteral):

    @staticmethod
    def from_json(node):
        match node:
            case ["boolean_literal", b]:
                from .types import AleoBooleanType
                if b == "true":
                    return AleoBooleanLiteral(True, AleoBooleanType())
                elif b == "false":
                    return AleoBooleanLiteral(False, AleoBooleanType())
                else:
                    raise NotImplementedError(f"Unsupported boolean lteral, got: {node}")
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)

    def __str__(self):
        return "true" if self.value else "false"

class AleoIntegerLiteral(AleoArithmeticLiteral):

    @staticmethod
    def from_json(node):
        match node:
            case ["integer_literal", ["unsigned_literal", *_]]:
                return AleoUnsignedLiteral.from_json(node[1])
            case ["integer_literal", ["signed_literal", *_]]:
                return AleoSignedLiteral.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, *args, **kwargs):
        assert type(self) is not AleoIntegerLiteral, "This class cannot be directly instantiated"
        super().__init__(*args, **kwargs)

    def __str__(self):
        raise TypeError()

class AleoFieldLiteral(AleoArithmeticLiteral):

    @staticmethod
    def from_json(node):
        match node:
            case ["field_literal", *digits, type]:
                from .types import AleoFieldType
                v = int("".join(digits))
                _type =AleoFieldType.from_json(type)
                return AleoFieldLiteral(v, _type)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)     

    def __str__(self):
        return f"{self.value}{self.type}"
    
class AleoGroupLiteral(AleoArithmeticLiteral):

    @staticmethod
    def from_json(node):
        match node:
            case ["group_literal", *digits, type]:
                from .types import AleoGroupType
                v = int("".join(digits))
                _type =AleoGroupType.from_json(type)
                return AleoGroupLiteral(v, _type)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)     

    def __str__(self):
        return f"{self.value}{self.type}"
    
class AleoScalarLiteral(AleoArithmeticLiteral):

    @staticmethod
    def from_json(node):
        match node:
            case ["scalar_literal", *digits, type]:
                from .types import AleoScalarType
                v = int("".join(digits))
                _type =AleoScalarType.from_json(type)
                return AleoScalarLiteral(v, _type)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)     

    def __str__(self):
        return f"{self.value}{self.type}"
    
class AleoSignedLiteral(AleoIntegerLiteral):

    @staticmethod
    def from_json(node):
        match node:
            case ["signed_literal", *digits, type]:
                from .types import AleoSignedType
                v = int("".join(digits))
                _type = AleoSignedType.from_json(type)
                return AleoSignedLiteral(v, _type)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)     

    def __str__(self):
        return f"{self.value}{self.type}"

class AleoUnsignedLiteral(AleoIntegerLiteral):

    @staticmethod
    def from_json(node):
        match node:
            case ["unsigned_literal", *digits, type]:
                from .types import AleoUnsignedType
                v = int("".join(digits))
                _type = AleoUnsignedType.from_json(type)
                return AleoUnsignedLiteral(v, _type)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)

    def __str__(self):
        return f"{self.value}{self.type}"
