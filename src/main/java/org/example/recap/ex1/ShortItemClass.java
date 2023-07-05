package org.example.recap.ex1;

public class ShortItemClass extends IntItemClass {
    public static void main(String[] args) {
        Short aShortItem = 3;

       // Long aLongItem = new Long(4);
        System.out.println(new ShortItemClass().count(aShortItem, 5));
    }
}
