package org.example.generics.exercitiu1;

import java.util.Objects;

public class Cizma implements Papuc {
    private String color;
    private int size;

    public Cizma(String color, int size) {
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
        if (!(o instanceof Cizma cizma)) return false;
        return size == cizma.size && Objects.equals(color, cizma.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size);
    }
}
