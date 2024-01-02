package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/10026
public class _10026 {
    static int N;
    static char[][] pixel_map;
    static boolean[][] visited;
    static int answer1, answer2;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        pixel_map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            pixel_map[i] = bf.readLine().toCharArray();
        }

        answer1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, pixel_map[i][j]);
                    answer1++;
                }
            }
        }

        answer2 = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (pixel_map[i][j] == 'G') pixel_map[i][j] = 'R';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, pixel_map[i][j]);
                    answer2++;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    public static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && pixel_map[nx][ny] == color) {
                    dfs(nx, ny, color);
                }
            }
        }
    }
}
