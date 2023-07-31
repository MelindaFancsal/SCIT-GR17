package org.example.concurency.concurencyExercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        LinkedList<String> sharedList = new LinkedList<>();
        ConsumerThread consumerThread = new ConsumerThread(sharedList);

        ProducerThread producer = new ProducerThread(sharedList);
        consumerThread.start();
        producer.start();
    }


    private static class ConsumerThread extends Thread {
        private LinkedList<String> sharedList;

        public ConsumerThread(LinkedList<String> sharedList) {
            this.sharedList = sharedList;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (sharedList) {
                        if (sharedList.isEmpty()) {
                            sharedList.wait();
                            System.out.println("C - nothing to consume");
                        } else {
                            sharedList.forEach(s ->
                                    System.out.println("C consumes: " + s)
                            );
                            sharedList.clear();
                            //     System.out.println("C consumes " + sharedList.getFirst());
                            //  sharedList.removeFirst();
                        }

                        sharedList.notify();
                    }

                    Thread.sleep(2000);
                }
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    private static class ProducerThread extends Thread {
        private final static String[] DATA = {"ana", "mere", "oere ", "olahkh", "alala"};

        private LinkedList<String> sharedList;

        public ProducerThread(LinkedList<String> sharedList) {
            this.sharedList = sharedList;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("P - waiting");
                    synchronized (sharedList) {
                        //    if (!sharedList.isEmpty()) {
                        if (sharedList.size() % 2 == 0 && !sharedList.isEmpty()) {
                            sharedList.wait();
                        }

                        String randomString = DATA[new Random().nextInt(5)];
                        sharedList.add(randomString);
                        System.out.println("P -  produces: " + randomString);

                        sharedList.notify();
                    }

                    Thread.sleep(1000);
                }
            } catch (
                    InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
