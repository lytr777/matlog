package com.lytr777.propositionalCalculus;

import com.lytr777.propositionalCalculus.operations.Operation;
import com.lytr777.propositionalCalculus.operations.OperationType;
import com.lytr777.propositionalCalculus.operations.Variable;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lytr777 on 15/08/2017.
 */
public class Expression {

    private Operation operation;

    public Expression(Operation op) {
        operation = op;
    }

    public Operation getOperation() {
        return operation;
    }

    public void reconstruct() {
        while (operation.isUseless())
            operation = operation.getFirstOperation();
        operation.reconstruct();
    }

    public List<Expression> getInsides() {
        List<Expression> insides = new LinkedList<>();
        if (operation.getType() != OperationType.VARIABLE) {
            if (operation.getType() != OperationType.NEGATION)
                insides.addAll(new Expression(operation.getSecondOperation()).getInsides());
            insides.addAll(new Expression(operation.getFirstOperation()).getInsides());
            insides.add(this);
        }
        return insides;
    }

    public void print() {
        print((Map<String, Operation>) null);
    }

    public void print(Map<String, Operation> substitutions) {
        operation.print(true, substitutions);
    }

    public void print(PrintWriter pw) {
        print(pw, null);
    }

    public void print(PrintWriter pw, Map<String, Operation> substitutions) {
        operation.print(pw, true, substitutions);
    }

    public boolean equalWith(Expression expression) {
        return equals(getOperation(), expression.getOperation());
    }

    private boolean equals(Operation op1, Operation op2) {
        if (op1.getType() == op2.getType()) {
            if (op1.getType() == OperationType.VARIABLE) {
                Variable var1 = (Variable) op1,
                        var2 = (Variable) op2;
                return var1.getName().equals(var2.getName());
            }
            if (!equals(op1.getFirstOperation(), op2.getFirstOperation()))
                return false;
            if (op1.getType() != OperationType.NEGATION && !equals(op1.getSecondOperation(), op2.getSecondOperation()))
                return false;
            return true;
        }
        return false;
    }
}
