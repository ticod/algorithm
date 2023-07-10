package com.ticod.baekjoon;

import com.ticod.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * 임의의 수열을 스택에 넣었다 출력하는 방식으로 오름차순 수열을 출력할 수 있는지 확인하고,
 * 출력할 수 있다면 push, pop 연산을 어떤 순서로 수행해야 하는지 출력하는 프로그램
 * - 입력
 *   첫 번째 줄 : 수열의 개수 n (1 <= n <= 100,000)
 *   두 번재 줄 : 수열을 이루는 1 이상, n 이하의 자연수 (같은 자연수가 두 번 이상 나오지 않음)
 * - 출력
 *   push 연산은 +, pop 연산은 -로 출력, 불가능은 NO를 출력
 */
public class Baekjoon1874 implements Baekjoon {

    int n;
    int[] numbers;

    public Baekjoon1874() throws IOException {
        input();
    }

    @Override
    public void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }
    }

    @Override
    public String solve() {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int topNumber = 1;

        for (int i = 0; i < n; i++) {
            if (numbers[i] >= topNumber) {
                while (numbers[i] >= topNumber) {
                    stack.push(topNumber);
                    topNumber++;
                    result.append("+\n");
                }
                stack.pop();
                result.append("-\n");
            } else {
                if (stack.pop() > numbers[i]) {
                    return "NO";
                } else {
                    result.append("-\n");
                }
            }
        }

        return result.toString();
    }

    @Override
    public void output() {
        System.out.println(solve());
    }
}
