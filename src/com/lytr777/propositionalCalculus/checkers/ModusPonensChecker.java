package com.lytr777.propositionalCalculus.checkers;

import com.lytr777.propositionalCalculus.Expression;
import com.lytr777.propositionalCalculus.operations.Operation;
import com.lytr777.propositionalCalculus.operations.OperationType;
import com.lytr777.propositionalCalculus.operations.Variable;
import javafx.util.Pair;

import java.util.List;

/**
 * Created by lytr777 on 28/08/2017.
 */
public class ModusPonensChecker {

    private final List<Expression> proof;

    public ModusPonensChecker(List<Expression> proof) {
        this.proof = proof;
    }

    public Pair<Integer, Integer> isModusPonens(int goal) {
        if (goal > proof.size())
            throw new IndexOutOfBoundsException("Bound more then proof list size");
        for (int j = goal - 1; j >= 0; j--) {
            if (proof.get(j).getOperation().getType() != OperationType.IMPLICATION)
                continue;
            if (equals(proof.get(j).getOperation().getSecondOperation(), proof.get(goal).getOperation()))
                for (int i = goal - 1; i >= 0; i--)
                    if (equals(proof.get(j).getOperation().getFirstOperation(), proof.get(i).getOperation()))
                        return new Pair<>(i + 1, j + 1);
        }
        return new Pair<>(-1, -1);
    }

    private boolean equals(Operation op1, Operation op2) {
        if (op1.getType() == op2.getType()) {
            if (op1.getType() == OperationType.VARIABLE) {
                Variable var1 = (Variable) op1,
                        var2 = (Variable) op2;
                return var1.getName().equals(var2.getName());
            }
            if (!equals(op1.getFirstOperation(), op2.getFirstOperation()))
                return false;
            if (op1.getType() != OperationType.NEGATION && !equals(op1.getSecondOperation(), op2.getSecondOperation()))
                return false;
            return true;
        }
        return false;
    }
}
