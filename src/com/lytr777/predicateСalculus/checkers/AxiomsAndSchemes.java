package com.lytr777.predicateСalculus.checkers;

import com.lytr777.propositionalCalculus.operations.*;
import com.lytr777.predicateСalculus.operations.*;
import com.lytr777.propositionalCalculus.checkers.AxiomSchemes;
import com.lytr777.util.Expression;
import javafx.util.Pair;

import java.util.*;

/**
 * Created by lytr777 on 15/09/2017.
 */
public class AxiomsAndSchemes {

    public final static List<Expression> axioms;
    private final static Map<String, Operation> substitutions;

    static {
        axioms = new ArrayList<>();

        axioms.add(new Expression(new Implication(
                new Equality(
                        new Function("a"),
                        new Function("b")
                ),
                new Equality(
                        new Successor(new Function("a")),
                        new Successor(new Function("b"))
                )
        )));

        axioms.add(new Expression(new Implication(
                new Equality(
                        new Function("a"),
                        new Function("b")
                ),
                new Implication(
                        new Equality(
                                new Function("a"),
                                new Function("c")
                        ),
                        new Equality(
                                new Function("b"),
                                new Function("c")
                        )
                )
        )));

        axioms.add(new Expression(new Implication(
                new Equality(
                        new Successor(new Function("a")),
                        new Successor(new Function("b"))
                ),
                new Equality(
                        new Function("a"),
                        new Function("b")
                )
        )));

        axioms.add(new Expression(new Negation(new Equality(
                new Successor(new Function("a")),
                new Zero()
        ))));

        axioms.add(new Expression(new Equality(
                new Add(
                        new Function("a"),
                        new Successor(new Function("b"))
                ),
                new Successor(new Add(
                        new Function("a"),
                        new Function("b")
                ))
        )));

        axioms.add(new Expression(new Equality(
                new Add(
                        new Function("a"),
                        new Zero()
                ),
                new Function("a")
        )));

        axioms.add(new Expression(new Equality(
                new Mul(
                        new Function("a"),
                        new Zero()
                ),
                new Zero()
        )));

        axioms.add(new Expression(new Equality(
                new Mul(
                        new Function("a"),
                        new Successor(new Function("b"))
                ),
                new Add(
                        new Mul(
                                new Function("a"),
                                new Function("b")
                        ),
                        new Function("a")
                )
        )));

        substitutions = new HashMap<>();
    }

    public static int isAxiom(Expression expression) {
        for (int i = 0; i < axioms.size(); i++) { //8 predicate axioms
            if (equals(axioms.get(i).getOperation(), expression.getOperation()))
                return i + 1;
        }

        if (isInduction(expression))
            return 9;

        for (int i = 0; i < AxiomSchemes.schemes.size(); i++) { //10 propositional schemes
            substitutions.clear();
            if (equals(AxiomSchemes.schemes.get(i).getOperation(), expression.getOperation()))
                return i + 1;
        }

        if (is11Scheme(expression))
            return 11;
        if (is12Scheme(expression))
            return 12;

        return -1;
    }

    private static boolean is11Scheme(Expression expression) {
        if (expression.getOperation().getType() == OperationType.IMPLICATION) {
            Operation xphi = expression.getOperation().getFirstOperation(),
                    phi = expression.getOperation().getSecondOperation();

            if (xphi.getType() == OperationType.UNIVERSAL_Q) {
                UniversalQ uq = (UniversalQ) xphi;
                return checkSubstitution(uq.getFirstOperation(), phi, uq.getVariable());
            }
        }
        return false;
    }

    private static boolean is12Scheme(Expression expression) {
        if (expression.getOperation().getType() == OperationType.IMPLICATION) {
            Operation phi = expression.getOperation().getFirstOperation(),
                    xphi = expression.getOperation().getSecondOperation();

            if (xphi.getType() == OperationType.EXISTENCE_Q) {
                ExistenceQ eq = (ExistenceQ) xphi;
                return checkSubstitution(eq.getFirstOperation(), phi, eq.getVariable());
            }
        }
        return false;
    }

