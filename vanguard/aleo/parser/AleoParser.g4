parser grammar AleoParser ;
options {
    tokenVocab = AleoLexer ;
}

start : program ;
program : ximport* PROGRAM program_id SC ( mapping | struct | record | closure | function )+ ;

// blocks
ximport : IMPORT program_id SC ;
mapping : MAPPING identifier CL mapping_key mapping_value ;
mapping_key : KEY AS mapping_type SC ;
mapping_value : VALUE AS mapping_type SC ;
struct : STRUCT identifier CL tuple+ ;
record : RECORD identifier CL entry* ;
closure : CLOSURE identifier CL closure_input* instruction+ closure_output* ;
closure_input : INPUT register AS register_type SC ;
closure_output : OUTPUT operand AS register_type SC ;
function : FUNCTION identifier CL function_input* instruction* function_output* finalize? ;
function_input : INPUT register AS value_type SC ;
function_output : OUTPUT operand AS value_type SC ;
finalize : FINALIZE identifier CL finalize_input* command+ ;
finalize_input : INPUT register AS finalize_type SC ;

// instructions
// NOTE: only those with multiple operators (e.g. branch) or composit operators (e.g., get_or_use)
//       will have corresponding operator parser rules
//       otherwise (e.g., TERNARY), use lexer rules directly instead
command : contains | get | get_or_use | set | remove | random | position | branch | xawait | instruction ;
contains : CONTAINS identifier LB operand RB INTO register_access SC ;
get : GET identifier LB operand RB INTO register_access SC ;
get_or_use : get_or_use_op identifier LB operand RB operand INTO register_access SC ;
// NOTE: destination of set can only be identifier, not register
set : SET operand INTO identifier LB operand RB SC ;
remove : REMOVE identifier LB operand RB SC ;
random : random_op operand* INTO register_access AS ( arithmetic_type | address_type | signature_type | boolean_type ) SC ;
position : POSITION label SC ;
branch : branch_op operand operand TO label SC ;
xawait : AWAIT register_access SC ;
instruction : unary | binary | ternary | is | assert | commit | hash | sign_verify | cast | call | xasync ;
unary : unary_op operand INTO register_access SC ;
binary : binary_op operand operand INTO register_access SC ;
ternary : TERNARY operand operand operand INTO register_access SC ;
is : is_op operand operand INTO register_access SC ;
assert : assert_op operand operand SC ;
commit : commit_op operand operand INTO register_access AS ( address_type | field_type | group_type ) SC ;
hash1 : hash1_op operand INTO register_access AS ( arithmetic_type | address_type | signature_type | array_type | identifier ) SC ;
hash2 : hash2_op operand operand INTO register_access AS ( arithmetic_type | address_type | signature_type | array_type | identifier ) SC ;
hash : hash1 | hash2 ;
sign_verify : sign_verify_op operand operand operand INTO register_access SC ;
cast : cast_op operand+ INTO register_access AS cast_destination SC ;
call : CALL ( locator | identifier ) operand* (INTO register_access+)? SC ;
xasync : ASYNC identifier operand* INTO register_access SC ;

// literals
literal : arithmetic_literal | address_literal | signature_literal | boolean_literal ;
signed_literal : DS? DIGITS signed_type ;
unsigned_literal : DS? DIGITS unsigned_type ;
integer_literal : signed_literal | unsigned_literal ;
field_literal : DS? DIGITS field_type ;
group_literal : DS? DIGITS group_type ;
scalar_literal : DS? DIGITS scalar_type ;
arithmetic_literal : integer_literal | field_literal | group_literal | scalar_literal ;
address_literal : ADDRESS_LITERAL ;
signature_literal : SIGNATURE_LITERAL ;
boolean_literal : TRUE | FALSE ;

// types
unsigned_type : UNSIGNED_TYPE ;
signed_type : SIGNED_TYPE ;
integer_type : unsigned_type | signed_type ;
field_type : FIELD ;
group_type : GROUP ;
scalar_type : SCALAR ;
arithmetic_type : integer_type | field_type | group_type | scalar_type ;
address_type : ADDRESS ;
boolean_type : BOOLEAN ;
signature_type : SIGNATURE ;
literal_type : arithmetic_type | address_type | signature_type | boolean_type ;
array_type : LB plaintext_type SC unsigned_literal RB ;
plaintext_type : literal_type | array_type | identifier ;
value_type : plaintext_type modifier | identifier modifier | locator modifier ;
mapping_type : plaintext_type modifier ;
finalize_type : plaintext_type modifier | locator modifier ;
entry_type : plaintext_type modifier ;
register_type : locator modifier | identifier modifier | plaintext_type ;
modifier : DOT ( CONSTANT | PRIVATE | PUBLIC | RECORD | FUTURE ) ;

