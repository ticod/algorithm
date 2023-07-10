package com.ticod.baekjoon;

import com.ticod.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 수 N개가 주어졌을 때, i번째 수에서 j번째 수까지의 합을 구하는 프로그램 작성 (시간 제한 0.5초)
 * 입력
 *  1번째 줄에 수의 개수 N, 합을 구해야 하는 횟수 M (1 <= N, M <= 100,000)
 *  2번째 줄에 N개의 수 (각 수는 1000보다 작거나 같은 자연수)
 *  3번째 줄부터 M개의 줄에 합을 구해야하는 구간 i, j
 */
public class Baekjoon11659 implements Baekjoon {
    int n;
    int m;
    int[] numbers;
    int[][] requestSum;

    public Baekjoon11659() throws IOException {
        input();
    }

    @Override
    public void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // n : 수의 개수, m : 합을 구해야 하는 횟수
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new int[n];
        requestSum = new int[m][2];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            requestSum[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            requestSum[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    @Override
    public Long[] solve() {
        // 첫 인덱스 값을 0으로 설정하기 위해 배열의 길이를 1 더 크게 설정
        long[] prefixSumArray = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            // numbers의 index는 0부터 더해줘야 되기 때문에 index에 -1
            prefixSumArray[i] = prefixSumArray[i - 1] + numbers[i - 1];
        }

        Long[] result = new Long[m];
        for (int i = 0; i < m; i++) {
            result[i] = prefixSumArray[requestSum[i][1]] - prefixSumArray[requestSum[i][0] - 1];
        }

        return result;
    }

    @Override
    public void output() {
        Long[] results = this.solve();
        System.out.println("result");
        for (Long result : results) {
            System.out.println(result);
        }
    }
}
