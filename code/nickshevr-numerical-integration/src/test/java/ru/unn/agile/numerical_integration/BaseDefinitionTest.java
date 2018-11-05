package ru.unn.agile.numerical_integration;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseDefinitionTest {
    private final double delta = 0.001;
    private Expression cube = x -> Math.pow(x, 3);
    private Expression square = x -> Math.pow(x, 2);
    private Expression hyperbola = x -> 1 / x;
    private final Class mainClass = BaseDefinition.class;
    private final String defaultMessage = "Don't make instance";

    @Test
    public void shouldBeFinal() {
        UtilityClassTest.testForFinal(mainClass);
    }

    @Test
    public void shouldHaveOneConstructor() {
        UtilityClassTest.shouldHaveOneConstructor(mainClass);
    }

    @Test
    public void constructorShouldBePrivate()
            throws IllegalArgumentException, NoSuchMethodException {
        UtilityClassTest.constructorShouldBePrivate(mainClass);
    }

    @Test
    public void constructorShouldThrowError()
            throws IllegalArgumentException, NoSuchMethodException {
        UtilityClassTest.constructWithExeption(mainClass, defaultMessage);
    }

    @Test
    public void shouldCalculateCube() {
        double result = BaseDefinition.calculate(cube, 0, 1, 0.01);

        assertEquals(result, 0.25, delta);
    }

    @Test
    public void returnZeroBoundEquals() {
        double result = BaseDefinition.calculate(square, 5, 5, 0.01);

        assertEquals(result, 0.0, delta);
    }

    @Test
    public void returnInfinityIfUnbounded() {
        double result = BaseDefinition.calculate(hyperbola, -0.005, 1, 0.01);

        assertEquals(result, Double.POSITIVE_INFINITY, delta);
    }

    @Test
    public void shouldReturnZero() {
        double result = BaseDefinition.calculate(cube, 0, 0, 0.01);

        assertEquals(result, 0, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void returnErrorDxNegative() {
        BaseDefinition.calculate(cube, 0, 1, -0.01);
    }
}
