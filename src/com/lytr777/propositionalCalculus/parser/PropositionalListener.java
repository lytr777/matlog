// Generated from /Users/lytr777/IdeaProjects/MATLOG_HW/src/com/lytr777/propositionalCalculus/parser/Propositional.g4 by ANTLR 4.7
package com.lytr777.propositionalCalculus.parser;

import com.lytr777.util.Expression;
import com.lytr777.util.InitialData;
import com.lytr777.propositionalCalculus.operations.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PropositionalParser}.
 */
public interface PropositionalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PropositionalParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(PropositionalParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropositionalParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(PropositionalParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropositionalParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(PropositionalParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropositionalParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(PropositionalParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropositionalParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PropositionalParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropositionalParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PropositionalParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropositionalParser#dis}.
	 * @param ctx the parse tree
	 */
	void enterDis(PropositionalParser.DisContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropositionalParser#dis}.
	 * @param ctx the parse tree
	 */
	void exitDis(PropositionalParser.DisContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropositionalParser#diss}.
	 * @param ctx the parse tree
	 */
	void enterDiss(PropositionalParser.DissContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropositionalParser#diss}.
	 * @param ctx the parse tree
	 */
	void exitDiss(PropositionalParser.DissContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropositionalParser#con}.
	 * @param ctx the parse tree
	 */
	void enterCon(PropositionalParser.ConContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropositionalParser#con}.
	 * @param ctx the parse tree
	 */
	void exitCon(PropositionalParser.ConContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropositionalParser#cons}.
	 * @param ctx the parse tree
	 */
	void enterCons(PropositionalParser.ConsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropositionalParser#cons}.
	 * @param ctx the parse tree
	 */
	void exitCons(PropositionalParser.ConsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropositionalParser#neg}.
	 * @param ctx the parse tree
	 */
	void enterNeg(PropositionalParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropositionalParser#neg}.
	 * @param ctx the parse tree
	 */
	void exitNeg(PropositionalParser.NegContext ctx);
}