package org.example.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapMain {
    public static void main(String[] args) {
       // exemplu1();
        exemplu2();

    }

    private static void exemplu2() {
        Map<String, Person> hashMap = new HashMap<>();
        hashMap.put("iso", new Unemployed(30, "Mihai", 3333));
        hashMap.put("iso", new Unemployed(30, "Mihai", 3333));
        hashMap.put("cel", (new Unemployed(30, "Mihai", 111)));
        hashMap.put("sos", (new Hired("Andrei", 35, 2000, 11111)));

        for (String key: hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }
    }

    private static void exemplu1() {
       // Map<Integer, String> hashMap = new HashMap<>();
     //   Map<Integer, String> hashMap = new LinkedHashMap<>();
        Map<Integer, String> hashMap = new TreeMap<>();
        hashMap.put(1, "one");
        hashMap.put(1, "one");
        hashMap.put(3, "three");
        hashMap.put(2, "two");

        for (Integer item: hashMap.keySet()) {
            System.out.println("keys of the map: " + item);
        }

        for (String item: hashMap.values()) {
            System.out.println("values of the map: "+item);
        }

        for (Map.Entry<Integer, String> item: hashMap.entrySet()) {
            System.out.println(item);
            System.out.println(item.getKey() + "    " + item.getValue());
        }
    }
}
