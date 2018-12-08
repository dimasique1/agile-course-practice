package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class KrutoberezhskayaIrinaTest {

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
    public void canMultiplyComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2, 3);
        ComplexNumber z2 = new ComplexNumber(5, 1);

        // Act
        ComplexNumber z = z1.multiply(z2);

        // Assert
        assertEquals(new ComplexNumber(7, 17), z);
    }

    @Test
    public void canGetImaginaryComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2, 3);

        // Act
        double z = z1.getImaginary();

        // Assert
        assertEquals(3, z, delta);
    }

    @Test
    public void canGetRealComplexNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(2, 3);

        // Act
        double z = z1.getReal();

        // Assert
        assertEquals(2, z, delta);
    }
}

