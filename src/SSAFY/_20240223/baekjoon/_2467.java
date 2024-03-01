package SSAFY._20240223.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2467 {

    static int[] water;
    static int L, R;
    static int difference = Integer.MAX_VALUE;
    static int LeftAnswer, RightAnswer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        water = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }
        L = 0;
        R = N - 1;
        while (L != R) {
            int target = Arrays.binarySearch(water, L, L, R - 1);
            int diff = 0;
            if (target == N) {
                int temp1 = water[N - 2];
                int temp2 = water[L];
                diff = calculateDifference(temp1, temp2);
                if (diff < difference) {
                    LeftAnswer = temp1;
                    RightAnswer = temp2;
                    L = L + 1;
                }
            }else{
                int checkDiffTargetIndex = water[N - 2];
                int temp1 = checkDiffTargetIndex;
                int temp2 = water[L];
                diff = calculateDifference(temp1, temp2);
                if (diff < difference) {
                    LeftAnswer = temp1;
                    RightAnswer = temp2;
                    L = L + 1;
                }
                checkDiffTargetIndex = water[N - 1];
                temp1 = checkDiffTargetIndex;
                temp2 = water[L];
                diff = calculateDifference(temp1, temp2);
                if (diff < difference) {
                    LeftAnswer = temp1;
                    RightAnswer = temp2;
                    L = L + 1;
                }
            }
        }
        System.out.println(LeftAnswer + " " + RightAnswer);

    }

    private static int calculateDifference(int temp1, int temp2) {
        temp1 = Math.abs(temp1);
        temp2 = Math.abs(temp2);
        return Math.abs(temp1 - temp2);
    }
}
