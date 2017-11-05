package com.lytr777.propositionalCalculus.operations;

import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by lytr777 on 15/08/2017.
 */
public class Disjunction extends AbstractBinaryOperation {

    public Disjunction(Operation op) {
        first = op;
    }

    public Disjunction(Operation op1, Operation op2) {
        first = op1;
        second = op2;
    }

    @Override
    public OperationType getType() {
        return OperationType.DISJUNCTION;
    }

    @Override
    public Operation replaceVariable(String v, Operation op) {
        return new Disjunction(first.replaceVariable(v, op), second.replaceVariable(v, op));
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        return first.isTrueOn(values) || second.isTrueOn(values);
    }

    @Override
    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions) {
        print(pw, outside, substitutions, "|");
    }

    @Override
    public void print(boolean outside, Map<String, Operation> substitutions) {
        print(outside, substitutions, "|");
    }

    @Override
    public void printTree(int level) {
        printTree(level, "Disjunction");
    }
}