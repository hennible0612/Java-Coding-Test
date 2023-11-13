package 삼성SW_EXPERT_ACADEMY.D4.Ladder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int answer;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            bf.readLine();
            int start_X = 0;
            int start_Y = 0;
            answer = 0;
            visited = new boolean[100][100];

            map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < 100; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    map[i][j] = temp;
                    if (temp == 2) {
                        start_X = i;
                        start_Y = j;
                    }
                }
            }
            dfs(start_X, start_Y);
            System.out.println("#" + test_case + " " + answer);

        }
    }

    public static void dfs(int x, int y) {
        if (x == 0) {
            answer = y;
            return;
        }
        visited[x][y] = true;

        if (y > 0 && map[x][y - 1] == 1 && !visited[x][y - 1]) {
            dfs(x, y - 1);
        } else if (y < 99 && map[x][y + 1] == 1 && !visited[x][y + 1]) {
            dfs(x, y + 1);
        } else if(map[x - 1][y] == 1){
            dfs(x - 1, y);
        }
    }
}
