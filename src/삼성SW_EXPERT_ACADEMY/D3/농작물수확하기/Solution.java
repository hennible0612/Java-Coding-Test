package 삼성SW_EXPERT_ACADEMY.D3.농작물수확하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= T; i++) {
            int length = Integer.parseInt(bf.readLine());
            int[][] array = new int[length][length];
            for (int j = 0; j < length; j++) {
                String line = bf.readLine();
                for (int p = 0; p < length; p++) {
                    array[j][p] = line.charAt(p) - '0';
                }
            }
            int answer = 0;
            int start = length / 2;
            for (int j = 0; j <= start; j++) {
                for (int p = start - j; p <= start + j; p++) {
                    answer += array[j][p];
                }
            }

            for (int j = start + 1; j < length; j++) {
                for (int p = start - (length - 1 - j); p <= start + (length - 1 - j); p++) {
                    answer += array[j][p];
                }
            }
            System.out.println("#" + i + " " + answer);
        }
    }
}