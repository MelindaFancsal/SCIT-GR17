package org.example.collections;

import java.util.*;

public class SetMain {
    public static void main(String[] args) {

        //exemplu1();

       // exemplu2();

        exemplu3();
    }

    private static void exemplu3() {
        PersonAgeComparator comparator = new PersonAgeComparator();
        Set<Person> personTreeSet = new TreeSet<>(comparator); //folosit cel mai des cand avem de facut multe stergeri,adaugari in interior lista
        personTreeSet.add(new Unemployed(35, "Mihai", 3333));
        personTreeSet.add(new Unemployed(30, "Mihai", 3333));
        personTreeSet.add(new Unemployed(30, "Mihai", 111));
        personTreeSet.add(new Hired("Andrei", 35, 2000, 11111));
        personTreeSet.add(new Student("UTCN", "Cristi", 20, 2222));

        for (Person person:personTreeSet) {
            System.out.println(person);
        }
    }

    private static void exemplu2() {
//        Person p1 = new Unemployed(30, "Mihai");
//        Person p2 = new Unemployed(30, "Mihai");
     //   Person p3 = p2;

      //  System.out.println(p3.equals(p2));

//        System.out.println(p1 + "    " + p2 + "  " + p1.equals(p2));


        Set<Person> personHashSet = new HashSet<>(); //folosit cel mai des cand avem de facut multe stergeri,adaugari in interior lista
        personHashSet.add(new Unemployed(35, "Mihai", 3333));
        personHashSet.add(new Unemployed(30, "Mihai", 3333));
        personHashSet.add(new Unemployed(30, "Mihai", 111));
        personHashSet.add(new Hired("Andrei", 35, 2000, 11111));
        personHashSet.add(new Student("UTCN", "Cristi", 20, 2222));


        List<Person> listaSortata = new ArrayList<>();
        listaSortata.addAll(personHashSet);

        //Collections.sort(listaSortata);

        //afisat lista de persoane ordonata aflabetic
//        for (Person person:listaSortata) {
//            System.out.println(person);
//        }
    }

    private static void exemplu1() {
        //hashset - nu exista o ordine de afisare a elementelor
        //  Set<Integer> integerSet = new HashSet<Integer>();
        // Set<Integer> integerSet = new LinkedHashSet<>();
        Set<Integer> integerSet = new TreeSet<>();
        integerSet.add(1);
        integerSet.add(1);
        integerSet.add(3);
        integerSet.add(2);
        integerSet.add(5);
        integerSet.add(8);
        integerSet.add(6);

        Iterator<Integer> integerIterator = integerSet.iterator();
        while (integerIterator.hasNext()) {
            Integer item = integerIterator.next();
            System.out.println(item);
        }

    }
}
