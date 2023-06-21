package org.example.unitTesting;

import java.util.List;

public class Banca {
    private String nume;

    private List<Persoana> clienti;

    public Banca(String nume) {
        this.nume = nume;
        this.clienti = null;
    }

    public String getNume() {
        return nume;
    }

    public List<Persoana> getClienti() {
        return clienti;
    }

    public void setClienti(List<Persoana> clienti) {
        this.clienti = clienti;
    }
}
