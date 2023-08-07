package org.example.JDBC;

import org.example.concurency.concurencyExercises.ThreadRandomInt;

import java.util.ArrayList;
import java.util.List;

public class RECAP_FINAL_QUIZ {
    private static Thread t1, t2;

    public static void main(String[] args) {


        //ex1
//        Thread thread = new Thread(new MyRunnable());
//        thread.start();

        //ex2
        ex2();


        /*
        clasa A  {
        m()
        }

        clasa B extends A {
        m1()
        }

        A obiect = new B();

      ( (B) obiect).m1();

         */

    }

    private static void ex2() {
        t1 = new Thread() {
            @Override
            public void run() {

                try {
                    System.out.println("T1");


                    t2.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("T2");
                }

                System.out.println("T3");
            }

        };


        t2 = new Thread() {
            @Override
            public void run() {

                try {
                    //   sleep(5000);
                    System.out.println("T4");


                    t1.wait();

                    t1.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("T5");
                }


                System.out.println("T6");

            }
        };

        t1.start();
        t2.start();

        //T1
    }

}
