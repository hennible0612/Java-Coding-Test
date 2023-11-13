package 삼성SW_EXPERT_ACADEMY.D4.숫자이어붙이기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    static int[][] grid;
    static Set<String> numbers;
    static int[] dx = {0, 0, -1, 1}; // 동서남북
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            grid = new int[4][4];
            numbers = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                String[] line = bf.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    grid[i][j] = Integer.parseInt(line[j]);
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, "", 0);
                }
            }

            System.out.println("#" + test_case + " " + numbers.size());
        }
    }

    public static void dfs(int x, int y, String num, int depth) {
        if (depth == 7) {
            numbers.add(num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
                dfs(nx, ny, num + grid[x][y], depth + 1);
            }
        }
    }
}
