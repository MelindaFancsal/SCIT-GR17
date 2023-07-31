package org.example.concurency.stream;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParalelStreaming {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        System.out.println("sequential");
        runStream(list.stream().sequential());

        System.out.println("paralel");
        runStream(list.stream().parallel());
    }

    private static void runStream(Stream<String> stream) {
        stream.forEach(it -> {
            System.out.println(LocalTime.now() + " time " + it + "- thread " + Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
