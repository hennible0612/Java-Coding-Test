package 삼성SW_EXPERT_ACADEMY.D2.threeSixNine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= n; i++) {
            String number = String.valueOf(i);
            int clapCount = 0;

            for (char c : number.toCharArray()) {
                if (c == '3' || c == '6' || c == '9') {
                    clapCount++;
                }
            }

            if (clapCount > 0) {
                for (int j = 0; j < clapCount; j++) {
                    System.out.print("-");
                }
                System.out.print(" ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}

