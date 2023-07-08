package com.ticod.baekjoon;

import com.ticod.Baekjoon;

import java.util.Scanner;

/*
N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램 작성
입력 : 1번째 줄의 숫자의 개수 N (1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.
 */
public class Baekjoon11720 implements Baekjoon {
    int n;
    int[] numbers;

    public Baekjoon11720() {
        input();
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        numbers = new int[n];
        char[] temp = scanner.nextLine().toCharArray();
        for (int i = 0; i < n; i++) {
            numbers[i] = temp[i] - '0';
        }
    }
    public Integer solve() {
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += numbers[i];
        }

        return result;
    }

    public void output() {
        System.out.println("result: " + this.solve());
    }
}
