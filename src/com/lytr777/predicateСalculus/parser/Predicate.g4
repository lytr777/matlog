grammar Predicate;

@parser::header {
import com.lytr777.propositionalCalculus.operations.*;
import com.lytr777.predicateСalculus.operations.*;
import com.lytr777.predicateСalculus.operations.Predicate;
import com.lytr777.util.Expression;
import com.lytr777.util.InitialData;
import javafx.util.Pair;
}

@parser::members {
public InitialData data = new InitialData();
public int lines = 0;
}

file
    : title '\n' (expression '\n' { data.addProofExpression(new Expression($expression.op)); lines += 1; if (lines % 500 == 0) System.out.println("Прочитано " + lines + " строк");} )*
    ;

five returns [Pair<Integer, Integer> ab]
    : a=num b=num { $ab = new Pair<>($a.value, $b.value); }
    ;

title
    : (expression { data.addAssumptionExpression(new Expression($expression.op)); } (',' expression { data.addAssumptionExpression(new Expression($expression.op)); } )*)?
    ('|-' expression { data.setStatement(new Expression($expression.op));})
    ;

expression returns [Operation op]
    : dis { $op = $dis.op; }
    | dis '->' expression { $op = new Implication($dis.op, $expression.op); }
    ;

dis returns [Operation op]
    : con { $op = $con.op; }
    | d=dis '|' con { $op = new Disjunction($d.op, $con.op); }
    ;

con returns [Operation op]
    : neg { $op = $neg.op; }
    | c=con '&' neg { $op = new Conjunction($c.op, $neg.op); }
    ;

neg returns [Operation op]
    : pred { $op = $pred.op; }
    | '!' neg { $op = new Negation($neg.op); }
    | '(' expression ')' { $op = $expression.op; }
    | '@' VAR neg { $op = new UniversalQ($VAR.text, $neg.op); }
    | '?' VAR neg { $op = new ExistenceQ($VAR.text, $neg.op); }
    ;

pred returns [Operation op]
    : PRED { $op = new Predicate($PRED.text); } ('(' h=term { $op.addArgument($h.op); } (',' t=term { $op.addArgument($t.op); } )* ')' )?
    | f=term '=' s=term { $op = new Equality($f.op, $s.op); }
    ;

term returns [Operation op]
    : add { $op = $add.op; }
    | t=term '+' add { $op = new Add($t.op, $add.op); }
    ;

add returns [Operation op]
    : mul { $op = $mul.op; }
    | a=add '*' mul { $op = new Mul($a.op, $mul.op); }
    ;

mul returns [Operation op]
    : VAR { $op = new Function($VAR.text); } ('(' h=term { $op.addArgument($h.op); } (',' t=term { $op.addArgument($t.op); } )* ')' )?
    | '(' term ')' { $op = $term.op; }
    | '0' { $op = new Zero(); }
    | m=mul '\'' { $op = new Successor($m.op); }
    ;

num returns [int value]
    : NUMBER { $value = Integer.parseInt($NUMBER.text); }
    ;

VAR : [a-z][a-z0-9]* ;
PRED : [A-Z][A-Z0-9]* ;
NUMBER : [0-9]+ ;
SKP : [ \t\r] -> skip ;