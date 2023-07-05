package org.example.recap.ex5;

import org.example.recap.ex4.Base;

public class ChildStatic extends BaseStatic {
    public static String m1() {return "ChildStatic m1";}

    public static void main(String[] args) {
        ChildStatic childStatic = new ChildStatic();
        BaseStatic baseStatic = new ChildStatic();

        System.out.println(childStatic.m1() + "  " + baseStatic.m1());
    }
}
