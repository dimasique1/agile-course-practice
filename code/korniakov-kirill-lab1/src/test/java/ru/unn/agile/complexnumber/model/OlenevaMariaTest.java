package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OlenevaMariaTest {

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(5, -5);
        ComplexNumber z2 = new ComplexNumber(-1, 1);

        ComplexNumber z = z1.add(z2);

        assertEquals(new ComplexNumber(4, -4), z);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(5, -5);
        ComplexNumber z2 = new ComplexNumber(-1, 1);

        ComplexNumber z = z1.multiply(z2);

        assertEquals(new ComplexNumber(0, 10), z);
    }

    @Test
    public void canSetRealComplexNumber() {
        ComplexNumber z = new ComplexNumber(5, -5);

        z.setReal(10);

        assertEquals(new ComplexNumber(10, -5), z);
    }

    @Test
    public void canSetImaginaryComplexNumber() {
        ComplexNumber z = new ComplexNumber(5, -5);

        z.setImaginary(10);

        assertEquals(new ComplexNumber(5, 10), z);
    }

    @Test
    public void canFormatToStringComplexNumber() {
        ComplexNumber z = new ComplexNumber(5.8, -5.5);

        String sz = z.toString();

        assertEquals("5.8 - 5.5i", sz);
    }

}
