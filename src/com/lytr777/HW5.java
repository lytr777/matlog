package com.lytr777;

import com.lytr777.predicateСalculus.operations.Predicate;
import com.lytr777.propositionalCalculus.operations.Implication;
import com.lytr777.util.Expression;

import java.io.PrintWriter;

/**
 * Created by lytr777 on 22/09/2017.
 */
public class HW5 {

    private Expression truE;
    private PrintWriter pw;
    private int a, b;

    public HW5(PrintWriter pw, int a, int b) {
        this.pw = pw;
        this.a = a;
        this.b = b;
        truE = new Expression(new Implication(new Predicate("A"), new Implication(
                new Predicate("B"),
                new Predicate("A")
        )));
    }

    public void buildProof() {
        printTitle();

        truE.print(pw);
        pw.println();

        base();
        if (b > 0) aEa();
        for (int i = 0; i < b; i++)
            step(i);
    }

    private void printTitle() {
        pw.print("|-");
        pw.print(getFormalNumber(a));
        pw.print("+");
        pw.print(getFormalNumber(b));
        pw.print("=");
        pw.println(getFormalNumber(a + b));
    }

    private void base() {
        pw.println("a+0=a");

        pw.print("(a+0=a)->(");
        truE.print(pw);
        pw.println(")->(a+0=a)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->(a+0=a)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@a(a+0=a)");

        pw.println("@a(a+0=a)");

        pw.println("@a(a+0=a)->(" + getFormalNumber(a) + "+0=" + getFormalNumber(a) + ")");

        pw.println(getFormalNumber(a) + "+0=" + getFormalNumber(a));
    }

    private void aEa() {
        pw.println("a=b->a=c->b=c");

        pw.print("(a=b->a=c->b=c)->(");
        truE.print(pw);
        pw.println(")->(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@c(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@b@c(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@a@b@c(a=b->a=c->b=c)");

        pw.println("@a@b@c(a=b->a=c->b=c)");
        pw.println("@a@b@c(a=b->a=c->b=c)->@b@c(a+0=b->a+0=c->b=c)");
        pw.println("@b@c(a+0=b->a+0=c->b=c)");
        pw.println("@b@c(a+0=b->a+0=c->b=c)->@c(a+0=a->a+0=c->a=c)");
        pw.println("@c(a+0=a->a+0=c->a=c)");
        pw.println("@c(a+0=a->a+0=c->a=c)->(a+0=a->a+0=a->a=a)");
        pw.println("a+0=a->a+0=a->a=a");
        pw.println("a+0=a");
        pw.println("a+0=a->a=a");
        pw.println("a=a");
    }

    private void step(int i) {
        String as = getFormalNumber(a),
                is = getFormalNumber(i),
                ss = getFormalNumber(a + i);

        //
        pw.println("a=b->a'=b'");

        pw.print("(a=b->a'=b')->(");
        truE.print(pw);
        pw.println(")->(a=b->a'=b')");

        pw.print("(");
        truE.print(pw);
        pw.println(")->(a=b->a'=b')");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@b(a=b->a'=b')");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@a@b(a=b->a'=b')");

        pw.println("@a@b(a=b->a'=b')");
        pw.println("@a@b(a=b->a'=b')->@b(" + as + "+" + is + "=b->(" + as + "+" + is + ")'=b')");
        pw.println("@b(" + as + "+" + is + "=b->(" + as + "+" + is + ")'=b')");
        pw.println("@b(" + as + "+" + is + "=b->(" + as + "+" + is + ")'=b')->(" +
                as + "+" + is + "=" + ss + "->(" + as + "+" + is + ")'=" + ss + "')");
        pw.println(as + "+" + is + "=" + ss + "->(" + as + "+" + is + ")'=" + ss + "'");
        pw.println("(" + as + "+" + is + ")'=" + ss + "'");

        //
        pw.println("a+b'=(a+b)'");

        pw.print("(a+b'=(a+b)')->(");
        truE.print(pw);
        pw.println(")->(a+b'=(a+b)')");

