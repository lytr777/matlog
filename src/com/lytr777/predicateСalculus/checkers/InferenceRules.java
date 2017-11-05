package com.lytr777.predicateСalculus.checkers;

import com.lytr777.predicateСalculus.operations.ExistenceQ;
import com.lytr777.predicateСalculus.operations.UniversalQ;
import com.lytr777.propositionalCalculus.operations.Implication;
import com.lytr777.propositionalCalculus.operations.Operation;
import com.lytr777.propositionalCalculus.operations.OperationType;
import com.lytr777.util.Expression;
import javafx.util.Pair;

import java.util.List;

/**
 * Created by lytr777 on 15/09/2017.
 */
public class InferenceRules {

    private final List<Expression> proof;

    public InferenceRules(List<Expression> proof) {
        this.proof = proof;
    }

    public Pair<Integer, String> isInferenceRule(int goal) {
        if (goal > proof.size())
            throw new IndexOutOfBoundsException("Bound more then proof list size");
        Expression expression = proof.get(goal);
        if (expression.getOperation().getType() == OperationType.IMPLICATION) {
            Operation fi = expression.getOperation().getFirstOperation(),
                    psi = expression.getOperation().getSecondOperation();

            if (psi.getType() == OperationType.UNIVERSAL_Q) {
                UniversalQ uq = (UniversalQ) psi;

                if (!fi.getFreeVariables().contains(uq.getVariable()) &&
                        patternProved(goal, new Expression(new Implication(fi, uq.getFirstOperation()))))
                    return new Pair<>(1, uq.getVariable());
            }

            if (fi.getType() == OperationType.EXISTENCE_Q) {
                ExistenceQ eq = (ExistenceQ) fi;
                if (!psi.getFreeVariables().contains(eq.getVariable()) &&
                        patternProved(goal, new Expression(new Implication(eq.getFirstOperation(), psi))))
                    return new Pair<>(2, eq.getVariable());
            }
        }
        return new Pair<>(-1, "");
    }

    private boolean patternProved(int goal, Expression pattern) {
        for (int i = goal - 1; i >= 0; i--) {
            if (pattern.equalWith(proof.get(i)))
                return true;
        }
        return false;
    }
}
