package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class KryukovaPolinaTest {

    private final double delta = 0.001;

    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 0);
        ComplexNumber z2 = new ComplexNumber(0, 1);

        // Act
        ComplexNumber z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(1, 1), z);
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

    @Test
    public void canMultiplyComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(3, 4);

        // Act
        ComplexNumber z = z1.multiply(z2);

        // Assert
        assertEquals(new ComplexNumber(-5, 10), z);
    }

    @Test
    public void canEqualsComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(1, 2);

        // Act
        boolean complexNumbersAreEqual = z1.equals(z2);

        // Assert
        assertEquals(true, complexNumbersAreEqual);
    }
}
