// Generated from /Users/lytr777/IdeaProjects/MATLOG_HW/src/com/lytr777/predicateСalculus/parser/Predicate.g4 by ANTLR 4.7
package com.lytr777.predicateСalculus.parser;

import com.lytr777.propositionalCalculus.operations.*;
import com.lytr777.predicateСalculus.operations.*;
import com.lytr777.predicateСalculus.operations.Predicate;
import com.lytr777.util.Expression;
import com.lytr777.util.InitialData;
import javafx.util.Pair;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PredicateParser}.
 */
public interface PredicateListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PredicateParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(PredicateParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(PredicateParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateParser#five}.
	 * @param ctx the parse tree
	 */
	void enterFive(PredicateParser.FiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#five}.
	 * @param ctx the parse tree
	 */
	void exitFive(PredicateParser.FiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(PredicateParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(PredicateParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PredicateParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PredicateParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateParser#dis}.
	 * @param ctx the parse tree
	 */
	void enterDis(PredicateParser.DisContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#dis}.
	 * @param ctx the parse tree
	 */
	void exitDis(PredicateParser.DisContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateParser#con}.
	 * @param ctx the parse tree
	 */
	void enterCon(PredicateParser.ConContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#con}.
	 * @param ctx the parse tree
	 */
	void exitCon(PredicateParser.ConContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateParser#neg}.
	 * @param ctx the parse tree
	 */
	void enterNeg(PredicateParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#neg}.
	 * @param ctx the parse tree
	 */
	void exitNeg(PredicateParser.NegContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateParser#pred}.
	 * @param ctx the parse tree
	 */
	void enterPred(PredicateParser.PredContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#pred}.
	 * @param ctx the parse tree
	 */
	void exitPred(PredicateParser.PredContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(PredicateParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(PredicateParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(PredicateParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(PredicateParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(PredicateParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(PredicateParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link PredicateParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(PredicateParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link PredicateParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(PredicateParser.NumContext ctx);
}