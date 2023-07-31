package org.example.concurency.concurencyExercises.videoStramingV2;

public class StreamingExample {
    public static void main(String[] args) {
        VideoStream videoStream = new VideoStream();
        VideoConsumer videoConsumer = new VideoConsumer(videoStream);
        VideoProducer videoProducer = new VideoProducer(videoStream);

        videoConsumer.start();
        videoProducer.start();
    }
}
