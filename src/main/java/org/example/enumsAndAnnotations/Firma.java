package org.example.enumsAndAnnotations;


import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Firma {

    @NotNull
    private String nume;
    @NotNull
    private Set<Angajat> listaAngajati;


    public Firma(@NotNull String nume) {
        this.nume = nume;
        listaAngajati = new HashSet<>();
    }

    public void adaugaAngajat(@NotNull Angajat angajat){
        listaAngajati.add(angajat);
    }

    //care imi va returna angajatii de un anume sex
   @NotNull
    public List<Angajat> afisareAngajatiDupaSex(@NotNull Gender gender) {
        List<Angajat> listaFiltrata = new ArrayList<>();

        for (Angajat angajat: listaAngajati) {
            if (angajat.getGender().equals(gender)) {
                listaFiltrata.add(angajat);
            }
        }

        return listaFiltrata;
    }

    //vreau sa afisez angajatii ordonati alfabetic
    public List<Angajat> afisareListaOrdonataAlfabetic() {
        List<Angajat> lista = new ArrayList<>(listaAngajati);
        Collections.sort(lista,  new OrdonareAlfabeticaComparator());

        return lista;
    }

    public Set<Angajat> getListaAngajati() {
        return listaAngajati;
    }
}