// misc
program_id : program_name DOT program_domain ;
program_name : identifier ;
program_domain : identifier ;
register : REGISTER ;
register_access : register register_accessor* ;
register_accessor : access_by_field | access_by_index ;
access_by_field : DOT identifier ;
access_by_index : LB unsigned_literal RB | LB DIGITS RB ;

operand : literal | register_access | program_id | operand_preset ;
operand_preset : GROUP CC GEN | SELF DOT ( SIGNER | CALLER ) | BLOCK DOT HEIGHT ;
tuple : identifier AS plaintext_type SC ;
entry : identifier AS entry_type SC ;
locator : program_id SLASH identifier ;
cast_destination : register_type | locator | destination_group ;
destination_group : GROUP DOT ( X | Y ) ;

unary_op : ABS ( DOT W )? | DOUBLE | INV | NEG | NOT | SQUARE | SQRT ;
binary_op : ADD ( DOT W )? | SUB ( DOT W )? | MUL ( DOT W )? | DIV ( DOT W )? | REM ( DOT W )?
          | POW ( DOT W )? | SHL ( DOT W )? | SHR ( DOT W )? | MOD | AND | OR | XOR
          | NAND | NOR | GT | GTE | LT | LTE ;
is_op : IS DOT ( EQ | NEQ ) ;
assert_op : ASSERT DOT ( EQ | NEQ ) ;
commit_op : COMMIT DOT ( BHP256 | BHP512 | BHP768 | BHP1024 | PED64 | PED128 ) ;
hash1_op : HASH DOT ( BHP256 | BHP512 | BHP768 | BHP1024 | PED64 | PED128 | PSD2 | PSD4 | PSD8
                    | KECCAK256 | KECCAK384 | KECCAK512 | SHA3_256 | SHA3_384 | SHA3_512 ) ;
hash2_op : HASH_MANY DOT ( PSD2 | PSD4 | PSD8 ) ;
cast_op : CAST ( DOT LOSSY )? ;
branch_op : BRANCH DOT ( EQ | NEQ ) ;
random_op : RAND DOT CHACHA ;
get_or_use_op : GET DOT OR_USE ;
sign_verify_op : SIGN DOT VERIFY | SIGN_VERIFY ;

label : IDENTIFIER ;
// identifier : IDENTIFIER ;

// NOTE: identifier needs to consider keywords when they are not matched by parser rules
//       here only the DIGITS lexer rule and the special character lexer rules are not used
//       because they strictly cannot form identifies solely
// aleoswap05.aleo uses `to` as name of a struct field which can be accepted by this
// identifier : IDENTIFIER ;
identifier : IDENTIFIER | AS | INTO | TO | PUBLIC | PRIVATE | CONSTANT | FUTURE | RECORD
           | GROUP | GEN | SELF | SIGNER | CALLER | BLOCK | HEIGHT | W | X | Y
           | CONTAINS | GET | OR_USE | SET | REMOVE | RAND | CHACHA | POSITION
           | AWAIT | TERNARY | SIGN | VERIFY | SIGN_VERIFY | CALL | ASYNC
           | ABS | DOUBLE | INV | NEG | NOT | SQUARE | SQRT | ADD | SUB | MUL | DIV
           | REM | POW | SHL | SHR | MOD | AND | OR | XOR | NAND | NOR
           | GT | GTE | LT | LTE | IS | EQ | NEQ | ASSERT | COMMIT | HASH | HASH_MANY
           | BHP256 | BHP512 | BHP768 | BHP1024 | PED64 | PED128 | PSD2 | PSD4 | PSD8
           | KECCAK256 | KECCAK384 | KECCAK512 | SHA3_256 | SHA3_384 | SHA3_512
           | CAST | LOSSY | BRANCH | PROGRAM | IMPORT | MAPPING | KEY | VALUE | STRUCT
           | CLOSURE | INPUT | OUTPUT | FUNCTION | FINALIZE | TRUE | FALSE
           | UNSIGNED_TYPE | SIGNED_TYPE | FIELD | SCALAR | ADDRESS | BOOLEAN | SIGNATURE
           | ADDRESS_LITERAL | SIGNATURE_LITERAL | REGISTER ;