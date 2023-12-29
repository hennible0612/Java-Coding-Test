package 삼성SW_EXPERT_ACADEMY.사전학습.하.중간값찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(bf.readLine());
        String[] string_array = new String[length];


        StringTokenizer st = new StringTokenizer(bf.readLine());

        int target = length / 2;


        while (st.hasMoreTokens()) {
            total += Integer.parseInt(st.nextToken());
        }

        int answer = total / max;
        System.out.println(answer);
    }
}
