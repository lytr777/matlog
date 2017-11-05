package com.lytr777.predicateСalculus.operations;

import com.lytr777.propositionalCalculus.operations.AbstractBinaryOperation;
import com.lytr777.propositionalCalculus.operations.Operation;
import com.lytr777.propositionalCalculus.operations.OperationType;

import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by lytr777 on 11/09/2017.
 */
public class Equality extends AbstractBinaryOperation {

    public Equality(Operation op) {
        first = op;
    }

    public Equality(Operation op1, Operation op2) {
        first = op1;
        second = op2;
    }

    @Override
    public OperationType getType() {
        return OperationType.EQUALITY;
    }

    @Override
    public Operation replaceVariable(String v, Operation op) {
        return new Equality(first.replaceVariable(v, op), second.replaceVariable(v, op));
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        return first.equals(second);
    }

    @Override
    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions) {
        print(pw, outside, substitutions, "=");
    }

    @Override
    public void print(boolean outside, Map<String, Operation> substitutions) {
        print(outside, substitutions, "=");
    }

    @Override
    public void printTree(int level) {
        printTree(level, "Equality");
    }
}
