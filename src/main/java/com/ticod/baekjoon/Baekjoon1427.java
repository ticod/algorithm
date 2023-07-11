package com.ticod.baekjoon;

import com.ticod.Baekjoon;
import com.ticod.algorithm.sort.SelectionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 내림차순으로 자릿수 정렬하기
 * - 입력
 *   정렬할 자연수 N (1 <= N <= 1,000,000,000)
 */
public class Baekjoon1427 implements Baekjoon {
    int n;
    public Baekjoon1427() throws IOException {
        input();
    }

    @Override
    public void input() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(bufferedReader.readLine());
        }
    }

    @Override
    public Integer solve() {
        int result = 0;
        int[] temp;

        int count = 0;
        int tempN = n;
        while (tempN >= 1) {
            tempN /= 10;
            count++;
        }
        temp = new int[count];
        tempN = n;
        while (tempN >= 1) {
            count--;
            temp[count] = tempN % 10;
            tempN /= 10;
        }
        new SelectionSort().sort(temp);
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < i; j++) {
                temp[temp.length - i - 1] *= 10;
            }
            result += temp[temp.length - i - 1];
        }
        return result;
    }

    @Override
    public void output() {
        System.out.println("result : " + solve());
    }
}
