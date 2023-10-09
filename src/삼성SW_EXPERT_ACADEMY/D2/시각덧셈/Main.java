package 삼성SW_EXPERT_ACADEMY.D2.시각덧셈;

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] sudoku = new int[9][9];
            boolean isValid = true;

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 9; i++) {
                boolean[] rowCheck = new boolean[10];
                boolean[] colCheck = new boolean[10];
                for (int j = 0; j < 9; j++) {
                    if (rowCheck[sudoku[i][j]] || colCheck[sudoku[j][i]]) {
                        isValid = false;
                        break;
                    }
                    rowCheck[sudoku[i][j]] = true;
                    colCheck[sudoku[j][i]] = true;
                }
            }

            for (int r = 0; r < 9; r += 3) {
                for (int c = 0; c < 9; c += 3) {
                    boolean[] check = new boolean[10];
                    for (int i = r; i < r + 3; i++) {
                        for (int j = c; j < c + 3; j++) {
                            if (check[sudoku[i][j]]) {
                                isValid = false;
                                break;
                            }
                            check[sudoku[i][j]] = true;
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + (isValid ? 1 : 0));
        }
    }
}