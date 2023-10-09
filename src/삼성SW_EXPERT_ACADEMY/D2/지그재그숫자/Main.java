package 삼성SW_EXPERT_ACADEMY.D2.지그재그숫자;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(bf.readLine());
            int flag = 0;
            int answer = 0;
            for (int j = 1; j <= m; j++) {
                if (flag == 0) {
                    answer += j;
                    flag = 1;
                } else {
                    flag = 0;
                    answer -= j;
                }
            }
            System.out.println("#" + (i + 1) + " " + answer);
        }
    }
}
