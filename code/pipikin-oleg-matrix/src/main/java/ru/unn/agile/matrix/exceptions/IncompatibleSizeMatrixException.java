package ru.unn.agile.matrix.exceptions;

public class IncompatibleSizeMatrixException extends RuntimeException {
    public IncompatibleSizeMatrixException() {

        super("Processing matrices does not have compatible size");
    }
}
