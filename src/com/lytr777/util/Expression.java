package com.lytr777.util;

import com.lytr777.predicateСalculus.operations.AbstractFunctionalOperator;
import com.lytr777.predicateСalculus.operations.ExistenceQ;
import com.lytr777.predicateСalculus.operations.UniversalQ;
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
            if (op1.getType() == OperationType.FUNCTION || op1.getType() == OperationType.PREDICATE) {
                AbstractFunctionalOperator func1 = (AbstractFunctionalOperator) op1,
                        func2 = (AbstractFunctionalOperator) op2;
                if (func1.getName().equals(func2.getName())) {
                    List<Operation> args1 = func1.getArguments(),
                            args2 = func2.getArguments();
                    if (args1.size() == args2.size()) {
                        for (int i = 0; i < args1.size(); i++)
                            if (!equals(args1.get(i), args2.get(i)))
                                return false;
                        return true;
                    }
                }
                return false;
            }
            if (op1.getType() == OperationType.ZERO)
                return true;
            if (op1.getType() == OperationType.EXISTENCE_Q) {
                ExistenceQ eq1 = (ExistenceQ) op1,
                        eq2 = (ExistenceQ) op2;
                if (eq1.getVariable().equals(eq2.getVariable()) && equals(eq1.getFirstOperation(), eq2.getFirstOperation()))
                    return true;
                return false;
            }
            if (op1.getType() == OperationType.UNIVERSAL_Q) {
                UniversalQ uq1 = (UniversalQ) op1,
                        uq2 = (UniversalQ) op2;
                if (uq1.getVariable().equals(uq2.getVariable()) && equals(uq1.getFirstOperation(), uq2.getFirstOperation()))
                    return true;
                return false;
            }
            if (!equals(op1.getFirstOperation(), op2.getFirstOperation()))
                return false;
            if (op1.getType() != OperationType.NEGATION && op1.getType() != OperationType.SUCCESSOR)
                return equals(op1.getSecondOperation(), op2.getSecondOperation());
            return true;
        }
        return false;
    }
}
