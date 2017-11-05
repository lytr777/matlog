package com.lytr777.propositionalCalculus.operations;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lytr777 on 20/08/2017.
 */
public class Substitution extends AbstractOperation {

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
    public void addArgument(Operation arg) {
        throw new UnsupportedOperationException("Substitution can't contain arguments");
    }

    @Override
    public List<Operation> getArguments() {
        throw new UnsupportedOperationException("Substitution can't contain arguments");
    }

    @Override
    public Set<String> getFreeVariables() {
        throw new UnsupportedOperationException("Substitution can't contain variables");
    }

    @Override
    public boolean isAvailableToInsert(String v, Set<String> free, boolean linked) {
        throw new UnsupportedOperationException("Substitution can't contain variables");
    }

    @Override
    public Operation replaceVariable(String v, Operation op) {
        throw new UnsupportedOperationException("Substitution can't contain variables");
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
    public void reconstruct() {
    }

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
                operation.print(pw, false, null);
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
}
