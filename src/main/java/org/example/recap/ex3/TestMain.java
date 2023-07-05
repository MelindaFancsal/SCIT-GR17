package org.example.recap.ex3;

public class TestMain {
    public static void main(String[] args) {
        ChildStatic childStatic = new ChildStatic();
        AClass aClass = null;

        System.out.println((Object) childStatic == (Object) aClass);
    }
}
