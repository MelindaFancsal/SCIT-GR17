package org.example.exceptions.exemple;

import org.example.generics.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    private String fisier;
    private Map<String, Integer> cuvantAparitii;

    public WordCount(String fisier) throws IOException {
        this.cuvantAparitii = new LinkedHashMap<>();
        this.fisier = fisier;

        citireFisier(fisier);
    }

    private void citireFisier(String file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String words[] = line.split(" ");

            numaraAparitiile(words);
        }
    }

    private void numaraAparitiile(String words[]) {
        for (String word : words) {
            int count = 1;

            System.out.println("cuvantul verificat este: " + word);

            Iterator<Map.Entry<String, Integer>> iterator = cuvantAparitii.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<String, Integer> itemMap = iterator.next();

                if (word.equals(itemMap.getKey())) {
                    count = itemMap.getValue() + 1;
                }
            }

            cuvantAparitii.put(word, count);
        }
    }

    public Map<String, Integer> getCuvantAparitii() {
        return cuvantAparitii;
    }

    public Map<String, Integer> getNrAparitiiOrdonateCrescator() {
        Set<Map.Entry<String, Integer>> setItems = cuvantAparitii.entrySet();

        List<Map.Entry<String, Integer>> list = setItems.stream().collect(Collectors.toList());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<String, Integer> sortedMapBasedOnValue = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> item : list) {
            sortedMapBasedOnValue.put(item.getKey(), item.getValue());
        }

        //   return sortedMapBasedOnValue;
        //v2


//        for (int i = 0; i < cuvantAparitii.values().size() - 1; i++) {
//            for (int j = i + 1; i < cuvantAparitii.values().size() - 1; j++) {
//                Integer valueItem1 = cuvantAparitii.get(i);
//                Integer valueItem2 = cuvantAparitii.get(j);
//                if (valueItem1 > valueItem2) {
//                    Integer temp = valueItem1;
//                    valueItem1 = valueItem2;
//                    valueItem2 = temp;
//
//                  //  cuvantAparitii.put(cuvantAparitii., valueItem1);
//                  //  cuvantAparitii.put("cuvantAparitii.", valueItem2);
//                }
//
//
//            }
//        }

        return cuvantAparitii;

    }
}
