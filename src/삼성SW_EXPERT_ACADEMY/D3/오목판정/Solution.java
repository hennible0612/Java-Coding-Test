package 삼성SW_EXPERT_ACADEMY.D3.오목판정;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {-1, 0, 1, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(bf.readLine());
            int[][] graph = new int[n][n];

            for (int i = 0; i < n; i++) {
                String temp = bf.readLine();
                for (int j = 0; j < n; j++) {



                }
            }


        }
    }

    public static void dfs() {

    }
}
