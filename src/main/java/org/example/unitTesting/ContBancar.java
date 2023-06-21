package org.example.unitTesting;

import java.util.List;

public class ContBancar {
    private List<Card> cardList;
    private double sum;
    private String iban;

    public ContBancar(String iban) {
        this.iban = iban;
        sum = 0;
        cardList = null;
    }

    public void adaugBani(int money) {
        if (money < 0) {
            System.out.println("numaurul trebuie sa fie pozitiv");
        } else {
            sum = sum + money;
        }
    }

    public void scoateBanii(int money) {
        if (money < 0) {
            System.out.println("numaurul trebuie sa fie pozitiv");
        } else if (money > sum) {
            System.out.println("nu aveti suficienti bani");
        } else {
            sum = sum - money;
        }
    }

    public void atasezCard(Card card) {
        cardList.add(card);
    }

    public void stergeCard(Card card) {
        cardList.remove(card);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public double getSum() {
        return sum;
    }
}
