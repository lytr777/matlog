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
    }

    private void reconstruct() {
        for (Expression expression : assumptions)
            expression.reconstruct();
        statement.reconstruct();
        for (Expression expression : proof)
            expression.reconstruct();
    }
}
