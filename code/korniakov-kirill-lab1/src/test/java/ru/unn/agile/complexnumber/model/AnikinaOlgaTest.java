package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnikinaOlgaTest {

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber number1 = new ComplexNumber(4, 4);
        ComplexNumber number2 = new ComplexNumber(1, 1);

        ComplexNumber result = number1.add(number2);

        assertEquals(new ComplexNumber(5, 5), result);
    }

    @Test
    public void canMultiplyZeroComplexNumberByNotZeroComplexNumber() {
        ComplexNumber notZeroComplexNumber = new ComplexNumber(1, 4);
        ComplexNumber zeroComplexNumber = new ComplexNumber(0, 0);

        ComplexNumber result = notZeroComplexNumber.multiply(zeroComplexNumber);

        assertEquals(new ComplexNumber(0, 0), result);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber number1 = new ComplexNumber(1, 4);
        ComplexNumber number2 = new ComplexNumber(3, 4);

        ComplexNumber result = number1.multiply(number2);

        assertEquals(new ComplexNumber(-13, 16), result);
    }
}
