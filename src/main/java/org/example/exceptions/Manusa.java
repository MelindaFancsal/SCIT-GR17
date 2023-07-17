package org.example.exceptions;

import java.util.Objects;

public class Manusa implements Item{
    private int marime;
    private String culoare;

    public Manusa(int marime, String culoare) {
        this.culoare = culoare;
        this.marime = marime;
    }

    public int getMarime() {
        return marime;
    }

    public void setMarime(int marime) {
        this.marime = marime;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manusa manusa)) return false;
        return marime == manusa.marime && Objects.equals(culoare, manusa.culoare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marime, culoare);
    }
}
