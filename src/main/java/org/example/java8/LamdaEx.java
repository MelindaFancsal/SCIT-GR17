package org.example.java8;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LamdaEx {

    //metoda contine:
    //modificator de acces, nume, param de intrare, return type

    //fara lamda: public int m1(int a, int b) { return a+b}
    // cu lamda (int a, int b) -> {return a+b}
    //cu lamda si ai redus: (a, b) -> a+b;

    public static void main(String[] args) {
        //lamda expressions
        exampleLamdaMethods();
        exampleFunctionalInterfaceLamda();
        comparatorEx();
    }

    private static void comparatorEx() {
        List<Integer> intlist = new ArrayList<>();
        intlist.add(5); intlist.add(7); intlist.add(2);

        Collections.sort(intlist, new MyIntComparator());
        System.out.println(intlist);

        //sortare crescator
        Collections.sort(intlist, (o1, o2) -> (o1 > o2) ? 1 : (o1 < o2) ? -1 : 0);
        System.out.println("sortare crescator: " + intlist);

        //sortare descrescator
        Collections.sort(intlist, (o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0);
        System.out.println("sortare descrescator: " +intlist);
    }

    private static void exampleFunctionalInterfaceLamda() {
        //fara lamda
//        SimpleFunctionalInterface object  = new ClassForSimpleFunctionalInterface();
//        object.doWork();

        SimpleFunctionalInterface objectLamda = () -> System.out.println("lucreaza");
        objectLamda.doWork();

        FunctionalInterfaceReturn functionalInterfaceObj = (a, b) -> a+b;
        int result = functionalInterfaceObj.sum(1,2);
        System.out.println(result);
    }

    private static void exampleLamdaMethods() {

        /*
        () ->  System.out.println("hello");
        (a, b) ->  System.out.println(a+b);
        s -> s.length();

         */
    }

    public void m1() {
        System.out.println("hello");
    }
    
    public void m2(int a, int b) {
        System.out.println(a+b);
    }
    
    public int m3(String s) {
        return s.length();
    }
}
