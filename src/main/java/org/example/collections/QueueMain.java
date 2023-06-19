package org.example.collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(10);
        queue.add(20);

        Integer head = queue.remove();
        System.out.println(head);

    }
}
