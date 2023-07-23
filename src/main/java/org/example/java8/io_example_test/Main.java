package org.example.java8.io_example_test;

import org.example.java8.io_example_test.cvs.CVSBookReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        File cvs = new File("src/main/resources/books.cvs");

        try(CVSBookReader reader = new CVSBookReader(Files.newBufferedReader(cvs.toPath()))) {
            List<Book> bookList = reader.readBooks();

            bookList.forEach(System.out::println);
        }
    }
}
