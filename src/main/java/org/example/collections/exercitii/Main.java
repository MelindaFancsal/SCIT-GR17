package org.example.collections.exercitii;

public class Main {

        public static void main(String[] args) {
            ClassA b = new ClassB();

            int a = 4528;
            int d;
            int max = Integer.MIN_VALUE;

            while(a!=0)
            {
                d = a % 10;
                max = Math.max(max, d);
                a = a / 10;
            }
            System.out.println("Max digit of the number a: " + max);
        }

}
