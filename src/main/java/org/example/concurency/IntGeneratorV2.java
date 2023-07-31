package org.example.concurency;

import java.util.List;
import java.util.Random;

public class IntGeneratorV2 extends Thread {

    private final List<Integer> intGenerators;
    private final int i;

    public IntGeneratorV2(int i, List<Integer> intGenerators) {
        this.i = i;
        this.intGenerators = intGenerators;
    }

    @Override
    public void run() {
        int generatedNumber = new Random().nextInt(10);
        intGenerators.add(i, generatedNumber);
        System.out.println("Thread: " + Thread.currentThread().getName() + " generated nr: " + generatedNumber);
    }
}
