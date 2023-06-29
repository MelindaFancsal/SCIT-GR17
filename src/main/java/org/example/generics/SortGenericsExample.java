package org.example.generics;

import java.util.Arrays;

public class SortGenericsExample {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{5, 4, 7, 1, 2};
        Double[] doubles = new Double[]{9.0, 1.2, 1.1, 5.0};
        Short[] shorts = new Short[]{1, 3, 4, 6};
        Byte[] bytes = new Byte[]{3, 2, 6};

        sort(integers);
        displayArray(integers);

        sort(doubles);
        displayArray(doubles);

        sort(shorts);
        displayArray(shorts);
    }

    public static <T extends Comparable> void sort(T[] list) {
        for (int i = 0; i <= list.length - 1; i++) {
            for (int j = i+1; j <= list.length - 1; j++) {
                if (list[i].compareTo(list[j]) > 0) {
                    T temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    public static <T> void displayArray(T[] list) {
        for (Object item: list) {
            System.out.println(item);
        }
    }
}
