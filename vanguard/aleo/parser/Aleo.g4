// adapted from: https://github.com/AleoHQ/grammars/blob/master/aleo.abnf
// this is a compatible grammar that adapts to older versions of Aleo grammar

// =============================================== //
// ==== parser rules and implicit lexer rules ==== //
// =============================================== //
grammar Aleo ;
start: program ;
program : ximport* 'program' program_id ';' ( mapping | struct | record | closure | function )+ ;

// blocks
ximport : 'import' program_id ';' ;
mapping : 'mapping' identifier ':' mapping_key mapping_value ;
mapping_key : 'key' 'as' mapping_type ';' ;
mapping_value : 'value' 'as' mapping_type ';' ;
struct : 'struct' identifier ':' tuple+ ;
record : 'record' identifier ':' entry* ;
closure : 'closure' identifier ':' closure_input* instruction+ closure_output* ;
closure_input : 'input' register 'as' register_type ';' ;
closure_output : 'output' operand 'as' register_type ';' ;
function : 'function' identifier ':' function_input* instruction* function_output* finalize? ;
function_input : 'input' register 'as' value_type ';' ;
function_output : 'output' operand 'as' value_type ';' ;
finalize : 'finalize' identifier ':' finalize_input* command+ ;
finalize_input : 'input' register 'as' finalize_type ';' ;

// instructions
command : contains | get | get_or_use | set | remove | random | position | branch | xawait | instruction ;
contains : 'contains' identifier '[' operand ']' 'into' register_access ';' ;
get : 'get' identifier '[' operand ']' 'into' register_access ';' ;
get_or_use : 'get.or_use' identifier '[' operand ']' operand 'into' register_access ';' ;
set : 'set' operand 'into' identifier '[' operand ']' ';' ;
remove : 'remove' identifier '[' operand ']' ';' ;
random : 'rand.chacha' operand* 'into' register_access 'as' ( arithmetic_type | address_type | signature_type | boolean_type ) ';' ;
position : 'position' label ';' ;
branch : branch_op operand operand 'to' label ';' ;
xawait : 'await' register_access ';' ;
instruction : unary | binary | ternary | is | assert | commit | hash | signverify | cast | call | xasync ;
unary : unary_op operand 'into' register_access ';' ;
binary : binary_op operand operand 'into' register_access ';' ;
ternary : 'ternary' operand operand operand 'into' register_access ';' ;
is : is_op operand operand 'into' register_access ';' ;
assert : assert_op operand operand ';' ;
commit : commit_op operand operand 'into' register_access 'as' ( address_type | field_type | group_type ) ';' ;
hash1 : hash1_op operand 'into' register_access 'as' ( arithmetic_type | address_type | signature_type | array_type | identifier ) ';' ;
hash2 : hash2_op operand operand 'into' register_access 'as' ( arithmetic_type | address_type | signature_type | array_type | identifier ) ';' ;
hash : hash1 | hash2 ;
signverify : ( 'sign.verify' | 'sign_verify' ) operand operand operand 'into' register_access ';' ;
cast : cast_op operand+ 'into' register_access 'as' cast_destination ';' ;
call : 'call' ( locator | identifier ) operand* ('into' register_access+)? ';' ;
xasync : 'async' identifier operand* 'into' register_access ';' ;

// literals
literal : arithmetic_literal | address_literal | signature_literal | boolean_literal ;
signed_literal : '-'? ( DIGIT '_'* )+ signed_type ;
unsigned_literal : '-'? ( DIGIT '_'* )+ unsigned_type ;
integer_literal : signed_literal | unsigned_literal ;
field_literal : '-'? ( DIGIT '_'* )+ field_type ;
group_literal : '-'? ( DIGIT '_'* )+ group_type ;
scalar_literal : '-'? ( DIGIT '_'* )+ scalar_type ;
arithmetic_literal : integer_literal | field_literal | group_literal | scalar_literal ;
u32_literal : '-'? ( DIGIT '_'* )+ 'u32' ;
address_literal : ADDRESS_LITERAL ;
signature_literal : SIGNATURE_LITERAL ;
boolean_literal : 'true' | 'false' ;

// types
unsigned_type : 'u8' | 'u16' | 'u32' | 'u64' | 'u128' ;
signed_type : 'i8' | 'i16' | 'i32' | 'i64' | 'i128' ;
integer_type : unsigned_type | signed_type ;
field_type : 'field' ;
group_type : 'group' ;
scalar_type : 'scalar' ;
arithmetic_type : integer_type | field_type | group_type | scalar_type ;
address_type : 'address' ;
boolean_type : 'boolean' ;
signature_type : 'signature' ;
literal_type : arithmetic_type | address_type | signature_type | boolean_type ;
array_type : '[' plaintext_type ';' u32_literal ']' ;
plaintext_type : literal_type | array_type | identifier ;
value_type : plaintext_type '.constant' | plaintext_type '.public' | plaintext_type '.private'
           | identifier '.record' | locator '.record' | locator '.future' ;
