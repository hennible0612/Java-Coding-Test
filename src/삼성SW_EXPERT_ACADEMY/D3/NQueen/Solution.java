package 삼성SW_EXPERT_ACADEMY.D3.NQueen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static int answer;

    public static int[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());

        for (int T = 1; T <= test_case; T++) {
            int n = Integer.parseInt(bf.readLine());
            answer = 0;
            board = new int[n][n];
            dfs(n, 0);

        }
    }

    public static void dfs(int n, int curr) {
        if (n == curr) {
            return;
        }


    }
}
