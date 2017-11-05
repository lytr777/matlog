package com.lytr777;

import com.lytr777.util.Expression;
import com.lytr777.util.InitialData;
import com.lytr777.propositionalCalculus.operations.*;
import com.lytr777.util.DeductionTheorem;
import com.lytr777.util.Prover;

import java.io.PrintWriter;
import java.util.*;

/**
 * Created by lytr777 on 04/09/2017.
 */
public class HW3 {

    private PrintWriter pw;
    private InitialData data;
    private List<String> variableList;

    public HW3(InitialData data, PrintWriter pw) {
        this.data = data;
        this.pw = pw;
    }

    public void buildProof() {
        Set<String> variables = new HashSet<>();
        getVariableList(data.statement.getOperation(), variables);

        variableList = new ArrayList<>(variables);
        List<Map<String, Boolean>> valuesMap = new ArrayList<>();
        generateValues(variableList.size() - 1, new HashMap<>(), valuesMap);

        for (Map<String, Boolean> map : valuesMap) {
            if (!data.statement.getOperation().isTrueOn(map)) {
                pw.print("Высказывание ложно при ");
                int i = 0;
                for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                    pw.print(entry.getKey() + "=" + (entry.getValue() ? "И" : "Л"));
                    i++;
                    if (i < variableList.size())
                        pw.print(", ");
                }
                return;
            }
        }
        pw.print("|-");
        data.statement.print(pw);
        pw.println();
        List<String> variablesCopy = new ArrayList<>(variableList);
        for (Expression e : getProof(variablesCopy, new LinkedList<>())) {
            e.print(pw);
            pw.println();
        }
    }

    private void getVariableList(Operation operation, Set<String> variables) {
        if (operation.getType() == OperationType.VARIABLE) {
            Variable var = (Variable) operation;
            variables.add(var.getName());
            return;
        }
        getVariableList(operation.getFirstOperation(), variables);
        if (operation.getType() != OperationType.NEGATION)
            getVariableList(operation.getSecondOperation(), variables);
    }

    private void generateValues(int i, Map<String, Boolean> current, List<Map<String, Boolean>> valuesMap) {
        if (i < 0) {
            valuesMap.add(current);
            return;
        }
        Map<String, Boolean> copy = new HashMap<>(current);
        current.put(variableList.get(i), false);
        generateValues(i - 1, current, valuesMap);
        copy.put(variableList.get(i), true);
        generateValues(i - 1, copy, valuesMap);
    }

    private List<Expression> getProof(List<String> variables, List<Expression> assumptions) {
        if (!variables.isEmpty()) {
            Variable var = new Variable(variables.remove(0));
            Expression v = new Expression(var);
            Expression notV = new Expression(new Negation(var));
            List<Expression> list = new LinkedList<>(),
                    copy = new LinkedList<>(assumptions);
            List<String> variablesCopy = new ArrayList<>(variables);
            assumptions.add(v);
            copy.add(notV);
            List<Expression> trueCopy = new LinkedList<>(assumptions),
                    notTrueCopy = new LinkedList<>(copy);
            list.addAll(DeductionTheorem.deduction(assumptions, getProof(variables, trueCopy)));
            list.addAll(DeductionTheorem.deduction(copy, getProof(variablesCopy, notTrueCopy)));
            list.addAll(aOrNotA(v));
            list.addAll(aEnd(v));
            return list;
        }
        return getBaseProof(data.statement.getInsides(), getValues(assumptions));
    }

    private List<Expression> getBaseProof(List<Expression> targets, Map<String, Boolean> values) {
        Set<Expression> proved = new HashSet<>();
        List<Expression> proof = new LinkedList<>();
        for (Expression target : targets) {
            if (!proved.contains(target)) {
                proof.addAll(Prover.prove(target, values));
                proved.add(target);
            }
        }
        return proof;
    }

    private Map<String, Boolean> getValues(List<Expression> variables) {
        Map<String, Boolean> values = new HashMap<>();
        for (Expression expression : variables) {
            Operation op = expression.getOperation();
            if (op.getType() == OperationType.VARIABLE) {
                Variable variable = (Variable) op;
                values.put(variable.getName(), true);
            } else if (op.getType() == OperationType.NEGATION &&
                    op.getFirstOperation().getType() == OperationType.VARIABLE) {
                Variable variable = (Variable) op.getFirstOperation();
                values.put(variable.getName(), false);
            }
        }
        return values;
    }

    private List<Expression> aOrNotA(Expression a) {
        List<Expression> proof = new LinkedList<>();
        Operation aOp = a.getOperation();

        proof.add(new Expression(new Implication(
                a.getOperation(),
                new Disjunction(aOp, new Negation(aOp)))));
        proof.addAll(counterPosition(new Expression(aOp), new Expression(new Disjunction(aOp, new Negation(aOp)))));
        proof.add(new Expression(new Implication(
                new Negation(new Disjunction(aOp, new Negation(aOp))),
                new Negation(aOp))
        ));
        proof.add(new Expression(new Implication(
                new Negation(aOp),
                new Disjunction(aOp, new Negation(aOp)))
        ));
        proof.addAll(counterPosition(new Expression(new Negation(aOp)), new Expression(new Disjunction(aOp, new Negation(aOp)))));
        proof.add(new Expression(new Implication(
                new Negation(new Disjunction(aOp, new Negation(aOp))),
                new Negation(new Negation(aOp)))
        ));
        proof.add(new Expression(new Implication(
                new Implication(
                        new Negation(new Disjunction(aOp, new Negation(aOp))),
                        new Negation(aOp)),
                new Implication(
                        new Implication(
                                new Negation(new Disjunction(aOp, new Negation(aOp))),
                                new Negation(new Negation(aOp))),
                        new Negation(new Negation(new Disjunction(aOp, new Negation(aOp))))
                )
        )));
        proof.add(new Expression(new Implication(
                new Implication(
                        new Negation(new Disjunction(aOp, new Negation(aOp))),
                        new Negation(new Negation(aOp))),
                new Negation(new Negation(new Disjunction(aOp, new Negation(aOp))))
        )));
        proof.add(new Expression(new Negation(new Negation(new Disjunction(aOp, new Negation(aOp))))));
        proof.add(new Expression(new Implication(
                new Negation(new Negation(new Disjunction(aOp, new Negation(aOp)))),
                new Disjunction(aOp, new Negation(aOp))
        )));
        proof.add(new Expression(new Disjunction(aOp, new Negation(aOp))));
        return proof;
    }

    private List<Expression> counterPosition(Expression a, Expression b) {
        Operation aOp = a.getOperation(), bOp = b.getOperation();
        List<Expression> impl = new LinkedList<>(), proof = new LinkedList<>();
        impl.add(new Expression(new Implication(aOp, bOp)));
        List<Expression> copy = new LinkedList<>(impl);
        copy.add(new Expression(new Negation(bOp)));

        proof.add(new Expression(new Implication(
                new Implication(aOp, bOp),
                new Implication(new Implication(aOp, new Negation(bOp)), new Negation(aOp))
        )));
        proof.add(new Expression(new Implication(aOp, bOp)));
        proof.add(new Expression(new Implication(
                new Implication(aOp, new Negation(bOp)),
                new Negation(aOp)
        )));
        proof.add(new Expression(new Implication(
                new Negation(bOp),
                new Implication(aOp, new Negation(bOp)))
        ));
        proof.add(new Expression(new Negation(bOp)));
        proof.add(new Expression(new Implication(aOp, new Negation(bOp))));
        proof.add(new Expression(new Negation(aOp)));

        return DeductionTheorem.deduction(impl, DeductionTheorem.deduction(copy, proof));
    }

    private List<Expression> aEnd(Expression v) {
        List<Expression> list = new LinkedList<>();
        list.add(new Expression(new Implication(
                new Implication(v.getOperation(), data.statement.getOperation()),
                new Implication(
                        new Implication(new Negation(v.getOperation()), data.statement.getOperation()),
                        new Implication(
                                new Disjunction(v.getOperation(), new Negation(v.getOperation())),
                                data.statement.getOperation()
                        )
                )
        )));
        list.add(new Expression(new Implication(
                new Implication(new Negation(v.getOperation()), data.statement.getOperation()),
                new Implication(
                        new Disjunction(v.getOperation(), new Negation(v.getOperation())),
                        data.statement.getOperation()
                )
        )));
        list.add(new Expression(
                new Implication(
                        new Disjunction(v.getOperation(), new Negation(v.getOperation())),
                        data.statement.getOperation()
                )
        ));
        list.add(data.statement);
        return list;
    }
}
