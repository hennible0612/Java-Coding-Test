package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15651 {
    static int[] sequence;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M];

        backtrack(0);
        System.out.print(sb);

    }

    public static void backtrack(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            sequence[depth] = i;
            backtrack(depth + 1);
        }
    }
}
