package org.example.recap.ex3;

import org.example.recap.ex3.BaseStatic;

public class ChildStatic extends BaseStatic {
    static {
        System.out.println("ChildStatic");
    }
}
