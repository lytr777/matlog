package com.lytr777.propositionalCalculus.operations;

import java.util.List;
import java.util.Set;

/**
 * Created by lytr777 on 11/09/2017.
 */
public abstract class AbstractUnaryOperation extends AbstractOperation {

    public Operation operation;

    @Override
    public void setFirstOperation(Operation op) {
        operation = op;
    }

    @Override
    public void setSecondOperation(Operation op) {
        throw new UnsupportedOperationException("Unary operation can't have second logical operation");
    }

    @Override
    public void addArgument(Operation arg) {
        throw new UnsupportedOperationException("Unary operation can't have arguments");
    }

    @Override
    public List<Operation> getArguments() {
        throw new UnsupportedOperationException("Unary operation can't have arguments");
    }

    @Override
    public boolean isAvailableToInsert(String v, Set<String> free, boolean linked) {
        return operation.isAvailableToInsert(v, free, linked);
    }

    @Override
    public Set<String> getFreeVariables() {
        return operation.getFreeVariables();
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
        throw new UnsupportedOperationException("Unary operation can't have second logical operation");
    }

    @Override
    public void reconstruct() {
        operation.reconstruct();
        while (operation.isUseless())
            operation = operation.getFirstOperation();
    }

    public void printTree(int level, String operationName) {
        printLevel(level);
        System.out.println(operationName);
        operation.printTree(level + 1);
    }
}
