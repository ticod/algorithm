package com.ticod.algorithm.sort;

/**
 * 퀵 정렬
 * - 분할 정복 알고리즘
 * - partition 메서드와 partition 메서드로 나누어진 두 부분배열에 대해 재귀적으로 반복
 *   - 원소가 하나인 부분배열에서 재귀함수 탈출
 * - 처음 pivot 선택에 따라 시간복잡도가 달라짐
 *   - 배열의 중간값이 선택될수록 수행되는 연산 감소
 *   - 아래는 첫 원소를 pivot 으로 선택
 * - pivot의 위치를 찾기 위해 start (left), end (right) 변수를 이용
 *   - start는 우측, end는 좌측으로 이동하며 pivot 원소를 기준으로 정렬
 *     - 이 과정에서 start, end가 배열의 범위를 넘어서면 안되므로 그에 대한 조건 추가
 *     - 자연스럽게 pivot이 들어간 인덱스를 기준으로 정렬되므로, start와 end가 엇갈리는 지점이 pivot의 위치
 *   - start, end가 엇갈리지 않았다면 각 원소들 정렬
 *   - start, end가 엇갈렸다면 pivot의 위치와 변경해주고, while문은 자연스럽게 탈출
 *     - end와 교환하는 이유
 *         오름차순 기준, start는 pivot보다 큰 값, end는 pivot보다 작은 값에서 멈춤
 *         pivot은 첫 원소를 선택하므로, pivot의 위치에 와야 하는 원소는 pivot보다 작은 값
 *         따라서 end의 원소와 교환
 * - pivot의 index를 반환하며 종료하고, 해당 index를 바탕으로 배열 분리 및 반복 (재귀)
 */
public class QuickSort implements Sort {
    @Override
    public void sort(int[] elements) {
        sort(elements, 0, elements.length - 1, elements.length);
    }

    public void sort(int[] elements, int start, int end, int n) {
        if (n <= 1) {
            return;
        }
        int pivot = partition(elements, start, end, n);
        sort(elements, start, pivot - 1, pivot - start);
        sort(elements, pivot + 1, end, end - pivot);
    }

    public int partition(int[] elements, int start, int end, int n) {
        int pivot = start;
        while (start < end) {
            while (elements[pivot] > elements[start] && start < n) {
                start++;
            }
            while (elements[pivot] <= elements[end] && end >= pivot + 1) {
                end--;
            }
            if (start < end) {
                swap(elements, start, end);
            } else {
                swap(elements, pivot, end);
            }
        }
        return end;
    }
}
