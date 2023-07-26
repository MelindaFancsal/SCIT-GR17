package org.example.java8.io_example_test.cvs.obj;

import org.example.java8.io_example_test.Book;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookInputStream extends ObjectInputStream {
    private InputStream in;

    public BookInputStream(InputStream in) throws IOException {
        super(in);
        this.in = in;
    }

    public List<Book> readBooks() throws IOException, ClassNotFoundException {
        List<Book> books = new ArrayList<>();

        int available = in.available();
        while (available > 0) {
            Object obj = readObject();
            books.add((Book) obj);
            available = in.available();
        }

        return books;
    }
}
