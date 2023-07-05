package org.example.staticvsobject;

import org.example.recap.*;

public class Main {
    /*
    Am un magazin virtual cu un cos unde pot pune diverse alimente.
    Doresc sa vad care persoana are cele mai multe alimente in cos.

     */

    public static void main(String[] args) {
        Cos cos1 = new Cos();
        cos1.adaugaAliment(new Aliment(100));
        cos1.adaugaAliment(new Aliment(10));

        Cos cos2 = new Cos();
        cos2.adaugaAliment(new Aliment(1));
        Persoana p1 = new Persoana("ana", cos1);

        Persoana p2 = new Persoana("mihai", cos2);

        System.out.println("Persoana 1 are un numr de alimente egal cu : " + p1.getCos().getNumarAlimente());
        System.out.println("Persoana 2 are un numar de alimente egal cu: " +p2.getCos().getNumarAlimente());

    }
}
