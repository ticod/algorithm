package com.ticod.algorithm.sort;

public interface Sort {
    void sort(int[] elements);
    default void swap(int[] elements, int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
