package org.example.enumsAndAnnotations;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Angajat {
    @NotNull
    private String nume;
    @NotNull
    private Gender gender;
    @NotNull
    private String adresa;

    public Angajat(@NotNull String nume, @NotNull Gender gender) {
        this.nume = nume;
        this.gender = gender;
    }

    @NotNull
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Angajat angajat)) return false;
        return Objects.equals(nume, angajat.nume) && gender == angajat.gender && Objects.equals(adresa, angajat.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, gender, adresa);
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", gender=" + gender +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
