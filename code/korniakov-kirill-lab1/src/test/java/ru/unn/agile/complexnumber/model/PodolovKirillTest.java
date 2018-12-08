package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class PodolovKirillTest {

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(5, 1);
        ComplexNumber z2 = new ComplexNumber(1, 8);

        ComplexNumber sum = z1.add(z2);

        assertEquals(new ComplexNumber(6, 9), sum);
    }

    @Test
    public void canMultiplyComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(3, 7);
        ComplexNumber z2 = new ComplexNumber(8, 2);

        ComplexNumber mult = z1.multiply(z2);

        assertEquals(new ComplexNumber(10, 62), mult);
    }

    @Test
    public void areEquivalentComplexNumbersEquivalent() {
        ComplexNumber z1 = new ComplexNumber(5.28, 1.14);
        ComplexNumber z2 = new ComplexNumber(5.28, 1.14);

        assertTrue(z1.equals(z2));
    }
}
