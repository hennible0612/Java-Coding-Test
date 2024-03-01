package SSAFY._20240228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합. mCn
// DP (파스칼의 삼각형)
public class _1010_2 {
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

            memoi = new int[M + 1][M + 1];

            System.out.println(comb(M, N));

        }

    }

    // comb(n,r) <= nCr <= n-1Cr-1 + n-1Cr
    static int comb(int n, int r) {
        // 기저 조건
        if (n == r || r == 0) {
            return memoi[n][r] = 1;
        }
        // memoi 재활용
        if (memoi[n][r] > 0) {
            return memoi[n][r];
        }
        // nCr 계산
        return memoi[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }

}
