package org.example.unitTesting;

import java.util.List;

public class Pos {
    private List<Banca> bancaList;

    private Card card;

    public Pos(List<Banca> bancaList) {
        this.bancaList = bancaList;
        card = null;
    }

    public Chitanta scoateBani(Card card, int sumaRetrasa) {
        Chitanta chitanta = new Chitanta();

        for (Banca banca : bancaList) {

            for (Persoana persoana : banca.getClienti()) {

                for (ContBancar contBancar : persoana.getConturiBancare()) {

                    for (Card cardClient : contBancar.getCardList()) {
                        if (cardClient.getIban().equals(card.getIban())) {
                            contBancar.scoateBanii(sumaRetrasa);

                            chitanta.setMesaj(sumaRetrasa+ "  " +contBancar.getSum());
                        }
                    }
                }

            }

        }
    }


}
