package ru.unn.agile.numerical_integration;

import org.junit.Test;

import static org.junit.Assert.*;


public class RecursionSumTest {
    private final double delta = 0;

    private Expression step = x -> x + 1;
    private Expression square = x -> x * x;
    private Expression cube = x -> Math.pow(x, 3);
    private final Class mainClass = FpUtils.class;
    private final String defaultMessage = "It's static util";

    @Test
    public void constructorShouldThrowError()
            throws IllegalArgumentException, NoSuchMethodException {
        UtilityClassTest.constructWithExeption(mainClass, defaultMessage);
    }

    @Test
    public void shouldReturnZero() {
        double result = FpUtils.recursionSum(square, step, 0, 0);

        assertEquals(result, 0, delta);
    }

    @Test
    public void shouldCalcSquareSum() {
        double result = FpUtils.recursionSum(square, step, 0, 2);

        assertEquals(result, 5, delta);
    }

    @Test
    public void shouldCalcCubeSum() {
        double result = FpUtils.recursionSum(cube, step, 0, 2);

        assertEquals(result, 9, delta);
    }
}
