package 삼성SW_EXPERT_ACADEMY.D3.NQueen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static int answer;

    public static int[] board;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());

        for (int T = 1; T <= test_case; T++) {
            int n = Integer.parseInt(bf.readLine());
            answer = 0;
            board = new int[n];
            dfs(n, 0);
            System.out.println("#" + T + " " + answer);
        }
    }

    public static void dfs(int n, int curr) {
        if (n == curr) {
            answer++;
            return;
        } else {
            for (int i = 0; i < n; i++) {
                board[curr] = i;
                if (isPossible(curr)) {
                    dfs(n, curr + 1);
                }
            }
        }

    }
    public static boolean isPossible(int curr) {
        for (int i = 0; i < curr; i++) {
            // curr - i 는 현재 행과 이전 행 사이의 거리(높이 차이)
            //
            if (board[i] == board[curr] || curr - i == Math.abs(board[curr] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
