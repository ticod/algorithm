package com.ticod.baekjoon;

import com.ticod.Baekjoon;

import java.util.Scanner;

/*
N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램 작성
입력 : 1번째 줄의 숫자의 개수 N (1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.
 */
public class Baekjoon11720 implements Baekjoon {
    public String[] input() {
        Scanner scanner = new Scanner(System.in);
        String[] result = new String[2];
        for (int i = 0; i < result.length; i++) {
            result[i] = scanner.next();
        }
        return result;
    }
    public Integer solve(String[] data) {
        int n = Integer.parseInt(data[0]);
        char[] numbers = data[1].toCharArray();
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += numbers[i] - '0';
        }

        return result;
    }

    public void output() {
        String[] data = this.input();
        System.out.println("result: " + this.solve(data));
    }
}
