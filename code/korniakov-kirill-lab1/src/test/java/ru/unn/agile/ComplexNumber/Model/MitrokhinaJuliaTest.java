package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MitrokhinaJuliaTest {

    private final double eps = 0.001;

    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2, 0);
        ComplexNumber z2 = new ComplexNumber(0, 1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(2, 1), z);
    }

    @Test
    public void canGetImaginaryPartComplexNumber() {
        // Arrange
        ComplexNumber z = new ComplexNumber(2, -1);

        // Act
        double im = z.getImaginary();

        // Assert
        assertEquals(-1, im, eps);
    }

    @Test
    public void canGetRealPartComplexNumber() {
        // Arrange
        ComplexNumber z = new ComplexNumber(-2, 1);

        // Act
        double re = z.getReal();

        // Assert
        assertEquals(-2, re, eps);
    }
}


