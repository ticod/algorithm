package com.ticod.baekjoon;

import com.ticod.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1에서 N까지의 번호가 있는 N장의 카드가 있다. 1번 카드가 가장 위, N번 카드가 가장 아래인 상태로 놓여 있다.
 * 가장 위에 있는 카드를 버리고, 그 다음 가장 위에 있는 카드를 가장 아래에 있는 카드 밑으로 옮긴다.
 * 이 과정을 거쳤을 때, 가장 마지막에 남는 카드를 출력하기
 * - 입력
 *   첫 번째 줄 : N (1 <= N <= 500,000)
 */
public class Baekjoon2164 implements Baekjoon {
    int n;

    public Baekjoon2164() throws IOException {
        input();
    }

    @Override
    public void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
    }

    @Override
    public Integer solve() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    @Override
    public void output() {
        System.out.println("result : " + solve());
    }
}
