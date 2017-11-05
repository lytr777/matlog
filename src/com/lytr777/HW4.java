package com.lytr777;

import com.lytr777.predicateСalculus.checkers.AxiomsAndSchemes;
import com.lytr777.predicateСalculus.checkers.InferenceRules;
import com.lytr777.predicateСalculus.operations.ExistenceQ;
import com.lytr777.predicateСalculus.operations.UniversalQ;
import com.lytr777.propositionalCalculus.checkers.AssumptionList;
import com.lytr777.propositionalCalculus.checkers.ModusPonensChecker;
import com.lytr777.propositionalCalculus.operations.Conjunction;
import com.lytr777.propositionalCalculus.operations.Implication;
import com.lytr777.propositionalCalculus.operations.Operation;
import com.lytr777.util.DeductionTheorem;
import com.lytr777.util.Expression;
import com.lytr777.util.InitialData;
import javafx.util.Pair;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lytr777 on 12/09/2017.
 */
public class HW4 {

    private int error;

    private PrintWriter pw;
    private InitialData data;
    private Expression targetAssumption;

    private InferenceRules inferenceRules;
    private AssumptionList assumptionList;
    private ModusPonensChecker modusPonensChecker;

    public HW4(InitialData data, PrintWriter pw) {
        this.data = data;
        this.pw = pw;
        inferenceRules = new InferenceRules(data.proof);
        if (data.assumptions.size() > 0)
            targetAssumption = data.assumptions.remove(data.assumptions.size() - 1);
        assumptionList = new AssumptionList(data.assumptions);
        modusPonensChecker = new ModusPonensChecker(data.proof);
        error = -1;
    }

    public int checkProof() {
        printTitle();

        for (int i = 1; i <= data.proof.size(); i++) {
            if (i % 101 == 0)
                System.out.println("Прогресс: " + i);
            Expression e = data.proof.get(i - 1);

            if (AxiomsAndSchemes.isAxiom(e) > 0) {
                printFirstCase(e);
            } else if (assumptionList.isAssumption(e) > 0) {
                printFirstCase(e);
            } else if (targetAssumption != null && e.equalWith(targetAssumption)) {
                for (Expression aa : DeductionTheorem.getAToA(e)) {
                    aa.print(pw);
                    pw.println();
                }
            } else {
                Pair<Integer, Integer> mp = modusPonensChecker.isModusPonens(i - 1);
                if (mp.getKey() > 0) {
                    if (targetAssumption != null) {
                        for (Expression aa : DeductionTheorem.getMP(data.proof, e, targetAssumption, mp)) {
                            aa.print(pw);
                            pw.println();
                        }
                    } else {
                        e.print(pw);
                        pw.println();
                    }
                    continue;
                }

                Pair<Integer, String> ir = inferenceRules.isInferenceRule(i - 1);
                if (ir.getKey() == 1) {
                    if (targetAssumption != null) {
                        if (!targetAssumption.getOperation().getFreeVariables().contains(ir.getValue())) {
                            printUniversalQRule(e);
                            continue;
                        }
                    } else {
                        e.print(pw);
                        pw.println();
                        continue;
                    }
                }
                if (ir.getKey() == 2) {
                    if (targetAssumption != null) {
                        if (!targetAssumption.getOperation().getFreeVariables().contains(ir.getValue())) {
                            printExistenceQRule(e);
                            continue;
                        }
                    } else {
                        e.print(pw);
                        pw.println();
                        continue;
                    }
                }

                error = i;
                break;
            }
        }

        return error;
    }

    private void printTitle() {
        for (int i = 0; i < data.assumptions.size(); i++) {
            data.assumptions.get(i).print(pw);
            if (i < data.assumptions.size() - 1)
                pw.print(",");
        }
        pw.print("|-");
        if (targetAssumption != null)
            new Expression(new Implication(targetAssumption.getOperation(), data.statement.getOperation())).print(pw);
        else
            data.statement.print(pw);
        pw.println();
    }

    private void printFirstCase(Expression e) {
        if (targetAssumption != null) {
            for (Expression aa : DeductionTheorem.getFirstCase(e, targetAssumption)) {
                aa.print(pw);
                pw.println();
            }
        } else {
            e.print(pw);
            pw.println();
        }
    }

