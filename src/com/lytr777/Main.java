package com.lytr777;

import com.lytr777.predicateСalculus.parser.PredicateLexer;
import com.lytr777.predicateСalculus.parser.PredicateParser;
import com.lytr777.util.Expression;
import com.lytr777.util.InitialData;
import com.lytr777.propositionalCalculus.parser.PropositionalLexer;
import com.lytr777.propositionalCalculus.parser.PropositionalParser;
import javafx.util.Pair;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Неверное число аргументов: " + args.length);
        }
        long start = System.currentTimeMillis();

        Path p = FileSystems.getDefault().getPath(".", args[1]);
        CharStream in = CharStreams.fromString(new String(Files.readAllBytes(p)));

        PrintWriter pw = new PrintWriter(new FileWriter(args[2]));

        InitialData data;
        PropositionalParser propositionalParser;
        PredicateParser predicateParser;
        switch (args[0]) {
            case "1":
                propositionalParser = createPropositionParser(in);
                propositionalParser.file();
                data = propositionalParser.data;
                data.prepare();
                HW1 hw1 = new HW1(data, pw);
                hw1.checkProof();
                break;

            case "2":
                propositionalParser = createPropositionParser(in);
                propositionalParser.file();
                data = propositionalParser.data;
                data.prepare();
                HW2 hw2 = new HW2(data, pw);
                hw2.buildProof();
                break;

            case "3":
                propositionalParser = createPropositionParser(in);
                data = new InitialData();
                data.setStatement(new Expression(propositionalParser.expression().op));
                data.prepare();
                HW3 hw3 = new HW3(data, pw);
                hw3.buildProof();
                break;
            case "4":
                predicateParser = createPredicateParser(in);
                predicateParser.setBuildParseTree(false);
                //1
//                predicateParser.file();
//                data = predicateParser.data;
//                HW4 hw4 = new HW4(data, pw);
//                int code = hw4.checkProof();
//                if (code > 0) {
//                    pw.flush();
//                    pw.close();
//                    pw = new PrintWriter(new FileWriter(args[2]));
//                    pw.println("Вывод некоректен начиная с формулы номер " + code);
//                }

                //2
                predicateParser.sequentialFile(pw, args[2]);
                break;
            case "5":
                predicateParser = createPredicateParser(in);
                Pair<Integer, Integer> ab = predicateParser.five().ab;
                HW5 hw5 = new HW5(pw, ab.getKey(), ab.getValue());
                hw5.buildProof();
                break;
            default:
                System.out.println("Номер задания может быть только от 1 до 5");
        }
        System.out.println((System.currentTimeMillis() - start) + "ms");
        pw.flush();
        pw.close();
    }

    private static PropositionalParser createPropositionParser(CharStream in) {
        PropositionalLexer lexer = new PropositionalLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new PropositionalParser(tokens);
    }

    private static PredicateParser createPredicateParser(CharStream in) {
        PredicateLexer lexer = new PredicateLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new PredicateParser(tokens);
    }
}
