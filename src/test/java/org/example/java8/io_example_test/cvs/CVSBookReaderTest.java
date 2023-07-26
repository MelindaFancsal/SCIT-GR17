package org.example.java8.io_example_test.cvs;

import org.example.java8.io_example_test.Book;
import org.example.java8.io_example_test.Novel;
import org.example.java8.io_example_test.TYPE;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.*;

public class CVSBookReaderTest {
    private String inputString;
    private StringReader reader;

    @Test
    public void whenParsingCVSWithOneNovel_shouldReturnAListWithOneNovel() throws IOException {
        inputString = "Novel, Autor, NumeNuvela, FICTION";
        reader = new StringReader(inputString);

        try (CVSBookReader bookReader = new CVSBookReader(reader)) {
            List<Book> bookList = bookReader.readBooks();
            assertEquals(1, bookList.size());

            Novel novel = new Novel("NumeNuvela", "Autor", TYPE.FICTION);
            assertEquals(novel, bookList.get(0));
        }
    }

    @Test
    public void whenParsingCVSWithTwoNovel_shouldReturnAListWithTwoNovel() throws IOException {
        inputString = "Novel, Autor, NumeNuvela, FICTION\n" +
                "Novel, Autor2, NumeN, FANTACY";

        reader = new StringReader(inputString);

        try (CVSBookReader bookReader = new CVSBookReader(reader)) {
            List<Book> bookList = bookReader.readBooks();
            assertEquals(2, bookList.size());

            Novel novel1 = new Novel("NumeNuvela", "Autor", TYPE.FICTION);
            assertEquals(novel1, bookList.get(0));

            Novel novel2 = new Novel("NumeN", "Autor2", TYPE.FANTACY);
            assertEquals(novel2, bookList.get(1));
        }
    }


}