package com.lytr777.propositionalCalculus.checkers;

import com.lytr777.util.Expression;
import com.lytr777.propositionalCalculus.operations.OperationType;
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
            if (proof.get(goal).equalWith(new Expression(proof.get(j).getOperation().getSecondOperation())))
                for (int i = goal - 1; i >= 0; i--)
                    if (proof.get(i).equalWith(new Expression(proof.get(j).getOperation().getFirstOperation())))
                        return new Pair<>(i + 1, j + 1);
        }
        return new Pair<>(-1, -1);
    }
}
