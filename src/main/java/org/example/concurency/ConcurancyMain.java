package org.example.concurency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ConcurancyMain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        //   exampleCreateThread1();
        //   exampleCreateRunnableThread();
        //   task1();
        //task2();
        // daemonThreadExample();
        //    task3();
        //  task3_v2();
        //update count using threads
        task4();
    }

    private static void task4() throws InterruptedException {
        Counter counter = new Counter();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                counter.increment();
                //  Counter.getInstance().increment()
            }).start();

        }

        System.out.println("total count is " + counter.getCount());
        //  System.out.println("total count is: " + Counter.getInstance().getCount());
    }

    private static void task3_v2() throws InterruptedException {
        List<Integer> sharedResource = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            IntGeneratorV2 thread = new IntGeneratorV2(i, sharedResource);
            thread.start();
            thread.join();
        }

        Optional<Integer> sum = sharedResource.stream().reduce((a, b) -> a + b);
        //  sharedResource.stream().mapToInt(it -> it).sum()
        System.out.println(sum.get());
    }

    private static void task3() throws InterruptedException {
        List<IntGenerator> intGenerators = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            intGenerators.add(new IntGenerator());
        }

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(intGenerators.get(i));
            threads.add(t);
            t.start();
            t.join();
        }

        int sum = intGenerators.stream().mapToInt(it -> it.getGeneratedNumber()).sum();

        System.out.println(sum);

    }

    private static void daemonThreadExample() {
        Runnable daemonThread = () -> {
            while (true) {
                System.out.println("Sunt un thread de tip daemon");
            }
        };

        Thread thread = new Thread(daemonThread);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.setDaemon(true);
        thread.start();


        try {
            Thread.sleep(5000); //putem thread ul main pe sleep pt 5 sec
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void task2() {
        Runnable runnable = new CountingThread();
        Thread thread = new Thread(runnable);
        thread.start();

        //lamda

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);

                System.out.println("pausing for 1second");
                try {
                    Thread.sleep(1000); //thread ul va dormi pentu 1 secunda
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (i % 10 == 0) {
                    System.out.println("s au afisat inca 10 numere");
                }

            }

        });
        thread1.start();
    }

    private static void task1() {
        Thread thread1 = new StepThread(2);
        thread1.setName("mihai");
        Thread thread2 = new StepThread(3);
        thread2.setName("andrei");
        Thread thread3 = new StepThread(4);
        thread3.setName("alex");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void exampleCreateRunnableThread() {
        //v1
        Runnable runnable = new MyRunnable();

//        Thread thread = new Thread(runnable);
//        thread.start();

        //v2 utilizand lambda

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        });

        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread.start();
    }


    public static void currentThread() {
        //cod
    }

    private static void exampleCreateThread1() {
        Thread thread = new MyThread();
        thread.start();
        //  thread.start();
    }
}
