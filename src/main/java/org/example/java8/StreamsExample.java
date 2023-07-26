package org.example.java8;

import org.example.java8.streamClasses.F1Team;

import java.io.InputStream;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {
        exemplu1();

        exemplu2();

        exemplu3();

        exemplu4();

        exemplu5();

        exemplu6();
    }

    private static void exemplu6() {
        //avand o lista de echipe de formula1, doresc sa afisati toti cursantii
        Set<String> driversTeam1 = new HashSet<>();
        driversTeam1.add("driver1");
        driversTeam1.add("driver2");
        driversTeam1.add("driver3");

        Set<String> driversTeam2 = new HashSet<>();
        driversTeam1.add("driver4");
        driversTeam1.add("driver5");
        driversTeam1.add("driver6");


        F1Team echipa1 = new F1Team("echipa1", driversTeam1);
        F1Team echipa2 = new F1Team("echipa2", driversTeam2);
        List<F1Team> teams = Arrays.asList(echipa1, echipa2);

        List<String> drivers = teams
                .stream()
                .flatMap(it -> it.getDrivers().stream())
                .collect(Collectors.toList());


        System.out.println(drivers);
    }

    private static void exemplu5() {
        List<Integer> integerList = IntStream.range(0, 100)
                .filter(it -> {
                            boolean isPrime = it > 1;

                            for (int i = 2; i < it; i++) {
                                isPrime = (it % i != 0);

                                if (!isPrime) {
                                    break;
                                }
                            }

                            return isPrime;
                        }
                ).boxed().collect(Collectors.toList());

        System.out.println("elementele prime: " + integerList);
    }

    private static void exemplu4() {
        Arrays.asList("ana", "mere", "civic", "mama")
                .stream()
                .filter(element -> {
                    //varianta a: StringBuilder stringBuilder = new StringBuilder(element).reverse();

                    String cuvantInversat = "";
                    for (int i = element.length() - 1; i >= 0; i--) {
                        cuvantInversat = cuvantInversat + element.charAt(i);
                    }

                    return cuvantInversat.equals(element);
                }).forEach(System.out::println);
    }

    private static void exemplu3() {
        Stream.of("a1", "b1", "c1")
                .findFirst()
                .ifPresent(it -> System.out.println(it));


    }

    private static void exemplu2() {
        //verificati daca litera a se afla in sirul de caractere
        boolean isPresent = Stream.of("d", "b1", "c2", "a", "m1")
                .map(it -> {
                    System.out.println(it);
                    return it.toUpperCase();
                })
                .anyMatch(it -> {
                    System.out.println(it);
                    return it.startsWith("A");
                });

        if (isPresent) {
            System.out.println("litera a este presenta in lista data");
        }

    }

    private static void exemplu1() {
        //doresc sa afisez cu majuscule si in ordine crescatoare obiectele String care incep cu litera c.
        List<String> stringList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        List<String> updatedList = new ArrayList<>();
        for (String item : stringList) {
            if (item.startsWith("c")) {
                updatedList.add(item.toUpperCase());
            }
        }

        Collections.sort(updatedList);
        System.out.println(updatedList);

        //java8
        List<String> updatedListJava8 =
                stringList.stream()
                        .filter(s -> {
                            System.out.println("in filtrare:" + s);
                            return s.startsWith("c");
                        })
                        .map(it -> {
                            System.out.println("in mapare: " + it);
                            return it.toUpperCase();
                        })
                        .sorted()
                        .toList();//operator final sau forEach(...)

        System.out.println(updatedListJava8);
    }
}
