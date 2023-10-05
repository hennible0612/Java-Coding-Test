package 삼성SW_EXPERT_ACADEMY.D1.자릿수더하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        char[] charArr = n.toCharArray();
        int answer = 0;
        for (char c : charArr) {
            answer += Character.getNumericValue(c);
        }
        System.out.println(answer);
    }
}