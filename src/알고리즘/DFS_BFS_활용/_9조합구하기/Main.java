package 알고리즘.DFS_BFS_활용._9조합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] array;

    private static int l;
    private static int n;
    private static int[] checker;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        checker = new int[l];
        dfs(0, 1);
    }

    public static void dfs(int level, int start) {
        if (level == l) {

            for (int num : checker) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            checker[level] = i;
            dfs(level + 1, i + 1);
        }

    }
}
