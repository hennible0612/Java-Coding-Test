package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _7569 {
    static class Tomato {
        int x, y;
        int counter;
        int height;
        Tomato(int x, int y, int counter, int height) {
            this.x = x;
            this.y = y;
            this.counter = counter;
            this.height = height;
        }
    }

    static int answer;
    static int[][][] map;
    static int[] dx = { -1, 1, 0, 0, 0 };
    static int[] dy = { 0, 0, 1, -1, 0 };
    static int[] dh = { 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        ArrayDeque<Tomato> arrayDeque = new ArrayDeque<>();
        map = new int[H][N][M];
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < M; j++) {
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                    if (map[h][i][j] == 1) {
                        arrayDeque.add(new Tomato(i, j, 0, h));
                    }
                }
            }
        }


        while (!arrayDeque.isEmpty()) {
            Tomato tomato = arrayDeque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[tomato.height][nx][ny] == 0) {
                    int temp = tomato.counter + 1;
                    answer = temp;
                    map[tomato.height][nx][ny] = temp;
                    arrayDeque.add(new Tomato(nx, ny, temp, tomato.height));
                }
            }
            for (int i = 0; i < 2; i++) {
                int nh = tomato.height + dh[i];
                if (nh >= 0 && nh < H && map[nh][tomato.x][tomato.y] == 0) {
                    int temp = tomato.counter + 1;
                    answer = temp;
                    map[nh][tomato.x][tomato.y] = temp;
                    arrayDeque.add(new Tomato(tomato.x, tomato.y, temp, nh));
                }
            }
        }
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[h][i][j] == 0) {
                        answer = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}