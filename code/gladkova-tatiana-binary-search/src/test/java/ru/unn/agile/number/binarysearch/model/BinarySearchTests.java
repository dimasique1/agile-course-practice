package ru.unn.agile.number.binarysearch.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinarySearchTests {

    @Test
    public void canInitializeBinarySearch() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch binarySearch = new BinarySearch(array);

        assertEquals(array, binarySearch.getArray());
    }

    @Test
    public void isKeyLocateOnTheRightHalfOfTheArray() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 8;
        BinarySearch binarySearch = new BinarySearch(array);

        assertTrue(binarySearch.inRightHalf(key));
    }

    @Test
    public void isKeyLocateOnTheLeftHalfOfTheArray() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 2;
        BinarySearch binarySearch = new BinarySearch(array);

        assertTrue(binarySearch.inLeftHalf(key));
    }

    @Test
    public void canSearchKeyInArray() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 7;
        BinarySearch binarySearch = new BinarySearch(array);

        assertEquals(7, binarySearch.search(key));
    }

    @Test
    public void canSearchLastKeyInArray() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 9;
        BinarySearch binarySearch = new BinarySearch(array);

        assertEquals(9, binarySearch.search(key));
    }

    @Test
    public void canSearchMiddleKeyInArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 5;
        BinarySearch binarySearch = new BinarySearch(array);

        assertEquals(4, binarySearch.search(key));
    }

    @Test
    public void canSearchFirstKeyInArray() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 0;
        BinarySearch binarySearch = new BinarySearch(array);

        assertEquals(0, binarySearch.search(key));
    }

    @Test
    public void canNotSearchKeyInArray() {
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8};
        int key = 4;
        BinarySearch binarySearch = new BinarySearch(array);

        assertEquals(-1, binarySearch.search(key));
    }

    @Test
    public void canToIdentifyAnOrderedArray() {
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8};
        BinarySearch binarySearch = new BinarySearch(array);

        assertTrue(binarySearch.checkOrderedArray());
    }

    @Test(expected = NullPointerException.class)
    public void canExceptionAnEmptyArray() {
        int[] array = {};
        BinarySearch binarySearch = new BinarySearch(array);
    }


    @Test(expected = NullPointerException.class)
    public void canToIdentifyAnUnorderedArray() {
        int[] array = {0, 2, 8, 3, 9, 6, 4, 7};
        BinarySearch binarySearch = new BinarySearch(array);

        binarySearch.checkOrderedArray();
    }
}
