package org.example.exceptions;

public class PairNotMatchingException extends Exception {

    private final ERROR_TYPE errorType;

    enum ERROR_TYPE {
        CULOARE,
        MARIME
    }

    public PairNotMatchingException(String mesaj, ERROR_TYPE errorType) {
        super(mesaj);
        this.errorType = errorType;
    }

    public ERROR_TYPE getErrorType() {
        return errorType;
    }
}
