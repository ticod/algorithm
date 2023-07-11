package com.ticod.algorithm.sort;

/**
 * 삽입 정렬
 * 1. 제일 첫 원소는 정렬되었다고 가정, 두 번째 원소부터 첫 index로 선택
 * 2. index로 선택된 원소를 정렬된 범위 내에 삽입할 위치를 찾는다.
 *   2.1. 정렬된 범위는 0 ~ (index - 1)
 * 3. 현재 index부터 삽입할 위치까지 shift 연산 수행
 * 4. 전체 데이터에 대해 위 반복
 */
public class InsertionSort implements Sort {
    @Override
    public void sort(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            int targetIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (elements[i] < elements[j]) {
                    targetIndex = j;
                }
            }
            if (targetIndex != i) {
                for (int j = i; j > targetIndex; j--) {
                    swap(elements, j, j - 1);
                }
            }
        }
    }
}
