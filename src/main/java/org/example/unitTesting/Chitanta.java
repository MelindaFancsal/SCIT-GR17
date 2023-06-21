package org.example.unitTesting;

import java.time.LocalDateTime;
import java.util.Date;

public class Chitanta {
    private String mesaj;
    private Date data;

    public Chitanta() {
        this.data = new Date();
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getMesaj() {
        return mesaj;
    }

    public Date getData() {
        return data;
    }
}
