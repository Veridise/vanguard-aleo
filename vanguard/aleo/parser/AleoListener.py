# Generated from ./Aleo.g4 by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .AleoParser import AleoParser
else:
    from AleoParser import AleoParser

# This class defines a complete listener for a parse tree produced by AleoParser.
class AleoListener(ParseTreeListener):

    # Enter a parse tree produced by AleoParser#start.
    def enterStart(self, ctx:AleoParser.StartContext):
        pass

    # Exit a parse tree produced by AleoParser#start.
    def exitStart(self, ctx:AleoParser.StartContext):
        pass


    # Enter a parse tree produced by AleoParser#program.
    def enterProgram(self, ctx:AleoParser.ProgramContext):
        pass

    # Exit a parse tree produced by AleoParser#program.
    def exitProgram(self, ctx:AleoParser.ProgramContext):
        pass


    # Enter a parse tree produced by AleoParser#ximport.
    def enterXimport(self, ctx:AleoParser.XimportContext):
        pass

    # Exit a parse tree produced by AleoParser#ximport.
    def exitXimport(self, ctx:AleoParser.XimportContext):
        pass


    # Enter a parse tree produced by AleoParser#mapping.
    def enterMapping(self, ctx:AleoParser.MappingContext):
        pass

    # Exit a parse tree produced by AleoParser#mapping.
    def exitMapping(self, ctx:AleoParser.MappingContext):
        pass


    # Enter a parse tree produced by AleoParser#mapping_key.
    def enterMapping_key(self, ctx:AleoParser.Mapping_keyContext):
        pass

    # Exit a parse tree produced by AleoParser#mapping_key.
    def exitMapping_key(self, ctx:AleoParser.Mapping_keyContext):
        pass


    # Enter a parse tree produced by AleoParser#mapping_value.
    def enterMapping_value(self, ctx:AleoParser.Mapping_valueContext):
        pass

    # Exit a parse tree produced by AleoParser#mapping_value.
    def exitMapping_value(self, ctx:AleoParser.Mapping_valueContext):
        pass


    # Enter a parse tree produced by AleoParser#struct.
    def enterStruct(self, ctx:AleoParser.StructContext):
        pass

    # Exit a parse tree produced by AleoParser#struct.
    def exitStruct(self, ctx:AleoParser.StructContext):
        pass


    # Enter a parse tree produced by AleoParser#record.
    def enterRecord(self, ctx:AleoParser.RecordContext):
        pass

    # Exit a parse tree produced by AleoParser#record.
    def exitRecord(self, ctx:AleoParser.RecordContext):
        pass


    # Enter a parse tree produced by AleoParser#closure.
    def enterClosure(self, ctx:AleoParser.ClosureContext):
        pass

    # Exit a parse tree produced by AleoParser#closure.
    def exitClosure(self, ctx:AleoParser.ClosureContext):
        pass


    # Enter a parse tree produced by AleoParser#closure_input.
    def enterClosure_input(self, ctx:AleoParser.Closure_inputContext):
        pass

    # Exit a parse tree produced by AleoParser#closure_input.
    def exitClosure_input(self, ctx:AleoParser.Closure_inputContext):
        pass


    # Enter a parse tree produced by AleoParser#closure_output.
    def enterClosure_output(self, ctx:AleoParser.Closure_outputContext):
        pass

    # Exit a parse tree produced by AleoParser#closure_output.
    def exitClosure_output(self, ctx:AleoParser.Closure_outputContext):
        pass


    # Enter a parse tree produced by AleoParser#function.
    def enterFunction(self, ctx:AleoParser.FunctionContext):
        pass

    # Exit a parse tree produced by AleoParser#function.
    def exitFunction(self, ctx:AleoParser.FunctionContext):
        pass


    # Enter a parse tree produced by AleoParser#function_input.
    def enterFunction_input(self, ctx:AleoParser.Function_inputContext):
        pass

    # Exit a parse tree produced by AleoParser#function_input.
    def exitFunction_input(self, ctx:AleoParser.Function_inputContext):
        pass


    # Enter a parse tree produced by AleoParser#function_output.
    def enterFunction_output(self, ctx:AleoParser.Function_outputContext):
        pass

    # Exit a parse tree produced by AleoParser#function_output.
    def exitFunction_output(self, ctx:AleoParser.Function_outputContext):
        pass


    # Enter a parse tree produced by AleoParser#finalize.
    def enterFinalize(self, ctx:AleoParser.FinalizeContext):
        pass

    # Exit a parse tree produced by AleoParser#finalize.
    def exitFinalize(self, ctx:AleoParser.FinalizeContext):
        pass


    # Enter a parse tree produced by AleoParser#finalize_input.
    def enterFinalize_input(self, ctx:AleoParser.Finalize_inputContext):
        pass

    # Exit a parse tree produced by AleoParser#finalize_input.
    def exitFinalize_input(self, ctx:AleoParser.Finalize_inputContext):
        pass


    # Enter a parse tree produced by AleoParser#command.
    def enterCommand(self, ctx:AleoParser.CommandContext):
        pass

    # Exit a parse tree produced by AleoParser#command.
    def exitCommand(self, ctx:AleoParser.CommandContext):
        pass


    # Enter a parse tree produced by AleoParser#contains.
    def enterContains(self, ctx:AleoParser.ContainsContext):
        pass

    # Exit a parse tree produced by AleoParser#contains.
    def exitContains(self, ctx:AleoParser.ContainsContext):
        pass


    # Enter a parse tree produced by AleoParser#get.
    def enterGet(self, ctx:AleoParser.GetContext):
        pass

    # Exit a parse tree produced by AleoParser#get.
    def exitGet(self, ctx:AleoParser.GetContext):
        pass


    # Enter a parse tree produced by AleoParser#get_or_use.
    def enterGet_or_use(self, ctx:AleoParser.Get_or_useContext):
        pass

    # Exit a parse tree produced by AleoParser#get_or_use.
    def exitGet_or_use(self, ctx:AleoParser.Get_or_useContext):
        pass


    # Enter a parse tree produced by AleoParser#set.
    def enterSet(self, ctx:AleoParser.SetContext):
        pass

    # Exit a parse tree produced by AleoParser#set.
    def exitSet(self, ctx:AleoParser.SetContext):
        pass


    # Enter a parse tree produced by AleoParser#remove.
    def enterRemove(self, ctx:AleoParser.RemoveContext):
        pass

    # Exit a parse tree produced by AleoParser#remove.
    def exitRemove(self, ctx:AleoParser.RemoveContext):
        pass


    # Enter a parse tree produced by AleoParser#random.
    def enterRandom(self, ctx:AleoParser.RandomContext):
        pass

    # Exit a parse tree produced by AleoParser#random.
    def exitRandom(self, ctx:AleoParser.RandomContext):
        pass


    # Enter a parse tree produced by AleoParser#position.
    def enterPosition(self, ctx:AleoParser.PositionContext):
        pass

    # Exit a parse tree produced by AleoParser#position.
    def exitPosition(self, ctx:AleoParser.PositionContext):
        pass


    # Enter a parse tree produced by AleoParser#branch.
    def enterBranch(self, ctx:AleoParser.BranchContext):
        pass

    # Exit a parse tree produced by AleoParser#branch.
    def exitBranch(self, ctx:AleoParser.BranchContext):
        pass


    # Enter a parse tree produced by AleoParser#xawait.
    def enterXawait(self, ctx:AleoParser.XawaitContext):
        pass

    # Exit a parse tree produced by AleoParser#xawait.
    def exitXawait(self, ctx:AleoParser.XawaitContext):
        pass


    # Enter a parse tree produced by AleoParser#instruction.
    def enterInstruction(self, ctx:AleoParser.InstructionContext):
        pass

    # Exit a parse tree produced by AleoParser#instruction.
    def exitInstruction(self, ctx:AleoParser.InstructionContext):
        pass


    # Enter a parse tree produced by AleoParser#unary.
    def enterUnary(self, ctx:AleoParser.UnaryContext):
        pass

    # Exit a parse tree produced by AleoParser#unary.
    def exitUnary(self, ctx:AleoParser.UnaryContext):
        pass


    # Enter a parse tree produced by AleoParser#binary.
    def enterBinary(self, ctx:AleoParser.BinaryContext):
        pass

    # Exit a parse tree produced by AleoParser#binary.
    def exitBinary(self, ctx:AleoParser.BinaryContext):
        pass


    # Enter a parse tree produced by AleoParser#ternary.
    def enterTernary(self, ctx:AleoParser.TernaryContext):
        pass

    # Exit a parse tree produced by AleoParser#ternary.
    def exitTernary(self, ctx:AleoParser.TernaryContext):
        pass


    # Enter a parse tree produced by AleoParser#is.
    def enterIs(self, ctx:AleoParser.IsContext):
        pass

    # Exit a parse tree produced by AleoParser#is.
    def exitIs(self, ctx:AleoParser.IsContext):
        pass


    # Enter a parse tree produced by AleoParser#assert.
    def enterAssert(self, ctx:AleoParser.AssertContext):
        pass

    # Exit a parse tree produced by AleoParser#assert.
    def exitAssert(self, ctx:AleoParser.AssertContext):
        pass


    # Enter a parse tree produced by AleoParser#commit.
    def enterCommit(self, ctx:AleoParser.CommitContext):
        pass

    # Exit a parse tree produced by AleoParser#commit.
    def exitCommit(self, ctx:AleoParser.CommitContext):
        pass


    # Enter a parse tree produced by AleoParser#hash1.
    def enterHash1(self, ctx:AleoParser.Hash1Context):
        pass

    # Exit a parse tree produced by AleoParser#hash1.
    def exitHash1(self, ctx:AleoParser.Hash1Context):
        pass


    # Enter a parse tree produced by AleoParser#hash2.
    def enterHash2(self, ctx:AleoParser.Hash2Context):
        pass

    # Exit a parse tree produced by AleoParser#hash2.
    def exitHash2(self, ctx:AleoParser.Hash2Context):
        pass


    # Enter a parse tree produced by AleoParser#hash.
    def enterHash(self, ctx:AleoParser.HashContext):
        pass

    # Exit a parse tree produced by AleoParser#hash.
    def exitHash(self, ctx:AleoParser.HashContext):
        pass


    # Enter a parse tree produced by AleoParser#signverify.
    def enterSignverify(self, ctx:AleoParser.SignverifyContext):
        pass

    # Exit a parse tree produced by AleoParser#signverify.
    def exitSignverify(self, ctx:AleoParser.SignverifyContext):
        pass


    # Enter a parse tree produced by AleoParser#cast.
    def enterCast(self, ctx:AleoParser.CastContext):
        pass

    # Exit a parse tree produced by AleoParser#cast.
    def exitCast(self, ctx:AleoParser.CastContext):
        pass


    # Enter a parse tree produced by AleoParser#call.
    def enterCall(self, ctx:AleoParser.CallContext):
        pass

    # Exit a parse tree produced by AleoParser#call.
    def exitCall(self, ctx:AleoParser.CallContext):
        pass


    # Enter a parse tree produced by AleoParser#xasync.
    def enterXasync(self, ctx:AleoParser.XasyncContext):
        pass

    # Exit a parse tree produced by AleoParser#xasync.
    def exitXasync(self, ctx:AleoParser.XasyncContext):
        pass


    # Enter a parse tree produced by AleoParser#literal.
    def enterLiteral(self, ctx:AleoParser.LiteralContext):
        pass

    # Exit a parse tree produced by AleoParser#literal.
    def exitLiteral(self, ctx:AleoParser.LiteralContext):
        pass


    # Enter a parse tree produced by AleoParser#signed_literal.
    def enterSigned_literal(self, ctx:AleoParser.Signed_literalContext):
        pass

    # Exit a parse tree produced by AleoParser#signed_literal.
    def exitSigned_literal(self, ctx:AleoParser.Signed_literalContext):
        pass


    # Enter a parse tree produced by AleoParser#unsigned_literal.
    def enterUnsigned_literal(self, ctx:AleoParser.Unsigned_literalContext):
        pass

    # Exit a parse tree produced by AleoParser#unsigned_literal.
    def exitUnsigned_literal(self, ctx:AleoParser.Unsigned_literalContext):
        pass


    # Enter a parse tree produced by AleoParser#integer_literal.
    def enterInteger_literal(self, ctx:AleoParser.Integer_literalContext):
        pass

    # Exit a parse tree produced by AleoParser#integer_literal.
    def exitInteger_literal(self, ctx:AleoParser.Integer_literalContext):
        pass


    # Enter a parse tree produced by AleoParser#field_literal.
    def enterField_literal(self, ctx:AleoParser.Field_literalContext):
        pass

    # Exit a parse tree produced by AleoParser#field_literal.
    def exitField_literal(self, ctx:AleoParser.Field_literalContext):
        pass


    # Enter a parse tree produced by AleoParser#group_literal.
    def enterGroup_literal(self, ctx:AleoParser.Group_literalContext):
        pass

    # Exit a parse tree produced by AleoParser#group_literal.
    def exitGroup_literal(self, ctx:AleoParser.Group_literalContext):
        pass


    # Enter a parse tree produced by AleoParser#scalar_literal.
    def enterScalar_literal(self, ctx:AleoParser.Scalar_literalContext):
        pass

    # Exit a parse tree produced by AleoParser#scalar_literal.
    def exitScalar_literal(self, ctx:AleoParser.Scalar_literalContext):
        pass


    # Enter a parse tree produced by AleoParser#arithmetic_literal.
    def enterArithmetic_literal(self, ctx:AleoParser.Arithmetic_literalContext):
        pass

    # Exit a parse tree produced by AleoParser#arithmetic_literal.
    def exitArithmetic_literal(self, ctx:AleoParser.Arithmetic_literalContext):
        pass


    # Enter a parse tree produced by AleoParser#u32_literal.
    def enterU32_literal(self, ctx:AleoParser.U32_literalContext):
        pass

    # Exit a parse tree produced by AleoParser#u32_literal.
    def exitU32_literal(self, ctx:AleoParser.U32_literalContext):
        pass


    # Enter a parse tree produced by AleoParser#address_literal.
    def enterAddress_literal(self, ctx:AleoParser.Address_literalContext):
        pass

    # Exit a parse tree produced by AleoParser#address_literal.
    def exitAddress_literal(self, ctx:AleoParser.Address_literalContext):
        pass


    # Enter a parse tree produced by AleoParser#signature_literal.
    def enterSignature_literal(self, ctx:AleoParser.Signature_literalContext):
        pass

    # Exit a parse tree produced by AleoParser#signature_literal.
    def exitSignature_literal(self, ctx:AleoParser.Signature_literalContext):
        pass


    # Enter a parse tree produced by AleoParser#boolean_literal.
    def enterBoolean_literal(self, ctx:AleoParser.Boolean_literalContext):
        pass

    # Exit a parse tree produced by AleoParser#boolean_literal.
    def exitBoolean_literal(self, ctx:AleoParser.Boolean_literalContext):
        pass


    # Enter a parse tree produced by AleoParser#unsigned_type.
    def enterUnsigned_type(self, ctx:AleoParser.Unsigned_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#unsigned_type.
    def exitUnsigned_type(self, ctx:AleoParser.Unsigned_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#signed_type.
    def enterSigned_type(self, ctx:AleoParser.Signed_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#signed_type.
    def exitSigned_type(self, ctx:AleoParser.Signed_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#integer_type.
    def enterInteger_type(self, ctx:AleoParser.Integer_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#integer_type.
    def exitInteger_type(self, ctx:AleoParser.Integer_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#field_type.
    def enterField_type(self, ctx:AleoParser.Field_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#field_type.
    def exitField_type(self, ctx:AleoParser.Field_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#group_type.
    def enterGroup_type(self, ctx:AleoParser.Group_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#group_type.
    def exitGroup_type(self, ctx:AleoParser.Group_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#scalar_type.
    def enterScalar_type(self, ctx:AleoParser.Scalar_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#scalar_type.
    def exitScalar_type(self, ctx:AleoParser.Scalar_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#arithmetic_type.
    def enterArithmetic_type(self, ctx:AleoParser.Arithmetic_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#arithmetic_type.
    def exitArithmetic_type(self, ctx:AleoParser.Arithmetic_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#address_type.
    def enterAddress_type(self, ctx:AleoParser.Address_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#address_type.
    def exitAddress_type(self, ctx:AleoParser.Address_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#boolean_type.
    def enterBoolean_type(self, ctx:AleoParser.Boolean_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#boolean_type.
    def exitBoolean_type(self, ctx:AleoParser.Boolean_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#signature_type.
    def enterSignature_type(self, ctx:AleoParser.Signature_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#signature_type.
    def exitSignature_type(self, ctx:AleoParser.Signature_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#literal_type.
    def enterLiteral_type(self, ctx:AleoParser.Literal_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#literal_type.
    def exitLiteral_type(self, ctx:AleoParser.Literal_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#array_type.
    def enterArray_type(self, ctx:AleoParser.Array_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#array_type.
    def exitArray_type(self, ctx:AleoParser.Array_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#plaintext_type.
    def enterPlaintext_type(self, ctx:AleoParser.Plaintext_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#plaintext_type.
    def exitPlaintext_type(self, ctx:AleoParser.Plaintext_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#value_type.
    def enterValue_type(self, ctx:AleoParser.Value_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#value_type.
    def exitValue_type(self, ctx:AleoParser.Value_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#mapping_type.
    def enterMapping_type(self, ctx:AleoParser.Mapping_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#mapping_type.
    def exitMapping_type(self, ctx:AleoParser.Mapping_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#finalize_type.
    def enterFinalize_type(self, ctx:AleoParser.Finalize_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#finalize_type.
    def exitFinalize_type(self, ctx:AleoParser.Finalize_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#entry_type.
    def enterEntry_type(self, ctx:AleoParser.Entry_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#entry_type.
    def exitEntry_type(self, ctx:AleoParser.Entry_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#register_type.
    def enterRegister_type(self, ctx:AleoParser.Register_typeContext):
        pass

    # Exit a parse tree produced by AleoParser#register_type.
    def exitRegister_type(self, ctx:AleoParser.Register_typeContext):
        pass


    # Enter a parse tree produced by AleoParser#program_id.
    def enterProgram_id(self, ctx:AleoParser.Program_idContext):
        pass

    # Exit a parse tree produced by AleoParser#program_id.
    def exitProgram_id(self, ctx:AleoParser.Program_idContext):
        pass


    # Enter a parse tree produced by AleoParser#program_name.
    def enterProgram_name(self, ctx:AleoParser.Program_nameContext):
        pass

    # Exit a parse tree produced by AleoParser#program_name.
    def exitProgram_name(self, ctx:AleoParser.Program_nameContext):
        pass


    # Enter a parse tree produced by AleoParser#program_domain.
    def enterProgram_domain(self, ctx:AleoParser.Program_domainContext):
        pass

    # Exit a parse tree produced by AleoParser#program_domain.
    def exitProgram_domain(self, ctx:AleoParser.Program_domainContext):
        pass


    # Enter a parse tree produced by AleoParser#register.
    def enterRegister(self, ctx:AleoParser.RegisterContext):
        pass

    # Exit a parse tree produced by AleoParser#register.
    def exitRegister(self, ctx:AleoParser.RegisterContext):
        pass


    # Enter a parse tree produced by AleoParser#register_access.
    def enterRegister_access(self, ctx:AleoParser.Register_accessContext):
        pass

    # Exit a parse tree produced by AleoParser#register_access.
    def exitRegister_access(self, ctx:AleoParser.Register_accessContext):
        pass


    # Enter a parse tree produced by AleoParser#register_accessor.
    def enterRegister_accessor(self, ctx:AleoParser.Register_accessorContext):
        pass

    # Exit a parse tree produced by AleoParser#register_accessor.
    def exitRegister_accessor(self, ctx:AleoParser.Register_accessorContext):
        pass


    # Enter a parse tree produced by AleoParser#access_by_field.
    def enterAccess_by_field(self, ctx:AleoParser.Access_by_fieldContext):
        pass

    # Exit a parse tree produced by AleoParser#access_by_field.
    def exitAccess_by_field(self, ctx:AleoParser.Access_by_fieldContext):
        pass


    # Enter a parse tree produced by AleoParser#access_by_index.
    def enterAccess_by_index(self, ctx:AleoParser.Access_by_indexContext):
        pass

    # Exit a parse tree produced by AleoParser#access_by_index.
    def exitAccess_by_index(self, ctx:AleoParser.Access_by_indexContext):
        pass


    # Enter a parse tree produced by AleoParser#operand.
    def enterOperand(self, ctx:AleoParser.OperandContext):
        pass

    # Exit a parse tree produced by AleoParser#operand.
    def exitOperand(self, ctx:AleoParser.OperandContext):
        pass


    # Enter a parse tree produced by AleoParser#tuple.
    def enterTuple(self, ctx:AleoParser.TupleContext):
        pass

    # Exit a parse tree produced by AleoParser#tuple.
    def exitTuple(self, ctx:AleoParser.TupleContext):
        pass


    # Enter a parse tree produced by AleoParser#entry.
    def enterEntry(self, ctx:AleoParser.EntryContext):
        pass

    # Exit a parse tree produced by AleoParser#entry.
    def exitEntry(self, ctx:AleoParser.EntryContext):
        pass


    # Enter a parse tree produced by AleoParser#locator.
    def enterLocator(self, ctx:AleoParser.LocatorContext):
        pass

    # Exit a parse tree produced by AleoParser#locator.
    def exitLocator(self, ctx:AleoParser.LocatorContext):
        pass


    # Enter a parse tree produced by AleoParser#cast_destination.
    def enterCast_destination(self, ctx:AleoParser.Cast_destinationContext):
        pass

    # Exit a parse tree produced by AleoParser#cast_destination.
    def exitCast_destination(self, ctx:AleoParser.Cast_destinationContext):
        pass


    # Enter a parse tree produced by AleoParser#unary_op.
    def enterUnary_op(self, ctx:AleoParser.Unary_opContext):
        pass

    # Exit a parse tree produced by AleoParser#unary_op.
    def exitUnary_op(self, ctx:AleoParser.Unary_opContext):
        pass


    # Enter a parse tree produced by AleoParser#binary_op.
    def enterBinary_op(self, ctx:AleoParser.Binary_opContext):
        pass

    # Exit a parse tree produced by AleoParser#binary_op.
    def exitBinary_op(self, ctx:AleoParser.Binary_opContext):
        pass


    # Enter a parse tree produced by AleoParser#is_op.
    def enterIs_op(self, ctx:AleoParser.Is_opContext):
        pass

    # Exit a parse tree produced by AleoParser#is_op.
    def exitIs_op(self, ctx:AleoParser.Is_opContext):
        pass


    # Enter a parse tree produced by AleoParser#assert_op.
    def enterAssert_op(self, ctx:AleoParser.Assert_opContext):
        pass

    # Exit a parse tree produced by AleoParser#assert_op.
    def exitAssert_op(self, ctx:AleoParser.Assert_opContext):
        pass


    # Enter a parse tree produced by AleoParser#commit_op.
    def enterCommit_op(self, ctx:AleoParser.Commit_opContext):
        pass

    # Exit a parse tree produced by AleoParser#commit_op.
    def exitCommit_op(self, ctx:AleoParser.Commit_opContext):
        pass


    # Enter a parse tree produced by AleoParser#hash1_op.
    def enterHash1_op(self, ctx:AleoParser.Hash1_opContext):
        pass

    # Exit a parse tree produced by AleoParser#hash1_op.
    def exitHash1_op(self, ctx:AleoParser.Hash1_opContext):
        pass


    # Enter a parse tree produced by AleoParser#hash2_op.
    def enterHash2_op(self, ctx:AleoParser.Hash2_opContext):
        pass

    # Exit a parse tree produced by AleoParser#hash2_op.
    def exitHash2_op(self, ctx:AleoParser.Hash2_opContext):
        pass


    # Enter a parse tree produced by AleoParser#cast_op.
    def enterCast_op(self, ctx:AleoParser.Cast_opContext):
        pass

    # Exit a parse tree produced by AleoParser#cast_op.
    def exitCast_op(self, ctx:AleoParser.Cast_opContext):
        pass


    # Enter a parse tree produced by AleoParser#branch_op.
    def enterBranch_op(self, ctx:AleoParser.Branch_opContext):
        pass

    # Exit a parse tree produced by AleoParser#branch_op.
    def exitBranch_op(self, ctx:AleoParser.Branch_opContext):
        pass


    # Enter a parse tree produced by AleoParser#label.
    def enterLabel(self, ctx:AleoParser.LabelContext):
        pass

    # Exit a parse tree produced by AleoParser#label.
    def exitLabel(self, ctx:AleoParser.LabelContext):
        pass


    # Enter a parse tree produced by AleoParser#identifier.
    def enterIdentifier(self, ctx:AleoParser.IdentifierContext):
        pass

    # Exit a parse tree produced by AleoParser#identifier.
    def exitIdentifier(self, ctx:AleoParser.IdentifierContext):
        pass



del AleoParser