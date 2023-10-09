package 삼성SW_EXPERT_ACADEMY.D1.거꾸로출력해보아요;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 0; i--) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString().trim());

    }
}
