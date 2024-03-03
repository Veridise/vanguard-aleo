// Generated from /Users/joseph/Desktop/UCSB/24winter/vanguard-aleo/vanguard/aleo/parser/AleoParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AleoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, SLASH=2, LB=3, RB=4, SC=5, CC=6, CL=7, DS=8, AS=9, INTO=10, TO=11, 
		PUBLIC=12, PRIVATE=13, CONSTANT=14, FUTURE=15, RECORD=16, GROUP=17, GEN=18, 
		SELF=19, SIGNER=20, CALLER=21, BLOCK=22, HEIGHT=23, W=24, X=25, Y=26, 
		CONTAINS=27, GET=28, OR_USE=29, SET=30, REMOVE=31, RAND=32, CHACHA=33, 
		POSITION=34, AWAIT=35, TERNARY=36, SIGN=37, VERIFY=38, SIGN_VERIFY=39, 
		CALL=40, ASYNC=41, ABS=42, DOUBLE=43, INV=44, NEG=45, NOT=46, SQUARE=47, 
		SQRT=48, ADD=49, SUB=50, MUL=51, DIV=52, REM=53, POW=54, SHL=55, SHR=56, 
		MOD=57, AND=58, OR=59, XOR=60, NAND=61, NOR=62, GT=63, GTE=64, LT=65, 
		LTE=66, IS=67, EQ=68, NEQ=69, ASSERT=70, COMMIT=71, HASH=72, HASH_MANY=73, 
		BHP256=74, BHP512=75, BHP768=76, BHP1024=77, PED64=78, PED128=79, PSD2=80, 
		PSD4=81, PSD8=82, KECCAK256=83, KECCAK384=84, KECCAK512=85, SHA3_256=86, 
		SHA3_384=87, SHA3_512=88, CAST=89, LOSSY=90, BRANCH=91, PROGRAM=92, IMPORT=93, 
		MAPPING=94, KEY=95, VALUE=96, STRUCT=97, CLOSURE=98, INPUT=99, OUTPUT=100, 
		FUNCTION=101, FINALIZE=102, TRUE=103, FALSE=104, UNSIGNED_TYPE=105, SIGNED_TYPE=106, 
		FIELD=107, SCALAR=108, ADDRESS=109, BOOLEAN=110, SIGNATURE=111, ADDRESS_LITERAL=112, 
		SIGNATURE_LITERAL=113, DIGITS=114, REGISTER=115, IDENTIFIER=116, WS=117, 
		COMMENT=118, LINE_COMMENT=119;
	public static final int
		RULE_start = 0, RULE_program = 1, RULE_ximport = 2, RULE_mapping = 3, 
		RULE_mapping_key = 4, RULE_mapping_value = 5, RULE_struct = 6, RULE_record = 7, 
		RULE_closure = 8, RULE_closure_input = 9, RULE_closure_output = 10, RULE_function = 11, 
		RULE_function_input = 12, RULE_function_output = 13, RULE_finalize = 14, 
		RULE_finalize_input = 15, RULE_command = 16, RULE_contains = 17, RULE_get = 18, 
		RULE_get_or_use = 19, RULE_set = 20, RULE_remove = 21, RULE_random = 22, 
		RULE_position = 23, RULE_branch = 24, RULE_xawait = 25, RULE_instruction = 26, 
		RULE_unary = 27, RULE_binary = 28, RULE_ternary = 29, RULE_is = 30, RULE_assert = 31, 
		RULE_commit = 32, RULE_hash1 = 33, RULE_hash2 = 34, RULE_hash = 35, RULE_sign_verify = 36, 
		RULE_cast = 37, RULE_call = 38, RULE_xasync = 39, RULE_literal = 40, RULE_signed_literal = 41, 
		RULE_unsigned_literal = 42, RULE_integer_literal = 43, RULE_field_literal = 44, 
		RULE_group_literal = 45, RULE_scalar_literal = 46, RULE_arithmetic_literal = 47, 
		RULE_address_literal = 48, RULE_signature_literal = 49, RULE_boolean_literal = 50, 
		RULE_unsigned_type = 51, RULE_signed_type = 52, RULE_integer_type = 53, 
		RULE_field_type = 54, RULE_group_type = 55, RULE_scalar_type = 56, RULE_arithmetic_type = 57, 
		RULE_address_type = 58, RULE_boolean_type = 59, RULE_signature_type = 60, 
		RULE_literal_type = 61, RULE_array_type = 62, RULE_plaintext_type = 63, 
		RULE_value_type = 64, RULE_mapping_type = 65, RULE_finalize_type = 66, 
		RULE_entry_type = 67, RULE_register_type = 68, RULE_modifier = 69, RULE_program_id = 70, 
		RULE_program_name = 71, RULE_program_domain = 72, RULE_register = 73, 
		RULE_register_access = 74, RULE_register_accessor = 75, RULE_access_by_field = 76, 
		RULE_access_by_index = 77, RULE_operand = 78, RULE_operand_preset = 79, 
		RULE_tuple = 80, RULE_entry = 81, RULE_locator = 82, RULE_cast_destination = 83, 
		RULE_destination_group = 84, RULE_unary_op = 85, RULE_binary_op = 86, 
		RULE_is_op = 87, RULE_assert_op = 88, RULE_commit_op = 89, RULE_hash1_op = 90, 
		RULE_hash2_op = 91, RULE_cast_op = 92, RULE_branch_op = 93, RULE_random_op = 94, 
		RULE_get_or_use_op = 95, RULE_sign_verify_op = 96, RULE_label = 97, RULE_identifier = 98;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "program", "ximport", "mapping", "mapping_key", "mapping_value", 
			"struct", "record", "closure", "closure_input", "closure_output", "function", 
			"function_input", "function_output", "finalize", "finalize_input", "command", 
			"contains", "get", "get_or_use", "set", "remove", "random", "position", 
			"branch", "xawait", "instruction", "unary", "binary", "ternary", "is", 
			"assert", "commit", "hash1", "hash2", "hash", "sign_verify", "cast", 
			"call", "xasync", "literal", "signed_literal", "unsigned_literal", "integer_literal", 
			"field_literal", "group_literal", "scalar_literal", "arithmetic_literal", 
			"address_literal", "signature_literal", "boolean_literal", "unsigned_type", 
			"signed_type", "integer_type", "field_type", "group_type", "scalar_type", 
			"arithmetic_type", "address_type", "boolean_type", "signature_type", 
			"literal_type", "array_type", "plaintext_type", "value_type", "mapping_type", 
			"finalize_type", "entry_type", "register_type", "modifier", "program_id", 
			"program_name", "program_domain", "register", "register_access", "register_accessor", 
			"access_by_field", "access_by_index", "operand", "operand_preset", "tuple", 
			"entry", "locator", "cast_destination", "destination_group", "unary_op", 
			"binary_op", "is_op", "assert_op", "commit_op", "hash1_op", "hash2_op", 
			"cast_op", "branch_op", "random_op", "get_or_use_op", "sign_verify_op", 
			"label", "identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'/'", "'['", "']'", "';'", "'::'", "':'", "'-'", "'as'", 
			"'into'", "'to'", "'public'", "'private'", "'constant'", "'future'", 
			"'record'", "'group'", "'GEN'", "'self'", "'signer'", "'caller'", "'block'", 
			"'height'", "'w'", "'x'", "'y'", "'contains'", "'get'", "'or_use'", "'set'", 
			"'remove'", "'rand'", "'chacha'", "'position'", "'await'", "'ternary'", 
			"'sign'", "'verify'", "'sign_verify'", "'call'", "'async'", "'abs'", 
			"'double'", "'inv'", "'neg'", "'not'", "'square'", "'sqrt'", "'add'", 
			"'sub'", "'mul'", "'div'", "'rem'", "'pow'", "'shl'", "'shr'", "'mod'", 
			"'and'", "'or'", "'xor'", "'nand'", "'nor'", "'gt'", "'gte'", "'lt'", 
			"'lte'", "'is'", "'eq'", "'neq'", "'assert'", "'commit'", "'hash'", "'hash_many'", 
			"'bhp256'", "'bhp512'", "'bhp768'", "'bhp1024'", "'ped64'", "'ped128'", 
			"'psd2'", "'psd4'", "'psd8'", "'keccak256'", "'keccak384'", "'keccak512'", 
			"'sha3_256'", "'sha3_384'", "'sha3_512'", "'cast'", "'lossy'", "'branch'", 
			"'program'", "'import'", "'mapping'", "'key'", "'value'", "'struct'", 
			"'closure'", "'input'", "'output'", "'function'", "'finalize'", "'true'", 
			"'false'", null, null, "'field'", "'scalar'", "'address'", "'boolean'", 
			"'signature'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOT", "SLASH", "LB", "RB", "SC", "CC", "CL", "DS", "AS", "INTO", 
			"TO", "PUBLIC", "PRIVATE", "CONSTANT", "FUTURE", "RECORD", "GROUP", "GEN", 
			"SELF", "SIGNER", "CALLER", "BLOCK", "HEIGHT", "W", "X", "Y", "CONTAINS", 
			"GET", "OR_USE", "SET", "REMOVE", "RAND", "CHACHA", "POSITION", "AWAIT", 
			"TERNARY", "SIGN", "VERIFY", "SIGN_VERIFY", "CALL", "ASYNC", "ABS", "DOUBLE", 
			"INV", "NEG", "NOT", "SQUARE", "SQRT", "ADD", "SUB", "MUL", "DIV", "REM", 
			"POW", "SHL", "SHR", "MOD", "AND", "OR", "XOR", "NAND", "NOR", "GT", 
			"GTE", "LT", "LTE", "IS", "EQ", "NEQ", "ASSERT", "COMMIT", "HASH", "HASH_MANY", 
			"BHP256", "BHP512", "BHP768", "BHP1024", "PED64", "PED128", "PSD2", "PSD4", 
			"PSD8", "KECCAK256", "KECCAK384", "KECCAK512", "SHA3_256", "SHA3_384", 
			"SHA3_512", "CAST", "LOSSY", "BRANCH", "PROGRAM", "IMPORT", "MAPPING", 
			"KEY", "VALUE", "STRUCT", "CLOSURE", "INPUT", "OUTPUT", "FUNCTION", "FINALIZE", 
			"TRUE", "FALSE", "UNSIGNED_TYPE", "SIGNED_TYPE", "FIELD", "SCALAR", "ADDRESS", 
			"BOOLEAN", "SIGNATURE", "ADDRESS_LITERAL", "SIGNATURE_LITERAL", "DIGITS", 
			"REGISTER", "IDENTIFIER", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AleoParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AleoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			program();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(AleoParser.PROGRAM, 0); }
		public Program_idContext program_id() {
			return getRuleContext(Program_idContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public List<XimportContext> ximport() {
			return getRuleContexts(XimportContext.class);
		}
		public XimportContext ximport(int i) {
			return getRuleContext(XimportContext.class,i);
		}
		public List<MappingContext> mapping() {
			return getRuleContexts(MappingContext.class);
		}
		public MappingContext mapping(int i) {
			return getRuleContext(MappingContext.class,i);
		}
		public List<StructContext> struct() {
			return getRuleContexts(StructContext.class);
		}
		public StructContext struct(int i) {
			return getRuleContext(StructContext.class,i);
		}
		public List<RecordContext> record() {
			return getRuleContexts(RecordContext.class);
		}
		public RecordContext record(int i) {
			return getRuleContext(RecordContext.class,i);
		}
		public List<ClosureContext> closure() {
			return getRuleContexts(ClosureContext.class);
		}
		public ClosureContext closure(int i) {
			return getRuleContext(ClosureContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(200);
				ximport();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			match(PROGRAM);
			setState(207);
			program_id();
			setState(208);
			match(SC);
			setState(214); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(214);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MAPPING:
					{
					setState(209);
					mapping();
					}
					break;
				case STRUCT:
					{
					setState(210);
					struct();
					}
					break;
				case RECORD:
					{
					setState(211);
					record();
					}
					break;
				case CLOSURE:
					{
					setState(212);
					closure();
					}
					break;
				case FUNCTION:
					{
					setState(213);
					function();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(216); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RECORD || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & 153L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class XimportContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(AleoParser.IMPORT, 0); }
		public Program_idContext program_id() {
			return getRuleContext(Program_idContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public XimportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ximport; }
	}

	public final XimportContext ximport() throws RecognitionException {
		XimportContext _localctx = new XimportContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ximport);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(IMPORT);
			setState(219);
			program_id();
			setState(220);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MappingContext extends ParserRuleContext {
		public TerminalNode MAPPING() { return getToken(AleoParser.MAPPING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CL() { return getToken(AleoParser.CL, 0); }
		public Mapping_keyContext mapping_key() {
			return getRuleContext(Mapping_keyContext.class,0);
		}
		public Mapping_valueContext mapping_value() {
			return getRuleContext(Mapping_valueContext.class,0);
		}
		public MappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping; }
	}

	public final MappingContext mapping() throws RecognitionException {
		MappingContext _localctx = new MappingContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mapping);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(MAPPING);
			setState(223);
			identifier();
			setState(224);
			match(CL);
			setState(225);
			mapping_key();
			setState(226);
			mapping_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mapping_keyContext extends ParserRuleContext {
		public TerminalNode KEY() { return getToken(AleoParser.KEY, 0); }
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public Mapping_typeContext mapping_type() {
			return getRuleContext(Mapping_typeContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Mapping_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping_key; }
	}

	public final Mapping_keyContext mapping_key() throws RecognitionException {
		Mapping_keyContext _localctx = new Mapping_keyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mapping_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(KEY);
			setState(229);
			match(AS);
			setState(230);
			mapping_type();
			setState(231);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mapping_valueContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(AleoParser.VALUE, 0); }
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public Mapping_typeContext mapping_type() {
			return getRuleContext(Mapping_typeContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Mapping_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping_value; }
	}

	public final Mapping_valueContext mapping_value() throws RecognitionException {
		Mapping_valueContext _localctx = new Mapping_valueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mapping_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(VALUE);
			setState(234);
			match(AS);
			setState(235);
			mapping_type();
			setState(236);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(AleoParser.STRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CL() { return getToken(AleoParser.CL, 0); }
		public List<TupleContext> tuple() {
			return getRuleContexts(TupleContext.class);
		}
		public TupleContext tuple(int i) {
			return getRuleContext(TupleContext.class,i);
		}
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_struct);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(STRUCT);
			setState(239);
			identifier();
			setState(240);
			match(CL);
			setState(242); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(241);
					tuple();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(244); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecordContext extends ParserRuleContext {
		public TerminalNode RECORD() { return getToken(AleoParser.RECORD, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CL() { return getToken(AleoParser.CL, 0); }
		public List<EntryContext> entry() {
			return getRuleContexts(EntryContext.class);
		}
		public EntryContext entry(int i) {
			return getRuleContext(EntryContext.class,i);
		}
		public RecordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record; }
	}

	public final RecordContext record() throws RecognitionException {
		RecordContext _localctx = new RecordContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_record);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(RECORD);
			setState(247);
			identifier();
			setState(248);
			match(CL);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(249);
					entry();
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClosureContext extends ParserRuleContext {
		public TerminalNode CLOSURE() { return getToken(AleoParser.CLOSURE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CL() { return getToken(AleoParser.CL, 0); }
		public List<Closure_inputContext> closure_input() {
			return getRuleContexts(Closure_inputContext.class);
		}
		public Closure_inputContext closure_input(int i) {
			return getRuleContext(Closure_inputContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<Closure_outputContext> closure_output() {
			return getRuleContexts(Closure_outputContext.class);
		}
		public Closure_outputContext closure_output(int i) {
			return getRuleContext(Closure_outputContext.class,i);
		}
		public ClosureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closure; }
	}

	public final ClosureContext closure() throws RecognitionException {
		ClosureContext _localctx = new ClosureContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_closure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(CLOSURE);
			setState(256);
			identifier();
			setState(257);
			match(CL);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INPUT) {
				{
				{
				setState(258);
				closure_input();
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(264);
				instruction();
				}
				}
				setState(267); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & 9007461247746043L) != 0) );
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OUTPUT) {
				{
				{
				setState(269);
				closure_output();
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Closure_inputContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(AleoParser.INPUT, 0); }
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public Register_typeContext register_type() {
			return getRuleContext(Register_typeContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Closure_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closure_input; }
	}

	public final Closure_inputContext closure_input() throws RecognitionException {
		Closure_inputContext _localctx = new Closure_inputContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_closure_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(INPUT);
			setState(276);
			register();
			setState(277);
			match(AS);
			setState(278);
			register_type();
			setState(279);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Closure_outputContext extends ParserRuleContext {
		public TerminalNode OUTPUT() { return getToken(AleoParser.OUTPUT, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public Register_typeContext register_type() {
			return getRuleContext(Register_typeContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Closure_outputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closure_output; }
	}

	public final Closure_outputContext closure_output() throws RecognitionException {
		Closure_outputContext _localctx = new Closure_outputContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_closure_output);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(OUTPUT);
			setState(282);
			operand();
			setState(283);
			match(AS);
			setState(284);
			register_type();
			setState(285);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(AleoParser.FUNCTION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CL() { return getToken(AleoParser.CL, 0); }
		public List<Function_inputContext> function_input() {
			return getRuleContexts(Function_inputContext.class);
		}
		public Function_inputContext function_input(int i) {
			return getRuleContext(Function_inputContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<Function_outputContext> function_output() {
			return getRuleContexts(Function_outputContext.class);
		}
		public Function_outputContext function_output(int i) {
			return getRuleContext(Function_outputContext.class,i);
		}
		public FinalizeContext finalize() {
			return getRuleContext(FinalizeContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(FUNCTION);
			setState(288);
			identifier();
			setState(289);
			match(CL);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INPUT) {
				{
				{
				setState(290);
				function_input();
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & 9007461247746043L) != 0)) {
				{
				{
				setState(296);
				instruction();
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OUTPUT) {
				{
				{
				setState(302);
				function_output();
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALIZE) {
				{
				setState(308);
				finalize();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_inputContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(AleoParser.INPUT, 0); }
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public Value_typeContext value_type() {
			return getRuleContext(Value_typeContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Function_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_input; }
	}

	public final Function_inputContext function_input() throws RecognitionException {
		Function_inputContext _localctx = new Function_inputContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(INPUT);
			setState(312);
			register();
			setState(313);
			match(AS);
			setState(314);
			value_type();
			setState(315);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_outputContext extends ParserRuleContext {
		public TerminalNode OUTPUT() { return getToken(AleoParser.OUTPUT, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public Value_typeContext value_type() {
			return getRuleContext(Value_typeContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Function_outputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_output; }
	}

	public final Function_outputContext function_output() throws RecognitionException {
		Function_outputContext _localctx = new Function_outputContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function_output);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(OUTPUT);
			setState(318);
			operand();
			setState(319);
			match(AS);
			setState(320);
			value_type();
			setState(321);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FinalizeContext extends ParserRuleContext {
		public TerminalNode FINALIZE() { return getToken(AleoParser.FINALIZE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CL() { return getToken(AleoParser.CL, 0); }
		public List<Finalize_inputContext> finalize_input() {
			return getRuleContexts(Finalize_inputContext.class);
		}
		public Finalize_inputContext finalize_input(int i) {
			return getRuleContext(Finalize_inputContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public FinalizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalize; }
	}

	public final FinalizeContext finalize() throws RecognitionException {
		FinalizeContext _localctx = new FinalizeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_finalize);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(FINALIZE);
			setState(324);
			identifier();
			setState(325);
			match(CL);
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INPUT) {
				{
				{
				setState(326);
				finalize_input();
				}
				}
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(333); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(332);
				command();
				}
				}
				setState(335); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -284138930176L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 167773135L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Finalize_inputContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(AleoParser.INPUT, 0); }
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public Finalize_typeContext finalize_type() {
			return getRuleContext(Finalize_typeContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Finalize_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalize_input; }
	}

	public final Finalize_inputContext finalize_input() throws RecognitionException {
		Finalize_inputContext _localctx = new Finalize_inputContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_finalize_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(INPUT);
			setState(338);
			register();
			setState(339);
			match(AS);
			setState(340);
			finalize_type();
			setState(341);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommandContext extends ParserRuleContext {
		public ContainsContext contains() {
			return getRuleContext(ContainsContext.class,0);
		}
		public GetContext get() {
			return getRuleContext(GetContext.class,0);
		}
		public Get_or_useContext get_or_use() {
			return getRuleContext(Get_or_useContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public RemoveContext remove() {
			return getRuleContext(RemoveContext.class,0);
		}
		public RandomContext random() {
			return getRuleContext(RandomContext.class,0);
		}
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public BranchContext branch() {
			return getRuleContext(BranchContext.class,0);
		}
		public XawaitContext xawait() {
			return getRuleContext(XawaitContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_command);
		try {
			setState(353);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				contains();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(344);
				get();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(345);
				get_or_use();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(346);
				set();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(347);
				remove();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(348);
				random();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(349);
				position();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(350);
				branch();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(351);
				xawait();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(352);
				instruction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContainsContext extends ParserRuleContext {
		public TerminalNode CONTAINS() { return getToken(AleoParser.CONTAINS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LB() { return getToken(AleoParser.LB, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public TerminalNode RB() { return getToken(AleoParser.RB, 0); }
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public ContainsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contains; }
	}

	public final ContainsContext contains() throws RecognitionException {
		ContainsContext _localctx = new ContainsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_contains);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(CONTAINS);
			setState(356);
			identifier();
			setState(357);
			match(LB);
			setState(358);
			operand();
			setState(359);
			match(RB);
			setState(360);
			match(INTO);
			setState(361);
			register_access();
			setState(362);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GetContext extends ParserRuleContext {
		public TerminalNode GET() { return getToken(AleoParser.GET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LB() { return getToken(AleoParser.LB, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public TerminalNode RB() { return getToken(AleoParser.RB, 0); }
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public GetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_get; }
	}

	public final GetContext get() throws RecognitionException {
		GetContext _localctx = new GetContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_get);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(GET);
			setState(365);
			identifier();
			setState(366);
			match(LB);
			setState(367);
			operand();
			setState(368);
			match(RB);
			setState(369);
			match(INTO);
			setState(370);
			register_access();
			setState(371);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Get_or_useContext extends ParserRuleContext {
		public Get_or_use_opContext get_or_use_op() {
			return getRuleContext(Get_or_use_opContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LB() { return getToken(AleoParser.LB, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode RB() { return getToken(AleoParser.RB, 0); }
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Get_or_useContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_get_or_use; }
	}

	public final Get_or_useContext get_or_use() throws RecognitionException {
		Get_or_useContext _localctx = new Get_or_useContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_get_or_use);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			get_or_use_op();
			setState(374);
			identifier();
			setState(375);
			match(LB);
			setState(376);
			operand();
			setState(377);
			match(RB);
			setState(378);
			operand();
			setState(379);
			match(INTO);
			setState(380);
			register_access();
			setState(381);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(AleoParser.SET, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LB() { return getToken(AleoParser.LB, 0); }
		public TerminalNode RB() { return getToken(AleoParser.RB, 0); }
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(SET);
			setState(384);
			operand();
			setState(385);
			match(INTO);
			setState(386);
			identifier();
			setState(387);
			match(LB);
			setState(388);
			operand();
			setState(389);
			match(RB);
			setState(390);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RemoveContext extends ParserRuleContext {
		public TerminalNode REMOVE() { return getToken(AleoParser.REMOVE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LB() { return getToken(AleoParser.LB, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public TerminalNode RB() { return getToken(AleoParser.RB, 0); }
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public RemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remove; }
	}

	public final RemoveContext remove() throws RecognitionException {
		RemoveContext _localctx = new RemoveContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_remove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(REMOVE);
			setState(393);
			identifier();
			setState(394);
			match(LB);
			setState(395);
			operand();
			setState(396);
			match(RB);
			setState(397);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RandomContext extends ParserRuleContext {
		public Random_opContext random_op() {
			return getRuleContext(Random_opContext.class,0);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Arithmetic_typeContext arithmetic_type() {
			return getRuleContext(Arithmetic_typeContext.class,0);
		}
		public Address_typeContext address_type() {
			return getRuleContext(Address_typeContext.class,0);
		}
		public Signature_typeContext signature_type() {
			return getRuleContext(Signature_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public RandomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_random; }
	}

	public final RandomContext random() throws RecognitionException {
		RandomContext _localctx = new RandomContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_random);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			random_op();
			setState(403);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(400);
					operand();
					}
					} 
				}
				setState(405);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(406);
			match(INTO);
			setState(407);
			register_access();
			setState(408);
			match(AS);
			setState(413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GROUP:
			case UNSIGNED_TYPE:
			case SIGNED_TYPE:
			case FIELD:
			case SCALAR:
				{
				setState(409);
				arithmetic_type();
				}
				break;
			case ADDRESS:
				{
				setState(410);
				address_type();
				}
				break;
			case SIGNATURE:
				{
				setState(411);
				signature_type();
				}
				break;
			case BOOLEAN:
				{
				setState(412);
				boolean_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(415);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PositionContext extends ParserRuleContext {
		public TerminalNode POSITION() { return getToken(AleoParser.POSITION, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public PositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_position; }
	}

	public final PositionContext position() throws RecognitionException {
		PositionContext _localctx = new PositionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_position);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(POSITION);
			setState(418);
			label();
			setState(419);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BranchContext extends ParserRuleContext {
		public Branch_opContext branch_op() {
			return getRuleContext(Branch_opContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode TO() { return getToken(AleoParser.TO, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_branch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			branch_op();
			setState(422);
			operand();
			setState(423);
			operand();
			setState(424);
			match(TO);
			setState(425);
			label();
			setState(426);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class XawaitContext extends ParserRuleContext {
		public TerminalNode AWAIT() { return getToken(AleoParser.AWAIT, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public XawaitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xawait; }
	}

	public final XawaitContext xawait() throws RecognitionException {
		XawaitContext _localctx = new XawaitContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_xawait);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(AWAIT);
			setState(429);
			register_access();
			setState(430);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public BinaryContext binary() {
			return getRuleContext(BinaryContext.class,0);
		}
		public TernaryContext ternary() {
			return getRuleContext(TernaryContext.class,0);
		}
		public IsContext is() {
			return getRuleContext(IsContext.class,0);
		}
		public AssertContext assert_() {
			return getRuleContext(AssertContext.class,0);
		}
		public CommitContext commit() {
			return getRuleContext(CommitContext.class,0);
		}
		public HashContext hash() {
			return getRuleContext(HashContext.class,0);
		}
		public Sign_verifyContext sign_verify() {
			return getRuleContext(Sign_verifyContext.class,0);
		}
		public CastContext cast() {
			return getRuleContext(CastContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public XasyncContext xasync() {
			return getRuleContext(XasyncContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_instruction);
		try {
			setState(443);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABS:
			case DOUBLE:
			case INV:
			case NEG:
			case NOT:
			case SQUARE:
			case SQRT:
				enterOuterAlt(_localctx, 1);
				{
				setState(432);
				unary();
				}
				break;
			case ADD:
			case SUB:
			case MUL:
			case DIV:
			case REM:
			case POW:
			case SHL:
			case SHR:
			case MOD:
			case AND:
			case OR:
			case XOR:
			case NAND:
			case NOR:
			case GT:
			case GTE:
			case LT:
			case LTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
				binary();
				}
				break;
			case TERNARY:
				enterOuterAlt(_localctx, 3);
				{
				setState(434);
				ternary();
				}
				break;
			case IS:
				enterOuterAlt(_localctx, 4);
				{
				setState(435);
				is();
				}
				break;
			case ASSERT:
				enterOuterAlt(_localctx, 5);
				{
				setState(436);
				assert_();
				}
				break;
			case COMMIT:
				enterOuterAlt(_localctx, 6);
				{
				setState(437);
				commit();
				}
				break;
			case HASH:
			case HASH_MANY:
				enterOuterAlt(_localctx, 7);
				{
				setState(438);
				hash();
				}
				break;
			case SIGN:
			case SIGN_VERIFY:
				enterOuterAlt(_localctx, 8);
				{
				setState(439);
				sign_verify();
				}
				break;
			case CAST:
				enterOuterAlt(_localctx, 9);
				{
				setState(440);
				cast();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 10);
				{
				setState(441);
				call();
				}
				break;
			case ASYNC:
				enterOuterAlt(_localctx, 11);
				{
				setState(442);
				xasync();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends ParserRuleContext {
		public Unary_opContext unary_op() {
			return getRuleContext(Unary_opContext.class,0);
		}
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_unary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			unary_op();
			setState(446);
			operand();
			setState(447);
			match(INTO);
			setState(448);
			register_access();
			setState(449);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryContext extends ParserRuleContext {
		public Binary_opContext binary_op() {
			return getRuleContext(Binary_opContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public BinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary; }
	}

	public final BinaryContext binary() throws RecognitionException {
		BinaryContext _localctx = new BinaryContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_binary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			binary_op();
			setState(452);
			operand();
			setState(453);
			operand();
			setState(454);
			match(INTO);
			setState(455);
			register_access();
			setState(456);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TernaryContext extends ParserRuleContext {
		public TerminalNode TERNARY() { return getToken(AleoParser.TERNARY, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public TernaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary; }
	}

	public final TernaryContext ternary() throws RecognitionException {
		TernaryContext _localctx = new TernaryContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ternary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(TERNARY);
			setState(459);
			operand();
			setState(460);
			operand();
			setState(461);
			operand();
			setState(462);
			match(INTO);
			setState(463);
			register_access();
			setState(464);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IsContext extends ParserRuleContext {
		public Is_opContext is_op() {
			return getRuleContext(Is_opContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public IsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is; }
	}

	public final IsContext is() throws RecognitionException {
		IsContext _localctx = new IsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_is);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			is_op();
			setState(467);
			operand();
			setState(468);
			operand();
			setState(469);
			match(INTO);
			setState(470);
			register_access();
			setState(471);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssertContext extends ParserRuleContext {
		public Assert_opContext assert_op() {
			return getRuleContext(Assert_opContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public AssertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assert; }
	}

	public final AssertContext assert_() throws RecognitionException {
		AssertContext _localctx = new AssertContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_assert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			assert_op();
			setState(474);
			operand();
			setState(475);
			operand();
			setState(476);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommitContext extends ParserRuleContext {
		public Commit_opContext commit_op() {
			return getRuleContext(Commit_opContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Address_typeContext address_type() {
			return getRuleContext(Address_typeContext.class,0);
		}
		public Field_typeContext field_type() {
			return getRuleContext(Field_typeContext.class,0);
		}
		public Group_typeContext group_type() {
			return getRuleContext(Group_typeContext.class,0);
		}
		public CommitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commit; }
	}

	public final CommitContext commit() throws RecognitionException {
		CommitContext _localctx = new CommitContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_commit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			commit_op();
			setState(479);
			operand();
			setState(480);
			operand();
			setState(481);
			match(INTO);
			setState(482);
			register_access();
			setState(483);
			match(AS);
			setState(487);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADDRESS:
				{
				setState(484);
				address_type();
				}
				break;
			case FIELD:
				{
				setState(485);
				field_type();
				}
				break;
			case GROUP:
				{
				setState(486);
				group_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(489);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Hash1Context extends ParserRuleContext {
		public Hash1_opContext hash1_op() {
			return getRuleContext(Hash1_opContext.class,0);
		}
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Arithmetic_typeContext arithmetic_type() {
			return getRuleContext(Arithmetic_typeContext.class,0);
		}
		public Address_typeContext address_type() {
			return getRuleContext(Address_typeContext.class,0);
		}
		public Signature_typeContext signature_type() {
			return getRuleContext(Signature_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Hash1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hash1; }
	}

	public final Hash1Context hash1() throws RecognitionException {
		Hash1Context _localctx = new Hash1Context(_ctx, getState());
		enterRule(_localctx, 66, RULE_hash1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			hash1_op();
			setState(492);
			operand();
			setState(493);
			match(INTO);
			setState(494);
			register_access();
			setState(495);
			match(AS);
			setState(501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(496);
				arithmetic_type();
				}
				break;
			case 2:
				{
				setState(497);
				address_type();
				}
				break;
			case 3:
				{
				setState(498);
				signature_type();
				}
				break;
			case 4:
				{
				setState(499);
				array_type();
				}
				break;
			case 5:
				{
				setState(500);
				identifier();
				}
				break;
			}
			setState(503);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Hash2Context extends ParserRuleContext {
		public Hash2_opContext hash2_op() {
			return getRuleContext(Hash2_opContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Arithmetic_typeContext arithmetic_type() {
			return getRuleContext(Arithmetic_typeContext.class,0);
		}
		public Address_typeContext address_type() {
			return getRuleContext(Address_typeContext.class,0);
		}
		public Signature_typeContext signature_type() {
			return getRuleContext(Signature_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Hash2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hash2; }
	}

	public final Hash2Context hash2() throws RecognitionException {
		Hash2Context _localctx = new Hash2Context(_ctx, getState());
		enterRule(_localctx, 68, RULE_hash2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			hash2_op();
			setState(506);
			operand();
			setState(507);
			operand();
			setState(508);
			match(INTO);
			setState(509);
			register_access();
			setState(510);
			match(AS);
			setState(516);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(511);
				arithmetic_type();
				}
				break;
			case 2:
				{
				setState(512);
				address_type();
				}
				break;
			case 3:
				{
				setState(513);
				signature_type();
				}
				break;
			case 4:
				{
				setState(514);
				array_type();
				}
				break;
			case 5:
				{
				setState(515);
				identifier();
				}
				break;
			}
			setState(518);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HashContext extends ParserRuleContext {
		public Hash1Context hash1() {
			return getRuleContext(Hash1Context.class,0);
		}
		public Hash2Context hash2() {
			return getRuleContext(Hash2Context.class,0);
		}
		public HashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hash; }
	}

	public final HashContext hash() throws RecognitionException {
		HashContext _localctx = new HashContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_hash);
		try {
			setState(522);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(520);
				hash1();
				}
				break;
			case HASH_MANY:
				enterOuterAlt(_localctx, 2);
				{
				setState(521);
				hash2();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Sign_verifyContext extends ParserRuleContext {
		public Sign_verify_opContext sign_verify_op() {
			return getRuleContext(Sign_verify_opContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Sign_verifyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign_verify; }
	}

	public final Sign_verifyContext sign_verify() throws RecognitionException {
		Sign_verifyContext _localctx = new Sign_verifyContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_sign_verify);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			sign_verify_op();
			setState(525);
			operand();
			setState(526);
			operand();
			setState(527);
			operand();
			setState(528);
			match(INTO);
			setState(529);
			register_access();
			setState(530);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastContext extends ParserRuleContext {
		public Cast_opContext cast_op() {
			return getRuleContext(Cast_opContext.class,0);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public Cast_destinationContext cast_destination() {
			return getRuleContext(Cast_destinationContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public CastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast; }
	}

	public final CastContext cast() throws RecognitionException {
		CastContext _localctx = new CastContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_cast);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			cast_op();
			setState(534); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(533);
					operand();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(536); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(538);
			match(INTO);
			setState(539);
			register_access();
			setState(540);
			match(AS);
			setState(541);
			cast_destination();
			setState(542);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(AleoParser.CALL, 0); }
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public LocatorContext locator() {
			return getRuleContext(LocatorContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public List<Register_accessContext> register_access() {
			return getRuleContexts(Register_accessContext.class);
		}
		public Register_accessContext register_access(int i) {
			return getRuleContext(Register_accessContext.class,i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_call);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			match(CALL);
			setState(547);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(545);
				locator();
				}
				break;
			case 2:
				{
				setState(546);
				identifier();
				}
				break;
			}
			setState(552);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(549);
					operand();
					}
					} 
				}
				setState(554);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(561);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTO) {
				{
				setState(555);
				match(INTO);
				setState(557); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(556);
					register_access();
					}
					}
					setState(559); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==REGISTER );
				}
			}

			setState(563);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class XasyncContext extends ParserRuleContext {
		public TerminalNode ASYNC() { return getToken(AleoParser.ASYNC, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public XasyncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xasync; }
	}

	public final XasyncContext xasync() throws RecognitionException {
		XasyncContext _localctx = new XasyncContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_xasync);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			match(ASYNC);
			setState(566);
			identifier();
			setState(570);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(567);
					operand();
					}
					} 
				}
				setState(572);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(573);
			match(INTO);
			setState(574);
			register_access();
			setState(575);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public Arithmetic_literalContext arithmetic_literal() {
			return getRuleContext(Arithmetic_literalContext.class,0);
		}
		public Address_literalContext address_literal() {
			return getRuleContext(Address_literalContext.class,0);
		}
		public Signature_literalContext signature_literal() {
			return getRuleContext(Signature_literalContext.class,0);
		}
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_literal);
		try {
			setState(581);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DS:
			case DIGITS:
				enterOuterAlt(_localctx, 1);
				{
				setState(577);
				arithmetic_literal();
				}
				break;
			case ADDRESS_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(578);
				address_literal();
				}
				break;
			case SIGNATURE_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(579);
				signature_literal();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(580);
				boolean_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Signed_literalContext extends ParserRuleContext {
		public TerminalNode DIGITS() { return getToken(AleoParser.DIGITS, 0); }
		public Signed_typeContext signed_type() {
			return getRuleContext(Signed_typeContext.class,0);
		}
		public TerminalNode DS() { return getToken(AleoParser.DS, 0); }
		public Signed_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_literal; }
	}

	public final Signed_literalContext signed_literal() throws RecognitionException {
		Signed_literalContext _localctx = new Signed_literalContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_signed_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DS) {
				{
				setState(583);
				match(DS);
				}
			}

			setState(586);
			match(DIGITS);
			setState(587);
			signed_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unsigned_literalContext extends ParserRuleContext {
		public TerminalNode DIGITS() { return getToken(AleoParser.DIGITS, 0); }
		public Unsigned_typeContext unsigned_type() {
			return getRuleContext(Unsigned_typeContext.class,0);
		}
		public TerminalNode DS() { return getToken(AleoParser.DS, 0); }
		public Unsigned_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_literal; }
	}

	public final Unsigned_literalContext unsigned_literal() throws RecognitionException {
		Unsigned_literalContext _localctx = new Unsigned_literalContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_unsigned_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DS) {
				{
				setState(589);
				match(DS);
				}
			}

			setState(592);
			match(DIGITS);
			setState(593);
			unsigned_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Integer_literalContext extends ParserRuleContext {
		public Signed_literalContext signed_literal() {
			return getRuleContext(Signed_literalContext.class,0);
		}
		public Unsigned_literalContext unsigned_literal() {
			return getRuleContext(Unsigned_literalContext.class,0);
		}
		public Integer_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_literal; }
	}

	public final Integer_literalContext integer_literal() throws RecognitionException {
		Integer_literalContext _localctx = new Integer_literalContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_integer_literal);
		try {
			setState(597);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(595);
				signed_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(596);
				unsigned_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_literalContext extends ParserRuleContext {
		public TerminalNode DIGITS() { return getToken(AleoParser.DIGITS, 0); }
		public Field_typeContext field_type() {
			return getRuleContext(Field_typeContext.class,0);
		}
		public TerminalNode DS() { return getToken(AleoParser.DS, 0); }
		public Field_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_literal; }
	}

	public final Field_literalContext field_literal() throws RecognitionException {
		Field_literalContext _localctx = new Field_literalContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_field_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DS) {
				{
				setState(599);
				match(DS);
				}
			}

			setState(602);
			match(DIGITS);
			setState(603);
			field_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Group_literalContext extends ParserRuleContext {
		public TerminalNode DIGITS() { return getToken(AleoParser.DIGITS, 0); }
		public Group_typeContext group_type() {
			return getRuleContext(Group_typeContext.class,0);
		}
		public TerminalNode DS() { return getToken(AleoParser.DS, 0); }
		public Group_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group_literal; }
	}

	public final Group_literalContext group_literal() throws RecognitionException {
		Group_literalContext _localctx = new Group_literalContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_group_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DS) {
				{
				setState(605);
				match(DS);
				}
			}

			setState(608);
			match(DIGITS);
			setState(609);
			group_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scalar_literalContext extends ParserRuleContext {
		public TerminalNode DIGITS() { return getToken(AleoParser.DIGITS, 0); }
		public Scalar_typeContext scalar_type() {
			return getRuleContext(Scalar_typeContext.class,0);
		}
		public TerminalNode DS() { return getToken(AleoParser.DS, 0); }
		public Scalar_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_literal; }
	}

	public final Scalar_literalContext scalar_literal() throws RecognitionException {
		Scalar_literalContext _localctx = new Scalar_literalContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_scalar_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DS) {
				{
				setState(611);
				match(DS);
				}
			}

			setState(614);
			match(DIGITS);
			setState(615);
			scalar_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Arithmetic_literalContext extends ParserRuleContext {
		public Integer_literalContext integer_literal() {
			return getRuleContext(Integer_literalContext.class,0);
		}
		public Field_literalContext field_literal() {
			return getRuleContext(Field_literalContext.class,0);
		}
		public Group_literalContext group_literal() {
			return getRuleContext(Group_literalContext.class,0);
		}
		public Scalar_literalContext scalar_literal() {
			return getRuleContext(Scalar_literalContext.class,0);
		}
		public Arithmetic_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_literal; }
	}

	public final Arithmetic_literalContext arithmetic_literal() throws RecognitionException {
		Arithmetic_literalContext _localctx = new Arithmetic_literalContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_arithmetic_literal);
		try {
			setState(621);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(617);
				integer_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(618);
				field_literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(619);
				group_literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(620);
				scalar_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Address_literalContext extends ParserRuleContext {
		public TerminalNode ADDRESS_LITERAL() { return getToken(AleoParser.ADDRESS_LITERAL, 0); }
		public Address_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_address_literal; }
	}

	public final Address_literalContext address_literal() throws RecognitionException {
		Address_literalContext _localctx = new Address_literalContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_address_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			match(ADDRESS_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Signature_literalContext extends ParserRuleContext {
		public TerminalNode SIGNATURE_LITERAL() { return getToken(AleoParser.SIGNATURE_LITERAL, 0); }
		public Signature_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature_literal; }
	}

	public final Signature_literalContext signature_literal() throws RecognitionException {
		Signature_literalContext _localctx = new Signature_literalContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_signature_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			match(SIGNATURE_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_literalContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(AleoParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(AleoParser.FALSE, 0); }
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unsigned_typeContext extends ParserRuleContext {
		public TerminalNode UNSIGNED_TYPE() { return getToken(AleoParser.UNSIGNED_TYPE, 0); }
		public Unsigned_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_type; }
	}

	public final Unsigned_typeContext unsigned_type() throws RecognitionException {
		Unsigned_typeContext _localctx = new Unsigned_typeContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_unsigned_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			match(UNSIGNED_TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Signed_typeContext extends ParserRuleContext {
		public TerminalNode SIGNED_TYPE() { return getToken(AleoParser.SIGNED_TYPE, 0); }
		public Signed_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_type; }
	}

	public final Signed_typeContext signed_type() throws RecognitionException {
		Signed_typeContext _localctx = new Signed_typeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_signed_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			match(SIGNED_TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Integer_typeContext extends ParserRuleContext {
		public Unsigned_typeContext unsigned_type() {
			return getRuleContext(Unsigned_typeContext.class,0);
		}
		public Signed_typeContext signed_type() {
			return getRuleContext(Signed_typeContext.class,0);
		}
		public Integer_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_type; }
	}

	public final Integer_typeContext integer_type() throws RecognitionException {
		Integer_typeContext _localctx = new Integer_typeContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_integer_type);
		try {
			setState(635);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNSIGNED_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(633);
				unsigned_type();
				}
				break;
			case SIGNED_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(634);
				signed_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_typeContext extends ParserRuleContext {
		public TerminalNode FIELD() { return getToken(AleoParser.FIELD, 0); }
		public Field_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_type; }
	}

	public final Field_typeContext field_type() throws RecognitionException {
		Field_typeContext _localctx = new Field_typeContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			match(FIELD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Group_typeContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(AleoParser.GROUP, 0); }
		public Group_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group_type; }
	}

	public final Group_typeContext group_type() throws RecognitionException {
		Group_typeContext _localctx = new Group_typeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_group_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			match(GROUP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scalar_typeContext extends ParserRuleContext {
		public TerminalNode SCALAR() { return getToken(AleoParser.SCALAR, 0); }
		public Scalar_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_type; }
	}

	public final Scalar_typeContext scalar_type() throws RecognitionException {
		Scalar_typeContext _localctx = new Scalar_typeContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_scalar_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			match(SCALAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Arithmetic_typeContext extends ParserRuleContext {
		public Integer_typeContext integer_type() {
			return getRuleContext(Integer_typeContext.class,0);
		}
		public Field_typeContext field_type() {
			return getRuleContext(Field_typeContext.class,0);
		}
		public Group_typeContext group_type() {
			return getRuleContext(Group_typeContext.class,0);
		}
		public Scalar_typeContext scalar_type() {
			return getRuleContext(Scalar_typeContext.class,0);
		}
		public Arithmetic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_type; }
	}

	public final Arithmetic_typeContext arithmetic_type() throws RecognitionException {
		Arithmetic_typeContext _localctx = new Arithmetic_typeContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_arithmetic_type);
		try {
			setState(647);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNSIGNED_TYPE:
			case SIGNED_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(643);
				integer_type();
				}
				break;
			case FIELD:
				enterOuterAlt(_localctx, 2);
				{
				setState(644);
				field_type();
				}
				break;
			case GROUP:
				enterOuterAlt(_localctx, 3);
				{
				setState(645);
				group_type();
				}
				break;
			case SCALAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(646);
				scalar_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Address_typeContext extends ParserRuleContext {
		public TerminalNode ADDRESS() { return getToken(AleoParser.ADDRESS, 0); }
		public Address_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_address_type; }
	}

	public final Address_typeContext address_type() throws RecognitionException {
		Address_typeContext _localctx = new Address_typeContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_address_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			match(ADDRESS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_typeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(AleoParser.BOOLEAN, 0); }
		public Boolean_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_type; }
	}

	public final Boolean_typeContext boolean_type() throws RecognitionException {
		Boolean_typeContext _localctx = new Boolean_typeContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_boolean_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
			match(BOOLEAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Signature_typeContext extends ParserRuleContext {
		public TerminalNode SIGNATURE() { return getToken(AleoParser.SIGNATURE, 0); }
		public Signature_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature_type; }
	}

	public final Signature_typeContext signature_type() throws RecognitionException {
		Signature_typeContext _localctx = new Signature_typeContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_signature_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			match(SIGNATURE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Literal_typeContext extends ParserRuleContext {
		public Arithmetic_typeContext arithmetic_type() {
			return getRuleContext(Arithmetic_typeContext.class,0);
		}
		public Address_typeContext address_type() {
			return getRuleContext(Address_typeContext.class,0);
		}
		public Signature_typeContext signature_type() {
			return getRuleContext(Signature_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public Literal_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_type; }
	}

	public final Literal_typeContext literal_type() throws RecognitionException {
		Literal_typeContext _localctx = new Literal_typeContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_literal_type);
		try {
			setState(659);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GROUP:
			case UNSIGNED_TYPE:
			case SIGNED_TYPE:
			case FIELD:
			case SCALAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(655);
				arithmetic_type();
				}
				break;
			case ADDRESS:
				enterOuterAlt(_localctx, 2);
				{
				setState(656);
				address_type();
				}
				break;
			case SIGNATURE:
				enterOuterAlt(_localctx, 3);
				{
				setState(657);
				signature_type();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(658);
				boolean_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_typeContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(AleoParser.LB, 0); }
		public Plaintext_typeContext plaintext_type() {
			return getRuleContext(Plaintext_typeContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public Unsigned_literalContext unsigned_literal() {
			return getRuleContext(Unsigned_literalContext.class,0);
		}
		public TerminalNode RB() { return getToken(AleoParser.RB, 0); }
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_array_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
			match(LB);
			setState(662);
			plaintext_type();
			setState(663);
			match(SC);
			setState(664);
			unsigned_literal();
			setState(665);
			match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Plaintext_typeContext extends ParserRuleContext {
		public Literal_typeContext literal_type() {
			return getRuleContext(Literal_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Plaintext_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plaintext_type; }
	}

	public final Plaintext_typeContext plaintext_type() throws RecognitionException {
		Plaintext_typeContext _localctx = new Plaintext_typeContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_plaintext_type);
		try {
			setState(670);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(667);
				literal_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(668);
				array_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(669);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_typeContext extends ParserRuleContext {
		public Plaintext_typeContext plaintext_type() {
			return getRuleContext(Plaintext_typeContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LocatorContext locator() {
			return getRuleContext(LocatorContext.class,0);
		}
		public Value_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_type; }
	}

	public final Value_typeContext value_type() throws RecognitionException {
		Value_typeContext _localctx = new Value_typeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_value_type);
		try {
			setState(681);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(672);
				plaintext_type();
				setState(673);
				modifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(675);
				identifier();
				setState(676);
				modifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(678);
				locator();
				setState(679);
				modifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mapping_typeContext extends ParserRuleContext {
		public Plaintext_typeContext plaintext_type() {
			return getRuleContext(Plaintext_typeContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public Mapping_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping_type; }
	}

	public final Mapping_typeContext mapping_type() throws RecognitionException {
		Mapping_typeContext _localctx = new Mapping_typeContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_mapping_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
			plaintext_type();
			setState(684);
			modifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Finalize_typeContext extends ParserRuleContext {
		public Plaintext_typeContext plaintext_type() {
			return getRuleContext(Plaintext_typeContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public LocatorContext locator() {
			return getRuleContext(LocatorContext.class,0);
		}
		public Finalize_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalize_type; }
	}

	public final Finalize_typeContext finalize_type() throws RecognitionException {
		Finalize_typeContext _localctx = new Finalize_typeContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_finalize_type);
		try {
			setState(692);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(686);
				plaintext_type();
				setState(687);
				modifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(689);
				locator();
				setState(690);
				modifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Entry_typeContext extends ParserRuleContext {
		public Plaintext_typeContext plaintext_type() {
			return getRuleContext(Plaintext_typeContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public Entry_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry_type; }
	}

	public final Entry_typeContext entry_type() throws RecognitionException {
		Entry_typeContext _localctx = new Entry_typeContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_entry_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			plaintext_type();
			setState(695);
			modifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Register_typeContext extends ParserRuleContext {
		public LocatorContext locator() {
			return getRuleContext(LocatorContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Plaintext_typeContext plaintext_type() {
			return getRuleContext(Plaintext_typeContext.class,0);
		}
		public Register_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register_type; }
	}

	public final Register_typeContext register_type() throws RecognitionException {
		Register_typeContext _localctx = new Register_typeContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_register_type);
		try {
			setState(704);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(697);
				locator();
				setState(698);
				modifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(700);
				identifier();
				setState(701);
				modifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(703);
				plaintext_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode CONSTANT() { return getToken(AleoParser.CONSTANT, 0); }
		public TerminalNode PRIVATE() { return getToken(AleoParser.PRIVATE, 0); }
		public TerminalNode PUBLIC() { return getToken(AleoParser.PUBLIC, 0); }
		public TerminalNode RECORD() { return getToken(AleoParser.RECORD, 0); }
		public TerminalNode FUTURE() { return getToken(AleoParser.FUTURE, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			match(DOT);
			setState(707);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 126976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Program_idContext extends ParserRuleContext {
		public Program_nameContext program_name() {
			return getRuleContext(Program_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public Program_domainContext program_domain() {
			return getRuleContext(Program_domainContext.class,0);
		}
		public Program_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_id; }
	}

	public final Program_idContext program_id() throws RecognitionException {
		Program_idContext _localctx = new Program_idContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_program_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(709);
			program_name();
			setState(710);
			match(DOT);
			setState(711);
			program_domain();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Program_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Program_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_name; }
	}

	public final Program_nameContext program_name() throws RecognitionException {
		Program_nameContext _localctx = new Program_nameContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_program_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(713);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Program_domainContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Program_domainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_domain; }
	}

	public final Program_domainContext program_domain() throws RecognitionException {
		Program_domainContext _localctx = new Program_domainContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_program_domain);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RegisterContext extends ParserRuleContext {
		public TerminalNode REGISTER() { return getToken(AleoParser.REGISTER, 0); }
		public RegisterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register; }
	}

	public final RegisterContext register() throws RecognitionException {
		RegisterContext _localctx = new RegisterContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			match(REGISTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Register_accessContext extends ParserRuleContext {
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public List<Register_accessorContext> register_accessor() {
			return getRuleContexts(Register_accessorContext.class);
		}
		public Register_accessorContext register_accessor(int i) {
			return getRuleContext(Register_accessorContext.class,i);
		}
		public Register_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register_access; }
	}

	public final Register_accessContext register_access() throws RecognitionException {
		Register_accessContext _localctx = new Register_accessContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_register_access);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
			register();
			setState(723);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==LB) {
				{
				{
				setState(720);
				register_accessor();
				}
				}
				setState(725);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Register_accessorContext extends ParserRuleContext {
		public Access_by_fieldContext access_by_field() {
			return getRuleContext(Access_by_fieldContext.class,0);
		}
		public Access_by_indexContext access_by_index() {
			return getRuleContext(Access_by_indexContext.class,0);
		}
		public Register_accessorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register_accessor; }
	}

	public final Register_accessorContext register_accessor() throws RecognitionException {
		Register_accessorContext _localctx = new Register_accessorContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_register_accessor);
		try {
			setState(728);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(726);
				access_by_field();
				}
				break;
			case LB:
				enterOuterAlt(_localctx, 2);
				{
				setState(727);
				access_by_index();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Access_by_fieldContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Access_by_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access_by_field; }
	}

	public final Access_by_fieldContext access_by_field() throws RecognitionException {
		Access_by_fieldContext _localctx = new Access_by_fieldContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_access_by_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			match(DOT);
			setState(731);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Access_by_indexContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(AleoParser.LB, 0); }
		public Unsigned_literalContext unsigned_literal() {
			return getRuleContext(Unsigned_literalContext.class,0);
		}
		public TerminalNode RB() { return getToken(AleoParser.RB, 0); }
		public TerminalNode DIGITS() { return getToken(AleoParser.DIGITS, 0); }
		public Access_by_indexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access_by_index; }
	}

	public final Access_by_indexContext access_by_index() throws RecognitionException {
		Access_by_indexContext _localctx = new Access_by_indexContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_access_by_index);
		try {
			setState(740);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(733);
				match(LB);
				setState(734);
				unsigned_literal();
				setState(735);
				match(RB);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(737);
				match(LB);
				setState(738);
				match(DIGITS);
				setState(739);
				match(RB);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperandContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Register_accessContext register_access() {
			return getRuleContext(Register_accessContext.class,0);
		}
		public Program_idContext program_id() {
			return getRuleContext(Program_idContext.class,0);
		}
		public Operand_presetContext operand_preset() {
			return getRuleContext(Operand_presetContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_operand);
		try {
			setState(746);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(742);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(743);
				register_access();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(744);
				program_id();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(745);
				operand_preset();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Operand_presetContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(AleoParser.GROUP, 0); }
		public TerminalNode CC() { return getToken(AleoParser.CC, 0); }
		public TerminalNode GEN() { return getToken(AleoParser.GEN, 0); }
		public TerminalNode SELF() { return getToken(AleoParser.SELF, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode SIGNER() { return getToken(AleoParser.SIGNER, 0); }
		public TerminalNode CALLER() { return getToken(AleoParser.CALLER, 0); }
		public TerminalNode BLOCK() { return getToken(AleoParser.BLOCK, 0); }
		public TerminalNode HEIGHT() { return getToken(AleoParser.HEIGHT, 0); }
		public Operand_presetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand_preset; }
	}

	public final Operand_presetContext operand_preset() throws RecognitionException {
		Operand_presetContext _localctx = new Operand_presetContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_operand_preset);
		int _la;
		try {
			setState(757);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GROUP:
				enterOuterAlt(_localctx, 1);
				{
				setState(748);
				match(GROUP);
				setState(749);
				match(CC);
				setState(750);
				match(GEN);
				}
				break;
			case SELF:
				enterOuterAlt(_localctx, 2);
				{
				setState(751);
				match(SELF);
				setState(752);
				match(DOT);
				setState(753);
				_la = _input.LA(1);
				if ( !(_la==SIGNER || _la==CALLER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case BLOCK:
				enterOuterAlt(_localctx, 3);
				{
				setState(754);
				match(BLOCK);
				setState(755);
				match(DOT);
				setState(756);
				match(HEIGHT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public Plaintext_typeContext plaintext_type() {
			return getRuleContext(Plaintext_typeContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_tuple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(759);
			identifier();
			setState(760);
			match(AS);
			setState(761);
			plaintext_type();
			setState(762);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EntryContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public Entry_typeContext entry_type() {
			return getRuleContext(Entry_typeContext.class,0);
		}
		public TerminalNode SC() { return getToken(AleoParser.SC, 0); }
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_entry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(764);
			identifier();
			setState(765);
			match(AS);
			setState(766);
			entry_type();
			setState(767);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocatorContext extends ParserRuleContext {
		public Program_idContext program_id() {
			return getRuleContext(Program_idContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(AleoParser.SLASH, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LocatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_locator; }
	}

	public final LocatorContext locator() throws RecognitionException {
		LocatorContext _localctx = new LocatorContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_locator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(769);
			program_id();
			setState(770);
			match(SLASH);
			setState(771);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cast_destinationContext extends ParserRuleContext {
		public Register_typeContext register_type() {
			return getRuleContext(Register_typeContext.class,0);
		}
		public LocatorContext locator() {
			return getRuleContext(LocatorContext.class,0);
		}
		public Destination_groupContext destination_group() {
			return getRuleContext(Destination_groupContext.class,0);
		}
		public Cast_destinationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_destination; }
	}

	public final Cast_destinationContext cast_destination() throws RecognitionException {
		Cast_destinationContext _localctx = new Cast_destinationContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_cast_destination);
		try {
			setState(776);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(773);
				register_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(774);
				locator();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(775);
				destination_group();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Destination_groupContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(AleoParser.GROUP, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode X() { return getToken(AleoParser.X, 0); }
		public TerminalNode Y() { return getToken(AleoParser.Y, 0); }
		public Destination_groupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destination_group; }
	}

	public final Destination_groupContext destination_group() throws RecognitionException {
		Destination_groupContext _localctx = new Destination_groupContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_destination_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			match(GROUP);
			setState(779);
			match(DOT);
			setState(780);
			_la = _input.LA(1);
			if ( !(_la==X || _la==Y) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_opContext extends ParserRuleContext {
		public TerminalNode ABS() { return getToken(AleoParser.ABS, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode W() { return getToken(AleoParser.W, 0); }
		public TerminalNode DOUBLE() { return getToken(AleoParser.DOUBLE, 0); }
		public TerminalNode INV() { return getToken(AleoParser.INV, 0); }
		public TerminalNode NEG() { return getToken(AleoParser.NEG, 0); }
		public TerminalNode NOT() { return getToken(AleoParser.NOT, 0); }
		public TerminalNode SQUARE() { return getToken(AleoParser.SQUARE, 0); }
		public TerminalNode SQRT() { return getToken(AleoParser.SQRT, 0); }
		public Unary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_op; }
	}

	public final Unary_opContext unary_op() throws RecognitionException {
		Unary_opContext _localctx = new Unary_opContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_unary_op);
		int _la;
		try {
			setState(793);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABS:
				enterOuterAlt(_localctx, 1);
				{
				setState(782);
				match(ABS);
				setState(785);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(783);
					match(DOT);
					setState(784);
					match(W);
					}
				}

				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(787);
				match(DOUBLE);
				}
				break;
			case INV:
				enterOuterAlt(_localctx, 3);
				{
				setState(788);
				match(INV);
				}
				break;
			case NEG:
				enterOuterAlt(_localctx, 4);
				{
				setState(789);
				match(NEG);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 5);
				{
				setState(790);
				match(NOT);
				}
				break;
			case SQUARE:
				enterOuterAlt(_localctx, 6);
				{
				setState(791);
				match(SQUARE);
				}
				break;
			case SQRT:
				enterOuterAlt(_localctx, 7);
				{
				setState(792);
				match(SQRT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Binary_opContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(AleoParser.ADD, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode W() { return getToken(AleoParser.W, 0); }
		public TerminalNode SUB() { return getToken(AleoParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(AleoParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(AleoParser.DIV, 0); }
		public TerminalNode REM() { return getToken(AleoParser.REM, 0); }
		public TerminalNode POW() { return getToken(AleoParser.POW, 0); }
		public TerminalNode SHL() { return getToken(AleoParser.SHL, 0); }
		public TerminalNode SHR() { return getToken(AleoParser.SHR, 0); }
		public TerminalNode MOD() { return getToken(AleoParser.MOD, 0); }
		public TerminalNode AND() { return getToken(AleoParser.AND, 0); }
		public TerminalNode OR() { return getToken(AleoParser.OR, 0); }
		public TerminalNode XOR() { return getToken(AleoParser.XOR, 0); }
		public TerminalNode NAND() { return getToken(AleoParser.NAND, 0); }
		public TerminalNode NOR() { return getToken(AleoParser.NOR, 0); }
		public TerminalNode GT() { return getToken(AleoParser.GT, 0); }
		public TerminalNode GTE() { return getToken(AleoParser.GTE, 0); }
		public TerminalNode LT() { return getToken(AleoParser.LT, 0); }
		public TerminalNode LTE() { return getToken(AleoParser.LTE, 0); }
		public Binary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_op; }
	}

	public final Binary_opContext binary_op() throws RecognitionException {
		Binary_opContext _localctx = new Binary_opContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_binary_op);
		int _la;
		try {
			setState(845);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(795);
				match(ADD);
				setState(798);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(796);
					match(DOT);
					setState(797);
					match(W);
					}
				}

				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(800);
				match(SUB);
				setState(803);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(801);
					match(DOT);
					setState(802);
					match(W);
					}
				}

				}
				break;
			case MUL:
				enterOuterAlt(_localctx, 3);
				{
				setState(805);
				match(MUL);
				setState(808);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(806);
					match(DOT);
					setState(807);
					match(W);
					}
				}

				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 4);
				{
				setState(810);
				match(DIV);
				setState(813);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(811);
					match(DOT);
					setState(812);
					match(W);
					}
				}

				}
				break;
			case REM:
				enterOuterAlt(_localctx, 5);
				{
				setState(815);
				match(REM);
				setState(818);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(816);
					match(DOT);
					setState(817);
					match(W);
					}
				}

				}
				break;
			case POW:
				enterOuterAlt(_localctx, 6);
				{
				setState(820);
				match(POW);
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(821);
					match(DOT);
					setState(822);
					match(W);
					}
				}

				}
				break;
			case SHL:
				enterOuterAlt(_localctx, 7);
				{
				setState(825);
				match(SHL);
				setState(828);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(826);
					match(DOT);
					setState(827);
					match(W);
					}
				}

				}
				break;
			case SHR:
				enterOuterAlt(_localctx, 8);
				{
				setState(830);
				match(SHR);
				setState(833);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(831);
					match(DOT);
					setState(832);
					match(W);
					}
				}

				}
				break;
			case MOD:
				enterOuterAlt(_localctx, 9);
				{
				setState(835);
				match(MOD);
				}
				break;
			case AND:
				enterOuterAlt(_localctx, 10);
				{
				setState(836);
				match(AND);
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 11);
				{
				setState(837);
				match(OR);
				}
				break;
			case XOR:
				enterOuterAlt(_localctx, 12);
				{
				setState(838);
				match(XOR);
				}
				break;
			case NAND:
				enterOuterAlt(_localctx, 13);
				{
				setState(839);
				match(NAND);
				}
				break;
			case NOR:
				enterOuterAlt(_localctx, 14);
				{
				setState(840);
				match(NOR);
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 15);
				{
				setState(841);
				match(GT);
				}
				break;
			case GTE:
				enterOuterAlt(_localctx, 16);
				{
				setState(842);
				match(GTE);
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 17);
				{
				setState(843);
				match(LT);
				}
				break;
			case LTE:
				enterOuterAlt(_localctx, 18);
				{
				setState(844);
				match(LTE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Is_opContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(AleoParser.IS, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode EQ() { return getToken(AleoParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(AleoParser.NEQ, 0); }
		public Is_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_op; }
	}

	public final Is_opContext is_op() throws RecognitionException {
		Is_opContext _localctx = new Is_opContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_is_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(847);
			match(IS);
			setState(848);
			match(DOT);
			setState(849);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==NEQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Assert_opContext extends ParserRuleContext {
		public TerminalNode ASSERT() { return getToken(AleoParser.ASSERT, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode EQ() { return getToken(AleoParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(AleoParser.NEQ, 0); }
		public Assert_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assert_op; }
	}

	public final Assert_opContext assert_op() throws RecognitionException {
		Assert_opContext _localctx = new Assert_opContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_assert_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(851);
			match(ASSERT);
			setState(852);
			match(DOT);
			setState(853);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==NEQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Commit_opContext extends ParserRuleContext {
		public TerminalNode COMMIT() { return getToken(AleoParser.COMMIT, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode BHP256() { return getToken(AleoParser.BHP256, 0); }
		public TerminalNode BHP512() { return getToken(AleoParser.BHP512, 0); }
		public TerminalNode BHP768() { return getToken(AleoParser.BHP768, 0); }
		public TerminalNode BHP1024() { return getToken(AleoParser.BHP1024, 0); }
		public TerminalNode PED64() { return getToken(AleoParser.PED64, 0); }
		public TerminalNode PED128() { return getToken(AleoParser.PED128, 0); }
		public Commit_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commit_op; }
	}

	public final Commit_opContext commit_op() throws RecognitionException {
		Commit_opContext _localctx = new Commit_opContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_commit_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(855);
			match(COMMIT);
			setState(856);
			match(DOT);
			setState(857);
			_la = _input.LA(1);
			if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 63L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Hash1_opContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(AleoParser.HASH, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode BHP256() { return getToken(AleoParser.BHP256, 0); }
		public TerminalNode BHP512() { return getToken(AleoParser.BHP512, 0); }
		public TerminalNode BHP768() { return getToken(AleoParser.BHP768, 0); }
		public TerminalNode BHP1024() { return getToken(AleoParser.BHP1024, 0); }
		public TerminalNode PED64() { return getToken(AleoParser.PED64, 0); }
		public TerminalNode PED128() { return getToken(AleoParser.PED128, 0); }
		public TerminalNode PSD2() { return getToken(AleoParser.PSD2, 0); }
		public TerminalNode PSD4() { return getToken(AleoParser.PSD4, 0); }
		public TerminalNode PSD8() { return getToken(AleoParser.PSD8, 0); }
		public TerminalNode KECCAK256() { return getToken(AleoParser.KECCAK256, 0); }
		public TerminalNode KECCAK384() { return getToken(AleoParser.KECCAK384, 0); }
		public TerminalNode KECCAK512() { return getToken(AleoParser.KECCAK512, 0); }
		public TerminalNode SHA3_256() { return getToken(AleoParser.SHA3_256, 0); }
		public TerminalNode SHA3_384() { return getToken(AleoParser.SHA3_384, 0); }
		public TerminalNode SHA3_512() { return getToken(AleoParser.SHA3_512, 0); }
		public Hash1_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hash1_op; }
	}

	public final Hash1_opContext hash1_op() throws RecognitionException {
		Hash1_opContext _localctx = new Hash1_opContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_hash1_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(859);
			match(HASH);
			setState(860);
			match(DOT);
			setState(861);
			_la = _input.LA(1);
			if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 32767L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Hash2_opContext extends ParserRuleContext {
		public TerminalNode HASH_MANY() { return getToken(AleoParser.HASH_MANY, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode PSD2() { return getToken(AleoParser.PSD2, 0); }
		public TerminalNode PSD4() { return getToken(AleoParser.PSD4, 0); }
		public TerminalNode PSD8() { return getToken(AleoParser.PSD8, 0); }
		public Hash2_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hash2_op; }
	}

	public final Hash2_opContext hash2_op() throws RecognitionException {
		Hash2_opContext _localctx = new Hash2_opContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_hash2_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(863);
			match(HASH_MANY);
			setState(864);
			match(DOT);
			setState(865);
			_la = _input.LA(1);
			if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cast_opContext extends ParserRuleContext {
		public TerminalNode CAST() { return getToken(AleoParser.CAST, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode LOSSY() { return getToken(AleoParser.LOSSY, 0); }
		public Cast_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_op; }
	}

	public final Cast_opContext cast_op() throws RecognitionException {
		Cast_opContext _localctx = new Cast_opContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_cast_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(867);
			match(CAST);
			setState(870);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(868);
				match(DOT);
				setState(869);
				match(LOSSY);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Branch_opContext extends ParserRuleContext {
		public TerminalNode BRANCH() { return getToken(AleoParser.BRANCH, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode EQ() { return getToken(AleoParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(AleoParser.NEQ, 0); }
		public Branch_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch_op; }
	}

	public final Branch_opContext branch_op() throws RecognitionException {
		Branch_opContext _localctx = new Branch_opContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_branch_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872);
			match(BRANCH);
			setState(873);
			match(DOT);
			setState(874);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==NEQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Random_opContext extends ParserRuleContext {
		public TerminalNode RAND() { return getToken(AleoParser.RAND, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode CHACHA() { return getToken(AleoParser.CHACHA, 0); }
		public Random_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_random_op; }
	}

	public final Random_opContext random_op() throws RecognitionException {
		Random_opContext _localctx = new Random_opContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_random_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(876);
			match(RAND);
			setState(877);
			match(DOT);
			setState(878);
			match(CHACHA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Get_or_use_opContext extends ParserRuleContext {
		public TerminalNode GET() { return getToken(AleoParser.GET, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode OR_USE() { return getToken(AleoParser.OR_USE, 0); }
		public Get_or_use_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_get_or_use_op; }
	}

	public final Get_or_use_opContext get_or_use_op() throws RecognitionException {
		Get_or_use_opContext _localctx = new Get_or_use_opContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_get_or_use_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(880);
			match(GET);
			setState(881);
			match(DOT);
			setState(882);
			match(OR_USE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Sign_verify_opContext extends ParserRuleContext {
		public TerminalNode SIGN() { return getToken(AleoParser.SIGN, 0); }
		public TerminalNode DOT() { return getToken(AleoParser.DOT, 0); }
		public TerminalNode VERIFY() { return getToken(AleoParser.VERIFY, 0); }
		public TerminalNode SIGN_VERIFY() { return getToken(AleoParser.SIGN_VERIFY, 0); }
		public Sign_verify_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign_verify_op; }
	}

	public final Sign_verify_opContext sign_verify_op() throws RecognitionException {
		Sign_verify_opContext _localctx = new Sign_verify_opContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_sign_verify_op);
		try {
			setState(888);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(884);
				match(SIGN);
				setState(885);
				match(DOT);
				setState(886);
				match(VERIFY);
				}
				break;
			case SIGN_VERIFY:
				enterOuterAlt(_localctx, 2);
				{
				setState(887);
				match(SIGN_VERIFY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AleoParser.IDENTIFIER, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AleoParser.IDENTIFIER, 0); }
		public TerminalNode AS() { return getToken(AleoParser.AS, 0); }
		public TerminalNode INTO() { return getToken(AleoParser.INTO, 0); }
		public TerminalNode TO() { return getToken(AleoParser.TO, 0); }
		public TerminalNode PUBLIC() { return getToken(AleoParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(AleoParser.PRIVATE, 0); }
		public TerminalNode CONSTANT() { return getToken(AleoParser.CONSTANT, 0); }
		public TerminalNode FUTURE() { return getToken(AleoParser.FUTURE, 0); }
		public TerminalNode RECORD() { return getToken(AleoParser.RECORD, 0); }
		public TerminalNode GROUP() { return getToken(AleoParser.GROUP, 0); }
		public TerminalNode GEN() { return getToken(AleoParser.GEN, 0); }
		public TerminalNode SELF() { return getToken(AleoParser.SELF, 0); }
		public TerminalNode SIGNER() { return getToken(AleoParser.SIGNER, 0); }
		public TerminalNode CALLER() { return getToken(AleoParser.CALLER, 0); }
		public TerminalNode BLOCK() { return getToken(AleoParser.BLOCK, 0); }
		public TerminalNode HEIGHT() { return getToken(AleoParser.HEIGHT, 0); }
		public TerminalNode W() { return getToken(AleoParser.W, 0); }
		public TerminalNode X() { return getToken(AleoParser.X, 0); }
		public TerminalNode Y() { return getToken(AleoParser.Y, 0); }
		public TerminalNode CONTAINS() { return getToken(AleoParser.CONTAINS, 0); }
		public TerminalNode GET() { return getToken(AleoParser.GET, 0); }
		public TerminalNode OR_USE() { return getToken(AleoParser.OR_USE, 0); }
		public TerminalNode SET() { return getToken(AleoParser.SET, 0); }
		public TerminalNode REMOVE() { return getToken(AleoParser.REMOVE, 0); }
		public TerminalNode RAND() { return getToken(AleoParser.RAND, 0); }
		public TerminalNode CHACHA() { return getToken(AleoParser.CHACHA, 0); }
		public TerminalNode POSITION() { return getToken(AleoParser.POSITION, 0); }
		public TerminalNode AWAIT() { return getToken(AleoParser.AWAIT, 0); }
		public TerminalNode TERNARY() { return getToken(AleoParser.TERNARY, 0); }
		public TerminalNode SIGN() { return getToken(AleoParser.SIGN, 0); }
		public TerminalNode VERIFY() { return getToken(AleoParser.VERIFY, 0); }
		public TerminalNode SIGN_VERIFY() { return getToken(AleoParser.SIGN_VERIFY, 0); }
		public TerminalNode CALL() { return getToken(AleoParser.CALL, 0); }
		public TerminalNode ASYNC() { return getToken(AleoParser.ASYNC, 0); }
		public TerminalNode ABS() { return getToken(AleoParser.ABS, 0); }
		public TerminalNode DOUBLE() { return getToken(AleoParser.DOUBLE, 0); }
		public TerminalNode INV() { return getToken(AleoParser.INV, 0); }
		public TerminalNode NEG() { return getToken(AleoParser.NEG, 0); }
		public TerminalNode NOT() { return getToken(AleoParser.NOT, 0); }
		public TerminalNode SQUARE() { return getToken(AleoParser.SQUARE, 0); }
		public TerminalNode SQRT() { return getToken(AleoParser.SQRT, 0); }
		public TerminalNode ADD() { return getToken(AleoParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(AleoParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(AleoParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(AleoParser.DIV, 0); }
		public TerminalNode REM() { return getToken(AleoParser.REM, 0); }
		public TerminalNode POW() { return getToken(AleoParser.POW, 0); }
		public TerminalNode SHL() { return getToken(AleoParser.SHL, 0); }
		public TerminalNode SHR() { return getToken(AleoParser.SHR, 0); }
		public TerminalNode MOD() { return getToken(AleoParser.MOD, 0); }
		public TerminalNode AND() { return getToken(AleoParser.AND, 0); }
		public TerminalNode OR() { return getToken(AleoParser.OR, 0); }
		public TerminalNode XOR() { return getToken(AleoParser.XOR, 0); }
		public TerminalNode NAND() { return getToken(AleoParser.NAND, 0); }
		public TerminalNode NOR() { return getToken(AleoParser.NOR, 0); }
		public TerminalNode GT() { return getToken(AleoParser.GT, 0); }
		public TerminalNode GTE() { return getToken(AleoParser.GTE, 0); }
		public TerminalNode LT() { return getToken(AleoParser.LT, 0); }
		public TerminalNode LTE() { return getToken(AleoParser.LTE, 0); }
		public TerminalNode IS() { return getToken(AleoParser.IS, 0); }
		public TerminalNode EQ() { return getToken(AleoParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(AleoParser.NEQ, 0); }
		public TerminalNode ASSERT() { return getToken(AleoParser.ASSERT, 0); }
		public TerminalNode COMMIT() { return getToken(AleoParser.COMMIT, 0); }
		public TerminalNode HASH() { return getToken(AleoParser.HASH, 0); }
		public TerminalNode HASH_MANY() { return getToken(AleoParser.HASH_MANY, 0); }
		public TerminalNode BHP256() { return getToken(AleoParser.BHP256, 0); }
		public TerminalNode BHP512() { return getToken(AleoParser.BHP512, 0); }
		public TerminalNode BHP768() { return getToken(AleoParser.BHP768, 0); }
		public TerminalNode BHP1024() { return getToken(AleoParser.BHP1024, 0); }
		public TerminalNode PED64() { return getToken(AleoParser.PED64, 0); }
		public TerminalNode PED128() { return getToken(AleoParser.PED128, 0); }
		public TerminalNode PSD2() { return getToken(AleoParser.PSD2, 0); }
		public TerminalNode PSD4() { return getToken(AleoParser.PSD4, 0); }
		public TerminalNode PSD8() { return getToken(AleoParser.PSD8, 0); }
		public TerminalNode KECCAK256() { return getToken(AleoParser.KECCAK256, 0); }
		public TerminalNode KECCAK384() { return getToken(AleoParser.KECCAK384, 0); }
		public TerminalNode KECCAK512() { return getToken(AleoParser.KECCAK512, 0); }
		public TerminalNode SHA3_256() { return getToken(AleoParser.SHA3_256, 0); }
		public TerminalNode SHA3_384() { return getToken(AleoParser.SHA3_384, 0); }
		public TerminalNode SHA3_512() { return getToken(AleoParser.SHA3_512, 0); }
		public TerminalNode CAST() { return getToken(AleoParser.CAST, 0); }
		public TerminalNode LOSSY() { return getToken(AleoParser.LOSSY, 0); }
		public TerminalNode BRANCH() { return getToken(AleoParser.BRANCH, 0); }
		public TerminalNode PROGRAM() { return getToken(AleoParser.PROGRAM, 0); }
		public TerminalNode IMPORT() { return getToken(AleoParser.IMPORT, 0); }
		public TerminalNode MAPPING() { return getToken(AleoParser.MAPPING, 0); }
		public TerminalNode KEY() { return getToken(AleoParser.KEY, 0); }
		public TerminalNode VALUE() { return getToken(AleoParser.VALUE, 0); }
		public TerminalNode STRUCT() { return getToken(AleoParser.STRUCT, 0); }
		public TerminalNode CLOSURE() { return getToken(AleoParser.CLOSURE, 0); }
		public TerminalNode INPUT() { return getToken(AleoParser.INPUT, 0); }
		public TerminalNode OUTPUT() { return getToken(AleoParser.OUTPUT, 0); }
		public TerminalNode FUNCTION() { return getToken(AleoParser.FUNCTION, 0); }
		public TerminalNode FINALIZE() { return getToken(AleoParser.FINALIZE, 0); }
		public TerminalNode TRUE() { return getToken(AleoParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(AleoParser.FALSE, 0); }
		public TerminalNode UNSIGNED_TYPE() { return getToken(AleoParser.UNSIGNED_TYPE, 0); }
		public TerminalNode SIGNED_TYPE() { return getToken(AleoParser.SIGNED_TYPE, 0); }
		public TerminalNode FIELD() { return getToken(AleoParser.FIELD, 0); }
		public TerminalNode SCALAR() { return getToken(AleoParser.SCALAR, 0); }
		public TerminalNode ADDRESS() { return getToken(AleoParser.ADDRESS, 0); }
		public TerminalNode BOOLEAN() { return getToken(AleoParser.BOOLEAN, 0); }
		public TerminalNode SIGNATURE() { return getToken(AleoParser.SIGNATURE, 0); }
		public TerminalNode ADDRESS_LITERAL() { return getToken(AleoParser.ADDRESS_LITERAL, 0); }
		public TerminalNode SIGNATURE_LITERAL() { return getToken(AleoParser.SIGNATURE_LITERAL, 0); }
		public TerminalNode REGISTER() { return getToken(AleoParser.REGISTER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(892);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -512L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 7881299347898367L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001w\u037f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"+
		"Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0002"+
		"_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0005\u0001\u00ca\b\u0001\n\u0001\f\u0001\u00cd\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0004\u0001\u00d7\b\u0001\u000b\u0001\f\u0001\u00d8"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0004\u0006\u00f3\b\u0006\u000b\u0006\f\u0006\u00f4\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00fb\b\u0007\n\u0007\f\u0007"+
		"\u00fe\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0104\b\b\n\b\f"+
		"\b\u0107\t\b\u0001\b\u0004\b\u010a\b\b\u000b\b\f\b\u010b\u0001\b\u0005"+
		"\b\u010f\b\b\n\b\f\b\u0112\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0124\b\u000b\n\u000b\f\u000b"+
		"\u0127\t\u000b\u0001\u000b\u0005\u000b\u012a\b\u000b\n\u000b\f\u000b\u012d"+
		"\t\u000b\u0001\u000b\u0005\u000b\u0130\b\u000b\n\u000b\f\u000b\u0133\t"+
		"\u000b\u0001\u000b\u0003\u000b\u0136\b\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0148\b\u000e\n"+
		"\u000e\f\u000e\u014b\t\u000e\u0001\u000e\u0004\u000e\u014e\b\u000e\u000b"+
		"\u000e\f\u000e\u014f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u0162\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u0192\b\u0016\n\u0016\f\u0016\u0195\t\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u019e\b\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u01bc\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 "+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u01e8\b \u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0003!\u01f6\b!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u0205\b\"\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0003#\u020b\b#\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001%\u0001%\u0004%\u0217\b%\u000b%\f%\u0218\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0003&\u0224"+
		"\b&\u0001&\u0005&\u0227\b&\n&\f&\u022a\t&\u0001&\u0001&\u0004&\u022e\b"+
		"&\u000b&\f&\u022f\u0003&\u0232\b&\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"\'\u0005\'\u0239\b\'\n\'\f\'\u023c\t\'\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001(\u0001(\u0001(\u0001(\u0003(\u0246\b(\u0001)\u0003)\u0249\b)\u0001"+
		")\u0001)\u0001)\u0001*\u0003*\u024f\b*\u0001*\u0001*\u0001*\u0001+\u0001"+
		"+\u0003+\u0256\b+\u0001,\u0003,\u0259\b,\u0001,\u0001,\u0001,\u0001-\u0003"+
		"-\u025f\b-\u0001-\u0001-\u0001-\u0001.\u0003.\u0265\b.\u0001.\u0001.\u0001"+
		".\u0001/\u0001/\u0001/\u0001/\u0003/\u026e\b/\u00010\u00010\u00011\u0001"+
		"1\u00012\u00012\u00013\u00013\u00014\u00014\u00015\u00015\u00035\u027c"+
		"\b5\u00016\u00016\u00017\u00017\u00018\u00018\u00019\u00019\u00019\u0001"+
		"9\u00039\u0288\b9\u0001:\u0001:\u0001;\u0001;\u0001<\u0001<\u0001=\u0001"+
		"=\u0001=\u0001=\u0003=\u0294\b=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		">\u0001?\u0001?\u0001?\u0003?\u029f\b?\u0001@\u0001@\u0001@\u0001@\u0001"+
		"@\u0001@\u0001@\u0001@\u0001@\u0003@\u02aa\b@\u0001A\u0001A\u0001A\u0001"+
		"B\u0001B\u0001B\u0001B\u0001B\u0001B\u0003B\u02b5\bB\u0001C\u0001C\u0001"+
		"C\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0003D\u02c1\bD\u0001"+
		"E\u0001E\u0001E\u0001F\u0001F\u0001F\u0001F\u0001G\u0001G\u0001H\u0001"+
		"H\u0001I\u0001I\u0001J\u0001J\u0005J\u02d2\bJ\nJ\fJ\u02d5\tJ\u0001K\u0001"+
		"K\u0003K\u02d9\bK\u0001L\u0001L\u0001L\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0001M\u0001M\u0003M\u02e5\bM\u0001N\u0001N\u0001N\u0001N\u0003N\u02eb"+
		"\bN\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0003"+
		"O\u02f6\bO\u0001P\u0001P\u0001P\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0001"+
		"Q\u0001Q\u0001R\u0001R\u0001R\u0001R\u0001S\u0001S\u0001S\u0003S\u0309"+
		"\bS\u0001T\u0001T\u0001T\u0001T\u0001U\u0001U\u0001U\u0003U\u0312\bU\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0001U\u0003U\u031a\bU\u0001V\u0001V\u0001"+
		"V\u0003V\u031f\bV\u0001V\u0001V\u0001V\u0003V\u0324\bV\u0001V\u0001V\u0001"+
		"V\u0003V\u0329\bV\u0001V\u0001V\u0001V\u0003V\u032e\bV\u0001V\u0001V\u0001"+
		"V\u0003V\u0333\bV\u0001V\u0001V\u0001V\u0003V\u0338\bV\u0001V\u0001V\u0001"+
		"V\u0003V\u033d\bV\u0001V\u0001V\u0001V\u0003V\u0342\bV\u0001V\u0001V\u0001"+
		"V\u0001V\u0001V\u0001V\u0001V\u0001V\u0001V\u0001V\u0003V\u034e\bV\u0001"+
		"W\u0001W\u0001W\u0001W\u0001X\u0001X\u0001X\u0001X\u0001Y\u0001Y\u0001"+
		"Y\u0001Y\u0001Z\u0001Z\u0001Z\u0001Z\u0001[\u0001[\u0001[\u0001[\u0001"+
		"\\\u0001\\\u0001\\\u0003\\\u0367\b\\\u0001]\u0001]\u0001]\u0001]\u0001"+
		"^\u0001^\u0001^\u0001^\u0001_\u0001_\u0001_\u0001_\u0001`\u0001`\u0001"+
		"`\u0001`\u0003`\u0379\b`\u0001a\u0001a\u0001b\u0001b\u0001b\u0000\u0000"+
		"c\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2"+
		"\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u0000\t\u0001\u0000"+
		"gh\u0001\u0000\f\u0010\u0001\u0000\u0014\u0015\u0001\u0000\u0019\u001a"+
		"\u0001\u0000DE\u0001\u0000JO\u0001\u0000JX\u0001\u0000PR\u0002\u0000\t"+
		"qst\u039a\u0000\u00c6\u0001\u0000\u0000\u0000\u0002\u00cb\u0001\u0000"+
		"\u0000\u0000\u0004\u00da\u0001\u0000\u0000\u0000\u0006\u00de\u0001\u0000"+
		"\u0000\u0000\b\u00e4\u0001\u0000\u0000\u0000\n\u00e9\u0001\u0000\u0000"+
		"\u0000\f\u00ee\u0001\u0000\u0000\u0000\u000e\u00f6\u0001\u0000\u0000\u0000"+
		"\u0010\u00ff\u0001\u0000\u0000\u0000\u0012\u0113\u0001\u0000\u0000\u0000"+
		"\u0014\u0119\u0001\u0000\u0000\u0000\u0016\u011f\u0001\u0000\u0000\u0000"+
		"\u0018\u0137\u0001\u0000\u0000\u0000\u001a\u013d\u0001\u0000\u0000\u0000"+
		"\u001c\u0143\u0001\u0000\u0000\u0000\u001e\u0151\u0001\u0000\u0000\u0000"+
		" \u0161\u0001\u0000\u0000\u0000\"\u0163\u0001\u0000\u0000\u0000$\u016c"+
		"\u0001\u0000\u0000\u0000&\u0175\u0001\u0000\u0000\u0000(\u017f\u0001\u0000"+
		"\u0000\u0000*\u0188\u0001\u0000\u0000\u0000,\u018f\u0001\u0000\u0000\u0000"+
		".\u01a1\u0001\u0000\u0000\u00000\u01a5\u0001\u0000\u0000\u00002\u01ac"+
		"\u0001\u0000\u0000\u00004\u01bb\u0001\u0000\u0000\u00006\u01bd\u0001\u0000"+
		"\u0000\u00008\u01c3\u0001\u0000\u0000\u0000:\u01ca\u0001\u0000\u0000\u0000"+
		"<\u01d2\u0001\u0000\u0000\u0000>\u01d9\u0001\u0000\u0000\u0000@\u01de"+
		"\u0001\u0000\u0000\u0000B\u01eb\u0001\u0000\u0000\u0000D\u01f9\u0001\u0000"+
		"\u0000\u0000F\u020a\u0001\u0000\u0000\u0000H\u020c\u0001\u0000\u0000\u0000"+
		"J\u0214\u0001\u0000\u0000\u0000L\u0220\u0001\u0000\u0000\u0000N\u0235"+
		"\u0001\u0000\u0000\u0000P\u0245\u0001\u0000\u0000\u0000R\u0248\u0001\u0000"+
		"\u0000\u0000T\u024e\u0001\u0000\u0000\u0000V\u0255\u0001\u0000\u0000\u0000"+
		"X\u0258\u0001\u0000\u0000\u0000Z\u025e\u0001\u0000\u0000\u0000\\\u0264"+
		"\u0001\u0000\u0000\u0000^\u026d\u0001\u0000\u0000\u0000`\u026f\u0001\u0000"+
		"\u0000\u0000b\u0271\u0001\u0000\u0000\u0000d\u0273\u0001\u0000\u0000\u0000"+
		"f\u0275\u0001\u0000\u0000\u0000h\u0277\u0001\u0000\u0000\u0000j\u027b"+
		"\u0001\u0000\u0000\u0000l\u027d\u0001\u0000\u0000\u0000n\u027f\u0001\u0000"+
		"\u0000\u0000p\u0281\u0001\u0000\u0000\u0000r\u0287\u0001\u0000\u0000\u0000"+
		"t\u0289\u0001\u0000\u0000\u0000v\u028b\u0001\u0000\u0000\u0000x\u028d"+
		"\u0001\u0000\u0000\u0000z\u0293\u0001\u0000\u0000\u0000|\u0295\u0001\u0000"+
		"\u0000\u0000~\u029e\u0001\u0000\u0000\u0000\u0080\u02a9\u0001\u0000\u0000"+
		"\u0000\u0082\u02ab\u0001\u0000\u0000\u0000\u0084\u02b4\u0001\u0000\u0000"+
		"\u0000\u0086\u02b6\u0001\u0000\u0000\u0000\u0088\u02c0\u0001\u0000\u0000"+
		"\u0000\u008a\u02c2\u0001\u0000\u0000\u0000\u008c\u02c5\u0001\u0000\u0000"+
		"\u0000\u008e\u02c9\u0001\u0000\u0000\u0000\u0090\u02cb\u0001\u0000\u0000"+
		"\u0000\u0092\u02cd\u0001\u0000\u0000\u0000\u0094\u02cf\u0001\u0000\u0000"+
		"\u0000\u0096\u02d8\u0001\u0000\u0000\u0000\u0098\u02da\u0001\u0000\u0000"+
		"\u0000\u009a\u02e4\u0001\u0000\u0000\u0000\u009c\u02ea\u0001\u0000\u0000"+
		"\u0000\u009e\u02f5\u0001\u0000\u0000\u0000\u00a0\u02f7\u0001\u0000\u0000"+
		"\u0000\u00a2\u02fc\u0001\u0000\u0000\u0000\u00a4\u0301\u0001\u0000\u0000"+
		"\u0000\u00a6\u0308\u0001\u0000\u0000\u0000\u00a8\u030a\u0001\u0000\u0000"+
		"\u0000\u00aa\u0319\u0001\u0000\u0000\u0000\u00ac\u034d\u0001\u0000\u0000"+
		"\u0000\u00ae\u034f\u0001\u0000\u0000\u0000\u00b0\u0353\u0001\u0000\u0000"+
		"\u0000\u00b2\u0357\u0001\u0000\u0000\u0000\u00b4\u035b\u0001\u0000\u0000"+
		"\u0000\u00b6\u035f\u0001\u0000\u0000\u0000\u00b8\u0363\u0001\u0000\u0000"+
		"\u0000\u00ba\u0368\u0001\u0000\u0000\u0000\u00bc\u036c\u0001\u0000\u0000"+
		"\u0000\u00be\u0370\u0001\u0000\u0000\u0000\u00c0\u0378\u0001\u0000\u0000"+
		"\u0000\u00c2\u037a\u0001\u0000\u0000\u0000\u00c4\u037c\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0003\u0002\u0001\u0000\u00c7\u0001\u0001\u0000\u0000"+
		"\u0000\u00c8\u00ca\u0003\u0004\u0002\u0000\u00c9\u00c8\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001\u0000\u0000"+
		"\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\\\u0000\u0000"+
		"\u00cf\u00d0\u0003\u008cF\u0000\u00d0\u00d6\u0005\u0005\u0000\u0000\u00d1"+
		"\u00d7\u0003\u0006\u0003\u0000\u00d2\u00d7\u0003\f\u0006\u0000\u00d3\u00d7"+
		"\u0003\u000e\u0007\u0000\u00d4\u00d7\u0003\u0010\b\u0000\u00d5\u00d7\u0003"+
		"\u0016\u000b\u0000\u00d6\u00d1\u0001\u0000\u0000\u0000\u00d6\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d9\u0003\u0001\u0000\u0000\u0000\u00da\u00db\u0005"+
		"]\u0000\u0000\u00db\u00dc\u0003\u008cF\u0000\u00dc\u00dd\u0005\u0005\u0000"+
		"\u0000\u00dd\u0005\u0001\u0000\u0000\u0000\u00de\u00df\u0005^\u0000\u0000"+
		"\u00df\u00e0\u0003\u00c4b\u0000\u00e0\u00e1\u0005\u0007\u0000\u0000\u00e1"+
		"\u00e2\u0003\b\u0004\u0000\u00e2\u00e3\u0003\n\u0005\u0000\u00e3\u0007"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005_\u0000\u0000\u00e5\u00e6\u0005"+
		"\t\u0000\u0000\u00e6\u00e7\u0003\u0082A\u0000\u00e7\u00e8\u0005\u0005"+
		"\u0000\u0000\u00e8\t\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005`\u0000"+
		"\u0000\u00ea\u00eb\u0005\t\u0000\u0000\u00eb\u00ec\u0003\u0082A\u0000"+
		"\u00ec\u00ed\u0005\u0005\u0000\u0000\u00ed\u000b\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0005a\u0000\u0000\u00ef\u00f0\u0003\u00c4b\u0000\u00f0\u00f2"+
		"\u0005\u0007\u0000\u0000\u00f1\u00f3\u0003\u00a0P\u0000\u00f2\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\r\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f7\u0005\u0010\u0000\u0000\u00f7\u00f8\u0003\u00c4"+
		"b\u0000\u00f8\u00fc\u0005\u0007\u0000\u0000\u00f9\u00fb\u0003\u00a2Q\u0000"+
		"\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000"+
		"\u00fd\u000f\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000"+
		"\u00ff\u0100\u0005b\u0000\u0000\u0100\u0101\u0003\u00c4b\u0000\u0101\u0105"+
		"\u0005\u0007\u0000\u0000\u0102\u0104\u0003\u0012\t\u0000\u0103\u0102\u0001"+
		"\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001"+
		"\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0109\u0001"+
		"\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u010a\u0003"+
		"4\u001a\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000"+
		"\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000"+
		"\u0000\u0000\u010c\u0110\u0001\u0000\u0000\u0000\u010d\u010f\u0003\u0014"+
		"\n\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010f\u0112\u0001\u0000\u0000"+
		"\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000"+
		"\u0000\u0111\u0011\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000"+
		"\u0000\u0113\u0114\u0005c\u0000\u0000\u0114\u0115\u0003\u0092I\u0000\u0115"+
		"\u0116\u0005\t\u0000\u0000\u0116\u0117\u0003\u0088D\u0000\u0117\u0118"+
		"\u0005\u0005\u0000\u0000\u0118\u0013\u0001\u0000\u0000\u0000\u0119\u011a"+
		"\u0005d\u0000\u0000\u011a\u011b\u0003\u009cN\u0000\u011b\u011c\u0005\t"+
		"\u0000\u0000\u011c\u011d\u0003\u0088D\u0000\u011d\u011e\u0005\u0005\u0000"+
		"\u0000\u011e\u0015\u0001\u0000\u0000\u0000\u011f\u0120\u0005e\u0000\u0000"+
		"\u0120\u0121\u0003\u00c4b\u0000\u0121\u0125\u0005\u0007\u0000\u0000\u0122"+
		"\u0124\u0003\u0018\f\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0124\u0127"+
		"\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126"+
		"\u0001\u0000\u0000\u0000\u0126\u012b\u0001\u0000\u0000\u0000\u0127\u0125"+
		"\u0001\u0000\u0000\u0000\u0128\u012a\u00034\u001a\u0000\u0129\u0128\u0001"+
		"\u0000\u0000\u0000\u012a\u012d\u0001\u0000\u0000\u0000\u012b\u0129\u0001"+
		"\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u0131\u0001"+
		"\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012e\u0130\u0003"+
		"\u001a\r\u0000\u012f\u012e\u0001\u0000\u0000\u0000\u0130\u0133\u0001\u0000"+
		"\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000"+
		"\u0000\u0000\u0132\u0135\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000"+
		"\u0000\u0000\u0134\u0136\u0003\u001c\u000e\u0000\u0135\u0134\u0001\u0000"+
		"\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0017\u0001\u0000"+
		"\u0000\u0000\u0137\u0138\u0005c\u0000\u0000\u0138\u0139\u0003\u0092I\u0000"+
		"\u0139\u013a\u0005\t\u0000\u0000\u013a\u013b\u0003\u0080@\u0000\u013b"+
		"\u013c\u0005\u0005\u0000\u0000\u013c\u0019\u0001\u0000\u0000\u0000\u013d"+
		"\u013e\u0005d\u0000\u0000\u013e\u013f\u0003\u009cN\u0000\u013f\u0140\u0005"+
		"\t\u0000\u0000\u0140\u0141\u0003\u0080@\u0000\u0141\u0142\u0005\u0005"+
		"\u0000\u0000\u0142\u001b\u0001\u0000\u0000\u0000\u0143\u0144\u0005f\u0000"+
		"\u0000\u0144\u0145\u0003\u00c4b\u0000\u0145\u0149\u0005\u0007\u0000\u0000"+
		"\u0146\u0148\u0003\u001e\u000f\u0000\u0147\u0146\u0001\u0000\u0000\u0000"+
		"\u0148\u014b\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000"+
		"\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014d\u0001\u0000\u0000\u0000"+
		"\u014b\u0149\u0001\u0000\u0000\u0000\u014c\u014e\u0003 \u0010\u0000\u014d"+
		"\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f"+
		"\u014d\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150"+
		"\u001d\u0001\u0000\u0000\u0000\u0151\u0152\u0005c\u0000\u0000\u0152\u0153"+
		"\u0003\u0092I\u0000\u0153\u0154\u0005\t\u0000\u0000\u0154\u0155\u0003"+
		"\u0084B\u0000\u0155\u0156\u0005\u0005\u0000\u0000\u0156\u001f\u0001\u0000"+
		"\u0000\u0000\u0157\u0162\u0003\"\u0011\u0000\u0158\u0162\u0003$\u0012"+
		"\u0000\u0159\u0162\u0003&\u0013\u0000\u015a\u0162\u0003(\u0014\u0000\u015b"+
		"\u0162\u0003*\u0015\u0000\u015c\u0162\u0003,\u0016\u0000\u015d\u0162\u0003"+
		".\u0017\u0000\u015e\u0162\u00030\u0018\u0000\u015f\u0162\u00032\u0019"+
		"\u0000\u0160\u0162\u00034\u001a\u0000\u0161\u0157\u0001\u0000\u0000\u0000"+
		"\u0161\u0158\u0001\u0000\u0000\u0000\u0161\u0159\u0001\u0000\u0000\u0000"+
		"\u0161\u015a\u0001\u0000\u0000\u0000\u0161\u015b\u0001\u0000\u0000\u0000"+
		"\u0161\u015c\u0001\u0000\u0000\u0000\u0161\u015d\u0001\u0000\u0000\u0000"+
		"\u0161\u015e\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000"+
		"\u0161\u0160\u0001\u0000\u0000\u0000\u0162!\u0001\u0000\u0000\u0000\u0163"+
		"\u0164\u0005\u001b\u0000\u0000\u0164\u0165\u0003\u00c4b\u0000\u0165\u0166"+
		"\u0005\u0003\u0000\u0000\u0166\u0167\u0003\u009cN\u0000\u0167\u0168\u0005"+
		"\u0004\u0000\u0000\u0168\u0169\u0005\n\u0000\u0000\u0169\u016a\u0003\u0094"+
		"J\u0000\u016a\u016b\u0005\u0005\u0000\u0000\u016b#\u0001\u0000\u0000\u0000"+
		"\u016c\u016d\u0005\u001c\u0000\u0000\u016d\u016e\u0003\u00c4b\u0000\u016e"+
		"\u016f\u0005\u0003\u0000\u0000\u016f\u0170\u0003\u009cN\u0000\u0170\u0171"+
		"\u0005\u0004\u0000\u0000\u0171\u0172\u0005\n\u0000\u0000\u0172\u0173\u0003"+
		"\u0094J\u0000\u0173\u0174\u0005\u0005\u0000\u0000\u0174%\u0001\u0000\u0000"+
		"\u0000\u0175\u0176\u0003\u00be_\u0000\u0176\u0177\u0003\u00c4b\u0000\u0177"+
		"\u0178\u0005\u0003\u0000\u0000\u0178\u0179\u0003\u009cN\u0000\u0179\u017a"+
		"\u0005\u0004\u0000\u0000\u017a\u017b\u0003\u009cN\u0000\u017b\u017c\u0005"+
		"\n\u0000\u0000\u017c\u017d\u0003\u0094J\u0000\u017d\u017e\u0005\u0005"+
		"\u0000\u0000\u017e\'\u0001\u0000\u0000\u0000\u017f\u0180\u0005\u001e\u0000"+
		"\u0000\u0180\u0181\u0003\u009cN\u0000\u0181\u0182\u0005\n\u0000\u0000"+
		"\u0182\u0183\u0003\u00c4b\u0000\u0183\u0184\u0005\u0003\u0000\u0000\u0184"+
		"\u0185\u0003\u009cN\u0000\u0185\u0186\u0005\u0004\u0000\u0000\u0186\u0187"+
		"\u0005\u0005\u0000\u0000\u0187)\u0001\u0000\u0000\u0000\u0188\u0189\u0005"+
		"\u001f\u0000\u0000\u0189\u018a\u0003\u00c4b\u0000\u018a\u018b\u0005\u0003"+
		"\u0000\u0000\u018b\u018c\u0003\u009cN\u0000\u018c\u018d\u0005\u0004\u0000"+
		"\u0000\u018d\u018e\u0005\u0005\u0000\u0000\u018e+\u0001\u0000\u0000\u0000"+
		"\u018f\u0193\u0003\u00bc^\u0000\u0190\u0192\u0003\u009cN\u0000\u0191\u0190"+
		"\u0001\u0000\u0000\u0000\u0192\u0195\u0001\u0000\u0000\u0000\u0193\u0191"+
		"\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194\u0196"+
		"\u0001\u0000\u0000\u0000\u0195\u0193\u0001\u0000\u0000\u0000\u0196\u0197"+
		"\u0005\n\u0000\u0000\u0197\u0198\u0003\u0094J\u0000\u0198\u019d\u0005"+
		"\t\u0000\u0000\u0199\u019e\u0003r9\u0000\u019a\u019e\u0003t:\u0000\u019b"+
		"\u019e\u0003x<\u0000\u019c\u019e\u0003v;\u0000\u019d\u0199\u0001\u0000"+
		"\u0000\u0000\u019d\u019a\u0001\u0000\u0000\u0000\u019d\u019b\u0001\u0000"+
		"\u0000\u0000\u019d\u019c\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000"+
		"\u0000\u0000\u019f\u01a0\u0005\u0005\u0000\u0000\u01a0-\u0001\u0000\u0000"+
		"\u0000\u01a1\u01a2\u0005\"\u0000\u0000\u01a2\u01a3\u0003\u00c2a\u0000"+
		"\u01a3\u01a4\u0005\u0005\u0000\u0000\u01a4/\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a6\u0003\u00ba]\u0000\u01a6\u01a7\u0003\u009cN\u0000\u01a7\u01a8\u0003"+
		"\u009cN\u0000\u01a8\u01a9\u0005\u000b\u0000\u0000\u01a9\u01aa\u0003\u00c2"+
		"a\u0000\u01aa\u01ab\u0005\u0005\u0000\u0000\u01ab1\u0001\u0000\u0000\u0000"+
		"\u01ac\u01ad\u0005#\u0000\u0000\u01ad\u01ae\u0003\u0094J\u0000\u01ae\u01af"+
		"\u0005\u0005\u0000\u0000\u01af3\u0001\u0000\u0000\u0000\u01b0\u01bc\u0003"+
		"6\u001b\u0000\u01b1\u01bc\u00038\u001c\u0000\u01b2\u01bc\u0003:\u001d"+
		"\u0000\u01b3\u01bc\u0003<\u001e\u0000\u01b4\u01bc\u0003>\u001f\u0000\u01b5"+
		"\u01bc\u0003@ \u0000\u01b6\u01bc\u0003F#\u0000\u01b7\u01bc\u0003H$\u0000"+
		"\u01b8\u01bc\u0003J%\u0000\u01b9\u01bc\u0003L&\u0000\u01ba\u01bc\u0003"+
		"N\'\u0000\u01bb\u01b0\u0001\u0000\u0000\u0000\u01bb\u01b1\u0001\u0000"+
		"\u0000\u0000\u01bb\u01b2\u0001\u0000\u0000\u0000\u01bb\u01b3\u0001\u0000"+
		"\u0000\u0000\u01bb\u01b4\u0001\u0000\u0000\u0000\u01bb\u01b5\u0001\u0000"+
		"\u0000\u0000\u01bb\u01b6\u0001\u0000\u0000\u0000\u01bb\u01b7\u0001\u0000"+
		"\u0000\u0000\u01bb\u01b8\u0001\u0000\u0000\u0000\u01bb\u01b9\u0001\u0000"+
		"\u0000\u0000\u01bb\u01ba\u0001\u0000\u0000\u0000\u01bc5\u0001\u0000\u0000"+
		"\u0000\u01bd\u01be\u0003\u00aaU\u0000\u01be\u01bf\u0003\u009cN\u0000\u01bf"+
		"\u01c0\u0005\n\u0000\u0000\u01c0\u01c1\u0003\u0094J\u0000\u01c1\u01c2"+
		"\u0005\u0005\u0000\u0000\u01c27\u0001\u0000\u0000\u0000\u01c3\u01c4\u0003"+
		"\u00acV\u0000\u01c4\u01c5\u0003\u009cN\u0000\u01c5\u01c6\u0003\u009cN"+
		"\u0000\u01c6\u01c7\u0005\n\u0000\u0000\u01c7\u01c8\u0003\u0094J\u0000"+
		"\u01c8\u01c9\u0005\u0005\u0000\u0000\u01c99\u0001\u0000\u0000\u0000\u01ca"+
		"\u01cb\u0005$\u0000\u0000\u01cb\u01cc\u0003\u009cN\u0000\u01cc\u01cd\u0003"+
		"\u009cN\u0000\u01cd\u01ce\u0003\u009cN\u0000\u01ce\u01cf\u0005\n\u0000"+
		"\u0000\u01cf\u01d0\u0003\u0094J\u0000\u01d0\u01d1\u0005\u0005\u0000\u0000"+
		"\u01d1;\u0001\u0000\u0000\u0000\u01d2\u01d3\u0003\u00aeW\u0000\u01d3\u01d4"+
		"\u0003\u009cN\u0000\u01d4\u01d5\u0003\u009cN\u0000\u01d5\u01d6\u0005\n"+
		"\u0000\u0000\u01d6\u01d7\u0003\u0094J\u0000\u01d7\u01d8\u0005\u0005\u0000"+
		"\u0000\u01d8=\u0001\u0000\u0000\u0000\u01d9\u01da\u0003\u00b0X\u0000\u01da"+
		"\u01db\u0003\u009cN\u0000\u01db\u01dc\u0003\u009cN\u0000\u01dc\u01dd\u0005"+
		"\u0005\u0000\u0000\u01dd?\u0001\u0000\u0000\u0000\u01de\u01df\u0003\u00b2"+
		"Y\u0000\u01df\u01e0\u0003\u009cN\u0000\u01e0\u01e1\u0003\u009cN\u0000"+
		"\u01e1\u01e2\u0005\n\u0000\u0000\u01e2\u01e3\u0003\u0094J\u0000\u01e3"+
		"\u01e7\u0005\t\u0000\u0000\u01e4\u01e8\u0003t:\u0000\u01e5\u01e8\u0003"+
		"l6\u0000\u01e6\u01e8\u0003n7\u0000\u01e7\u01e4\u0001\u0000\u0000\u0000"+
		"\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e7\u01e6\u0001\u0000\u0000\u0000"+
		"\u01e8\u01e9\u0001\u0000\u0000\u0000\u01e9\u01ea\u0005\u0005\u0000\u0000"+
		"\u01eaA\u0001\u0000\u0000\u0000\u01eb\u01ec\u0003\u00b4Z\u0000\u01ec\u01ed"+
		"\u0003\u009cN\u0000\u01ed\u01ee\u0005\n\u0000\u0000\u01ee\u01ef\u0003"+
		"\u0094J\u0000\u01ef\u01f5\u0005\t\u0000\u0000\u01f0\u01f6\u0003r9\u0000"+
		"\u01f1\u01f6\u0003t:\u0000\u01f2\u01f6\u0003x<\u0000\u01f3\u01f6\u0003"+
		"|>\u0000\u01f4\u01f6\u0003\u00c4b\u0000\u01f5\u01f0\u0001\u0000\u0000"+
		"\u0000\u01f5\u01f1\u0001\u0000\u0000\u0000\u01f5\u01f2\u0001\u0000\u0000"+
		"\u0000\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f5\u01f4\u0001\u0000\u0000"+
		"\u0000\u01f6\u01f7\u0001\u0000\u0000\u0000\u01f7\u01f8\u0005\u0005\u0000"+
		"\u0000\u01f8C\u0001\u0000\u0000\u0000\u01f9\u01fa\u0003\u00b6[\u0000\u01fa"+
		"\u01fb\u0003\u009cN\u0000\u01fb\u01fc\u0003\u009cN\u0000\u01fc\u01fd\u0005"+
		"\n\u0000\u0000\u01fd\u01fe\u0003\u0094J\u0000\u01fe\u0204\u0005\t\u0000"+
		"\u0000\u01ff\u0205\u0003r9\u0000\u0200\u0205\u0003t:\u0000\u0201\u0205"+
		"\u0003x<\u0000\u0202\u0205\u0003|>\u0000\u0203\u0205\u0003\u00c4b\u0000"+
		"\u0204\u01ff\u0001\u0000\u0000\u0000\u0204\u0200\u0001\u0000\u0000\u0000"+
		"\u0204\u0201\u0001\u0000\u0000\u0000\u0204\u0202\u0001\u0000\u0000\u0000"+
		"\u0204\u0203\u0001\u0000\u0000\u0000\u0205\u0206\u0001\u0000\u0000\u0000"+
		"\u0206\u0207\u0005\u0005\u0000\u0000\u0207E\u0001\u0000\u0000\u0000\u0208"+
		"\u020b\u0003B!\u0000\u0209\u020b\u0003D\"\u0000\u020a\u0208\u0001\u0000"+
		"\u0000\u0000\u020a\u0209\u0001\u0000\u0000\u0000\u020bG\u0001\u0000\u0000"+
		"\u0000\u020c\u020d\u0003\u00c0`\u0000\u020d\u020e\u0003\u009cN\u0000\u020e"+
		"\u020f\u0003\u009cN\u0000\u020f\u0210\u0003\u009cN\u0000\u0210\u0211\u0005"+
		"\n\u0000\u0000\u0211\u0212\u0003\u0094J\u0000\u0212\u0213\u0005\u0005"+
		"\u0000\u0000\u0213I\u0001\u0000\u0000\u0000\u0214\u0216\u0003\u00b8\\"+
		"\u0000\u0215\u0217\u0003\u009cN\u0000\u0216\u0215\u0001\u0000\u0000\u0000"+
		"\u0217\u0218\u0001\u0000\u0000\u0000\u0218\u0216\u0001\u0000\u0000\u0000"+
		"\u0218\u0219\u0001\u0000\u0000\u0000\u0219\u021a\u0001\u0000\u0000\u0000"+
		"\u021a\u021b\u0005\n\u0000\u0000\u021b\u021c\u0003\u0094J\u0000\u021c"+
		"\u021d\u0005\t\u0000\u0000\u021d\u021e\u0003\u00a6S\u0000\u021e\u021f"+
		"\u0005\u0005\u0000\u0000\u021fK\u0001\u0000\u0000\u0000\u0220\u0223\u0005"+
		"(\u0000\u0000\u0221\u0224\u0003\u00a4R\u0000\u0222\u0224\u0003\u00c4b"+
		"\u0000\u0223\u0221\u0001\u0000\u0000\u0000\u0223\u0222\u0001\u0000\u0000"+
		"\u0000\u0224\u0228\u0001\u0000\u0000\u0000\u0225\u0227\u0003\u009cN\u0000"+
		"\u0226\u0225\u0001\u0000\u0000\u0000\u0227\u022a\u0001\u0000\u0000\u0000"+
		"\u0228\u0226\u0001\u0000\u0000\u0000\u0228\u0229\u0001\u0000\u0000\u0000"+
		"\u0229\u0231\u0001\u0000\u0000\u0000\u022a\u0228\u0001\u0000\u0000\u0000"+
		"\u022b\u022d\u0005\n\u0000\u0000\u022c\u022e\u0003\u0094J\u0000\u022d"+
		"\u022c\u0001\u0000\u0000\u0000\u022e\u022f\u0001\u0000\u0000\u0000\u022f"+
		"\u022d\u0001\u0000\u0000\u0000\u022f\u0230\u0001\u0000\u0000\u0000\u0230"+
		"\u0232\u0001\u0000\u0000\u0000\u0231\u022b\u0001\u0000\u0000\u0000\u0231"+
		"\u0232\u0001\u0000\u0000\u0000\u0232\u0233\u0001\u0000\u0000\u0000\u0233"+
		"\u0234\u0005\u0005\u0000\u0000\u0234M\u0001\u0000\u0000\u0000\u0235\u0236"+
		"\u0005)\u0000\u0000\u0236\u023a\u0003\u00c4b\u0000\u0237\u0239\u0003\u009c"+
		"N\u0000\u0238\u0237\u0001\u0000\u0000\u0000\u0239\u023c\u0001\u0000\u0000"+
		"\u0000\u023a\u0238\u0001\u0000\u0000\u0000\u023a\u023b\u0001\u0000\u0000"+
		"\u0000\u023b\u023d\u0001\u0000\u0000\u0000\u023c\u023a\u0001\u0000\u0000"+
		"\u0000\u023d\u023e\u0005\n\u0000\u0000\u023e\u023f\u0003\u0094J\u0000"+
		"\u023f\u0240\u0005\u0005\u0000\u0000\u0240O\u0001\u0000\u0000\u0000\u0241"+
		"\u0246\u0003^/\u0000\u0242\u0246\u0003`0\u0000\u0243\u0246\u0003b1\u0000"+
		"\u0244\u0246\u0003d2\u0000\u0245\u0241\u0001\u0000\u0000\u0000\u0245\u0242"+
		"\u0001\u0000\u0000\u0000\u0245\u0243\u0001\u0000\u0000\u0000\u0245\u0244"+
		"\u0001\u0000\u0000\u0000\u0246Q\u0001\u0000\u0000\u0000\u0247\u0249\u0005"+
		"\b\u0000\u0000\u0248\u0247\u0001\u0000\u0000\u0000\u0248\u0249\u0001\u0000"+
		"\u0000\u0000\u0249\u024a\u0001\u0000\u0000\u0000\u024a\u024b\u0005r\u0000"+
		"\u0000\u024b\u024c\u0003h4\u0000\u024cS\u0001\u0000\u0000\u0000\u024d"+
		"\u024f\u0005\b\u0000\u0000\u024e\u024d\u0001\u0000\u0000\u0000\u024e\u024f"+
		"\u0001\u0000\u0000\u0000\u024f\u0250\u0001\u0000\u0000\u0000\u0250\u0251"+
		"\u0005r\u0000\u0000\u0251\u0252\u0003f3\u0000\u0252U\u0001\u0000\u0000"+
		"\u0000\u0253\u0256\u0003R)\u0000\u0254\u0256\u0003T*\u0000\u0255\u0253"+
		"\u0001\u0000\u0000\u0000\u0255\u0254\u0001\u0000\u0000\u0000\u0256W\u0001"+
		"\u0000\u0000\u0000\u0257\u0259\u0005\b\u0000\u0000\u0258\u0257\u0001\u0000"+
		"\u0000\u0000\u0258\u0259\u0001\u0000\u0000\u0000\u0259\u025a\u0001\u0000"+
		"\u0000\u0000\u025a\u025b\u0005r\u0000\u0000\u025b\u025c\u0003l6\u0000"+
		"\u025cY\u0001\u0000\u0000\u0000\u025d\u025f\u0005\b\u0000\u0000\u025e"+
		"\u025d\u0001\u0000\u0000\u0000\u025e\u025f\u0001\u0000\u0000\u0000\u025f"+
		"\u0260\u0001\u0000\u0000\u0000\u0260\u0261\u0005r\u0000\u0000\u0261\u0262"+
		"\u0003n7\u0000\u0262[\u0001\u0000\u0000\u0000\u0263\u0265\u0005\b\u0000"+
		"\u0000\u0264\u0263\u0001\u0000\u0000\u0000\u0264\u0265\u0001\u0000\u0000"+
		"\u0000\u0265\u0266\u0001\u0000\u0000\u0000\u0266\u0267\u0005r\u0000\u0000"+
		"\u0267\u0268\u0003p8\u0000\u0268]\u0001\u0000\u0000\u0000\u0269\u026e"+
		"\u0003V+\u0000\u026a\u026e\u0003X,\u0000\u026b\u026e\u0003Z-\u0000\u026c"+
		"\u026e\u0003\\.\u0000\u026d\u0269\u0001\u0000\u0000\u0000\u026d\u026a"+
		"\u0001\u0000\u0000\u0000\u026d\u026b\u0001\u0000\u0000\u0000\u026d\u026c"+
		"\u0001\u0000\u0000\u0000\u026e_\u0001\u0000\u0000\u0000\u026f\u0270\u0005"+
		"p\u0000\u0000\u0270a\u0001\u0000\u0000\u0000\u0271\u0272\u0005q\u0000"+
		"\u0000\u0272c\u0001\u0000\u0000\u0000\u0273\u0274\u0007\u0000\u0000\u0000"+
		"\u0274e\u0001\u0000\u0000\u0000\u0275\u0276\u0005i\u0000\u0000\u0276g"+
		"\u0001\u0000\u0000\u0000\u0277\u0278\u0005j\u0000\u0000\u0278i\u0001\u0000"+
		"\u0000\u0000\u0279\u027c\u0003f3\u0000\u027a\u027c\u0003h4\u0000\u027b"+
		"\u0279\u0001\u0000\u0000\u0000\u027b\u027a\u0001\u0000\u0000\u0000\u027c"+
		"k\u0001\u0000\u0000\u0000\u027d\u027e\u0005k\u0000\u0000\u027em\u0001"+
		"\u0000\u0000\u0000\u027f\u0280\u0005\u0011\u0000\u0000\u0280o\u0001\u0000"+
		"\u0000\u0000\u0281\u0282\u0005l\u0000\u0000\u0282q\u0001\u0000\u0000\u0000"+
		"\u0283\u0288\u0003j5\u0000\u0284\u0288\u0003l6\u0000\u0285\u0288\u0003"+
		"n7\u0000\u0286\u0288\u0003p8\u0000\u0287\u0283\u0001\u0000\u0000\u0000"+
		"\u0287\u0284\u0001\u0000\u0000\u0000\u0287\u0285\u0001\u0000\u0000\u0000"+
		"\u0287\u0286\u0001\u0000\u0000\u0000\u0288s\u0001\u0000\u0000\u0000\u0289"+
		"\u028a\u0005m\u0000\u0000\u028au\u0001\u0000\u0000\u0000\u028b\u028c\u0005"+
		"n\u0000\u0000\u028cw\u0001\u0000\u0000\u0000\u028d\u028e\u0005o\u0000"+
		"\u0000\u028ey\u0001\u0000\u0000\u0000\u028f\u0294\u0003r9\u0000\u0290"+
		"\u0294\u0003t:\u0000\u0291\u0294\u0003x<\u0000\u0292\u0294\u0003v;\u0000"+
		"\u0293\u028f\u0001\u0000\u0000\u0000\u0293\u0290\u0001\u0000\u0000\u0000"+
		"\u0293\u0291\u0001\u0000\u0000\u0000\u0293\u0292\u0001\u0000\u0000\u0000"+
		"\u0294{\u0001\u0000\u0000\u0000\u0295\u0296\u0005\u0003\u0000\u0000\u0296"+
		"\u0297\u0003~?\u0000\u0297\u0298\u0005\u0005\u0000\u0000\u0298\u0299\u0003"+
		"T*\u0000\u0299\u029a\u0005\u0004\u0000\u0000\u029a}\u0001\u0000\u0000"+
		"\u0000\u029b\u029f\u0003z=\u0000\u029c\u029f\u0003|>\u0000\u029d\u029f"+
		"\u0003\u00c4b\u0000\u029e\u029b\u0001\u0000\u0000\u0000\u029e\u029c\u0001"+
		"\u0000\u0000\u0000\u029e\u029d\u0001\u0000\u0000\u0000\u029f\u007f\u0001"+
		"\u0000\u0000\u0000\u02a0\u02a1\u0003~?\u0000\u02a1\u02a2\u0003\u008aE"+
		"\u0000\u02a2\u02aa\u0001\u0000\u0000\u0000\u02a3\u02a4\u0003\u00c4b\u0000"+
		"\u02a4\u02a5\u0003\u008aE\u0000\u02a5\u02aa\u0001\u0000\u0000\u0000\u02a6"+
		"\u02a7\u0003\u00a4R\u0000\u02a7\u02a8\u0003\u008aE\u0000\u02a8\u02aa\u0001"+
		"\u0000\u0000\u0000\u02a9\u02a0\u0001\u0000\u0000\u0000\u02a9\u02a3\u0001"+
		"\u0000\u0000\u0000\u02a9\u02a6\u0001\u0000\u0000\u0000\u02aa\u0081\u0001"+
		"\u0000\u0000\u0000\u02ab\u02ac\u0003~?\u0000\u02ac\u02ad\u0003\u008aE"+
		"\u0000\u02ad\u0083\u0001\u0000\u0000\u0000\u02ae\u02af\u0003~?\u0000\u02af"+
		"\u02b0\u0003\u008aE\u0000\u02b0\u02b5\u0001\u0000\u0000\u0000\u02b1\u02b2"+
		"\u0003\u00a4R\u0000\u02b2\u02b3\u0003\u008aE\u0000\u02b3\u02b5\u0001\u0000"+
		"\u0000\u0000\u02b4\u02ae\u0001\u0000\u0000\u0000\u02b4\u02b1\u0001\u0000"+
		"\u0000\u0000\u02b5\u0085\u0001\u0000\u0000\u0000\u02b6\u02b7\u0003~?\u0000"+
		"\u02b7\u02b8\u0003\u008aE\u0000\u02b8\u0087\u0001\u0000\u0000\u0000\u02b9"+
		"\u02ba\u0003\u00a4R\u0000\u02ba\u02bb\u0003\u008aE\u0000\u02bb\u02c1\u0001"+
		"\u0000\u0000\u0000\u02bc\u02bd\u0003\u00c4b\u0000\u02bd\u02be\u0003\u008a"+
		"E\u0000\u02be\u02c1\u0001\u0000\u0000\u0000\u02bf\u02c1\u0003~?\u0000"+
		"\u02c0\u02b9\u0001\u0000\u0000\u0000\u02c0\u02bc\u0001\u0000\u0000\u0000"+
		"\u02c0\u02bf\u0001\u0000\u0000\u0000\u02c1\u0089\u0001\u0000\u0000\u0000"+
		"\u02c2\u02c3\u0005\u0001\u0000\u0000\u02c3\u02c4\u0007\u0001\u0000\u0000"+
		"\u02c4\u008b\u0001\u0000\u0000\u0000\u02c5\u02c6\u0003\u008eG\u0000\u02c6"+
		"\u02c7\u0005\u0001\u0000\u0000\u02c7\u02c8\u0003\u0090H\u0000\u02c8\u008d"+
		"\u0001\u0000\u0000\u0000\u02c9\u02ca\u0003\u00c4b\u0000\u02ca\u008f\u0001"+
		"\u0000\u0000\u0000\u02cb\u02cc\u0003\u00c4b\u0000\u02cc\u0091\u0001\u0000"+
		"\u0000\u0000\u02cd\u02ce\u0005s\u0000\u0000\u02ce\u0093\u0001\u0000\u0000"+
		"\u0000\u02cf\u02d3\u0003\u0092I\u0000\u02d0\u02d2\u0003\u0096K\u0000\u02d1"+
		"\u02d0\u0001\u0000\u0000\u0000\u02d2\u02d5\u0001\u0000\u0000\u0000\u02d3"+
		"\u02d1\u0001\u0000\u0000\u0000\u02d3\u02d4\u0001\u0000\u0000\u0000\u02d4"+
		"\u0095\u0001\u0000\u0000\u0000\u02d5\u02d3\u0001\u0000\u0000\u0000\u02d6"+
		"\u02d9\u0003\u0098L\u0000\u02d7\u02d9\u0003\u009aM\u0000\u02d8\u02d6\u0001"+
		"\u0000\u0000\u0000\u02d8\u02d7\u0001\u0000\u0000\u0000\u02d9\u0097\u0001"+
		"\u0000\u0000\u0000\u02da\u02db\u0005\u0001\u0000\u0000\u02db\u02dc\u0003"+
		"\u00c4b\u0000\u02dc\u0099\u0001\u0000\u0000\u0000\u02dd\u02de\u0005\u0003"+
		"\u0000\u0000\u02de\u02df\u0003T*\u0000\u02df\u02e0\u0005\u0004\u0000\u0000"+
		"\u02e0\u02e5\u0001\u0000\u0000\u0000\u02e1\u02e2\u0005\u0003\u0000\u0000"+
		"\u02e2\u02e3\u0005r\u0000\u0000\u02e3\u02e5\u0005\u0004\u0000\u0000\u02e4"+
		"\u02dd\u0001\u0000\u0000\u0000\u02e4\u02e1\u0001\u0000\u0000\u0000\u02e5"+
		"\u009b\u0001\u0000\u0000\u0000\u02e6\u02eb\u0003P(\u0000\u02e7\u02eb\u0003"+
		"\u0094J\u0000\u02e8\u02eb\u0003\u008cF\u0000\u02e9\u02eb\u0003\u009eO"+
		"\u0000\u02ea\u02e6\u0001\u0000\u0000\u0000\u02ea\u02e7\u0001\u0000\u0000"+
		"\u0000\u02ea\u02e8\u0001\u0000\u0000\u0000\u02ea\u02e9\u0001\u0000\u0000"+
		"\u0000\u02eb\u009d\u0001\u0000\u0000\u0000\u02ec\u02ed\u0005\u0011\u0000"+
		"\u0000\u02ed\u02ee\u0005\u0006\u0000\u0000\u02ee\u02f6\u0005\u0012\u0000"+
		"\u0000\u02ef\u02f0\u0005\u0013\u0000\u0000\u02f0\u02f1\u0005\u0001\u0000"+
		"\u0000\u02f1\u02f6\u0007\u0002\u0000\u0000\u02f2\u02f3\u0005\u0016\u0000"+
		"\u0000\u02f3\u02f4\u0005\u0001\u0000\u0000\u02f4\u02f6\u0005\u0017\u0000"+
		"\u0000\u02f5\u02ec\u0001\u0000\u0000\u0000\u02f5\u02ef\u0001\u0000\u0000"+
		"\u0000\u02f5\u02f2\u0001\u0000\u0000\u0000\u02f6\u009f\u0001\u0000\u0000"+
		"\u0000\u02f7\u02f8\u0003\u00c4b\u0000\u02f8\u02f9\u0005\t\u0000\u0000"+
		"\u02f9\u02fa\u0003~?\u0000\u02fa\u02fb\u0005\u0005\u0000\u0000\u02fb\u00a1"+
		"\u0001\u0000\u0000\u0000\u02fc\u02fd\u0003\u00c4b\u0000\u02fd\u02fe\u0005"+
		"\t\u0000\u0000\u02fe\u02ff\u0003\u0086C\u0000\u02ff\u0300\u0005\u0005"+
		"\u0000\u0000\u0300\u00a3\u0001\u0000\u0000\u0000\u0301\u0302\u0003\u008c"+
		"F\u0000\u0302\u0303\u0005\u0002\u0000\u0000\u0303\u0304\u0003\u00c4b\u0000"+
		"\u0304\u00a5\u0001\u0000\u0000\u0000\u0305\u0309\u0003\u0088D\u0000\u0306"+
		"\u0309\u0003\u00a4R\u0000\u0307\u0309\u0003\u00a8T\u0000\u0308\u0305\u0001"+
		"\u0000\u0000\u0000\u0308\u0306\u0001\u0000\u0000\u0000\u0308\u0307\u0001"+
		"\u0000\u0000\u0000\u0309\u00a7\u0001\u0000\u0000\u0000\u030a\u030b\u0005"+
		"\u0011\u0000\u0000\u030b\u030c\u0005\u0001\u0000\u0000\u030c\u030d\u0007"+
		"\u0003\u0000\u0000\u030d\u00a9\u0001\u0000\u0000\u0000\u030e\u0311\u0005"+
		"*\u0000\u0000\u030f\u0310\u0005\u0001\u0000\u0000\u0310\u0312\u0005\u0018"+
		"\u0000\u0000\u0311\u030f\u0001\u0000\u0000\u0000\u0311\u0312\u0001\u0000"+
		"\u0000\u0000\u0312\u031a\u0001\u0000\u0000\u0000\u0313\u031a\u0005+\u0000"+
		"\u0000\u0314\u031a\u0005,\u0000\u0000\u0315\u031a\u0005-\u0000\u0000\u0316"+
		"\u031a\u0005.\u0000\u0000\u0317\u031a\u0005/\u0000\u0000\u0318\u031a\u0005"+
		"0\u0000\u0000\u0319\u030e\u0001\u0000\u0000\u0000\u0319\u0313\u0001\u0000"+
		"\u0000\u0000\u0319\u0314\u0001\u0000\u0000\u0000\u0319\u0315\u0001\u0000"+
		"\u0000\u0000\u0319\u0316\u0001\u0000\u0000\u0000\u0319\u0317\u0001\u0000"+
		"\u0000\u0000\u0319\u0318\u0001\u0000\u0000\u0000\u031a\u00ab\u0001\u0000"+
		"\u0000\u0000\u031b\u031e\u00051\u0000\u0000\u031c\u031d\u0005\u0001\u0000"+
		"\u0000\u031d\u031f\u0005\u0018\u0000\u0000\u031e\u031c\u0001\u0000\u0000"+
		"\u0000\u031e\u031f\u0001\u0000\u0000\u0000\u031f\u034e\u0001\u0000\u0000"+
		"\u0000\u0320\u0323\u00052\u0000\u0000\u0321\u0322\u0005\u0001\u0000\u0000"+
		"\u0322\u0324\u0005\u0018\u0000\u0000\u0323\u0321\u0001\u0000\u0000\u0000"+
		"\u0323\u0324\u0001\u0000\u0000\u0000\u0324\u034e\u0001\u0000\u0000\u0000"+
		"\u0325\u0328\u00053\u0000\u0000\u0326\u0327\u0005\u0001\u0000\u0000\u0327"+
		"\u0329\u0005\u0018\u0000\u0000\u0328\u0326\u0001\u0000\u0000\u0000\u0328"+
		"\u0329\u0001\u0000\u0000\u0000\u0329\u034e\u0001\u0000\u0000\u0000\u032a"+
		"\u032d\u00054\u0000\u0000\u032b\u032c\u0005\u0001\u0000\u0000\u032c\u032e"+
		"\u0005\u0018\u0000\u0000\u032d\u032b\u0001\u0000\u0000\u0000\u032d\u032e"+
		"\u0001\u0000\u0000\u0000\u032e\u034e\u0001\u0000\u0000\u0000\u032f\u0332"+
		"\u00055\u0000\u0000\u0330\u0331\u0005\u0001\u0000\u0000\u0331\u0333\u0005"+
		"\u0018\u0000\u0000\u0332\u0330\u0001\u0000\u0000\u0000\u0332\u0333\u0001"+
		"\u0000\u0000\u0000\u0333\u034e\u0001\u0000\u0000\u0000\u0334\u0337\u0005"+
		"6\u0000\u0000\u0335\u0336\u0005\u0001\u0000\u0000\u0336\u0338\u0005\u0018"+
		"\u0000\u0000\u0337\u0335\u0001\u0000\u0000\u0000\u0337\u0338\u0001\u0000"+
		"\u0000\u0000\u0338\u034e\u0001\u0000\u0000\u0000\u0339\u033c\u00057\u0000"+
		"\u0000\u033a\u033b\u0005\u0001\u0000\u0000\u033b\u033d\u0005\u0018\u0000"+
		"\u0000\u033c\u033a\u0001\u0000\u0000\u0000\u033c\u033d\u0001\u0000\u0000"+
		"\u0000\u033d\u034e\u0001\u0000\u0000\u0000\u033e\u0341\u00058\u0000\u0000"+
		"\u033f\u0340\u0005\u0001\u0000\u0000\u0340\u0342\u0005\u0018\u0000\u0000"+
		"\u0341\u033f\u0001\u0000\u0000\u0000\u0341\u0342\u0001\u0000\u0000\u0000"+
		"\u0342\u034e\u0001\u0000\u0000\u0000\u0343\u034e\u00059\u0000\u0000\u0344"+
		"\u034e\u0005:\u0000\u0000\u0345\u034e\u0005;\u0000\u0000\u0346\u034e\u0005"+
		"<\u0000\u0000\u0347\u034e\u0005=\u0000\u0000\u0348\u034e\u0005>\u0000"+
		"\u0000\u0349\u034e\u0005?\u0000\u0000\u034a\u034e\u0005@\u0000\u0000\u034b"+
		"\u034e\u0005A\u0000\u0000\u034c\u034e\u0005B\u0000\u0000\u034d\u031b\u0001"+
		"\u0000\u0000\u0000\u034d\u0320\u0001\u0000\u0000\u0000\u034d\u0325\u0001"+
		"\u0000\u0000\u0000\u034d\u032a\u0001\u0000\u0000\u0000\u034d\u032f\u0001"+
		"\u0000\u0000\u0000\u034d\u0334\u0001\u0000\u0000\u0000\u034d\u0339\u0001"+
		"\u0000\u0000\u0000\u034d\u033e\u0001\u0000\u0000\u0000\u034d\u0343\u0001"+
		"\u0000\u0000\u0000\u034d\u0344\u0001\u0000\u0000\u0000\u034d\u0345\u0001"+
		"\u0000\u0000\u0000\u034d\u0346\u0001\u0000\u0000\u0000\u034d\u0347\u0001"+
		"\u0000\u0000\u0000\u034d\u0348\u0001\u0000\u0000\u0000\u034d\u0349\u0001"+
		"\u0000\u0000\u0000\u034d\u034a\u0001\u0000\u0000\u0000\u034d\u034b\u0001"+
		"\u0000\u0000\u0000\u034d\u034c\u0001\u0000\u0000\u0000\u034e\u00ad\u0001"+
		"\u0000\u0000\u0000\u034f\u0350\u0005C\u0000\u0000\u0350\u0351\u0005\u0001"+
		"\u0000\u0000\u0351\u0352\u0007\u0004\u0000\u0000\u0352\u00af\u0001\u0000"+
		"\u0000\u0000\u0353\u0354\u0005F\u0000\u0000\u0354\u0355\u0005\u0001\u0000"+
		"\u0000\u0355\u0356\u0007\u0004\u0000\u0000\u0356\u00b1\u0001\u0000\u0000"+
		"\u0000\u0357\u0358\u0005G\u0000\u0000\u0358\u0359\u0005\u0001\u0000\u0000"+
		"\u0359\u035a\u0007\u0005\u0000\u0000\u035a\u00b3\u0001\u0000\u0000\u0000"+
		"\u035b\u035c\u0005H\u0000\u0000\u035c\u035d\u0005\u0001\u0000\u0000\u035d"+
		"\u035e\u0007\u0006\u0000\u0000\u035e\u00b5\u0001\u0000\u0000\u0000\u035f"+
		"\u0360\u0005I\u0000\u0000\u0360\u0361\u0005\u0001\u0000\u0000\u0361\u0362"+
		"\u0007\u0007\u0000\u0000\u0362\u00b7\u0001\u0000\u0000\u0000\u0363\u0366"+
		"\u0005Y\u0000\u0000\u0364\u0365\u0005\u0001\u0000\u0000\u0365\u0367\u0005"+
		"Z\u0000\u0000\u0366\u0364\u0001\u0000\u0000\u0000\u0366\u0367\u0001\u0000"+
		"\u0000\u0000\u0367\u00b9\u0001\u0000\u0000\u0000\u0368\u0369\u0005[\u0000"+
		"\u0000\u0369\u036a\u0005\u0001\u0000\u0000\u036a\u036b\u0007\u0004\u0000"+
		"\u0000\u036b\u00bb\u0001\u0000\u0000\u0000\u036c\u036d\u0005 \u0000\u0000"+
		"\u036d\u036e\u0005\u0001\u0000\u0000\u036e\u036f\u0005!\u0000\u0000\u036f"+
		"\u00bd\u0001\u0000\u0000\u0000\u0370\u0371\u0005\u001c\u0000\u0000\u0371"+
		"\u0372\u0005\u0001\u0000\u0000\u0372\u0373\u0005\u001d\u0000\u0000\u0373"+
		"\u00bf\u0001\u0000\u0000\u0000\u0374\u0375\u0005%\u0000\u0000\u0375\u0376"+
		"\u0005\u0001\u0000\u0000\u0376\u0379\u0005&\u0000\u0000\u0377\u0379\u0005"+
		"\'\u0000\u0000\u0378\u0374\u0001\u0000\u0000\u0000\u0378\u0377\u0001\u0000"+
		"\u0000\u0000\u0379\u00c1\u0001\u0000\u0000\u0000\u037a\u037b\u0005t\u0000"+
		"\u0000\u037b\u00c3\u0001\u0000\u0000\u0000\u037c\u037d\u0007\b\u0000\u0000"+
		"\u037d\u00c5\u0001\u0000\u0000\u0000>\u00cb\u00d6\u00d8\u00f4\u00fc\u0105"+
		"\u010b\u0110\u0125\u012b\u0131\u0135\u0149\u014f\u0161\u0193\u019d\u01bb"+
		"\u01e7\u01f5\u0204\u020a\u0218\u0223\u0228\u022f\u0231\u023a\u0245\u0248"+
		"\u024e\u0255\u0258\u025e\u0264\u026d\u027b\u0287\u0293\u029e\u02a9\u02b4"+
		"\u02c0\u02d3\u02d8\u02e4\u02ea\u02f5\u0308\u0311\u0319\u031e\u0323\u0328"+
		"\u032d\u0332\u0337\u033c\u0341\u034d\u0366\u0378";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}