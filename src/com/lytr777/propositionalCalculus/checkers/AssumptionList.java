package com.lytr777.propositionalCalculus.checkers;

import com.lytr777.propositionalCalculus.Expression;

import java.util.List;

/**
 * Created by lytr777 on 28/08/2017.
 */
public class AssumptionList {

    private final List<Expression> assumptions;

    public AssumptionList(List<Expression> assumptions) {
        this.assumptions = assumptions;
    }

    public int isAssumption(Expression expression) {
        for (int i = 0; i < assumptions.size(); i++) {
            if (expression.equalWith(assumptions.get(i)))
                return i + 1;
        }
        return -1;
    }
}
