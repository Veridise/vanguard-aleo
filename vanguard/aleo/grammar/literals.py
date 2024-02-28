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
            case ["address_literal", "aleo1", *chars]:
                from .types import AleoAddressType
                _chars = []
                for p in chars:
                    assert p[0] == "address_or_signature_char", f"Unsupported json component of address literal, got: {node}"
                    _chars.append(p[1])
                _address = "".join(_chars)
                return AleoAddressLiteral(_address, AleoAddressType())
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
            case ["field_literal", sign, *digits, type]:
                from .types import AleoFieldType
                assert sign is None or sign == "-", f"Unsupported sign of literal, got: {sign}"
                ls = [] if sign is None else ["-"]
                for p in digits:
                    assert p[0] == "digit", f"Unsupported digit of literal, got: {p}"
                    ls.append(p[1])
                v = int("".join(ls))
                _type = AleoFieldType.from_json(type)
                return AleoFieldLiteral(v, _type)
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
            case ["field_literal", sign, *digits, type]:
                from .types import AleoSignedType
                assert sign is None or sign == "-", f"Unsupported sign of literal, got: {sign}"
                ls = [] if sign is None else ["-"]
                for p in digits:
                    assert p[0] == "digit", f"Unsupported digit of literal, got: {p}"
                    ls.append(p[1])
                v = int("".join(ls))
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
            case ["unsigned_literal", sign, *vs, type]:
                from .types import AleoUnsignedType
                # vs: digits
                assert sign is None, f"Unsupported sign of literal, expected: None, got: {sign}"
                ls = []
                for p in vs:
                    assert p[0] == "digit", f"Unsupported digit of literal, got: {p}"
                    ls.append(p[1])
                v = int("".join(ls))
                _type = AleoUnsignedType.from_json(type)
                return AleoUnsignedLiteral(v, _type)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)

    def __str__(self):
        return f"{self.value}{self.type}"

class AleoU32Literal:
    """Special literal only for representing array, but this will instantiated to unsigned literal"""

    @staticmethod
    def from_json(node):
        match node:
            case ["u32_literal", sign, *vs, "u32"]:
                from .types import AleoU32Type
                # vs: digits
                assert sign is None or sign == "-", f"Unsupported sign of literal, got: {sign}"
                ls = [] if sign is None else ["-"]
                for p in vs:
                    assert p[0] == "digit", f"Unsupported digit of literal, got: {p}"
                    ls.append(p[1])
                v = int("".join(ls))
                return AleoUnsignedLiteral(v, AleoU32Type())
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, **kwargs):
        assert type(self) is not AleoU32Literal, "This terminal can't be directly initialized"
        super().__init__(**kwargs)

    def __str__(self):
        raise TypeError()