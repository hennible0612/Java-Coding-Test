package 알고리즘_스터디._3주차.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 1 2 3
// 2 3 1 -> 1 2 3
// 조합 <= select 필요 x

public class _15650 {
    static int N;
    static int M;
    static int[] src, tgt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        src = new int[N + 1];
        tgt = new int[M];
        for (int i = 1; i <= N; i++) {
            src[i] = i;
        }
        comb(1, 0);
        System.out.println(sb);
    }

    public static void comb(int srcIdx, int tgtIdx) {
        /// 탈출
        if (tgtIdx == M) {
            for (int n : tgt) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (srcIdx == N + 1) {
            return;
        }
        tgt[tgtIdx] = src[srcIdx];// 선택
        comb(srcIdx + 1, tgtIdx + 1);
        comb(srcIdx + 1, tgtIdx);

    }
}
