package com.lytr777.propositionalCalculus.operations;

import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by lytr777 on 15/08/2017.
 */
public interface Operation {
    OperationType getType();

    void setFirstOperation(Operation op);
    void setSecondOperation(Operation op);

    boolean isTrueOn(Map<String, Boolean> values);
    boolean isUseless();
    Operation getFirstOperation();
    Operation getSecondOperation();
    void reconstruct();

    void printTree(int level);
    void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions);
    void print(boolean outside, Map<String, Operation> substitutions);
}
