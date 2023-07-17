package org.example.exceptions;

public class ValidationException extends Exception {
    private int codEroare;

    public ValidationException(String mesaj, int codEroare) {
        super(mesaj);
        this.codEroare = codEroare;
    }

    public int getCodEroare() {
        return codEroare;
    }
}
