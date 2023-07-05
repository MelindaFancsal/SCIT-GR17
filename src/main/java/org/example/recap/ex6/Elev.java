package org.example.recap.ex6;

import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Elev implements Comparable<Elev>{
    private String nume;
    private String numarMatricol;

    private Map<String, List<Integer>> note;

    public Elev(String nume, String numarMatricol, Map<String, List<Integer>> note) {
        this.nume = nume;
        this.numarMatricol = numarMatricol;
        this.note = note;
        note = new HashMap<>();
    }


    public void setNote(Map<String, List<Integer>> note) {
        this.note = note;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNumarMatricol() {
        return numarMatricol;
    }

    public void setNumarMatricol(String numarMatricol) {
        this.numarMatricol = numarMatricol;
    }

    public boolean esteCorigent() {
        if (this.note == null) {
            return false;
        }

        boolean esteCorigent = false;

        for (Map.Entry<String, List<Integer>> kv: this.note.entrySet()) {

            String numeMaterie = kv.getKey();
            List<Integer> note = kv.getValue();
            int sumaNote=0;

            for (Integer nota: note) {
                sumaNote+=nota;
            }

            double mediaMaterie = (double) sumaNote /note.size();
            if (mediaMaterie  < 5) {
                esteCorigent = true;
                break;
            }
        }

        return esteCorigent;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Elev elev)) return false;
        return Objects.equals(nume, elev.nume) && Objects.equals(numarMatricol, elev.numarMatricol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, numarMatricol);
    }

    @Override
    public int compareTo(Elev o) {
        return this.nume.compareTo(o.nume);
    }

    @Override
    public String toString() {
        return "Elev{" +
                "nume='" + nume + '\'' +
                ", numarMatricol='" + numarMatricol + '\'' +
                ", note=" + note +
                '}';
    }
}
