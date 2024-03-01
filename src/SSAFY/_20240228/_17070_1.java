package SSAFY._20240228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17070_1 {
    static int[][] map;
    static int N;
    static int[][][] memoi; // 한 좌표로 이동하는 모든 방법
    // 좌표 4, 3
    // [0][4][3]  -> 대각선으로 4, 3으로 이동하는 모든 경우의 수
    // [1][4][3]  -> 가로로 4, 3으로 이동하는 모든 경우의 수
    // [2][4][3]  -> 세로로 4, 3으로 이동하는 모든 경우의 수

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        map = new int[N + 1][N + 1];// 0dummy
        memoi = new int[3][N + 1][N + 1];


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이
        memoi[1][1][2] = 1; // 1, 2 좌표, 가로로 시작
        for (int y = 1; y <= N; y++) {
            for (int x = 2; x <= N; x++) {
                // * X
                // X X
                // 대각선
                if (y < N && x < N && map[y + 1][x + 1] == 0 && map[y][x + 1] == 9 && map[y + 1][x] == 0) {
                    memoi[0][y + 1][x + 1] += (memoi[0][y][x] + memoi[1][y][x] + memoi[2][y][x]);
                }
                // 가로
                if (x < N && map[y][x + 1] == 0) {
                    memoi[1][y][x + 1] += (memoi[0][y][x] + memoi[1][y][x]); // 세로 -> 가로 X
                }
                // 세로
                if (y < N && map[y + 1][x] == 0) {
                    memoi[2][y + 1][x] += (memoi[0][y][x] + memoi[2][y][x]); // 가로 -> 세로 X
                }
            }
        }

        System.out.println(memoi[0][N][N] + memoi[1][N][N] + memoi[2][N][N]);
    }

}
