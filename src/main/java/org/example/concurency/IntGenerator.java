package org.example.concurency;

import java.util.Random;

public class IntGenerator implements Runnable{
    private int generatedNumber;
    @Override
    public void run() {
        generatedNumber = new Random().nextInt(10);
        System.out.println("Thread: " + Thread.currentThread().getName() + " generated nr: " + generatedNumber);
    }

    public int getGeneratedNumber() {
        return generatedNumber;
    }
}
