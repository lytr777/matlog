package com.lytr777.propositionalCalculus.checkers;

import com.lytr777.predicateСalculus.operations.AbstractFunctionalOperator;
import com.lytr777.predicateСalculus.operations.ExistenceQ;
import com.lytr777.predicateСalculus.operations.UniversalQ;
import com.lytr777.util.Expression;
import com.lytr777.propositionalCalculus.operations.*;

import java.io.PrintWriter;
import java.util.*;

/**
 * Created by lytr777 on 20/08/2017.
 */
public class AxiomSchemes {

    public final static List<Expression> schemes;
    private final static Map<String, Operation> substitutions;

    static {
        schemes = new ArrayList<>();

        schemes.add(new Expression(new Implication(
                new Substitution("A"),
                new Implication(
                        new Substitution("B"),
                        new Substitution("A")
                )
        )));
        schemes.add(new Expression(new Implication(
                new Implication(
                        new Substitution("A"),
                        new Substitution("B")
                ),
                new Implication(
                        new Implication(
                                new Substitution("A"),
                                new Implication(
                                        new Substitution("B"),
                                        new Substitution("C")
                                )
                        ),
                        new Implication(
                                new Substitution("A"),
                                new Substitution("C")
                        )
                )
        )));
        schemes.add(new Expression(new Implication(
                new Substitution("A"),
                new Implication(
                        new Substitution("B"),
                        new Conjunction(
                                new Substitution("A"),
                                new Substitution("B")
                        )
                )
        )));
        schemes.add(new Expression(new Implication(
                new Conjunction(
                        new Substitution("A"),
                        new Substitution("B")
                ),
                new Substitution("A")
        )));
        schemes.add(new Expression(new Implication(
                new Conjunction(
                        new Substitution("A"),
                        new Substitution("B")
                ),
                new Substitution("B")
        )));
        schemes.add(new Expression(new Implication(
                new Substitution("A"),
                new Disjunction(
                        new Substitution("A"),
                        new Substitution("B")
                )
        )));
        schemes.add(new Expression(new Implication(
                new Substitution("B"),
                new Disjunction(
                        new Substitution("A"),
                        new Substitution("B")
                )
        )));
        schemes.add(new Expression(new Implication(
                new Implication(
                        new Substitution("A"),
                        new Substitution("C")
                ),
                new Implication(
                        new Implication(
                                new Substitution("B"),
                                new Substitution("C")
                        ),
                        new Implication(
                                new Disjunction(
                                        new Substitution("A"),
                                        new Substitution("B")
                                ),
                                new Substitution("C")
                        )
                )
        )));
        schemes.add(new Expression(new Implication(
                new Implication(
                        new Substitution("A"),
                        new Substitution("B")
                ),
                new Implication(
                        new Implication(
                                new Substitution("A"),
                                new Negation(new Substitution("B"))
                        ),
                        new Negation(new Substitution("A"))
                )
        )));
        schemes.add(new Expression(new Implication(
                new Negation(new Negation(new Substitution("A"))),
                new Substitution("A")
        )));

        substitutions = new HashMap<>();
    }

    public static int isAxiom(Expression expression) {
        for (int i = 0; i < schemes.size(); i++) {
            substitutions.clear();
            if (equals(schemes.get(i).getOperation(), expression.getOperation()))
                return i + 1;
        }
        return -1;
    }

    private static boolean equals(Operation sample, Operation op2) {
        if (sample.getType() == OperationType.SUBSTITUTION) {
            Substitution substitution = (Substitution) sample;
            Operation op = substitutions.get(substitution.getName());
            if (op != null)
                return equals(op, op2);
            substitutions.put(substitution.getName(), op2);
            return true;
        }
        if (sample.getType() == op2.getType()) {
            if (sample.getType() == OperationType.VARIABLE) {
                Variable var1 = (Variable) sample,
                        var2 = (Variable) op2;
                return var1.getName().equals(var2.getName());
            }
            if (sample.getType() == OperationType.FUNCTION || sample.getType() == OperationType.PREDICATE) {
                AbstractFunctionalOperator func1 = (AbstractFunctionalOperator) sample,
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
            if (sample.getType() == OperationType.ZERO)
                return true;
            if (sample.getType() == OperationType.EXISTENCE_Q) {
                ExistenceQ eq1 = (ExistenceQ) sample,
                        eq2 = (ExistenceQ) op2;
                if (eq1.getVariable().equals(eq2.getVariable()) && equals(eq1.getFirstOperation(), eq2.getFirstOperation()))
                    return true;
                return false;
            }
            if (sample.getType() == OperationType.UNIVERSAL_Q) {
                UniversalQ uq1 = (UniversalQ) sample,
                        uq2 = (UniversalQ) op2;
                if (uq1.getVariable().equals(uq2.getVariable()) && equals(uq1.getFirstOperation(), uq2.getFirstOperation()))
                    return true;
                return false;
            }
            if (!equals(sample.getFirstOperation(), op2.getFirstOperation()))
                return false;
            if (sample.getType() != OperationType.NEGATION && sample.getType() != OperationType.SUCCESSOR)
                return equals(sample.getSecondOperation(), op2.getSecondOperation());
            return true;
        }
        return false;
    }

    public static void printAxiom(PrintWriter pw, int index, Map<String, Operation> substitutions) {
        schemes.get(index - 1).print(pw, substitutions);
    }
}