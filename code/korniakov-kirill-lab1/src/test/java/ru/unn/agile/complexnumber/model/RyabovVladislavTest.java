package ru.unn.agile.complexnumber.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RyabovVladislavTest {
    @Test
    public void complexNumbersAddition() {
        ComplexNumber lh = new ComplexNumber(5, -4);
        ComplexNumber rh = new ComplexNumber(7, 6);

        ComplexNumber result = lh.add(rh);

        assertEquals(new ComplexNumber(12, 2), result);
    }

    @Test
    public void complexNumbersAdditionCommutativity() {
        ComplexNumber lh = new ComplexNumber(5, -4);
        ComplexNumber rh = new ComplexNumber(7, 6);

        ComplexNumber lhResult = lh.add(rh);
        ComplexNumber rhResult = rh.add(lh);

        assertEquals(lhResult, rhResult);
    }

    @Test
    public void complexNumbersToStringConversion() {
        ComplexNumber number = new ComplexNumber(0.3333333, -73.02342342);

        assertEquals("0.33 - 73.02i", number.toString());
    }


    @Test
    public void complexNumbersMultiplicationCommutativity() {
        ComplexNumber lh = new ComplexNumber(-2.45, 7.67);
        ComplexNumber rh = new ComplexNumber(123.56, -1.0973);

        ComplexNumber lhResult = lh.multiply(rh);
        ComplexNumber rhResult = rh.multiply(lh);

        assertEquals(lhResult, rhResult);
    }
}

