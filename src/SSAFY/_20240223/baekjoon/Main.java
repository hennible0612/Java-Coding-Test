package SSAFY._20240223.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] solutions = new int[N];
        for (int i = 0; i < N; i++) {
            solutions[i] = scanner.nextInt();
        }

        Arrays.sort(solutions);
        int left = 0, right = N - 1;
        int closest = Integer.MAX_VALUE;
        int val1 = 0, val2 = 0;

        while (left < right) {
            int sum = solutions[left] + solutions[right];

            if (Math.abs(sum) < closest) {
                closest = Math.abs(sum);
                val1 = solutions[left];
                val2 = solutions[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(val1 + " " + val2);
    }
}
