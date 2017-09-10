package com.lytr777.util;

import com.lytr777.propositionalCalculus.Expression;
import com.lytr777.propositionalCalculus.operations.Implication;
import com.lytr777.propositionalCalculus.operations.Negation;
import com.lytr777.propositionalCalculus.operations.Operation;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lytr777 on 08/09/2017.
 */
public class Prover {

    public static List<Expression> prove(Expression target, Map<String, Boolean> values) {
        switch (target.getOperation().getType()) {
            case NEGATION:
                return proveNegation(target, values);
            case IMPLICATION:
                return proveImplication(target, values);
            case CONJUNCTION:
                return proveConjunction(target, values);
            case DISJUNCTION:
                return proveDisjunction(target, values);
            default:
                return new LinkedList<>();
        }
    }

    private static List<Expression> proveDisjunction(Expression target, Map<String, Boolean> values) {
        Operation first = target.getOperation().getFirstOperation(),
                second = target.getOperation().getSecondOperation(),
                mainVariable;

        List<Expression> list = new LinkedList<>();
        if (!first.isTrueOn(values) && !second.isTrueOn(values) && !target.getOperation().isTrueOn(values)) {
//            System.out.println("marked");
//            for (Map.Entry<String, Boolean> entry : values.entrySet())
//                System.out.println(entry.getKey() + " " + entry.getValue());
            List<Expression> sublist = new LinkedList<>();
            sublist.add(new Expression(new Negation(first)));
            sublist.add(new Expression(new Negation(second)));
            sublist.add(target);
            sublist.addAll(DeductionTheorem.getAToA(new Expression(first)));

            list.add(new Expression(new Negation(first)));
            list.add(new Expression(new Negation(second)));
            list.add(new Expression(new Implication(
                    new Implication(target.getOperation(), first),
                    new Implication(
                            new Implication(target.getOperation(), new Negation(first)),
                            new Negation(target.getOperation())
                    )
            )));
            list.add(new Expression(new Implication(
                    new Negation(first),
                    new Implication(target.getOperation(), new Negation(first))
            )));
            list.add(new Expression(new Implication(target.getOperation(), new Negation(first))));

            List<Expression> deductionAssumptions = new LinkedList<>(), deductionProof = new LinkedList<>();
            deductionAssumptions.add(new Expression(new Negation(first)));
            deductionAssumptions.add(new Expression(new Negation(second)));
            deductionAssumptions.add(target);

            deductionProof.addAll(sublist);
            deductionProof.addAll(proveNotFirstNotSecondImplication(second, first));
            deductionProof.add(new Expression(new Implication(second, first)));
            deductionProof.add(new Expression(new Implication(
                    new Implication(first, first),
                    new Implication(
                            new Implication(second, first),
                            new Implication(target.getOperation(), first)
                    )
            )));
            deductionProof.add(new Expression(new Implication(
                    new Implication(second, first),
                    new Implication(target.getOperation(), first)
            )));
            deductionProof.add(new Expression(new Implication(target.getOperation(), first)));
            deductionProof.add(new Expression(first));

            list.addAll(DeductionTheorem.deduction(deductionAssumptions, deductionProof));
            list.add(new Expression(new Implication(target.getOperation(), first)));
            list.add(new Expression(new Implication(
                    new Implication(target.getOperation(), new Negation(first)),
                    new Negation(target.getOperation()))));
            list.add(new Expression(new Negation(target.getOperation())));
            return list;
        }

        if (!first.isTrueOn(values) && second.isTrueOn(values) && target.getOperation().isTrueOn(values)) {
            mainVariable = second;
        } else {
            mainVariable = first;
        }
        list.add(new Expression(mainVariable));
        list.add(new Expression(new Implication(mainVariable, target.getOperation())));
        list.add(target);
        return list;
    }

    private static List<Expression> proveConjunction(Expression target, Map<String, Boolean> values) {
        Operation first = target.getOperation().getFirstOperation(),
                second = target.getOperation().getSecondOperation(),
                mainVariable;

        List<Expression> list = new LinkedList<>();
        if (first.isTrueOn(values) && second.isTrueOn(values) && target.getOperation().isTrueOn(values)) {
            list.add(new Expression(first));
            list.add(new Expression(second));
            list.add(new Expression(new Implication(
                    first,
                    new Implication(second, target.getOperation())
            )));
            list.add(new Expression(new Implication(second, target.getOperation())));
            list.add(target);
            return list;
        }
        if (first.isTrueOn(values) && !second.isTrueOn(values) && !target.getOperation().isTrueOn(values))
            mainVariable = second;
        else
            mainVariable = first;
        list.add(new Expression(new Negation(mainVariable)));
        list.add(new Expression(new Implication(
                new Implication(target.getOperation(), mainVariable),
                new Implication(
                        new Implication(target.getOperation(), new Negation(mainVariable)),
                        new Negation(target.getOperation()))
        )));
        list.add(new Expression(new Implication(target.getOperation(), mainVariable)));
        list.add(new Expression(new Implication(
                new Implication(target.getOperation(), new Negation(mainVariable)),
                new Negation(target.getOperation())
        )));
        list.add(new Expression(new Implication(
                new Negation(mainVariable),
                new Implication(target.getOperation(), new Negation(mainVariable))
        )));
        list.add(new Expression(new Implication(target.getOperation(), new Negation(mainVariable))));
        list.add(new Expression(new Negation(target.getOperation())));
        return list;
    }

