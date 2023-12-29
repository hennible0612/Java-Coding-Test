package 삼성SW_EXPERT_ACADEMY.사전학습.하.자릿수더하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String line = bf.readLine();

        int answer = 0;

        sb.append(line);

        for (int i = 0; i < sb.length(); i++) {
            answer += Integer.parseInt(String.valueOf(sb.charAt(i)));

        }
        System.out.println(answer);
    }
}
