package com.ticod.algorithm.sort;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] elements) {
        sort(elements, 0, elements.length);
    }

    public int[] sort(int[] elements, int start, int n) {
        if (n <= 1) {
            int[] result = new int[1];
            result[0] = elements[start];
            return result;
        }
        double mid = n / 2.0;
        int[] aNumbers = sort(elements, start, (int) Math.ceil(mid));
        int[] bNumbers = sort(elements, start + (int) mid, (int) mid);
        return merge(aNumbers, bNumbers);
    }

    private int[] merge(int[] aNumbers, int[] bNumbers) {
        int[] result = new int[aNumbers.length + bNumbers.length];
        int aIndex = 0, bIndex = 0, resultIndex = 0;
        while (aIndex < aNumbers.length && bIndex < bNumbers.length) {
            if (aNumbers[aIndex] <= bNumbers[bIndex]) {
                result[resultIndex++] = aNumbers[aIndex++];
            } else {
                result[resultIndex++] = bNumbers[bIndex++];
            }
        }
        while (aIndex < aNumbers.length) {
            result[resultIndex++] = aNumbers[aIndex++];
        }
        while (bIndex < bNumbers.length) {
            result[resultIndex++] = bNumbers[bIndex++];
        }
        return result;
    }
}
