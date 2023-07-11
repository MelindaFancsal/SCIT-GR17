package org.example.io;

import java.io.Serializable;

public class Persoana implements Serializable {
    private static final long serialVersionUID = 124608L;

    private String nume;

    private int varsta;

    private transient double inaltime;

    public Persoana(String nume, int varsta, double inaltime) {
        this.nume = nume;
        this.varsta = varsta;
        this.inaltime = inaltime;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public double getInaltime() {
        return inaltime;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", inaltime=" + inaltime +
                '}';
    }
}
