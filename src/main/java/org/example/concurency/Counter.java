package org.example.concurency;

import javax.sound.midi.Soundbank;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private Integer count = 0;
    private static Counter instance = null;

    public void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }

    public static synchronized Counter getInstance() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
    }
}
