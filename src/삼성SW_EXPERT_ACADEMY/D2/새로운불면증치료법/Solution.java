package 삼성SW_EXPERT_ACADEMY.D2.새로운불면증치료법;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int Test_Case = Integer.parseInt(bf.readLine());
        for (int T = 1; T <= Test_Case; T++) {
            int answer = 0;
            int stack = 0;
            int N = Integer.parseInt(bf.readLine());

            HashSet<Character> hashSet = new HashSet<>();

            while (hashSet.size() < 10) {
                stack++;
                int temp = stack * N;
                String tempStr = Integer.toString(temp);
                for (int i = 0; i < tempStr.length(); i++) {
                    hashSet.add(tempStr.charAt(i));
                }
                answer = temp;
            }
            System.out.println("#" + T + " " + answer);
        }
    }
}
