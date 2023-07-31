package org.example.concurency.concurencyExercises.videoStreamingV1;

public class VideoStream {
    private String frame;

    public synchronized String getFrame() throws VideoStreamException{
        try {
            if (frame == null) {
                wait();
            }

            String f = frame;
            frame = null;

            notify();
            return f;
        } catch (InterruptedException ex) {
            throw new VideoStreamException(ex);
        }
    }

    public synchronized void putFrame(String frame)  throws VideoStreamException {
        try {
            if (this.frame != null) {
                wait();
            }

            this.frame = frame;
            notify();
        } catch (InterruptedException ex) {
            throw new VideoStreamException(ex);
        }
    }
}