    private void printUniversalQRule(Expression e) {
        Operation psi = e.getOperation().getFirstOperation(),
                fi = e.getOperation().getSecondOperation().getFirstOperation();
        String v = ((UniversalQ) e.getOperation().getSecondOperation()).getVariable();

        //lemma2
        List<Expression> assumptions = new ArrayList<>(),
                proof = new ArrayList<>();
        assumptions.add(new Expression(new Implication(targetAssumption.getOperation(), new Implication(psi, fi))));
        assumptions.add(new Expression(new Conjunction(targetAssumption.getOperation(), psi)));

        proof.add(new Expression(new Implication(
                new Conjunction(targetAssumption.getOperation(), psi),
                targetAssumption.getOperation()
        )));
        proof.add(new Expression(new Conjunction(targetAssumption.getOperation(), psi)));
        proof.add(targetAssumption);
        proof.add(new Expression(new Implication(new Conjunction(targetAssumption.getOperation(), psi), psi)));
        proof.add(new Expression(psi));
        proof.add(new Expression(new Implication(targetAssumption.getOperation(), new Implication(psi, fi))));
        proof.add(new Expression(new Implication(psi, fi)));
        proof.add(new Expression(fi));
        fullDeduction(assumptions, proof);
        //

        new Expression(new Implication(new Conjunction(targetAssumption.getOperation(), psi), fi)).print(pw);
        pw.println();
        new Expression(new Implication(
                new Conjunction(targetAssumption.getOperation(), psi),
                new UniversalQ(v, fi)
        )).print(pw);
        pw.println();

        //lemma1
        assumptions = new ArrayList<>();
        proof = new ArrayList<>();
        assumptions.add(new Expression(new Implication(
                new Conjunction(targetAssumption.getOperation(), psi),
                new UniversalQ(v, fi)
        )));
        assumptions.add(targetAssumption);
        assumptions.add(new Expression(psi));

        proof.add(targetAssumption);
        proof.add(new Expression(psi));
        proof.add(new Expression(new Implication(targetAssumption.getOperation(), new Implication(
                psi,
                new Conjunction(targetAssumption.getOperation(), psi)
        ))));
        proof.add(new Expression(new Implication(psi, new Conjunction(targetAssumption.getOperation(), psi))));
        proof.add(new Expression(new Conjunction(targetAssumption.getOperation(), psi)));
        proof.add(new Expression(new Implication(
                new Conjunction(targetAssumption.getOperation(), psi),
                new UniversalQ(v, fi)
        )));
        proof.add(new Expression(new UniversalQ(v, fi)));
        fullDeduction(assumptions, proof);
        //
        new Expression(new Implication(targetAssumption.getOperation(), e.getOperation())).print(pw);
        pw.println();
    }

    private void printExistenceQRule(Expression e) {
        Operation psi = e.getOperation().getFirstOperation().getFirstOperation(),
                fi = e.getOperation().getSecondOperation();
        String v = ((ExistenceQ) e.getOperation().getFirstOperation()).getVariable();

        permutation(targetAssumption.getOperation(), psi, fi);

        new Expression(new Implication(targetAssumption.getOperation(), new Implication(psi, fi))).print(pw);
        pw.println();
        new Expression(new Implication(psi, new Implication(targetAssumption.getOperation(), fi))).print(pw);
        pw.println();
        new Expression(new Implication(new ExistenceQ(v, psi), new Implication(
                targetAssumption.getOperation(),
                fi
        ))).print(pw);
        pw.println();

        permutation(new ExistenceQ(v, psi), targetAssumption.getOperation(), fi);

        new Expression(new Implication(targetAssumption.getOperation(), e.getOperation())).print(pw);
        pw.println();
    }

    private void permutation(Operation a, Operation psi, Operation fi) {
        List<Expression> assumptions = new ArrayList<>(),
                proof = new ArrayList<>();
        assumptions.add(new Expression(new Implication(a, new Implication(psi, fi))));
        assumptions.add(new Expression(psi));
        assumptions.add(new Expression(a));

        proof.add(new Expression(new Implication(a, new Implication(psi, fi))));
        proof.add(new Expression(a));
        proof.add(new Expression(new Implication(psi, fi)));
        proof.add(new Expression(psi));
        proof.add(new Expression(fi));

        fullDeduction(assumptions, proof);
    }

    private void fullDeduction(List<Expression> assumptions, List<Expression> proof) {
        while (!assumptions.isEmpty()) {
            proof = DeductionTheorem.deduction(assumptions, proof);
            assumptions.remove(assumptions.size() - 1);
        }
        for (Expression aa : proof) {
            aa.print(pw);
            pw.println();
        }
    }
}
