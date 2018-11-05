package ru.unn.agile.mathstatistics.model;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class MathStatisticsTest {

    @Test
    public void canCalculateExpectedValueWithOneNumbers() {
        Integer[] data = {10};
        Double[]  probability = {1.0};

        Double expectedValue = MathStatistics.calculateExpectedValue(data, probability);

        assertEquals(new Double(10), expectedValue);
    }

    @Test
    public void canCalculateExpectedValueWithOneNegativeInteger() {
        Integer[] data = {-23};
        Double[]  probability = {1.0};

        Double expectedValue = MathStatistics.calculateExpectedValue(data, probability);

        assertEquals(new Double(-23), expectedValue);
    }

    @Test
    public void canCalculateExpectedValuePositiveIntegers() {
        Integer[] data = {10, 5, 25, 30};
        Double[]  probability = {0.25, 0.25, 0.25, 0.25};

        Double expectedValue = MathStatistics.calculateExpectedValue(data, probability);

        assertEquals(new Double(17.5), expectedValue);
    }

    @Test
    public void canCalculateExpectedValueWithDouble() {
        Double[] data = {1.2, 3.3, 0.2, 8.1, 0.9};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        Double expectedValue = MathStatistics.calculateExpectedValue(data, probability);

        assertEquals(new Double(2.74), expectedValue);
    }

    @Test
    public void canCalculateExpectedValueWithIntegersAndDouble() {
        Number[] data = {1.2, 3.3, 11, 2, 8.9, 2, 36, 7.3};
        Double[] probability = {0.125, 0.125, 0.125, 0.125, 0.125, 0.125, 0.125, 0.125};

        Double expectedValue = MathStatistics.calculateExpectedValue(data, probability);

        assertEquals(new Double(8.9625), expectedValue);
    }

    @Test
    public void canCalculateExpectedValueWithNegativeNumbers() {
        Number[] data = {-3, 8.3, 86.2, -3.5};
        Double[] probability = {0.25, 0.25, 0.25, 0.25};

        Double expectedValue = MathStatistics.calculateExpectedValue(data, probability);

        assertEquals(new Double(22.0), expectedValue);
    }

    @Test
    public void canCalculateNegativeExpectedValue() {
        Double[] data = {-10.2, 4.3, 0.0, -31.9, 3.0, 0.33};
        Double[] probability = {0.1667, 0.166666, 0.166666, 0.166666, 0.166666, 0.16666};

        Double expectedValue = MathStatistics.calculateExpectedValue(data, probability);

        assertTrue(Math.abs(-5.745 - expectedValue) <= MathStatistics.EPSILON);
    }

    @Test
    public void canCalculateExpectedValueWithBigSizeOfDataArray() {
        Integer[] data = getMonotonicArray(0, 100);
        Double[]  probability = new Double[100];
        Arrays.fill(probability, 0.01);

        Double expected = new Double((0 + 99) * 100 / 2) * 0.01;

        Double expectedValue = MathStatistics.calculateExpectedValue(data, probability);

        assertEquals(expected, expectedValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateExpectedValueWithNullElement() {
        Number[] data = {1.2, 2, -5, null, 7};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        MathStatistics.calculateExpectedValue(data, probability);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateExpectedValueWithNullData() {
        Double[] data = null;
        Double[] probability = {1.0};

        MathStatistics.calculateExpectedValue(data, probability);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateExpectedValueWithEmptyData() {
        Number[] data = {};
        Double[] probability = {1.0};

        MathStatistics.calculateExpectedValue(data, probability);
    }

    @Test
    public void canCalculateDispersionWithOneNumber() {
        Integer[] data = {8};
        Double[]  probability = {1.0};

        Double dispersion = MathStatistics.calculateDispersion(data, probability);

        assertEquals(new Double(0), dispersion);
    }

    @Test
    public void canCalculateDispersionWithOneNegativeNumber() {
        Integer[] data = {-23};
        Double[]  probability = {1.0};

        Double dispersion = MathStatistics.calculateDispersion(data, probability);

        assertEquals(new Double(0), dispersion);
    }

    @Test
    public void canCalculateDispersionWithNegativeNumbers() {
        Number[] data = {9, 3, -1, 5, -8};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        Double dispersion = MathStatistics.calculateDispersion(data, probability);

        assertEquals(new Double(33.44), dispersion);
    }

    @Test
    public void canCalculateDispersionWithArrayOfZeros() {
        Number[] data = {0, 0, 0, 0};
        Double[] probability = {0.25, 0.25, 0.25, 0.25};

        Double dispersion = MathStatistics.calculateDispersion(data, probability);

        assertEquals(new Double(0.0), dispersion);
    }

    @Test
    public void canCalculateDispersionWithDouble() {
        Number[] data = {7.2, 64.3, -13.8, 0.6, 23.1};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        Double dispersion = MathStatistics.calculateDispersion(data, probability);

        assertEquals(new Double(717.1096), dispersion);
    }

    @Test
    public void canCalculateDispersionWithBigSizeOfDataArray() {
        Integer[] data = getMonotonicArray(0, 100);
        Double[]  probability = new Double[100];
        Arrays.fill(probability, 0.01);

        Double dispersion = MathStatistics.calculateDispersion(data, probability);

        assertTrue(Math.abs(833.2499 - dispersion) <= MathStatistics.EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateDispersionWithNullElement() {
        Number[] data = {2, -3, 5, null, 8};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        MathStatistics.calculateDispersion(data, probability);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateDispersionWithNullData() {
        Double[] data = null;
        Double[] probability = {1.0};

        MathStatistics.calculateDispersion(data, probability);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateDispersionWithEmptyData() {
        Number[] data = {};
        Double[] probability = {1.0};

        MathStatistics.calculateDispersion(data, probability);
    }

    @Test
    public void canCalculateMomentWithOneNumber() {
        Integer[] data = {3};
        Double[]  probability = {1.0};

        Double moment = MathStatistics.calculateMoment(data, probability, 3, 46);

        assertEquals(new Double(-79507.0), moment);
    }

    @Test
    public void canCalculateMomentWithOneNegativeNumber() {
        Integer[] data = {-11};
        Double[]  probability = {1.0};

        Double moment = MathStatistics.calculateMoment(data, probability, 1, 44);

        assertEquals(new Double(-55), moment);
    }

    @Test
    public void canCalculateMomentWithNegativeNumbers() {
        Number[] data = {9, 3, -1, 9, -8};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        Double moment = MathStatistics.calculateMoment(data, probability, 4, 9);

        assertEquals(new Double(18963.4), moment);
    }

    @Test
    public void canCalculateMomentWithArrayOfZeros() {
        Number[] data = {0, 0, 0, 0};
        Double[] probability = {0.25, 0.25, 0.25, 0.25};

        Double moment = MathStatistics.calculateMoment(data, probability, 5, 2);

        assertEquals(new Double(-32.0), moment);
    }

    @Test
    public void canCalculateMomentWithDouble() {
        Number[] data = {7.1, 6.3, 11.8, 0.8, 23.2};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        Double moment = MathStatistics.calculateMoment(data, probability, 3, 3);

        assertTrue(Math.abs(1803.618 - moment) <= MathStatistics.EPSILON);
    }

    @Test
    public void canCalculateMomentWithBigSizeOfDataArray() {
        Integer[] data = getMonotonicArray(-400, 400);
        Double[]  probability = new Double[800];
        Arrays.fill(probability, 0.00125);

        Double moment = MathStatistics.calculateMoment(data, probability, 3, 1);

        assertTrue(Math.abs(-240003.0 - moment) <= MathStatistics.EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMomentWithNullElement() {
        Number[] data = {1, null, 7, 2, 2};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        MathStatistics.calculateMoment(data, probability, 3, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMomentWithNullData() {
        Double[] data = null;
        Double[] probability = {1.0};

        MathStatistics.calculateMoment(data, probability, 1, 2.8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMomentWithEmptyData() {
        Number[] data = {};
        Double[] probability = {1.0};

        MathStatistics.calculateMoment(data, probability, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMomentWithZeroOrder() {
        Number[] data = {0.1, 9.3, 1.8, 0.8, 2.2};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        MathStatistics.calculateMoment(data, probability, 0, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCalculateMomentWithNegativeOrder() {
        Number[] data = {0.1, 0.3, 6.8, -6.8, 2.2};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        MathStatistics.calculateMoment(data, probability, -5, 3);
    }

    @Test
    public void canCalculateExpectedValue() {
        Number[] data = {0, -3, 0.1, 0, 1.9};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        Double expectedValue = MathStatistics.calculateExpectedValue(data, probability);
        Double moment = MathStatistics.calculateMoment(
                data, probability, MathStatistics.EXPECTED_VALUE_ORDER, 0);

        assertEquals(expectedValue, moment);
    }

    @Test
    public void canCalculateCentralMoment() {
        Number[] data = {2.1, 1.2, -3, 0, 4.9};
        Double[] probability = {0.2, 0.2, 0.2, 0.2, 0.2};

        Double dispersion = MathStatistics.calculateDispersion(data, probability);
        Double expectedValue = MathStatistics.calculateExpectedValue(data, probability);
        Double moment = MathStatistics.calculateMoment(
                data, probability, MathStatistics.DISPERSION_ORDER, expectedValue);

        assertEquals(dispersion, moment);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenProbabilityVectorWithNullElement() {
        Number[] data = {1, 3, 7, 4, 2};
        Double[] probability = {0.2, null, 0.2, 0.2, 0.2};

        MathStatistics.calculateMoment(data, probability, 3, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenProbabilityVectorWithNullData() {
        Double[] data = {4.0, 5.0, 6.0, 7.0};
        Double[] probability = null;

        MathStatistics.calculateMoment(data, probability, 1, 2.8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenProbabilityVectorWithEmptyData() {
        Number[] data = {0, -3, 0.1, 0, 1.9};
        Double[] probability = {};

        MathStatistics.calculateMoment(data, probability, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenDataLengthAndProbabilityVectorLengthAreNotEqual() {
        Number[] data = {7.3, -5.1, 9.3, 5.5};
        Double[] probability = {0.1, 0.2, 0.7};

        MathStatistics.calculateDispersion(data, probability);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenTotalProbabilityIsNotEqual1() {
        Number[] data = {1, 3, 7, 4, 2};
        Double[] probability = {0.2, 0.2, 0.13, 0.2, 0.2};

        MathStatistics.calculateExpectedValue(data, probability);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenProbabilityVectorElementIsNegative() {
        Number[] data = {7.3, 5.1, 9.3};
        Double[] probability = {0.1, -0.2, 0.7};

        MathStatistics.calculateDispersion(data, probability);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenProbabilityVectorElementIsMoreThan1() {
        Number[] data = {7.3, 5.1, 9.3};
        Double[] probability = {1.2, 0.5, 0.7};

        MathStatistics.calculateDispersion(data, probability);
    }


    private Integer[] getMonotonicArray(final int start, final int end) {
        Integer[] data = new Integer[end - start];
        for (int i = 0; i < data.length; ++i) {
            data[i] = start + i;
        }
        return data;
    }

}
