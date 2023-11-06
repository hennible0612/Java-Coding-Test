package 삼성SW_EXPERT_ACADEMY.D3.진기의_최고급_붕어빵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken()); // 먹을 N명
            int M = Integer.parseInt(st.nextToken()); // 붕어빵 제조 시간 M
            int K = Integer.parseInt(st.nextToken()); // 제조 시간 후 만든 붕어빵 개수 K


            st = new StringTokenizer(bf.readLine());
            HashMap<Integer, Integer> arrivalTimes = new HashMap<>();
            int maxTime = 0;

            for (int i = 0; i < N; i++) {
                int arrivalTime = Integer.parseInt(st.nextToken());
                arrivalTimes.put(arrivalTime, arrivalTimes.getOrDefault(arrivalTime, 0) + 1);
                maxTime = Math.max(maxTime, arrivalTime);
            }

            boolean possible = true;
            int fishBreadsMade = 0;

            for (int time = 0; time <= maxTime && possible; time++) {
                if (time > 0 && time % M == 0) {
                    fishBreadsMade += K;
                }

                if (arrivalTimes.containsKey(time)) {
                    fishBreadsMade -= arrivalTimes.get(time);
                    if (fishBreadsMade < 0) {
                        possible = false;
                    }
                }
            }

            System.out.println("#" + test_case + (possible ? " Possible" : " Impossible"));
        }
    }
}