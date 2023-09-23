package DFS_BFS_활용._10미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int graph[][];

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean visited[][];
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        graph = new int[7][7];
        visited = new boolean[7][7];
        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 7; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        // target 도착시 경로 + 1
        if (x == 6 && y == 6) {
            answer++;
            return;
        }
        // 간곳 체크
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            // graph 안이라면
            if (next_x >= 0 && next_x < 7 && next_y >= 0 && next_y < 7) {
                // 갔던 곳이 아니고 갈수 있는 길이면
                if (!visited[next_x][next_y] && graph[next_x][next_y] == 0) {
                    dfs(next_x, next_y);
                }
            }
        }
        visited[x][y] = false;
    }
}
