package com.lytr777.propositionalCalculus.operations;

import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by lytr777 on 15/08/2017.
 */
public class Variable implements Operation {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public OperationType getType() {
        return OperationType.VARIABLE;
    }

    @Override
    public void setFirstOperation(Operation op) {
        throw new UnsupportedOperationException("Variable can't contain logical operation");
    }

    @Override
    public void setSecondOperation(Operation op) {
        throw new UnsupportedOperationException("Variable can't contain logical operation");
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        return values.get(name);
    }

    @Override
    public boolean isUseless() {
        return false;
    }

    @Override
    public Operation getFirstOperation() {
        throw new UnsupportedOperationException("Variable can't contain logical operation");
    }

    @Override
    public Operation getSecondOperation() {
        throw new UnsupportedOperationException("Variable can't contain logical operation");
    }

    @Override
    public void reconstruct() {}

    public String getName() {
        return name;
    }

    @Override
    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions) {
        pw.print(name);
    }

    @Override
    public void print(boolean outside, Map<String, Operation> substitutions) {
        System.out.print(name);
    }

    @Override
    public void printTree(int level) {
        printLevel(level);
        System.out.println(name);
    }

    private void printLevel(int level) {
        for (int i = 0; i < level; i++)
            System.out.print("--");
    }
}
