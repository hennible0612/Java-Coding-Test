package 삼성SW_EXPERT_ACADEMY.D1.가위바위보;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(getWinner(A, B));
    }
    public static String getWinner(int A, int B) {

        if ((A == 1 && B == 3) || (A == 2 && B == 1) || (A == 3 && B == 2)) {
            return "A";
        } else {
            return "B";
        }
    }
}

