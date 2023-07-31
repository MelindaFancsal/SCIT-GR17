package org.example.concurency.deadlock;

public class Deadlock {
    public static void main(String[] args) {
        final String resource1 = "resource1";
        final String resource2 = "resource2";

        Thread a = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread a locks resource1");
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (resource2) {
                System.out.println("Thread a locks resource 2");
            }
        });

        Thread b = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread b locks resource2");
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (resource1) {
                System.out.println("Thread b locks resource 1");
            }
        });

        a.start();
        b.start();
    }
}
