package SSAFY._20240228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _1600 {
    static int K, W, H;

    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] hx = {1, -1, 2, 2, 1, -1, -2, -2};
    static int[] hy = {2, 2, 1, -1, -2, -2, 1, -1};
    static int answer = -1;
    static class Node {
        int x, y;
        int count;
        int horseJump;

        Node(int x, int y, int count, int horseJump) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.horseJump = horseJump;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayDeque<Node> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(new Node(0, 0, 0, K));
        while (!arrayDeque.isEmpty()) {
            Node curNode = arrayDeque.poll();
            if (curNode.x == W - 1 && curNode.y == H - 1) {
                answer = curNode.count;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curNode.x - dx[i];
                int ny = curNode.y - dy[i];
                if (nx >= 0 && nx < W && ny >= 0 && ny < H && map[ny][nx] != 1
                        && !visited[ny][nx][curNode.horseJump]) {
                    visited[ny][nx][curNode.horseJump] = true;
                    arrayDeque.add(new Node(nx, ny, curNode.count + 1, curNode.horseJump));
                }
            }
            if (curNode.horseJump > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = curNode.x - hx[i];
                    int ny = curNode.y - hy[i];
                    if (nx >= 0 && nx < W && ny >= 0 && ny < H && map[ny][nx] != 1
                            && !visited[ny][nx][curNode.horseJump - 1]) {
                        visited[ny][nx][curNode.horseJump - 1] = true;
                        arrayDeque.add(new Node(nx, ny, curNode.count + 1, curNode.horseJump - 1));
                    }
                }

            }
        }
        System.out.println(answer);
    }
}
