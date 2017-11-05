package com.lytr777.predicateСalculus.operations;

import com.lytr777.propositionalCalculus.operations.AbstractUnaryOperation;
import com.lytr777.propositionalCalculus.operations.Operation;
import com.lytr777.propositionalCalculus.operations.OperationType;

import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by lytr777 on 11/09/2017.
 */
public class Successor extends AbstractUnaryOperation {

    public Successor(Operation op) {
        operation = op;
    }

    @Override
    public OperationType getType() {
        return OperationType.SUCCESSOR;
    }

    @Override
    public Operation replaceVariable(String v, Operation op) {
        return new Successor(operation.replaceVariable(v, op));
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        throw new UnsupportedOperationException("Successor - it's not logical operation");
    }

    @Override
    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions) {
        operation.print(pw, false, substitutions);
        pw.print("'");
    }

    @Override
    public void print(boolean outside, Map<String, Operation> substitutions) {
        operation.print(false, substitutions);
        System.out.print("'");
    }

    @Override
    public void printTree(int level) {
        printTree(level, "Successor");
    }
}
