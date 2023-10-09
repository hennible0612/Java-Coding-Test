package 삼성SW_EXPERT_ACADEMY.D2.숫자배열회전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(bf.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    System.out.print(matrix[j][i]);
                }
                System.out.print(" ");
                for (int j = N - 1; j >= 0; j--) {
                    System.out.print(matrix[N - 1 - i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[j][N - 1 - i]);
                }
                System.out.println();
            }
        }
    }
}