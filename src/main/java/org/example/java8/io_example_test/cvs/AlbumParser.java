package org.example.java8.io_example_test.cvs;

import org.example.java8.io_example_test.Album;
import org.example.java8.io_example_test.Novel;
import org.example.java8.io_example_test.QUALITY;
import org.example.java8.io_example_test.TYPE;

public class AlbumParser extends CVSBookParser<Album> {

    public Album parseBook(String source) {
        String[] token = source.split(SEPARATOR);

        return new Album(token[2], token[1], QUALITY.valueOf(token[3]));
    }

    public String getParserType() {
        return Album.class.getSimpleName();
    }
}
