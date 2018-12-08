package ru.unn.agile.complexnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PodchishchaevaMariyaTest {
    @Test
    public void canAddComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(3, 4);

        ComplexNumber z = z1.add(z2);

        assertEquals(new ComplexNumber(4, 6), z);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(0, 1);
        ComplexNumber z2 = new ComplexNumber(2, 0);

        ComplexNumber z = z1.multiply(z2);

        assertEquals(new ComplexNumber(0, 2), z);
    }

    @Test
    public void checkToSting() {
        ComplexNumber z1 = new ComplexNumber(0.5, -0.5);

        String z1Str = z1.toString();

        assertEquals("0.5 - 0.5i", z1Str);
    }
}
