package org.example.collections;

public class Hired extends Person{
    private int salar;

    public Hired(String nume, int age, int salar) {
        super(nume, age);
        this.salar = salar;
    }

    public int getSalar() {
        return salar;
    }
}
