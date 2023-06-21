package org.example.unitTesting;

import java.util.Date;

public class Card {
    private String iban;
    private Date expirationDate;

    private String nume;
    private int numarCard;

    public Card(String iban, Date expirationDate, String nume, int numarCard) {
        this.iban = iban;
        this.expirationDate = expirationDate;
        this.nume = nume;
        this.numarCard = numarCard;
    }

    public String getIban() {
        return iban;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getNume() {
        return nume;
    }

    public int getNumarCard() {
        return numarCard;
    }
}
