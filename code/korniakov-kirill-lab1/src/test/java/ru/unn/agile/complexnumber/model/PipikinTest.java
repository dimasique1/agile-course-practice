package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class PipikinTest {

    @Test
    public void canMultiplyNumbersWithNegativeParts() {
        ComplexNumber z1 = new ComplexNumber(1.00, -2.00);
        ComplexNumber z2 = new ComplexNumber(-3.00, 1.00);

        assertEquals(new ComplexNumber(-1.00, 7.00), z1.multiply(z2));
    }

    @Test
    public void formatOfSum() {
        ComplexNumber z1 = new ComplexNumber(1.12, -2.47);
        ComplexNumber z2 = new ComplexNumber(-3.22, 1.45);

        assertEquals("-2.1 - 1.02i", z1.add(z2).toString());
    }

    @Test
    public void canAddNegativeAndPositive() {
        ComplexNumber z1 = new ComplexNumber(1.00, 24.00);
        ComplexNumber z2 = new ComplexNumber(-7.00, -15.00);

        assertEquals(new ComplexNumber(-6.00, 9.00), z1.add(z2));
    }
}
