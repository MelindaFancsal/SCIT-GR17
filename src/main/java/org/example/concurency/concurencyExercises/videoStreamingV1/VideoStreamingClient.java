package org.example.concurency.concurencyExercises.videoStreamingV1;


public class VideoStreamingClient extends Thread {
    private VideoStream stream;

    public VideoStreamingClient(VideoStream stream) {
        this.stream = stream;
    }

    @Override
    public void run() {
        while (true) {
            try {
            System.out.println("Client consumes: " + stream.getFrame());
            } catch (VideoStreamException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
