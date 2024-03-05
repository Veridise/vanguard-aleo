from typing import Any, Union

from .misc import *

class AleoType(AleoNode):

    def __init__(self, visibility=AleoModifier.DEFAULT, **kwargs):
        assert type(self) is not AleoType, "This class cannot be directly instantiated"
        super().__init__(**kwargs)
        self.visibility = visibility
    
    def __str__(self):
        raise TypeError()

class AleoRegisterType(AleoType):

    # NOTE: this contains visibility parsing, except for the plaintext type subtype
    @staticmethod
    def from_json(node):
        match node:
            case ["register_type", ["plaintext_type", *_]]:
                return AleoPlaintextType.from_json(node[1])
            case ["register_type", ["identifier", *_], modifier]:
                _type = AleoIdentifier.from_json(node[1])
                _type.visibility = AleoModifier.from_json(modifier)
                return _type
            case ["register_type", ["locator", *_], modifier]:
                _type = AleoLocator.from_json(node[1])
                _type.visibility = AleoModifier.from_json(modifier)
                return _type
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, **kwargs):
        assert type(self) is not AleoRegisterType, "This class cannot be directly instantiated"
        super().__init__(**kwargs)

    def __str__(self):
        raise TypeError()

class AleoPlaintextType(AleoRegisterType):

    @staticmethod
    def from_json(node):
        match node:
            case ["plaintext_type", ["literal_type", *_]]:
                return AleoLiteralType.from_json(node[1])
            case ["plaintext_type", ["array_type", *_]]:
                return AleoArrayType.from_json(node[1])
            case ["plaintext_type", ["identifier", *_]]:
                return AleoIdentifier.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, **kwargs):
        assert type(self) is not AleoPlaintextType, "This class cannot be directly instantiated"
        super().__init__(**kwargs)

    def __str__(self):
        raise TypeError()

class AleoArrayType(AleoPlaintextType):

    @staticmethod
    def from_json(node):
        match node:
            case ["array_type", "[", b, ";", size, "]"]:
                from .literals import AleoUnsignedLiteral
                # b: base type
                btype = AleoPlaintextType.from_json(b)
                _size = AleoUnsignedLiteral.from_json(size).value
                dim = btype.dim + (_size,) if isinstance(btype, AleoArrayType) else (_size,)
                return AleoArrayType(btype, dim)
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, btype, dim, **kwargs):
        super().__init__(**kwargs)
        self.btype = btype
        self.dim = dim # directly stored in tuple

    def __str__(self):
        # as dim is directly stored as tuple, add u32 postfix
        s = f"[{self.btype};{self.dim[0]}u32]"
        if len(self.dim) > 1:
            for p in self.dim[1:]:
                s = f"[{s};{p}u32]"
        return s
            
class AleoLiteralType(AleoPlaintextType):

    @staticmethod
    def from_json(node):
        match node:
            case ["literal_type", ["arithmetic_type", *_]]:
                return AleoArithmeticType.from_json(node[1])
            case ["literal_type", ["boolean_type", *_]]:
                return AleoBooleanType.from_json(node[1])
            case ["literal_type", ["address_type", *_]]:
                return AleoAddressType.from_json(node[1])
            case ["literal_type", ["signature_type", *_]]:
                return AleoSignatureType.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, **kwargs):
        assert type(self) is not AleoLiteralType, "This class cannot be directly instantiated"
        super().__init__(**kwargs)

    def __str__(self):
        raise TypeError()

class AleoBooleanType(AleoLiteralType):

    @staticmethod
    def from_json(node):
        match node:
            case ["boolean_type", "boolean"]:
                return AleoBooleanType()
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def __str__(self):
        return "boolean"

class AleoSignatureType(AleoLiteralType):

    @staticmethod
    def from_json(node):
        match node:
            case ["signature_type", "signature"]:
                return AleoSignatureType()
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def __str__(self):
        return "sign1"
            
class AleoArithmeticType(AleoLiteralType):

    @staticmethod
    def from_json(node):
        match node:
            case ["arithmetic_type", ["integer_type", *_]]:
                return AleoIntegerType.from_json(node[1])
            case ["arithmetic_type", ["field_type", *_]]:
                return AleoFieldType.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
        
    def __init__(self, **kwargs):
        assert type(self) is not AleoArithmeticType, "This class cannot be directly instantiated"
        super().__init__(**kwargs)
    
    def __str__(self):
        raise TypeError()
            
class AleoIntegerType(AleoArithmeticType):

    @staticmethod
    def from_json(node):
        match node:
            case ["integer_type", ["unsigned_type", *_]]:
                return AleoUnsignedType.from_json(node[1])
            case ["integer_type", ["signed_type", *_]]:
                return AleoSignedType.from_json(node[1])
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, **kwargs):
        assert type(self) is not AleoIntegerType, "This class cannot be directly instantiated"
        super().__init__(**kwargs)
    
    def __str__(self):
        raise TypeError()

