package org.example.recap.ex2;

import org.example.recap.ex2.Base;

public class ChildBase extends Base {
    public ChildBase() {
        //super();
        System.out.println("ChildBase");
    }

    public ChildBase(String item) {
        this();
        System.out.println("ChildBase " + item);
    }

    @Override
    public void method() {
        System.out.println("metoda subclasa");
    }
}
