package com.lytr777.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lytr777 on 16/08/2017.
 */
public class InitialData {

    public List<Expression> assumptions, proof;
    public Expression statement;

    public InitialData() {
        assumptions = new ArrayList<>();
        proof = new ArrayList<>();
    }

    public void addAssumptionExpression(Expression expression) {
        expression.reconstruct();
        assumptions.add(expression);
    }

    public void addProofExpression(Expression expression) {
        expression.reconstruct();
        proof.add(expression);
    }

    public void setStatement(Expression expression) {
        expression.reconstruct();
        statement = expression;
    }

    public void prepare() {
        reconstruct();
    }

    private void reconstruct() {
        for (Expression expression : assumptions)
            expression.reconstruct();
        statement.reconstruct();
        for (Expression expression : proof)
            expression.reconstruct();
    }
}
