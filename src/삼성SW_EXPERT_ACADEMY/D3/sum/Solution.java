package 삼성SW_EXPERT_ACADEMY.D3.sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int trash = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }

            int maxSum = Integer.MIN_VALUE;

            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += arr[i][j];
                }
                maxSum = Math.max(maxSum, sum);
            }

            for (int j = 0; j < 100; j++) {
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum += arr[i][j];
                }
                maxSum = Math.max(maxSum, sum);
            }

            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 100; i++) {
                sum1 += arr[i][i];
                sum2 += arr[i][99 - i];
            }
            maxSum = Math.max(maxSum, sum1);
            maxSum = Math.max(maxSum, sum2);

            System.out.println("#" + test_case + " " + maxSum);
        }
    }
}