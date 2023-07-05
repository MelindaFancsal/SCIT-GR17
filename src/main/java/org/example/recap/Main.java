package org.example.recap;

import org.example.recap.ex2.ChildBase;

public class Main {
    //vreau o variabila accesibila din orice clasa si care sa nu poata fi modificata = constanta
    public static final String VARIABILA = "variabila";

    //2) Collections - (e o clasa utils) vs collections: List, Set, Map


    public static void main(String[] args) {
        //1) check return array
        //returnArray();

        //2)
        oopMostenire();


     }

    private static void oopMostenire() {
        new ChildBase("Apelare");

    }


    public static void returnArray() {
         String[] array = new String[5];
         System.out.println(array[5]);

     }
}
