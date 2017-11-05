grammar Propositional;

@parser::header {
import com.lytr777.util.Expression;
import com.lytr777.util.InitialData;
import com.lytr777.propositionalCalculus.operations.*;
}

@parser::members {
public InitialData data = new InitialData();
public int lines = 0;
}

file
    : title '\n' (expression '\n' { data.addProofExpression(new Expression($expression.op)); lines += 1; if (lines % 500 == 0) System.out.println("Прочитано " + lines + " строк");} )*
    ;

title
    : (expression { data.addAssumptionExpression(new Expression($expression.op)); } (',' expression { data.addAssumptionExpression(new Expression($expression.op)); } )*)?
    ('|-' expression { data.setStatement(new Expression($expression.op));})
    ;

expression returns [Operation op]
    : dis { $op = new Implication($dis.op); }
    | dis '->' expression { $op = new Implication($dis.op, $expression.op); }
    ;

dis returns [Operation op]
    : con diss { $op = new Disjunction($con.op, $diss.op); }
    ;


diss returns [Operation op]
    : '|' con diss { $op = new Disjunction($con.op, $diss.op); }
    | { $op = null; }
    ;

con returns [Operation op]
    : neg cons { $op = new Conjunction($neg.op, $cons.op); }
    ;

cons returns [Operation op]
    : '&' neg cons { $op = new Conjunction($neg.op, $cons.op); }
    | { $op = null; }
    ;

neg returns [Operation op]
    : NAME { $op = new Variable($NAME.text); }
    | '!' neg { $op = new Negation($neg.op); }
    | '(' expression ')' { $op = $expression.op; }
    ;

NAME : [A-Z][A-Z0-9]* ;
SKP : [ \t\r] -> skip ;