package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FytovAleksandrTest {
    @Test
    public void canAddComplexNumbers() {
        // Arrange
        ComplexNumber number1 = new ComplexNumber(5, 1);
        ComplexNumber number2 = new ComplexNumber(1, 5);

        // Act
        ComplexNumber sum = number1.add(number2);

        // Assert
        assertEquals(new ComplexNumber(6, 6), sum);
    }

    @Test
    public void canCompareComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(3, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(3, 1);

        assertTrue(complexNumber1.equals(complexNumber2));
    }

    @Test
    public void areNotEqualNumbers() {
        // Arrange
        ComplexNumber z1 = new ComplexNumber(5.1, 6.2);
        ComplexNumber z2 = new ComplexNumber(5.12, 6.25);

        // Act
        boolean isEqual = z1.equals(z2);

        // Assert
        assertFalse(isEqual);
    }
}
