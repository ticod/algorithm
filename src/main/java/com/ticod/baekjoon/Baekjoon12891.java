package com.ticod.baekjoon;

import com.ticod.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 모든 문자가 'A', 'C', 'G', 'T' 로 이루어진 DNA 문자열의 부분 문자열 중,
 * 각각의 문자가 몇 개 이상 나타나는지에 대한 조건에 부합하는 부분 문자열의 개수 출력
 * 입력
 *  첫 번째 줄 : DNA 문자열의 길이 |S|, 비밀번호로 사용할 부분 문자열의 길이 |P|
 *   (1 <= |P| <= |S| <= 1,000,000)
 *  두 번째 줄 : 임의로 만든 DNA 문자열
 *  세 번째 줄 : 부분 문자열에 포함돼야 할 {'A', 'C', 'G', 'T'}의 각각의 최소 개수 (사이에 공백 문자)
 *
 */
public class Baekjoon12891 implements Baekjoon {
    int s, p;
    char[] dna;
    char[] ruleString = {'A', 'C', 'G', 'T'};
    int[] rule = new int[ruleString.length];

    public Baekjoon12891() throws IOException {
        input();
    }

    public void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        s = Integer.parseInt(stringTokenizer.nextToken());
        p = Integer.parseInt(stringTokenizer.nextToken());

        dna = bufferedReader.readLine().toCharArray();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < ruleString.length; i++) {
            rule[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    void add(char target, int[] currentState) {
        for (int i = 0; i < ruleString.length; i++) {
            if (ruleString[i] == target) {
                currentState[i]++;
                break;
            }
        }
    }

    void remove(char target, int[] currentState) {
        for (int i = 0; i < ruleString.length; i++) {
            if (ruleString[i] == target) {
                currentState[i]--;
                break;
            }
        }
    }

    boolean isRight(int[] currentState) {
        int count = 0;
        for (int i = 0; i < ruleString.length; i++) {
            if (currentState[i] >= rule[i]) {
                count++;
            }
        }
        return count == ruleString.length;
    }

    public Integer solve() {
        int result = 0;
        int startIndex = 0;
        int[] currentState = new int[ruleString.length];

        for (int i = startIndex; i < p; i++) {
            add(dna[i], currentState);
        }
        if (isRight(currentState)) {
            result++;
        }
        while (startIndex + p < s) {
            remove(dna[startIndex], currentState);
            add(dna[startIndex + p], currentState);
            startIndex++;
            if (isRight(currentState)) {
                result++;
            }
        }

        return result;
    }

    public void output() {
        System.out.println("result : " + solve());
    }
}

