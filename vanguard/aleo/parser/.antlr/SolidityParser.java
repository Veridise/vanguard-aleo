// Generated from /Users/joseph/Desktop/UCSB/24winter/vanguard-aleo/vanguard/aleo/parser/Solidity.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SolidityParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, T__88=89, T__89=90, T__90=91, T__91=92, Int=93, Uint=94, Byte=95, 
		Fixed=96, Ufixed=97, BooleanLiteral=98, DecimalNumber=99, HexNumber=100, 
		NumberUnit=101, HexLiteralFragment=102, ReservedKeyword=103, AnonymousKeyword=104, 
		BreakKeyword=105, ConstantKeyword=106, ImmutableKeyword=107, ContinueKeyword=108, 
		LeaveKeyword=109, ExternalKeyword=110, IndexedKeyword=111, InternalKeyword=112, 
		PayableKeyword=113, PrivateKeyword=114, PublicKeyword=115, VirtualKeyword=116, 
		PureKeyword=117, TypeKeyword=118, ViewKeyword=119, ConstructorKeyword=120, 
		FallbackKeyword=121, ReceiveKeyword=122, Identifier=123, StringLiteralFragment=124, 
		VersionLiteral=125, WS=126, COMMENT=127, LINE_COMMENT=128;
	public static final int
		RULE_sourceUnit = 0, RULE_pragmaDirective = 1, RULE_pragmaName = 2, RULE_pragmaValue = 3, 
		RULE_version = 4, RULE_versionConstraint = 5, RULE_versionOperator = 6, 
		RULE_importDirective = 7, RULE_importDeclaration = 8, RULE_contractDefinition = 9, 
		RULE_inheritanceSpecifier = 10, RULE_contractPart = 11, RULE_stateVariableDeclaration = 12, 
		RULE_overrideSpecifier = 13, RULE_usingForDeclaration = 14, RULE_structDefinition = 15, 
		RULE_modifierDefinition = 16, RULE_functionDefinition = 17, RULE_functionDescriptor = 18, 
		RULE_returnParameters = 19, RULE_modifierList = 20, RULE_modifierInvocation = 21, 
		RULE_eventDefinition = 22, RULE_enumDefinition = 23, RULE_enumValue = 24, 
		RULE_parameterList = 25, RULE_parameter = 26, RULE_eventParameterList = 27, 
		RULE_eventParameter = 28, RULE_variableDeclaration = 29, RULE_typeName = 30, 
		RULE_userDefinedTypeName = 31, RULE_mapping = 32, RULE_functionTypeName = 33, 
		RULE_storageLocation = 34, RULE_stateMutability = 35, RULE_block = 36, 
		RULE_statement = 37, RULE_expressionStatement = 38, RULE_ifStatement = 39, 
		RULE_tryStatement = 40, RULE_catchClause = 41, RULE_whileStatement = 42, 
		RULE_forStatement = 43, RULE_simpleStatement = 44, RULE_inlineAssemblyStatement = 45, 
		RULE_doWhileStatement = 46, RULE_continueStatement = 47, RULE_breakStatement = 48, 
		RULE_returnStatement = 49, RULE_throwStatement = 50, RULE_emitStatement = 51, 
		RULE_variableDeclarationStatement = 52, RULE_variableDeclarationList = 53, 
		RULE_identifierList = 54, RULE_elementaryTypeName = 55, RULE_expression = 56, 
		RULE_primaryExpression = 57, RULE_expressionList = 58, RULE_nameValueList = 59, 
		RULE_nameValue = 60, RULE_functionCallArguments = 61, RULE_functionCall = 62, 
		RULE_tupleExpression = 63, RULE_typeNameExpression = 64, RULE_assemblyItem = 65, 
		RULE_assemblyBlock = 66, RULE_assemblyExpression = 67, RULE_assemblyCall = 68, 
		RULE_assemblyLocalDefinition = 69, RULE_assemblyAssignment = 70, RULE_assemblyIdentifierList = 71, 
		RULE_assemblyStackAssignment = 72, RULE_labelDefinition = 73, RULE_assemblySwitch = 74, 
		RULE_assemblyCase = 75, RULE_assemblyFunctionDefinition = 76, RULE_assemblyFunctionReturns = 77, 
		RULE_assemblyFor = 78, RULE_assemblyIf = 79, RULE_assemblyLiteral = 80, 
		RULE_assemblyTypedVariableList = 81, RULE_assemblyType = 82, RULE_subAssembly = 83, 
		RULE_numberLiteral = 84, RULE_identifier = 85, RULE_hexLiteral = 86, RULE_stringLiteral = 87;
	private static String[] makeRuleNames() {
		return new String[] {
			"sourceUnit", "pragmaDirective", "pragmaName", "pragmaValue", "version", 
			"versionConstraint", "versionOperator", "importDirective", "importDeclaration", 
			"contractDefinition", "inheritanceSpecifier", "contractPart", "stateVariableDeclaration", 
			"overrideSpecifier", "usingForDeclaration", "structDefinition", "modifierDefinition", 
			"functionDefinition", "functionDescriptor", "returnParameters", "modifierList", 
			"modifierInvocation", "eventDefinition", "enumDefinition", "enumValue", 
			"parameterList", "parameter", "eventParameterList", "eventParameter", 
			"variableDeclaration", "typeName", "userDefinedTypeName", "mapping", 
			"functionTypeName", "storageLocation", "stateMutability", "block", "statement", 
			"expressionStatement", "ifStatement", "tryStatement", "catchClause", 
			"whileStatement", "forStatement", "simpleStatement", "inlineAssemblyStatement", 
			"doWhileStatement", "continueStatement", "breakStatement", "returnStatement", 
			"throwStatement", "emitStatement", "variableDeclarationStatement", "variableDeclarationList", 
			"identifierList", "elementaryTypeName", "expression", "primaryExpression", 
			"expressionList", "nameValueList", "nameValue", "functionCallArguments", 
			"functionCall", "tupleExpression", "typeNameExpression", "assemblyItem", 
			"assemblyBlock", "assemblyExpression", "assemblyCall", "assemblyLocalDefinition", 
			"assemblyAssignment", "assemblyIdentifierList", "assemblyStackAssignment", 
			"labelDefinition", "assemblySwitch", "assemblyCase", "assemblyFunctionDefinition", 
			"assemblyFunctionReturns", "assemblyFor", "assemblyIf", "assemblyLiteral", 
			"assemblyTypedVariableList", "assemblyType", "subAssembly", "numberLiteral", 
			"identifier", "hexLiteral", "stringLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'pragma'", "';'", "'^'", "'~'", "'>='", "'>'", "'<'", "'<='", 
			"'='", "'import'", "'as'", "'*'", "'from'", "'{'", "','", "'}'", "'abstract'", 
			"'contract'", "'interface'", "'library'", "'is'", "'('", "')'", "'override'", 
			"'using'", "'for'", "'struct'", "'modifier'", "'function'", "'returns'", 
			"'event'", "'enum'", "'['", "']'", "'.'", "'mapping'", "'=>'", "'memory'", 
			"'storage'", "'calldata'", "'if'", "'else'", "'try'", "'catch'", "'while'", 
			"'assembly'", "'do'", "'return'", "'throw'", "'emit'", "'var'", "'address'", 
			"'bool'", "'string'", "'byte'", "'++'", "'--'", "'new'", "':'", "'+'", 
			"'-'", "'after'", "'delete'", "'!'", "'**'", "'/'", "'%'", "'<<'", "'>>'", 
			"'&'", "'|'", "'=='", "'!='", "'&&'", "'||'", "'?'", "'|='", "'^='", 
			"'&='", "'<<='", "'>>='", "'+='", "'-='", "'*='", "'/='", "'%='", "'let'", 
			"':='", "'=:'", "'switch'", "'case'", "'default'", null, null, null, 
			null, null, null, null, null, null, null, null, "'anonymous'", "'break'", 
			"'constant'", "'immutable'", "'continue'", "'leave'", "'external'", "'indexed'", 
			"'internal'", "'payable'", "'private'", "'public'", "'virtual'", "'pure'", 
			"'type'", "'view'", "'constructor'", "'fallback'", "'receive'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "Int", "Uint", 
			"Byte", "Fixed", "Ufixed", "BooleanLiteral", "DecimalNumber", "HexNumber", 
			"NumberUnit", "HexLiteralFragment", "ReservedKeyword", "AnonymousKeyword", 
			"BreakKeyword", "ConstantKeyword", "ImmutableKeyword", "ContinueKeyword", 
			"LeaveKeyword", "ExternalKeyword", "IndexedKeyword", "InternalKeyword", 
			"PayableKeyword", "PrivateKeyword", "PublicKeyword", "VirtualKeyword", 
			"PureKeyword", "TypeKeyword", "ViewKeyword", "ConstructorKeyword", "FallbackKeyword", 
			"ReceiveKeyword", "Identifier", "StringLiteralFragment", "VersionLiteral", 
			"WS", "COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "Solidity.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SolidityParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SourceUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SolidityParser.EOF, 0); }
		public List<PragmaDirectiveContext> pragmaDirective() {
			return getRuleContexts(PragmaDirectiveContext.class);
		}
		public PragmaDirectiveContext pragmaDirective(int i) {
			return getRuleContext(PragmaDirectiveContext.class,i);
		}
		public List<ImportDirectiveContext> importDirective() {
			return getRuleContexts(ImportDirectiveContext.class);
		}
		public ImportDirectiveContext importDirective(int i) {
			return getRuleContext(ImportDirectiveContext.class,i);
		}
		public List<StructDefinitionContext> structDefinition() {
			return getRuleContexts(StructDefinitionContext.class);
		}
		public StructDefinitionContext structDefinition(int i) {
			return getRuleContext(StructDefinitionContext.class,i);
		}
		public List<EnumDefinitionContext> enumDefinition() {
			return getRuleContexts(EnumDefinitionContext.class);
		}
		public EnumDefinitionContext enumDefinition(int i) {
			return getRuleContext(EnumDefinitionContext.class,i);
		}
		public List<ContractDefinitionContext> contractDefinition() {
			return getRuleContexts(ContractDefinitionContext.class);
		}
		public ContractDefinitionContext contractDefinition(int i) {
			return getRuleContext(ContractDefinitionContext.class,i);
		}
		public SourceUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceUnit; }
	}

	public final SourceUnitContext sourceUnit() throws RecognitionException {
		SourceUnitContext _localctx = new SourceUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sourceUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4431152130L) != 0)) {
				{
				setState(181);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(176);
					pragmaDirective();
					}
					break;
				case T__9:
					{
					setState(177);
					importDirective();
					}
					break;
				case T__26:
					{
					setState(178);
					structDefinition();
					}
					break;
				case T__31:
					{
					setState(179);
					enumDefinition();
					}
					break;
				case T__16:
				case T__17:
				case T__18:
				case T__19:
					{
					setState(180);
					contractDefinition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(186);
			match(EOF);
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
	public static class PragmaDirectiveContext extends ParserRuleContext {
		public PragmaNameContext pragmaName() {
			return getRuleContext(PragmaNameContext.class,0);
		}
		public PragmaValueContext pragmaValue() {
			return getRuleContext(PragmaValueContext.class,0);
		}
		public PragmaDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragmaDirective; }
	}

	public final PragmaDirectiveContext pragmaDirective() throws RecognitionException {
		PragmaDirectiveContext _localctx = new PragmaDirectiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pragmaDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__0);
			setState(189);
			pragmaName();
			setState(190);
			pragmaValue();
			setState(191);
			match(T__1);
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
	public static class PragmaNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PragmaNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragmaName; }
	}

	public final PragmaNameContext pragmaName() throws RecognitionException {
		PragmaNameContext _localctx = new PragmaNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pragmaName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
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
	public static class PragmaValueContext extends ParserRuleContext {
		public VersionContext version() {
			return getRuleContext(VersionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PragmaValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragmaValue; }
	}

	public final PragmaValueContext pragmaValue() throws RecognitionException {
		PragmaValueContext _localctx = new PragmaValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pragmaValue);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				version();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				expression(0);
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
	public static class VersionContext extends ParserRuleContext {
		public List<VersionConstraintContext> versionConstraint() {
			return getRuleContexts(VersionConstraintContext.class);
		}
		public VersionConstraintContext versionConstraint(int i) {
			return getRuleContext(VersionConstraintContext.class,i);
		}
		public VersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_version; }
	}

	public final VersionContext version() throws RecognitionException {
		VersionContext _localctx = new VersionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_version);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			versionConstraint();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1016L) != 0) || _la==VersionLiteral) {
				{
				setState(200);
				versionConstraint();
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
	public static class VersionConstraintContext extends ParserRuleContext {
		public TerminalNode VersionLiteral() { return getToken(SolidityParser.VersionLiteral, 0); }
		public VersionOperatorContext versionOperator() {
			return getRuleContext(VersionOperatorContext.class,0);
		}
		public VersionConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_versionConstraint; }
	}

	public final VersionConstraintContext versionConstraint() throws RecognitionException {
		VersionConstraintContext _localctx = new VersionConstraintContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_versionConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1016L) != 0)) {
				{
				setState(203);
				versionOperator();
				}
			}

			setState(206);
			match(VersionLiteral);
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
	public static class VersionOperatorContext extends ParserRuleContext {
		public VersionOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_versionOperator; }
	}

	public final VersionOperatorContext versionOperator() throws RecognitionException {
		VersionOperatorContext _localctx = new VersionOperatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_versionOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1016L) != 0)) ) {
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
	public static class ImportDirectiveContext extends ParserRuleContext {
		public TerminalNode StringLiteralFragment() { return getToken(SolidityParser.StringLiteralFragment, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public ImportDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDirective; }
	}

	public final ImportDirectiveContext importDirective() throws RecognitionException {
		ImportDirectiveContext _localctx = new ImportDirectiveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_importDirective);
		int _la;
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(T__9);
				setState(211);
				match(StringLiteralFragment);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(212);
					match(T__10);
					setState(213);
					identifier();
					}
				}

				setState(216);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				match(T__9);
				setState(220);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(218);
					match(T__11);
					}
					break;
				case T__12:
				case T__39:
				case T__51:
				case Identifier:
					{
					setState(219);
					identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(222);
					match(T__10);
					setState(223);
					identifier();
					}
				}

				setState(226);
				match(T__12);
				setState(227);
				match(StringLiteralFragment);
				setState(228);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				match(T__9);
				setState(230);
				match(T__13);
				setState(231);
				importDeclaration();
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(232);
					match(T__14);
					setState(233);
					importDeclaration();
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(239);
				match(T__15);
				setState(240);
				match(T__12);
				setState(241);
				match(StringLiteralFragment);
				setState(242);
				match(T__1);
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
	public static class ImportDeclarationContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			identifier();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(247);
				match(T__10);
				setState(248);
				identifier();
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
	public static class ContractDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<InheritanceSpecifierContext> inheritanceSpecifier() {
			return getRuleContexts(InheritanceSpecifierContext.class);
		}
		public InheritanceSpecifierContext inheritanceSpecifier(int i) {
			return getRuleContext(InheritanceSpecifierContext.class,i);
		}
		public List<ContractPartContext> contractPart() {
			return getRuleContexts(ContractPartContext.class);
		}
		public ContractPartContext contractPart(int i) {
			return getRuleContext(ContractPartContext.class,i);
		}
		public ContractDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contractDefinition; }
	}

	public final ContractDefinitionContext contractDefinition() throws RecognitionException {
		ContractDefinitionContext _localctx = new ContractDefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_contractDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(251);
				match(T__16);
				}
			}

			setState(254);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(255);
			identifier();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(256);
				match(T__20);
				setState(257);
				inheritanceSpecifier();
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(258);
					match(T__14);
					setState(259);
					inheritanceSpecifier();
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(267);
			match(T__13);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806969870884864L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 2013265951L) != 0)) {
				{
				{
				setState(268);
				contractPart();
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274);
			match(T__15);
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
	public static class InheritanceSpecifierContext extends ParserRuleContext {
		public UserDefinedTypeNameContext userDefinedTypeName() {
			return getRuleContext(UserDefinedTypeNameContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public InheritanceSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritanceSpecifier; }
	}

	public final InheritanceSpecifierContext inheritanceSpecifier() throws RecognitionException {
		InheritanceSpecifierContext _localctx = new InheritanceSpecifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inheritanceSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			userDefinedTypeName();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(277);
				match(T__21);
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
					{
					setState(278);
					expressionList();
					}
				}

				setState(281);
				match(T__22);
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
	public static class ContractPartContext extends ParserRuleContext {
		public StateVariableDeclarationContext stateVariableDeclaration() {
			return getRuleContext(StateVariableDeclarationContext.class,0);
		}
		public UsingForDeclarationContext usingForDeclaration() {
			return getRuleContext(UsingForDeclarationContext.class,0);
		}
		public StructDefinitionContext structDefinition() {
			return getRuleContext(StructDefinitionContext.class,0);
		}
		public ModifierDefinitionContext modifierDefinition() {
			return getRuleContext(ModifierDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public EventDefinitionContext eventDefinition() {
			return getRuleContext(EventDefinitionContext.class,0);
		}
		public EnumDefinitionContext enumDefinition() {
			return getRuleContext(EnumDefinitionContext.class,0);
		}
		public ContractPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contractPart; }
	}

	public final ContractPartContext contractPart() throws RecognitionException {
		ContractPartContext _localctx = new ContractPartContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_contractPart);
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				stateVariableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				usingForDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				structDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(287);
				modifierDefinition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(288);
				functionDefinition();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(289);
				eventDefinition();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(290);
				enumDefinition();
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
	public static class StateVariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> PublicKeyword() { return getTokens(SolidityParser.PublicKeyword); }
		public TerminalNode PublicKeyword(int i) {
			return getToken(SolidityParser.PublicKeyword, i);
		}
		public List<TerminalNode> InternalKeyword() { return getTokens(SolidityParser.InternalKeyword); }
		public TerminalNode InternalKeyword(int i) {
			return getToken(SolidityParser.InternalKeyword, i);
		}
		public List<TerminalNode> PrivateKeyword() { return getTokens(SolidityParser.PrivateKeyword); }
		public TerminalNode PrivateKeyword(int i) {
			return getToken(SolidityParser.PrivateKeyword, i);
		}
		public List<TerminalNode> ConstantKeyword() { return getTokens(SolidityParser.ConstantKeyword); }
		public TerminalNode ConstantKeyword(int i) {
			return getToken(SolidityParser.ConstantKeyword, i);
		}
		public List<TerminalNode> ImmutableKeyword() { return getTokens(SolidityParser.ImmutableKeyword); }
		public TerminalNode ImmutableKeyword(int i) {
			return getToken(SolidityParser.ImmutableKeyword, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StateVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateVariableDeclaration; }
	}

	public final StateVariableDeclarationContext stateVariableDeclaration() throws RecognitionException {
		StateVariableDeclarationContext _localctx = new StateVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stateVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			typeName(0);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23 || ((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 835L) != 0)) {
				{
				setState(300);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PublicKeyword:
					{
					setState(294);
					match(PublicKeyword);
					}
					break;
				case InternalKeyword:
					{
					setState(295);
					match(InternalKeyword);
					}
					break;
				case PrivateKeyword:
					{
					setState(296);
					match(PrivateKeyword);
					}
					break;
				case ConstantKeyword:
					{
					setState(297);
					match(ConstantKeyword);
					}
					break;
				case ImmutableKeyword:
					{
					setState(298);
					match(ImmutableKeyword);
					}
					break;
				case T__23:
					{
					setState(299);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(305);
			identifier();
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(306);
				match(T__8);
				setState(307);
				expression(0);
				}
			}

			setState(310);
			match(T__1);
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
	public static class OverrideSpecifierContext extends ParserRuleContext {
		public List<UserDefinedTypeNameContext> userDefinedTypeName() {
			return getRuleContexts(UserDefinedTypeNameContext.class);
		}
		public UserDefinedTypeNameContext userDefinedTypeName(int i) {
			return getRuleContext(UserDefinedTypeNameContext.class,i);
		}
		public OverrideSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overrideSpecifier; }
	}

	public final OverrideSpecifierContext overrideSpecifier() throws RecognitionException {
		OverrideSpecifierContext _localctx = new OverrideSpecifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_overrideSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(T__23);
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(313);
				match(T__21);
				setState(314);
				userDefinedTypeName();
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(315);
					match(T__14);
					setState(316);
					userDefinedTypeName();
					}
					}
					setState(321);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(322);
				match(T__22);
				}
				break;
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
	public static class UsingForDeclarationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public UsingForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingForDeclaration; }
	}

	public final UsingForDeclarationContext usingForDeclaration() throws RecognitionException {
		UsingForDeclarationContext _localctx = new UsingForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_usingForDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(T__24);
			setState(327);
			identifier();
			setState(328);
			match(T__25);
			setState(331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(329);
				match(T__11);
				}
				break;
			case T__12:
			case T__28:
			case T__35:
			case T__39:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case Int:
			case Uint:
			case Byte:
			case Fixed:
			case Ufixed:
			case Identifier:
				{
				setState(330);
				typeName(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(333);
			match(T__1);
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
	public static class StructDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public StructDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDefinition; }
	}

	public final StructDefinitionContext structDefinition() throws RecognitionException {
		StructDefinitionContext _localctx = new StructDefinitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_structDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(T__26);
			setState(336);
			identifier();
			setState(337);
			match(T__13);
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806962992226304L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 1073741855L) != 0)) {
				{
				setState(338);
				variableDeclaration();
				setState(339);
				match(T__1);
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806962992226304L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 1073741855L) != 0)) {
					{
					{
					setState(340);
					variableDeclaration();
					setState(341);
					match(T__1);
					}
					}
					setState(347);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(350);
			match(T__15);
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
	public static class ModifierDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public List<TerminalNode> VirtualKeyword() { return getTokens(SolidityParser.VirtualKeyword); }
		public TerminalNode VirtualKeyword(int i) {
			return getToken(SolidityParser.VirtualKeyword, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public ModifierDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierDefinition; }
	}

	public final ModifierDefinitionContext modifierDefinition() throws RecognitionException {
		ModifierDefinitionContext _localctx = new ModifierDefinitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_modifierDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(T__27);
			setState(353);
			identifier();
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(354);
				parameterList();
				}
			}

			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23 || _la==VirtualKeyword) {
				{
				setState(359);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VirtualKeyword:
					{
					setState(357);
					match(VirtualKeyword);
					}
					break;
				case T__23:
					{
					setState(358);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(364);
				match(T__1);
				}
				break;
			case T__13:
				{
				setState(365);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionDescriptorContext functionDescriptor() {
			return getRuleContext(FunctionDescriptorContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ReturnParametersContext returnParameters() {
			return getRuleContext(ReturnParametersContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			functionDescriptor();
			setState(369);
			parameterList();
			setState(370);
			modifierList();
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(371);
				returnParameters();
				}
			}

			setState(376);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(374);
				match(T__1);
				}
				break;
			case T__13:
				{
				setState(375);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class FunctionDescriptorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ReceiveKeyword() { return getToken(SolidityParser.ReceiveKeyword, 0); }
		public TerminalNode FallbackKeyword() { return getToken(SolidityParser.FallbackKeyword, 0); }
		public TerminalNode ConstructorKeyword() { return getToken(SolidityParser.ConstructorKeyword, 0); }
		public FunctionDescriptorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDescriptor; }
	}

	public final FunctionDescriptorContext functionDescriptor() throws RecognitionException {
		FunctionDescriptorContext _localctx = new FunctionDescriptorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionDescriptor);
		try {
			setState(387);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(378);
				match(T__28);
				setState(382);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__12:
				case T__39:
				case T__51:
				case Identifier:
					{
					setState(379);
					identifier();
					}
					break;
				case ReceiveKeyword:
					{
					setState(380);
					match(ReceiveKeyword);
					}
					break;
				case FallbackKeyword:
					{
					setState(381);
					match(FallbackKeyword);
					}
					break;
				case T__21:
					break;
				default:
					break;
				}
				}
				break;
			case ConstructorKeyword:
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				match(ConstructorKeyword);
				}
				break;
			case FallbackKeyword:
				enterOuterAlt(_localctx, 3);
				{
				setState(385);
				match(FallbackKeyword);
				}
				break;
			case ReceiveKeyword:
				enterOuterAlt(_localctx, 4);
				{
				setState(386);
				match(ReceiveKeyword);
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
	public static class ReturnParametersContext extends ParserRuleContext {
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ReturnParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnParameters; }
	}

	public final ReturnParametersContext returnParameters() throws RecognitionException {
		ReturnParametersContext _localctx = new ReturnParametersContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnParameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(T__29);
			setState(390);
			parameterList();
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
	public static class ModifierListContext extends ParserRuleContext {
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<StateMutabilityContext> stateMutability() {
			return getRuleContexts(StateMutabilityContext.class);
		}
		public StateMutabilityContext stateMutability(int i) {
			return getRuleContext(StateMutabilityContext.class,i);
		}
		public List<TerminalNode> ExternalKeyword() { return getTokens(SolidityParser.ExternalKeyword); }
		public TerminalNode ExternalKeyword(int i) {
			return getToken(SolidityParser.ExternalKeyword, i);
		}
		public List<TerminalNode> PublicKeyword() { return getTokens(SolidityParser.PublicKeyword); }
		public TerminalNode PublicKeyword(int i) {
			return getToken(SolidityParser.PublicKeyword, i);
		}
		public List<TerminalNode> InternalKeyword() { return getTokens(SolidityParser.InternalKeyword); }
		public TerminalNode InternalKeyword(int i) {
			return getToken(SolidityParser.InternalKeyword, i);
		}
		public List<TerminalNode> PrivateKeyword() { return getTokens(SolidityParser.PrivateKeyword); }
		public TerminalNode PrivateKeyword(int i) {
			return getToken(SolidityParser.PrivateKeyword, i);
		}
		public List<TerminalNode> VirtualKeyword() { return getTokens(SolidityParser.VirtualKeyword); }
		public TerminalNode VirtualKeyword(int i) {
			return getToken(SolidityParser.VirtualKeyword, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public ModifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierList; }
	}

	public final ModifierListContext modifierList() throws RecognitionException {
		ModifierListContext _localctx = new ModifierListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_modifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(400);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__12:
					case T__39:
					case T__51:
					case Identifier:
						{
						setState(392);
						modifierInvocation();
						}
						break;
					case ConstantKeyword:
					case PayableKeyword:
					case PureKeyword:
					case ViewKeyword:
						{
						setState(393);
						stateMutability();
						}
						break;
					case ExternalKeyword:
						{
						setState(394);
						match(ExternalKeyword);
						}
						break;
					case PublicKeyword:
						{
						setState(395);
						match(PublicKeyword);
						}
						break;
					case InternalKeyword:
						{
						setState(396);
						match(InternalKeyword);
						}
						break;
					case PrivateKeyword:
						{
						setState(397);
						match(PrivateKeyword);
						}
						break;
					case VirtualKeyword:
						{
						setState(398);
						match(VirtualKeyword);
						}
						break;
					case T__23:
						{
						setState(399);
						overrideSpecifier();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(404);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
	public static class ModifierInvocationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ModifierInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierInvocation; }
	}

	public final ModifierInvocationContext modifierInvocation() throws RecognitionException {
		ModifierInvocationContext _localctx = new ModifierInvocationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_modifierInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			identifier();
			setState(411);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(406);
				match(T__21);
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
					{
					setState(407);
					expressionList();
					}
				}

				setState(410);
				match(T__22);
				}
				break;
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
	public static class EventDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EventParameterListContext eventParameterList() {
			return getRuleContext(EventParameterListContext.class,0);
		}
		public TerminalNode AnonymousKeyword() { return getToken(SolidityParser.AnonymousKeyword, 0); }
		public EventDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventDefinition; }
	}

	public final EventDefinitionContext eventDefinition() throws RecognitionException {
		EventDefinitionContext _localctx = new EventDefinitionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_eventDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(T__30);
			setState(414);
			identifier();
			setState(415);
			eventParameterList();
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AnonymousKeyword) {
				{
				setState(416);
				match(AnonymousKeyword);
				}
			}

			setState(419);
			match(T__1);
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
	public static class EnumDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<EnumValueContext> enumValue() {
			return getRuleContexts(EnumValueContext.class);
		}
		public EnumValueContext enumValue(int i) {
			return getRuleContext(EnumValueContext.class,i);
		}
		public EnumDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDefinition; }
	}

	public final EnumDefinitionContext enumDefinition() throws RecognitionException {
		EnumDefinitionContext _localctx = new EnumDefinitionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_enumDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(T__31);
			setState(422);
			identifier();
			setState(423);
			match(T__13);
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504699139006464L) != 0) || _la==Identifier) {
				{
				setState(424);
				enumValue();
				}
			}

			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(427);
				match(T__14);
				setState(428);
				enumValue();
				}
				}
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(434);
			match(T__15);
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
	public static class EnumValueContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EnumValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumValue; }
	}

	public final EnumValueContext enumValue() throws RecognitionException {
		EnumValueContext _localctx = new EnumValueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_enumValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
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
	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(T__21);
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806962992226304L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 1073741855L) != 0)) {
				{
				setState(439);
				parameter();
				setState(444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(440);
					match(T__14);
					setState(441);
					parameter();
					}
					}
					setState(446);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(449);
			match(T__22);
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
	public static class ParameterContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public StorageLocationContext storageLocation() {
			return getRuleContext(StorageLocationContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			typeName(0);
			setState(453);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(452);
				storageLocation();
				}
				break;
			}
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504699139006464L) != 0) || _la==Identifier) {
				{
				setState(455);
				identifier();
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
	public static class EventParameterListContext extends ParserRuleContext {
		public List<EventParameterContext> eventParameter() {
			return getRuleContexts(EventParameterContext.class);
		}
		public EventParameterContext eventParameter(int i) {
			return getRuleContext(EventParameterContext.class,i);
		}
		public EventParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventParameterList; }
	}

	public final EventParameterListContext eventParameterList() throws RecognitionException {
		EventParameterListContext _localctx = new EventParameterListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_eventParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(T__21);
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806962992226304L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 1073741855L) != 0)) {
				{
				setState(459);
				eventParameter();
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(460);
					match(T__14);
					setState(461);
					eventParameter();
					}
					}
					setState(466);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(469);
			match(T__22);
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
	public static class EventParameterContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode IndexedKeyword() { return getToken(SolidityParser.IndexedKeyword, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EventParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventParameter; }
	}

	public final EventParameterContext eventParameter() throws RecognitionException {
		EventParameterContext _localctx = new EventParameterContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_eventParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			typeName(0);
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IndexedKeyword) {
				{
				setState(472);
				match(IndexedKeyword);
				}
			}

			setState(476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504699139006464L) != 0) || _la==Identifier) {
				{
				setState(475);
				identifier();
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
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StorageLocationContext storageLocation() {
			return getRuleContext(StorageLocationContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			typeName(0);
			setState(480);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(479);
				storageLocation();
				}
				break;
			}
			setState(482);
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
	public static class TypeNameContext extends ParserRuleContext {
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public UserDefinedTypeNameContext userDefinedTypeName() {
			return getRuleContext(UserDefinedTypeNameContext.class,0);
		}
		public MappingContext mapping() {
			return getRuleContext(MappingContext.class,0);
		}
		public FunctionTypeNameContext functionTypeName() {
			return getRuleContext(FunctionTypeNameContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
	}

	public final TypeNameContext typeName() throws RecognitionException {
		return typeName(0);
	}

	private TypeNameContext typeName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeNameContext _localctx = new TypeNameContext(_ctx, _parentState);
		TypeNameContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_typeName, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(485);
				elementaryTypeName();
				}
				break;
			case 2:
				{
				setState(486);
				userDefinedTypeName();
				}
				break;
			case 3:
				{
				setState(487);
				mapping();
				}
				break;
			case 4:
				{
				setState(488);
				functionTypeName();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(499);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeName);
					setState(491);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(492);
					match(T__32);
					setState(494);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
						{
						setState(493);
						expression(0);
						}
					}

					setState(496);
					match(T__33);
					}
					} 
				}
				setState(501);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UserDefinedTypeNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public UserDefinedTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedTypeName; }
	}

	public final UserDefinedTypeNameContext userDefinedTypeName() throws RecognitionException {
		UserDefinedTypeNameContext _localctx = new UserDefinedTypeNameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_userDefinedTypeName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			identifier();
			setState(507);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(503);
					match(T__34);
					setState(504);
					identifier();
					}
					} 
				}
				setState(509);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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
	public static class MappingContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public UserDefinedTypeNameContext userDefinedTypeName() {
			return getRuleContext(UserDefinedTypeNameContext.class,0);
		}
		public MappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping; }
	}

	public final MappingContext mapping() throws RecognitionException {
		MappingContext _localctx = new MappingContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_mapping);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			match(T__35);
			setState(511);
			match(T__21);
			setState(514);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(512);
				elementaryTypeName();
				}
				break;
			case 2:
				{
				setState(513);
				userDefinedTypeName();
				}
				break;
			}
			setState(516);
			match(T__36);
			setState(517);
			typeName(0);
			setState(518);
			match(T__22);
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
	public static class FunctionTypeNameContext extends ParserRuleContext {
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public ReturnParametersContext returnParameters() {
			return getRuleContext(ReturnParametersContext.class,0);
		}
		public FunctionTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionTypeName; }
	}

	public final FunctionTypeNameContext functionTypeName() throws RecognitionException {
		FunctionTypeNameContext _localctx = new FunctionTypeNameContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_functionTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			match(T__28);
			setState(521);
			parameterList();
			setState(522);
			modifierList();
			setState(524);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(523);
				returnParameters();
				}
				break;
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
	public static class StorageLocationContext extends ParserRuleContext {
		public StorageLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageLocation; }
	}

	public final StorageLocationContext storageLocation() throws RecognitionException {
		StorageLocationContext _localctx = new StorageLocationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_storageLocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1924145348608L) != 0)) ) {
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
	public static class StateMutabilityContext extends ParserRuleContext {
		public TerminalNode PureKeyword() { return getToken(SolidityParser.PureKeyword, 0); }
		public TerminalNode ConstantKeyword() { return getToken(SolidityParser.ConstantKeyword, 0); }
		public TerminalNode ViewKeyword() { return getToken(SolidityParser.ViewKeyword, 0); }
		public TerminalNode PayableKeyword() { return getToken(SolidityParser.PayableKeyword, 0); }
		public StateMutabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateMutability; }
	}

	public final StateMutabilityContext stateMutability() throws RecognitionException {
		StateMutabilityContext _localctx = new StateMutabilityContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_stateMutability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			_la = _input.LA(1);
			if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 10369L) != 0)) ) {
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
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			match(T__13);
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -576483764129996784L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747979808362463233L) != 0)) {
				{
				{
				setState(531);
				statement();
				}
				}
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(537);
			match(T__15);
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
	public static class StatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public InlineAssemblyStatementContext inlineAssemblyStatement() {
			return getRuleContext(InlineAssemblyStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public EmitStatementContext emitStatement() {
			return getRuleContext(EmitStatementContext.class,0);
		}
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_statement);
		try {
			setState(552);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__40:
				enterOuterAlt(_localctx, 1);
				{
				setState(539);
				ifStatement();
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				tryStatement();
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 3);
				{
				setState(541);
				whileStatement();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 4);
				{
				setState(542);
				forStatement();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(543);
				block();
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 6);
				{
				setState(544);
				inlineAssemblyStatement();
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 7);
				{
				setState(545);
				doWhileStatement();
				}
				break;
			case ContinueKeyword:
				enterOuterAlt(_localctx, 8);
				{
				setState(546);
				continueStatement();
				}
				break;
			case BreakKeyword:
				enterOuterAlt(_localctx, 9);
				{
				setState(547);
				breakStatement();
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 10);
				{
				setState(548);
				returnStatement();
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 11);
				{
				setState(549);
				throwStatement();
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 12);
				{
				setState(550);
				emitStatement();
				}
				break;
			case T__3:
			case T__12:
			case T__21:
			case T__28:
			case T__32:
			case T__35:
			case T__39:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case Int:
			case Uint:
			case Byte:
			case Fixed:
			case Ufixed:
			case BooleanLiteral:
			case DecimalNumber:
			case HexNumber:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
				enterOuterAlt(_localctx, 13);
				{
				setState(551);
				simpleStatement();
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
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			expression(0);
			setState(555);
			match(T__1);
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
	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			match(T__40);
			setState(558);
			match(T__21);
			setState(559);
			expression(0);
			setState(560);
			match(T__22);
			setState(561);
			statement();
			setState(564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(562);
				match(T__41);
				setState(563);
				statement();
				}
				break;
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
	public static class TryStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ReturnParametersContext returnParameters() {
			return getRuleContext(ReturnParametersContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_tryStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			match(T__42);
			setState(567);
			expression(0);
			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(568);
				returnParameters();
				}
			}

			setState(571);
			block();
			setState(573); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(572);
				catchClause();
				}
				}
				setState(575); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__43 );
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
	public static class CatchClauseContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			match(T__43);
			setState(582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504699143200768L) != 0) || _la==Identifier) {
				{
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504699139006464L) != 0) || _la==Identifier) {
					{
					setState(578);
					identifier();
					}
				}

				setState(581);
				parameterList();
				}
			}

			setState(584);
			block();
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
	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			match(T__44);
			setState(587);
			match(T__21);
			setState(588);
			expression(0);
			setState(589);
			match(T__22);
			setState(590);
			statement();
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
	public static class ForStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592);
			match(T__25);
			setState(593);
			match(T__21);
			setState(596);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__12:
			case T__21:
			case T__28:
			case T__32:
			case T__35:
			case T__39:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case Int:
			case Uint:
			case Byte:
			case Fixed:
			case Ufixed:
			case BooleanLiteral:
			case DecimalNumber:
			case HexNumber:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
				{
				setState(594);
				simpleStatement();
				}
				break;
			case T__1:
				{
				setState(595);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(600);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__12:
			case T__21:
			case T__32:
			case T__39:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case Int:
			case Uint:
			case Byte:
			case Fixed:
			case Ufixed:
			case BooleanLiteral:
			case DecimalNumber:
			case HexNumber:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
				{
				setState(598);
				expressionStatement();
				}
				break;
			case T__1:
				{
				setState(599);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(603);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
				{
				setState(602);
				expression(0);
				}
			}

			setState(605);
			match(T__22);
			setState(606);
			statement();
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
	public static class SimpleStatementContext extends ParserRuleContext {
		public VariableDeclarationStatementContext variableDeclarationStatement() {
			return getRuleContext(VariableDeclarationStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SimpleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStatement; }
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_simpleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(608);
				variableDeclarationStatement();
				}
				break;
			case 2:
				{
				setState(609);
				expressionStatement();
				}
				break;
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
	public static class InlineAssemblyStatementContext extends ParserRuleContext {
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public TerminalNode StringLiteralFragment() { return getToken(SolidityParser.StringLiteralFragment, 0); }
		public InlineAssemblyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineAssemblyStatement; }
	}

	public final InlineAssemblyStatementContext inlineAssemblyStatement() throws RecognitionException {
		InlineAssemblyStatementContext _localctx = new InlineAssemblyStatementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_inlineAssemblyStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			match(T__45);
			setState(614);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==StringLiteralFragment) {
				{
				setState(613);
				match(StringLiteralFragment);
				}
			}

			setState(616);
			assemblyBlock();
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
	public static class DoWhileStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618);
			match(T__46);
			setState(619);
			statement();
			setState(620);
			match(T__44);
			setState(621);
			match(T__21);
			setState(622);
			expression(0);
			setState(623);
			match(T__22);
			setState(624);
			match(T__1);
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
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode ContinueKeyword() { return getToken(SolidityParser.ContinueKeyword, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			match(ContinueKeyword);
			setState(627);
			match(T__1);
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
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode BreakKeyword() { return getToken(SolidityParser.BreakKeyword, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			match(BreakKeyword);
			setState(630);
			match(T__1);
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
	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			match(T__47);
			setState(634);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
				{
				setState(633);
				expression(0);
				}
			}

			setState(636);
			match(T__1);
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
	public static class ThrowStatementContext extends ParserRuleContext {
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638);
			match(T__48);
			setState(639);
			match(T__1);
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
	public static class EmitStatementContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public EmitStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emitStatement; }
	}

	public final EmitStatementContext emitStatement() throws RecognitionException {
		EmitStatementContext _localctx = new EmitStatementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_emitStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			match(T__49);
			setState(642);
			functionCall();
			setState(643);
			match(T__1);
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
	public static class VariableDeclarationStatementContext extends ParserRuleContext {
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableDeclarationListContext variableDeclarationList() {
			return getRuleContext(VariableDeclarationListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationStatement; }
	}

	public final VariableDeclarationStatementContext variableDeclarationStatement() throws RecognitionException {
		VariableDeclarationStatementContext _localctx = new VariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_variableDeclarationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(645);
				match(T__50);
				setState(646);
				identifierList();
				}
				break;
			case 2:
				{
				setState(647);
				variableDeclaration();
				}
				break;
			case 3:
				{
				setState(648);
				match(T__21);
				setState(649);
				variableDeclarationList();
				setState(650);
				match(T__22);
				}
				break;
			}
			setState(656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(654);
				match(T__8);
				setState(655);
				expression(0);
				}
			}

			setState(658);
			match(T__1);
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
	public static class VariableDeclarationListContext extends ParserRuleContext {
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public VariableDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationList; }
	}

	public final VariableDeclarationListContext variableDeclarationList() throws RecognitionException {
		VariableDeclarationListContext _localctx = new VariableDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_variableDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806962992226304L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 1073741855L) != 0)) {
				{
				setState(660);
				variableDeclaration();
				}
			}

			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(663);
				match(T__14);
				setState(665);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69806962992226304L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 1073741855L) != 0)) {
					{
					setState(664);
					variableDeclaration();
					}
				}

				}
				}
				setState(671);
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
	public static class IdentifierListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_identifierList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			match(T__21);
			setState(679);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(674);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504699139006464L) != 0) || _la==Identifier) {
						{
						setState(673);
						identifier();
						}
					}

					setState(676);
					match(T__14);
					}
					} 
				}
				setState(681);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			}
			setState(683);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504699139006464L) != 0) || _la==Identifier) {
				{
				setState(682);
				identifier();
				}
			}

			setState(685);
			match(T__22);
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
	public static class ElementaryTypeNameContext extends ParserRuleContext {
		public TerminalNode PayableKeyword() { return getToken(SolidityParser.PayableKeyword, 0); }
		public TerminalNode Int() { return getToken(SolidityParser.Int, 0); }
		public TerminalNode Uint() { return getToken(SolidityParser.Uint, 0); }
		public TerminalNode Byte() { return getToken(SolidityParser.Byte, 0); }
		public TerminalNode Fixed() { return getToken(SolidityParser.Fixed, 0); }
		public TerminalNode Ufixed() { return getToken(SolidityParser.Ufixed, 0); }
		public ElementaryTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementaryTypeName; }
	}

	public final ElementaryTypeNameContext elementaryTypeName() throws RecognitionException {
		ElementaryTypeNameContext _localctx = new ElementaryTypeNameContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_elementaryTypeName);
		try {
			setState(700);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__51:
				enterOuterAlt(_localctx, 1);
				{
				setState(687);
				match(T__51);
				setState(689);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(688);
					match(PayableKeyword);
					}
					break;
				}
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 2);
				{
				setState(691);
				match(T__52);
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 3);
				{
				setState(692);
				match(T__53);
				}
				break;
			case T__50:
				enterOuterAlt(_localctx, 4);
				{
				setState(693);
				match(T__50);
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 5);
				{
				setState(694);
				match(Int);
				}
				break;
			case Uint:
				enterOuterAlt(_localctx, 6);
				{
				setState(695);
				match(Uint);
				}
				break;
			case T__54:
				enterOuterAlt(_localctx, 7);
				{
				setState(696);
				match(T__54);
				}
				break;
			case Byte:
				enterOuterAlt(_localctx, 8);
				{
				setState(697);
				match(Byte);
				}
				break;
			case Fixed:
				enterOuterAlt(_localctx, 9);
				{
				setState(698);
				match(Fixed);
				}
				break;
			case Ufixed:
				enterOuterAlt(_localctx, 10);
				{
				setState(699);
				match(Ufixed);
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
	public static class ExpressionContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode PayableKeyword() { return getToken(SolidityParser.PayableKeyword, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public NameValueListContext nameValueList() {
			return getRuleContext(NameValueListContext.class,0);
		}
		public FunctionCallArgumentsContext functionCallArguments() {
			return getRuleContext(FunctionCallArgumentsContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 112;
		enterRecursionRule(_localctx, 112, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				{
				setState(703);
				match(T__57);
				setState(704);
				typeName(0);
				}
				break;
			case 2:
				{
				setState(705);
				match(PayableKeyword);
				setState(706);
				match(T__21);
				setState(707);
				expression(0);
				setState(708);
				match(T__22);
				}
				break;
			case 3:
				{
				setState(710);
				match(T__21);
				setState(711);
				expression(0);
				setState(712);
				match(T__22);
				}
				break;
			case 4:
				{
				setState(714);
				_la = _input.LA(1);
				if ( !(_la==T__55 || _la==T__56) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(715);
				expression(19);
				}
				break;
			case 5:
				{
				setState(716);
				_la = _input.LA(1);
				if ( !(_la==T__59 || _la==T__60) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(717);
				expression(18);
				}
				break;
			case 6:
				{
				setState(718);
				_la = _input.LA(1);
				if ( !(_la==T__61 || _la==T__62) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(719);
				expression(17);
				}
				break;
			case 7:
				{
				setState(720);
				match(T__63);
				setState(721);
				expression(16);
				}
				break;
			case 8:
				{
				setState(722);
				match(T__3);
				setState(723);
				expression(15);
				}
				break;
			case 9:
				{
				setState(724);
				primaryExpression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(802);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(800);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(727);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(728);
						match(T__64);
						setState(729);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(730);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(731);
						_la = _input.LA(1);
						if ( !(((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & 54043195528445953L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(732);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(733);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(734);
						_la = _input.LA(1);
						if ( !(_la==T__59 || _la==T__60) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(735);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(736);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(737);
						_la = _input.LA(1);
						if ( !(_la==T__67 || _la==T__68) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(738);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(739);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(740);
						match(T__69);
						setState(741);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(742);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(743);
						match(T__2);
						setState(744);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(745);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(746);
						match(T__70);
						setState(747);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(748);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(749);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(750);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(751);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(752);
						_la = _input.LA(1);
						if ( !(_la==T__71 || _la==T__72) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(753);
						expression(7);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(754);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(755);
						match(T__73);
						setState(756);
						expression(6);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(757);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(758);
						match(T__74);
						setState(759);
						expression(5);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(760);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(761);
						match(T__75);
						setState(762);
						expression(0);
						setState(763);
						match(T__58);
						setState(764);
						expression(4);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(766);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(767);
						_la = _input.LA(1);
						if ( !(_la==T__8 || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 1023L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(768);
						expression(3);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(769);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(770);
						_la = _input.LA(1);
						if ( !(_la==T__55 || _la==T__56) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(771);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(772);
						match(T__32);
						setState(774);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
							{
							setState(773);
							expression(0);
							}
						}

						setState(776);
						match(T__33);
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(777);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(778);
						match(T__32);
						setState(780);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
							{
							setState(779);
							expression(0);
							}
						}

						setState(782);
						match(T__58);
						setState(784);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
							{
							setState(783);
							expression(0);
							}
						}

						setState(786);
						match(T__33);
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(787);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(788);
						match(T__34);
						setState(789);
						identifier();
						}
						break;
					case 18:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(790);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(791);
						match(T__13);
						setState(792);
						nameValueList();
						setState(793);
						match(T__15);
						}
						break;
					case 19:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(795);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(796);
						match(T__21);
						setState(797);
						functionCallArguments();
						setState(798);
						match(T__22);
						}
						break;
					}
					} 
				}
				setState(804);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode BooleanLiteral() { return getToken(SolidityParser.BooleanLiteral, 0); }
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public HexLiteralContext hexLiteral() {
			return getRuleContext(HexLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode TypeKeyword() { return getToken(SolidityParser.TypeKeyword, 0); }
		public TupleExpressionContext tupleExpression() {
			return getRuleContext(TupleExpressionContext.class,0);
		}
		public TypeNameExpressionContext typeNameExpression() {
			return getRuleContext(TypeNameExpressionContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_primaryExpression);
		try {
			setState(821);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(805);
				match(BooleanLiteral);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(806);
				numberLiteral();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(807);
				hexLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(808);
				stringLiteral();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(809);
				identifier();
				setState(812);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
				case 1:
					{
					setState(810);
					match(T__32);
					setState(811);
					match(T__33);
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(814);
				match(TypeKeyword);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(815);
				tupleExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(816);
				typeNameExpression();
				setState(819);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(817);
					match(T__32);
					setState(818);
					match(T__33);
					}
					break;
				}
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
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(823);
			expression(0);
			setState(828);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(824);
				match(T__14);
				setState(825);
				expression(0);
				}
				}
				setState(830);
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
	public static class NameValueListContext extends ParserRuleContext {
		public List<NameValueContext> nameValue() {
			return getRuleContexts(NameValueContext.class);
		}
		public NameValueContext nameValue(int i) {
			return getRuleContext(NameValueContext.class,i);
		}
		public NameValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameValueList; }
	}

	public final NameValueListContext nameValueList() throws RecognitionException {
		NameValueListContext _localctx = new NameValueListContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_nameValueList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			nameValue();
			setState(836);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(832);
					match(T__14);
					setState(833);
					nameValue();
					}
					} 
				}
				setState(838);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			}
			setState(840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(839);
				match(T__14);
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
	public static class NameValueContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NameValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameValue; }
	}

	public final NameValueContext nameValue() throws RecognitionException {
		NameValueContext _localctx = new NameValueContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_nameValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
			identifier();
			setState(843);
			match(T__58);
			setState(844);
			expression(0);
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
	public static class FunctionCallArgumentsContext extends ParserRuleContext {
		public NameValueListContext nameValueList() {
			return getRuleContext(NameValueListContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FunctionCallArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallArguments; }
	}

	public final FunctionCallArgumentsContext functionCallArguments() throws RecognitionException {
		FunctionCallArgumentsContext _localctx = new FunctionCallArgumentsContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_functionCallArguments);
		int _la;
		try {
			setState(854);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(846);
				match(T__13);
				setState(848);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504699139006464L) != 0) || _la==Identifier) {
					{
					setState(847);
					nameValueList();
					}
				}

				setState(850);
				match(T__15);
				}
				break;
			case T__3:
			case T__12:
			case T__21:
			case T__22:
			case T__32:
			case T__39:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case Int:
			case Uint:
			case Byte:
			case Fixed:
			case Ufixed:
			case BooleanLiteral:
			case DecimalNumber:
			case HexNumber:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
				enterOuterAlt(_localctx, 2);
				{
				setState(852);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
					{
					setState(851);
					expressionList();
					}
				}

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
	public static class FunctionCallContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionCallArgumentsContext functionCallArguments() {
			return getRuleContext(FunctionCallArgumentsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(856);
			expression(0);
			setState(857);
			match(T__21);
			setState(858);
			functionCallArguments();
			setState(859);
			match(T__22);
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
	public static class TupleExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TupleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleExpression; }
	}

	public final TupleExpressionContext tupleExpression() throws RecognitionException {
		TupleExpressionContext _localctx = new TupleExpressionContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_tupleExpression);
		int _la;
		try {
			setState(887);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(861);
				match(T__21);
				{
				setState(863);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
					{
					setState(862);
					expression(0);
					}
				}

				setState(871);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(865);
					match(T__14);
					setState(867);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
						{
						setState(866);
						expression(0);
						}
					}

					}
					}
					setState(873);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(874);
				match(T__22);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(875);
				match(T__32);
				setState(884);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -578711444011343856L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1747960017153163265L) != 0)) {
					{
					setState(876);
					expression(0);
					setState(881);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__14) {
						{
						{
						setState(877);
						match(T__14);
						setState(878);
						expression(0);
						}
						}
						setState(883);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(886);
				match(T__33);
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
	public static class TypeNameExpressionContext extends ParserRuleContext {
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public UserDefinedTypeNameContext userDefinedTypeName() {
			return getRuleContext(UserDefinedTypeNameContext.class,0);
		}
		public TypeNameExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeNameExpression; }
	}

	public final TypeNameExpressionContext typeNameExpression() throws RecognitionException {
		TypeNameExpressionContext _localctx = new TypeNameExpressionContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_typeNameExpression);
		try {
			setState(891);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(889);
				elementaryTypeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(890);
				userDefinedTypeName();
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
	public static class AssemblyItemContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public AssemblyLocalDefinitionContext assemblyLocalDefinition() {
			return getRuleContext(AssemblyLocalDefinitionContext.class,0);
		}
		public AssemblyAssignmentContext assemblyAssignment() {
			return getRuleContext(AssemblyAssignmentContext.class,0);
		}
		public AssemblyStackAssignmentContext assemblyStackAssignment() {
			return getRuleContext(AssemblyStackAssignmentContext.class,0);
		}
		public LabelDefinitionContext labelDefinition() {
			return getRuleContext(LabelDefinitionContext.class,0);
		}
		public AssemblySwitchContext assemblySwitch() {
			return getRuleContext(AssemblySwitchContext.class,0);
		}
		public AssemblyFunctionDefinitionContext assemblyFunctionDefinition() {
			return getRuleContext(AssemblyFunctionDefinitionContext.class,0);
		}
		public AssemblyForContext assemblyFor() {
			return getRuleContext(AssemblyForContext.class,0);
		}
		public AssemblyIfContext assemblyIf() {
			return getRuleContext(AssemblyIfContext.class,0);
		}
		public TerminalNode BreakKeyword() { return getToken(SolidityParser.BreakKeyword, 0); }
		public TerminalNode ContinueKeyword() { return getToken(SolidityParser.ContinueKeyword, 0); }
		public TerminalNode LeaveKeyword() { return getToken(SolidityParser.LeaveKeyword, 0); }
		public SubAssemblyContext subAssembly() {
			return getRuleContext(SubAssemblyContext.class,0);
		}
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public HexLiteralContext hexLiteral() {
			return getRuleContext(HexLiteralContext.class,0);
		}
		public AssemblyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyItem; }
	}

	public final AssemblyItemContext assemblyItem() throws RecognitionException {
		AssemblyItemContext _localctx = new AssemblyItemContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_assemblyItem);
		try {
			setState(911);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(893);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(894);
				assemblyBlock();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(895);
				assemblyExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(896);
				assemblyLocalDefinition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(897);
				assemblyAssignment();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(898);
				assemblyStackAssignment();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(899);
				labelDefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(900);
				assemblySwitch();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(901);
				assemblyFunctionDefinition();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(902);
				assemblyFor();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(903);
				assemblyIf();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(904);
				match(BreakKeyword);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(905);
				match(ContinueKeyword);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(906);
				match(LeaveKeyword);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(907);
				subAssembly();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(908);
				numberLiteral();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(909);
				stringLiteral();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(910);
				hexLiteral();
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
	public static class AssemblyBlockContext extends ParserRuleContext {
		public List<AssemblyItemContext> assemblyItem() {
			return getRuleContexts(AssemblyItemContext.class);
		}
		public AssemblyItemContext assemblyItem(int i) {
			return getRuleContext(AssemblyItemContext.class,i);
		}
		public AssemblyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyBlock; }
	}

	public final AssemblyBlockContext assemblyBlock() throws RecognitionException {
		AssemblyBlockContext _localctx = new AssemblyBlockContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_assemblyBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(913);
			match(T__13);
			setState(917);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 40887539506110464L) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 206165030925L) != 0)) {
				{
				{
				setState(914);
				assemblyItem();
				}
				}
				setState(919);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(920);
			match(T__15);
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
	public static class AssemblyExpressionContext extends ParserRuleContext {
		public AssemblyCallContext assemblyCall() {
			return getRuleContext(AssemblyCallContext.class,0);
		}
		public AssemblyLiteralContext assemblyLiteral() {
			return getRuleContext(AssemblyLiteralContext.class,0);
		}
		public AssemblyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyExpression; }
	}

	public final AssemblyExpressionContext assemblyExpression() throws RecognitionException {
		AssemblyExpressionContext _localctx = new AssemblyExpressionContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_assemblyExpression);
		try {
			setState(924);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__39:
			case T__47:
			case T__51:
			case T__54:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(922);
				assemblyCall();
				}
				break;
			case BooleanLiteral:
			case DecimalNumber:
			case HexNumber:
			case HexLiteralFragment:
			case StringLiteralFragment:
				enterOuterAlt(_localctx, 2);
				{
				setState(923);
				assemblyLiteral();
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
	public static class AssemblyCallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AssemblyExpressionContext> assemblyExpression() {
			return getRuleContexts(AssemblyExpressionContext.class);
		}
		public AssemblyExpressionContext assemblyExpression(int i) {
			return getRuleContext(AssemblyExpressionContext.class,i);
		}
		public AssemblyCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyCall; }
	}

	public final AssemblyCallContext assemblyCall() throws RecognitionException {
		AssemblyCallContext _localctx = new AssemblyCallContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_assemblyCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(930);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(926);
				match(T__47);
				}
				break;
			case 2:
				{
				setState(927);
				match(T__51);
				}
				break;
			case 3:
				{
				setState(928);
				match(T__54);
				}
				break;
			case 4:
				{
				setState(929);
				identifier();
				}
				break;
			}
			setState(944);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(932);
				match(T__21);
				setState(934);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 40814971134681088L) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & 100663319L) != 0)) {
					{
					setState(933);
					assemblyExpression();
					}
				}

				setState(940);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(936);
					match(T__14);
					setState(937);
					assemblyExpression();
					}
					}
					setState(942);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(943);
				match(T__22);
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
	public static class AssemblyLocalDefinitionContext extends ParserRuleContext {
		public AssemblyIdentifierListContext assemblyIdentifierList() {
			return getRuleContext(AssemblyIdentifierListContext.class,0);
		}
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public AssemblyLocalDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyLocalDefinition; }
	}

	public final AssemblyLocalDefinitionContext assemblyLocalDefinition() throws RecognitionException {
		AssemblyLocalDefinitionContext _localctx = new AssemblyLocalDefinitionContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_assemblyLocalDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(946);
			match(T__86);
			setState(947);
			assemblyIdentifierList();
			setState(950);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__87) {
				{
				setState(948);
				match(T__87);
				setState(949);
				assemblyExpression();
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
	public static class AssemblyAssignmentContext extends ParserRuleContext {
		public AssemblyIdentifierListContext assemblyIdentifierList() {
			return getRuleContext(AssemblyIdentifierListContext.class,0);
		}
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public AssemblyAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyAssignment; }
	}

	public final AssemblyAssignmentContext assemblyAssignment() throws RecognitionException {
		AssemblyAssignmentContext _localctx = new AssemblyAssignmentContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_assemblyAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(952);
			assemblyIdentifierList();
			setState(953);
			match(T__87);
			setState(954);
			assemblyExpression();
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
	public static class AssemblyIdentifierListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public AssemblyIdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyIdentifierList; }
	}

	public final AssemblyIdentifierListContext assemblyIdentifierList() throws RecognitionException {
		AssemblyIdentifierListContext _localctx = new AssemblyIdentifierListContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_assemblyIdentifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(956);
			identifier();
			setState(961);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(957);
				match(T__14);
				setState(958);
				identifier();
				}
				}
				setState(963);
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
	public static class AssemblyStackAssignmentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyStackAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyStackAssignment; }
	}

	public final AssemblyStackAssignmentContext assemblyStackAssignment() throws RecognitionException {
		AssemblyStackAssignmentContext _localctx = new AssemblyStackAssignmentContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_assemblyStackAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(964);
			match(T__88);
			setState(965);
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
	public static class LabelDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LabelDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelDefinition; }
	}

	public final LabelDefinitionContext labelDefinition() throws RecognitionException {
		LabelDefinitionContext _localctx = new LabelDefinitionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_labelDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(967);
			identifier();
			setState(968);
			match(T__58);
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
	public static class AssemblySwitchContext extends ParserRuleContext {
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public List<AssemblyCaseContext> assemblyCase() {
			return getRuleContexts(AssemblyCaseContext.class);
		}
		public AssemblyCaseContext assemblyCase(int i) {
			return getRuleContext(AssemblyCaseContext.class,i);
		}
		public AssemblySwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblySwitch; }
	}

	public final AssemblySwitchContext assemblySwitch() throws RecognitionException {
		AssemblySwitchContext _localctx = new AssemblySwitchContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_assemblySwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(970);
			match(T__89);
			setState(971);
			assemblyExpression();
			setState(975);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__90 || _la==T__91) {
				{
				{
				setState(972);
				assemblyCase();
				}
				}
				setState(977);
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
	public static class AssemblyCaseContext extends ParserRuleContext {
		public AssemblyLiteralContext assemblyLiteral() {
			return getRuleContext(AssemblyLiteralContext.class,0);
		}
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public AssemblyTypeContext assemblyType() {
			return getRuleContext(AssemblyTypeContext.class,0);
		}
		public AssemblyCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyCase; }
	}

	public final AssemblyCaseContext assemblyCase() throws RecognitionException {
		AssemblyCaseContext _localctx = new AssemblyCaseContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_assemblyCase);
		int _la;
		try {
			setState(987);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__90:
				enterOuterAlt(_localctx, 1);
				{
				setState(978);
				match(T__90);
				setState(979);
				assemblyLiteral();
				setState(981);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__58) {
					{
					setState(980);
					assemblyType();
					}
				}

				setState(983);
				assemblyBlock();
				}
				break;
			case T__91:
				enterOuterAlt(_localctx, 2);
				{
				setState(985);
				match(T__91);
				setState(986);
				assemblyBlock();
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
	public static class AssemblyFunctionDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public AssemblyTypedVariableListContext assemblyTypedVariableList() {
			return getRuleContext(AssemblyTypedVariableListContext.class,0);
		}
		public AssemblyFunctionReturnsContext assemblyFunctionReturns() {
			return getRuleContext(AssemblyFunctionReturnsContext.class,0);
		}
		public AssemblyFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyFunctionDefinition; }
	}

	public final AssemblyFunctionDefinitionContext assemblyFunctionDefinition() throws RecognitionException {
		AssemblyFunctionDefinitionContext _localctx = new AssemblyFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_assemblyFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(989);
			match(T__28);
			setState(990);
			identifier();
			setState(991);
			match(T__21);
			setState(993);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504699139006464L) != 0) || _la==Identifier) {
				{
				setState(992);
				assemblyTypedVariableList();
				}
			}

			setState(995);
			match(T__22);
			setState(997);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__60) {
				{
				setState(996);
				assemblyFunctionReturns();
				}
			}

			setState(999);
			assemblyBlock();
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
	public static class AssemblyFunctionReturnsContext extends ParserRuleContext {
		public AssemblyTypedVariableListContext assemblyTypedVariableList() {
			return getRuleContext(AssemblyTypedVariableListContext.class,0);
		}
		public AssemblyFunctionReturnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyFunctionReturns; }
	}

	public final AssemblyFunctionReturnsContext assemblyFunctionReturns() throws RecognitionException {
		AssemblyFunctionReturnsContext _localctx = new AssemblyFunctionReturnsContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_assemblyFunctionReturns);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1001);
			match(T__60);
			setState(1002);
			match(T__5);
			setState(1003);
			assemblyTypedVariableList();
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
	public static class AssemblyForContext extends ParserRuleContext {
		public List<AssemblyBlockContext> assemblyBlock() {
			return getRuleContexts(AssemblyBlockContext.class);
		}
		public AssemblyBlockContext assemblyBlock(int i) {
			return getRuleContext(AssemblyBlockContext.class,i);
		}
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public AssemblyForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyFor; }
	}

	public final AssemblyForContext assemblyFor() throws RecognitionException {
		AssemblyForContext _localctx = new AssemblyForContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_assemblyFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1005);
			match(T__25);
			setState(1006);
			assemblyBlock();
			setState(1007);
			assemblyExpression();
			setState(1008);
			assemblyBlock();
			setState(1009);
			assemblyBlock();
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
	public static class AssemblyIfContext extends ParserRuleContext {
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public AssemblyIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyIf; }
	}

	public final AssemblyIfContext assemblyIf() throws RecognitionException {
		AssemblyIfContext _localctx = new AssemblyIfContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_assemblyIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1011);
			match(T__40);
			setState(1012);
			assemblyExpression();
			setState(1013);
			assemblyBlock();
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
	public static class AssemblyLiteralContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode DecimalNumber() { return getToken(SolidityParser.DecimalNumber, 0); }
		public TerminalNode HexNumber() { return getToken(SolidityParser.HexNumber, 0); }
		public HexLiteralContext hexLiteral() {
			return getRuleContext(HexLiteralContext.class,0);
		}
		public TerminalNode BooleanLiteral() { return getToken(SolidityParser.BooleanLiteral, 0); }
		public AssemblyTypeContext assemblyType() {
			return getRuleContext(AssemblyTypeContext.class,0);
		}
		public AssemblyLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyLiteral; }
	}

	public final AssemblyLiteralContext assemblyLiteral() throws RecognitionException {
		AssemblyLiteralContext _localctx = new AssemblyLiteralContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_assemblyLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1020);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringLiteralFragment:
				{
				setState(1015);
				stringLiteral();
				}
				break;
			case DecimalNumber:
				{
				setState(1016);
				match(DecimalNumber);
				}
				break;
			case HexNumber:
				{
				setState(1017);
				match(HexNumber);
				}
				break;
			case HexLiteralFragment:
				{
				setState(1018);
				hexLiteral();
				}
				break;
			case BooleanLiteral:
				{
				setState(1019);
				match(BooleanLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1023);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				{
				setState(1022);
				assemblyType();
				}
				break;
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
	public static class AssemblyTypedVariableListContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyTypeContext assemblyType() {
			return getRuleContext(AssemblyTypeContext.class,0);
		}
		public AssemblyTypedVariableListContext assemblyTypedVariableList() {
			return getRuleContext(AssemblyTypedVariableListContext.class,0);
		}
		public AssemblyTypedVariableListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyTypedVariableList; }
	}

	public final AssemblyTypedVariableListContext assemblyTypedVariableList() throws RecognitionException {
		AssemblyTypedVariableListContext _localctx = new AssemblyTypedVariableListContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_assemblyTypedVariableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1025);
			identifier();
			setState(1027);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__58) {
				{
				setState(1026);
				assemblyType();
				}
			}

			setState(1031);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(1029);
				match(T__14);
				setState(1030);
				assemblyTypedVariableList();
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
	public static class AssemblyTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyType; }
	}

	public final AssemblyTypeContext assemblyType() throws RecognitionException {
		AssemblyTypeContext _localctx = new AssemblyTypeContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_assemblyType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1033);
			match(T__58);
			setState(1034);
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
	public static class SubAssemblyContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public SubAssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subAssembly; }
	}

	public final SubAssemblyContext subAssembly() throws RecognitionException {
		SubAssemblyContext _localctx = new SubAssemblyContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_subAssembly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1036);
			match(T__45);
			setState(1037);
			identifier();
			setState(1038);
			assemblyBlock();
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
	public static class NumberLiteralContext extends ParserRuleContext {
		public TerminalNode DecimalNumber() { return getToken(SolidityParser.DecimalNumber, 0); }
		public TerminalNode HexNumber() { return getToken(SolidityParser.HexNumber, 0); }
		public TerminalNode NumberUnit() { return getToken(SolidityParser.NumberUnit, 0); }
		public NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiteral; }
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_numberLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1040);
			_la = _input.LA(1);
			if ( !(_la==DecimalNumber || _la==HexNumber) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1042);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				{
				setState(1041);
				match(NumberUnit);
				}
				break;
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SolidityParser.Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1044);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504699139006464L) != 0) || _la==Identifier) ) {
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
	public static class HexLiteralContext extends ParserRuleContext {
		public List<TerminalNode> HexLiteralFragment() { return getTokens(SolidityParser.HexLiteralFragment); }
		public TerminalNode HexLiteralFragment(int i) {
			return getToken(SolidityParser.HexLiteralFragment, i);
		}
		public HexLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexLiteral; }
	}

	public final HexLiteralContext hexLiteral() throws RecognitionException {
		HexLiteralContext _localctx = new HexLiteralContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_hexLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1047); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1046);
					match(HexLiteralFragment);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1049); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
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
	public static class StringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> StringLiteralFragment() { return getTokens(SolidityParser.StringLiteralFragment); }
		public TerminalNode StringLiteralFragment(int i) {
			return getToken(SolidityParser.StringLiteralFragment, i);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_stringLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1052); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1051);
					match(StringLiteralFragment);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1054); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 30:
			return typeName_sempred((TypeNameContext)_localctx, predIndex);
		case 56:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeName_sempred(TypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 28);
		case 15:
			return precpred(_ctx, 26);
		case 16:
			return precpred(_ctx, 25);
		case 17:
			return precpred(_ctx, 24);
		case 18:
			return precpred(_ctx, 23);
		case 19:
			return precpred(_ctx, 22);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0080\u0421\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u00b6\b\u0000\n\u0000\f\u0000"+
		"\u00b9\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0003\u0003\u00c6\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004\u00ca\b"+
		"\u0004\u0001\u0005\u0003\u0005\u00cd\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00d7\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00dd\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00e1\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007\u00eb\b\u0007\n\u0007\f\u0007\u00ee"+
		"\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00f5\b\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u00fa\b\b\u0001\t"+
		"\u0003\t\u00fd\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u0105\b\t\n\t\f\t\u0108\t\t\u0003\t\u010a\b\t\u0001\t\u0001\t\u0005"+
		"\t\u010e\b\t\n\t\f\t\u0111\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n"+
		"\u0003\n\u0118\b\n\u0001\n\u0003\n\u011b\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0124"+
		"\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u012d\b\f\n\f\f\f\u0130\t\f\u0001\f\u0001\f\u0001\f\u0003\f\u0135\b"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u013e"+
		"\b\r\n\r\f\r\u0141\t\r\u0001\r\u0001\r\u0003\r\u0145\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u014c\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0158\b\u000f\n"+
		"\u000f\f\u000f\u015b\t\u000f\u0003\u000f\u015d\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0164\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u0168\b\u0010\n\u0010\f\u0010\u016b\t\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u016f\b\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u0175\b\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0179\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u017f\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u0184\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0005\u0014\u0191\b\u0014\n\u0014\f\u0014\u0194\t\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u0199\b\u0015\u0001\u0015\u0003\u0015\u019c"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u01a2"+
		"\b\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u01aa\b\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u01ae"+
		"\b\u0017\n\u0017\f\u0017\u01b1\t\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019"+
		"\u01bb\b\u0019\n\u0019\f\u0019\u01be\t\u0019\u0003\u0019\u01c0\b\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u01c6\b\u001a"+
		"\u0001\u001a\u0003\u001a\u01c9\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0005\u001b\u01cf\b\u001b\n\u001b\f\u001b\u01d2\t\u001b\u0003"+
		"\u001b\u01d4\b\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0003"+
		"\u001c\u01da\b\u001c\u0001\u001c\u0003\u001c\u01dd\b\u001c\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u01e1\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u01ea\b\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u01ef\b\u001e\u0001\u001e"+
		"\u0005\u001e\u01f2\b\u001e\n\u001e\f\u001e\u01f5\t\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0005\u001f\u01fa\b\u001f\n\u001f\f\u001f\u01fd\t\u001f"+
		"\u0001 \u0001 \u0001 \u0001 \u0003 \u0203\b \u0001 \u0001 \u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0001!\u0003!\u020d\b!\u0001\"\u0001\"\u0001#\u0001"+
		"#\u0001$\u0001$\u0005$\u0215\b$\n$\f$\u0218\t$\u0001$\u0001$\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0003%\u0229\b%\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0235\b\'\u0001(\u0001(\u0001"+
		"(\u0003(\u023a\b(\u0001(\u0001(\u0004(\u023e\b(\u000b(\f(\u023f\u0001"+
		")\u0001)\u0003)\u0244\b)\u0001)\u0003)\u0247\b)\u0001)\u0001)\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0003+\u0255"+
		"\b+\u0001+\u0001+\u0003+\u0259\b+\u0001+\u0003+\u025c\b+\u0001+\u0001"+
		"+\u0001+\u0001,\u0001,\u0003,\u0263\b,\u0001-\u0001-\u0003-\u0267\b-\u0001"+
		"-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001"+
		"/\u0001/\u0001/\u00010\u00010\u00010\u00011\u00011\u00031\u027b\b1\u0001"+
		"1\u00011\u00012\u00012\u00012\u00013\u00013\u00013\u00013\u00014\u0001"+
		"4\u00014\u00014\u00014\u00014\u00014\u00034\u028d\b4\u00014\u00014\u0003"+
		"4\u0291\b4\u00014\u00014\u00015\u00035\u0296\b5\u00015\u00015\u00035\u029a"+
		"\b5\u00055\u029c\b5\n5\f5\u029f\t5\u00016\u00016\u00036\u02a3\b6\u0001"+
		"6\u00056\u02a6\b6\n6\f6\u02a9\t6\u00016\u00036\u02ac\b6\u00016\u00016"+
		"\u00017\u00017\u00037\u02b2\b7\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00037\u02bd\b7\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00038\u02d6"+
		"\b8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00038\u0307\b8\u0001"+
		"8\u00018\u00018\u00018\u00038\u030d\b8\u00018\u00018\u00038\u0311\b8\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00058\u0321\b8\n8\f8\u0324\t8\u00019\u00019\u0001"+
		"9\u00019\u00019\u00019\u00019\u00039\u032d\b9\u00019\u00019\u00019\u0001"+
		"9\u00019\u00039\u0334\b9\u00039\u0336\b9\u0001:\u0001:\u0001:\u0005:\u033b"+
		"\b:\n:\f:\u033e\t:\u0001;\u0001;\u0001;\u0005;\u0343\b;\n;\f;\u0346\t"+
		";\u0001;\u0003;\u0349\b;\u0001<\u0001<\u0001<\u0001<\u0001=\u0001=\u0003"+
		"=\u0351\b=\u0001=\u0001=\u0003=\u0355\b=\u0003=\u0357\b=\u0001>\u0001"+
		">\u0001>\u0001>\u0001>\u0001?\u0001?\u0003?\u0360\b?\u0001?\u0001?\u0003"+
		"?\u0364\b?\u0005?\u0366\b?\n?\f?\u0369\t?\u0001?\u0001?\u0001?\u0001?"+
		"\u0001?\u0005?\u0370\b?\n?\f?\u0373\t?\u0003?\u0375\b?\u0001?\u0003?\u0378"+
		"\b?\u0001@\u0001@\u0003@\u037c\b@\u0001A\u0001A\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0003A\u0390\bA\u0001B\u0001B\u0005B\u0394\bB\nB\fB\u0397"+
		"\tB\u0001B\u0001B\u0001C\u0001C\u0003C\u039d\bC\u0001D\u0001D\u0001D\u0001"+
		"D\u0003D\u03a3\bD\u0001D\u0001D\u0003D\u03a7\bD\u0001D\u0001D\u0005D\u03ab"+
		"\bD\nD\fD\u03ae\tD\u0001D\u0003D\u03b1\bD\u0001E\u0001E\u0001E\u0001E"+
		"\u0003E\u03b7\bE\u0001F\u0001F\u0001F\u0001F\u0001G\u0001G\u0001G\u0005"+
		"G\u03c0\bG\nG\fG\u03c3\tG\u0001H\u0001H\u0001H\u0001I\u0001I\u0001I\u0001"+
		"J\u0001J\u0001J\u0005J\u03ce\bJ\nJ\fJ\u03d1\tJ\u0001K\u0001K\u0001K\u0003"+
		"K\u03d6\bK\u0001K\u0001K\u0001K\u0001K\u0003K\u03dc\bK\u0001L\u0001L\u0001"+
		"L\u0001L\u0003L\u03e2\bL\u0001L\u0001L\u0003L\u03e6\bL\u0001L\u0001L\u0001"+
		"M\u0001M\u0001M\u0001M\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001"+
		"O\u0001O\u0001O\u0001O\u0001P\u0001P\u0001P\u0001P\u0001P\u0003P\u03fd"+
		"\bP\u0001P\u0003P\u0400\bP\u0001Q\u0001Q\u0003Q\u0404\bQ\u0001Q\u0001"+
		"Q\u0003Q\u0408\bQ\u0001R\u0001R\u0001R\u0001S\u0001S\u0001S\u0001S\u0001"+
		"T\u0001T\u0003T\u0413\bT\u0001U\u0001U\u0001V\u0004V\u0418\bV\u000bV\f"+
		"V\u0419\u0001W\u0004W\u041d\bW\u000bW\fW\u041e\u0001W\u0000\u0002<pX\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c"+
		"\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u0000\u000e\u0001"+
		"\u0000\u0003\t\u0001\u0000\u0012\u0014\u0001\u0000&(\u0004\u0000jjqqu"+
		"uww\u0001\u000089\u0001\u0000<=\u0001\u0000>?\u0002\u0000\f\fBC\u0001"+
		"\u0000DE\u0001\u0000\u0005\b\u0001\u0000HI\u0002\u0000\t\tMV\u0001\u0000"+
		"cd\u0004\u0000\r\r((44{{\u04a2\u0000\u00b7\u0001\u0000\u0000\u0000\u0002"+
		"\u00bc\u0001\u0000\u0000\u0000\u0004\u00c1\u0001\u0000\u0000\u0000\u0006"+
		"\u00c5\u0001\u0000\u0000\u0000\b\u00c7\u0001\u0000\u0000\u0000\n\u00cc"+
		"\u0001\u0000\u0000\u0000\f\u00d0\u0001\u0000\u0000\u0000\u000e\u00f4\u0001"+
		"\u0000\u0000\u0000\u0010\u00f6\u0001\u0000\u0000\u0000\u0012\u00fc\u0001"+
		"\u0000\u0000\u0000\u0014\u0114\u0001\u0000\u0000\u0000\u0016\u0123\u0001"+
		"\u0000\u0000\u0000\u0018\u0125\u0001\u0000\u0000\u0000\u001a\u0138\u0001"+
		"\u0000\u0000\u0000\u001c\u0146\u0001\u0000\u0000\u0000\u001e\u014f\u0001"+
		"\u0000\u0000\u0000 \u0160\u0001\u0000\u0000\u0000\"\u0170\u0001\u0000"+
		"\u0000\u0000$\u0183\u0001\u0000\u0000\u0000&\u0185\u0001\u0000\u0000\u0000"+
		"(\u0192\u0001\u0000\u0000\u0000*\u0195\u0001\u0000\u0000\u0000,\u019d"+
		"\u0001\u0000\u0000\u0000.\u01a5\u0001\u0000\u0000\u00000\u01b4\u0001\u0000"+
		"\u0000\u00002\u01b6\u0001\u0000\u0000\u00004\u01c3\u0001\u0000\u0000\u0000"+
		"6\u01ca\u0001\u0000\u0000\u00008\u01d7\u0001\u0000\u0000\u0000:\u01de"+
		"\u0001\u0000\u0000\u0000<\u01e9\u0001\u0000\u0000\u0000>\u01f6\u0001\u0000"+
		"\u0000\u0000@\u01fe\u0001\u0000\u0000\u0000B\u0208\u0001\u0000\u0000\u0000"+
		"D\u020e\u0001\u0000\u0000\u0000F\u0210\u0001\u0000\u0000\u0000H\u0212"+
		"\u0001\u0000\u0000\u0000J\u0228\u0001\u0000\u0000\u0000L\u022a\u0001\u0000"+
		"\u0000\u0000N\u022d\u0001\u0000\u0000\u0000P\u0236\u0001\u0000\u0000\u0000"+
		"R\u0241\u0001\u0000\u0000\u0000T\u024a\u0001\u0000\u0000\u0000V\u0250"+
		"\u0001\u0000\u0000\u0000X\u0262\u0001\u0000\u0000\u0000Z\u0264\u0001\u0000"+
		"\u0000\u0000\\\u026a\u0001\u0000\u0000\u0000^\u0272\u0001\u0000\u0000"+
		"\u0000`\u0275\u0001\u0000\u0000\u0000b\u0278\u0001\u0000\u0000\u0000d"+
		"\u027e\u0001\u0000\u0000\u0000f\u0281\u0001\u0000\u0000\u0000h\u028c\u0001"+
		"\u0000\u0000\u0000j\u0295\u0001\u0000\u0000\u0000l\u02a0\u0001\u0000\u0000"+
		"\u0000n\u02bc\u0001\u0000\u0000\u0000p\u02d5\u0001\u0000\u0000\u0000r"+
		"\u0335\u0001\u0000\u0000\u0000t\u0337\u0001\u0000\u0000\u0000v\u033f\u0001"+
		"\u0000\u0000\u0000x\u034a\u0001\u0000\u0000\u0000z\u0356\u0001\u0000\u0000"+
		"\u0000|\u0358\u0001\u0000\u0000\u0000~\u0377\u0001\u0000\u0000\u0000\u0080"+
		"\u037b\u0001\u0000\u0000\u0000\u0082\u038f\u0001\u0000\u0000\u0000\u0084"+
		"\u0391\u0001\u0000\u0000\u0000\u0086\u039c\u0001\u0000\u0000\u0000\u0088"+
		"\u03a2\u0001\u0000\u0000\u0000\u008a\u03b2\u0001\u0000\u0000\u0000\u008c"+
		"\u03b8\u0001\u0000\u0000\u0000\u008e\u03bc\u0001\u0000\u0000\u0000\u0090"+
		"\u03c4\u0001\u0000\u0000\u0000\u0092\u03c7\u0001\u0000\u0000\u0000\u0094"+
		"\u03ca\u0001\u0000\u0000\u0000\u0096\u03db\u0001\u0000\u0000\u0000\u0098"+
		"\u03dd\u0001\u0000\u0000\u0000\u009a\u03e9\u0001\u0000\u0000\u0000\u009c"+
		"\u03ed\u0001\u0000\u0000\u0000\u009e\u03f3\u0001\u0000\u0000\u0000\u00a0"+
		"\u03fc\u0001\u0000\u0000\u0000\u00a2\u0401\u0001\u0000\u0000\u0000\u00a4"+
		"\u0409\u0001\u0000\u0000\u0000\u00a6\u040c\u0001\u0000\u0000\u0000\u00a8"+
		"\u0410\u0001\u0000\u0000\u0000\u00aa\u0414\u0001\u0000\u0000\u0000\u00ac"+
		"\u0417\u0001\u0000\u0000\u0000\u00ae\u041c\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b6\u0003\u0002\u0001\u0000\u00b1\u00b6\u0003\u000e\u0007\u0000\u00b2"+
		"\u00b6\u0003\u001e\u000f\u0000\u00b3\u00b6\u0003.\u0017\u0000\u00b4\u00b6"+
		"\u0003\u0012\t\u0000\u00b5\u00b0\u0001\u0000\u0000\u0000\u00b5\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0005\u0000\u0000\u0001\u00bb\u0001\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0005\u0001\u0000\u0000\u00bd\u00be\u0003"+
		"\u0004\u0002\u0000\u00be\u00bf\u0003\u0006\u0003\u0000\u00bf\u00c0\u0005"+
		"\u0002\u0000\u0000\u00c0\u0003\u0001\u0000\u0000\u0000\u00c1\u00c2\u0003"+
		"\u00aaU\u0000\u00c2\u0005\u0001\u0000\u0000\u0000\u00c3\u00c6\u0003\b"+
		"\u0004\u0000\u00c4\u00c6\u0003p8\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c6\u0007\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c9\u0003\n\u0005\u0000\u00c8\u00ca\u0003\n\u0005\u0000\u00c9"+
		"\u00c8\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca"+
		"\t\u0001\u0000\u0000\u0000\u00cb\u00cd\u0003\f\u0006\u0000\u00cc\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005}\u0000\u0000\u00cf\u000b\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0007\u0000\u0000\u0000\u00d1\r\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0005\n\u0000\u0000\u00d3\u00d6\u0005|\u0000"+
		"\u0000\u00d4\u00d5\u0005\u000b\u0000\u0000\u00d5\u00d7\u0003\u00aaU\u0000"+
		"\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00f5\u0005\u0002\u0000\u0000"+
		"\u00d9\u00dc\u0005\n\u0000\u0000\u00da\u00dd\u0005\f\u0000\u0000\u00db"+
		"\u00dd\u0003\u00aaU\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00db"+
		"\u0001\u0000\u0000\u0000\u00dd\u00e0\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u0005\u000b\u0000\u0000\u00df\u00e1\u0003\u00aaU\u0000\u00e0\u00de\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e3\u0005\r\u0000\u0000\u00e3\u00e4\u0005|"+
		"\u0000\u0000\u00e4\u00f5\u0005\u0002\u0000\u0000\u00e5\u00e6\u0005\n\u0000"+
		"\u0000\u00e6\u00e7\u0005\u000e\u0000\u0000\u00e7\u00ec\u0003\u0010\b\u0000"+
		"\u00e8\u00e9\u0005\u000f\u0000\u0000\u00e9\u00eb\u0003\u0010\b\u0000\u00ea"+
		"\u00e8\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ef\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0005\u0010\u0000\u0000\u00f0\u00f1\u0005\r\u0000\u0000\u00f1\u00f2"+
		"\u0005|\u0000\u0000\u00f2\u00f3\u0005\u0002\u0000\u0000\u00f3\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f4\u00d2\u0001\u0000\u0000\u0000\u00f4\u00d9\u0001"+
		"\u0000\u0000\u0000\u00f4\u00e5\u0001\u0000\u0000\u0000\u00f5\u000f\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f9\u0003\u00aaU\u0000\u00f7\u00f8\u0005\u000b"+
		"\u0000\u0000\u00f8\u00fa\u0003\u00aaU\u0000\u00f9\u00f7\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u0011\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fd\u0005\u0011\u0000\u0000\u00fc\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000"+
		"\u0000\u00fe\u00ff\u0007\u0001\u0000\u0000\u00ff\u0109\u0003\u00aaU\u0000"+
		"\u0100\u0101\u0005\u0015\u0000\u0000\u0101\u0106\u0003\u0014\n\u0000\u0102"+
		"\u0103\u0005\u000f\u0000\u0000\u0103\u0105\u0003\u0014\n\u0000\u0104\u0102"+
		"\u0001\u0000\u0000\u0000\u0105\u0108\u0001\u0000\u0000\u0000\u0106\u0104"+
		"\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u010a"+
		"\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0109\u0100"+
		"\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010b"+
		"\u0001\u0000\u0000\u0000\u010b\u010f\u0005\u000e\u0000\u0000\u010c\u010e"+
		"\u0003\u0016\u000b\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010e\u0111"+
		"\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u0110"+
		"\u0001\u0000\u0000\u0000\u0110\u0112\u0001\u0000\u0000\u0000\u0111\u010f"+
		"\u0001\u0000\u0000\u0000\u0112\u0113\u0005\u0010\u0000\u0000\u0113\u0013"+
		"\u0001\u0000\u0000\u0000\u0114\u011a\u0003>\u001f\u0000\u0115\u0117\u0005"+
		"\u0016\u0000\u0000\u0116\u0118\u0003t:\u0000\u0117\u0116\u0001\u0000\u0000"+
		"\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000"+
		"\u0000\u0119\u011b\u0005\u0017\u0000\u0000\u011a\u0115\u0001\u0000\u0000"+
		"\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u0015\u0001\u0000\u0000"+
		"\u0000\u011c\u0124\u0003\u0018\f\u0000\u011d\u0124\u0003\u001c\u000e\u0000"+
		"\u011e\u0124\u0003\u001e\u000f\u0000\u011f\u0124\u0003 \u0010\u0000\u0120"+
		"\u0124\u0003\"\u0011\u0000\u0121\u0124\u0003,\u0016\u0000\u0122\u0124"+
		"\u0003.\u0017\u0000\u0123\u011c\u0001\u0000\u0000\u0000\u0123\u011d\u0001"+
		"\u0000\u0000\u0000\u0123\u011e\u0001\u0000\u0000\u0000\u0123\u011f\u0001"+
		"\u0000\u0000\u0000\u0123\u0120\u0001\u0000\u0000\u0000\u0123\u0121\u0001"+
		"\u0000\u0000\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0124\u0017\u0001"+
		"\u0000\u0000\u0000\u0125\u012e\u0003<\u001e\u0000\u0126\u012d\u0005s\u0000"+
		"\u0000\u0127\u012d\u0005p\u0000\u0000\u0128\u012d\u0005r\u0000\u0000\u0129"+
		"\u012d\u0005j\u0000\u0000\u012a\u012d\u0005k\u0000\u0000\u012b\u012d\u0003"+
		"\u001a\r\u0000\u012c\u0126\u0001\u0000\u0000\u0000\u012c\u0127\u0001\u0000"+
		"\u0000\u0000\u012c\u0128\u0001\u0000\u0000\u0000\u012c\u0129\u0001\u0000"+
		"\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012b\u0001\u0000"+
		"\u0000\u0000\u012d\u0130\u0001\u0000\u0000\u0000\u012e\u012c\u0001\u0000"+
		"\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0131\u0001\u0000"+
		"\u0000\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0131\u0134\u0003\u00aa"+
		"U\u0000\u0132\u0133\u0005\t\u0000\u0000\u0133\u0135\u0003p8\u0000\u0134"+
		"\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135"+
		"\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0005\u0002\u0000\u0000\u0137"+
		"\u0019\u0001\u0000\u0000\u0000\u0138\u0144\u0005\u0018\u0000\u0000\u0139"+
		"\u013a\u0005\u0016\u0000\u0000\u013a\u013f\u0003>\u001f\u0000\u013b\u013c"+
		"\u0005\u000f\u0000\u0000\u013c\u013e\u0003>\u001f\u0000\u013d\u013b\u0001"+
		"\u0000\u0000\u0000\u013e\u0141\u0001\u0000\u0000\u0000\u013f\u013d\u0001"+
		"\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u0142\u0001"+
		"\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0142\u0143\u0005"+
		"\u0017\u0000\u0000\u0143\u0145\u0001\u0000\u0000\u0000\u0144\u0139\u0001"+
		"\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u001b\u0001"+
		"\u0000\u0000\u0000\u0146\u0147\u0005\u0019\u0000\u0000\u0147\u0148\u0003"+
		"\u00aaU\u0000\u0148\u014b\u0005\u001a\u0000\u0000\u0149\u014c\u0005\f"+
		"\u0000\u0000\u014a\u014c\u0003<\u001e\u0000\u014b\u0149\u0001\u0000\u0000"+
		"\u0000\u014b\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000"+
		"\u0000\u014d\u014e\u0005\u0002\u0000\u0000\u014e\u001d\u0001\u0000\u0000"+
		"\u0000\u014f\u0150\u0005\u001b\u0000\u0000\u0150\u0151\u0003\u00aaU\u0000"+
		"\u0151\u015c\u0005\u000e\u0000\u0000\u0152\u0153\u0003:\u001d\u0000\u0153"+
		"\u0159\u0005\u0002\u0000\u0000\u0154\u0155\u0003:\u001d\u0000\u0155\u0156"+
		"\u0005\u0002\u0000\u0000\u0156\u0158\u0001\u0000\u0000\u0000\u0157\u0154"+
		"\u0001\u0000\u0000\u0000\u0158\u015b\u0001\u0000\u0000\u0000\u0159\u0157"+
		"\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015d"+
		"\u0001\u0000\u0000\u0000\u015b\u0159\u0001\u0000\u0000\u0000\u015c\u0152"+
		"\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015e"+
		"\u0001\u0000\u0000\u0000\u015e\u015f\u0005\u0010\u0000\u0000\u015f\u001f"+
		"\u0001\u0000\u0000\u0000\u0160\u0161\u0005\u001c\u0000\u0000\u0161\u0163"+
		"\u0003\u00aaU\u0000\u0162\u0164\u00032\u0019\u0000\u0163\u0162\u0001\u0000"+
		"\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0169\u0001\u0000"+
		"\u0000\u0000\u0165\u0168\u0005t\u0000\u0000\u0166\u0168\u0003\u001a\r"+
		"\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0167\u0166\u0001\u0000\u0000"+
		"\u0000\u0168\u016b\u0001\u0000\u0000\u0000\u0169\u0167\u0001\u0000\u0000"+
		"\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a\u016e\u0001\u0000\u0000"+
		"\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016c\u016f\u0005\u0002\u0000"+
		"\u0000\u016d\u016f\u0003H$\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e"+
		"\u016d\u0001\u0000\u0000\u0000\u016f!\u0001\u0000\u0000\u0000\u0170\u0171"+
		"\u0003$\u0012\u0000\u0171\u0172\u00032\u0019\u0000\u0172\u0174\u0003("+
		"\u0014\u0000\u0173\u0175\u0003&\u0013\u0000\u0174\u0173\u0001\u0000\u0000"+
		"\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u0178\u0001\u0000\u0000"+
		"\u0000\u0176\u0179\u0005\u0002\u0000\u0000\u0177\u0179\u0003H$\u0000\u0178"+
		"\u0176\u0001\u0000\u0000\u0000\u0178\u0177\u0001\u0000\u0000\u0000\u0179"+
		"#\u0001\u0000\u0000\u0000\u017a\u017e\u0005\u001d\u0000\u0000\u017b\u017f"+
		"\u0003\u00aaU\u0000\u017c\u017f\u0005z\u0000\u0000\u017d\u017f\u0005y"+
		"\u0000\u0000\u017e\u017b\u0001\u0000\u0000\u0000\u017e\u017c\u0001\u0000"+
		"\u0000\u0000\u017e\u017d\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000"+
		"\u0000\u0000\u017f\u0184\u0001\u0000\u0000\u0000\u0180\u0184\u0005x\u0000"+
		"\u0000\u0181\u0184\u0005y\u0000\u0000\u0182\u0184\u0005z\u0000\u0000\u0183"+
		"\u017a\u0001\u0000\u0000\u0000\u0183\u0180\u0001\u0000\u0000\u0000\u0183"+
		"\u0181\u0001\u0000\u0000\u0000\u0183\u0182\u0001\u0000\u0000\u0000\u0184"+
		"%\u0001\u0000\u0000\u0000\u0185\u0186\u0005\u001e\u0000\u0000\u0186\u0187"+
		"\u00032\u0019\u0000\u0187\'\u0001\u0000\u0000\u0000\u0188\u0191\u0003"+
		"*\u0015\u0000\u0189\u0191\u0003F#\u0000\u018a\u0191\u0005n\u0000\u0000"+
		"\u018b\u0191\u0005s\u0000\u0000\u018c\u0191\u0005p\u0000\u0000\u018d\u0191"+
		"\u0005r\u0000\u0000\u018e\u0191\u0005t\u0000\u0000\u018f\u0191\u0003\u001a"+
		"\r\u0000\u0190\u0188\u0001\u0000\u0000\u0000\u0190\u0189\u0001\u0000\u0000"+
		"\u0000\u0190\u018a\u0001\u0000\u0000\u0000\u0190\u018b\u0001\u0000\u0000"+
		"\u0000\u0190\u018c\u0001\u0000\u0000\u0000\u0190\u018d\u0001\u0000\u0000"+
		"\u0000\u0190\u018e\u0001\u0000\u0000\u0000\u0190\u018f\u0001\u0000\u0000"+
		"\u0000\u0191\u0194\u0001\u0000\u0000\u0000\u0192\u0190\u0001\u0000\u0000"+
		"\u0000\u0192\u0193\u0001\u0000\u0000\u0000\u0193)\u0001\u0000\u0000\u0000"+
		"\u0194\u0192\u0001\u0000\u0000\u0000\u0195\u019b\u0003\u00aaU\u0000\u0196"+
		"\u0198\u0005\u0016\u0000\u0000\u0197\u0199\u0003t:\u0000\u0198\u0197\u0001"+
		"\u0000\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000\u0199\u019a\u0001"+
		"\u0000\u0000\u0000\u019a\u019c\u0005\u0017\u0000\u0000\u019b\u0196\u0001"+
		"\u0000\u0000\u0000\u019b\u019c\u0001\u0000\u0000\u0000\u019c+\u0001\u0000"+
		"\u0000\u0000\u019d\u019e\u0005\u001f\u0000\u0000\u019e\u019f\u0003\u00aa"+
		"U\u0000\u019f\u01a1\u00036\u001b\u0000\u01a0\u01a2\u0005h\u0000\u0000"+
		"\u01a1\u01a0\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000"+
		"\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a4\u0005\u0002\u0000\u0000"+
		"\u01a4-\u0001\u0000\u0000\u0000\u01a5\u01a6\u0005 \u0000\u0000\u01a6\u01a7"+
		"\u0003\u00aaU\u0000\u01a7\u01a9\u0005\u000e\u0000\u0000\u01a8\u01aa\u0003"+
		"0\u0018\u0000\u01a9\u01a8\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000"+
		"\u0000\u0000\u01aa\u01af\u0001\u0000\u0000\u0000\u01ab\u01ac\u0005\u000f"+
		"\u0000\u0000\u01ac\u01ae\u00030\u0018\u0000\u01ad\u01ab\u0001\u0000\u0000"+
		"\u0000\u01ae\u01b1\u0001\u0000\u0000\u0000\u01af\u01ad\u0001\u0000\u0000"+
		"\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b2\u0001\u0000\u0000"+
		"\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b2\u01b3\u0005\u0010\u0000"+
		"\u0000\u01b3/\u0001\u0000\u0000\u0000\u01b4\u01b5\u0003\u00aaU\u0000\u01b5"+
		"1\u0001\u0000\u0000\u0000\u01b6\u01bf\u0005\u0016\u0000\u0000\u01b7\u01bc"+
		"\u00034\u001a\u0000\u01b8\u01b9\u0005\u000f\u0000\u0000\u01b9\u01bb\u0003"+
		"4\u001a\u0000\u01ba\u01b8\u0001\u0000\u0000\u0000\u01bb\u01be\u0001\u0000"+
		"\u0000\u0000\u01bc\u01ba\u0001\u0000\u0000\u0000\u01bc\u01bd\u0001\u0000"+
		"\u0000\u0000\u01bd\u01c0\u0001\u0000\u0000\u0000\u01be\u01bc\u0001\u0000"+
		"\u0000\u0000\u01bf\u01b7\u0001\u0000\u0000\u0000\u01bf\u01c0\u0001\u0000"+
		"\u0000\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1\u01c2\u0005\u0017"+
		"\u0000\u0000\u01c23\u0001\u0000\u0000\u0000\u01c3\u01c5\u0003<\u001e\u0000"+
		"\u01c4\u01c6\u0003D\"\u0000\u01c5\u01c4\u0001\u0000\u0000\u0000\u01c5"+
		"\u01c6\u0001\u0000\u0000\u0000\u01c6\u01c8\u0001\u0000\u0000\u0000\u01c7"+
		"\u01c9\u0003\u00aaU\u0000\u01c8\u01c7\u0001\u0000\u0000\u0000\u01c8\u01c9"+
		"\u0001\u0000\u0000\u0000\u01c95\u0001\u0000\u0000\u0000\u01ca\u01d3\u0005"+
		"\u0016\u0000\u0000\u01cb\u01d0\u00038\u001c\u0000\u01cc\u01cd\u0005\u000f"+
		"\u0000\u0000\u01cd\u01cf\u00038\u001c\u0000\u01ce\u01cc\u0001\u0000\u0000"+
		"\u0000\u01cf\u01d2\u0001\u0000\u0000\u0000\u01d0\u01ce\u0001\u0000\u0000"+
		"\u0000\u01d0\u01d1\u0001\u0000\u0000\u0000\u01d1\u01d4\u0001\u0000\u0000"+
		"\u0000\u01d2\u01d0\u0001\u0000\u0000\u0000\u01d3\u01cb\u0001\u0000\u0000"+
		"\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000\u0000"+
		"\u0000\u01d5\u01d6\u0005\u0017\u0000\u0000\u01d67\u0001\u0000\u0000\u0000"+
		"\u01d7\u01d9\u0003<\u001e\u0000\u01d8\u01da\u0005o\u0000\u0000\u01d9\u01d8"+
		"\u0001\u0000\u0000\u0000\u01d9\u01da\u0001\u0000\u0000\u0000\u01da\u01dc"+
		"\u0001\u0000\u0000\u0000\u01db\u01dd\u0003\u00aaU\u0000\u01dc\u01db\u0001"+
		"\u0000\u0000\u0000\u01dc\u01dd\u0001\u0000\u0000\u0000\u01dd9\u0001\u0000"+
		"\u0000\u0000\u01de\u01e0\u0003<\u001e\u0000\u01df\u01e1\u0003D\"\u0000"+
		"\u01e0\u01df\u0001\u0000\u0000\u0000\u01e0\u01e1\u0001\u0000\u0000\u0000"+
		"\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2\u01e3\u0003\u00aaU\u0000\u01e3"+
		";\u0001\u0000\u0000\u0000\u01e4\u01e5\u0006\u001e\uffff\uffff\u0000\u01e5"+
		"\u01ea\u0003n7\u0000\u01e6\u01ea\u0003>\u001f\u0000\u01e7\u01ea\u0003"+
		"@ \u0000\u01e8\u01ea\u0003B!\u0000\u01e9\u01e4\u0001\u0000\u0000\u0000"+
		"\u01e9\u01e6\u0001\u0000\u0000\u0000\u01e9\u01e7\u0001\u0000\u0000\u0000"+
		"\u01e9\u01e8\u0001\u0000\u0000\u0000\u01ea\u01f3\u0001\u0000\u0000\u0000"+
		"\u01eb\u01ec\n\u0002\u0000\u0000\u01ec\u01ee\u0005!\u0000\u0000\u01ed"+
		"\u01ef\u0003p8\u0000\u01ee\u01ed\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001"+
		"\u0000\u0000\u0000\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f0\u01f2\u0005"+
		"\"\u0000\u0000\u01f1\u01eb\u0001\u0000\u0000\u0000\u01f2\u01f5\u0001\u0000"+
		"\u0000\u0000\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001\u0000"+
		"\u0000\u0000\u01f4=\u0001\u0000\u0000\u0000\u01f5\u01f3\u0001\u0000\u0000"+
		"\u0000\u01f6\u01fb\u0003\u00aaU\u0000\u01f7\u01f8\u0005#\u0000\u0000\u01f8"+
		"\u01fa\u0003\u00aaU\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000\u01fa\u01fd"+
		"\u0001\u0000\u0000\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fb\u01fc"+
		"\u0001\u0000\u0000\u0000\u01fc?\u0001\u0000\u0000\u0000\u01fd\u01fb\u0001"+
		"\u0000\u0000\u0000\u01fe\u01ff\u0005$\u0000\u0000\u01ff\u0202\u0005\u0016"+
		"\u0000\u0000\u0200\u0203\u0003n7\u0000\u0201\u0203\u0003>\u001f\u0000"+
		"\u0202\u0200\u0001\u0000\u0000\u0000\u0202\u0201\u0001\u0000\u0000\u0000"+
		"\u0203\u0204\u0001\u0000\u0000\u0000\u0204\u0205\u0005%\u0000\u0000\u0205"+
		"\u0206\u0003<\u001e\u0000\u0206\u0207\u0005\u0017\u0000\u0000\u0207A\u0001"+
		"\u0000\u0000\u0000\u0208\u0209\u0005\u001d\u0000\u0000\u0209\u020a\u0003"+
		"2\u0019\u0000\u020a\u020c\u0003(\u0014\u0000\u020b\u020d\u0003&\u0013"+
		"\u0000\u020c\u020b\u0001\u0000\u0000\u0000\u020c\u020d\u0001\u0000\u0000"+
		"\u0000\u020dC\u0001\u0000\u0000\u0000\u020e\u020f\u0007\u0002\u0000\u0000"+
		"\u020fE\u0001\u0000\u0000\u0000\u0210\u0211\u0007\u0003\u0000\u0000\u0211"+
		"G\u0001\u0000\u0000\u0000\u0212\u0216\u0005\u000e\u0000\u0000\u0213\u0215"+
		"\u0003J%\u0000\u0214\u0213\u0001\u0000\u0000\u0000\u0215\u0218\u0001\u0000"+
		"\u0000\u0000\u0216\u0214\u0001\u0000\u0000\u0000\u0216\u0217\u0001\u0000"+
		"\u0000\u0000\u0217\u0219\u0001\u0000\u0000\u0000\u0218\u0216\u0001\u0000"+
		"\u0000\u0000\u0219\u021a\u0005\u0010\u0000\u0000\u021aI\u0001\u0000\u0000"+
		"\u0000\u021b\u0229\u0003N\'\u0000\u021c\u0229\u0003P(\u0000\u021d\u0229"+
		"\u0003T*\u0000\u021e\u0229\u0003V+\u0000\u021f\u0229\u0003H$\u0000\u0220"+
		"\u0229\u0003Z-\u0000\u0221\u0229\u0003\\.\u0000\u0222\u0229\u0003^/\u0000"+
		"\u0223\u0229\u0003`0\u0000\u0224\u0229\u0003b1\u0000\u0225\u0229\u0003"+
		"d2\u0000\u0226\u0229\u0003f3\u0000\u0227\u0229\u0003X,\u0000\u0228\u021b"+
		"\u0001\u0000\u0000\u0000\u0228\u021c\u0001\u0000\u0000\u0000\u0228\u021d"+
		"\u0001\u0000\u0000\u0000\u0228\u021e\u0001\u0000\u0000\u0000\u0228\u021f"+
		"\u0001\u0000\u0000\u0000\u0228\u0220\u0001\u0000\u0000\u0000\u0228\u0221"+
		"\u0001\u0000\u0000\u0000\u0228\u0222\u0001\u0000\u0000\u0000\u0228\u0223"+
		"\u0001\u0000\u0000\u0000\u0228\u0224\u0001\u0000\u0000\u0000\u0228\u0225"+
		"\u0001\u0000\u0000\u0000\u0228\u0226\u0001\u0000\u0000\u0000\u0228\u0227"+
		"\u0001\u0000\u0000\u0000\u0229K\u0001\u0000\u0000\u0000\u022a\u022b\u0003"+
		"p8\u0000\u022b\u022c\u0005\u0002\u0000\u0000\u022cM\u0001\u0000\u0000"+
		"\u0000\u022d\u022e\u0005)\u0000\u0000\u022e\u022f\u0005\u0016\u0000\u0000"+
		"\u022f\u0230\u0003p8\u0000\u0230\u0231\u0005\u0017\u0000\u0000\u0231\u0234"+
		"\u0003J%\u0000\u0232\u0233\u0005*\u0000\u0000\u0233\u0235\u0003J%\u0000"+
		"\u0234\u0232\u0001\u0000\u0000\u0000\u0234\u0235\u0001\u0000\u0000\u0000"+
		"\u0235O\u0001\u0000\u0000\u0000\u0236\u0237\u0005+\u0000\u0000\u0237\u0239"+
		"\u0003p8\u0000\u0238\u023a\u0003&\u0013\u0000\u0239\u0238\u0001\u0000"+
		"\u0000\u0000\u0239\u023a\u0001\u0000\u0000\u0000\u023a\u023b\u0001\u0000"+
		"\u0000\u0000\u023b\u023d\u0003H$\u0000\u023c\u023e\u0003R)\u0000\u023d"+
		"\u023c\u0001\u0000\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f"+
		"\u023d\u0001\u0000\u0000\u0000\u023f\u0240\u0001\u0000\u0000\u0000\u0240"+
		"Q\u0001\u0000\u0000\u0000\u0241\u0246\u0005,\u0000\u0000\u0242\u0244\u0003"+
		"\u00aaU\u0000\u0243\u0242\u0001\u0000\u0000\u0000\u0243\u0244\u0001\u0000"+
		"\u0000\u0000\u0244\u0245\u0001\u0000\u0000\u0000\u0245\u0247\u00032\u0019"+
		"\u0000\u0246\u0243\u0001\u0000\u0000\u0000\u0246\u0247\u0001\u0000\u0000"+
		"\u0000\u0247\u0248\u0001\u0000\u0000\u0000\u0248\u0249\u0003H$\u0000\u0249"+
		"S\u0001\u0000\u0000\u0000\u024a\u024b\u0005-\u0000\u0000\u024b\u024c\u0005"+
		"\u0016\u0000\u0000\u024c\u024d\u0003p8\u0000\u024d\u024e\u0005\u0017\u0000"+
		"\u0000\u024e\u024f\u0003J%\u0000\u024fU\u0001\u0000\u0000\u0000\u0250"+
		"\u0251\u0005\u001a\u0000\u0000\u0251\u0254\u0005\u0016\u0000\u0000\u0252"+
		"\u0255\u0003X,\u0000\u0253\u0255\u0005\u0002\u0000\u0000\u0254\u0252\u0001"+
		"\u0000\u0000\u0000\u0254\u0253\u0001\u0000\u0000\u0000\u0255\u0258\u0001"+
		"\u0000\u0000\u0000\u0256\u0259\u0003L&\u0000\u0257\u0259\u0005\u0002\u0000"+
		"\u0000\u0258\u0256\u0001\u0000\u0000\u0000\u0258\u0257\u0001\u0000\u0000"+
		"\u0000\u0259\u025b\u0001\u0000\u0000\u0000\u025a\u025c\u0003p8\u0000\u025b"+
		"\u025a\u0001\u0000\u0000\u0000\u025b\u025c\u0001\u0000\u0000\u0000\u025c"+
		"\u025d\u0001\u0000\u0000\u0000\u025d\u025e\u0005\u0017\u0000\u0000\u025e"+
		"\u025f\u0003J%\u0000\u025fW\u0001\u0000\u0000\u0000\u0260\u0263\u0003"+
		"h4\u0000\u0261\u0263\u0003L&\u0000\u0262\u0260\u0001\u0000\u0000\u0000"+
		"\u0262\u0261\u0001\u0000\u0000\u0000\u0263Y\u0001\u0000\u0000\u0000\u0264"+
		"\u0266\u0005.\u0000\u0000\u0265\u0267\u0005|\u0000\u0000\u0266\u0265\u0001"+
		"\u0000\u0000\u0000\u0266\u0267\u0001\u0000\u0000\u0000\u0267\u0268\u0001"+
		"\u0000\u0000\u0000\u0268\u0269\u0003\u0084B\u0000\u0269[\u0001\u0000\u0000"+
		"\u0000\u026a\u026b\u0005/\u0000\u0000\u026b\u026c\u0003J%\u0000\u026c"+
		"\u026d\u0005-\u0000\u0000\u026d\u026e\u0005\u0016\u0000\u0000\u026e\u026f"+
		"\u0003p8\u0000\u026f\u0270\u0005\u0017\u0000\u0000\u0270\u0271\u0005\u0002"+
		"\u0000\u0000\u0271]\u0001\u0000\u0000\u0000\u0272\u0273\u0005l\u0000\u0000"+
		"\u0273\u0274\u0005\u0002\u0000\u0000\u0274_\u0001\u0000\u0000\u0000\u0275"+
		"\u0276\u0005i\u0000\u0000\u0276\u0277\u0005\u0002\u0000\u0000\u0277a\u0001"+
		"\u0000\u0000\u0000\u0278\u027a\u00050\u0000\u0000\u0279\u027b\u0003p8"+
		"\u0000\u027a\u0279\u0001\u0000\u0000\u0000\u027a\u027b\u0001\u0000\u0000"+
		"\u0000\u027b\u027c\u0001\u0000\u0000\u0000\u027c\u027d\u0005\u0002\u0000"+
		"\u0000\u027dc\u0001\u0000\u0000\u0000\u027e\u027f\u00051\u0000\u0000\u027f"+
		"\u0280\u0005\u0002\u0000\u0000\u0280e\u0001\u0000\u0000\u0000\u0281\u0282"+
		"\u00052\u0000\u0000\u0282\u0283\u0003|>\u0000\u0283\u0284\u0005\u0002"+
		"\u0000\u0000\u0284g\u0001\u0000\u0000\u0000\u0285\u0286\u00053\u0000\u0000"+
		"\u0286\u028d\u0003l6\u0000\u0287\u028d\u0003:\u001d\u0000\u0288\u0289"+
		"\u0005\u0016\u0000\u0000\u0289\u028a\u0003j5\u0000\u028a\u028b\u0005\u0017"+
		"\u0000\u0000\u028b\u028d\u0001\u0000\u0000\u0000\u028c\u0285\u0001\u0000"+
		"\u0000\u0000\u028c\u0287\u0001\u0000\u0000\u0000\u028c\u0288\u0001\u0000"+
		"\u0000\u0000\u028d\u0290\u0001\u0000\u0000\u0000\u028e\u028f\u0005\t\u0000"+
		"\u0000\u028f\u0291\u0003p8\u0000\u0290\u028e\u0001\u0000\u0000\u0000\u0290"+
		"\u0291\u0001\u0000\u0000\u0000\u0291\u0292\u0001\u0000\u0000\u0000\u0292"+
		"\u0293\u0005\u0002\u0000\u0000\u0293i\u0001\u0000\u0000\u0000\u0294\u0296"+
		"\u0003:\u001d\u0000\u0295\u0294\u0001\u0000\u0000\u0000\u0295\u0296\u0001"+
		"\u0000\u0000\u0000\u0296\u029d\u0001\u0000\u0000\u0000\u0297\u0299\u0005"+
		"\u000f\u0000\u0000\u0298\u029a\u0003:\u001d\u0000\u0299\u0298\u0001\u0000"+
		"\u0000\u0000\u0299\u029a\u0001\u0000\u0000\u0000\u029a\u029c\u0001\u0000"+
		"\u0000\u0000\u029b\u0297\u0001\u0000\u0000\u0000\u029c\u029f\u0001\u0000"+
		"\u0000\u0000\u029d\u029b\u0001\u0000\u0000\u0000\u029d\u029e\u0001\u0000"+
		"\u0000\u0000\u029ek\u0001\u0000\u0000\u0000\u029f\u029d\u0001\u0000\u0000"+
		"\u0000\u02a0\u02a7\u0005\u0016\u0000\u0000\u02a1\u02a3\u0003\u00aaU\u0000"+
		"\u02a2\u02a1\u0001\u0000\u0000\u0000\u02a2\u02a3\u0001\u0000\u0000\u0000"+
		"\u02a3\u02a4\u0001\u0000\u0000\u0000\u02a4\u02a6\u0005\u000f\u0000\u0000"+
		"\u02a5\u02a2\u0001\u0000\u0000\u0000\u02a6\u02a9\u0001\u0000\u0000\u0000"+
		"\u02a7\u02a5\u0001\u0000\u0000\u0000\u02a7\u02a8\u0001\u0000\u0000\u0000"+
		"\u02a8\u02ab\u0001\u0000\u0000\u0000\u02a9\u02a7\u0001\u0000\u0000\u0000"+
		"\u02aa\u02ac\u0003\u00aaU\u0000\u02ab\u02aa\u0001\u0000\u0000\u0000\u02ab"+
		"\u02ac\u0001\u0000\u0000\u0000\u02ac\u02ad\u0001\u0000\u0000\u0000\u02ad"+
		"\u02ae\u0005\u0017\u0000\u0000\u02aem\u0001\u0000\u0000\u0000\u02af\u02b1"+
		"\u00054\u0000\u0000\u02b0\u02b2\u0005q\u0000\u0000\u02b1\u02b0\u0001\u0000"+
		"\u0000\u0000\u02b1\u02b2\u0001\u0000\u0000\u0000\u02b2\u02bd\u0001\u0000"+
		"\u0000\u0000\u02b3\u02bd\u00055\u0000\u0000\u02b4\u02bd\u00056\u0000\u0000"+
		"\u02b5\u02bd\u00053\u0000\u0000\u02b6\u02bd\u0005]\u0000\u0000\u02b7\u02bd"+
		"\u0005^\u0000\u0000\u02b8\u02bd\u00057\u0000\u0000\u02b9\u02bd\u0005_"+
		"\u0000\u0000\u02ba\u02bd\u0005`\u0000\u0000\u02bb\u02bd\u0005a\u0000\u0000"+
		"\u02bc\u02af\u0001\u0000\u0000\u0000\u02bc\u02b3\u0001\u0000\u0000\u0000"+
		"\u02bc\u02b4\u0001\u0000\u0000\u0000\u02bc\u02b5\u0001\u0000\u0000\u0000"+
		"\u02bc\u02b6\u0001\u0000\u0000\u0000\u02bc\u02b7\u0001\u0000\u0000\u0000"+
		"\u02bc\u02b8\u0001\u0000\u0000\u0000\u02bc\u02b9\u0001\u0000\u0000\u0000"+
		"\u02bc\u02ba\u0001\u0000\u0000\u0000\u02bc\u02bb\u0001\u0000\u0000\u0000"+
		"\u02bdo\u0001\u0000\u0000\u0000\u02be\u02bf\u00068\uffff\uffff\u0000\u02bf"+
		"\u02c0\u0005:\u0000\u0000\u02c0\u02d6\u0003<\u001e\u0000\u02c1\u02c2\u0005"+
		"q\u0000\u0000\u02c2\u02c3\u0005\u0016\u0000\u0000\u02c3\u02c4\u0003p8"+
		"\u0000\u02c4\u02c5\u0005\u0017\u0000\u0000\u02c5\u02d6\u0001\u0000\u0000"+
		"\u0000\u02c6\u02c7\u0005\u0016\u0000\u0000\u02c7\u02c8\u0003p8\u0000\u02c8"+
		"\u02c9\u0005\u0017\u0000\u0000\u02c9\u02d6\u0001\u0000\u0000\u0000\u02ca"+
		"\u02cb\u0007\u0004\u0000\u0000\u02cb\u02d6\u0003p8\u0013\u02cc\u02cd\u0007"+
		"\u0005\u0000\u0000\u02cd\u02d6\u0003p8\u0012\u02ce\u02cf\u0007\u0006\u0000"+
		"\u0000\u02cf\u02d6\u0003p8\u0011\u02d0\u02d1\u0005@\u0000\u0000\u02d1"+
		"\u02d6\u0003p8\u0010\u02d2\u02d3\u0005\u0004\u0000\u0000\u02d3\u02d6\u0003"+
		"p8\u000f\u02d4\u02d6\u0003r9\u0000\u02d5\u02be\u0001\u0000\u0000\u0000"+
		"\u02d5\u02c1\u0001\u0000\u0000\u0000\u02d5\u02c6\u0001\u0000\u0000\u0000"+
		"\u02d5\u02ca\u0001\u0000\u0000\u0000\u02d5\u02cc\u0001\u0000\u0000\u0000"+
		"\u02d5\u02ce\u0001\u0000\u0000\u0000\u02d5\u02d0\u0001\u0000\u0000\u0000"+
		"\u02d5\u02d2\u0001\u0000\u0000\u0000\u02d5\u02d4\u0001\u0000\u0000\u0000"+
		"\u02d6\u0322\u0001\u0000\u0000\u0000\u02d7\u02d8\n\u000e\u0000\u0000\u02d8"+
		"\u02d9\u0005A\u0000\u0000\u02d9\u0321\u0003p8\u000f\u02da\u02db\n\r\u0000"+
		"\u0000\u02db\u02dc\u0007\u0007\u0000\u0000\u02dc\u0321\u0003p8\u000e\u02dd"+
		"\u02de\n\f\u0000\u0000\u02de\u02df\u0007\u0005\u0000\u0000\u02df\u0321"+
		"\u0003p8\r\u02e0\u02e1\n\u000b\u0000\u0000\u02e1\u02e2\u0007\b\u0000\u0000"+
		"\u02e2\u0321\u0003p8\f\u02e3\u02e4\n\n\u0000\u0000\u02e4\u02e5\u0005F"+
		"\u0000\u0000\u02e5\u0321\u0003p8\u000b\u02e6\u02e7\n\t\u0000\u0000\u02e7"+
		"\u02e8\u0005\u0003\u0000\u0000\u02e8\u0321\u0003p8\n\u02e9\u02ea\n\b\u0000"+
		"\u0000\u02ea\u02eb\u0005G\u0000\u0000\u02eb\u0321\u0003p8\t\u02ec\u02ed"+
		"\n\u0007\u0000\u0000\u02ed\u02ee\u0007\t\u0000\u0000\u02ee\u0321\u0003"+
		"p8\b\u02ef\u02f0\n\u0006\u0000\u0000\u02f0\u02f1\u0007\n\u0000\u0000\u02f1"+
		"\u0321\u0003p8\u0007\u02f2\u02f3\n\u0005\u0000\u0000\u02f3\u02f4\u0005"+
		"J\u0000\u0000\u02f4\u0321\u0003p8\u0006\u02f5\u02f6\n\u0004\u0000\u0000"+
		"\u02f6\u02f7\u0005K\u0000\u0000\u02f7\u0321\u0003p8\u0005\u02f8\u02f9"+
		"\n\u0003\u0000\u0000\u02f9\u02fa\u0005L\u0000\u0000\u02fa\u02fb\u0003"+
		"p8\u0000\u02fb\u02fc\u0005;\u0000\u0000\u02fc\u02fd\u0003p8\u0004\u02fd"+
		"\u0321\u0001\u0000\u0000\u0000\u02fe\u02ff\n\u0002\u0000\u0000\u02ff\u0300"+
		"\u0007\u000b\u0000\u0000\u0300\u0321\u0003p8\u0003\u0301\u0302\n\u001c"+
		"\u0000\u0000\u0302\u0321\u0007\u0004\u0000\u0000\u0303\u0304\n\u001a\u0000"+
		"\u0000\u0304\u0306\u0005!\u0000\u0000\u0305\u0307\u0003p8\u0000\u0306"+
		"\u0305\u0001\u0000\u0000\u0000\u0306\u0307\u0001\u0000\u0000\u0000\u0307"+
		"\u0308\u0001\u0000\u0000\u0000\u0308\u0321\u0005\"\u0000\u0000\u0309\u030a"+
		"\n\u0019\u0000\u0000\u030a\u030c\u0005!\u0000\u0000\u030b\u030d\u0003"+
		"p8\u0000\u030c\u030b\u0001\u0000\u0000\u0000\u030c\u030d\u0001\u0000\u0000"+
		"\u0000\u030d\u030e\u0001\u0000\u0000\u0000\u030e\u0310\u0005;\u0000\u0000"+
		"\u030f\u0311\u0003p8\u0000\u0310\u030f\u0001\u0000\u0000\u0000\u0310\u0311"+
		"\u0001\u0000\u0000\u0000\u0311\u0312\u0001\u0000\u0000\u0000\u0312\u0321"+
		"\u0005\"\u0000\u0000\u0313\u0314\n\u0018\u0000\u0000\u0314\u0315\u0005"+
		"#\u0000\u0000\u0315\u0321\u0003\u00aaU\u0000\u0316\u0317\n\u0017\u0000"+
		"\u0000\u0317\u0318\u0005\u000e\u0000\u0000\u0318\u0319\u0003v;\u0000\u0319"+
		"\u031a\u0005\u0010\u0000\u0000\u031a\u0321\u0001\u0000\u0000\u0000\u031b"+
		"\u031c\n\u0016\u0000\u0000\u031c\u031d\u0005\u0016\u0000\u0000\u031d\u031e"+
		"\u0003z=\u0000\u031e\u031f\u0005\u0017\u0000\u0000\u031f\u0321\u0001\u0000"+
		"\u0000\u0000\u0320\u02d7\u0001\u0000\u0000\u0000\u0320\u02da\u0001\u0000"+
		"\u0000\u0000\u0320\u02dd\u0001\u0000\u0000\u0000\u0320\u02e0\u0001\u0000"+
		"\u0000\u0000\u0320\u02e3\u0001\u0000\u0000\u0000\u0320\u02e6\u0001\u0000"+
		"\u0000\u0000\u0320\u02e9\u0001\u0000\u0000\u0000\u0320\u02ec\u0001\u0000"+
		"\u0000\u0000\u0320\u02ef\u0001\u0000\u0000\u0000\u0320\u02f2\u0001\u0000"+
		"\u0000\u0000\u0320\u02f5\u0001\u0000\u0000\u0000\u0320\u02f8\u0001\u0000"+
		"\u0000\u0000\u0320\u02fe\u0001\u0000\u0000\u0000\u0320\u0301\u0001\u0000"+
		"\u0000\u0000\u0320\u0303\u0001\u0000\u0000\u0000\u0320\u0309\u0001\u0000"+
		"\u0000\u0000\u0320\u0313\u0001\u0000\u0000\u0000\u0320\u0316\u0001\u0000"+
		"\u0000\u0000\u0320\u031b\u0001\u0000\u0000\u0000\u0321\u0324\u0001\u0000"+
		"\u0000\u0000\u0322\u0320\u0001\u0000\u0000\u0000\u0322\u0323\u0001\u0000"+
		"\u0000\u0000\u0323q\u0001\u0000\u0000\u0000\u0324\u0322\u0001\u0000\u0000"+
		"\u0000\u0325\u0336\u0005b\u0000\u0000\u0326\u0336\u0003\u00a8T\u0000\u0327"+
		"\u0336\u0003\u00acV\u0000\u0328\u0336\u0003\u00aeW\u0000\u0329\u032c\u0003"+
		"\u00aaU\u0000\u032a\u032b\u0005!\u0000\u0000\u032b\u032d\u0005\"\u0000"+
		"\u0000\u032c\u032a\u0001\u0000\u0000\u0000\u032c\u032d\u0001\u0000\u0000"+
		"\u0000\u032d\u0336\u0001\u0000\u0000\u0000\u032e\u0336\u0005v\u0000\u0000"+
		"\u032f\u0336\u0003~?\u0000\u0330\u0333\u0003\u0080@\u0000\u0331\u0332"+
		"\u0005!\u0000\u0000\u0332\u0334\u0005\"\u0000\u0000\u0333\u0331\u0001"+
		"\u0000\u0000\u0000\u0333\u0334\u0001\u0000\u0000\u0000\u0334\u0336\u0001"+
		"\u0000\u0000\u0000\u0335\u0325\u0001\u0000\u0000\u0000\u0335\u0326\u0001"+
		"\u0000\u0000\u0000\u0335\u0327\u0001\u0000\u0000\u0000\u0335\u0328\u0001"+
		"\u0000\u0000\u0000\u0335\u0329\u0001\u0000\u0000\u0000\u0335\u032e\u0001"+
		"\u0000\u0000\u0000\u0335\u032f\u0001\u0000\u0000\u0000\u0335\u0330\u0001"+
		"\u0000\u0000\u0000\u0336s\u0001\u0000\u0000\u0000\u0337\u033c\u0003p8"+
		"\u0000\u0338\u0339\u0005\u000f\u0000\u0000\u0339\u033b\u0003p8\u0000\u033a"+
		"\u0338\u0001\u0000\u0000\u0000\u033b\u033e\u0001\u0000\u0000\u0000\u033c"+
		"\u033a\u0001\u0000\u0000\u0000\u033c\u033d\u0001\u0000\u0000\u0000\u033d"+
		"u\u0001\u0000\u0000\u0000\u033e\u033c\u0001\u0000\u0000\u0000\u033f\u0344"+
		"\u0003x<\u0000\u0340\u0341\u0005\u000f\u0000\u0000\u0341\u0343\u0003x"+
		"<\u0000\u0342\u0340\u0001\u0000\u0000\u0000\u0343\u0346\u0001\u0000\u0000"+
		"\u0000\u0344\u0342\u0001\u0000\u0000\u0000\u0344\u0345\u0001\u0000\u0000"+
		"\u0000\u0345\u0348\u0001\u0000\u0000\u0000\u0346\u0344\u0001\u0000\u0000"+
		"\u0000\u0347\u0349\u0005\u000f\u0000\u0000\u0348\u0347\u0001\u0000\u0000"+
		"\u0000\u0348\u0349\u0001\u0000\u0000\u0000\u0349w\u0001\u0000\u0000\u0000"+
		"\u034a\u034b\u0003\u00aaU\u0000\u034b\u034c\u0005;\u0000\u0000\u034c\u034d"+
		"\u0003p8\u0000\u034dy\u0001\u0000\u0000\u0000\u034e\u0350\u0005\u000e"+
		"\u0000\u0000\u034f\u0351\u0003v;\u0000\u0350\u034f\u0001\u0000\u0000\u0000"+
		"\u0350\u0351\u0001\u0000\u0000\u0000\u0351\u0352\u0001\u0000\u0000\u0000"+
		"\u0352\u0357\u0005\u0010\u0000\u0000\u0353\u0355\u0003t:\u0000\u0354\u0353"+
		"\u0001\u0000\u0000\u0000\u0354\u0355\u0001\u0000\u0000\u0000\u0355\u0357"+
		"\u0001\u0000\u0000\u0000\u0356\u034e\u0001\u0000\u0000\u0000\u0356\u0354"+
		"\u0001\u0000\u0000\u0000\u0357{\u0001\u0000\u0000\u0000\u0358\u0359\u0003"+
		"p8\u0000\u0359\u035a\u0005\u0016\u0000\u0000\u035a\u035b\u0003z=\u0000"+
		"\u035b\u035c\u0005\u0017\u0000\u0000\u035c}\u0001\u0000\u0000\u0000\u035d"+
		"\u035f\u0005\u0016\u0000\u0000\u035e\u0360\u0003p8\u0000\u035f\u035e\u0001"+
		"\u0000\u0000\u0000\u035f\u0360\u0001\u0000\u0000\u0000\u0360\u0367\u0001"+
		"\u0000\u0000\u0000\u0361\u0363\u0005\u000f\u0000\u0000\u0362\u0364\u0003"+
		"p8\u0000\u0363\u0362\u0001\u0000\u0000\u0000\u0363\u0364\u0001\u0000\u0000"+
		"\u0000\u0364\u0366\u0001\u0000\u0000\u0000\u0365\u0361\u0001\u0000\u0000"+
		"\u0000\u0366\u0369\u0001\u0000\u0000\u0000\u0367\u0365\u0001\u0000\u0000"+
		"\u0000\u0367\u0368\u0001\u0000\u0000\u0000\u0368\u036a\u0001\u0000\u0000"+
		"\u0000\u0369\u0367\u0001\u0000\u0000\u0000\u036a\u0378\u0005\u0017\u0000"+
		"\u0000\u036b\u0374\u0005!\u0000\u0000\u036c\u0371\u0003p8\u0000\u036d"+
		"\u036e\u0005\u000f\u0000\u0000\u036e\u0370\u0003p8\u0000\u036f\u036d\u0001"+
		"\u0000\u0000\u0000\u0370\u0373\u0001\u0000\u0000\u0000\u0371\u036f\u0001"+
		"\u0000\u0000\u0000\u0371\u0372\u0001\u0000\u0000\u0000\u0372\u0375\u0001"+
		"\u0000\u0000\u0000\u0373\u0371\u0001\u0000\u0000\u0000\u0374\u036c\u0001"+
		"\u0000\u0000\u0000\u0374\u0375\u0001\u0000\u0000\u0000\u0375\u0376\u0001"+
		"\u0000\u0000\u0000\u0376\u0378\u0005\"\u0000\u0000\u0377\u035d\u0001\u0000"+
		"\u0000\u0000\u0377\u036b\u0001\u0000\u0000\u0000\u0378\u007f\u0001\u0000"+
		"\u0000\u0000\u0379\u037c\u0003n7\u0000\u037a\u037c\u0003>\u001f\u0000"+
		"\u037b\u0379\u0001\u0000\u0000\u0000\u037b\u037a\u0001\u0000\u0000\u0000"+
		"\u037c\u0081\u0001\u0000\u0000\u0000\u037d\u0390\u0003\u00aaU\u0000\u037e"+
		"\u0390\u0003\u0084B\u0000\u037f\u0390\u0003\u0086C\u0000\u0380\u0390\u0003"+
		"\u008aE\u0000\u0381\u0390\u0003\u008cF\u0000\u0382\u0390\u0003\u0090H"+
		"\u0000\u0383\u0390\u0003\u0092I\u0000\u0384\u0390\u0003\u0094J\u0000\u0385"+
		"\u0390\u0003\u0098L\u0000\u0386\u0390\u0003\u009cN\u0000\u0387\u0390\u0003"+
		"\u009eO\u0000\u0388\u0390\u0005i\u0000\u0000\u0389\u0390\u0005l\u0000"+
		"\u0000\u038a\u0390\u0005m\u0000\u0000\u038b\u0390\u0003\u00a6S\u0000\u038c"+
		"\u0390\u0003\u00a8T\u0000\u038d\u0390\u0003\u00aeW\u0000\u038e\u0390\u0003"+
		"\u00acV\u0000\u038f\u037d\u0001\u0000\u0000\u0000\u038f\u037e\u0001\u0000"+
		"\u0000\u0000\u038f\u037f\u0001\u0000\u0000\u0000\u038f\u0380\u0001\u0000"+
		"\u0000\u0000\u038f\u0381\u0001\u0000\u0000\u0000\u038f\u0382\u0001\u0000"+
		"\u0000\u0000\u038f\u0383\u0001\u0000\u0000\u0000\u038f\u0384\u0001\u0000"+
		"\u0000\u0000\u038f\u0385\u0001\u0000\u0000\u0000\u038f\u0386\u0001\u0000"+
		"\u0000\u0000\u038f\u0387\u0001\u0000\u0000\u0000\u038f\u0388\u0001\u0000"+
		"\u0000\u0000\u038f\u0389\u0001\u0000\u0000\u0000\u038f\u038a\u0001\u0000"+
		"\u0000\u0000\u038f\u038b\u0001\u0000\u0000\u0000\u038f\u038c\u0001\u0000"+
		"\u0000\u0000\u038f\u038d\u0001\u0000\u0000\u0000\u038f\u038e\u0001\u0000"+
		"\u0000\u0000\u0390\u0083\u0001\u0000\u0000\u0000\u0391\u0395\u0005\u000e"+
		"\u0000\u0000\u0392\u0394\u0003\u0082A\u0000\u0393\u0392\u0001\u0000\u0000"+
		"\u0000\u0394\u0397\u0001\u0000\u0000\u0000\u0395\u0393\u0001\u0000\u0000"+
		"\u0000\u0395\u0396\u0001\u0000\u0000\u0000\u0396\u0398\u0001\u0000\u0000"+
		"\u0000\u0397\u0395\u0001\u0000\u0000\u0000\u0398\u0399\u0005\u0010\u0000"+
		"\u0000\u0399\u0085\u0001\u0000\u0000\u0000\u039a\u039d\u0003\u0088D\u0000"+
		"\u039b\u039d\u0003\u00a0P\u0000\u039c\u039a\u0001\u0000\u0000\u0000\u039c"+
		"\u039b\u0001\u0000\u0000\u0000\u039d\u0087\u0001\u0000\u0000\u0000\u039e"+
		"\u03a3\u00050\u0000\u0000\u039f\u03a3\u00054\u0000\u0000\u03a0\u03a3\u0005"+
		"7\u0000\u0000\u03a1\u03a3\u0003\u00aaU\u0000\u03a2\u039e\u0001\u0000\u0000"+
		"\u0000\u03a2\u039f\u0001\u0000\u0000\u0000\u03a2\u03a0\u0001\u0000\u0000"+
		"\u0000\u03a2\u03a1\u0001\u0000\u0000\u0000\u03a3\u03b0\u0001\u0000\u0000"+
		"\u0000\u03a4\u03a6\u0005\u0016\u0000\u0000\u03a5\u03a7\u0003\u0086C\u0000"+
		"\u03a6\u03a5\u0001\u0000\u0000\u0000\u03a6\u03a7\u0001\u0000\u0000\u0000"+
		"\u03a7\u03ac\u0001\u0000\u0000\u0000\u03a8\u03a9\u0005\u000f\u0000\u0000"+
		"\u03a9\u03ab\u0003\u0086C\u0000\u03aa\u03a8\u0001\u0000\u0000\u0000\u03ab"+
		"\u03ae\u0001\u0000\u0000\u0000\u03ac\u03aa\u0001\u0000\u0000\u0000\u03ac"+
		"\u03ad\u0001\u0000\u0000\u0000\u03ad\u03af\u0001\u0000\u0000\u0000\u03ae"+
		"\u03ac\u0001\u0000\u0000\u0000\u03af\u03b1\u0005\u0017\u0000\u0000\u03b0"+
		"\u03a4\u0001\u0000\u0000\u0000\u03b0\u03b1\u0001\u0000\u0000\u0000\u03b1"+
		"\u0089\u0001\u0000\u0000\u0000\u03b2\u03b3\u0005W\u0000\u0000\u03b3\u03b6"+
		"\u0003\u008eG\u0000\u03b4\u03b5\u0005X\u0000\u0000\u03b5\u03b7\u0003\u0086"+
		"C\u0000\u03b6\u03b4\u0001\u0000\u0000\u0000\u03b6\u03b7\u0001\u0000\u0000"+
		"\u0000\u03b7\u008b\u0001\u0000\u0000\u0000\u03b8\u03b9\u0003\u008eG\u0000"+
		"\u03b9\u03ba\u0005X\u0000\u0000\u03ba\u03bb\u0003\u0086C\u0000\u03bb\u008d"+
		"\u0001\u0000\u0000\u0000\u03bc\u03c1\u0003\u00aaU\u0000\u03bd\u03be\u0005"+
		"\u000f\u0000\u0000\u03be\u03c0\u0003\u00aaU\u0000\u03bf\u03bd\u0001\u0000"+
		"\u0000\u0000\u03c0\u03c3\u0001\u0000\u0000\u0000\u03c1\u03bf\u0001\u0000"+
		"\u0000\u0000\u03c1\u03c2\u0001\u0000\u0000\u0000\u03c2\u008f\u0001\u0000"+
		"\u0000\u0000\u03c3\u03c1\u0001\u0000\u0000\u0000\u03c4\u03c5\u0005Y\u0000"+
		"\u0000\u03c5\u03c6\u0003\u00aaU\u0000\u03c6\u0091\u0001\u0000\u0000\u0000"+
		"\u03c7\u03c8\u0003\u00aaU\u0000\u03c8\u03c9\u0005;\u0000\u0000\u03c9\u0093"+
		"\u0001\u0000\u0000\u0000\u03ca\u03cb\u0005Z\u0000\u0000\u03cb\u03cf\u0003"+
		"\u0086C\u0000\u03cc\u03ce\u0003\u0096K\u0000\u03cd\u03cc\u0001\u0000\u0000"+
		"\u0000\u03ce\u03d1\u0001\u0000\u0000\u0000\u03cf\u03cd\u0001\u0000\u0000"+
		"\u0000\u03cf\u03d0\u0001\u0000\u0000\u0000\u03d0\u0095\u0001\u0000\u0000"+
		"\u0000\u03d1\u03cf\u0001\u0000\u0000\u0000\u03d2\u03d3\u0005[\u0000\u0000"+
		"\u03d3\u03d5\u0003\u00a0P\u0000\u03d4\u03d6\u0003\u00a4R\u0000\u03d5\u03d4"+
		"\u0001\u0000\u0000\u0000\u03d5\u03d6\u0001\u0000\u0000\u0000\u03d6\u03d7"+
		"\u0001\u0000\u0000\u0000\u03d7\u03d8\u0003\u0084B\u0000\u03d8\u03dc\u0001"+
		"\u0000\u0000\u0000\u03d9\u03da\u0005\\\u0000\u0000\u03da\u03dc\u0003\u0084"+
		"B\u0000\u03db\u03d2\u0001\u0000\u0000\u0000\u03db\u03d9\u0001\u0000\u0000"+
		"\u0000\u03dc\u0097\u0001\u0000\u0000\u0000\u03dd\u03de\u0005\u001d\u0000"+
		"\u0000\u03de\u03df\u0003\u00aaU\u0000\u03df\u03e1\u0005\u0016\u0000\u0000"+
		"\u03e0\u03e2\u0003\u00a2Q\u0000\u03e1\u03e0\u0001\u0000\u0000\u0000\u03e1"+
		"\u03e2\u0001\u0000\u0000\u0000\u03e2\u03e3\u0001\u0000\u0000\u0000\u03e3"+
		"\u03e5\u0005\u0017\u0000\u0000\u03e4\u03e6\u0003\u009aM\u0000\u03e5\u03e4"+
		"\u0001\u0000\u0000\u0000\u03e5\u03e6\u0001\u0000\u0000\u0000\u03e6\u03e7"+
		"\u0001\u0000\u0000\u0000\u03e7\u03e8\u0003\u0084B\u0000\u03e8\u0099\u0001"+
		"\u0000\u0000\u0000\u03e9\u03ea\u0005=\u0000\u0000\u03ea\u03eb\u0005\u0006"+
		"\u0000\u0000\u03eb\u03ec\u0003\u00a2Q\u0000\u03ec\u009b\u0001\u0000\u0000"+
		"\u0000\u03ed\u03ee\u0005\u001a\u0000\u0000\u03ee\u03ef\u0003\u0084B\u0000"+
		"\u03ef\u03f0\u0003\u0086C\u0000\u03f0\u03f1\u0003\u0084B\u0000\u03f1\u03f2"+
		"\u0003\u0084B\u0000\u03f2\u009d\u0001\u0000\u0000\u0000\u03f3\u03f4\u0005"+
		")\u0000\u0000\u03f4\u03f5\u0003\u0086C\u0000\u03f5\u03f6\u0003\u0084B"+
		"\u0000\u03f6\u009f\u0001\u0000\u0000\u0000\u03f7\u03fd\u0003\u00aeW\u0000"+
		"\u03f8\u03fd\u0005c\u0000\u0000\u03f9\u03fd\u0005d\u0000\u0000\u03fa\u03fd"+
		"\u0003\u00acV\u0000\u03fb\u03fd\u0005b\u0000\u0000\u03fc\u03f7\u0001\u0000"+
		"\u0000\u0000\u03fc\u03f8\u0001\u0000\u0000\u0000\u03fc\u03f9\u0001\u0000"+
		"\u0000\u0000\u03fc\u03fa\u0001\u0000\u0000\u0000\u03fc\u03fb\u0001\u0000"+
		"\u0000\u0000\u03fd\u03ff\u0001\u0000\u0000\u0000\u03fe\u0400\u0003\u00a4"+
		"R\u0000\u03ff\u03fe\u0001\u0000\u0000\u0000\u03ff\u0400\u0001\u0000\u0000"+
		"\u0000\u0400\u00a1\u0001\u0000\u0000\u0000\u0401\u0403\u0003\u00aaU\u0000"+
		"\u0402\u0404\u0003\u00a4R\u0000\u0403\u0402\u0001\u0000\u0000\u0000\u0403"+
		"\u0404\u0001\u0000\u0000\u0000\u0404\u0407\u0001\u0000\u0000\u0000\u0405"+
		"\u0406\u0005\u000f\u0000\u0000\u0406\u0408\u0003\u00a2Q\u0000\u0407\u0405"+
		"\u0001\u0000\u0000\u0000\u0407\u0408\u0001\u0000\u0000\u0000\u0408\u00a3"+
		"\u0001\u0000\u0000\u0000\u0409\u040a\u0005;\u0000\u0000\u040a\u040b\u0003"+
		"\u00aaU\u0000\u040b\u00a5\u0001\u0000\u0000\u0000\u040c\u040d\u0005.\u0000"+
		"\u0000\u040d\u040e\u0003\u00aaU\u0000\u040e\u040f\u0003\u0084B\u0000\u040f"+
		"\u00a7\u0001\u0000\u0000\u0000\u0410\u0412\u0007\f\u0000\u0000\u0411\u0413"+
		"\u0005e\u0000\u0000\u0412\u0411\u0001\u0000\u0000\u0000\u0412\u0413\u0001"+
		"\u0000\u0000\u0000\u0413\u00a9\u0001\u0000\u0000\u0000\u0414\u0415\u0007"+
		"\r\u0000\u0000\u0415\u00ab\u0001\u0000\u0000\u0000\u0416\u0418\u0005f"+
		"\u0000\u0000\u0417\u0416\u0001\u0000\u0000\u0000\u0418\u0419\u0001\u0000"+
		"\u0000\u0000\u0419\u0417\u0001\u0000\u0000\u0000\u0419\u041a\u0001\u0000"+
		"\u0000\u0000\u041a\u00ad\u0001\u0000\u0000\u0000\u041b\u041d\u0005|\u0000"+
		"\u0000\u041c\u041b\u0001\u0000\u0000\u0000\u041d\u041e\u0001\u0000\u0000"+
		"\u0000\u041e\u041c\u0001\u0000\u0000\u0000\u041e\u041f\u0001\u0000\u0000"+
		"\u0000\u041f\u00af\u0001\u0000\u0000\u0000z\u00b5\u00b7\u00c5\u00c9\u00cc"+
		"\u00d6\u00dc\u00e0\u00ec\u00f4\u00f9\u00fc\u0106\u0109\u010f\u0117\u011a"+
		"\u0123\u012c\u012e\u0134\u013f\u0144\u014b\u0159\u015c\u0163\u0167\u0169"+
		"\u016e\u0174\u0178\u017e\u0183\u0190\u0192\u0198\u019b\u01a1\u01a9\u01af"+
		"\u01bc\u01bf\u01c5\u01c8\u01d0\u01d3\u01d9\u01dc\u01e0\u01e9\u01ee\u01f3"+
		"\u01fb\u0202\u020c\u0216\u0228\u0234\u0239\u023f\u0243\u0246\u0254\u0258"+
		"\u025b\u0262\u0266\u027a\u028c\u0290\u0295\u0299\u029d\u02a2\u02a7\u02ab"+
		"\u02b1\u02bc\u02d5\u0306\u030c\u0310\u0320\u0322\u032c\u0333\u0335\u033c"+
		"\u0344\u0348\u0350\u0354\u0356\u035f\u0363\u0367\u0371\u0374\u0377\u037b"+
		"\u038f\u0395\u039c\u03a2\u03a6\u03ac\u03b0\u03b6\u03c1\u03cf\u03d5\u03db"+
		"\u03e1\u03e5\u03fc\u03ff\u0403\u0407\u0412\u0419\u041e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}