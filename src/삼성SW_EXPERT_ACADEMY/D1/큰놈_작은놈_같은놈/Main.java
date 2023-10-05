package 삼성SW_EXPERT_ACADEMY.D1.큰놈_작은놈_같은놈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x > y) {
                System.out.println("#" + (i + 1) + " " + ">");
            } else if (x < y) {
                System.out.println("#" + (i + 1) + " " + "<");
            } else {
                System.out.println("#" + (i + 1) + " " + "=");
            }
        }
    }
}