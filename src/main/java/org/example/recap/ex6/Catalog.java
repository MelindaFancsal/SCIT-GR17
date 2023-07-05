package org.example.recap.ex6;

import java.util.*;

public class Catalog {

    private Set<Elev> elevi;

    public Catalog() {
        elevi = new HashSet<>();
    }

    public void addElev(Elev elev) {
        if (!elevi.add(elev)) {
            System.out.println("elevul exista deja");
        }
    }

    public void afiseazaEleviiCareNuSuntCorigenti() {
        for (Elev elev: elevi) {
            if (!elev.esteCorigent()) {
                System.out.println(elev);
            }
        }
    }

    public List<Elev> returneazaEleviiOrdonatiAlfabetic() {
        List<Elev> elevList = new ArrayList<>(elevi);
        Collections.sort(elevList);
        return elevList;
    }

    public List<Elev> returneazaEleviiOrdonatiDupaNrMatricol() {
        List<Elev> elevList = new ArrayList<>(elevi);
        elevList.sort(new OrdonareNumarMatricolComparator());

        return elevList;
    }
}
