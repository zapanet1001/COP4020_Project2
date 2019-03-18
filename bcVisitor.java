// Generated from bc.g4 by ANTLR 4.7.2

//package tools;
import java.util.*;
import java.lang.Math;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link bcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface bcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link bcParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(bcParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link bcParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(bcParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link bcParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(bcParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link bcParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(bcParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link bcParser#mixedexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixedexpr(bcParser.MixedexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link bcParser#boolexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolexpr(bcParser.BoolexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link bcParser#stdexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStdexpr(bcParser.StdexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link bcParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(bcParser.EContext ctx);
}