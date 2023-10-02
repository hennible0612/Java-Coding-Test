package DFS_BFS_활용._13섬나라_아일랜드;

import java.util.*;
import java.io.*;

public class Main {

    private static final int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
    private static final int[] dy = {0, -1, 0, 1, 1, 1, -1, -1};

    static boolean[][] visited;
    static int[][] graph;

    static int answer;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        answer = 0;
        graph = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((graph[i][j] == 1) && (!visited[i][j])) {
                    dfs(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int x, int y) {

        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && graph[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
        return 1;

    }
}
