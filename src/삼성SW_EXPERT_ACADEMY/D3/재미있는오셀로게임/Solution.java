package 삼성SW_EXPERT_ACADEMY.D3.재미있는오셀로게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int[][] map;
    public static StringTokenizer st;

    static int n;
    static int white;
    static int black;

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(bf.readLine());
        for (int T = 1; T <= test_case; T++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            map[(n / 2) - 1][(n / 2) - 1] = 2; //white
            map[(n / 2)][(n / 2)] = 2; //white
            map[(n / 2) - 1][(n / 2)] = 1; //black
            map[(n / 2)][(n / 2) - 1] = 1; //black
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int stone = Integer.parseInt(st.nextToken());

                map[x][y] = stone;
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    placeAndCheckStone(x, y, nx, ny, stone,j);
                }
            }
            int black = 0, white = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) black++;
                    else if (map[i][j] == 2) white++;
                }
            }

            System.out.println("#" + T + " " + black + " " + white);
        }
    }

    public static void placeAndCheckStone(int x, int y, int nx, int ny, int color, int dir) {
        int cnt = 0;
        while (true) {
            // 바운더리에서 나감
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                return;
            }
            // 다음꼐 0임
            if (map[nx][ny] == 0) {
                return;
            }
            if (map[nx][ny] == color) {
                // 시작점 부터 cnt까지 color로 칠함
                for (int i = 1; i <= cnt; i++) {
                    int fx = x + dx[dir] * i;
                    int fy = y + dy[dir] * i;
                    map[fx][fy] = color;
                }
                break;
            }
            nx += dx[dir];
            ny += dy[dir];
            cnt++;
        }
    }
}

