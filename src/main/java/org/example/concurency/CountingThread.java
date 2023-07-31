package org.example.concurency;

public class CountingThread implements Runnable {

    @Override
    public void run() {
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

    }
}