mapping_type : plaintext_type '.public' ;
finalize_type : plaintext_type '.public' | locator '.future' ;
entry_type : plaintext_type ( '.constant' | '.public' | '.private' ) ;
register_type : locator '.future' | locator '.record' | identifier '.record' | plaintext_type ;

// misc
program_id : program_name '.' program_domain ;
program_name : identifier ;
program_domain : identifier ;
register : REGISTER ;
register_access : register register_accessor* ;
register_accessor : access_by_field | access_by_index ;
access_by_field : '.' identifier ;
access_by_index : '[' u32_literal ']' | '[' DIGIT+ ']' ;

operand : literal | 'group::GEN' | register_access | program_id | 'self.signer' | 'self.caller' | 'block.height' ;
tuple : identifier 'as' plaintext_type ';' ;
entry : identifier 'as' entry_type ';' ;
locator : program_id '/' identifier ;
cast_destination : register_type | locator | 'group.x' | 'group.y' ;

unary_op : 'abs' | 'abs.w' | 'double' | 'inv' | 'neg' | 'not' | 'square' | 'sqrt' ;
binary_op : 'add' | 'add.w' | 'sub' | 'sub.w' | 'mul' | 'mul.w' | 'div' | 'div.w' | 'rem' | 'rem.w'
          | 'pow' | 'pow.w' | 'shl' | 'shl.w' | 'shr' | 'shr.w' | 'mod' | 'and' | 'or' | 'xor'
          | 'nand' | 'nor' | 'gt' | 'gte' | 'lt' | 'lte' ;
is_op : 'is.eq' | 'is.neq' ;
assert_op : 'assert.eq' | 'assert.neq' ;
commit_op : 'commit.bhp256' | 'commit.bhp512' | 'commit.bhp768' | 'commit.bhp1024'
          | 'commit.ped64' | 'commit.ped128' ;
hash1_op : 'hash.bhp256' | 'hash.bhp512' | 'hash.bhp768' | 'hash.bhp1024'
         | 'hash.ped64' | 'hash.ped128'
         | 'hash.psd2' | 'hash.psd4' | 'hash.psd8'
         | 'hash.keccak256' | 'hash.keccak384' | 'hash.keccak512'
         | 'hash.sha3_256' | 'hash.sha3_384' | 'hash.sha3_512' ;
hash2_op : 'hash_many.psd2' | 'hash_many.psd4' | 'hash_many.psd8' ;
cast_op : 'cast.lossy' | 'cast' ;
branch_op : 'branch.eq' | 'branch.neq' ;

label : identifier ;
identifier : IDENTIFIER ; // lexer rule to parser rule

// ============================== //
// ==== explicit lexer rules ==== //
// ============================== //

// literals
ADDRESS_LITERAL : 'aleo1' ( ADDRESS_OR_SIGNATURE_CHAR '_'* )+ ;
SIGNATURE_LITERAL : 'sign1' ( ADDRESS_OR_SIGNATURE_CHAR '_'* )+ ;
fragment ADDRESS_OR_SIGNATURE_CHAR : ADDRESS_OR_SIGNATURE_LOWERCASE_LETTER | ADDRESS_OR_SIGNATURE_DIGIT ;

// identifiers
REGISTER : 'r' DIGIT+ ;
IDENTIFIER : LETTER ( LETTER | DIGIT | '_' )* ;
fragment LETTER : LOWERCASE_LETTER | UPPERCASE_LETTER ;
fragment LOWERCASE_LETTER : ADDRESS_OR_SIGNATURE_LOWERCASE_LETTER | OTHER_LOWERCASE_LETTER ;
fragment ADDRESS_OR_SIGNATURE_LOWERCASE_LETTER : 'a' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'j' | 'k'
                                               | 'l' | 'm' | 'n' | 'p' | 'q' | 'r' | 's' | 't' | 'u'
                                               | 'v' | 'w' | 'x' | 'y' | 'z' ;
fragment OTHER_LOWERCASE_LETTER : 'b' | 'i' | 'o' ;
fragment UPPERCASE_LETTER : [A-Z] ;
DIGIT : ADDRESS_OR_SIGNATURE_DIGIT | OTHER_DIGIT ;
fragment ADDRESS_OR_SIGNATURE_DIGIT : '0' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' ;
fragment OTHER_DIGIT : '1' ;

// misc
WS : [ \t\r\n\u000C]+ -> skip ;
COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN) ;