    private static List<Expression> proveImplication(Expression target, Map<String, Boolean> values) {
        Operation first = target.getOperation().getFirstOperation(),
                second = target.getOperation().getSecondOperation();

        if (!first.isTrueOn(values) && !second.isTrueOn(values) && target.getOperation().isTrueOn(values)) {
            return proveNotFirstNotSecondImplication(first, second);
        }

        List<Expression> list = new LinkedList<>();
        if (first.isTrueOn(values) && !second.isTrueOn(values) && !target.getOperation().isTrueOn(values)) {
            list.add(new Expression(first));
            list.add(new Expression(new Negation(second)));
            list.add(new Expression(new Implication(
                    new Negation(second),
                    new Implication(target.getOperation(), new Negation(second))
            )));
            list.add(new Expression(new Negation(second)));
            list.add(new Expression(new Implication(target.getOperation(), new Negation(second))));

            List<Expression> deductionAssumptions = new LinkedList<>(), deductionProof = new LinkedList<>();
            deductionAssumptions.add(new Expression(first));
            deductionAssumptions.add(new Expression(new Negation(second)));
            deductionAssumptions.add(target);
            deductionProof.add(new Expression(first));
            deductionProof.add(target);
            deductionProof.add(new Expression(second));
            list.addAll(DeductionTheorem.deduction(deductionAssumptions, deductionProof));

            list.add(new Expression(new Implication(
                    new Implication(target.getOperation(), second),
                    new Implication(
                            new Implication(target.getOperation(), new Negation(second)),
                            new Negation(target.getOperation())
                    )
            )));
            list.add(new Expression(new Implication(
                    new Implication(target.getOperation(), new Negation(second)),
                    new Negation(target.getOperation())
            )));
            ///here 2 lines remove
            list.add(new Expression(new Negation(target.getOperation())));
            return list;
        }

        list.add(new Expression(second));
        list.add(new Expression(new Implication(second, target.getOperation())));
        list.add(target);
        return list;
    }

    private static List<Expression> proveNotFirstNotSecondImplication(Operation first, Operation second) {
        List<Expression> deductionAssumptions = new LinkedList<>(), deductionProof = new LinkedList<>();

        deductionAssumptions.add(new Expression(new Negation(first)));
        deductionAssumptions.add(new Expression(new Negation(second)));
        deductionAssumptions.add(new Expression(first));

        deductionProof.add(new Expression(new Implication(
                new Implication(new Negation(second), first),
                new Implication(
                        new Implication(new Negation(second), new Negation(first)),
                        new Negation(new Negation(second))
                )
        )));
        deductionProof.add(new Expression(first));
        deductionProof.add(new Expression(new Implication(
                first,
                new Implication(new Negation(second), first))));
        deductionProof.add(new Expression(new Implication(new Negation(second), first)));
        deductionProof.add(new Expression(new Implication(
                new Implication(
                        new Negation(second),
                        new Negation(first)
                ),
                new Negation(new Negation(second))
        )));
        deductionProof.add(new Expression(new Negation(first)));
        deductionProof.add(new Expression(new Implication(
                new Negation(first),
                new Implication(new Negation(second), new Negation(first))
        )));
        deductionProof.add(new Expression(new Implication(new Negation(second), new Negation(first))));
        deductionProof.add(new Expression(new Negation(new Negation(second))));
        deductionProof.add(new Expression(new Implication(new Negation(new Negation(second)), second)));
        deductionProof.add(new Expression(second));

        return DeductionTheorem.deduction(deductionAssumptions, deductionProof);
    }

    private static List<Expression> proveNegation(Expression target, Map<String, Boolean> values) {
        Operation first = target.getOperation().getFirstOperation();

        List<Expression> list = new LinkedList<>();
        if (!first.isTrueOn(values) && target.getOperation().isTrueOn(values))
            list.add(target);
        else {
            list.add(new Expression(first));
            list.add(new Expression(new Implication(first, new Implication(new Negation(first), first))));
            list.add(new Expression(new Implication(new Negation(first), first)));
            list.add(new Expression(new Implication(
                    new Negation(first),
                    new Implication(new Negation(first), new Negation(first)))));
            list.add(new Expression(new Implication(
                    new Implication(new Negation(first), new Implication(new Negation(first), new Negation(first))),
                    new Implication(
                            new Implication(
                                    new Negation(first),
                                    new Implication(
                                            new Implication(new Negation(first), new Negation(first)),
                                            new Negation(first)
                                    )
                            ),
                            new Implication(new Negation(first), new Negation(first))
                    )
            )));
            list.add(new Expression(new Implication(
                    new Implication(
                            new Negation(first),
                            new Implication(
                                    new Implication(new Negation(first), new Negation(first)),
                                    new Negation(first)
                            )
                    ),
                    new Implication(new Negation(first), new Negation(first))
            )));
            list.add(new Expression(new Implication(
                    new Negation(first),
                    new Implication(
                            new Implication(new Negation(first), new Negation(first)),
                            new Negation(first)
                    )
            )));
            list.add(new Expression(new Implication(new Negation(first), new Negation(first))));
            list.add(new Expression(new Implication(
                    new Implication(new Negation(first), first),
                    new Implication(
                            new Implication(new Negation(first), new Negation(first)),
                            new Negation(new Negation(first))
                    )
            )));
            list.add(new Expression(new Implication(
                    new Implication(new Negation(first), new Negation(first)),
                    new Negation(new Negation(first))
            )));
            list.add(new Expression(new Negation(new Negation(first))));
        }
        return list;
    }
}
