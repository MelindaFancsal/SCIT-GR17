package org.example.java8.io_example_test;

public class Album extends Book{
    private QUALITY quality;


    public Album(String title, String author, QUALITY quality) {
        super(title, author);
        this.quality = quality;
    }

    public QUALITY getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return "Album{" +
                "quality=" + quality +
                '}';
    }
}
