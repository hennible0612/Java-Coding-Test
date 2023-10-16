package 삼성SW_EXPERT_ACADEMY.D2.최빈수구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int trash = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                hashMap.put(tmp, hashMap.getOrDefault(tmp, 0) + 1);
            }

            int maxKey = Integer.MIN_VALUE;
            int maxValue = Integer.MIN_VALUE;

            for (int key : hashMap.keySet()) {
                if (hashMap.get(key) > maxValue) {
                    maxKey = key;
                    maxValue = hashMap.get(key);
                } else if (hashMap.get(key) == maxValue) {
                    maxKey = Math.max(maxKey, key);
                }
            }

            System.out.println("#" + test_case + " " + maxKey);
        }


    }
}