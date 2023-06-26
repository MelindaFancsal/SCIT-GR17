package org.example.unitTesting;

import java.util.ArrayList;
import java.util.List;

public class Banca {
    protected String nume;

    protected List<Persoana> clienti;

    public Banca(String nume) {
        this.nume = nume;
        this.clienti = new ArrayList<>();
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

    public void adaugaClient(Persoana client) {
        this.clienti.add(client);
    }
}
