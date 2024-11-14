// Generated from d:/Work/grammarinator_ucla_cs230/py_calculator/Calculator.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(CalculatorParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(CalculatorParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDOPGRP2}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterADDOPGRP2(CalculatorParser.ADDOPGRP2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDOPGRP2}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitADDOPGRP2(CalculatorParser.ADDOPGRP2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMULOPGRP(CalculatorParser.MULOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MULOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMULOPGRP(CalculatorParser.MULOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLE(CalculatorParser.DOUBLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLE(CalculatorParser.DOUBLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MULOPGRP1}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMULOPGRP1(CalculatorParser.MULOPGRP1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code MULOPGRP1}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMULOPGRP1(CalculatorParser.MULOPGRP1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterADDOPGRP(CalculatorParser.ADDOPGRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDOPGRP}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitADDOPGRP(CalculatorParser.ADDOPGRPContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#uminus}.
	 * @param ctx the parse tree
	 */
	void enterUminus(CalculatorParser.UminusContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#uminus}.
	 * @param ctx the parse tree
	 */
	void exitUminus(CalculatorParser.UminusContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(CalculatorParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(CalculatorParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(CalculatorParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(CalculatorParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(CalculatorParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(CalculatorParser.AtomContext ctx);
}