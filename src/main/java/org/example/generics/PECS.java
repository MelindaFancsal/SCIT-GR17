package org.example.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PECS {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        double result = getTotalNumberSum(integerList);

        displayList(integerList);
        System.out.println(result);


        List<Double> doubleList = Arrays.asList(1.1, 2.3, 4.5);
        result = getTotalNumberSum(doubleList);

        displayList(doubleList);
        System.out.println(result);

        displayEvenNumberFromList(doubleList);


        List<String> stringList = new ArrayList<>();
        stringList.add("test");

        displayList(stringList);

        List<? extends Number> numberList = Arrays.asList(1,2,3,4,5,6);
        Number item = numberList.get(0);
      //  numberList.add(1);
//        numberList.add(new Integer(10));
//        numberList.add(new Double(10))

        List<? super Integer> integerLists = new ArrayList<>();
       // Integer itemInt = integerLists.get(0);
        Object itemInt = integerLists.get(0);


        integerLists.add(Integer.valueOf(10));
        integerLists.add(10);

    }

    private static void displayEvenNumberFromList(List<? extends Number> list) {
        for (Number item : list) {
            if (item.doubleValue() % 2 == 0) {
                System.out.println(item+ "  ");
            }
        }

    }


    private static void displayList(List<?> list) {
        for (Object item : list) {
            System.out.println(item + " ");
        }
    }

    private static double getTotalNumberSum(List<? extends Number> list) {
        double sum = 0;

        for (Number item : list) {
            sum += item.doubleValue();
        }

        return sum;
    }

//    private static int getTotalSum(List<Integer> list) {
//        int sum = 0;
//
//        for (Integer item: list) {
//            sum += item;
//        }
//
//        return sum;
//    }
//
//    private static double getTotalDoubleSum(List<Double> list) {
//        int sum = 0;
//
//        for (Double item: list) {
//            sum += item;
//        }
//
//        return sum;
//    }
}
