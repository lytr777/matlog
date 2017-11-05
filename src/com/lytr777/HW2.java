package com.lytr777;

import com.lytr777.propositionalCalculus.checkers.AssumptionList;
import com.lytr777.propositionalCalculus.checkers.ModusPonensChecker;
import com.lytr777.util.Expression;
import com.lytr777.util.InitialData;
import com.lytr777.propositionalCalculus.checkers.AxiomSchemes;
import com.lytr777.propositionalCalculus.operations.Implication;
import com.lytr777.propositionalCalculus.operations.Operation;
import javafx.util.Pair;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lytr777 on 02/09/2017.
 */
public class HW2 {

    private PrintWriter pw;
    private InitialData data;
    private Expression targetAssumption;

    AssumptionList assumptionList;
    ModusPonensChecker modusPonensChecker;

    public HW2(InitialData data, PrintWriter pw) {
        this.data = data;
        this.pw = pw;
        targetAssumption = data.assumptions.remove(data.assumptions.size() - 1);
        assumptionList = new AssumptionList(data.assumptions);
        modusPonensChecker = new ModusPonensChecker(data.proof);
    }

    public void buildProof() {
        printTitle();
        for (int i = 1; i <= data.proof.size(); i++) {
            Expression e = data.proof.get(i - 1);

            if (AxiomSchemes.isAxiom(e) > 0)
                printFirstCase(e);
            else if (assumptionList.isAssumption(e) > 0)
                printFirstCase(e);
            else if (targetAssumption.equalWith(e))
                printSecondCase(e);
            else {
                Pair<Integer, Integer> mp = modusPonensChecker.isModusPonens(i - 1);
                if (mp.getKey() > 0)
                    printThirdCase(e, mp);
            }
        }
    }

    private void printTitle() {
        for (int i = 0; i < data.assumptions.size(); i++) {
            data.assumptions.get(i).print(pw);
            if (i < data.assumptions.size() - 1)
                System.out.print(",");
        }
        pw.print("|-");
        Expression newStatement = new Expression(new Implication(targetAssumption.getOperation(),
                data.statement.getOperation()));
        newStatement.print(pw);
        pw.println();
    }

    private void printFirstCase(Expression e) {
        Map<String, Operation> substitutions = new HashMap<>();
        substitutions.put("A", e.getOperation());
        substitutions.put("B", targetAssumption.getOperation());
        AxiomSchemes.printAxiom(pw,1, substitutions);
        pw.println();
        e.print(pw);
        pw.println();
        Expression newE = new Expression(new Implication(targetAssumption.getOperation(), e.getOperation()));
        newE.print(pw);
        pw.println();
    }

    private void printSecondCase(Expression e) {
        Map<String, Operation> substitutions = new HashMap<>();
        substitutions.put("A", targetAssumption.getOperation());
        substitutions.put("B", targetAssumption.getOperation());
        AxiomSchemes.printAxiom(pw,1, substitutions);
        pw.println();
        substitutions.replace("B", new Implication(targetAssumption.getOperation(), targetAssumption.getOperation()));
        AxiomSchemes.printAxiom(pw,1, substitutions);
        pw.println();
        substitutions.put("C", targetAssumption.getOperation());
        AxiomSchemes.printAxiom(pw,2, substitutions);
        pw.println();
        Expression i = new Expression(new Implication(
                new Implication(
                        targetAssumption.getOperation(),
                        new Implication(
                                new Implication(targetAssumption.getOperation(), targetAssumption.getOperation()),
                                targetAssumption.getOperation()
                        )
                ),
                new Implication(targetAssumption.getOperation(), targetAssumption.getOperation())
        ));
        i.print(pw);
        pw.println();
        Expression newE = new Expression(new Implication(targetAssumption.getOperation(),
                targetAssumption.getOperation()));
        newE.print(pw);
        pw.println();
    }

    private void printThirdCase(Expression e, Pair<Integer, Integer> mp) {
        Map<String, Operation> substitutions = new HashMap<>();
        substitutions.put("A", targetAssumption.getOperation());
        substitutions.put("B", data.proof.get(mp.getKey() - 1).getOperation());
        substitutions.put("C", e.getOperation());
        AxiomSchemes.printAxiom(pw,2, substitutions);
        pw.println();
        Expression i = new Expression(new Implication(
                new Implication(targetAssumption.getOperation(), data.proof.get(mp.getValue() - 1).getOperation()),
                new Implication(targetAssumption.getOperation(), e.getOperation())
        ));
        i.print(pw);
        pw.println();
        Expression newE = new Expression(new Implication(targetAssumption.getOperation(), e.getOperation()));
        newE.print(pw);
        pw.println();
    }
}
