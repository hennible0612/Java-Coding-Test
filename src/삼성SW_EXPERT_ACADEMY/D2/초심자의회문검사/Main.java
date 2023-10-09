package 삼성SW_EXPERT_ACADEMY.D2.초심자의회문검사;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String text = bf.readLine();
            StringBuilder reversed = new StringBuilder(text).reverse();
            if (text.contentEquals(reversed)) {
                System.out.println("#" + (i + 1) + " " + 1);
            } else {
                System.out.println("#" + (i + 1) + " " + 0);
            }
        }
    }
}
