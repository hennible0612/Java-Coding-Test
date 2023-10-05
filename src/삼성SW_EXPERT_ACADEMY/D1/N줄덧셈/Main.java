package 삼성SW_EXPERT_ACADEMY.D1.N줄덧셈;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    private static int Recursion(int n) {
        while (n > 0) {
            return n + Recursion(n - 1);
        }
        return 0;
    }
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        System.out.println(Recursion(n));
    }
}

