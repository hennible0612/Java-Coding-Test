package 삼성SW_EXPERT_ACADEMY.D2.두개의숫자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] aArray = new int[a];
            int[] bArray = new int[b];
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < a; j++) {
                aArray[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < b; j++) {
                bArray[j] = Integer.parseInt(st.nextToken());
            }

            int sum = Integer.MIN_VALUE;

            // aArray의 길이가 bArray의 길이보다 작거나 같은 경우
            if (a <= b) {
                for (int j = 0; j <= b - a; j++) {
                    int temp = 0;
                    for (int k = 0; k < a; k++) {
                        temp += aArray[k] * bArray[j + k];
                    }

                    sum = Math.max(sum, temp);
                }
            } else {
                for (int j = 0; j <= a - b; j++) {
                    int temp = 0;
                    for (int k = 0; k < b; k++) {
                        temp += bArray[k] * aArray[j + k];
                    }
                    sum = Math.max(sum, temp);
                }
            }

            System.out.println("#" + (i + 1) + " " + sum);

        }
    }
}
