package ru.unn.agile.numerical_integration;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumericMethodTest {
    @Test
    public void shoudReturnZero() {
        assertEquals(NumericMethod.calculate(x -> x * x, 0, 0, 0.1),
                0, 0);

    }
}
