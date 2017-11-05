package com.lytr777.propositionalCalculus.operations;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lytr777 on 11/09/2017.
 */
public abstract class AbstractBinaryOperation extends AbstractOperation {

    public Operation first, second;

    @Override
    public void setFirstOperation(Operation op) {
        first = op;
    }

    @Override
    public void setSecondOperation(Operation op) {
        second = op;
    }

    @Override
    public void addArgument(Operation arg) {
        throw new UnsupportedOperationException("Binary operation can't have arguments");
    }

    @Override
    public List<Operation> getArguments() {
        throw new UnsupportedOperationException("Binary operation can't have arguments");
    }

    @Override
    public boolean isAvailableToInsert(String v, Set<String> free, boolean linked) {
        return first.isAvailableToInsert(v, free, linked) && second.isAvailableToInsert(v, free, linked);
    }

    @Override
    public Set<String> getFreeVariables() {
        Set<String> set = first.getFreeVariables();
        set.addAll(second.getFreeVariables());
        return set;
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

    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions, String operation) {
        if (!outside) pw.print("(");
        first.print(pw,false, substitutions);
        if (second != null) {
            pw.print(operation);
            second.print(pw,false, substitutions);
        }
        if (!outside) pw.print(")");
    }

    public void print(boolean outside, Map<String, Operation> substitutions, String operation) {
        if (!outside) System.out.print("(");
        first.print(false, substitutions);
        if (second != null) {
            System.out.print(operation);
            second.print(false, substitutions);
        }
        if (!outside) System.out.print(")");
    }

    public void printTree(int level, String operationName) {
        printLevel(level);
        System.out.println(operationName);
        first.printTree(level + 1);
        if (second != null) {
            second.printTree(level + 1);
        }
    }
}
