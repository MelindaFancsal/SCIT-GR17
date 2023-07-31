package org.example.concurency.concurencyExercises.videoStreamingV1;

public class StreamingExample {
    /*
    Doresc sa creez un o aplicatie care ruleaza un fisier video.
    Voi avea nevoie de un producer care va adauga frame uri in stream ul de date si
    de un consumer care va face play la framurile din stream ul de date
     */

    public static void main(String[] args) {
        VideoStream stream = new VideoStream();

        VideoStreamingClient vsc = new VideoStreamingClient(stream);
        VideoProducer videoProducer = new VideoProducer(stream);
        vsc.start();
        videoProducer.start();
    }
}
