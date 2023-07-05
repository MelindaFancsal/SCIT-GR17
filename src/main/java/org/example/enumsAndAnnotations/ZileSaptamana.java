package org.example.enumsAndAnnotations;

public enum ZileSaptamana {
    LUNI("luni"),

    MARTI("marti"),

    MIERCURI("miercuri"),

    JOI("joi"),

    VINERI("vineri");


    private String nume;
    ZileSaptamana(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }
}
