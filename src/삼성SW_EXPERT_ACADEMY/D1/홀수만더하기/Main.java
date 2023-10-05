package 삼성SW_EXPERT_ACADEMY.D1.홀수만더하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] answers = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp % 2 != 0) {
                    answers[i] += tmp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("#" + (i + 1) + " " + answers[i]);
        }
    }
}