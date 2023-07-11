package com.ticod.algorithm.sort;

/**
 * 선택 정렬
 * - 최소/최댓값을 첫 번째 원소부터 채우는 방식
 * - 내림차순으로 구현 -> 최댓값을 활용
 */
public class SelectionSort implements Sort {
    @Override
    public void sort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int max = 0;
            int maxIndex = 0;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] > max) {
                    max = elements[j];
                    maxIndex = j;
                }
            }
            if (max > elements[i]) {
                swap(elements, i, maxIndex);
            }
        }
    }
}
