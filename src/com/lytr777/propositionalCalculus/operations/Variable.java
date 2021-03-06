package com.lytr777.propositionalCalculus.operations;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lytr777 on 15/08/2017.
 */
public class Variable extends AbstractOperation {

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
    public void addArgument(Operation arg) {
        throw new UnsupportedOperationException("Variable can't contain arguments");
    }

    @Override
    public List<Operation> getArguments() {
        throw new UnsupportedOperationException("Variable can't contain arguments");
    }

    @Override
    public Set<String> getFreeVariables() {
        Set<String> set = new HashSet<>();
        set.add(name);
        return set;
    }

    @Override
    public boolean isAvailableToInsert(String v, Set<String> free, boolean linked) {
        return !name.equals(v) || !linked;
    }

    @Override
    public Operation replaceVariable(String v, Operation op) {
        if (name.equals(v))
            return op;
        return new Variable(v);
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
}
