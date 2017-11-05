package com.lytr777.propositionalCalculus.operations;

/**
 * Created by lytr777 on 11/09/2017.
 */
public abstract class AbstractOperation implements Operation {

    public void printLevel(int level) {
        for (int i = 0; i < level; i++)
            System.out.print("--");
    }
}
