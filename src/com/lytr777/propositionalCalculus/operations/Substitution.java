package com.lytr777.propositionalCalculus.operations;

import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by lytr777 on 20/08/2017.
 */
public class Substitution implements Operation {

    private String name;

    public Substitution(String name) {
        this.name = name;
    }

    @Override
    public OperationType getType() {
        return OperationType.SUBSTITUTION;
    }

    @Override
    public void setFirstOperation(Operation op) {
        throw new UnsupportedOperationException("Substitution can't contain logical operation");
    }

    @Override
    public void setSecondOperation(Operation op) {
        throw new UnsupportedOperationException("Substitution can't contain logical operation");
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        throw new UnsupportedOperationException("Substitution hasn't logical value");
    }

    @Override
    public boolean isUseless() {
        return false;
    }

    @Override
    public Operation getFirstOperation() {
        throw new UnsupportedOperationException("Substitution can't contain logical operation");
    }

    @Override
    public Operation getSecondOperation() {
        throw new UnsupportedOperationException("Substitution can't contain logical operation");
    }

    @Override
    public void reconstruct() {}

    public String getName() {
        return name;
    }

    @Override
    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions) {
        if (substitutions == null)
            pw.print(name + '\'');
        else {
            Operation operation = substitutions.get(name);
            if (operation != null)
                operation.print(pw,false, null);
        }
    }

    @Override
    public void print(boolean outside, Map<String, Operation> substitutions) {
        if (substitutions == null)
            System.out.print(name + '\'');
        else {
            Operation operation = substitutions.get(name);
            if (operation != null)
                operation.print(false, null);
        }
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
