package org.example.concurency.starvation;

import java.util.LinkedList;

public class Consumer {
    private LinkedList<String> list;

    public Consumer(LinkedList<String> list) {
        this.list = list;
    }

    public void consumerStarvationThread() {
        new Thread(() -> {
            synchronized (list) {
                while (true) {
                    System.out.println("list content: "+ list);
                    System.out.println("consumed: " + list.poll());
                }
            }
        }).start();
    }
}
