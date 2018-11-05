package ru.unn.agile.bitarray.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BitArray {

    private List<Integer> bits;

    BitArray() {
        bits = new ArrayList<>();
    }

    BitArray(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Argument must be positive number");
        }

        int localNumber = number;
        bits = new ArrayList<>();

        if (localNumber == 0) {
            return;
        }

        do {
            bits.add(localNumber % 2);
            localNumber /= 2;
        } while (localNumber != 0);

        Collections.reverse(bits);
    }

    BitArray(final List<Integer> bitArray) {
        if (bitArray == null) {
            throw new NullPointerException();
        }

        if (bitArray.stream().anyMatch(i -> !isOneOrZero(i))) {
            throw new IllegalArgumentException("Array must contains only 1 and 0");
        }

        int i = 0;
        while (!bitArray.isEmpty() && bitArray.get(i) == 0) {
            bitArray.remove(i);
        }

        bits = bitArray;
    }

    public int size() {
        return bits.size();
    }

    public int getAtIndex(final int index) {
        return bits.get(index);
    }

    public void add(final int bit) {
        if (!isOneOrZero(bit)) {
            throw new IllegalArgumentException("Array must contains only 1 and 0");
        }

        bits.add(bit);
    }

    public void remove(final int index) {
        bits.remove(index);
    }

    public void replace(final int index, final int bit) {
        if (!isOneOrZero(bit)) {
            throw new IllegalArgumentException("Array must contains only 1 and 0");
        }

        bits.set(index, bit);
    }

    public int toInt() {
        int result = 0;

        for (int i = 0; i < bits.size(); i++) {
            result += bits.get(i) * Math.pow(2, size() - i - 1);
        }

        return result;
    }

    @Override
    public String toString() {
        return bits
                .stream()
                .map(e -> e.toString())
                .collect(Collectors.joining(""));
    }

    public boolean isEqual(final BitArray other) {
        return toInt() == other.toInt();
    }

    private boolean isOneOrZero(final int number) {
        return number == 1 || number == 0;
    }
}
