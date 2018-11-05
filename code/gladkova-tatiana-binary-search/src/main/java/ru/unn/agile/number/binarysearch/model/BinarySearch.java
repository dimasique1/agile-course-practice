package ru.unn.agile.number.binarysearch.model;

public class BinarySearch {

    private int[] array;
    private int size;


    public BinarySearch(final int[] arrayParam) {
        if (arrayParam.length != 0) {
            array = arrayParam;
            size = array.length;
        } else {
            throw new NullPointerException("Размер массива равен нулю");
        }
    }

    public int[] getArray() {
        return array;
    }

    public boolean inLeftHalf(final int key) {
        return  (key < array[size / 2]);
    }

    public boolean inRightHalf(final int key) {
        return (array[size / 2] < key);
    }

    public int search(final int key) {
        int middle;
        int leftBorder = 0;
        int rightBorder = size - 1;

        if (checkOrderedArray()) {
            while ((leftBorder <= rightBorder)) {
                middle = (leftBorder + rightBorder) / 2;
                if (key > array[middle]) {
                    leftBorder = middle + 1;
                }
                if (key < array[middle]) {
                    rightBorder = middle - 1;
                }
                if (key == array[middle]) {
                    return middle;
                }
            }
        }
        return -1;
    }

    public boolean checkOrderedArray() {
            for (int i = 0; i < size - 1; i++) {
            if (array[i] > array[i + 1]) {
                throw new NullPointerException("Массив не отсортирован");
            }
        }
        return true;
    }
}
