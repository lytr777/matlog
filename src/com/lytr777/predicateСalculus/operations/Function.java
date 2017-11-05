package com.lytr777.predicateСalculus.operations;

import com.lytr777.propositionalCalculus.operations.Operation;
import com.lytr777.propositionalCalculus.operations.OperationType;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by lytr777 on 11/09/2017.
 */
public class Function extends AbstractFunctionalOperator {

    public Function(String name) {
        this.name = name;
        arguments = new LinkedList<>();
    }

    @Override
    public OperationType getType() {
        return OperationType.FUNCTION;
    }

    @Override
    public Operation replaceVariable(String v, Operation op) {
        if (arguments.size() == 0 && name.equals(v))
            return op;
        Function f = new Function(name);
        for (Operation arg : arguments) {
            f.addArgument(arg.replaceVariable(v, op));
        }
        return f;
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        throw new UnsupportedOperationException("Unknown function can't been evaluate");
    }

    @Override
    public void printTree(int level) {
        printTree(level, "Function " + name);
    }
}
