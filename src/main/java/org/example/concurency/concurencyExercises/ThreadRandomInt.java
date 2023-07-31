package org.example.concurency.concurencyExercises;

import javax.swing.plaf.TableHeaderUI;
import java.util.Random;

public class ThreadRandomInt extends Thread {
    private int aNumber;

    @Override
    public void run() {
        aNumber = new Random().nextInt(10);
        System.out.println(Thread.currentThread().getName() + "  " + aNumber);
    }

    public int getaNumber() {
        return aNumber;
    }
}
