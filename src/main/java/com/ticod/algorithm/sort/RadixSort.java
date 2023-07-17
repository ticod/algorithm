package com.ticod.algorithm.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort implements Sort {
    private final static int MAX_RADIX = 5;
    @Override
    public void sort(int[] elements) {

    }

    public int[] sort(int[] elements, int n) {
        int[] results = new int[n];
        ArrayList<Queue<Integer>> queues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queues.add(new LinkedList<>());
        }
        for (int element : elements) {
            queues.get(element % 10).add(element);
        }
        for (int i = 0; i < MAX_RADIX; i++) {
            int radix = 1;
            for (int j = 0; j < i; j++) {
                radix *= 10;
            }
            int resultIndex = 0;
            for (Queue<Integer> queue : queues) {
                while (!queue.isEmpty()) {
                    results[resultIndex++] = queue.poll();
                }
            }
            for (int result : results) {
                queues.get(result / radix % 10).add(result);
            }
        }
        return results;
    }
}
