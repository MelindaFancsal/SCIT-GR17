package org.example.generics.exercitiu1;

import java.util.Objects;

public class PapucToc implements Papuc {
    private String color;
    private int size;

    public PapucToc(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getSize() {
        return size;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PapucToc papucToc)) return false;
        return size == papucToc.size && Objects.equals(color, papucToc.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size);
    }
}