package 삼성SW_EXPERT_ACADEMY.D2.백만장자프로젝트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(bf.readLine());
            long[] array = new long[m];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                array[j] = Long.parseLong(st.nextToken());
            }
            long profit = 0;
            long max = array[m - 1];

            for (int j = m - 1; j >= 0; j--) {
                if (array[j] < max) {
                    profit += max - array[j];
                } else {
                    max = array[j];
                }
            }
            System.out.println("#" + (i + 1) + " " + profit);
        }
    }
}

