package org.example.recap.ex4;

public class MainTest {
    public static void main(String[] args) {
        Base b1 = new Base();
        Base b2 = new Subclass();
        Subclass s1 = new Subclass();

        b1.metoda1();   //-> metoda1
        b2.metoda1();  //-> metoda1;
        s1.metoda1();  //->   ??
       // b1.metoda2();  //->  eroare de compliare
       // b2.metoda2();  // ->  eroare de compliare

        //((Subclass) b2).metoda2();
        s1.metoda2();   // ->metoda2
    }
}
