package com.lytr777.predicateСalculus.operations;

import com.lytr777.propositionalCalculus.operations.AbstractOperation;
import com.lytr777.propositionalCalculus.operations.Operation;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lytr777 on 12/09/2017.
 */
public abstract class AbstractFunctionalOperator extends AbstractOperation {

    public String name;
    List<Operation> arguments;

    @Override
    public void setFirstOperation(Operation op) {
        throw new UnsupportedOperationException("Functional operation can't have first logical operation");
    }

    @Override
    public void setSecondOperation(Operation op) {
        throw new UnsupportedOperationException("Functional operation can't have second logical operation");
    }

    @Override
    public void addArgument(Operation arg) {
        arguments.add(arg);
    }

    @Override
    public List<Operation> getArguments() {
        return arguments;
    }

    @Override
    public boolean isAvailableToInsert(String v, Set<String> free, boolean linked) {
        if (arguments.size() == 0 && name.equals(v))
            return !linked;
        boolean flag = true;
        for (Operation arg : arguments)
            flag &= arg.isAvailableToInsert(v, free, linked);
        return flag;
    }

    @Override
    public boolean isUseless() {
        return false;
    }

    @Override
    public Operation getFirstOperation() {
        throw new UnsupportedOperationException("Functional operation can't have first logical operation");
    }

    @Override
    public Operation getSecondOperation() {
        throw new UnsupportedOperationException("Functional operation can't have second logical operation");
    }

    @Override
    public Set<String> getFreeVariables() {
        Set<String> set = new HashSet<>();
        if (arguments.size() == 0)
            set.add(name);
        for (Operation op : arguments)
            set.addAll(op.getFreeVariables());
        return set;
    }

    @Override
    public void reconstruct() {
        for (Operation arg : arguments)
            arg.reconstruct();
    }

    public String getName() {
        return name;
    }

    @Override
    public void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions) {
        pw.print(name);
        if (arguments.size() > 0) pw.print("(");
        int i = 0;
        for (Operation arg : arguments) {
            arg.print(pw, true, substitutions);
            i++;
            if (i < arguments.size())
                pw.print(", ");
        }
        if (arguments.size() > 0) pw.print(")");
    }

    @Override
    public void print(boolean outside, Map<String, Operation> substitutions) {
        System.out.print(name);
        if (arguments.size() > 0) System.out.print("(");
        int i = 0;
        for (Operation arg : arguments) {
            arg.print(true, substitutions);
            i++;
            if (i < arguments.size())
                System.out.print(", ");
        }
        if (arguments.size() > 0) System.out.print(")");
    }

    public void printTree(int level, String operationName) {
        printLevel(level);
        System.out.println(operationName);
        for (Operation arg : arguments)
            arg.printTree(level + 1);
    }
}
