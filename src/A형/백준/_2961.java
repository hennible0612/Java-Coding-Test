package A형.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// binary counting
public class _2961 {
    static int N, min;
    static int[][] src;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        src = new int[N][2];

        // 초기값
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            src[i][0] = Integer.parseInt(st.nextToken());
            src[i][1] = Integer.parseInt(st.nextToken());
        }
        // 풀이
        int subsetCnt = 1 << src.length;

        for (int i = 1; i < subsetCnt; i++) { // 재료가 최소 1개이상 ... 맨앞은 재료 0개 이므로 skip
            int sin = 1;
            int ssn = 0;

            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) != 0) {
                    sin *= src[j][0];
                    ssn += src[j][1];
                }
            }
            min = Math.min(min, Math.abs(sin - ssn));

        }

        System.out.println(min);

    }
}
