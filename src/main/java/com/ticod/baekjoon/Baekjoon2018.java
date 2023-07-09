package com.ticod.baekjoon;

import com.ticod.Baekjoon;

import java.io.IOException;
import java.util.Scanner;

/***
 * 어떤 자연수 N에 대해 연속된 자연수의 합으로 나타낼 수 있는 가짓수 계산
 * 입력
 *  자연수 N (1 <= N <= 10,000,000)
 *
 * 입력의 크기가 크기 때문에 투포인터 방식 활용
 *  1. start index, end index를 두고, 구간의 합을 구함
 *  2. 합이 자연수 N보다 작다면 end index의 크기를 증가  (구간 증가 -> 합 증가)
 *  3. 합이 자연수 N보다 크다면 start index의 크기를 증가 (구간 감소 -> 합 감소)
 *  4. 합이 자연수 N과 같을 때마다 카운팅
 */
public class Baekjoon2018 implements Baekjoon {
    int n;

    public Baekjoon2018() throws IOException {
        input();
    }

    @Override
    public void input() throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public Integer solve() {
        int startIndex = 1, endIndex = 1;
        int sum = 0;
        int result = 0;
        while (startIndex <= n) {
            if (sum < n) {
                sum += endIndex;
                endIndex++;
            } else if (sum > n) {
                sum -= startIndex;
                startIndex++;
            } else {
                sum += endIndex;
                endIndex++;
                result++;
            }
        }
        return result;
    }

    @Override
    public void output() throws IOException {
        System.out.println("result : " + solve());
    }
}
