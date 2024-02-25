package 순열_조합_부분집합.순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _N과M3_순열 {

    static int N, M;
    static int[] src, tgt;
    static boolean[] select;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        src = new int[N + 1]; // 0 dummy
        tgt = new int[M];

        // src 를 자연수로 채운다
        for (int i = 1; i <= N; i++) {
            src[i] = i;
        }
        perm(0);
        System.out.println(sb);

    }


    static void perm(int tgtIdx) {
        if(tgtIdx == M) {
            for(int n : tgt) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {

            tgt[tgtIdx] = src[i];
            perm(tgtIdx + 1);
        }
    }
}
