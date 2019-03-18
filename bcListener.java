// Generated from bc.g4 by ANTLR 4.7.2

//package tools;
import java.util.*;
import java.lang.Math;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link bcParser}.
 */
public interface bcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link bcParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(bcParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link bcParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(bcParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link bcParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(bcParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link bcParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(bcParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link bcParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(bcParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link bcParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(bcParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link bcParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(bcParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link bcParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(bcParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link bcParser#mixedexpr}.
	 * @param ctx the parse tree
	 */
	void enterMixedexpr(bcParser.MixedexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link bcParser#mixedexpr}.
	 * @param ctx the parse tree
	 */
	void exitMixedexpr(bcParser.MixedexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link bcParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolexpr(bcParser.BoolexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link bcParser#boolexpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolexpr(bcParser.BoolexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link bcParser#stdexpr}.
	 * @param ctx the parse tree
	 */
	void enterStdexpr(bcParser.StdexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link bcParser#stdexpr}.
	 * @param ctx the parse tree
	 */
	void exitStdexpr(bcParser.StdexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link bcParser#e}.
	 * @param ctx the parse tree
	 */
	void enterE(bcParser.EContext ctx);
	/**
	 * Exit a parse tree produced by {@link bcParser#e}.
	 * @param ctx the parse tree
	 */
	void exitE(bcParser.EContext ctx);
}