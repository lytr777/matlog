package com.lytr777.propositionalCalculus.operations;

import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by lytr777 on 15/08/2017.
 */
public class Disjunction implements Operation {

    private Operation first, second;

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
    public void setFirstOperation(Operation op) {
        first = op;
    }

    @Override
    public void setSecondOperation(Operation op) {
        second = op;
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        return first.isTrueOn(values) || second.isTrueOn(values);
    }

    @Override
    public boolean isUseless() {
        return second == null;
    }

    @Override
    public Operation getFirstOperation() {
        return first;
    }

    @Override
    public Operation getSecondOperation() {
        return second;
    }

    @Override
    public void reconstruct() {
        first.reconstruct();
        while (first.isUseless())
            first = first.getFirstOperation();
        if (second != null) {
            second.reconstruct();
            while (second.isUseless())
                second = second.getFirstOperation();
        }
    }

    @Override
    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions) {
        if (!outside) pw.print("(");
        first.print(pw, false, substitutions);
        if (second != null) {
            pw.print("|");
            second.print(pw, false, substitutions);
        }
        if (!outside) pw.print(")");
    }

    @Override
    public void print(boolean outside, Map<String, Operation> substitutions) {
        if (!outside) System.out.print("(");
        first.print(false, substitutions);
        if (second != null) {
            System.out.print("|");
            second.print(false, substitutions);
        }
        if (!outside) System.out.print(")");
    }

    @Override
    public void printTree(int level) {
        printLevel(level);
        System.out.println("Disjunction");
        first.printTree(level + 1);
        if (second != null) {
            second.printTree(level + 1);
        }
    }

    private void printLevel(int level) {
        for (int i = 0; i < level; i++)
            System.out.print("--");
    }
}
