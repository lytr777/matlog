// Generated from /Users/lytr777/IdeaProjects/MATLOG_HW/src/com/lytr777/predicateСalculus/parser/Predicate.g4 by ANTLR 4.7
package com.lytr777.predicateСalculus.parser;

import com.lytr777.HW4;
import com.lytr777.propositionalCalculus.operations.*;
import com.lytr777.predicateСalculus.operations.*;
import com.lytr777.predicateСalculus.operations.Predicate;
import com.lytr777.util.Expression;
import com.lytr777.util.InitialData;
import javafx.util.Pair;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

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
    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, VAR = 17,
            PRED = 18, NUMBER = 19, SKP = 20;
    public static final int
            RULE_sequentialFile = 0, RULE_file = 1, RULE_five = 2, RULE_title = 3,
            RULE_expression = 4, RULE_dis = 5, RULE_con = 6, RULE_neg = 7, RULE_pred = 8,
            RULE_term = 9, RULE_add = 10, RULE_mul = 11, RULE_num = 12;
    public static final String[] ruleNames = {
            "sequentialFile", "file", "five", "title", "expression", "dis", "con",
            "neg", "pred", "term", "add", "mul", "num"
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
    public String getGrammarFileName() {
        return "Predicate.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }


    public InitialData data = new InitialData();
    public HW4 hw4;
    public PrintWriter pw;
    public int lines = 0;

    public PredicateParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class SequentialFileContext extends ParserRuleContext {
        public PrintWriter pw;
        public String out;
        public ExpressionContext expression;

        public TitleContext title() {
            return getRuleContext(TitleContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public SequentialFileContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public SequentialFileContext(ParserRuleContext parent, int invokingState, PrintWriter pw, String out) {
            super(parent, invokingState);
            this.pw = pw;
            this.out = out;
        }

        @Override
        public int getRuleIndex() {
            return RULE_sequentialFile;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterSequentialFile(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitSequentialFile(this);
        }
    }

    public final SequentialFileContext sequentialFile(PrintWriter pw, String out) throws RecognitionException {
        SequentialFileContext _localctx = new SequentialFileContext(_ctx, getState(), pw, out);
        enterRule(_localctx, 0, RULE_sequentialFile);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(26);
                title();
                setState(27);
                match(T__0);
                hw4 = new HW4(data, pw);
                hw4.printTitle();
                setState(35);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << VAR) | (1L << PRED))) != 0)) {
                    {
                        {
                            setState(29);
                            ((SequentialFileContext) _localctx).expression = expression();
                            setState(30);
                            match(T__0);
                            data.addProofExpression(new Expression(((SequentialFileContext) _localctx).expression.op));
                            int code = hw4.checkLast();
                            if (code > 0) {
                                pw.flush();
                                pw.close();

                                try {
                                    pw = new PrintWriter(new FileWriter(out));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                pw.println("Вывод некоректен начиная с формулы номер " + code);
                                pw.flush();
                                pw.close();
                                break;
                            }
                        }
                    }
                    setState(37);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FileContext extends ParserRuleContext {
        public ExpressionContext expression;

        public TitleContext title() {
            return getRuleContext(TitleContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public FileContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_file;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterFile(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitFile(this);
        }
    }

    public final FileContext file() throws RecognitionException {
        FileContext _localctx = new FileContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_file);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(38);
                title();
                setState(39);
                match(T__0);
                setState(46);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << VAR) | (1L << PRED))) != 0)) {
                    {
                        {
                            setState(40);
                            ((FileContext) _localctx).expression = expression();
                            setState(41);
                            match(T__0);
                            data.addProofExpression(new Expression(((FileContext) _localctx).expression.op));
                            lines += 1;
                            if (lines % 500 == 0) System.out.println("Прочитано " + lines + " строк");
                        }
                    }
                    setState(48);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
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
            return getRuleContext(NumContext.class, i);
        }

        public FiveContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_five;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterFive(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitFive(this);
        }
    }

    public final FiveContext five() throws RecognitionException {
        FiveContext _localctx = new FiveContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_five);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(49);
                ((FiveContext) _localctx).a = num();
                setState(50);
                ((FiveContext) _localctx).b = num();
                ((FiveContext) _localctx).ab = new Pair<>(((FiveContext) _localctx).a.value, ((FiveContext) _localctx).b.value);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
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
            return getRuleContext(ExpressionContext.class, i);
        }

        public TitleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_title;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterTitle(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitTitle(this);
        }
    }

    public final TitleContext title() throws RecognitionException {
        TitleContext _localctx = new TitleContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_title);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(64);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << VAR) | (1L << PRED))) != 0)) {
                    {
                        setState(53);
                        ((TitleContext) _localctx).expression = expression();
                        data.addAssumptionExpression(new Expression(((TitleContext) _localctx).expression.op));
                        setState(61);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T__1) {
                            {
                                {
                                    setState(55);
                                    match(T__1);
                                    setState(56);
                                    ((TitleContext) _localctx).expression = expression();
                                    data.addAssumptionExpression(new Expression(((TitleContext) _localctx).expression.op));
                                }
                            }
                            setState(63);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                {
                    setState(66);
                    match(T__2);
                    setState(67);
                    ((TitleContext) _localctx).expression = expression();
                    data.setStatement(new Expression(((TitleContext) _localctx).expression.op));
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExpressionContext extends ParserRuleContext {
        public Operation op;
        public DisContext dis;
        public ExpressionContext expression;

        public DisContext dis() {
            return getRuleContext(DisContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitExpression(this);
        }
    }

    public final ExpressionContext expression() throws RecognitionException {
        ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_expression);
        try {
            setState(78);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(70);
                    ((ExpressionContext) _localctx).dis = dis(0);
                    ((ExpressionContext) _localctx).op = ((ExpressionContext) _localctx).dis.op;
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(73);
                    ((ExpressionContext) _localctx).dis = dis(0);
                    setState(74);
                    match(T__3);
                    setState(75);
                    ((ExpressionContext) _localctx).expression = expression();
                    ((ExpressionContext) _localctx).op = new Implication(((ExpressionContext) _localctx).dis.op, ((ExpressionContext) _localctx).expression.op);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DisContext extends ParserRuleContext {
        public Operation op;
        public DisContext d;
        public ConContext con;

        public ConContext con() {
            return getRuleContext(ConContext.class, 0);
        }

        public DisContext dis() {
            return getRuleContext(DisContext.class, 0);
        }

        public DisContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dis;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterDis(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitDis(this);
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
        int _startState = 10;
        enterRecursionRule(_localctx, 10, RULE_dis, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(81);
                    ((DisContext) _localctx).con = con(0);
                    ((DisContext) _localctx).op = ((DisContext) _localctx).con.op;
                }
                _ctx.stop = _input.LT(-1);
                setState(91);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new DisContext(_parentctx, _parentState);
                                _localctx.d = _prevctx;
                                _localctx.d = _prevctx;
                                pushNewRecursionContext(_localctx, _startState, RULE_dis);
                                setState(84);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(85);
                                match(T__4);
                                setState(86);
                                ((DisContext) _localctx).con = con(0);
                                ((DisContext) _localctx).op = new Disjunction(((DisContext) _localctx).d.op, ((DisContext) _localctx).con.op);
                            }
                        }
                    }
                    setState(93);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class ConContext extends ParserRuleContext {
        public Operation op;
        public ConContext c;
        public NegContext neg;

        public NegContext neg() {
            return getRuleContext(NegContext.class, 0);
        }

        public ConContext con() {
            return getRuleContext(ConContext.class, 0);
        }

        public ConContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_con;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterCon(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitCon(this);
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
        int _startState = 12;
        enterRecursionRule(_localctx, 12, RULE_con, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(95);
                    ((ConContext) _localctx).neg = neg();
                    ((ConContext) _localctx).op = ((ConContext) _localctx).neg.op;
                }
                _ctx.stop = _input.LT(-1);
                setState(105);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new ConContext(_parentctx, _parentState);
                                _localctx.c = _prevctx;
                                _localctx.c = _prevctx;
                                pushNewRecursionContext(_localctx, _startState, RULE_con);
                                setState(98);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(99);
                                match(T__5);
                                setState(100);
                                ((ConContext) _localctx).neg = neg();
                                ((ConContext) _localctx).op = new Conjunction(((ConContext) _localctx).c.op, ((ConContext) _localctx).neg.op);
                            }
                        }
                    }
                    setState(107);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
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
            return getRuleContext(PredContext.class, 0);
        }

        public NegContext neg() {
            return getRuleContext(NegContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode VAR() {
            return getToken(PredicateParser.VAR, 0);
        }

        public NegContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_neg;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterNeg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitNeg(this);
        }
    }

    public final NegContext neg() throws RecognitionException {
        NegContext _localctx = new NegContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_neg);
        try {
            setState(130);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(108);
                    ((NegContext) _localctx).pred = pred();
                    ((NegContext) _localctx).op = ((NegContext) _localctx).pred.op;
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(111);
                    match(T__6);
                    setState(112);
                    ((NegContext) _localctx).neg = neg();
                    ((NegContext) _localctx).op = new Negation(((NegContext) _localctx).neg.op);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(115);
                    match(T__7);
                    setState(116);
                    ((NegContext) _localctx).expression = expression();
                    setState(117);
                    match(T__8);
                    ((NegContext) _localctx).op = ((NegContext) _localctx).expression.op;
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(120);
                    match(T__9);
                    setState(121);
                    ((NegContext) _localctx).VAR = match(VAR);
                    setState(122);
                    ((NegContext) _localctx).neg = neg();
                    ((NegContext) _localctx).op = new UniversalQ((((NegContext) _localctx).VAR != null ? ((NegContext) _localctx).VAR.getText() : null), ((NegContext) _localctx).neg.op);
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(125);
                    match(T__10);
                    setState(126);
                    ((NegContext) _localctx).VAR = match(VAR);
                    setState(127);
                    ((NegContext) _localctx).neg = neg();
                    ((NegContext) _localctx).op = new ExistenceQ((((NegContext) _localctx).VAR != null ? ((NegContext) _localctx).VAR.getText() : null), ((NegContext) _localctx).neg.op);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
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

        public TerminalNode PRED() {
            return getToken(PredicateParser.PRED, 0);
        }

        public List<TermContext> term() {
            return getRuleContexts(TermContext.class);
        }

        public TermContext term(int i) {
            return getRuleContext(TermContext.class, i);
        }

        public PredContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pred;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterPred(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitPred(this);
        }
    }

    public final PredContext pred() throws RecognitionException {
        PredContext _localctx = new PredContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_pred);
        int _la;
        try {
            setState(155);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case PRED:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(132);
                    ((PredContext) _localctx).PRED = match(PRED);
                    ((PredContext) _localctx).op = new Predicate((((PredContext) _localctx).PRED != null ? ((PredContext) _localctx).PRED.getText() : null));
                    setState(148);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 9, _ctx)) {
                        case 1: {
                            setState(134);
                            match(T__7);
                            setState(135);
                            ((PredContext) _localctx).h = term(0);
                            _localctx.op.addArgument(((PredContext) _localctx).h.op);
                            setState(143);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T__1) {
                                {
                                    {
                                        setState(137);
                                        match(T__1);
                                        setState(138);
                                        ((PredContext) _localctx).t = term(0);
                                        _localctx.op.addArgument(((PredContext) _localctx).t.op);
                                    }
                                }
                                setState(145);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                            setState(146);
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
                    setState(150);
                    ((PredContext) _localctx).f = term(0);
                    setState(151);
                    match(T__11);
                    setState(152);
                    ((PredContext) _localctx).s = term(0);
                    ((PredContext) _localctx).op = new Equality(((PredContext) _localctx).f.op, ((PredContext) _localctx).s.op);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TermContext extends ParserRuleContext {
        public Operation op;
        public TermContext t;
        public AddContext add;

        public AddContext add() {
            return getRuleContext(AddContext.class, 0);
        }

        public TermContext term() {
            return getRuleContext(TermContext.class, 0);
        }

        public TermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_term;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitTerm(this);
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
        int _startState = 18;
        enterRecursionRule(_localctx, 18, RULE_term, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(158);
                    ((TermContext) _localctx).add = add(0);
                    ((TermContext) _localctx).op = ((TermContext) _localctx).add.op;
                }
                _ctx.stop = _input.LT(-1);
                setState(168);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 11, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new TermContext(_parentctx, _parentState);
                                _localctx.t = _prevctx;
                                _localctx.t = _prevctx;
                                pushNewRecursionContext(_localctx, _startState, RULE_term);
                                setState(161);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(162);
                                match(T__12);
                                setState(163);
                                ((TermContext) _localctx).add = add(0);
                                ((TermContext) _localctx).op = new Add(((TermContext) _localctx).t.op, ((TermContext) _localctx).add.op);
                            }
                        }
                    }
                    setState(170);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 11, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class AddContext extends ParserRuleContext {
        public Operation op;
        public AddContext a;
        public MulContext mul;

        public MulContext mul() {
            return getRuleContext(MulContext.class, 0);
        }

        public AddContext add() {
            return getRuleContext(AddContext.class, 0);
        }

        public AddContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_add;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterAdd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitAdd(this);
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
        int _startState = 20;
        enterRecursionRule(_localctx, 20, RULE_add, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(172);
                    ((AddContext) _localctx).mul = mul(0);
                    ((AddContext) _localctx).op = ((AddContext) _localctx).mul.op;
                }
                _ctx.stop = _input.LT(-1);
                setState(182);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new AddContext(_parentctx, _parentState);
                                _localctx.a = _prevctx;
                                _localctx.a = _prevctx;
                                pushNewRecursionContext(_localctx, _startState, RULE_add);
                                setState(175);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(176);
                                match(T__13);
                                setState(177);
                                ((AddContext) _localctx).mul = mul(0);
                                ((AddContext) _localctx).op = new Mul(((AddContext) _localctx).a.op, ((AddContext) _localctx).mul.op);
                            }
                        }
                    }
                    setState(184);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
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

        public TerminalNode VAR() {
            return getToken(PredicateParser.VAR, 0);
        }

        public List<TermContext> term() {
            return getRuleContexts(TermContext.class);
        }

        public TermContext term(int i) {
            return getRuleContext(TermContext.class, i);
        }

        public MulContext mul() {
            return getRuleContext(MulContext.class, 0);
        }

        public MulContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mul;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterMul(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitMul(this);
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
        int _startState = 22;
        enterRecursionRule(_localctx, 22, RULE_mul, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(211);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case VAR: {
                        setState(186);
                        ((MulContext) _localctx).VAR = match(VAR);
                        ((MulContext) _localctx).op = new Function((((MulContext) _localctx).VAR != null ? ((MulContext) _localctx).VAR.getText() : null));
                        setState(202);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 14, _ctx)) {
                            case 1: {
                                setState(188);
                                match(T__7);
                                setState(189);
                                ((MulContext) _localctx).h = ((MulContext) _localctx).term = term(0);
                                _localctx.op.addArgument(((MulContext) _localctx).h.op);
                                setState(197);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                while (_la == T__1) {
                                    {
                                        {
                                            setState(191);
                                            match(T__1);
                                            setState(192);
                                            ((MulContext) _localctx).t = ((MulContext) _localctx).term = term(0);
                                            _localctx.op.addArgument(((MulContext) _localctx).t.op);
                                        }
                                    }
                                    setState(199);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                }
                                setState(200);
                                match(T__8);
                            }
                            break;
                        }
                    }
                    break;
                    case T__7: {
                        setState(204);
                        match(T__7);
                        setState(205);
                        ((MulContext) _localctx).term = term(0);
                        setState(206);
                        match(T__8);
                        ((MulContext) _localctx).op = ((MulContext) _localctx).term.op;
                    }
                    break;
                    case T__14: {
                        setState(209);
                        match(T__14);
                        ((MulContext) _localctx).op = new Zero();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(218);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 16, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new MulContext(_parentctx, _parentState);
                                _localctx.m = _prevctx;
                                _localctx.m = _prevctx;
                                pushNewRecursionContext(_localctx, _startState, RULE_mul);
                                setState(213);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(214);
                                match(T__15);
                                ((MulContext) _localctx).op = new Successor(((MulContext) _localctx).m.op);
                            }
                        }
                    }
                    setState(220);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 16, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class NumContext extends ParserRuleContext {
        public int value;
        public Token NUMBER;

        public TerminalNode NUMBER() {
            return getToken(PredicateParser.NUMBER, 0);
        }

        public NumContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_num;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).enterNum(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PredicateListener) ((PredicateListener) listener).exitNum(this);
        }
    }

    public final NumContext num() throws RecognitionException {
        NumContext _localctx = new NumContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_num);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(221);
                ((NumContext) _localctx).NUMBER = match(NUMBER);
                ((NumContext) _localctx).value = Integer.parseInt((((NumContext) _localctx).NUMBER != null ? ((NumContext) _localctx).NUMBER.getText() : null));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 5:
                return dis_sempred((DisContext) _localctx, predIndex);
            case 6:
                return con_sempred((ConContext) _localctx, predIndex);
            case 9:
                return term_sempred((TermContext) _localctx, predIndex);
            case 10:
                return add_sempred((AddContext) _localctx, predIndex);
            case 11:
                return mul_sempred((MulContext) _localctx, predIndex);
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u00e3\4\2\t\2" +
                    "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2$\n\2\f" +
                    "\2\16\2\'\13\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\3\4\3" +
                    "\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5>\n\5\f\5\16\5A\13\5\5\5C\n\5\3" +
                    "\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6Q\n\6\3\7\3\7\3\7\3" +
                    "\7\3\7\3\7\3\7\3\7\3\7\7\7\\\n\7\f\7\16\7_\13\7\3\b\3\b\3\b\3\b\3\b\3" +
                    "\b\3\b\3\b\3\b\7\bj\n\b\f\b\16\bm\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t" +
                    "\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0085\n\t" +
                    "\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0090\n\n\f\n\16\n\u0093\13\n" +
                    "\3\n\3\n\5\n\u0097\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u009e\n\n\3\13\3\13\3\13" +
                    "\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00a9\n\13\f\13\16\13\u00ac\13\13" +
                    "\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00b7\n\f\f\f\16\f\u00ba\13\f" +
                    "\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00c6\n\r\f\r\16\r\u00c9" +
                    "\13\r\3\r\3\r\5\r\u00cd\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d6\n\r" +
                    "\3\r\3\r\3\r\7\r\u00db\n\r\f\r\16\r\u00de\13\r\3\16\3\16\3\16\3\16\2\7" +
                    "\f\16\24\26\30\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\2\2\u00ea\2\34\3" +
                    "\2\2\2\4(\3\2\2\2\6\63\3\2\2\2\bB\3\2\2\2\nP\3\2\2\2\fR\3\2\2\2\16`\3" +
                    "\2\2\2\20\u0084\3\2\2\2\22\u009d\3\2\2\2\24\u009f\3\2\2\2\26\u00ad\3\2" +
                    "\2\2\30\u00d5\3\2\2\2\32\u00df\3\2\2\2\34\35\5\b\5\2\35\36\7\3\2\2\36" +
                    "%\b\2\1\2\37 \5\n\6\2 !\7\3\2\2!\"\b\2\1\2\"$\3\2\2\2#\37\3\2\2\2$\'\3" +
                    "\2\2\2%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'%\3\2\2\2()\5\b\5\2)\60\7\3\2\2" +
                    "*+\5\n\6\2+,\7\3\2\2,-\b\3\1\2-/\3\2\2\2.*\3\2\2\2/\62\3\2\2\2\60.\3\2" +
                    "\2\2\60\61\3\2\2\2\61\5\3\2\2\2\62\60\3\2\2\2\63\64\5\32\16\2\64\65\5" +
                    "\32\16\2\65\66\b\4\1\2\66\7\3\2\2\2\678\5\n\6\28?\b\5\1\29:\7\4\2\2:;" +
                    "\5\n\6\2;<\b\5\1\2<>\3\2\2\2=9\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@" +
                    "C\3\2\2\2A?\3\2\2\2B\67\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\7\5\2\2EF\5\n\6" +
                    "\2FG\b\5\1\2G\t\3\2\2\2HI\5\f\7\2IJ\b\6\1\2JQ\3\2\2\2KL\5\f\7\2LM\7\6" +
                    "\2\2MN\5\n\6\2NO\b\6\1\2OQ\3\2\2\2PH\3\2\2\2PK\3\2\2\2Q\13\3\2\2\2RS\b" +
                    "\7\1\2ST\5\16\b\2TU\b\7\1\2U]\3\2\2\2VW\f\3\2\2WX\7\7\2\2XY\5\16\b\2Y" +
                    "Z\b\7\1\2Z\\\3\2\2\2[V\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\r\3\2\2" +
                    "\2_]\3\2\2\2`a\b\b\1\2ab\5\20\t\2bc\b\b\1\2ck\3\2\2\2de\f\3\2\2ef\7\b" +
                    "\2\2fg\5\20\t\2gh\b\b\1\2hj\3\2\2\2id\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3" +
                    "\2\2\2l\17\3\2\2\2mk\3\2\2\2no\5\22\n\2op\b\t\1\2p\u0085\3\2\2\2qr\7\t" +
                    "\2\2rs\5\20\t\2st\b\t\1\2t\u0085\3\2\2\2uv\7\n\2\2vw\5\n\6\2wx\7\13\2" +
                    "\2xy\b\t\1\2y\u0085\3\2\2\2z{\7\f\2\2{|\7\23\2\2|}\5\20\t\2}~\b\t\1\2" +
                    "~\u0085\3\2\2\2\177\u0080\7\r\2\2\u0080\u0081\7\23\2\2\u0081\u0082\5\20" +
                    "\t\2\u0082\u0083\b\t\1\2\u0083\u0085\3\2\2\2\u0084n\3\2\2\2\u0084q\3\2" +
                    "\2\2\u0084u\3\2\2\2\u0084z\3\2\2\2\u0084\177\3\2\2\2\u0085\21\3\2\2\2" +
                    "\u0086\u0087\7\24\2\2\u0087\u0096\b\n\1\2\u0088\u0089\7\n\2\2\u0089\u008a" +
                    "\5\24\13\2\u008a\u0091\b\n\1\2\u008b\u008c\7\4\2\2\u008c\u008d\5\24\13" +
                    "\2\u008d\u008e\b\n\1\2\u008e\u0090\3\2\2\2\u008f\u008b\3\2\2\2\u0090\u0093" +
                    "\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093" +
                    "\u0091\3\2\2\2\u0094\u0095\7\13\2\2\u0095\u0097\3\2\2\2\u0096\u0088\3" +
                    "\2\2\2\u0096\u0097\3\2\2\2\u0097\u009e\3\2\2\2\u0098\u0099\5\24\13\2\u0099" +
                    "\u009a\7\16\2\2\u009a\u009b\5\24\13\2\u009b\u009c\b\n\1\2\u009c\u009e" +
                    "\3\2\2\2\u009d\u0086\3\2\2\2\u009d\u0098\3\2\2\2\u009e\23\3\2\2\2\u009f" +
                    "\u00a0\b\13\1\2\u00a0\u00a1\5\26\f\2\u00a1\u00a2\b\13\1\2\u00a2\u00aa" +
                    "\3\2\2\2\u00a3\u00a4\f\3\2\2\u00a4\u00a5\7\17\2\2\u00a5\u00a6\5\26\f\2" +
                    "\u00a6\u00a7\b\13\1\2\u00a7\u00a9\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a9\u00ac" +
                    "\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\25\3\2\2\2\u00ac" +
                    "\u00aa\3\2\2\2\u00ad\u00ae\b\f\1\2\u00ae\u00af\5\30\r\2\u00af\u00b0\b" +
                    "\f\1\2\u00b0\u00b8\3\2\2\2\u00b1\u00b2\f\3\2\2\u00b2\u00b3\7\20\2\2\u00b3" +
                    "\u00b4\5\30\r\2\u00b4\u00b5\b\f\1\2\u00b5\u00b7\3\2\2\2\u00b6\u00b1\3" +
                    "\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9" +
                    "\27\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\b\r\1\2\u00bc\u00bd\7\23\2" +
                    "\2\u00bd\u00cc\b\r\1\2\u00be\u00bf\7\n\2\2\u00bf\u00c0\5\24\13\2\u00c0" +
                    "\u00c7\b\r\1\2\u00c1\u00c2\7\4\2\2\u00c2\u00c3\5\24\13\2\u00c3\u00c4\b" +
                    "\r\1\2\u00c4\u00c6\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7" +
                    "\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2" +
                    "\2\2\u00ca\u00cb\7\13\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00be\3\2\2\2\u00cc" +
                    "\u00cd\3\2\2\2\u00cd\u00d6\3\2\2\2\u00ce\u00cf\7\n\2\2\u00cf\u00d0\5\24" +
                    "\13\2\u00d0\u00d1\7\13\2\2\u00d1\u00d2\b\r\1\2\u00d2\u00d6\3\2\2\2\u00d3" +
                    "\u00d4\7\21\2\2\u00d4\u00d6\b\r\1\2\u00d5\u00bb\3\2\2\2\u00d5\u00ce\3" +
                    "\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00dc\3\2\2\2\u00d7\u00d8\f\3\2\2\u00d8" +
                    "\u00d9\7\22\2\2\u00d9\u00db\b\r\1\2\u00da\u00d7\3\2\2\2\u00db\u00de\3" +
                    "\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\31\3\2\2\2\u00de" +
                    "\u00dc\3\2\2\2\u00df\u00e0\7\25\2\2\u00e0\u00e1\b\16\1\2\u00e1\33\3\2" +
                    "\2\2\23%\60?BP]k\u0084\u0091\u0096\u009d\u00aa\u00b8\u00c7\u00cc\u00d5" +
                    "\u00dc";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}