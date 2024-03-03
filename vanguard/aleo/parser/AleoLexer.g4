lexer grammar AleoLexer ;

// ===================================== //
// ==== special chars - match first ==== //
// ===================================== //

DOT : '.' ; // important: this should NOT be a fragment
SLASH : '/' ;
LB : '[' ;
RB : ']' ;
SC : ';' ;
CC : '::' ;
CL : ':' ;
DS : '-' ;

// ======================= //
// ==== keyword rules ==== //
// ======================= //

// conjunctions
AS : 'as' ;
INTO : 'into' ;
TO : 'to' ;

// modifiers
PUBLIC : 'public' ;
PRIVATE : 'private' ;
CONSTANT : 'constant' ;
FUTURE : 'future' ;
RECORD : 'record' ;

// operands
GROUP : 'group' ;
GEN : 'GEN' ;
SELF : 'self' ;
SIGNER : 'signer' ;
CALLER : 'caller' ;
BLOCK : 'block' ;
HEIGHT : 'height' ;

// instructions
W : 'w' ;
X : 'x' ;
Y : 'y' ;
CONTAINS : 'contains' ;
GET : 'get' ;
OR_USE : 'or_use' ;
SET : 'set' ;
REMOVE : 'remove' ;
RAND : 'rand' ;
CHACHA : 'chacha' ;
POSITION : 'position' ;
AWAIT : 'await' ;
TERNARY : 'ternary' ;
SIGN : 'sign' ;
VERIFY : 'verify' ;
SIGN_VERIFY : 'sign_verify' ;
CALL : 'call' ;
ASYNC : 'async' ;
// operators
ABS : 'abs' ;
DOUBLE : 'double' ;
INV : 'inv' ;
NEG : 'neg' ;
NOT : 'not' ;
SQUARE : 'square' ;
SQRT : 'sqrt' ;
ADD : 'add' ;
SUB : 'sub' ;
MUL : 'mul' ;
DIV : 'div' ;
REM : 'rem' ;
POW : 'pow' ;
SHL : 'shl' ;
SHR : 'shr' ;
MOD : 'mod' ;
AND : 'and' ;
OR : 'or' ;
XOR : 'xor' ;
NAND : 'nand' ;
NOR : 'nor' ;
GT : 'gt' ;
GTE : 'gte' ;
LT : 'lt' ;
LTE : 'lte' ;
IS : 'is' ;
EQ : 'eq' ;
NEQ : 'neq' ;
ASSERT : 'assert' ;
COMMIT : 'commit' ;
HASH : 'hash' ;
HASH_MANY : 'hash_many' ;
BHP256 : 'bhp256' ;
BHP512 : 'bhp512' ;
BHP768 : 'bhp768' ;
BHP1024 : 'bhp1024' ;
PED64 : 'ped64' ;
PED128 : 'ped128' ;
PSD2 : 'psd2' ;
PSD4 : 'psd4' ;
PSD8 : 'psd8' ;
KECCAK256 : 'keccak256' ;
KECCAK384 : 'keccak384' ;
KECCAK512 : 'keccak512' ;
SHA3_256 : 'sha3_256' ;
SHA3_384 : 'sha3_384' ;
SHA3_512 : 'sha3_512' ;
CAST : 'cast' ;
LOSSY : 'lossy' ;
BRANCH : 'branch' ;

// blocks
PROGRAM : 'program' ;
IMPORT : 'import' ;
MAPPING : 'mapping' ;
KEY : 'key' ;
VALUE : 'value' ;
STRUCT : 'struct' ;
// RECORD : 'record' ;
CLOSURE : 'closure' ;
INPUT : 'input' ;
OUTPUT : 'output' ;
FUNCTION : 'function' ;
FINALIZE : 'finalize' ;

// literals & types
TRUE : 'true' ;
FALSE : 'false' ;
UNSIGNED_TYPE : 'u8' | 'u16' | 'u32' | 'u64' | 'u128' ;
SIGNED_TYPE : 'i8' | 'i16' | 'i32' | 'i64' | 'i128' ;
FIELD : 'field' ;
SCALAR : 'scalar' ;
ADDRESS : 'address' ;
BOOLEAN : 'boolean' ;
SIGNATURE : 'signature' ;

// ========================================== //
// ==== foundation rules (order matters) ==== //
// ========================================== //

// (special literals) address & signature literals
ADDRESS_LITERAL : ADDR_PREFIX ( ADDR_SIGN_CHAR '_'* )+ ;
SIGNATURE_LITERAL : SIGN_PREFIX ( ADDR_SIGN_CHAR '_'* )+ ;
fragment ADDR_PREFIX : 'aleo1' ;
fragment SIGN_PREFIX : 'sign1' ;
fragment ADDR_SIGN_CHAR : ADDR_SIGN_LETTER | ADDR_SIGN_DIGIT ;

DIGITS : ( DIGIT '_'* )+ ;
REGISTER : 'r' DIGIT+ ;
IDENTIFIER : LETTER ( LETTER | DIGIT | '_' )* ;

fragment DIGIT : ADDR_SIGN_DIGIT | OTHER_DIGIT ;
fragment ADDR_SIGN_DIGIT : '0' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' ;
fragment OTHER_DIGIT : '1' ;

fragment LETTER : LOWERCASE_LETTER | UPPERCASE_LETTER ;
fragment LOWERCASE_LETTER : ADDR_SIGN_LETTER | OTHER_LOWERCASE_LETTER ;
fragment ADDR_SIGN_LETTER : 'a' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'j' | 'k'
                          | 'l' | 'm' | 'n' | 'p' | 'q' | 'r' | 's' | 't' | 'u'
                          | 'v' | 'w' | 'x' | 'y' | 'z' ;
fragment OTHER_LOWERCASE_LETTER : 'b' | 'i' | 'o' ;
fragment UPPERCASE_LETTER : 'A' .. 'Z' ;

WS : [ \t\r\n\u000C]+ -> skip ;
COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN) ;