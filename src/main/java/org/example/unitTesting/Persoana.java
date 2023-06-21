package org.example.unitTesting;

import java.util.List;

public class Persoana {
    private String nume;
    private List<ContBancar> conturiBancare;

    public Persoana(String nume, List<ContBancar> conturiBancare) {
        this.conturiBancare = conturiBancare;
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<ContBancar> getConturiBancare() {
        return conturiBancare;
    }

    public void addCard(ContBancar contBancar) {
        conturiBancare.add(contBancar);
    }

}
