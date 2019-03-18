// Generated from bc.g4 by ANTLR 4.7.2

//package tools;
import java.util.*;
import java.lang.Math;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class bcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, MUL=8, DIV=9, 
		ADD=10, SUB=11, AND=12, OR=13, NOT=14, IF=15, ELSE=16, WHILE=17, VAR=18, 
		ID=19, FLOAT=20, INT=21, NEWLINE=22, WS=23, COMMENT=24, ASSIGN=25;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_print = 2, RULE_function = 3, RULE_mixedexpr = 4, 
		RULE_boolexpr = 5, RULE_stdexpr = 6, RULE_e = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "print", "function", "mixedexpr", "boolexpr", "stdexpr", 
			"e"
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

	@Override
	public String getGrammarFileName() { return "bc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    /** "memory" for our calculator; variable/value pairs go here */
	    Map<String, Float> memory = new HashMap<String, Float>();
	    Scanner reader = new Scanner(System.in);
	    float eval(float l, int op, float r) {
	        
	        switch ( op ) {
	            case MUL : return l * r;
	            case DIV : return l / r;
	            case ADD : return l + r;
	            case SUB : return l - r;
	        }
	        return 0;
	    }

	    float getFloatValue(String f){
	        return Float.parseFloat(f);
	    }

	    float solveFunction(String func, float val){
	        switch(func){
	            case "sqrt": return (float)Math.sqrt(val);
	            case "s": return (float)Math.sin(val);
	            case "c": return (float)Math.cos(val);
	            case "l": return (float)Math.log(val);
	            case "e": return (float)Math.exp(val);
	        }
	        return 0;
	    }

	    int evalBool(float left, String op, float right) {
	        if(op.equals("&&")){
	            if(left!=0 && right!=0) {return 1;}
	        }
	        else if (op.equals("||")){
	            if(left!=0 || right!=0) {return 1;}
	        }
	        return 0;
	    }
	    int evalBool(float left, String op, int right) {
	        if(op.equals("&&")){
	            if(left!=0 && right!=0) {return 1;}
	        }
	        else if (op.equals("||")){
	            if(left!=0 || right!=0) {return 1;}
	        }
	        return 0;
	    }
	    int evalBool(int left, String op, float right) {
	        if(op.equals("&&")){
	            if(left!=0 && right!=0) {return 1;}
	        }
	        else if (op.equals("||")){
	            if(left!=0 || right!=0) {return 1;}
	        }
	        return 0;
	    }
	    int evalBool(int left, String op, int right) {
	        if(op.equals("&&")){
	            if(left!=0 && right!=0) {return 1;}
	        }
	        else if (op.equals("||")){
	            if(left!=0 || right!=0) {return 1;}
	        }
	        return 0;
	    }

	    int negation(String op, float val){
	        if(op.equals("!") && val==0){
	            return 1;
	        }
	        return 0;
	    }
	    int negation(String op, int val){
	        if(op.equals("!") && val==0){
	            return 1;
	        }
	        return 0;
	    }
	    float decrement(String s){
	        if(memory.containsKey(s)){
	            memory.put(s, memory.get(s) - 1); 
	            return memory.get(s);
	        }
	        return 0;
	    }

	    float decrement_post(String s){
	        float r;
	        if(memory.containsKey(s)){
	            r = memory.get(s);
	            memory.put(s, memory.get(s) - 1); 
	            return r;
	        }
	        return 0;
	    }

	    float increment(String s){
	        if(memory.containsKey(s)){
	            memory.put(s, memory.get(s) + 1); 
	            return memory.get(s);
	        }
	        return 0;
	    }    
	    float increment_post(String s){
	        float r;
	        if(memory.containsKey(s)){
	            r = memory.get(s);
	            memory.put(s, memory.get(s) + 1); 
	            return r;
	        }
	        return 0;
	    }

	public bcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bcVisitor ) return ((bcVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				stat();
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << NOT) | (1L << ID) | (1L << FLOAT) | (1L << NEWLINE))) != 0) );
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

	public static class StatContext extends ParserRuleContext {
		public EContext e;
		public BoolexprContext boolexpr;
		public FunctionContext function;
		public MixedexprContext mixedexpr;
		public StdexprContext stdexpr;
		public Token ID;
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(bcParser.NEWLINE, 0); }
		public BoolexprContext boolexpr() {
			return getRuleContext(BoolexprContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public MixedexprContext mixedexpr() {
			return getRuleContext(MixedexprContext.class,0);
		}
		public StdexprContext stdexpr() {
			return getRuleContext(StdexprContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public TerminalNode ID() { return getToken(bcParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(bcParser.ASSIGN, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bcVisitor ) return ((bcVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				((StatContext)_localctx).e = e(0);
				setState(22);
				match(NEWLINE);
				System.out.println(((StatContext)_localctx).e.v);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				((StatContext)_localctx).boolexpr = boolexpr(0);
				setState(26);
				match(NEWLINE);
				System.out.println(((StatContext)_localctx).boolexpr.i);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				((StatContext)_localctx).function = function(0);
				setState(30);
				match(NEWLINE);
				System.out.println(((StatContext)_localctx).function.f);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				((StatContext)_localctx).mixedexpr = mixedexpr();
				setState(34);
				match(NEWLINE);
				System.out.println(((StatContext)_localctx).mixedexpr.m);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(37);
				((StatContext)_localctx).stdexpr = stdexpr();
				setState(38);
				match(NEWLINE);
				System.out.println(((StatContext)_localctx).stdexpr.s);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				print();
				setState(42);
				match(NEWLINE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(44);
				((StatContext)_localctx).ID = match(ID);
				setState(45);
				match(ASSIGN);
				setState(46);
				((StatContext)_localctx).function = function(0);
				setState(47);
				match(NEWLINE);
				memory.put((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null), ((StatContext)_localctx).function.f);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(50);
				((StatContext)_localctx).ID = match(ID);
				setState(51);
				match(ASSIGN);
				setState(52);
				((StatContext)_localctx).e = e(0);
				setState(53);
				match(NEWLINE);
				memory.put((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null), ((StatContext)_localctx).e.v);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(56);
				((StatContext)_localctx).ID = match(ID);
				setState(57);
				match(ASSIGN);
				setState(58);
				((StatContext)_localctx).boolexpr = boolexpr(0);
				setState(59);
				match(NEWLINE);
				memory.put((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null), (float)((StatContext)_localctx).boolexpr.i);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(62);
				((StatContext)_localctx).ID = match(ID);
				setState(63);
				match(ASSIGN);
				setState(64);
				((StatContext)_localctx).mixedexpr = mixedexpr();
				setState(65);
				match(NEWLINE);
				memory.put((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null), (float)((StatContext)_localctx).mixedexpr.m);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(68);
				((StatContext)_localctx).ID = match(ID);
				setState(69);
				match(ASSIGN);
				setState(70);
				((StatContext)_localctx).stdexpr = stdexpr();
				setState(71);
				match(NEWLINE);
				memory.put((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null), ((StatContext)_localctx).stdexpr.s);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(74);
				match(NEWLINE);
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

	public static class PrintContext extends ParserRuleContext {
		public EContext e;
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bcVisitor ) return ((bcVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__0);
			setState(78);
			((PrintContext)_localctx).e = e(0);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(79);
				match(T__1);
				setState(80);
				((PrintContext)_localctx).e = e(0);
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println(((PrintContext)_localctx).e.v);
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

	public static class FunctionContext extends ParserRuleContext {
		public float f;
		public FunctionContext x;
		public Token ID;
		public EContext a;
		public FunctionContext function;
		public Token op;
		public FunctionContext y;
		public TerminalNode ID() { return getToken(bcParser.ID, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(bcParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(bcParser.SUB, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bcVisitor ) return ((bcVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		return function(0);
	}

	private FunctionContext function(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FunctionContext _localctx = new FunctionContext(_ctx, _parentState);
		FunctionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_function, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(89);
				match(T__2);
				setState(90);
				match(T__3);
				setState(91);
				match(T__4);
				((FunctionContext)_localctx).f =  reader.nextFloat();
				}
				break;
			case ID:
				{
				setState(93);
				((FunctionContext)_localctx).ID = match(ID);
				setState(94);
				match(T__3);
				setState(95);
				((FunctionContext)_localctx).a = e(0);
				setState(96);
				match(T__4);
				((FunctionContext)_localctx).f =  solveFunction((((FunctionContext)_localctx).ID!=null?((FunctionContext)_localctx).ID.getText():null), ((FunctionContext)_localctx).a.v);
				}
				break;
			case T__3:
				{
				setState(99);
				match(T__3);
				setState(100);
				((FunctionContext)_localctx).function = function(0);
				setState(101);
				match(T__4);
				((FunctionContext)_localctx).f =  ((FunctionContext)_localctx).function.f;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(116);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new FunctionContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_function);
						setState(106);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(107);
						((FunctionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((FunctionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(108);
						((FunctionContext)_localctx).y = ((FunctionContext)_localctx).function = function(4);
						((FunctionContext)_localctx).f =  eval(((FunctionContext)_localctx).x.f, (((FunctionContext)_localctx).op!=null?((FunctionContext)_localctx).op.getType():0), ((FunctionContext)_localctx).y.f);
						}
						break;
					case 2:
						{
						_localctx = new FunctionContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_function);
						setState(111);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(112);
						((FunctionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((FunctionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(113);
						((FunctionContext)_localctx).y = ((FunctionContext)_localctx).function = function(3);
						((FunctionContext)_localctx).f =  eval(((FunctionContext)_localctx).x.f, (((FunctionContext)_localctx).op!=null?((FunctionContext)_localctx).op.getType():0), ((FunctionContext)_localctx).y.f);
						}
						break;
					}
					} 
				}
				setState(120);
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

	public static class MixedexprContext extends ParserRuleContext {
		public float m;
		public EContext a;
		public Token op;
		public BoolexprContext b;
		public BoolexprContext c;
		public MixedexprContext mixedexpr;
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public List<BoolexprContext> boolexpr() {
			return getRuleContexts(BoolexprContext.class);
		}
		public BoolexprContext boolexpr(int i) {
			return getRuleContext(BoolexprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(bcParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(bcParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(bcParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(bcParser.SUB, 0); }
		public TerminalNode AND() { return getToken(bcParser.AND, 0); }
		public TerminalNode OR() { return getToken(bcParser.OR, 0); }
		public MixedexprContext mixedexpr() {
			return getRuleContext(MixedexprContext.class,0);
		}
		public MixedexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mixedexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).enterMixedexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).exitMixedexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bcVisitor ) return ((bcVisitor<? extends T>)visitor).visitMixedexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MixedexprContext mixedexpr() throws RecognitionException {
		MixedexprContext _localctx = new MixedexprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mixedexpr);
		int _la;
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				((MixedexprContext)_localctx).a = e(0);
				setState(122);
				((MixedexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
					((MixedexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(123);
				((MixedexprContext)_localctx).b = boolexpr(0);
				((MixedexprContext)_localctx).m =  eval(((MixedexprContext)_localctx).a.v, (((MixedexprContext)_localctx).op!=null?((MixedexprContext)_localctx).op.getType():0), (float)((MixedexprContext)_localctx).b.i);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				((MixedexprContext)_localctx).b = boolexpr(0);
				setState(127);
				((MixedexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
					((MixedexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(128);
				((MixedexprContext)_localctx).a = e(0);
				((MixedexprContext)_localctx).m =  eval((float)((MixedexprContext)_localctx).b.i, (((MixedexprContext)_localctx).op!=null?((MixedexprContext)_localctx).op.getType():0), ((MixedexprContext)_localctx).a.v);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				((MixedexprContext)_localctx).a = e(0);
				setState(132);
				((MixedexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((MixedexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(133);
				((MixedexprContext)_localctx).b = boolexpr(0);
				((MixedexprContext)_localctx).m =  eval(((MixedexprContext)_localctx).a.v, (((MixedexprContext)_localctx).op!=null?((MixedexprContext)_localctx).op.getType():0), (float)((MixedexprContext)_localctx).b.i);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				((MixedexprContext)_localctx).b = boolexpr(0);
				setState(137);
				((MixedexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((MixedexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(138);
				((MixedexprContext)_localctx).a = e(0);
				((MixedexprContext)_localctx).m =  eval((float)((MixedexprContext)_localctx).b.i, (((MixedexprContext)_localctx).op!=null?((MixedexprContext)_localctx).op.getType():0), ((MixedexprContext)_localctx).a.v);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(141);
				((MixedexprContext)_localctx).b = boolexpr(0);
				setState(142);
				((MixedexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
					((MixedexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(143);
				((MixedexprContext)_localctx).c = boolexpr(0);
				((MixedexprContext)_localctx).m =  eval((float)((MixedexprContext)_localctx).b.i, (((MixedexprContext)_localctx).op!=null?((MixedexprContext)_localctx).op.getType():0), (float)((MixedexprContext)_localctx).c.i);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(146);
				((MixedexprContext)_localctx).b = boolexpr(0);
				setState(147);
				((MixedexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((MixedexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(148);
				((MixedexprContext)_localctx).c = boolexpr(0);
				((MixedexprContext)_localctx).m =  eval((float)((MixedexprContext)_localctx).b.i, (((MixedexprContext)_localctx).op!=null?((MixedexprContext)_localctx).op.getType():0), (float)((MixedexprContext)_localctx).c.i);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(151);
				((MixedexprContext)_localctx).a = e(0);
				setState(152);
				((MixedexprContext)_localctx).op = match(AND);
				setState(153);
				((MixedexprContext)_localctx).b = boolexpr(0);
				((MixedexprContext)_localctx).m =  evalBool(((MixedexprContext)_localctx).a.v, (((MixedexprContext)_localctx).op!=null?((MixedexprContext)_localctx).op.getText():null), (float)((MixedexprContext)_localctx).b.i);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(156);
				((MixedexprContext)_localctx).b = boolexpr(0);
				setState(157);
				((MixedexprContext)_localctx).op = match(AND);
				setState(158);
				((MixedexprContext)_localctx).a = e(0);
				((MixedexprContext)_localctx).m =  evalBool((float)((MixedexprContext)_localctx).b.i, (((MixedexprContext)_localctx).op!=null?((MixedexprContext)_localctx).op.getText():null), ((MixedexprContext)_localctx).a.v);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(161);
				((MixedexprContext)_localctx).a = e(0);
				setState(162);
				((MixedexprContext)_localctx).op = match(OR);
				setState(163);
				((MixedexprContext)_localctx).b = boolexpr(0);
				((MixedexprContext)_localctx).m =  evalBool(((MixedexprContext)_localctx).a.v, (((MixedexprContext)_localctx).op!=null?((MixedexprContext)_localctx).op.getText():null), (float)((MixedexprContext)_localctx).b.i);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(166);
				((MixedexprContext)_localctx).b = boolexpr(0);
				setState(167);
				((MixedexprContext)_localctx).op = match(OR);
				setState(168);
				((MixedexprContext)_localctx).a = e(0);
				((MixedexprContext)_localctx).m =  evalBool((float)((MixedexprContext)_localctx).b.i, (((MixedexprContext)_localctx).op!=null?((MixedexprContext)_localctx).op.getText():null), ((MixedexprContext)_localctx).a.v);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(171);
				match(T__3);
				setState(172);
				((MixedexprContext)_localctx).mixedexpr = mixedexpr();
				setState(173);
				match(T__4);
				((MixedexprContext)_localctx).m =  ((MixedexprContext)_localctx).mixedexpr.m;
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

	public static class BoolexprContext extends ParserRuleContext {
		public int i;
		public BoolexprContext x;
		public Token op;
		public BoolexprContext boolexpr;
		public EContext a;
		public EContext b;
		public BoolexprContext y;
		public TerminalNode NOT() { return getToken(bcParser.NOT, 0); }
		public List<BoolexprContext> boolexpr() {
			return getRuleContexts(BoolexprContext.class);
		}
		public BoolexprContext boolexpr(int i) {
			return getRuleContext(BoolexprContext.class,i);
		}
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public TerminalNode AND() { return getToken(bcParser.AND, 0); }
		public TerminalNode OR() { return getToken(bcParser.OR, 0); }
		public BoolexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).enterBoolexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).exitBoolexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bcVisitor ) return ((bcVisitor<? extends T>)visitor).visitBoolexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolexprContext boolexpr() throws RecognitionException {
		return boolexpr(0);
	}

	private BoolexprContext boolexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolexprContext _localctx = new BoolexprContext(_ctx, _parentState);
		BoolexprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_boolexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(179);
				((BoolexprContext)_localctx).op = match(NOT);
				setState(180);
				((BoolexprContext)_localctx).x = ((BoolexprContext)_localctx).boolexpr = boolexpr(5);
				((BoolexprContext)_localctx).i =  negation((((BoolexprContext)_localctx).op!=null?((BoolexprContext)_localctx).op.getText():null), ((BoolexprContext)_localctx).x.i);
				}
				break;
			case 2:
				{
				setState(183);
				((BoolexprContext)_localctx).a = e(0);
				setState(184);
				((BoolexprContext)_localctx).op = match(AND);
				setState(185);
				((BoolexprContext)_localctx).b = e(0);
				((BoolexprContext)_localctx).i =  evalBool(((BoolexprContext)_localctx).a.v, (((BoolexprContext)_localctx).op!=null?((BoolexprContext)_localctx).op.getText():null), ((BoolexprContext)_localctx).b.v);
				}
				break;
			case 3:
				{
				setState(188);
				((BoolexprContext)_localctx).a = e(0);
				setState(189);
				((BoolexprContext)_localctx).op = match(OR);
				setState(190);
				((BoolexprContext)_localctx).b = e(0);
				((BoolexprContext)_localctx).i =  evalBool(((BoolexprContext)_localctx).a.v, (((BoolexprContext)_localctx).op!=null?((BoolexprContext)_localctx).op.getText():null), ((BoolexprContext)_localctx).b.v);
				}
				break;
			case 4:
				{
				setState(193);
				((BoolexprContext)_localctx).op = match(NOT);
				setState(194);
				((BoolexprContext)_localctx).a = e(0);
				((BoolexprContext)_localctx).i =  negation((((BoolexprContext)_localctx).op!=null?((BoolexprContext)_localctx).op.getText():null), ((BoolexprContext)_localctx).a.v);
				}
				break;
			case 5:
				{
				setState(197);
				match(T__3);
				setState(198);
				((BoolexprContext)_localctx).boolexpr = boolexpr(0);
				setState(199);
				match(T__4);
				((BoolexprContext)_localctx).i =  ((BoolexprContext)_localctx).boolexpr.i;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(214);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new BoolexprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_boolexpr);
						setState(204);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(205);
						((BoolexprContext)_localctx).op = match(AND);
						setState(206);
						((BoolexprContext)_localctx).y = ((BoolexprContext)_localctx).boolexpr = boolexpr(8);
						((BoolexprContext)_localctx).i =  evalBool(((BoolexprContext)_localctx).x.i, (((BoolexprContext)_localctx).op!=null?((BoolexprContext)_localctx).op.getText():null), ((BoolexprContext)_localctx).y.i);
						}
						break;
					case 2:
						{
						_localctx = new BoolexprContext(_parentctx, _parentState);
						_localctx.x = _prevctx;
						_localctx.x = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_boolexpr);
						setState(209);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(210);
						((BoolexprContext)_localctx).op = match(OR);
						setState(211);
						((BoolexprContext)_localctx).y = ((BoolexprContext)_localctx).boolexpr = boolexpr(7);
						((BoolexprContext)_localctx).i =  evalBool(((BoolexprContext)_localctx).x.i, (((BoolexprContext)_localctx).op!=null?((BoolexprContext)_localctx).op.getText():null), ((BoolexprContext)_localctx).y.i);
						}
						break;
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class StdexprContext extends ParserRuleContext {
		public float s;
		public EContext a;
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public StdexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stdexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).enterStdexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).exitStdexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bcVisitor ) return ((bcVisitor<? extends T>)visitor).visitStdexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StdexprContext stdexpr() throws RecognitionException {
		StdexprContext _localctx = new StdexprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stdexpr);
		try {
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(T__5);
				setState(220);
				((StdexprContext)_localctx).a = e(0);
				((StdexprContext)_localctx).s =  decrement((((StdexprContext)_localctx).a!=null?_input.getText(((StdexprContext)_localctx).a.start,((StdexprContext)_localctx).a.stop):null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				((StdexprContext)_localctx).a = e(0);
				setState(224);
				match(T__5);
				((StdexprContext)_localctx).s =  decrement_post((((StdexprContext)_localctx).a!=null?_input.getText(((StdexprContext)_localctx).a.start,((StdexprContext)_localctx).a.stop):null));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				match(T__6);
				setState(228);
				((StdexprContext)_localctx).a = e(0);
				((StdexprContext)_localctx).s =  increment((((StdexprContext)_localctx).a!=null?_input.getText(((StdexprContext)_localctx).a.start,((StdexprContext)_localctx).a.stop):null));
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(231);
				((StdexprContext)_localctx).a = e(0);
				setState(232);
				match(T__6);
				((StdexprContext)_localctx).s =  increment_post((((StdexprContext)_localctx).a!=null?_input.getText(((StdexprContext)_localctx).a.start,((StdexprContext)_localctx).a.stop):null));
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

	public static class EContext extends ParserRuleContext {
		public float v;
		public EContext a;
		public Token FLOAT;
		public Token ID;
		public EContext e;
		public Token op;
		public EContext b;
		public TerminalNode FLOAT() { return getToken(bcParser.FLOAT, 0); }
		public TerminalNode ID() { return getToken(bcParser.ID, 0); }
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public TerminalNode MUL() { return getToken(bcParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(bcParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(bcParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(bcParser.SUB, 0); }
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bcListener ) ((bcListener)listener).exitE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bcVisitor ) return ((bcVisitor<? extends T>)visitor).visitE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EContext e() throws RecognitionException {
		return e(0);
	}

	private EContext e(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EContext _localctx = new EContext(_ctx, _parentState);
		EContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_e, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				{
				setState(238);
				((EContext)_localctx).FLOAT = match(FLOAT);
				((EContext)_localctx).v =  getFloatValue((((EContext)_localctx).FLOAT!=null?((EContext)_localctx).FLOAT.getText():null));
				}
				break;
			case ID:
				{
				setState(240);
				((EContext)_localctx).ID = match(ID);

				      String id = (((EContext)_localctx).ID!=null?((EContext)_localctx).ID.getText():null);
				      ((EContext)_localctx).v =  memory.containsKey(id) ? memory.get(id) : 0;
				      
				}
				break;
			case T__3:
				{
				setState(242);
				match(T__3);
				setState(243);
				((EContext)_localctx).e = e(0);
				setState(244);
				match(T__4);
				((EContext)_localctx).v =  ((EContext)_localctx).e.v;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(259);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(249);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(250);
						((EContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((EContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(251);
						((EContext)_localctx).b = ((EContext)_localctx).e = e(6);
						((EContext)_localctx).v =  eval(((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), ((EContext)_localctx).b.v);
						}
						break;
					case 2:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(254);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(255);
						((EContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((EContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(256);
						((EContext)_localctx).b = ((EContext)_localctx).e = e(5);
						((EContext)_localctx).v =  eval(((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), ((EContext)_localctx).b.v);
						}
						break;
					}
					} 
				}
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return function_sempred((FunctionContext)_localctx, predIndex);
		case 5:
			return boolexpr_sempred((BoolexprContext)_localctx, predIndex);
		case 7:
			return e_sempred((EContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean function_sempred(FunctionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean boolexpr_sempred(BoolexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean e_sempred(EContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u010b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\24\n"+
		"\2\r\2\16\2\25\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3N\n\3\3\4\3\4\3\4\3\4\7\4T\n\4\f\4\16\4W\13\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5k\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5w\n\5\f\5\16\5"+
		"z\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u00b3\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00cd\n\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00d9\n\7\f\7\16\7\u00dc"+
		"\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\b\u00ee\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00fa\n\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0106\n\t\f\t\16\t\u0109\13"+
		"\t\3\t\2\5\b\f\20\n\2\4\6\b\n\f\16\20\2\4\3\2\f\r\3\2\n\13\2\u012a\2\23"+
		"\3\2\2\2\4M\3\2\2\2\6O\3\2\2\2\bj\3\2\2\2\n\u00b2\3\2\2\2\f\u00cc\3\2"+
		"\2\2\16\u00ed\3\2\2\2\20\u00f9\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2\2\24"+
		"\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\3\3\2\2\2\27\30\5\20\t\2\30"+
		"\31\7\30\2\2\31\32\b\3\1\2\32N\3\2\2\2\33\34\5\f\7\2\34\35\7\30\2\2\35"+
		"\36\b\3\1\2\36N\3\2\2\2\37 \5\b\5\2 !\7\30\2\2!\"\b\3\1\2\"N\3\2\2\2#"+
		"$\5\n\6\2$%\7\30\2\2%&\b\3\1\2&N\3\2\2\2\'(\5\16\b\2()\7\30\2\2)*\b\3"+
		"\1\2*N\3\2\2\2+,\5\6\4\2,-\7\30\2\2-N\3\2\2\2./\7\25\2\2/\60\7\33\2\2"+
		"\60\61\5\b\5\2\61\62\7\30\2\2\62\63\b\3\1\2\63N\3\2\2\2\64\65\7\25\2\2"+
		"\65\66\7\33\2\2\66\67\5\20\t\2\678\7\30\2\289\b\3\1\29N\3\2\2\2:;\7\25"+
		"\2\2;<\7\33\2\2<=\5\f\7\2=>\7\30\2\2>?\b\3\1\2?N\3\2\2\2@A\7\25\2\2AB"+
		"\7\33\2\2BC\5\n\6\2CD\7\30\2\2DE\b\3\1\2EN\3\2\2\2FG\7\25\2\2GH\7\33\2"+
		"\2HI\5\16\b\2IJ\7\30\2\2JK\b\3\1\2KN\3\2\2\2LN\7\30\2\2M\27\3\2\2\2M\33"+
		"\3\2\2\2M\37\3\2\2\2M#\3\2\2\2M\'\3\2\2\2M+\3\2\2\2M.\3\2\2\2M\64\3\2"+
		"\2\2M:\3\2\2\2M@\3\2\2\2MF\3\2\2\2ML\3\2\2\2N\5\3\2\2\2OP\7\3\2\2PU\5"+
		"\20\t\2QR\7\4\2\2RT\5\20\t\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V"+
		"X\3\2\2\2WU\3\2\2\2XY\b\4\1\2Y\7\3\2\2\2Z[\b\5\1\2[\\\7\5\2\2\\]\7\6\2"+
		"\2]^\7\7\2\2^k\b\5\1\2_`\7\25\2\2`a\7\6\2\2ab\5\20\t\2bc\7\7\2\2cd\b\5"+
		"\1\2dk\3\2\2\2ef\7\6\2\2fg\5\b\5\2gh\7\7\2\2hi\b\5\1\2ik\3\2\2\2jZ\3\2"+
		"\2\2j_\3\2\2\2je\3\2\2\2kx\3\2\2\2lm\f\5\2\2mn\t\2\2\2no\5\b\5\6op\b\5"+
		"\1\2pw\3\2\2\2qr\f\4\2\2rs\t\2\2\2st\5\b\5\5tu\b\5\1\2uw\3\2\2\2vl\3\2"+
		"\2\2vq\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\t\3\2\2\2zx\3\2\2\2{|\5"+
		"\20\t\2|}\t\3\2\2}~\5\f\7\2~\177\b\6\1\2\177\u00b3\3\2\2\2\u0080\u0081"+
		"\5\f\7\2\u0081\u0082\t\3\2\2\u0082\u0083\5\20\t\2\u0083\u0084\b\6\1\2"+
		"\u0084\u00b3\3\2\2\2\u0085\u0086\5\20\t\2\u0086\u0087\t\2\2\2\u0087\u0088"+
		"\5\f\7\2\u0088\u0089\b\6\1\2\u0089\u00b3\3\2\2\2\u008a\u008b\5\f\7\2\u008b"+
		"\u008c\t\2\2\2\u008c\u008d\5\20\t\2\u008d\u008e\b\6\1\2\u008e\u00b3\3"+
		"\2\2\2\u008f\u0090\5\f\7\2\u0090\u0091\t\3\2\2\u0091\u0092\5\f\7\2\u0092"+
		"\u0093\b\6\1\2\u0093\u00b3\3\2\2\2\u0094\u0095\5\f\7\2\u0095\u0096\t\2"+
		"\2\2\u0096\u0097\5\f\7\2\u0097\u0098\b\6\1\2\u0098\u00b3\3\2\2\2\u0099"+
		"\u009a\5\20\t\2\u009a\u009b\7\16\2\2\u009b\u009c\5\f\7\2\u009c\u009d\b"+
		"\6\1\2\u009d\u00b3\3\2\2\2\u009e\u009f\5\f\7\2\u009f\u00a0\7\16\2\2\u00a0"+
		"\u00a1\5\20\t\2\u00a1\u00a2\b\6\1\2\u00a2\u00b3\3\2\2\2\u00a3\u00a4\5"+
		"\20\t\2\u00a4\u00a5\7\17\2\2\u00a5\u00a6\5\f\7\2\u00a6\u00a7\b\6\1\2\u00a7"+
		"\u00b3\3\2\2\2\u00a8\u00a9\5\f\7\2\u00a9\u00aa\7\17\2\2\u00aa\u00ab\5"+
		"\20\t\2\u00ab\u00ac\b\6\1\2\u00ac\u00b3\3\2\2\2\u00ad\u00ae\7\6\2\2\u00ae"+
		"\u00af\5\n\6\2\u00af\u00b0\7\7\2\2\u00b0\u00b1\b\6\1\2\u00b1\u00b3\3\2"+
		"\2\2\u00b2{\3\2\2\2\u00b2\u0080\3\2\2\2\u00b2\u0085\3\2\2\2\u00b2\u008a"+
		"\3\2\2\2\u00b2\u008f\3\2\2\2\u00b2\u0094\3\2\2\2\u00b2\u0099\3\2\2\2\u00b2"+
		"\u009e\3\2\2\2\u00b2\u00a3\3\2\2\2\u00b2\u00a8\3\2\2\2\u00b2\u00ad\3\2"+
		"\2\2\u00b3\13\3\2\2\2\u00b4\u00b5\b\7\1\2\u00b5\u00b6\7\20\2\2\u00b6\u00b7"+
		"\5\f\7\7\u00b7\u00b8\b\7\1\2\u00b8\u00cd\3\2\2\2\u00b9\u00ba\5\20\t\2"+
		"\u00ba\u00bb\7\16\2\2\u00bb\u00bc\5\20\t\2\u00bc\u00bd\b\7\1\2\u00bd\u00cd"+
		"\3\2\2\2\u00be\u00bf\5\20\t\2\u00bf\u00c0\7\17\2\2\u00c0\u00c1\5\20\t"+
		"\2\u00c1\u00c2\b\7\1\2\u00c2\u00cd\3\2\2\2\u00c3\u00c4\7\20\2\2\u00c4"+
		"\u00c5\5\20\t\2\u00c5\u00c6\b\7\1\2\u00c6\u00cd\3\2\2\2\u00c7\u00c8\7"+
		"\6\2\2\u00c8\u00c9\5\f\7\2\u00c9\u00ca\7\7\2\2\u00ca\u00cb\b\7\1\2\u00cb"+
		"\u00cd\3\2\2\2\u00cc\u00b4\3\2\2\2\u00cc\u00b9\3\2\2\2\u00cc\u00be\3\2"+
		"\2\2\u00cc\u00c3\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cd\u00da\3\2\2\2\u00ce"+
		"\u00cf\f\t\2\2\u00cf\u00d0\7\16\2\2\u00d0\u00d1\5\f\7\n\u00d1\u00d2\b"+
		"\7\1\2\u00d2\u00d9\3\2\2\2\u00d3\u00d4\f\b\2\2\u00d4\u00d5\7\17\2\2\u00d5"+
		"\u00d6\5\f\7\t\u00d6\u00d7\b\7\1\2\u00d7\u00d9\3\2\2\2\u00d8\u00ce\3\2"+
		"\2\2\u00d8\u00d3\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\r\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7\b\2\2"+
		"\u00de\u00df\5\20\t\2\u00df\u00e0\b\b\1\2\u00e0\u00ee\3\2\2\2\u00e1\u00e2"+
		"\5\20\t\2\u00e2\u00e3\7\b\2\2\u00e3\u00e4\b\b\1\2\u00e4\u00ee\3\2\2\2"+
		"\u00e5\u00e6\7\t\2\2\u00e6\u00e7\5\20\t\2\u00e7\u00e8\b\b\1\2\u00e8\u00ee"+
		"\3\2\2\2\u00e9\u00ea\5\20\t\2\u00ea\u00eb\7\t\2\2\u00eb\u00ec\b\b\1\2"+
		"\u00ec\u00ee\3\2\2\2\u00ed\u00dd\3\2\2\2\u00ed\u00e1\3\2\2\2\u00ed\u00e5"+
		"\3\2\2\2\u00ed\u00e9\3\2\2\2\u00ee\17\3\2\2\2\u00ef\u00f0\b\t\1\2\u00f0"+
		"\u00f1\7\26\2\2\u00f1\u00fa\b\t\1\2\u00f2\u00f3\7\25\2\2\u00f3\u00fa\b"+
		"\t\1\2\u00f4\u00f5\7\6\2\2\u00f5\u00f6\5\20\t\2\u00f6\u00f7\7\7\2\2\u00f7"+
		"\u00f8\b\t\1\2\u00f8\u00fa\3\2\2\2\u00f9\u00ef\3\2\2\2\u00f9\u00f2\3\2"+
		"\2\2\u00f9\u00f4\3\2\2\2\u00fa\u0107\3\2\2\2\u00fb\u00fc\f\7\2\2\u00fc"+
		"\u00fd\t\3\2\2\u00fd\u00fe\5\20\t\b\u00fe\u00ff\b\t\1\2\u00ff\u0106\3"+
		"\2\2\2\u0100\u0101\f\6\2\2\u0101\u0102\t\2\2\2\u0102\u0103\5\20\t\7\u0103"+
		"\u0104\b\t\1\2\u0104\u0106\3\2\2\2\u0105\u00fb\3\2\2\2\u0105\u0100\3\2"+
		"\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\21\3\2\2\2\u0109\u0107\3\2\2\2\20\25MUjvx\u00b2\u00cc\u00d8\u00da\u00ed"+
		"\u00f9\u0105\u0107";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}