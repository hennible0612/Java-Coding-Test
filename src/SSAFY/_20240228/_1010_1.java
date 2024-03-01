package SSAFY._20240228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합. mCn
// DP (파스칼의 삼각형)
public class _1010_1 {
    static StringBuilder sb = new StringBuilder();
    static int T, N, M, ans;
    static int[][] memoi;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // ㅍ스칼 ㅍ라미드
            memoi = new int[M + 1][M + 1];
            memoi[0][0] = 1;
            for (int i = 1; i <= M; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        memoi[i][j] = 1; // 삼각형 양쪽 끝
                        continue;
                    }
                    memoi[i][j] = memoi[i - 1][j - 1] + memoi[i - 1][j]; // 위쪽 행의 왼쪽, 오른쪽
                }
            }
            System.out.println(memoi[M][N]);
        }
    }
}
