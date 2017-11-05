package com.lytr777.propositionalCalculus.operations;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lytr777 on 15/08/2017.
 */
public interface Operation {
    OperationType getType();

    void setFirstOperation(Operation op);
    void setSecondOperation(Operation op);

    void addArgument(Operation arg);
    List<Operation> getArguments();

    Set<String> getFreeVariables();
    Operation replaceVariable(String v, Operation op);
    boolean isAvailableToInsert(String v, Set<String> free, boolean linked);

    boolean isTrueOn(Map<String, Boolean> values);
    boolean isUseless();
    Operation getFirstOperation();
    Operation getSecondOperation();
    void reconstruct();

    void print(PrintWriter pw, boolean outside, Map<String, Operation> substitutions);
    void print(boolean outside, Map<String, Operation> substitutions);
    void printTree(int level);
}
