package com.ticod;

import com.ticod.algorithm.sort.*;

public class SortTest {
    public static void main(String[] args) {
        int[] elements = new int[20];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = (int) (Math.random() * 10000);
        }
        output(elements);
//        new RadixSort().sort(elements);
//        output(elements);
        output(new RadixSort().sort(elements, elements.length));
    }

    private static void output(int[] elements) {
        for (int element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
