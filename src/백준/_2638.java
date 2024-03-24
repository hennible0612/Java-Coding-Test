package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _2638 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static ArrayDeque<Node> queueAir;
    static ArrayDeque<Node> queueBorder;

    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queueAir = new ArrayDeque<>();
        queueBorder = new ArrayDeque<>();
        queueAir.add(new Node(0, 0));
        visited[0][0] = true;

        while (true) {
            bfsAir();
            if (queueBorder.isEmpty()) {
                break;
            }
            bfsBorder();
            answer++;
        }
        System.out.println(answer);
    }

    private static void bfsBorder() {
        while (!queueBorder.isEmpty()) {
            Node node = queueBorder.poll();
            map[node.y][node.x] = 0;
            queueAir.add(node);
        }
    }

    private static void bfsAir() {
        while (!queueAir.isEmpty()) {
            Node curNode = queueAir.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx]) {
                    if (map[ny][nx] == 0) {
                        queueAir.add(new Node(nx, ny));
                        visited[ny][nx] = true;
                    } else if (map[ny][nx] >= 1) {
                        map[ny][nx] += 1;
                        if (map[ny][nx] >= 3) {
                            visited[ny][nx] = true;
                            queueBorder.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }
    }

    private static class Node{
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
