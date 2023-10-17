package 삼성SW_EXPERT_ACADEMY.D3.원재의메모리복구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            char[] memory = br.readLine().trim().toCharArray();
            char current = '0';
            int changes = 0;

            for (char bit : memory) {
                if (bit != current) {
                    changes++;
                    current = bit;
                }
            }

            System.out.println("#" + tc + " " + changes);
        }
    }
}