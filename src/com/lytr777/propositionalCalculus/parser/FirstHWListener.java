// Generated from /Users/lytr777/IdeaProjects/MATLOG_HW/src/com/lytr777/propositionalCalculus/parser/FirstHW.g4 by ANTLR 4.7
package com.lytr777.propositionalCalculus.parser;

import com.lytr777.propositionalCalculus.Expression;
import com.lytr777.propositionalCalculus.InitialData;
import com.lytr777.propositionalCalculus.operations.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FirstHWParser}.
 */
public interface FirstHWListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FirstHWParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(FirstHWParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link FirstHWParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(FirstHWParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link FirstHWParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(FirstHWParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FirstHWParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(FirstHWParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FirstHWParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FirstHWParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FirstHWParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FirstHWParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FirstHWParser#dis}.
	 * @param ctx the parse tree
	 */
	void enterDis(FirstHWParser.DisContext ctx);
	/**
	 * Exit a parse tree produced by {@link FirstHWParser#dis}.
	 * @param ctx the parse tree
	 */
	void exitDis(FirstHWParser.DisContext ctx);
	/**
	 * Enter a parse tree produced by {@link FirstHWParser#diss}.
	 * @param ctx the parse tree
	 */
	void enterDiss(FirstHWParser.DissContext ctx);
	/**
	 * Exit a parse tree produced by {@link FirstHWParser#diss}.
	 * @param ctx the parse tree
	 */
	void exitDiss(FirstHWParser.DissContext ctx);
	/**
	 * Enter a parse tree produced by {@link FirstHWParser#con}.
	 * @param ctx the parse tree
	 */
	void enterCon(FirstHWParser.ConContext ctx);
	/**
	 * Exit a parse tree produced by {@link FirstHWParser#con}.
	 * @param ctx the parse tree
	 */
	void exitCon(FirstHWParser.ConContext ctx);
	/**
	 * Enter a parse tree produced by {@link FirstHWParser#cons}.
	 * @param ctx the parse tree
	 */
	void enterCons(FirstHWParser.ConsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FirstHWParser#cons}.
	 * @param ctx the parse tree
	 */
	void exitCons(FirstHWParser.ConsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FirstHWParser#neg}.
	 * @param ctx the parse tree
	 */
	void enterNeg(FirstHWParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by {@link FirstHWParser#neg}.
	 * @param ctx the parse tree
	 */
	void exitNeg(FirstHWParser.NegContext ctx);
}