package org.example.unitTesting;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Chitanta {
    private String mesaj;
    private Date data;

    public Chitanta() {
        this.data = new Date();
        this.mesaj = "";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chitanta chitanta)) return false;
        return Objects.equals(mesaj, chitanta.mesaj) && Objects.equals(data, chitanta.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mesaj, data);
    }
}
