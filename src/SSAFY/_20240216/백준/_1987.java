package SSAFY._20240216.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1987 {
    static boolean[] visited = new boolean[26];
    static char[][] map;

    static int R, C;

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];

        for (int i = 0; i < R; i++) {
            map[i] = bf.readLine().toCharArray();
        }

        dfs(0, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int count) {

        if (count > answer) {
            answer = count;
        }

        if (answer == 26) {
            return;
        }


        visited[map[y][x] - 'A'] = true;
        answer = Math.max(answer, count);
        for (int i = 0; i < 4; i++) {
            int nx = x - dx[i];
            int ny = y - dy[i];

            if (nx >= 0 && nx < C && ny >= 0 && ny < R && !visited[map[ny][nx] - 'A']) {
                dfs(nx, ny, count + 1);
                visited[map[ny][nx] - 'A'] = false;
            }
        }

        visited[map[y][x] - 'A'] = false;

    }
}
