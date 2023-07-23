package org.example.java8.io_example_test.cvs;

import org.example.java8.io_example_test.Album;
import org.example.java8.io_example_test.Book;
import org.example.java8.io_example_test.QUALITY;

public abstract class CVSBookParser<T> {
    public static final String SEPARATOR = ", ";

    public abstract String getParserType();

    public abstract Book parseBook(String source);
}
