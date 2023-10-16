package 삼성SW_EXPERT_ACADEMY.D2.수도요금경쟁;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int a = P * W;
            int b;
            int temp = W - R;
            if (temp <= 0) {
                b = Q;
            } else {
                b = temp * S;
                b += Q;
            }
            System.out.println("#" + test_case + " " + Math.min(a, b));
        }
    }
}
