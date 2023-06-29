package org.example.generics.exercitiu1;

public class FindPairs {

    /*
    Am mai multe perechi de papuci -> cizme, papuci cu toc si adidasi . Doresc sa verific daca cizemele sau papucii cu toc sunt sau
    nu perechi
     */
    public static void main(String[] args) {
        Adidas adidas1 = new Adidas("rosu", 39);
        Adidas adidas2 = new Adidas("rosu", 39);
        Cizma cizma1 = new Cizma("albastru", 29);
        Cizma cizma2 = new Cizma("verde", 29);

        PairCheck<Adidas> pairCheck = new PairCheck<>(adidas1, adidas2);
        System.out.println(adidas1.getClass().getSimpleName() + " sunt " + pairCheck.isPair());

        PairCheck<Cizma> pairCheckCizma = new PairCheck<>(cizma1, cizma2);
        System.out.println(cizma1.getClass().getSimpleName() + " sunt " + pairCheckCizma.isPair());


    }
}
