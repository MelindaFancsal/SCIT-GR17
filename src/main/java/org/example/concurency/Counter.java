package org.example.concurency;

import javax.sound.midi.Soundbank;

public class Counter {
    private int count = 0;
    private static Counter instance = null;

    public  void increment() {
        count++;
    }

    public  int getCount() {
        return count;
    }

    public static synchronized Counter getInstance() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
    }
}
