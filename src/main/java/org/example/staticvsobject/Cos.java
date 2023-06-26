package org.example.staticvsobject;

import java.util.ArrayList;
import java.util.List;

public class Cos {
    private  List<Aliment> alimentList;

    public Cos () {
        alimentList = new ArrayList<>();
    }

    public void adaugaAliment (Aliment aliment) {
        this.alimentList.add(aliment);
    }

    public int getNumarAlimente() {
        return alimentList.size();
    }
}
