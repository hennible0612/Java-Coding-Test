package 삼성SW_EXPERT_ACADEMY.D3.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int i = 1; i <= T; i++) {
            int length = Integer.parseInt(bf.readLine());
            int[] array = new int[length];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < length; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;
            for (int j = 2; j < length - 2; j++) {
                int tmp_height = Math.max(array[j - 2],
                        Math.max(array[j - 1],
                                Math.max(array[j + 1], array[j + 2])));

                if (tmp_height < array[j]) {
                    answer += array[j] - tmp_height;
                }
            }
            System.out.println("#" + i + " " + answer);
        }
    }
}