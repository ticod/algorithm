package com.ticod.baekjoon;

import com.ticod.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 절댓값 힙 구현
 *   1. 배열에 정수 x (x != 0) 을 넣는다
 *   2. 배열에서 절댓값이 가장 작은 값을 출력한 후, 그 값을 배열에서 제거.
 *      배열에서 절댓값이 가장 작은 값이 여러 개일 경우 그 중 가장 작은 수를 출력, 제거
 * 프로그램은 비어있는 배열에서 시작
 * - 입력
 *   첫 번째 줄 : 연산의 개수 N (1 <= N <= 100,000)
 *   다음 N개의 줄 : 연산과 관련된 정보를 나타내는 정수 x
 */
public class Baekjoon11286 implements Baekjoon {
    int n;
    int[] x;

    public Baekjoon11286() throws IOException {
        input();
    }

    @Override
    public void input() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(bufferedReader.readLine());
            x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = Integer.parseInt(bufferedReader.readLine());
            }
        }
    }

    @Override
    public String solve() {
        StringBuilder result = new StringBuilder();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> {
                    if (Math.abs(o1) == Math.abs(o2)) {
                        return o1 - o2;
                    }
                    return Math.abs(o1) - Math.abs(o2);
                }
        );

        for (int i = 0; i < n; i++) {
            if (x[i] == 0) {
                if (priorityQueue.isEmpty()) {
                    result.append("0\n");
                } else {
                    result.append(priorityQueue.poll()).append("\n");
                }
            } else {
                priorityQueue.add(x[i]);
            }
        }

        return result.toString();
    }

    @Override
    public void output() {
        System.out.println(solve());
    }
}
