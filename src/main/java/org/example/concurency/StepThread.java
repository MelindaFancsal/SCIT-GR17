package org.example.concurency;

public class StepThread extends Thread {
    private int step;

    public StepThread(int step) {
        this.step = step;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i = i + step) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
