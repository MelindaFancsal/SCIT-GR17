package org.example.generics;

public abstract class Animal {
    protected String nume;

    public Animal(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }
}
