package com.ticod.algorithm.sort;

public class BubbleSort implements Sort {
    @Override
    public void sort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    swap(elements, j, j + 1);
                }
            }
        }
    }
}
