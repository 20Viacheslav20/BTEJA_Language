// Generated from c:/Users/slavi/Downloads/a.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class aParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, MODULE=13, IMPORT=14, VARIABLES=15, INT=16, 
		INT_V=17, REAL=18, REAL_V=19, STR=20, STR_V=21, ARRAY=22, OF=23, PROCEDURE=24, 
		IF=25, THEN=26, ELSIF=27, ELSE=28, WHILE=29, DO=30, START=31, END=32, 
		RETURN=33, SEMI=34, COMMA=35, LPAREN=36, RPAREN=37, EQ=38, COLON=39, PERIOD=40, 
		IDENT_V=41, WS=42;
	public static final int
		RULE_module = 0, RULE_moduleStatements = 1, RULE_variablesDeclarationBlock = 2, 
		RULE_variablesDeclaration = 3, RULE_type = 4, RULE_procedure = 5, RULE_procedureDeclaration = 6, 
		RULE_procedureParameters = 7, RULE_procedureBody = 8, RULE_statement = 9, 
		RULE_procedureCall = 10, RULE_expression = 11, RULE_simpleExpression = 12, 
		RULE_addOperator = 13, RULE_relation = 14, RULE_term = 15, RULE_mulOperator = 16, 
		RULE_factor = 17, RULE_literal = 18, RULE_assignment = 19, RULE_ifStatement = 20, 
		RULE_elseIfStatement = 21, RULE_elseStatement = 22, RULE_whileStatement = 23, 
		RULE_returnStatement = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"module", "moduleStatements", "variablesDeclarationBlock", "variablesDeclaration", 
			"type", "procedure", "procedureDeclaration", "procedureParameters", "procedureBody", 
			"statement", "procedureCall", "expression", "simpleExpression", "addOperator", 
			"relation", "term", "mulOperator", "factor", "literal", "assignment", 
			"ifStatement", "elseIfStatement", "elseStatement", "whileStatement", 
			"returnStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'='", "'#'", "'<'", "'<='", "'>'", "'>='", "'*'", 
			"'/'", "'&'", "'~'", "'MODULE'", "'IMPORT'", "'VARIABLES'", "'INT'", 
			null, "'REAL'", null, "'STR'", null, "'ARRAY'", "'OF'", "'PROCEDURE'", 
			"'IF'", "'THEN'", "'ELSIF'", "'ELSE'", "'WHILE'", "'DO'", "'START'", 
			"'END'", "'RETURN'", "';'", "','", "'('", "')'", "':='", "':'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "MODULE", "IMPORT", "VARIABLES", "INT", "INT_V", "REAL", "REAL_V", 
			"STR", "STR_V", "ARRAY", "OF", "PROCEDURE", "IF", "THEN", "ELSIF", "ELSE", 
			"WHILE", "DO", "START", "END", "RETURN", "SEMI", "COMMA", "LPAREN", "RPAREN", 
			"EQ", "COLON", "PERIOD", "IDENT_V", "WS"
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
	public String getGrammarFileName() { return "a.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public aParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(aParser.MODULE, 0); }
		public TerminalNode IDENT_V() { return getToken(aParser.IDENT_V, 0); }
		public TerminalNode SEMI() { return getToken(aParser.SEMI, 0); }
		public TerminalNode PERIOD() { return getToken(aParser.PERIOD, 0); }
		public ModuleStatementsContext moduleStatements() {
			return getRuleContext(ModuleStatementsContext.class,0);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(MODULE);
			setState(51);
			match(IDENT_V);
			setState(52);
			match(SEMI);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2164310016L) != 0)) {
				{
				setState(53);
				moduleStatements();
				}
			}

			setState(56);
			match(PERIOD);
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
	public static class ModuleStatementsContext extends ParserRuleContext {
		public ProcedureBodyContext procedureBody() {
			return getRuleContext(ProcedureBodyContext.class,0);
		}
		public List<TerminalNode> IDENT_V() { return getTokens(aParser.IDENT_V); }
		public TerminalNode IDENT_V(int i) {
			return getToken(aParser.IDENT_V, i);
		}
		public List<TerminalNode> IMPORT() { return getTokens(aParser.IMPORT); }
		public TerminalNode IMPORT(int i) {
			return getToken(aParser.IMPORT, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(aParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(aParser.SEMI, i);
		}
		public VariablesDeclarationBlockContext variablesDeclarationBlock() {
			return getRuleContext(VariablesDeclarationBlockContext.class,0);
		}
		public List<ProcedureContext> procedure() {
			return getRuleContexts(ProcedureContext.class);
		}
		public ProcedureContext procedure(int i) {
			return getRuleContext(ProcedureContext.class,i);
		}
		public ModuleStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleStatements; }
	}

	public final ModuleStatementsContext moduleStatements() throws RecognitionException {
		ModuleStatementsContext _localctx = new ModuleStatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_moduleStatements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(58);
				match(IMPORT);
				setState(59);
				match(IDENT_V);
				setState(60);
				match(SEMI);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABLES) {
				{
				setState(66);
				variablesDeclarationBlock();
				}
			}

			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROCEDURE) {
				{
				{
				setState(69);
				procedure();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			procedureBody();
			setState(76);
			match(IDENT_V);
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
	public static class VariablesDeclarationBlockContext extends ParserRuleContext {
		public TerminalNode VARIABLES() { return getToken(aParser.VARIABLES, 0); }
		public List<VariablesDeclarationContext> variablesDeclaration() {
			return getRuleContexts(VariablesDeclarationContext.class);
		}
		public VariablesDeclarationContext variablesDeclaration(int i) {
			return getRuleContext(VariablesDeclarationContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(aParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(aParser.SEMI, i);
		}
		public VariablesDeclarationBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablesDeclarationBlock; }
	}

	public final VariablesDeclarationBlockContext variablesDeclarationBlock() throws RecognitionException {
		VariablesDeclarationBlockContext _localctx = new VariablesDeclarationBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variablesDeclarationBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(VARIABLES);
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				variablesDeclaration();
				setState(80);
				match(SEMI);
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT_V );
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
	public static class VariablesDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> IDENT_V() { return getTokens(aParser.IDENT_V); }
		public TerminalNode IDENT_V(int i) {
			return getToken(aParser.IDENT_V, i);
		}
		public TerminalNode COLON() { return getToken(aParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(aParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(aParser.COMMA, i);
		}
		public VariablesDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablesDeclaration; }
	}

	public final VariablesDeclarationContext variablesDeclaration() throws RecognitionException {
		VariablesDeclarationContext _localctx = new VariablesDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variablesDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(IDENT_V);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(87);
				match(COMMA);
				setState(88);
				match(IDENT_V);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(COLON);
			setState(95);
			type();
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(aParser.INT, 0); }
		public TerminalNode REAL() { return getToken(aParser.REAL, 0); }
		public TerminalNode STR() { return getToken(aParser.STR, 0); }
		public TerminalNode ARRAY() { return getToken(aParser.ARRAY, 0); }
		public TerminalNode OF() { return getToken(aParser.OF, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(INT);
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(REAL);
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				match(STR);
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				match(ARRAY);
				setState(101);
				match(OF);
				setState(102);
				type();
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
	public static class ProcedureContext extends ParserRuleContext {
		public ProcedureDeclarationContext procedureDeclaration() {
			return getRuleContext(ProcedureDeclarationContext.class,0);
		}
		public ProcedureBodyContext procedureBody() {
			return getRuleContext(ProcedureBodyContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(aParser.SEMI, 0); }
		public VariablesDeclarationBlockContext variablesDeclarationBlock() {
			return getRuleContext(VariablesDeclarationBlockContext.class,0);
		}
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			procedureDeclaration();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABLES) {
				{
				setState(106);
				variablesDeclarationBlock();
				}
			}

			setState(109);
			procedureBody();
			setState(110);
			match(SEMI);
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
	public static class ProcedureDeclarationContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(aParser.PROCEDURE, 0); }
		public TerminalNode IDENT_V() { return getToken(aParser.IDENT_V, 0); }
		public TerminalNode LPAREN() { return getToken(aParser.LPAREN, 0); }
		public ProcedureParametersContext procedureParameters() {
			return getRuleContext(ProcedureParametersContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(aParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(aParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ProcedureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureDeclaration; }
	}

	public final ProcedureDeclarationContext procedureDeclaration() throws RecognitionException {
		ProcedureDeclarationContext _localctx = new ProcedureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_procedureDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(PROCEDURE);
			setState(113);
			match(IDENT_V);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(114);
				match(LPAREN);
				setState(115);
				procedureParameters();
				setState(116);
				match(RPAREN);
				}
			}

			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(120);
				match(COLON);
				setState(121);
				type();
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
	public static class ProcedureParametersContext extends ParserRuleContext {
		public List<VariablesDeclarationContext> variablesDeclaration() {
			return getRuleContexts(VariablesDeclarationContext.class);
		}
		public VariablesDeclarationContext variablesDeclaration(int i) {
			return getRuleContext(VariablesDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(aParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(aParser.COMMA, i);
		}
		public ProcedureParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureParameters; }
	}

	public final ProcedureParametersContext procedureParameters() throws RecognitionException {
		ProcedureParametersContext _localctx = new ProcedureParametersContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_procedureParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			variablesDeclaration();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(125);
				match(COMMA);
				setState(126);
				variablesDeclaration();
				}
				}
				setState(131);
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
	public static class ProcedureBodyContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(aParser.START, 0); }
		public TerminalNode END() { return getToken(aParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProcedureBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureBody; }
	}

	public final ProcedureBodyContext procedureBody() throws RecognitionException {
		ProcedureBodyContext _localctx = new ProcedureBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_procedureBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(START);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2208183615488L) != 0)) {
				{
				{
				setState(133);
				statement();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139);
			match(END);
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
		public TerminalNode SEMI() { return getToken(aParser.SEMI, 0); }
		public ProcedureCallContext procedureCall() {
			return getRuleContext(ProcedureCallContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(141);
				procedureCall();
				}
				break;
			case 2:
				{
				setState(142);
				assignment();
				}
				break;
			case 3:
				{
				setState(143);
				ifStatement();
				}
				break;
			case 4:
				{
				setState(144);
				whileStatement();
				}
				break;
			case 5:
				{
				setState(145);
				returnStatement();
				}
				break;
			}
			setState(148);
			match(SEMI);
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
	public static class ProcedureCallContext extends ParserRuleContext {
		public TerminalNode IDENT_V() { return getToken(aParser.IDENT_V, 0); }
		public TerminalNode LPAREN() { return getToken(aParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(aParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(aParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(aParser.COMMA, i);
		}
		public ProcedureCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureCall; }
	}

	public final ProcedureCallContext procedureCall() throws RecognitionException {
		ProcedureCallContext _localctx = new ProcedureCallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_procedureCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(IDENT_V);
			setState(151);
			match(LPAREN);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2267745488902L) != 0)) {
				{
				setState(152);
				expression();
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(153);
					match(COMMA);
					setState(154);
					expression();
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(162);
			match(RPAREN);
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
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			simpleExpression();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 504L) != 0)) {
				{
				setState(165);
				relation();
				setState(166);
				simpleExpression();
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
	public static class SimpleExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<AddOperatorContext> addOperator() {
			return getRuleContexts(AddOperatorContext.class);
		}
		public AddOperatorContext addOperator(int i) {
			return getRuleContext(AddOperatorContext.class,i);
		}
		public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpression; }
	}

	public final SimpleExpressionContext simpleExpression() throws RecognitionException {
		SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_simpleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__1) {
				{
				setState(170);
				addOperator();
				}
			}

			setState(173);
			term();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__1) {
				{
				{
				setState(174);
				addOperator();
				setState(175);
				term();
				}
				}
				setState(181);
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
	public static class AddOperatorContext extends ParserRuleContext {
		public AddOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOperator; }
	}

	public final AddOperatorContext addOperator() throws RecognitionException {
		AddOperatorContext _localctx = new AddOperatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_addOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
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
	public static class RelationContext extends ParserRuleContext {
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 504L) != 0)) ) {
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
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<MulOperatorContext> mulOperator() {
			return getRuleContexts(MulOperatorContext.class);
		}
		public MulOperatorContext mulOperator(int i) {
			return getRuleContext(MulOperatorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			factor();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) {
				{
				{
				setState(187);
				mulOperator();
				setState(188);
				factor();
				}
				}
				setState(194);
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
	public static class MulOperatorContext extends ParserRuleContext {
		public MulOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOperator; }
	}

	public final MulOperatorContext mulOperator() throws RecognitionException {
		MulOperatorContext _localctx = new MulOperatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mulOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
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
	public static class FactorContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(aParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(aParser.RPAREN, 0); }
		public ProcedureCallContext procedureCall() {
			return getRuleContext(ProcedureCallContext.class,0);
		}
		public TerminalNode IDENT_V() { return getToken(aParser.IDENT_V, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_factor);
		try {
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(T__11);
				setState(198);
				factor();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(LPAREN);
				setState(200);
				expression();
				setState(201);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				procedureCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
				match(IDENT_V);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				literal();
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
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode REAL_V() { return getToken(aParser.REAL_V, 0); }
		public TerminalNode INT_V() { return getToken(aParser.INT_V, 0); }
		public TerminalNode STR_V() { return getToken(aParser.STR_V, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2752512L) != 0)) ) {
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENT_V() { return getToken(aParser.IDENT_V, 0); }
		public TerminalNode EQ() { return getToken(aParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(IDENT_V);
			setState(211);
			match(EQ);
			setState(212);
			expression();
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
		public TerminalNode IF() { return getToken(aParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(aParser.THEN, 0); }
		public TerminalNode END() { return getToken(aParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseIfStatementContext elseIfStatement() {
			return getRuleContext(ElseIfStatementContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(IF);
			setState(215);
			expression();
			setState(216);
			match(THEN);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2208183615488L) != 0)) {
				{
				{
				setState(217);
				statement();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSIF) {
				{
				setState(223);
				elseIfStatement();
				}
			}

			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(226);
				elseStatement();
				}
			}

			setState(229);
			match(END);
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
	public static class ElseIfStatementContext extends ParserRuleContext {
		public TerminalNode ELSIF() { return getToken(aParser.ELSIF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(aParser.THEN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_elseIfStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(ELSIF);
			setState(232);
			expression();
			setState(233);
			match(THEN);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2208183615488L) != 0)) {
				{
				{
				setState(234);
				statement();
				}
				}
				setState(239);
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
	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(aParser.ELSE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(ELSE);
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2208183615488L) != 0)) {
				{
				{
				setState(241);
				statement();
				}
				}
				setState(246);
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
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(aParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DO() { return getToken(aParser.DO, 0); }
		public TerminalNode END() { return getToken(aParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_whileStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(WHILE);
			setState(248);
			expression();
			setState(249);
			match(DO);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2208183615488L) != 0)) {
				{
				{
				setState(250);
				statement();
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			match(END);
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
		public TerminalNode RETURN() { return getToken(aParser.RETURN, 0); }
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
		enterRule(_localctx, 48, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(RETURN);
			setState(259);
			expression();
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
		"\u0004\u0001*\u0106\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u00007\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		">\b\u0001\n\u0001\f\u0001A\t\u0001\u0001\u0001\u0003\u0001D\b\u0001\u0001"+
		"\u0001\u0005\u0001G\b\u0001\n\u0001\f\u0001J\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004"+
		"\u0002S\b\u0002\u000b\u0002\f\u0002T\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003Z\b\u0003\n\u0003\f\u0003]\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004h\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005"+
		"l\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006w\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006{\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u0080\b\u0007\n\u0007\f\u0007\u0083\t\u0007\u0001"+
		"\b\u0001\b\u0005\b\u0087\b\b\n\b\f\b\u008a\t\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0093\b\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u009c\b\n\n\n\f\n\u009f\t\n"+
		"\u0003\n\u00a1\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00a9\b\u000b\u0001\f\u0003\f\u00ac\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0005\f\u00b2\b\f\n\f\f\f\u00b5\t\f\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u00bf\b\u000f\n\u000f\f\u000f\u00c2\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00cf\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00db\b\u0014"+
		"\n\u0014\f\u0014\u00de\t\u0014\u0001\u0014\u0003\u0014\u00e1\b\u0014\u0001"+
		"\u0014\u0003\u0014\u00e4\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00ec\b\u0015\n\u0015\f\u0015"+
		"\u00ef\t\u0015\u0001\u0016\u0001\u0016\u0005\u0016\u00f3\b\u0016\n\u0016"+
		"\f\u0016\u00f6\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u00fc\b\u0017\n\u0017\f\u0017\u00ff\t\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0000\u0000\u0019"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.0\u0000\u0004\u0001\u0000\u0001\u0002\u0001\u0000"+
		"\u0003\b\u0001\u0000\t\u000b\u0003\u0000\u0011\u0011\u0013\u0013\u0015"+
		"\u0015\u010e\u00002\u0001\u0000\u0000\u0000\u0002?\u0001\u0000\u0000\u0000"+
		"\u0004N\u0001\u0000\u0000\u0000\u0006V\u0001\u0000\u0000\u0000\bg\u0001"+
		"\u0000\u0000\u0000\ni\u0001\u0000\u0000\u0000\fp\u0001\u0000\u0000\u0000"+
		"\u000e|\u0001\u0000\u0000\u0000\u0010\u0084\u0001\u0000\u0000\u0000\u0012"+
		"\u0092\u0001\u0000\u0000\u0000\u0014\u0096\u0001\u0000\u0000\u0000\u0016"+
		"\u00a4\u0001\u0000\u0000\u0000\u0018\u00ab\u0001\u0000\u0000\u0000\u001a"+
		"\u00b6\u0001\u0000\u0000\u0000\u001c\u00b8\u0001\u0000\u0000\u0000\u001e"+
		"\u00ba\u0001\u0000\u0000\u0000 \u00c3\u0001\u0000\u0000\u0000\"\u00ce"+
		"\u0001\u0000\u0000\u0000$\u00d0\u0001\u0000\u0000\u0000&\u00d2\u0001\u0000"+
		"\u0000\u0000(\u00d6\u0001\u0000\u0000\u0000*\u00e7\u0001\u0000\u0000\u0000"+
		",\u00f0\u0001\u0000\u0000\u0000.\u00f7\u0001\u0000\u0000\u00000\u0102"+
		"\u0001\u0000\u0000\u000023\u0005\r\u0000\u000034\u0005)\u0000\u000046"+
		"\u0005\"\u0000\u000057\u0003\u0002\u0001\u000065\u0001\u0000\u0000\u0000"+
		"67\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u000089\u0005(\u0000\u0000"+
		"9\u0001\u0001\u0000\u0000\u0000:;\u0005\u000e\u0000\u0000;<\u0005)\u0000"+
		"\u0000<>\u0005\"\u0000\u0000=:\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000"+
		"\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@C\u0001\u0000"+
		"\u0000\u0000A?\u0001\u0000\u0000\u0000BD\u0003\u0004\u0002\u0000CB\u0001"+
		"\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DH\u0001\u0000\u0000\u0000"+
		"EG\u0003\n\u0005\u0000FE\u0001\u0000\u0000\u0000GJ\u0001\u0000\u0000\u0000"+
		"HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IK\u0001\u0000\u0000"+
		"\u0000JH\u0001\u0000\u0000\u0000KL\u0003\u0010\b\u0000LM\u0005)\u0000"+
		"\u0000M\u0003\u0001\u0000\u0000\u0000NR\u0005\u000f\u0000\u0000OP\u0003"+
		"\u0006\u0003\u0000PQ\u0005\"\u0000\u0000QS\u0001\u0000\u0000\u0000RO\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000U\u0005\u0001\u0000\u0000\u0000V[\u0005)\u0000"+
		"\u0000WX\u0005#\u0000\u0000XZ\u0005)\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000"+
		"\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005\'"+
		"\u0000\u0000_`\u0003\b\u0004\u0000`\u0007\u0001\u0000\u0000\u0000ah\u0005"+
		"\u0010\u0000\u0000bh\u0005\u0012\u0000\u0000ch\u0005\u0014\u0000\u0000"+
		"de\u0005\u0016\u0000\u0000ef\u0005\u0017\u0000\u0000fh\u0003\b\u0004\u0000"+
		"ga\u0001\u0000\u0000\u0000gb\u0001\u0000\u0000\u0000gc\u0001\u0000\u0000"+
		"\u0000gd\u0001\u0000\u0000\u0000h\t\u0001\u0000\u0000\u0000ik\u0003\f"+
		"\u0006\u0000jl\u0003\u0004\u0002\u0000kj\u0001\u0000\u0000\u0000kl\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0003\u0010\b\u0000no\u0005"+
		"\"\u0000\u0000o\u000b\u0001\u0000\u0000\u0000pq\u0005\u0018\u0000\u0000"+
		"qv\u0005)\u0000\u0000rs\u0005$\u0000\u0000st\u0003\u000e\u0007\u0000t"+
		"u\u0005%\u0000\u0000uw\u0001\u0000\u0000\u0000vr\u0001\u0000\u0000\u0000"+
		"vw\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xy\u0005\'\u0000\u0000"+
		"y{\u0003\b\u0004\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{\r\u0001\u0000\u0000\u0000|\u0081\u0003\u0006\u0003\u0000}~\u0005#\u0000"+
		"\u0000~\u0080\u0003\u0006\u0003\u0000\u007f}\u0001\u0000\u0000\u0000\u0080"+
		"\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0001\u0000\u0000\u0000\u0082\u000f\u0001\u0000\u0000\u0000\u0083"+
		"\u0081\u0001\u0000\u0000\u0000\u0084\u0088\u0005\u001f\u0000\u0000\u0085"+
		"\u0087\u0003\u0012\t\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u008a"+
		"\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0001\u0000\u0000\u0000\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u0088"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0005 \u0000\u0000\u008c\u0011\u0001"+
		"\u0000\u0000\u0000\u008d\u0093\u0003\u0014\n\u0000\u008e\u0093\u0003&"+
		"\u0013\u0000\u008f\u0093\u0003(\u0014\u0000\u0090\u0093\u0003.\u0017\u0000"+
		"\u0091\u0093\u00030\u0018\u0000\u0092\u008d\u0001\u0000\u0000\u0000\u0092"+
		"\u008e\u0001\u0000\u0000\u0000\u0092\u008f\u0001\u0000\u0000\u0000\u0092"+
		"\u0090\u0001\u0000\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0001\u0000\u0000\u0000\u0094\u0095\u0005\"\u0000\u0000\u0095\u0013"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0005)\u0000\u0000\u0097\u00a0\u0005"+
		"$\u0000\u0000\u0098\u009d\u0003\u0016\u000b\u0000\u0099\u009a\u0005#\u0000"+
		"\u0000\u009a\u009c\u0003\u0016\u000b\u0000\u009b\u0099\u0001\u0000\u0000"+
		"\u0000\u009c\u009f\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u00a1\u0001\u0000\u0000"+
		"\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0\u0098\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0005%\u0000\u0000\u00a3\u0015\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a8\u0003\u0018\f\u0000\u00a5\u00a6\u0003\u001c\u000e\u0000\u00a6"+
		"\u00a7\u0003\u0018\f\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u0017"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ac\u0003\u001a\r\u0000\u00ab\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001"+
		"\u0000\u0000\u0000\u00ad\u00b3\u0003\u001e\u000f\u0000\u00ae\u00af\u0003"+
		"\u001a\r\u0000\u00af\u00b0\u0003\u001e\u000f\u0000\u00b0\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b1\u00ae\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b4\u0019\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0007\u0000\u0000\u0000\u00b7\u001b\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0007\u0001\u0000\u0000\u00b9\u001d\u0001\u0000"+
		"\u0000\u0000\u00ba\u00c0\u0003\"\u0011\u0000\u00bb\u00bc\u0003 \u0010"+
		"\u0000\u00bc\u00bd\u0003\"\u0011\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000"+
		"\u00be\u00bb\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c1\u001f\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0007\u0002\u0000\u0000\u00c4!\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005\f\u0000\u0000\u00c6\u00cf\u0003\"\u0011\u0000\u00c7\u00c8"+
		"\u0005$\u0000\u0000\u00c8\u00c9\u0003\u0016\u000b\u0000\u00c9\u00ca\u0005"+
		"%\u0000\u0000\u00ca\u00cf\u0001\u0000\u0000\u0000\u00cb\u00cf\u0003\u0014"+
		"\n\u0000\u00cc\u00cf\u0005)\u0000\u0000\u00cd\u00cf\u0003$\u0012\u0000"+
		"\u00ce\u00c5\u0001\u0000\u0000\u0000\u00ce\u00c7\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf#\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0007\u0003\u0000\u0000\u00d1%\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0005)\u0000\u0000\u00d3\u00d4\u0005&\u0000\u0000\u00d4\u00d5\u0003\u0016"+
		"\u000b\u0000\u00d5\'\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u0019\u0000"+
		"\u0000\u00d7\u00d8\u0003\u0016\u000b\u0000\u00d8\u00dc\u0005\u001a\u0000"+
		"\u0000\u00d9\u00db\u0003\u0012\t\u0000\u00da\u00d9\u0001\u0000\u0000\u0000"+
		"\u00db\u00de\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00e0\u0001\u0000\u0000\u0000"+
		"\u00de\u00dc\u0001\u0000\u0000\u0000\u00df\u00e1\u0003*\u0015\u0000\u00e0"+
		"\u00df\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e2\u00e4\u0003,\u0016\u0000\u00e3\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005 \u0000\u0000\u00e6)\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0005\u001b\u0000\u0000\u00e8\u00e9\u0003\u0016"+
		"\u000b\u0000\u00e9\u00ed\u0005\u001a\u0000\u0000\u00ea\u00ec\u0003\u0012"+
		"\t\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ee+\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f4\u0005\u001c\u0000\u0000\u00f1\u00f3\u0003\u0012\t\u0000\u00f2"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5"+
		"-\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u00f8"+
		"\u0005\u001d\u0000\u0000\u00f8\u00f9\u0003\u0016\u000b\u0000\u00f9\u00fd"+
		"\u0005\u001e\u0000\u0000\u00fa\u00fc\u0003\u0012\t\u0000\u00fb\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fc\u00ff\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u0100\u0001"+
		"\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u0100\u0101\u0005"+
		" \u0000\u0000\u0101/\u0001\u0000\u0000\u0000\u0102\u0103\u0005!\u0000"+
		"\u0000\u0103\u0104\u0003\u0016\u000b\u0000\u01041\u0001\u0000\u0000\u0000"+
		"\u001a6?CHT[gkvz\u0081\u0088\u0092\u009d\u00a0\u00a8\u00ab\u00b3\u00c0"+
		"\u00ce\u00dc\u00e0\u00e3\u00ed\u00f4\u00fd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}