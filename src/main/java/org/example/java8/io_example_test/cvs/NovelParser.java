package org.example.java8.io_example_test.cvs;

import org.example.java8.io_example_test.Novel;
import org.example.java8.io_example_test.TYPE;

import javax.swing.plaf.PanelUI;

public class NovelParser extends CVSBookParser<Novel> {

    public Novel parseBook(String source) {
        String [] token = source.split(SEPARATOR);


        return new Novel(token[2], token[1], TYPE.valueOf(token[3]));
     }
    @Override
    public String getParserType() {
        return Novel.class.getSimpleName();
    }
}
