package org.example.java8;

import java.util.Comparator;

public class MyIntComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
       /* if (o1 > o2) {
            return 1;
        } else if (o1 <o2) {
            return -1;
        } else {
            return 0;
        }*/

      return  (o1 > o2) ? 1 : (o1 < o2) ? -1 : 0;
    }
}
