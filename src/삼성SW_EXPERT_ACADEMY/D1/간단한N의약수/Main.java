package 삼성SW_EXPERT_ACADEMY.D1.간단한N의약수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }

    }
}