    private static boolean checkSubstitution(Operation base, Operation target, String v) {
        substitutions.clear();
        if (findSubstitutions(base, target, v)) {
            if (substitutions.size() == 0)
                return true;
            Operation substitution = substitutions.get(v);
            if (substitutions.size() == 1 && substitution != null) {
                return base.isAvailableToInsert(v, substitution.getFreeVariables(), false);
            }
        }
        return false;
    }

    private static boolean findSubstitutions(Operation base, Operation target, String v) {
        if (base.getType() == target.getType()) {
            if (base.getType() == OperationType.FUNCTION || base.getType() == OperationType.PREDICATE) {
                AbstractFunctionalOperator func1 = (AbstractFunctionalOperator) base,
                        func2 = (AbstractFunctionalOperator) target;
                if (func1.getName().equals(func2.getName())) {
                    List<Operation> args1 = func1.getArguments(),
                            args2 = func2.getArguments();
                    if (args1.size() == args2.size()) {
                        for (int i = 0; i < args1.size(); i++)
                            if (!findSubstitutions(args1.get(i), args2.get(i), v))
                                return false;
                        return true;
                    }
                }
                if (func1.getType() == OperationType.FUNCTION && func1.getArguments().size() == 0) {
                    Operation op = substitutions.get(func1.getName());
                    if (op != null)
                        return equals(op, target);
                    substitutions.put(func1.getName(), target);
                    return true;
                }
                return false;
            }
            if (base.getType() == OperationType.ZERO)
                return true;
            if (base.getType() == OperationType.EXISTENCE_Q) {
                ExistenceQ eq1 = (ExistenceQ) base,
                        eq2 = (ExistenceQ) target;
                if (eq1.getVariable().equals(eq2.getVariable()))
                    if (eq1.getVariable().equals(v)) return equals(eq1.getFirstOperation(), eq2.getFirstOperation());
                    else return findSubstitutions(eq1.getFirstOperation(), eq2.getFirstOperation(), v);
            }
            if (base.getType() == OperationType.UNIVERSAL_Q) {
                UniversalQ uq1 = (UniversalQ) base,
                        uq2 = (UniversalQ) target;
                if (uq1.getVariable().equals(v)) return equals(uq1.getFirstOperation(), uq2.getFirstOperation());
                else return findSubstitutions(uq1.getFirstOperation(), uq2.getFirstOperation(), v);
            }
            if (!findSubstitutions(base.getFirstOperation(), target.getFirstOperation(), v))
                return false;
            if (base.getType() != OperationType.NEGATION && base.getType() != OperationType.SUCCESSOR)
                return findSubstitutions(base.getSecondOperation(), target.getSecondOperation(), v);
            return true;
        }
        if (base.getType() == OperationType.FUNCTION) {
            Function function = (Function) base;
            if (function.getArguments().size() == 0) {
                Operation op = substitutions.get(function.getName());
                if (op != null)
                    return equals(op, target);
                substitutions.put(function.getName(), target);
                return true;
            }
        }
        return false;
    }

    private static boolean isInduction(Expression expression) {
        if (expression.getOperation().getType() == OperationType.IMPLICATION) {
            Operation fi = expression.getOperation().getSecondOperation();
            Set<String> free = fi.getFreeVariables();
            for (String v : free) {
                Operation pattern = new Implication(new Conjunction(
                        fi.replaceVariable(v, new Zero()),
                        new UniversalQ(v, new Implication(
                                fi,
                                fi.replaceVariable(v, new Successor(new Function(v)))
                        ))
                ), fi);
                if (equals(expression.getOperation(), pattern))
                    return true;
            }
        }
        return false;
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
                UniversalQ eq1 = (UniversalQ) sample,
                        eq2 = (UniversalQ) op2;
                if (eq1.getVariable().equals(eq2.getVariable()) && equals(eq1.getFirstOperation(), eq2.getFirstOperation()))
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
}
