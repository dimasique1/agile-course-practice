package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlegontovAlexanderTest {
    @Test
    public void canAddNegativeComplexNumbers() {
        ComplexNumber c1 = new ComplexNumber(-1, -2);
        ComplexNumber c2 = new ComplexNumber(-3, -4);

        ComplexNumber sum = c2.add(c1);

        assertTrue(sum.equals(new ComplexNumber(-4, -6)));
    }

    @Test
    public void canMultComplexNumbers() {
        ComplexNumber c1 = new ComplexNumber(0.6, 0.33);
        ComplexNumber c2 = new ComplexNumber(8, 1);

        ComplexNumber mult = c2.multiply(c1);

        assertEquals(new ComplexNumber(4.47, 3.24), mult);
    }

    @Test
    public void areComplexNumbersEquivalent() {
        ComplexNumber c1 = new ComplexNumber(1.1, 4.3);
        ComplexNumber c2 = new ComplexNumber(1.1, 4.3);

        assertTrue(c2.equals(c1));
    }
}
