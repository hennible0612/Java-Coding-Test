package 삼성SW_EXPERT_ACADEMY.D3.Professional조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static final int MOD = 1234567891;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] factorial = new long[1000001];
        factorial[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long result = factorial[N];
            result *= modInverse(factorial[R], MOD);
            result %= MOD;
            result *= modInverse(factorial[N - R], MOD);
            result %= MOD;

            System.out.println("#" + tc + " " + result);
        }
    }

    private static long modInverse(long a, int m) {
        return power(a, m - 2, m);
    }

    private static long power(long x, int y, int m) {
        long result = 1;
        x = x % m;

        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % m;
            }

            y = y >> 1;
            x = (x * x) % m;
        }
        return result;
    }
}