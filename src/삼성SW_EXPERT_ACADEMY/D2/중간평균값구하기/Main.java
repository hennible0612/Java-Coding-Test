package 삼성SW_EXPERT_ACADEMY.D2.중간평균값구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            while (st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp > max) {
                    max = temp;
                } else if (temp < min) {
                    min = temp;
                }
                sum += temp;
            }
            sum = sum - max - min;
            System.out.println("#"+(i+1) + " " + (int)Math.round(sum/8.0) );
        }
    }
}
