package com.ticod.baekjoon;

import com.ticod.Baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/***
 * 재료의 개수 N, 갑옷을 만드는 데 필요한 수 M이 주어질 때,
 * 2개의 재료로 몇 개의 갑옷을 만들 수 있는지 출력
 * (주어진 N개의 자연수 중 두 자연수의 합으로 M을 만드는 가짓수)
 * 입력
 *  재료의 수 N (1 <= N <= 15,000)
 *  갑옷을 만드는 데 필요한 수 M (1 <= M <= 10,000,000)
 *  N개의 재료들이 가진 고유한 번호 (100,000보다 작거나 같은 자연수)
 */
public class Baekjoon1940 implements Baekjoon {
    int n;
    int m;
    int[] numbers;

    public Baekjoon1940() {
        input();
    }
    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        m = Integer.parseInt(scanner.nextLine());
        numbers = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    @Override
    public Integer solve() {
        int result = 0;
        // 투 포인터를 양쪽 끝 값을 지정하고 시작
        int startIndex = 0, endIndex = n - 1;

        // numbers 정렬
        Arrays.sort(numbers);

        // 각 포인터가 교차할 때까지 반복
        while (startIndex < endIndex) {
            if (numbers[startIndex] + numbers[endIndex] == m) {
                result++;
                startIndex++;
                endIndex--;
            } else if (numbers[startIndex] + numbers[endIndex] < m) {
                startIndex++;
            } else {
                endIndex--;
            }
        }

        return result;
    }

    @Override
    public void output() {
        System.out.println("result : " + solve());
    }
}
