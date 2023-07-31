package org.example.concurency.concurencyExercises.videoStreamingV1;


public class VideoProducer extends Thread {
    private int frame = 0;
    private VideoStream stream;

    public VideoProducer(VideoStream stream) {
        this.stream = stream;
    }

    @Override
    public void run() {
        while (true) {
            //Thread.sleep(2000);
            String frame1 = "F" + frame++;
            try {
                stream.putFrame(frame1);
            } catch (VideoStreamException e) {
                e.printStackTrace(System.err);
            }
            System.out.println("VH: added frame " + frame + " to stream");
        }
    }
}
