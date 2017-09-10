package com.lytr777;

import com.lytr777.propositionalCalculus.Expression;
import com.lytr777.propositionalCalculus.InitialData;
import com.lytr777.propositionalCalculus.parser.FirstHWLexer;
import com.lytr777.propositionalCalculus.parser.FirstHWParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Неверное число аргументов: " + args.length);
        }
        long start = System.currentTimeMillis();

        Path p = FileSystems.getDefault().getPath(".", args[1]);
        CharStream in = CharStreams.fromString(new String(Files.readAllBytes(p)));
        FirstHWLexer lexer = new FirstHWLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FirstHWParser parser = new FirstHWParser(tokens);

        PrintWriter pw = new PrintWriter(new FileWriter(args[2]));

        InitialData data;
        switch (args[0]) {
            case "1":
                parser.file();
                data = parser.data;
                data.prepare();
                HW1 hw1 = new HW1(data, pw);
                hw1.checkProof();
                break;

            case "2":
                parser.file();
                data = parser.data;
                data.prepare();
                HW2 hw2 = new HW2(data, pw);
                hw2.buildProof();
                break;

            case "3":
                data = new InitialData();
                data.setStatement(new Expression(parser.expression().op));
                data.prepare();
                HW3 hw3 = new HW3(data, pw);
                hw3.buildProof();
                break;
        }
        System.out.println((System.currentTimeMillis() - start) + "ms");
        pw.flush();
        pw.close();
    }
}
