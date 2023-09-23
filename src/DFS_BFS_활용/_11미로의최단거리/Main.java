package DFS_BFS_활용._11미로의최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int graph[][];
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        graph = new int[7][7];
        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 7; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }

    private static void bfs() {
        boolean visited[][] = new boolean[7][7]; // 간곳 체크 => 순환 무한 루프 방지위해
        Queue<int[]> queue = new LinkedList<>(); // 배열을 넣을꺼임
        queue.offer(new int[]{0, 0, 0}); // 초기 값 위치, 거리
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 꺼내기
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == 6 && y == 6) {
                System.out.println(distance); // 도착시 출력(BFS)이므로 도착하면 최단거리
                return;
            }

            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i]; // 다음 위치 좌표 후보
                int next_y = y + dy[i];

                // 좌표 위치 유효하고, 안간곳이라면
                if (next_x >= 0 && next_x < 7 && next_y >= 0 && next_y < 7
                        && !visited[next_x][next_y] && graph[next_x][next_y] == 0) {
                    // 다음위치 추가
                    queue.offer(new int[]{next_x, next_y, distance + 1});
                    //도착한 곳이라고 표시
                    visited[next_x][next_y] = true;
                }
            }
        }
        System.out.println("-1");
    }
}
