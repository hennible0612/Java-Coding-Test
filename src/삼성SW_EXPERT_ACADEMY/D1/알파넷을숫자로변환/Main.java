package 삼성SW_EXPERT_ACADEMY.D1.알파넷을숫자로변환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        char[] charArr = n.toCharArray();
        for (char c : charArr) {
            System.out.print((int) c - 64 + " ");
        }
    }
}
