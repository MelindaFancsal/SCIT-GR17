package org.example.exceptions;

public class Perechi<T extends Item> {
    private T primulItem;
    public T alDoileaItem;

    public Perechi(T primulItem, T alDoileaItem) {
        this.primulItem = primulItem;
        this.alDoileaItem = alDoileaItem;
    }


    public void verifica() throws PairNotMatchingException {
        if (primulItem.getCuloare() != alDoileaItem.getCuloare()) {
            throw new PairNotMatchingException("nu coincid culorile", PairNotMatchingException.ERROR_TYPE.CULOARE);
        }

        if (primulItem.getMarime() != alDoileaItem.getMarime()) {
            throw new PairNotMatchingException("nu coincid marimile", PairNotMatchingException.ERROR_TYPE.MARIME);
        }
    }
    public T getAlDoileaItem() {
        return alDoileaItem;
    }

    public T getPrimulItem() {
        return primulItem;
    }
}
