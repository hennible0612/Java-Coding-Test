package 삼성SW_EXPERT_ACADEMY.D1.더블더블;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int value = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 0; i++) {
            sb.append(i).append(" ");
            value *= 2;
        }

        System.out.println(sb.toString().trim());

    }
}
