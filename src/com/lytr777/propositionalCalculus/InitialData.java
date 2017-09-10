package com.lytr777.propositionalCalculus;

import com.lytr777.propositionalCalculus.checkers.AssumptionList;
import com.lytr777.propositionalCalculus.checkers.ModusPonensChecker;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lytr777 on 16/08/2017.
 */
public class InitialData {

    public List<Expression> assumptions, proof;
    public Expression statement;

    public AssumptionList assumptionList;
    public ModusPonensChecker modusPonensChecker;

    public InitialData() {
        assumptions = new LinkedList<>();
        proof = new LinkedList<>();
    }

    public void addAssumptionExpression(Expression expression) {
        assumptions.add(expression);
    }

    public void addProofExpression(Expression expression) {
        proof.add(expression);
    }

    public void setStatement(Expression expression) {
        statement = expression;
    }

    public void prepare() {
        reconstruct();
        assumptionList = new AssumptionList(assumptions);
        modusPonensChecker = new ModusPonensChecker(proof);
    }

    private void reconstruct() {
        for (Expression expression : assumptions)
            expression.reconstruct();
        statement.reconstruct();
        for (Expression expression : proof)
            expression.reconstruct();
    }
}
