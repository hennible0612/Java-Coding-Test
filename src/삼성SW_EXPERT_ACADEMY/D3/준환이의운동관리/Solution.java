package 삼성SW_EXPERT_ACADEMY.D3.준환이의운동관리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int least_target = Integer.parseInt(st.nextToken());
            int max_target = Integer.parseInt(st.nextToken());
            int current_target = Integer.parseInt(st.nextToken());
            int answer = 0;
            if (least_target > current_target) {
                answer = least_target - current_target;
            }
            if (current_target > max_target) {
                answer = -1;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}