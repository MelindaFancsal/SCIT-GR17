package org.example.concurency.concurencyExercises;

import java.util.*;
import java.util.stream.Collectors;

public class SumThreads {
    /*
    5 threaduri genereaza aleator cate un numar. Doresc sa se afiseze suma totala a numerelor generate de thread uri.
     */
    public static void main(String[] args) throws InterruptedException {
    /*    ThreadRandomInt t1 = new ThreadRandomInt();
        ThreadRandomInt t2 = new ThreadRandomInt();
        ThreadRandomInt t3 = new ThreadRandomInt();
        ThreadRandomInt t4 = new ThreadRandomInt();
        ThreadRandomInt t5 = new ThreadRandomInt();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();


        int sum = t1.getaNumber() + t2.getaNumber() + t3.getaNumber() + t4.getaNumber() + t5.getaNumber();
        System.out.println("Suma este: " + sum);*/

        List<ThreadRandomInt> threads = new ArrayList<>();
        // List<Integer> values = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ThreadRandomInt aThread = new ThreadRandomInt();
//            Thread aThread = new Thread(() -> {
//                int a = new Random().nextInt(10);
//                System.out.println(Thread.currentThread().getName() + "  " + a);
//                values.add(a);
//            });
            threads.add(aThread);
        }

        threads.stream().forEach(t -> t.start());
        threads.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //v1
        int sum = 0;
        for (ThreadRandomInt thread : threads) {
            sum = sum + thread.getaNumber();
        }

        //v2
        List<Integer> list = threads.stream().map(thread -> thread.getaNumber()).collect(Collectors.toList());
        Optional<Integer> sum2 = list.stream().reduce((a, b) -> a + b);


//        Optional<Integer> sum = values.stream().reduce((a, b)-> a+b);
//        System.out.println(sum.get());
    }
}
