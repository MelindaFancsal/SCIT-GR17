package org.example.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UnmodifiableCollections {
    public static void main(String[] args) {
        List<Person> personList = new LinkedList<>(); //folosit cel mai des cand avem de facut multe stergeri,adaugari in interior lista
        personList.add(new Unemployed(30, "Mihai", 11111));
        personList.add(new Hired("Andrei", 35, 2000, 2222));
        personList.add(new Student("UTCN", "Cristi", 20, 3333));

        List<Person> immutableList = Collections.unmodifiableList(personList);

       // immutableList.add(new Unemployed(30, "Dragos", 11111));
    }
}
