package SSAFY._20240228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 최단 경로 - bfs
// 말(K번),원숭이
public class _1600_1 {
    static int K, W, H;

    static int[][] map;
    static boolean[][][] visited; // 현재 좌표에서 K값에 ㄸ라 경우의수가 달라진다.

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] hx = {1, -1, 2, 2, 1, -1, -2, -2};
    static int[] hy = {2, 2, 1, -1, -2, -2, 1, -1};

    static Queue<Node> queue = new ArrayDeque<>();

    static class Node {
        int x, y;
        int k;
        int d;

        Node(int y, int x, int k, int d) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1]; // K = 3, 0, 1, 2, 3
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이
        bfs();
    }

    static void bfs() {
        //시작 좌표 처리
        visited[0][0][K] = true;
        queue.offer(new Node(0, 0, K, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // 목표 도달
            if (node.y == H - 1 && node.x == W - 1) {
                System.out.println(node.d);
                return; // 바로 종료
            }
            // 탐색 - 상하좌우 - K 사용 X
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1
                        || visited[ny][nx][node.k]) {
                    continue;
                }
                visited[ny][nx][node.k] = true;
                queue.offer(new Node(ny, nx, node.k, node.d + 1));

            }

            // 탐색 - 말 조건에 맞아야 진행이히힝 - K 사용
            if (node.k == 0) {
                continue;
            }
            for (int i = 0; i < 8; i++) {
                int ny = node.y + hy[i];
                int nx = node.x + hx[i];
                if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1
                        || visited[ny][nx][node.k - 1]) {
                    continue;
                }
                visited[ny][nx][node.k - 1] = true;

                queue.offer(new Node(ny, nx, node.k - 1, node.d + 1));
            }



        }
        System.out.println(-1);

    }
}
