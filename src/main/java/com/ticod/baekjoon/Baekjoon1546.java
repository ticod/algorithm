package com.ticod.baekjoon;

import com.ticod.Baekjoon;

import java.util.Scanner;

/***
 * 점수 중 최댓값을 M이라 할 때, 모든 점수를 점수/M*100으로 고친 성적의 평균
 * 입력
 *  시험을 본 과목의 개수 N (N <= 1000),
 *  성적 (100보다 작거나 같은, 음이 아닌 정수, 적어도 하나의 값은 0보다 크다)
 *   성적은 각각 공백으로 분리
 */
public class Baekjoon1546 implements Baekjoon {

    @Override
    public String[] input() {
        Scanner scanner = new Scanner(System.in);
        String[] result = new String[2];
        for (int i = 0; i < result.length; i++) {
            result[i] = scanner.nextLine();
        }
        return result;
    }

    @Override
    public Double solve(String[] data) {
        int n = Integer.parseInt(data[0]);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            // 평균 구하기
            sum += Integer.parseInt(data[1].split(" ")[i]);
            // 최댓값 구하기
            max = Math.max(max, Integer.parseInt(data[1].split(" ")[i]));
        }
        return (double) sum / max * 100 / n;
    }

    @Override
    public void output() {
        System.out.println("result: " + this.solve(this.input()));
    }
}
