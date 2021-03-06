package com.lytr777.propositionalCalculus.operations;

import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by lytr777 on 15/08/2017.
 */
public class Negation extends AbstractUnaryOperation {

    public Negation(Operation op) {
        operation = op;
    }

    @Override
    public OperationType getType() {
        return OperationType.NEGATION;
    }

    @Override
    public Operation replaceVariable(String v, Operation op) {
        return new Negation(operation.replaceVariable(v, op));
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        return !operation.isTrueOn(values);
    }

    @Override
    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions) {
        pw.print("!");
        operation.print(pw, false, substitutions);
    }

    @Override
    public void print(boolean outside, Map<String, Operation> substitutions) {
        System.out.print("!");
        operation.print(false, substitutions);
    }

    @Override
    public void printTree(int level) {
        printTree(level, "Negation");
    }
}
