package org.example.java8;

import java.util.*;
import java.util.function.Consumer;

public class LamdaArrayExamples {
    public static void main(String[] args) {
        exemplu1();

        exemplu2();

        exemplu3();

        exemplu4();
    }

    private static void exemplu4() {
        //am un map cu K,V . Doresc sa adaug K,V intr un string.

        Map<String, Integer> map = new HashMap<>();
        map.put("k", 1);
        map.put("v", 1);
        map.put("m", 4);

        StringBuilder sb = new StringBuilder();
        map.forEach((k,v) -> sb.append(String.format("%s%s", k,v)));

        System.out.println(sb);
    }

    private static void exemplu3() {
        // avand o lista de sttringuri , inlocuiti fiecare cuvand cu upperCase
        List<String> words = new ArrayList<>(Arrays.asList("java", "test", "abcd", "abcvf"));

        words.replaceAll(s -> s.toUpperCase()); //String::toUpperCase()

        words.forEach(s -> System.out.println(s));
    }

    private static void exemplu2() {

        //avand o lista de stringuri stergeti din lista cuvintele care au lungimea impara
        List<String> words = new ArrayList<>(Arrays.asList("java", "test", "abcd", "abcvf"));
        words.removeIf(s -> s.length() % 2 != 0);

        words.forEach(System.out::println);
    }

    private static void exemplu1() {
        //avand o lista de stringuri creati un string care sa contina prima litera din fiecare element al listei

        List<String> words = new ArrayList<>(Arrays.asList("java", "test", "abcd"));

        //diferenta intre String si StringBuilder

        StringBuilder sb = new StringBuilder();
        words.forEach(s -> sb.append(s.charAt(0)));

        String result = sb.toString();
        System.out.println(result);
    }
}
