package org.example.unitTesting;

import java.util.ArrayList;
import java.util.List;

public class Pos {
    private final List<Banca> bancaList;

    public Pos() {
        bancaList = new ArrayList<>();
    }
    public void cunoasteBanca(Banca banca) {
        bancaList.add(banca);
    }
    public Chitanta scoateBani(Card card, int sumaRetrasa) {
        Chitanta chitanta = new Chitanta();

        for (Banca banca : bancaList) {

            for (Persoana persoana : banca.getClienti()) {

                for (ContBancar contBancar : persoana.getConturiBancare()) {

                    for (Card cardClient : contBancar.getCardList()) {
                        if (cardClient.getIban().equals(card.getIban())) {
                            contBancar.scoateBanii(sumaRetrasa);

                            chitanta.setMesaj(sumaRetrasa + " " + contBancar.getSum());
                        }
                    }
                }

            }

        }

        return chitanta;
    }


    public List<Banca> getListaBancaCunoscute() {
        return bancaList;
    }
}