        pw.print("(");
        truE.print(pw);
        pw.println(")->(a+b'=(a+b)')");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@b(a+b'=(a+b)')");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@a@b(a+b'=(a+b)')");

        pw.println("@a@b(a+b'=(a+b)')");
        pw.println("@a@b(a+b'=(a+b)')->@b(" + as + "+b'=(" + as + "+b)')");
        pw.println("@b(" + as + "+b'=(" + as + "+b)')");
        pw.println("@b(" + as + "+b'=(" + as + "+b)')->(" + as + "+" + is + "'=(" + as + "+" + is + ")')");
        pw.println(as + "+" + is + "'=(" + as + "+" + is + ")'");

        //
        pw.println("a=b->a=c->b=c");

        pw.print("(a=b->a=c->b=c)->(");
        truE.print(pw);
        pw.println(")->(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@c(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@b@c(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@a@b@c(a=b->a=c->b=c)");

        pw.println("@a@b@c(a=b->a=c->b=c)");

        pw.println("@a@b@c(a=b->a=c->b=c)->@b@c((" + as + "+" + is + "')=b->(" + as + "+" + is + "')=c->b=c)");
        pw.println("@b@c((" + as + "+" + is + "')=b->(" + as + "+" + is + "')=c->b=c)");
        pw.println("@b@c((" + as + "+" + is + "')=b->(" + as + "+" + is + "')=c->b=c)->@c((" + as + "+" + is +
                "')=(" + as + "+" + is + ")'->(" + as + "+" + is + "')=c->(" + as + "+" + is + ")'=c)");
        pw.println("@c((" + as + "+" + is + "')=(" + as + "+" + is + ")'->(" + as + "+" + is + "')=c->("
                + as + "+" + is + ")'=c)");
        pw.println("@c((" + as + "+" + is + "')=(" + as + "+" + is + ")'->(" + as + "+" + is + "')=c->(" + as +
        "+" + is + ")'=c)->((" + as + "+" + is + "')=(" + as + "+" + is + ")'->(" + as + "+" + is + "')=" + as +
                "+" + is + "'->(" + as + "+" + is + ")'=" + as + "+" + is + "')");
        pw.println("(" + as + "+" + is + "')=(" + as + "+" + is + ")'->(" + as + "+" + is + "')=" + as + "+" +
                is + "'->(" + as + "+" + is + ")'=" + as + "+" + is + "'");
        pw.println("(" + as + "+" + is + "')=" + as + "+" + is + "'->(" + as + "+" + is + ")'=" + as + "+" + is + "'");

        //
        pw.print("(a=a)->(");
        truE.print(pw);
        pw.println(")->(a=a)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->(a=a)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@a(a=a)");

        pw.println("@a(a=a)");

        pw.println("@a(a=a)->(" + as + "+" + is + "'=" + as + "+" + is + "')");
        pw.println(as + "+" + is + "'=" + as + "+" + is + "'");

        pw.println("(" + as + "+" + is + ")'=" + as + "+" + is + "'");

        //
        pw.println("a=b->a=c->b=c");

        pw.print("(a=b->a=c->b=c)->(");
        truE.print(pw);
        pw.println(")->(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@c(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@b@c(a=b->a=c->b=c)");

        pw.print("(");
        truE.print(pw);
        pw.println(")->@a@b@c(a=b->a=c->b=c)");

        pw.println("@a@b@c(a=b->a=c->b=c)");

        pw.println("@a@b@c(a=b->a=c->b=c)->@b@c((" + as + "+" + is + ")'=b->(" + as + "+" + is + ")'=c->b=c)");
        pw.println("@b@c((" + as + "+" + is + ")'=b->(" + as + "+" + is + ")'=c->b=c)");
        pw.println("@b@c((" + as + "+" + is + ")'=b->(" + as + "+" + is + ")'=c->b=c)->@c((" + as + "+" + is +
                ")'=(" + as + "+" + is + "')->(" + as + "+" + is + ")'=c->(" + as + "+" + is + "')=c)");
        pw.println("@c((" + as + "+" + is + ")'=(" + as + "+" + is + "')->(" + as + "+" + is + ")'=c->(" + as +
                "+" + is + "')=c)");

        pw.println("@c((" + as + "+" + is + ")'=(" + as + "+" + is + "')->(" + as + "+" + is + ")'=c->(" + as +
                "+" + is + "')=c)->((" + as + "+" + is + ")'=(" + as + "+" + is + "')->(" + as + "+" + is +
                ")'=" + ss + "'->(" + as + "+" + is + "')=" + ss + "')");

        pw.println("((" + as + "+" + is + ")'=(" + as + "+" + is + "')->(" + as + "+" + is + ")'=" + ss +
                "'->(" + as + "+" + is + "')=" + ss + "')");

        //
        pw.println("(" + as + "+" + is + ")'=" + ss + "'->(" + as + "+" + is + "')=" + ss + "'");
        pw.println("(" + as + "+" + is + "')=" + ss + "'");
    }

    private String getFormalNumber(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        for (int i = 0; i < n; i++)
            sb.append("'");
        return sb.toString();
    }
}
