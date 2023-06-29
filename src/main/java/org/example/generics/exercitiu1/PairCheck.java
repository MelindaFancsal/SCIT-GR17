package org.example.generics.exercitiu1;

public class PairCheck<T extends Papuc> {
    private T papuc1;
    private T papuc2;

    PairCheck(T papuc1, T papuc2) {
        this.papuc1 = papuc1;
        this.papuc2 = papuc2;
    }

    public boolean isPair() {
        return this.papuc1.equals(this.papuc2);
    }


}