class AleoFieldType(AleoArithmeticType):

    @staticmethod
    def from_json(node):
        match node:
            case ["field_type", "field"]:
                return AleoFieldType()
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def __str__(self):
        return "field"
    
class AleoSignedType(AleoIntegerType):

    @staticmethod
    def from_json(node):
        match node:
            case ["signed_type", "i8"]:
                return AleoI8Type()
            case ["signed_type", "i16"]:
                return AleoI16Type()
            case ["signed_type", "i32"]:
                return AleoI32Type()
            case ["signed_type", "i64"]:
                return AleoI64Type()
            case ["signed_type", "i128"]:
                return AleoI128Type()
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
    
    def __init__(self, **kwargs):
        assert type(self) is not AleoUnsignedType, "This class cannot be directly instantiated"
        super().__init__(**kwargs)
    
    def __str__(self):
        raise TypeError()

class AleoI8Type(AleoSignatureType):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    def __str__(self):
        return "i8"
    
class AleoI16Type(AleoSignatureType):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    def __str__(self):
        return "i16"
    
class AleoI32Type(AleoSignatureType):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    def __str__(self):
        return "i32"

class AleoI64Type(AleoSignatureType):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    def __str__(self):
        return "i64"
    
class AleoI128Type(AleoSignatureType):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    def __str__(self):
        return "i128"
            
class AleoUnsignedType(AleoIntegerType):

    @staticmethod
    def from_json(node):
        match node:
            case ["unsigned_type", "u8"]:
                return AleoU8Type()
            case ["unsigned_type", "u16"]:
                return AleoU16Type()
            case ["unsigned_type", "u32"]:
                return AleoU32Type()
            case ["unsigned_type", "u64"]:
                return AleoU64Type()
            case ["unsigned_type", "u128"]:
                return AleoU128Type()
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, **kwargs):
        assert type(self) is not AleoUnsignedType, "This class cannot be directly instantiated"
        super().__init__(**kwargs)
    
    def __str__(self):
        raise TypeError()
            
class AleoU8Type(AleoUnsignedType):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    def __str__(self):
        return "u8"
    
class AleoU16Type(AleoUnsignedType):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    def __str__(self):
        return "u16"

class AleoU32Type(AleoUnsignedType):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    def __str__(self):
        return "u32"
    
class AleoU64Type(AleoUnsignedType):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    def __str__(self):
        return "u64"
    
class AleoU128Type(AleoUnsignedType):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    def __str__(self):
        return "u128"

class AleoAddressType(AleoLiteralType):

    @staticmethod
    def from_json(node):
        match node:
            case ["address_type", "address"]:
                return AleoAddressType()
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, **kwargs):
        super().__init__(**kwargs)
    
    def __str__(self):
        return "aleo1"

class AleoValueType(AleoType):

    @staticmethod
    def from_json(node):
        # NOTE: this contains visibility parsing
        match node:
            case ["value_type", ["plaintext_type", *_], visibility]:
                _type = AleoPlaintextType.from_json(node[1])
                _visibility = AleoModifier.from_json(visibility)
                _type.visibility = _visibility
                return _type
            case ["value_type", ["locator", *_], modifier]:
                _type = AleoLocator.from_json(node[1])
                _modifier = AleoModifier.from_json(modifier)
                _type.visibility = _modifier
                return _type
            case ["value_type", ["identifier", *_], modifier]:
                _type = AleoIdentifier.from_json(node[1])
                _modifier = AleoModifier.from_json(modifier)
                _type.visibility = _modifier
                return _type
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
        
    def __init__(self, **kwargs):
        assert type(self) is not AleoValueType, "This class cannot be directly instantiated"
        super().__init__(**kwargs)
    
    def __str__(self):
        raise TypeError()

class AleoFinalizeType(AleoType):

    @staticmethod
    def from_json(node):
        # NOTE: this contains visibility parsing
        match node:
            case ["finalize_type", ["plaintext_type", *_], visibility]:
                _type = AleoPlaintextType.from_json(node[1])
                _visibility = AleoModifier.from_json(visibility)
                _type.visibility = _visibility
                return _type
            case ["finalize_type", ["locator", *_], modifier]:
                _type = AleoLocator.from_json(node[1])
                _visibility = AleoModifier.from_json(modifier)
                _type.visibility = modifier
                return _type
            case _:
                raise NotImplementedError(f"Unsupported json component, got: {node}")
            
    def __init__(self, **kwargs):
        assert type(self) is not AleoFinalizeType, "This class cannot be directly instantiated"
        super().__init__(**kwargs)

    def __str__(self):
        raise TypeError()