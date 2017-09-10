// Generated from /Users/lytr777/IdeaProjects/MATLOG_HW/src/com/lytr777/propositionalCalculus/parser/FirstHW.g4 by ANTLR 4.7
package com.lytr777.propositionalCalculus.parser;

import com.lytr777.propositionalCalculus.Expression;
import com.lytr777.propositionalCalculus.InitialData;
import com.lytr777.propositionalCalculus.operations.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FirstHWParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		NAME=10;
	public static final int
		RULE_file = 0, RULE_title = 1, RULE_expression = 2, RULE_dis = 3, RULE_diss = 4, 
		RULE_con = 5, RULE_cons = 6, RULE_neg = 7;
	public static final String[] ruleNames = {
		"file", "title", "expression", "dis", "diss", "con", "cons", "neg"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "','", "'|-'", "'->'", "'|'", "'&'", "'!'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "NAME"
	};
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
	public String getGrammarFileName() { return "FirstHW.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	public InitialData data = new InitialData();
	public int lines = 0;

	public FirstHWParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public ExpressionContext expression;
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			title();
			setState(17);
			match(T__0);
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << NAME))) != 0)) {
				{
				{
				setState(18);
				((FileContext)_localctx).expression = expression();
				setState(19);
				match(T__0);
				 data.addProofExpression(new Expression(((FileContext)_localctx).expression.op)); lines += 1; if (lines % 500 == 0) System.out.println("Прочитано " + lines + " строк");
				}
				}
				setState(26);
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

	public static class TitleContext extends ParserRuleContext {
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_title);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << NAME))) != 0)) {
				{
				setState(27);
				((TitleContext)_localctx).expression = expression();
				 data.addAssumptionExpression(new Expression(((TitleContext)_localctx).expression.op)); 
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(29);
					match(T__1);
					setState(30);
					((TitleContext)_localctx).expression = expression();
					 data.addAssumptionExpression(new Expression(((TitleContext)_localctx).expression.op)); 
					}
					}
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			{
			setState(40);
			match(T__2);
			setState(41);
			((TitleContext)_localctx).expression = expression();
			 data.setStatement(new Expression(((TitleContext)_localctx).expression.op));
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

	public static class ExpressionContext extends ParserRuleContext {
		public Operation op;
		public DisContext dis;
		public ExpressionContext expression;
		public DisContext dis() {
			return getRuleContext(DisContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expression);
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				((ExpressionContext)_localctx).dis = dis();
				 ((ExpressionContext)_localctx).op =  new Implication(((ExpressionContext)_localctx).dis.op); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				((ExpressionContext)_localctx).dis = dis();
				setState(48);
				match(T__3);
				setState(49);
				((ExpressionContext)_localctx).expression = expression();
				 ((ExpressionContext)_localctx).op =  new Implication(((ExpressionContext)_localctx).dis.op, ((ExpressionContext)_localctx).expression.op); 
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

	public static class DisContext extends ParserRuleContext {
		public Operation op;
		public ConContext con;
		public DissContext diss;
		public ConContext con() {
			return getRuleContext(ConContext.class,0);
		}
		public DissContext diss() {
			return getRuleContext(DissContext.class,0);
		}
		public DisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).enterDis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).exitDis(this);
		}
	}

	public final DisContext dis() throws RecognitionException {
		DisContext _localctx = new DisContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			((DisContext)_localctx).con = con();
			setState(55);
			((DisContext)_localctx).diss = diss();
			 ((DisContext)_localctx).op =  new Disjunction(((DisContext)_localctx).con.op, ((DisContext)_localctx).diss.op); 
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

	public static class DissContext extends ParserRuleContext {
		public Operation op;
		public ConContext con;
		public DissContext diss;
		public ConContext con() {
			return getRuleContext(ConContext.class,0);
		}
		public DissContext diss() {
			return getRuleContext(DissContext.class,0);
		}
		public DissContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diss; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).enterDiss(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).exitDiss(this);
		}
	}

	public final DissContext diss() throws RecognitionException {
		DissContext _localctx = new DissContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_diss);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(T__4);
				setState(59);
				((DissContext)_localctx).con = con();
				setState(60);
				((DissContext)_localctx).diss = diss();
				 ((DissContext)_localctx).op =  new Disjunction(((DissContext)_localctx).con.op, ((DissContext)_localctx).diss.op); 
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				 ((DissContext)_localctx).op =  null; 
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

	public static class ConContext extends ParserRuleContext {
		public Operation op;
		public NegContext neg;
		public ConsContext cons;
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public ConsContext cons() {
			return getRuleContext(ConsContext.class,0);
		}
		public ConContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_con; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).enterCon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).exitCon(this);
		}
	}

	public final ConContext con() throws RecognitionException {
		ConContext _localctx = new ConContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_con);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			((ConContext)_localctx).neg = neg();
			setState(67);
			((ConContext)_localctx).cons = cons();
			 ((ConContext)_localctx).op =  new Conjunction(((ConContext)_localctx).neg.op, ((ConContext)_localctx).cons.op); 
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

	public static class ConsContext extends ParserRuleContext {
		public Operation op;
		public NegContext neg;
		public ConsContext cons;
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public ConsContext cons() {
			return getRuleContext(ConsContext.class,0);
		}
		public ConsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cons; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).enterCons(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).exitCons(this);
		}
	}

	public final ConsContext cons() throws RecognitionException {
		ConsContext _localctx = new ConsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cons);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(T__5);
				setState(71);
				((ConsContext)_localctx).neg = neg();
				setState(72);
				((ConsContext)_localctx).cons = cons();
				 ((ConsContext)_localctx).op =  new Conjunction(((ConsContext)_localctx).neg.op, ((ConsContext)_localctx).cons.op); 
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				 ((ConsContext)_localctx).op =  null; 
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

	public static class NegContext extends ParserRuleContext {
		public Operation op;
		public Token NAME;
		public NegContext neg;
		public ExpressionContext expression;
		public TerminalNode NAME() { return getToken(FirstHWParser.NAME, 0); }
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).enterNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FirstHWListener ) ((FirstHWListener)listener).exitNeg(this);
		}
	}

	public final NegContext neg() throws RecognitionException {
		NegContext _localctx = new NegContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_neg);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				((NegContext)_localctx).NAME = match(NAME);
				 ((NegContext)_localctx).op =  new Variable((((NegContext)_localctx).NAME!=null?((NegContext)_localctx).NAME.getText():null)); 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(T__6);
				setState(81);
				((NegContext)_localctx).neg = neg();
				 ((NegContext)_localctx).op =  new Negation(((NegContext)_localctx).neg.op); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				match(T__7);
				setState(85);
				((NegContext)_localctx).expression = expression();
				setState(86);
				match(T__8);
				 ((NegContext)_localctx).op =  ((NegContext)_localctx).expression.op; 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f^\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3$\n\3\f\3"+
		"\16\3\'\13\3\5\3)\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4\67\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6C\n\6\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bO\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\t\\\n\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2]\2\22\3\2\2"+
		"\2\4(\3\2\2\2\6\66\3\2\2\2\b8\3\2\2\2\nB\3\2\2\2\fD\3\2\2\2\16N\3\2\2"+
		"\2\20[\3\2\2\2\22\23\5\4\3\2\23\32\7\3\2\2\24\25\5\6\4\2\25\26\7\3\2\2"+
		"\26\27\b\2\1\2\27\31\3\2\2\2\30\24\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2"+
		"\32\33\3\2\2\2\33\3\3\2\2\2\34\32\3\2\2\2\35\36\5\6\4\2\36%\b\3\1\2\37"+
		" \7\4\2\2 !\5\6\4\2!\"\b\3\1\2\"$\3\2\2\2#\37\3\2\2\2$\'\3\2\2\2%#\3\2"+
		"\2\2%&\3\2\2\2&)\3\2\2\2\'%\3\2\2\2(\35\3\2\2\2()\3\2\2\2)*\3\2\2\2*+"+
		"\7\5\2\2+,\5\6\4\2,-\b\3\1\2-\5\3\2\2\2./\5\b\5\2/\60\b\4\1\2\60\67\3"+
		"\2\2\2\61\62\5\b\5\2\62\63\7\6\2\2\63\64\5\6\4\2\64\65\b\4\1\2\65\67\3"+
		"\2\2\2\66.\3\2\2\2\66\61\3\2\2\2\67\7\3\2\2\289\5\f\7\29:\5\n\6\2:;\b"+
		"\5\1\2;\t\3\2\2\2<=\7\7\2\2=>\5\f\7\2>?\5\n\6\2?@\b\6\1\2@C\3\2\2\2AC"+
		"\b\6\1\2B<\3\2\2\2BA\3\2\2\2C\13\3\2\2\2DE\5\20\t\2EF\5\16\b\2FG\b\7\1"+
		"\2G\r\3\2\2\2HI\7\b\2\2IJ\5\20\t\2JK\5\16\b\2KL\b\b\1\2LO\3\2\2\2MO\b"+
		"\b\1\2NH\3\2\2\2NM\3\2\2\2O\17\3\2\2\2PQ\7\f\2\2Q\\\b\t\1\2RS\7\t\2\2"+
		"ST\5\20\t\2TU\b\t\1\2U\\\3\2\2\2VW\7\n\2\2WX\5\6\4\2XY\7\13\2\2YZ\b\t"+
		"\1\2Z\\\3\2\2\2[P\3\2\2\2[R\3\2\2\2[V\3\2\2\2\\\21\3\2\2\2\t\32%(\66B"+
		"N[";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}