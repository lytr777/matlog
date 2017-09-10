package com.lytr777.util;

import com.lytr777.propositionalCalculus.Expression;
import com.lytr777.propositionalCalculus.checkers.AxiomSchemes;
import com.lytr777.propositionalCalculus.checkers.ModusPonensChecker;
import com.lytr777.propositionalCalculus.operations.Implication;
import com.lytr777.propositionalCalculus.operations.Operation;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lytr777 on 05/09/2017.
 */
public class DeductionTheorem {

    public static List<Expression> deduction(List<Expression> assumptions, List<Expression> proof) {
//        System.out.println("-------input-------");
//        System.out.println();
//        System.out.println("-------assumptions-------");
//        for (Expression e : assumptions) {
//            e.print();
//            System.out.println();
//        }
//        System.out.println("-------proof-------");
//        for (Expression e : proof) {
//            e.print();
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println("-------|||-------");
        List<Expression> list = new LinkedList<>();
        Expression target = assumptions.get(assumptions.size() - 1);
        ModusPonensChecker mpc = new ModusPonensChecker(proof);
        for (int i = 1; i <= proof.size(); i++) {
            Expression e = proof.get(i - 1);

            if (AxiomSchemes.isAxiom(e) > 0)
                list.addAll(getFirstCase(e, target));
            else if (isAssumption(assumptions, e))
                list.addAll(getFirstCase(e, target));
            else if (target.equalWith(e))
                list.addAll(getSecondCase(target));
            else {
                Pair<Integer, Integer> mp = mpc.isModusPonens(i - 1);
                if (mp.getKey() > 0)
                    list.addAll(getThirdCase(proof, e, target, mp));
                else {
                    System.out.print("Bad : ");
                    e.print();
                    System.out.println();
                }
            }
        }
//        System.out.println("-------output-------");
//        System.out.println();
//        for (Expression e : list) {
//            e.print();
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println("-------|||-------");
        return list;
    }

    private static boolean isAssumption(List<Expression> assumptions, Expression expression) {
        for (int i = 0; i < assumptions.size() - 1; i++) {
            if (expression.equalWith(assumptions.get(i)))
                return true;
        }
        return false;
    }

    private static List<Expression> getFirstCase(Expression e, Expression target) {
        List<Expression> list = new LinkedList<>();
        list.add(new Expression(new Implication(
                e.getOperation(),
                new Implication(
                        target.getOperation(),
                        e.getOperation()
                )
        )));
        list.add(new Expression(e.getOperation()));
        list.add(new Expression(new Implication(target.getOperation(), e.getOperation())));
        return list;
    }

    public static List<Expression> getAToA(Expression a) {
        return getSecondCase(a);
    }

    private static List<Expression> getSecondCase(Expression target) {
        List<Expression> list = new LinkedList<>();
        list.add(new Expression(new Implication(
                target.getOperation(),
                new Implication(
                        target.getOperation(),
                        target.getOperation()
                )
        )));
        list.add(new Expression(new Implication(
                target.getOperation(),
                new Implication(
                        new Implication(target.getOperation(), target.getOperation()),
                        target.getOperation()
                )
        )));
        list.add(new Expression(new Implication(
                new Implication(
                        target.getOperation(),
                        new Implication(target.getOperation(), target.getOperation())
                ),
                new Implication(
                        new Implication(
                                target.getOperation(),
                                new Implication(
                                        new Implication(target.getOperation(), target.getOperation()),
                                        target.getOperation()
                                )
                        ),
                        new Implication(target.getOperation(), target.getOperation())
                )
        )));
        list.add(new Expression(new Implication(
                new Implication(
                        target.getOperation(),
                        new Implication(
                                new Implication(target.getOperation(), target.getOperation()),
                                target.getOperation()
                        )
                ),
                new Implication(target.getOperation(), target.getOperation())
        )));
        list.add(new Expression(new Implication(target.getOperation(), target.getOperation())));
        return list;
    }

    private static List<Expression> getThirdCase(List<Expression> proof, Expression e, Expression target, Pair<Integer, Integer> mp) {
        List<Expression> list = new LinkedList<>();
        list.add(new Expression(new Implication(
                new Implication(
                        target.getOperation(),
                        proof.get(mp.getKey() - 1).getOperation()
                ),
                new Implication(
                        new Implication(
                                target.getOperation(),
                                new Implication(
                                        proof.get(mp.getKey() - 1).getOperation(),
                                        e.getOperation()
                                )
                        ),
                        new Implication(
                                target.getOperation(),
                                e.getOperation()
                        )
                )
        )));
        list.add(new Expression(new Implication(
                new Implication(target.getOperation(), proof.get(mp.getValue() - 1).getOperation()),
                new Implication(target.getOperation(), e.getOperation())
        )));
        list.add(new Expression(new Implication(target.getOperation(), e.getOperation())));
        return list;
    }
}
