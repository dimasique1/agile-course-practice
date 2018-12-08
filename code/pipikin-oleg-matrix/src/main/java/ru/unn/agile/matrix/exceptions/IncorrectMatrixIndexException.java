package ru.unn.agile.matrix.exceptions;

public class IncorrectMatrixIndexException extends RuntimeException {
    public IncorrectMatrixIndexException() {

        super("Matrix index is out of bounds ");
    }
}

