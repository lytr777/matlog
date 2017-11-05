package com.lytr777.predicateСalculus.operations;

import com.lytr777.propositionalCalculus.operations.AbstractBinaryOperation;
import com.lytr777.propositionalCalculus.operations.Operation;
import com.lytr777.propositionalCalculus.operations.OperationType;

import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by lytr777 on 10/09/2017.
 */
public class Add extends AbstractBinaryOperation {

    public Add(Operation op) {
        first = op;
    }

    public Add(Operation op1, Operation op2) {
        first = op1;
        second = op2;
    }

    @Override
    public OperationType getType() {
        return OperationType.ADD;
    }

    @Override
    public Operation replaceVariable(String v, Operation op) {
        return new Add(first.replaceVariable(v, op), second.replaceVariable(v, op));
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        throw new UnsupportedOperationException("Add - it's not logical operation");
    }

    @Override
    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions) {
        print(pw, outside, substitutions, "+");
    }

    @Override
    public void print(boolean outside, Map<String, Operation> substitutions) {
        print(outside, substitutions, "+");
    }

    @Override
    public void printTree(int level) {
        printTree(level, "Add");
    }
}
