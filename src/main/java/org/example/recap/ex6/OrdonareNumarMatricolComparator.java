package org.example.recap.ex6;

import java.util.Comparator;

public class OrdonareNumarMatricolComparator implements Comparator<Elev> {
    @Override
    public int compare(Elev o1, Elev o2) {
        return o1.getNumarMatricol().compareTo(o2.getNumarMatricol());
    }
}
