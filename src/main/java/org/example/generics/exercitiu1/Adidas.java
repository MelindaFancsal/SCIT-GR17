package org.example.generics.exercitiu1;

import java.util.Objects;

public class Adidas implements Papuc {
    private String color;
    private int size;

    public Adidas(String color, int size) {
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
        if (!(o instanceof Adidas adidas)) return false;
        return size == adidas.size && Objects.equals(color, adidas.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size);
    }
}
