// Generated from /Users/lytr777/IdeaProjects/MATLOG_HW/src/com/lytr777/predicateСalculus/parser/Predicate.g4 by ANTLR 4.7
package com.lytr777.predicateСalculus.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PredicateLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, VAR=17, 
		PRED=18, NUMBER=19, SKP=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "VAR", "PRED", 
		"NUMBER", "SKP"
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


	public PredicateLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Predicate.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26d\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\7\22P\n\22\f\22\16\22S\13"+
		"\22\3\23\3\23\7\23W\n\23\f\23\16\23Z\13\23\3\24\6\24]\n\24\r\24\16\24"+
		"^\3\25\3\25\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2\b\3\2c|\4"+
		"\2\62;c|\3\2C\\\4\2\62;C\\\3\2\62;\5\2\13\13\17\17\"\"\2f\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2\2\2\7/\3\2\2\2\t\62\3\2\2"+
		"\2\13\65\3\2\2\2\r\67\3\2\2\2\179\3\2\2\2\21;\3\2\2\2\23=\3\2\2\2\25?"+
		"\3\2\2\2\27A\3\2\2\2\31C\3\2\2\2\33E\3\2\2\2\35G\3\2\2\2\37I\3\2\2\2!"+
		"K\3\2\2\2#M\3\2\2\2%T\3\2\2\2\'\\\3\2\2\2)`\3\2\2\2+,\7\f\2\2,\4\3\2\2"+
		"\2-.\7.\2\2.\6\3\2\2\2/\60\7~\2\2\60\61\7/\2\2\61\b\3\2\2\2\62\63\7/\2"+
		"\2\63\64\7@\2\2\64\n\3\2\2\2\65\66\7~\2\2\66\f\3\2\2\2\678\7(\2\28\16"+
		"\3\2\2\29:\7#\2\2:\20\3\2\2\2;<\7*\2\2<\22\3\2\2\2=>\7+\2\2>\24\3\2\2"+
		"\2?@\7B\2\2@\26\3\2\2\2AB\7A\2\2B\30\3\2\2\2CD\7?\2\2D\32\3\2\2\2EF\7"+
		"-\2\2F\34\3\2\2\2GH\7,\2\2H\36\3\2\2\2IJ\7\62\2\2J \3\2\2\2KL\7)\2\2L"+
		"\"\3\2\2\2MQ\t\2\2\2NP\t\3\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2"+
		"R$\3\2\2\2SQ\3\2\2\2TX\t\4\2\2UW\t\5\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2"+
		"XY\3\2\2\2Y&\3\2\2\2ZX\3\2\2\2[]\t\6\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2"+
		"\2^_\3\2\2\2_(\3\2\2\2`a\t\7\2\2ab\3\2\2\2bc\b\25\2\2c*\3\2\2\2\6\2QX"+
		"^\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}