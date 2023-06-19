package org.example.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        parcurgereLista(list);

        System.out.println("------------------");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(3);
        parcurgereLista(linkedList);

//        ArrayList<Integer> list1 = new ArrayList<>();
//        list.add(1);
        //  parcurgereArrayLista(list1);

        //  parcurgereLista(list1);


        //   parcurgereArrayLista(lista2);

        //  List<Person> personList = new ArrayList<>(); //folosit pentru parcurgere si adaugare si stergele la inceput si sf
        List<Person> personList = new LinkedList<>(); //folosit cel mai des cand avem de facut multe stergeri,adaugari in interior lista
        personList.add(new Unemployed(30, "Mihai"));
        personList.add(new Hired("Andrei", 35, 2000));
        personList.add(new Student("UTCN", "Cristi", 20));

        //   parcurgerePersoanaLista(personList);
        stergereElementLista(personList);

    }


    private static void stergereElementLista(List<Person> personList) {
        //parcurgerea si modificarea listei in acelasi timp nu se FACE CU for each sau for clasic ci cu ITERATOR

//        for (int i=0; i<personList.size(); i++) {
//            if (personList.get(i).getName().equals("Andrei")) {
//                Person person = personList.get(i);
//            }
//        }

        for (Person person : personList) {
            if (person.getName().equals("Andrei")) {
                personList.remove(person);
            } else {
                System.out.println("FOR: "+person.getName());
            }
        }

        //VARIANTA CORECTA DE MODIFICARE LISTA IN TIMP CE O PARCURG
        Iterator<Person> personIterator = personList.listIterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getName().equals("Andrei")) {
                personList.remove(person);
            } else {
                System.out.println("Iterator: " + person.getName());
            }
        }


    }

    public static void parcurgereLista(List<Integer> lista) {
        //v1
        for (Integer element : lista) {
            System.out.println(element);
        }

    }

    public static void parcurgerePersoanaLista(List<Person> lista) {
        //v1
        for (Person element : lista) {
            System.out.println(element);
        }

        //v2 - iterator
        Iterator<Person> iterator = lista.listIterator();

        while (iterator.hasNext()) {

            Person person = iterator.next();
            System.out.println(person.getName());
        }
    }

//    public static void parcurgereArrayLista(ArrayList<Integer> lista) {
//        for (Integer element: lista) {
//            System.out.println(element);
//        }
//    }
}
