package com.lytr777.propositionalCalculus.operations;

import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by lytr777 on 15/08/2017.
 */
public class Negation implements Operation {

    private Operation operation;

    public Negation(Operation op) {
        operation = op;
    }

    @Override
    public OperationType getType() {
        return OperationType.NEGATION;
    }

    @Override
    public void setFirstOperation(Operation op) {
        operation = op;
    }

    @Override
    public void setSecondOperation(Operation op) {
        throw new UnsupportedOperationException("Negation can't have second logical operation");
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        return !operation.isTrueOn(values);
    }

    @Override
    public boolean isUseless() {
        return false;
    }

    @Override
    public Operation getFirstOperation() {
        return operation;
    }

    @Override
    public Operation getSecondOperation() {
        throw new UnsupportedOperationException("Negation can't have second logical operation");
    }

    @Override
    public void reconstruct() {
        operation.reconstruct();
        while (operation.isUseless())
            operation = operation.getFirstOperation();
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
        printLevel(level);
        System.out.println("Negation");
        operation.printTree(level + 1);
    }

    private void printLevel(int level) {
        for (int i = 0; i < level; i++)
            System.out.print("--");
    }
}
