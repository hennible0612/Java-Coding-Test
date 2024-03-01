package SSAFY._20240228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1010 {
    static StringBuilder sb = new StringBuilder();
    static long[] fact;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(bf.readLine());
        fact = new long[31];

        getFact();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            long result = fact[n] / (fact[k] * fact[n - k]);
            sb.append(result).append("\n");

        }
        System.out.println(sb);


    }

    static void getFact() {
        fact[0] = 1;
        fact[1] = 1;
        for (int j = 2; j <= 30; j++) {
            fact[j] = j * fact[j - 1];
        }
    }
}
