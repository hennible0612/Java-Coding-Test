package 삼성SW_EXPERT_ACADEMY.D3.부분수열의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] array;
    static int N;
    static int K;

    static int answer;
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            array = new int[N];
            st = new StringTokenizer(bf.readLine());
            answer = 0;
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            };
            recursion(0, 0);
            System.out.println("#" + test_case + " " + answer);
        }

    }

    public static void recursion(int index, int weight) {
        if (weight > K) {
            return;
        }
        if (weight == K) {
            answer += 1;
            return;
        }
        if (index == N) {
            return;
        }
        recursion(index + 1, weight + array[index]);
        recursion(index + 1, weight);
    }
}
