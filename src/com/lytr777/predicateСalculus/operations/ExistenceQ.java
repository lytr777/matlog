package com.lytr777.predicateСalculus.operations;

import com.lytr777.propositionalCalculus.operations.AbstractUnaryOperation;
import com.lytr777.propositionalCalculus.operations.Operation;
import com.lytr777.propositionalCalculus.operations.OperationType;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

/**
 * Created by lytr777 on 11/09/2017.
 */
public class ExistenceQ extends AbstractUnaryOperation {

    private String variable;

    public ExistenceQ(String var, Operation op) {
        variable = var;
        operation = op;
    }

    @Override
    public OperationType getType() {
        return OperationType.EXISTENCE_Q;
    }

    @Override
    public boolean isTrueOn(Map<String, Boolean> values) {
        return false;
    }

    public String getVariable() {
        return variable;
    }

    @Override
    public boolean isAvailableToInsert(String v, Set<String> free, boolean linked) {
        if (variable.equals(v))
            return true;
        if (free.contains(variable))
            return operation.isAvailableToInsert(v, free, true);
        return super.isAvailableToInsert(v, free, linked);
    }

    @Override
    public Operation replaceVariable(String v, Operation op) {
        return new ExistenceQ(variable, operation.replaceVariable(v, op));
    }

    @Override
    public Set<String> getFreeVariables() {
        Set<String> set = operation.getFreeVariables();
        set.remove(variable);
        return set;
    }

    @Override
    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions) {
        pw.print("?" + variable + " ");
        operation.print(pw, false, substitutions);
    }

    @Override
    public void print(boolean outside, Map<String, Operation> substitutions) {
        System.out.print("?" + variable + " ");
        operation.print(false, substitutions);
    }

    @Override
    public void printTree(int level) {
        printTree(level, "Existence Quantifier ?" + variable);
    }
}
