package 삼성SW_EXPERT_ACADEMY.D3.회문1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int length = Integer.parseInt(bf.readLine()); // 찾아야 하는 회문의 길이
            char[][] board = new char[8][8]; // 8x8 크기의 글자판

            for (int i = 0; i < 8; i++) {
                String row = bf.readLine();
                for (int j = 0; j < 8; j++) {
                    board[i][j] = row.charAt(j);
                }
            }

            int count = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - length; j++) {
                    boolean isPalindrome = true;
                    for (int k = 0; k < length / 2; k++) {
                        if (board[i][j + k] != board[i][j + length - 1 - k]) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) {
                        count++;
                    }

                    isPalindrome = true;
                    for (int k = 0; k < length / 2; k++) {
                        if (board[j + k][i] != board[j + length - 1 - k][i]) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) {
                        count++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + count);
        }
    }
}
