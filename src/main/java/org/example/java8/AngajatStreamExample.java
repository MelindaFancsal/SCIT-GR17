package org.example.java8;

import org.example.java8.streamClasses.Angajat;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AngajatStreamExample {
    public static void main(String[] args) {
        List<Angajat> angajatList = new ArrayList<>();
        angajatList.add(new Angajat("A", 100));
        angajatList.add(new Angajat("b", 400));
        angajatList.add(new Angajat("c", 300));
        angajatList.add(new Angajat("g", 100));
        angajatList.add(new Angajat("f", 300));

        //vreau sa adaugam pentru fiecare angajat un bonus de 100 lei

        angajatList.stream().forEach(it -> it.adaugaBonus(100));
        System.out.println(angajatList);


        //vreau sa afisam angajatii in ordine aflabetica
        List<Angajat> listaSortata = angajatList.stream().sorted(Comparator.comparing(new Function<Angajat, String>() {
            @Override
            public String apply(Angajat angajat) {
                return angajat.getNume();
            }
        })).collect(Collectors.toList());

        //  angajatList.stream().sorted(Comparator.comparing(angajat -> angajat.getNume()));

        //angajatList.stream().sorted(Comparator.comparing(Angajat::getNume));

        System.out.println(listaSortata);


        //angajatul cu cel mai mare salar din firma

        OptionalInt salarMax = angajatList.stream().mapToInt(it -> it.getSalar()).max();

        System.out.println("salarul max din firma este:  " + salarMax.getAsInt());

        Angajat angajat = angajatList.stream().max(new Comparator<Angajat>() {
                    @Override
                    public int compare(Angajat o1, Angajat o2) {
                        return Integer.compare(o1.getSalar(), o2.getSalar());
                    }
                }).get();


        System.out.println(angajat);
    }
}
