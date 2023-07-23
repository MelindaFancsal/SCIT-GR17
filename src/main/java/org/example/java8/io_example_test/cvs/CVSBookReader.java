package org.example.java8.io_example_test.cvs;

import org.example.java8.io_example_test.Book;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CVSBookReader extends BufferedReader {
    private CVSBooksParserFactory parserFactory = new CVSBooksParserFactory();

    public CVSBookReader(@NotNull Reader in) {
        super(in);
    }

    public List<Book> readBooks() throws IOException {
        String line = readLine();

        List<Book> books = new ArrayList<>();

        while (line != null) {
            String[] tokens = line.split(", ");
            String bookType = tokens[0];

            // !! FACTORY PATTERN
            Book book = parserFactory.getParseFor(bookType).parseBook(line);
            books.add(book);
            line = readLine();

        }

        return books;
    }
}
