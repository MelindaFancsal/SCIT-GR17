package org.example.unitTesting;

import java.util.List;

public class UtilsClass {

    public int sum(int a, int b) {
        return a + b;
    }

    //AABC -> BC ; ABC -> BC ; BACAA -> BCAA ; A -> ""

    public String trimFirstChars(String word) {
        if (word.length() < 2) {
            return word.charAt(0) == 'A' ? "" : word;
//            if (word.charAt(0) == 'A') {
//                return "";
//            } else {
//                return word;
//            }
        }


        String firstTwoElements = word.toUpperCase().substring(0, 2);
        String finalWords;

        if (firstTwoElements.equals("AA")) {
            finalWords = word.substring(2);
        } else if (word.charAt(0) == 'A') {
            finalWords = word.substring(1);
        } else {
            finalWords = word;
        }

        return finalWords;
    }

    //AABAA - true; AABCDEA - false
    public boolean areFirstLastTwoCharsIdentical(String word) {
        String firstTwoElements = word.substring(0, 2).toUpperCase();
        String lastTwoElements = word.substring(word.length() - 2).toUpperCase();

        boolean areEqual = firstTwoElements.equals(lastTwoElements);

        return areEqual;
    }

    public int retrieveNumberOfEvenElements(List<Integer> integerList) {
        // [2,1,6,5,7,9] -> 2 elemente pare
        if (integerList == null) {
            return 0;
        }

        int nrElementPare = 0;
        for (Integer item : integerList) {
            if (item % 2 == 0) {
                nrElementPare++;
            }
        }

//        Iterator<Integer> integerIterator = integerList.listIterator();
//        while (integerIterator.hasNext()) {
//            Integer item = integerIterator.next();
//
//            if (item % 2 == 0) {
//                nrElementPare++;
//            }
//        }

        return nrElementPare;
    }


}
