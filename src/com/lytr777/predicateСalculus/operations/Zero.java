package com.lytr777.predicateСalculus.operations;

import com.lytr777.propositionalCalculus.operations.AbstractOperation;
import com.lytr777.propositionalCalculus.operations.Operation;
import com.lytr777.propositionalCalculus.operations.OperationType;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lytr777 on 11/09/2017.
 */
public class Zero extends AbstractOperation {

    public Zero() {}

    @Override
    public OperationType getType() {
        return OperationType.ZERO;
    }

    @Override
    public void setFirstOperation(Operation op) {
        throw new UnsupportedOperationException("Zero can't contain logical operation");
    }

    @Override
    public void setSecondOperation(Operation op) {
        throw new UnsupportedOperationException("Zero can't contain logical operation");
    }

    @Override
    public void addArgument(Operation arg) {
        throw new UnsupportedOperationException("Zero can't contain arguments");
    }

    @Override
    public List<Operation> getArguments() {
        throw new UnsupportedOperationException("Zero can't contain arguments");
    }

    @Override
    public Set<String> getFreeVariables() {
        return new HashSet<>();
    }

    @Override
    public boolean isAvailableToInsert(String v, Set<String> free, boolean linked) {
        return true;
    }

    @Override
    public Operation replaceVariable(String v, Operation op) {
        return new Zero();
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        throw new UnsupportedOperationException("Zero can't have logical value");
    }

    @Override
    public boolean isUseless() {
        return false;
    }

    @Override
    public Operation getFirstOperation() {
        throw new UnsupportedOperationException("Zero can't contain logical operation");
    }

    @Override
    public Operation getSecondOperation() {
        throw new UnsupportedOperationException("Zero can't contain logical operation");
    }

    @Override
    public void reconstruct() {}

    @Override
    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions) {
        pw.print("0");
    }

    @Override
    public void print(boolean outside, Map<String, Operation> substitutions) {
        System.out.print("0");
    }

    @Override
    public void printTree(int level) {
        printLevel(level);
        System.out.println("Zero");
    }
}
