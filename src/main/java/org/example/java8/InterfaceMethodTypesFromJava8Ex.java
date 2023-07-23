package org.example.java8;

public interface InterfaceMethodTypesFromJava8Ex {
    void m1();

    void m4();
    default void m2() {
        System.out.println("do something");
    }
    public static void m3() {
        System.out.println("static ");
    }
}
