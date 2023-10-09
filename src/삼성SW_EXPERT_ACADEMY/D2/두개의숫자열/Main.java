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
            System.out.println("------------------");
            for (int s : aArray) {
                System.out.print(s + " ");
            }
            System.out.println("------------------");

            for (int s : bArray) {
                System.out.print(s + " ");
            }

//            int lpoint = 0;
//            int rpoint = aArray.length;
//
//            int answer = Integer.MIN_VALUE;
//            int sum = 0;
//
//            for (int j = 0; j < (bArray.length / aArray.length); j++) {
//                for (int p = lpoint; p < rpoint; p++) {
//                    sum += (aArray[p] * bArray[p]);
//                }
//                answer = Integer.max(sum, answer);
//                lpoint = lpoint + 1;
//                rpoint = rpoint + 1;
//
//            }
//            System.out.println(answer);
        }
    }
}
