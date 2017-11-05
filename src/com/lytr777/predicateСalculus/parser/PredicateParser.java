// Generated from /Users/lytr777/IdeaProjects/MATLOG_HW/src/com/lytr777/predicateСalculus/parser/Predicate.g4 by ANTLR 4.7
package com.lytr777.predicateСalculus.parser;

import com.lytr777.propositionalCalculus.operations.*;
import com.lytr777.predicateСalculus.operations.*;
import com.lytr777.predicateСalculus.operations.Predicate;
import com.lytr777.util.Expression;
import com.lytr777.util.InitialData;
import javafx.util.Pair;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PredicateParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, VAR=17, 
		PRED=18, NUMBER=19, SKP=20;
	public static final int
		RULE_file = 0, RULE_five = 1, RULE_title = 2, RULE_expression = 3, RULE_dis = 4, 
		RULE_con = 5, RULE_neg = 6, RULE_pred = 7, RULE_term = 8, RULE_add = 9, 
		RULE_mul = 10, RULE_num = 11;
	public static final String[] ruleNames = {
		"file", "five", "title", "expression", "dis", "con", "neg", "pred", "term", 
		"add", "mul", "num"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "','", "'|-'", "'->'", "'|'", "'&'", "'!'", "'('", "')'", 
		"'@'", "'?'", "'='", "'+'", "'*'", "'0'", "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "VAR", "PRED", "NUMBER", "SKP"
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
	public String getGrammarFileName() { return "Predicate.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	public InitialData data = new InitialData();
	public int lines = 0;

	public PredicateParser(TokenStream input) {
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
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			title();
			setState(25);
			match(T__0);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << VAR) | (1L << PRED))) != 0)) {
				{
				{
				setState(26);
				((FileContext)_localctx).expression = expression();
				setState(27);
				match(T__0);
				 data.addProofExpression(new Expression(((FileContext)_localctx).expression.op)); lines += 1; if (lines % 500 == 0) System.out.println("Прочитано " + lines + " строк");
				}
				}
				setState(34);
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

	public static class FiveContext extends ParserRuleContext {
		public Pair<Integer, Integer> ab;
		public NumContext a;
		public NumContext b;
		public List<NumContext> num() {
			return getRuleContexts(NumContext.class);
		}
		public NumContext num(int i) {
			return getRuleContext(NumContext.class,i);
		}
		public FiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_five; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterFive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitFive(this);
		}
	}

	public final FiveContext five() throws RecognitionException {
		FiveContext _localctx = new FiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_five);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			((FiveContext)_localctx).a = num();
			setState(36);
			((FiveContext)_localctx).b = num();
			 ((FiveContext)_localctx).ab =  new Pair<>(((FiveContext)_localctx).a.value, ((FiveContext)_localctx).b.value); 
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
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_title);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << VAR) | (1L << PRED))) != 0)) {
				{
				setState(39);
				((TitleContext)_localctx).expression = expression();
				 data.addAssumptionExpression(new Expression(((TitleContext)_localctx).expression.op)); 
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(41);
					match(T__1);
					setState(42);
					((TitleContext)_localctx).expression = expression();
					 data.addAssumptionExpression(new Expression(((TitleContext)_localctx).expression.op)); 
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			{
			setState(52);
			match(T__2);
			setState(53);
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
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expression);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				((ExpressionContext)_localctx).dis = dis(0);
				 ((ExpressionContext)_localctx).op =  ((ExpressionContext)_localctx).dis.op; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				((ExpressionContext)_localctx).dis = dis(0);
				setState(60);
				match(T__3);
				setState(61);
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
		public DisContext d;
		public ConContext con;
		public ConContext con() {
			return getRuleContext(ConContext.class,0);
		}
		public DisContext dis() {
			return getRuleContext(DisContext.class,0);
		}
		public DisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterDis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitDis(this);
		}
	}

	public final DisContext dis() throws RecognitionException {
		return dis(0);
	}

	private DisContext dis(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DisContext _localctx = new DisContext(_ctx, _parentState);
		DisContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_dis, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(67);
			((DisContext)_localctx).con = con(0);
			 ((DisContext)_localctx).op =  ((DisContext)_localctx).con.op; 
			}
			_ctx.stop = _input.LT(-1);
			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DisContext(_parentctx, _parentState);
					_localctx.d = _prevctx;
					_localctx.d = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_dis);
					setState(70);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(71);
					match(T__4);
					setState(72);
					((DisContext)_localctx).con = con(0);
					 ((DisContext)_localctx).op =  new Disjunction(((DisContext)_localctx).d.op, ((DisContext)_localctx).con.op); 
					}
					} 
				}
				setState(79);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConContext extends ParserRuleContext {
		public Operation op;
		public ConContext c;
		public NegContext neg;
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public ConContext con() {
			return getRuleContext(ConContext.class,0);
		}
		public ConContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_con; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterCon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitCon(this);
		}
	}

	public final ConContext con() throws RecognitionException {
		return con(0);
	}

	private ConContext con(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConContext _localctx = new ConContext(_ctx, _parentState);
		ConContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_con, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(81);
			((ConContext)_localctx).neg = neg();
			 ((ConContext)_localctx).op =  ((ConContext)_localctx).neg.op; 
			}
			_ctx.stop = _input.LT(-1);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConContext(_parentctx, _parentState);
					_localctx.c = _prevctx;
					_localctx.c = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_con);
					setState(84);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(85);
					match(T__5);
					setState(86);
					((ConContext)_localctx).neg = neg();
					 ((ConContext)_localctx).op =  new Conjunction(((ConContext)_localctx).c.op, ((ConContext)_localctx).neg.op); 
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class NegContext extends ParserRuleContext {
		public Operation op;
		public PredContext pred;
		public NegContext neg;
		public ExpressionContext expression;
		public Token VAR;
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode VAR() { return getToken(PredicateParser.VAR, 0); }
		public NegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitNeg(this);
		}
	}

	public final NegContext neg() throws RecognitionException {
		NegContext _localctx = new NegContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_neg);
		try {
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				((NegContext)_localctx).pred = pred();
				 ((NegContext)_localctx).op =  ((NegContext)_localctx).pred.op; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(T__6);
				setState(98);
				((NegContext)_localctx).neg = neg();
				 ((NegContext)_localctx).op =  new Negation(((NegContext)_localctx).neg.op); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				match(T__7);
				setState(102);
				((NegContext)_localctx).expression = expression();
				setState(103);
				match(T__8);
				 ((NegContext)_localctx).op =  ((NegContext)_localctx).expression.op; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				match(T__9);
				setState(107);
				((NegContext)_localctx).VAR = match(VAR);
				setState(108);
				((NegContext)_localctx).neg = neg();
				 ((NegContext)_localctx).op =  new UniversalQ((((NegContext)_localctx).VAR!=null?((NegContext)_localctx).VAR.getText():null), ((NegContext)_localctx).neg.op); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				match(T__10);
				setState(112);
				((NegContext)_localctx).VAR = match(VAR);
				setState(113);
				((NegContext)_localctx).neg = neg();
				 ((NegContext)_localctx).op =  new ExistenceQ((((NegContext)_localctx).VAR!=null?((NegContext)_localctx).VAR.getText():null), ((NegContext)_localctx).neg.op); 
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

	public static class PredContext extends ParserRuleContext {
		public Operation op;
		public Token PRED;
		public TermContext h;
		public TermContext t;
		public TermContext f;
		public TermContext s;
		public TerminalNode PRED() { return getToken(PredicateParser.PRED, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public PredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterPred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitPred(this);
		}
	}

	public final PredContext pred() throws RecognitionException {
		PredContext _localctx = new PredContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pred);
		int _la;
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRED:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				((PredContext)_localctx).PRED = match(PRED);
				 ((PredContext)_localctx).op =  new Predicate((((PredContext)_localctx).PRED!=null?((PredContext)_localctx).PRED.getText():null)); 
				setState(134);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(120);
					match(T__7);
					setState(121);
					((PredContext)_localctx).h = term(0);
					 _localctx.op.addArgument(((PredContext)_localctx).h.op); 
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(123);
						match(T__1);
						setState(124);
						((PredContext)_localctx).t = term(0);
						 _localctx.op.addArgument(((PredContext)_localctx).t.op); 
						}
						}
						setState(131);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(132);
					match(T__8);
					}
					break;
				}
				}
				break;
			case T__7:
			case T__14:
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				((PredContext)_localctx).f = term(0);
				setState(137);
				match(T__11);
				setState(138);
				((PredContext)_localctx).s = term(0);
				 ((PredContext)_localctx).op =  new Equality(((PredContext)_localctx).f.op, ((PredContext)_localctx).s.op); 
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

	public static class TermContext extends ParserRuleContext {
		public Operation op;
		public TermContext t;
		public AddContext add;
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(144);
			((TermContext)_localctx).add = add(0);
			 ((TermContext)_localctx).op =  ((TermContext)_localctx).add.op; 
			}
			_ctx.stop = _input.LT(-1);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(147);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(148);
					match(T__12);
					setState(149);
					((TermContext)_localctx).add = add(0);
					 ((TermContext)_localctx).op =  new Add(((TermContext)_localctx).t.op, ((TermContext)_localctx).add.op); 
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class AddContext extends ParserRuleContext {
		public Operation op;
		public AddContext a;
		public MulContext mul;
		public MulContext mul() {
			return getRuleContext(MulContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitAdd(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		return add(0);
	}

	private AddContext add(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddContext _localctx = new AddContext(_ctx, _parentState);
		AddContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_add, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(158);
			((AddContext)_localctx).mul = mul(0);
			 ((AddContext)_localctx).op =  ((AddContext)_localctx).mul.op; 
			}
			_ctx.stop = _input.LT(-1);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddContext(_parentctx, _parentState);
					_localctx.a = _prevctx;
					_localctx.a = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_add);
					setState(161);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(162);
					match(T__13);
					setState(163);
					((AddContext)_localctx).mul = mul(0);
					 ((AddContext)_localctx).op =  new Mul(((AddContext)_localctx).a.op, ((AddContext)_localctx).mul.op); 
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class MulContext extends ParserRuleContext {
		public Operation op;
		public MulContext m;
		public Token VAR;
		public TermContext h;
		public TermContext term;
		public TermContext t;
		public TerminalNode VAR() { return getToken(PredicateParser.VAR, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public MulContext mul() {
			return getRuleContext(MulContext.class,0);
		}
		public MulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitMul(this);
		}
	}

	public final MulContext mul() throws RecognitionException {
		return mul(0);
	}

	private MulContext mul(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulContext _localctx = new MulContext(_ctx, _parentState);
		MulContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_mul, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(172);
				((MulContext)_localctx).VAR = match(VAR);
				 ((MulContext)_localctx).op =  new Function((((MulContext)_localctx).VAR!=null?((MulContext)_localctx).VAR.getText():null)); 
				setState(188);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(174);
					match(T__7);
					setState(175);
					((MulContext)_localctx).h = ((MulContext)_localctx).term = term(0);
					 _localctx.op.addArgument(((MulContext)_localctx).h.op); 
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(177);
						match(T__1);
						setState(178);
						((MulContext)_localctx).t = ((MulContext)_localctx).term = term(0);
						 _localctx.op.addArgument(((MulContext)_localctx).t.op); 
						}
						}
						setState(185);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(186);
					match(T__8);
					}
					break;
				}
				}
				break;
			case T__7:
				{
				setState(190);
				match(T__7);
				setState(191);
				((MulContext)_localctx).term = term(0);
				setState(192);
				match(T__8);
				 ((MulContext)_localctx).op =  ((MulContext)_localctx).term.op; 
				}
				break;
			case T__14:
				{
				setState(195);
				match(T__14);
				 ((MulContext)_localctx).op =  new Zero(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulContext(_parentctx, _parentState);
					_localctx.m = _prevctx;
					_localctx.m = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_mul);
					setState(199);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(200);
					match(T__15);
					 ((MulContext)_localctx).op =  new Successor(((MulContext)_localctx).m.op); 
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class NumContext extends ParserRuleContext {
		public int value;
		public Token NUMBER;
		public TerminalNode NUMBER() { return getToken(PredicateParser.NUMBER, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PredicateListener ) ((PredicateListener)listener).exitNum(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			((NumContext)_localctx).NUMBER = match(NUMBER);
			 ((NumContext)_localctx).value =  Integer.parseInt((((NumContext)_localctx).NUMBER!=null?((NumContext)_localctx).NUMBER.getText():null)); 
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
		case 4:
			return dis_sempred((DisContext)_localctx, predIndex);
		case 5:
			return con_sempred((ConContext)_localctx, predIndex);
		case 8:
			return term_sempred((TermContext)_localctx, predIndex);
		case 9:
			return add_sempred((AddContext)_localctx, predIndex);
		case 10:
			return mul_sempred((MulContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean dis_sempred(DisContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean con_sempred(ConContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean add_sempred(AddContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mul_sempred(MulContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u00d5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13\2"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13\4\5"+
		"\4\65\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5C\n\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6N\n\6\f\6\16\6Q\13\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\7\7\\\n\7\f\7\16\7_\13\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"w\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0082\n\t\f\t\16\t\u0085"+
		"\13\t\3\t\3\t\5\t\u0089\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u0090\n\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u009b\n\n\f\n\16\n\u009e\13\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00a9\n\13\f\13\16\13\u00ac"+
		"\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00b8\n\f\f\f\16\f"+
		"\u00bb\13\f\3\f\3\f\5\f\u00bf\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c8"+
		"\n\f\3\f\3\f\3\f\7\f\u00cd\n\f\f\f\16\f\u00d0\13\f\3\r\3\r\3\r\3\r\2\7"+
		"\n\f\22\24\26\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2\u00dc\2\32\3\2\2"+
		"\2\4%\3\2\2\2\6\64\3\2\2\2\bB\3\2\2\2\nD\3\2\2\2\fR\3\2\2\2\16v\3\2\2"+
		"\2\20\u008f\3\2\2\2\22\u0091\3\2\2\2\24\u009f\3\2\2\2\26\u00c7\3\2\2\2"+
		"\30\u00d1\3\2\2\2\32\33\5\6\4\2\33\"\7\3\2\2\34\35\5\b\5\2\35\36\7\3\2"+
		"\2\36\37\b\2\1\2\37!\3\2\2\2 \34\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2"+
		"\2#\3\3\2\2\2$\"\3\2\2\2%&\5\30\r\2&\'\5\30\r\2\'(\b\3\1\2(\5\3\2\2\2"+
		")*\5\b\5\2*\61\b\4\1\2+,\7\4\2\2,-\5\b\5\2-.\b\4\1\2.\60\3\2\2\2/+\3\2"+
		"\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2"+
		"\2\64)\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\7\5\2\2\678\5\b\5\28"+
		"9\b\4\1\29\7\3\2\2\2:;\5\n\6\2;<\b\5\1\2<C\3\2\2\2=>\5\n\6\2>?\7\6\2\2"+
		"?@\5\b\5\2@A\b\5\1\2AC\3\2\2\2B:\3\2\2\2B=\3\2\2\2C\t\3\2\2\2DE\b\6\1"+
		"\2EF\5\f\7\2FG\b\6\1\2GO\3\2\2\2HI\f\3\2\2IJ\7\7\2\2JK\5\f\7\2KL\b\6\1"+
		"\2LN\3\2\2\2MH\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\13\3\2\2\2QO\3\2"+
		"\2\2RS\b\7\1\2ST\5\16\b\2TU\b\7\1\2U]\3\2\2\2VW\f\3\2\2WX\7\b\2\2XY\5"+
		"\16\b\2YZ\b\7\1\2Z\\\3\2\2\2[V\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2"+
		"^\r\3\2\2\2_]\3\2\2\2`a\5\20\t\2ab\b\b\1\2bw\3\2\2\2cd\7\t\2\2de\5\16"+
		"\b\2ef\b\b\1\2fw\3\2\2\2gh\7\n\2\2hi\5\b\5\2ij\7\13\2\2jk\b\b\1\2kw\3"+
		"\2\2\2lm\7\f\2\2mn\7\23\2\2no\5\16\b\2op\b\b\1\2pw\3\2\2\2qr\7\r\2\2r"+
		"s\7\23\2\2st\5\16\b\2tu\b\b\1\2uw\3\2\2\2v`\3\2\2\2vc\3\2\2\2vg\3\2\2"+
		"\2vl\3\2\2\2vq\3\2\2\2w\17\3\2\2\2xy\7\24\2\2y\u0088\b\t\1\2z{\7\n\2\2"+
		"{|\5\22\n\2|\u0083\b\t\1\2}~\7\4\2\2~\177\5\22\n\2\177\u0080\b\t\1\2\u0080"+
		"\u0082\3\2\2\2\u0081}\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087"+
		"\7\13\2\2\u0087\u0089\3\2\2\2\u0088z\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u0090\3\2\2\2\u008a\u008b\5\22\n\2\u008b\u008c\7\16\2\2\u008c\u008d\5"+
		"\22\n\2\u008d\u008e\b\t\1\2\u008e\u0090\3\2\2\2\u008fx\3\2\2\2\u008f\u008a"+
		"\3\2\2\2\u0090\21\3\2\2\2\u0091\u0092\b\n\1\2\u0092\u0093\5\24\13\2\u0093"+
		"\u0094\b\n\1\2\u0094\u009c\3\2\2\2\u0095\u0096\f\3\2\2\u0096\u0097\7\17"+
		"\2\2\u0097\u0098\5\24\13\2\u0098\u0099\b\n\1\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0095\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d\23\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\b\13\1\2\u00a0\u00a1"+
		"\5\26\f\2\u00a1\u00a2\b\13\1\2\u00a2\u00aa\3\2\2\2\u00a3\u00a4\f\3\2\2"+
		"\u00a4\u00a5\7\20\2\2\u00a5\u00a6\5\26\f\2\u00a6\u00a7\b\13\1\2\u00a7"+
		"\u00a9\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00aa\u00ab\3\2\2\2\u00ab\25\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae"+
		"\b\f\1\2\u00ae\u00af\7\23\2\2\u00af\u00be\b\f\1\2\u00b0\u00b1\7\n\2\2"+
		"\u00b1\u00b2\5\22\n\2\u00b2\u00b9\b\f\1\2\u00b3\u00b4\7\4\2\2\u00b4\u00b5"+
		"\5\22\n\2\u00b5\u00b6\b\f\1\2\u00b6\u00b8\3\2\2\2\u00b7\u00b3\3\2\2\2"+
		"\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7\13\2\2\u00bd\u00bf\3\2\2\2"+
		"\u00be\u00b0\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c8\3\2\2\2\u00c0\u00c1"+
		"\7\n\2\2\u00c1\u00c2\5\22\n\2\u00c2\u00c3\7\13\2\2\u00c3\u00c4\b\f\1\2"+
		"\u00c4\u00c8\3\2\2\2\u00c5\u00c6\7\21\2\2\u00c6\u00c8\b\f\1\2\u00c7\u00ad"+
		"\3\2\2\2\u00c7\u00c0\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00ce\3\2\2\2\u00c9"+
		"\u00ca\f\3\2\2\u00ca\u00cb\7\22\2\2\u00cb\u00cd\b\f\1\2\u00cc\u00c9\3"+
		"\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\27\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7\25\2\2\u00d2\u00d3\b\r\1"+
		"\2\u00d3\31\3\2\2\2\22\"\61\64BO]v\u0083\u0088\u008f\u009c\u00aa\u00b9"+
		"\u00be\u00c7\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}