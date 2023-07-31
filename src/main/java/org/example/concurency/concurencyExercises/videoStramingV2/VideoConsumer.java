package org.example.concurency.concurencyExercises.videoStramingV2;

public class VideoConsumer extends Thread {
    private VideoStream videoStream;

    public VideoConsumer(VideoStream videoStream) {
        this.videoStream = videoStream;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (videoStream) {
                    if (videoStream.getFrame() == null) {
                        System.out.println("Consumer waits...");
                        videoStream.wait();
                    } else {

                        System.out.println("Consumer consumes: " + videoStream.getFrame());
                        videoStream.setFrame(null);
                        videoStream.notify();
                    }


                }
            }
        } catch (InterruptedException exception) {
            //doresc sa arunc o exceptie intitulata VideoFrameErrorException
            throw new VideoFrameErrorException("ERROARE video");
        }
    }
}
