package org.example.collections;

public class Student extends Person {
    private String numeUniversitate;

    public Student(String numeUniversitate, String nume, int age, int cnp) {
        super(nume, age,cnp);
        this.numeUniversitate = numeUniversitate;
    }

    public String getNumeUniversitate() {
        return numeUniversitate;
    }
}
