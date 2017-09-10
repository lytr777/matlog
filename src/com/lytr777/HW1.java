package com.lytr777;

import com.lytr777.propositionalCalculus.Expression;
import com.lytr777.propositionalCalculus.InitialData;
import com.lytr777.propositionalCalculus.checkers.AxiomSchemes;
import javafx.util.Pair;

import java.io.PrintWriter;

/**
 * Created by lytr777 on 02/09/2017.
 */
public class HW1 {

    PrintWriter pw;
    InitialData data;

    public HW1(InitialData data, PrintWriter pw) {
        this.data = data;
        this.pw = pw;
    }

    public void checkProof() {
        printTitle();

        for (int i = 1; i <= data.proof.size(); i++) {
            if (i % 101 == 0)
                System.out.println("Прогресс: " + i);
            Expression e = data.proof.get(i - 1);
            pw.print("(" + i + ") ");
            e.print(pw);

            int j = AxiomSchemes.isAxiom(e);
            if (j > 0) {
                pw.println(" (Сх. акс. " + j + ")");
                continue;
            }

            j = data.assumptionList.isAssumption(e);
            if (j > 0) {
                pw.println(" (Предп. " + j + ")");
                continue;
            }

            Pair<Integer, Integer> mp = data.modusPonensChecker.isModusPonens(i - 1);
            if (mp.getKey() > 0) {
                pw.println(" (M.P. " + mp.getKey() + ", " + mp.getValue() + ")");
                continue;
            }

            pw.println(" (Не доказано)");
            System.out.println("Не доказана строка " + i);
        }
    }

    private void printTitle() {
        for (int i = 0; i < data.assumptions.size(); i++) {
            data.assumptions.get(i).print(pw);
            if (i < data.assumptions.size() -1)
                pw.print(",");
        }
        pw.print("|-");
        data.statement.print(pw);
        pw.println();
    }
}
