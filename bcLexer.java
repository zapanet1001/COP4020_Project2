// Generated from bc.g4 by ANTLR 4.7.2

//package tools;
import java.util.*;
import java.lang.Math;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class bcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, MUL=8, DIV=9, 
		ADD=10, SUB=11, AND=12, OR=13, NOT=14, IF=15, ELSE=16, WHILE=17, VAR=18, 
		ID=19, FLOAT=20, INT=21, NEWLINE=22, WS=23, COMMENT=24, ASSIGN=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "MUL", "DIV", 
			"ADD", "SUB", "AND", "OR", "NOT", "IF", "ELSE", "WHILE", "VAR", "ID", 
			"FLOAT", "INT", "NEWLINE", "WS", "COMMENT", "ASSIGN"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "','", "'read'", "'('", "')'", "'--'", "'++'", "'*'", 
			"'/'", "'+'", "'-'", "'&&'", "'||'", "'!'", "'if'", "'else'", "'while'", 
			"'var'", null, null, null, null, null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "MUL", "DIV", "ADD", 
			"SUB", "AND", "OR", "NOT", "IF", "ELSE", "WHILE", "VAR", "ID", "FLOAT", 
			"INT", "NEWLINE", "WS", "COMMENT", "ASSIGN"
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


	public bcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "bc.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00a9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\6\24"+
		"p\n\24\r\24\16\24q\3\25\6\25u\n\25\r\25\16\25v\3\25\3\25\3\25\3\25\3\25"+
		"\6\25~\n\25\r\25\16\25\177\3\25\6\25\u0083\n\25\r\25\16\25\u0084\5\25"+
		"\u0087\n\25\3\26\6\26\u008a\n\26\r\26\16\26\u008b\3\27\5\27\u008f\n\27"+
		"\3\27\3\27\3\30\6\30\u0094\n\30\r\30\16\30\u0095\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\7\31\u009e\n\31\f\31\16\31\u00a1\13\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\3\u009f\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\3\2\5\4\2C\\c|\3\2\62;\4\2\13\13\"\"\2\u00b2\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\3\65\3\2\2\2\5;\3\2\2\2\7=\3\2\2\2\tB\3\2\2\2\13D\3\2\2\2\rF"+
		"\3\2\2\2\17I\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25P\3\2\2\2\27R\3\2\2\2\31"+
		"T\3\2\2\2\33W\3\2\2\2\35Z\3\2\2\2\37\\\3\2\2\2!_\3\2\2\2#d\3\2\2\2%j\3"+
		"\2\2\2\'o\3\2\2\2)\u0086\3\2\2\2+\u0089\3\2\2\2-\u008e\3\2\2\2/\u0093"+
		"\3\2\2\2\61\u0099\3\2\2\2\63\u00a7\3\2\2\2\65\66\7r\2\2\66\67\7t\2\2\67"+
		"8\7k\2\289\7p\2\29:\7v\2\2:\4\3\2\2\2;<\7.\2\2<\6\3\2\2\2=>\7t\2\2>?\7"+
		"g\2\2?@\7c\2\2@A\7f\2\2A\b\3\2\2\2BC\7*\2\2C\n\3\2\2\2DE\7+\2\2E\f\3\2"+
		"\2\2FG\7/\2\2GH\7/\2\2H\16\3\2\2\2IJ\7-\2\2JK\7-\2\2K\20\3\2\2\2LM\7,"+
		"\2\2M\22\3\2\2\2NO\7\61\2\2O\24\3\2\2\2PQ\7-\2\2Q\26\3\2\2\2RS\7/\2\2"+
		"S\30\3\2\2\2TU\7(\2\2UV\7(\2\2V\32\3\2\2\2WX\7~\2\2XY\7~\2\2Y\34\3\2\2"+
		"\2Z[\7#\2\2[\36\3\2\2\2\\]\7k\2\2]^\7h\2\2^ \3\2\2\2_`\7g\2\2`a\7n\2\2"+
		"ab\7u\2\2bc\7g\2\2c\"\3\2\2\2de\7y\2\2ef\7j\2\2fg\7k\2\2gh\7n\2\2hi\7"+
		"g\2\2i$\3\2\2\2jk\7x\2\2kl\7c\2\2lm\7t\2\2m&\3\2\2\2np\t\2\2\2on\3\2\2"+
		"\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r(\3\2\2\2su\5+\26\2ts\3\2\2\2uv\3\2\2"+
		"\2vt\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7\60\2\2yz\5+\26\2z\u0087\3\2\2\2{"+
		"}\7\60\2\2|~\5+\26\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2"+
		"\2\2\u0080\u0087\3\2\2\2\u0081\u0083\5+\26\2\u0082\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2"+
		"\2\2\u0086t\3\2\2\2\u0086{\3\2\2\2\u0086\u0082\3\2\2\2\u0087*\3\2\2\2"+
		"\u0088\u008a\t\3\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c,\3\2\2\2\u008d\u008f\7\17\2\2\u008e"+
		"\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7\f"+
		"\2\2\u0091.\3\2\2\2\u0092\u0094\t\4\2\2\u0093\u0092\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\b\30\2\2\u0098\60\3\2\2\2\u0099\u009a\7\61\2\2\u009a\u009b\7,\2"+
		"\2\u009b\u009f\3\2\2\2\u009c\u009e\13\2\2\2\u009d\u009c\3\2\2\2\u009e"+
		"\u00a1\3\2\2\2\u009f\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\3\2"+
		"\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7,\2\2\u00a3\u00a4\7\61\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a6\b\31\2\2\u00a6\62\3\2\2\2\u00a7\u00a8\7?\2"+
		"\2\u00a8\64\3\2\2\2\f\2qv\177\u0084\u0086\u008b\u008e\u0095\u009f\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}