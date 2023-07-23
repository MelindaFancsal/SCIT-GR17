package org.example.java8.io_example_test.cvs;

import java.util.HashMap;

public class CVSBooksParserFactory {
    private HashMap<String, CVSBookParser<?>> parsers = new HashMap<>();

    public CVSBooksParserFactory() {
        CVSBookParser<?> albumParser = new AlbumParser();
        parsers.put(albumParser.getParserType(), albumParser);

        CVSBookParser<?> novelParser = new NovelParser();
        parsers.put(novelParser.getParserType(), novelParser);
    }

    public CVSBookParser<?> getParseFor(String type) {
        if (parsers.containsKey(type)) {
            return parsers.get(type);
        } else {
            throw new IllegalArgumentException("nu exista acest tip " + type);
        }
    }
}
