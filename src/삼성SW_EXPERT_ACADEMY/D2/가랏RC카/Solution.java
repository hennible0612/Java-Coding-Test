package 삼성SW_EXPERT_ACADEMY.D2.가랏RC카;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(bf.readLine());
            int speed = 0;
            int answer = 0;
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int increase = 0;
                int command = Integer.parseInt(st.nextToken());
                if (command != 0) {
                    increase = Integer.parseInt(st.nextToken());
                }
                if (command == 1) {
                    speed += increase;
                } else {
                    speed -= increase;
                    if (speed < 0) {
                        speed = 0;
                    }
                }
                answer += speed;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}