package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _4485 {
    // 링크 시작 위치 0, 0
    // 금액을 최소로하여 동굴 건너편까지 이동
    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    // 최소비용 도둑 루피
    static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
    // 코스트 좌표 때문에
    static int[][] cost;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;
        while (true) {
            N = Integer.parseInt(bf.readLine());
            if (N == 0) {
                break;
            }
            map = new int[N][N];
            cost = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    // cost 입력ㄴ
                    map[i][j] = Integer.parseInt(st.nextToken());
                    // 크기 만큼
                    cost[i][j] = INF;
                }
            }

            dijkstra();
            sb.append("Problem ").append(t).append(": ").append(cost[N - 1][N - 1]).append("\n");
            t++;
        }
        System.out.println(sb);
    }

    //visit 사용 X
    private static void dijkstra() {

        // 시작점
        cost[0][0] = map[0][0];
        pqueue.offer(new Edge(0, 0, map[0][0]));

        while (!pqueue.isEmpty()) {
            Edge e = pqueue.poll(); //edge

            for (int d = 0; d < 4; d++) {
                int ny = e.y + dy[d];
                int nx = e.x + dx[d];
                // 맵 안이라면
                if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                    continue;
                }
                // 길이가 더 짧다면
                if (e.c + map[ny][nx] < cost[ny][nx]) {
                    cost[ny][nx] = e.c + map[ny][nx];
                    pqueue.add(new Edge(ny, nx, cost[ny][nx]));
                }
            }
        }
    }

    static class Edge {
        int y, x, c;

        Edge(int y, int x, int c) {
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }
}