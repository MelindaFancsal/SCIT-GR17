package org.example.concurency.concurencyExercises.videoStramingV2;

import java.util.Random;

public class VideoProducer extends Thread {
    private int frame;

    private VideoStream videoStream;

    public VideoProducer(VideoStream videoStream) {
        this.videoStream = videoStream;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (videoStream) {
                    if (videoStream.getFrame() != null) {
                        System.out.println("Producer ...waits");
                        videoStream.wait();
                    } else {

                        frame++;
                        System.out.println("Producer ...produces: " + frame);
                        videoStream.setFrame(String.valueOf(frame));
                        videoStream.notify();
                    }

                }

            }
        } catch (InterruptedException e) {

        }
    }
}
