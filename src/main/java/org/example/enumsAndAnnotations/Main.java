package org.example.enumsAndAnnotations;

import org.example.collections.ArrayMain;

import javax.sound.midi.Soundbank;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       // exemplu1();

        exemplu2();

        //vreau sa afisati un mesaj pentru fiecare zi a saptamanii

        exemplul3();
    }

    private static void exemplul3() {
        ZileSaptamana oZiSapt = ZileSaptamana.MARTI;

        System.out.println(oZiSapt.getNume());
    }

    private static void exemplu2() {
        /*
        O companie pe nume ThoughtWorks are mai multi angajati in firma. Doresc sa afisati toti angajatii de sex feminim din companie.
        - firma
        - angajat
         */

        Angajat angajat1 = new Angajat("mihai", Gender.MASCULIN);
        Angajat angajat2 = new Angajat("andreea", Gender.FEMININ);

       // Firma firmaAnnotation = new Firma(null);

        Firma firma = new Firma("Tw");
        firma.adaugaAngajat(angajat1);
        firma.adaugaAngajat(angajat2);

        List<Angajat> rezultat =firma.afisareAngajatiDupaSex(Gender.FEMININ);
        afisareLista(rezultat);


        List<Angajat> listaOrdonataAlfabetic = firma.afisareListaOrdonataAlfabetic();
        afisareLista(listaOrdonataAlfabetic);

    }

    private static void afisareLista (List<Angajat> angajati) {
        for (Angajat angajat: angajati) {
            System.out.println(angajat);
        }
    }
    private static void exemplu1() {
        Planet pamant = Planet.PAMANT;

        System.out.println(pamant);
        afiseazaMesajPlaneta(pamant);
    }

    private static void afiseazaMesajPlaneta(Planet planeta) {
        switch (planeta) {
            case PAMANT:
                System.out.println("Salut Pamant!. Suprafata si greutatea sunt: " + planeta.surfaceGravity() + " " + planeta.weight(10));
                break;

            case MARTE:
                System.out.println("Salut Marte");
                break;

            case PLUTO:
                System.out.println("Salut Pluto");
                break;

            default:
                System.out.println("alta planeta");

        }
    }
}
