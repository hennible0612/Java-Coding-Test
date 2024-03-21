package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25369 {
    static int n;
    static int target;
    static int[] selected;
    static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        target = 1;
        while (st.hasMoreTokens()) {
            target *= Integer.parseInt(st.nextToken());
        }

        selected = new int[n];
        permutation(0);

        if (!found) {
            System.out.println(-1);
        }
    }

    private static void permutation(int depth) {
        if (found) {
            return;
        }
        if (depth == n) {
            int temp = 1;
            for (int num : selected) {
                temp *= num;
            }
            if (target < temp) {
                found = true;
                for (int num : selected) {
                    System.out.print(num + " ");
                }
                System.out.println();
                return;
            }
        } else {
            for (int i = 0; i < 9; i++) {
                selected[depth] = numbers[i];
                permutation(depth + 1);
            }
        }
    }
}