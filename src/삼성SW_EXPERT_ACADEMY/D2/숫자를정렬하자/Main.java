package 삼성SW_EXPERT_ACADEMY.D2.숫자를정렬하자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(bf.readLine());
            int[] numbers = new int[N];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);

            System.out.print("#" + t + " ");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}