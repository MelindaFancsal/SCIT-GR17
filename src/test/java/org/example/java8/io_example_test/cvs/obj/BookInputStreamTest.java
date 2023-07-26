package org.example.java8.io_example_test.cvs.obj;

import org.example.java8.io_example_test.Book;
import org.example.java8.io_example_test.Novel;
import org.example.java8.io_example_test.TYPE;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import static org.junit.Assert.*;

public class BookInputStreamTest {
    @Test
    public void whenParsingCVSWithOneNovel_shouldReturnAListWithOneNovel() throws IOException, ClassNotFoundException {
        Novel novel = new Novel("Title", "Autor", TYPE.FICTION);
        byte[] serializedObject = null;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(novel);
            serializedObject = baos.toByteArray();
        }

        try (BookInputStream bis = new BookInputStream(new ByteArrayInputStream(serializedObject))) {
            List<Book> books = bis.readBooks();
            assertEquals(1, books.size());
            assertEquals(novel, books.get(0));
        }
    }


}