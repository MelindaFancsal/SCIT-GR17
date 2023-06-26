package org.example.staticvsobject;

public class Persoana {
    private  String nume;
    private  Cos cos;

    Persoana(String nume, Cos cos) {
        this.nume = nume;
        this.cos = cos;
    }

    public Cos getCos() {
        return cos;
    }
}
