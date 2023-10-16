package 삼성SW_EXPERT_ACADEMY.D2.아름이의돌던지기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int Test_Case = 1; Test_Case <= T; Test_Case++) {
            int N = Integer.parseInt(bf.readLine());
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            while (st.hasMoreTokens()) {
                int target = Integer.parseInt(st.nextToken());
                target = Math.abs(target);

                hashMap.put(target, hashMap.getOrDefault(target, 0) + 1);
            }
            int answer = Collections.min(hashMap.keySet());

            System.out.println("#" + Test_Case + " " + answer + " " + hashMap.get(answer));

        }
    }
}