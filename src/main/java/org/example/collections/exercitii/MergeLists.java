package org.example.collections.exercitii;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MergeLists {
    //doresc concatenarea listelor si rezultatul sa fie ordonat crescator
    public static void main(String[] args) {
        List<Integer> list1 = asList(1, 2, 3, 4, 5);
        List<Integer> list2 = asList(3, 4, 5, 6, 7, 8, 9, 10);

        mergeLists(list1, list2);
    }

    private static void mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        while (i1 < list1.size() && i2 < list2.size()) {
            if (i1 == list1.size() - 1 && i2 != list2.size() - 1) {
                for (; i2 < list2.size(); i2++) {
                    list.add(list2.get(i2));
                }
            } else if (i1 != list1.size() - 1 && i2 == list2.size() - 1) {
                for (; i1 < list1.size(); i1++) {
                    list.add(list1.get(i1));
                }
            } else if (list1.get(i1) < list2.get(i2)) {
                list.add(list1.get(i1));
                i1++;
            } else if (list1.get(i1) > list2.get(i2)) {
                list.add(list2.get(i2));
                i2++;
            } else if (list1.get(i1).equals(list2.get(i2))) {
                list.add(list1.get(i1));
                i1++;
                i2++;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
