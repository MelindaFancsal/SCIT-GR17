package org.example.concurency.starvation;

import java.util.LinkedList;

public class Producer {
    private LinkedList<String> list;

    public Producer(LinkedList<String> list) {
        this.list = list;
    }

    public void produceItems() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String payload = "P" + i;

                synchronized (list) {
                    list.add(payload);
                }
            }
        }).start();
    }
}
