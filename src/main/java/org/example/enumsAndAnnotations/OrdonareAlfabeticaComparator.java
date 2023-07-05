package org.example.enumsAndAnnotations;

import java.util.Comparator;

public class OrdonareAlfabeticaComparator implements Comparator<Angajat> {
    @Override
    public int compare(Angajat o1, Angajat o2) {
        return o1.getNume().compareTo(o2.getNume());
    }
}
