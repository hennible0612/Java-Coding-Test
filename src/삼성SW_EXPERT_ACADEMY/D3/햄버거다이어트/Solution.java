package 삼성SW_EXPERT_ACADEMY.D3.햄버거다이어트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, L;
    static int[] taste, calories;
    static int maxTaste;

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());


        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            taste = new int[N];
            calories = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }

            maxTaste = 0;
            makeBurger(0, 0, 0);

            System.out.println("#" + test_case + " " + maxTaste);
        }

    }
    public static void makeBurger(int idx, int currTaste, int currCalories){
        if (currCalories > L) {
            return;
        }

        if (idx == N) {
            if (currTaste > maxTaste) {
                maxTaste = currTaste;
            }
            return;
        }

        makeBurger(idx + 1, currTaste + taste[idx], currCalories + calories[idx]);
        makeBurger(idx + 1, currTaste, currCalories);

    }
}
