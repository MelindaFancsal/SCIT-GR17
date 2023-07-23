package org.example.java8.io_example_test;

public class Novel extends Book{
    private TYPE type;

    public Novel(String title, String author, TYPE type) {
        super(title, author);
        this.type = type;
    }

    public TYPE getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "type=" + type +
                '}';
    }
}
