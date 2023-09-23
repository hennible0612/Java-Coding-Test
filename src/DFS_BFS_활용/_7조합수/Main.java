package DFS_BFS_활용._7조합수;

import java.util.Scanner;

public class Main {
    static int[][] dy = new int[35][35];
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        DFS(n, r);
    }

    public static int DFS(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }
}

