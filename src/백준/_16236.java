package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _16236 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int sharkY, sharkX;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int time = 0;
    static int eatenFish = 0;
    static int sharkSize = 2;
    static PriorityQueue<Fish> fishQueue;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        map = new int[n][n];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 9) {
                    sharkY = i;
                    sharkX = j;
                }
                map[i][j] = temp;
            }
        }
        do {
            bfs(sharkY, sharkX);
            if (!fishQueue.isEmpty()) {
                Fish fish = fishQueue.poll();
                map[sharkY][sharkX] = 0;
                sharkX = fish.x;
                sharkY = fish.y;
                map[sharkY][sharkX] = 0;
                time += fish.distance;
                eatenFish++;
                if (eatenFish == sharkSize) {
                    sharkSize++;
                    eatenFish = 0;
                }

            }
        } while (!fishQueue.isEmpty());
        System.out.println(time);

    }

    public static void bfs(int Y, int X) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(X, Y, 0));
        fishQueue = new PriorityQueue<>();
        visited = new boolean[n][n];
        visited[Y][X] = true;


        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;
            int distance = cur.distance;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    if (map[ny][nx] > 0 && map[ny][nx] < sharkSize && map[ny][nx] != 9) {
                        fishQueue.add(new Fish(nx, ny, map[ny][nx], distance + 1));
                    } else if (map[ny][nx] == 0 || map[ny][nx] == sharkSize) {
                        queue.add(new Node(nx, ny, distance + 1));
                    }
                }
            }
        };

    }

    static class Node {
        int x, y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

    }

    static class Fish implements Comparable<Fish> {
        int x, y;
        int size;
        int distance;

        public Fish(int x, int y, int size, int distance) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.distance = distance;
        }

        @Override
        public int compareTo(Fish o) {
            if(this.distance == o.distance){
                if (this.y == o.y) {
                    return this.x- o.x;

                }
                return this.y - o.y;
            }
            return distance - o.distance;
        }
    }
}
