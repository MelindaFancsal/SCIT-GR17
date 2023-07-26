package org.example.java8.streamClasses;

public class Angajat {
    private String nume;
    private int salar;

    public Angajat(String nume, int salar) {
        this.nume = nume;
        this.salar = salar;
    }

    public String getNume() {
        return nume;
    }

    public int getSalar() {
        return salar;
    }

    public void adaugaBonus(int bonus) {
        salar = salar + bonus;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", salar=" + salar +
                '}';
    }
}
