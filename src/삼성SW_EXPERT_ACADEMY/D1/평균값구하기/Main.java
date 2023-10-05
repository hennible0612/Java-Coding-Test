package 삼성SW_EXPERT_ACADEMY.D1.평균값구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int tmp = 0;
            while (st.hasMoreTokens()) {
                tmp += Integer.parseInt(st.nextToken());
            }
            double average = (double) tmp / 10;
            int roundedAvg = (int) Math.round(average);
            System.out.println("#" + (i + 1) + " " + roundedAvg);
        }
    }
}