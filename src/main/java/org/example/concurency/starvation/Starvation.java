package org.example.concurency.starvation;

import java.util.LinkedList;

public class Starvation {
    public static void main(String[] args) {
        LinkedList<String > list = new LinkedList<>();
        Consumer consumer = new Consumer(list);
        Producer producer = new Producer(list);
        consumer.consumerStarvationThread();

        producer.produceItems();
    }
}
