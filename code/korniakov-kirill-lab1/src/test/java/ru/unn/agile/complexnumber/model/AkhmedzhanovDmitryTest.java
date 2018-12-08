package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class AkhmedzhanovDmitryTest {

    private final double delta = 0.001;

    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2.3, 4.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 2.2);

        // Act
        ComplexNumber result = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(3.3, 6.2), result);
    }

    @Test
    public void canMultiplyComplexNumberByZero() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(4.0, -5.0);
        ComplexNumber z2 = new ComplexNumber(0, 0);

        // Act
        ComplexNumber z = z1.multiply(z2);

        // Assert
        assertEquals(new ComplexNumber(0, 0), z);
    }

    @Test
    public void canGetRealComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2.0, 1.0);

        // Act
        double re = z1.getReal();

        // Assert
        assertEquals(2.0, re, delta);
    }
}
