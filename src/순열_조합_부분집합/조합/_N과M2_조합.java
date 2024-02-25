package 순열_조합_부분집합.조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _N과M2_조합 {
    static int N;
    static int M;
    static int[] numbers;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1];
        selected = new int[M];
        for (int i = 1; i <= N; i++) {
            numbers[i] = i;
        }
        comb(1, 0);
        System.out.println(sb);
    }

    public static void comb(int start, int depth) {
        /// 탈출
        if (depth == M) {
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[depth] = numbers[i];
            comb(i + 1,depth + 1);
        }
    }
}
