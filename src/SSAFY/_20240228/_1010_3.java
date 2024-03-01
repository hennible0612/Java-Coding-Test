package SSAFY._20240228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 조합. mCn
// nCr = > n(n-1)(n-2)...(n-(r-1))
//         -----------------------
//                     r!
public class _1010_3 {
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

            // 무식하게 다 계산
            // M!N! <= 30! 감당 불가 //int, long 모두 overflow
            // BigInteger <= 문자열로  숫자 전달, 수학 기호가 아닌 함수메소드로 연산
            BigInteger child = BigInteger.ONE;
            BigInteger parent = BigInteger.ONE;
            for (int i = 0; i < N; i++) {
                // M * (M-1) * (M-2) * ... * (M-(N-1))
                child = child.multiply(new BigInteger(String.valueOf(M - i)));
                // 1 * 2 *...(N-1)*N
                parent = parent.multiply(new BigInteger(String.valueOf(i + 1)));
            }
            System.out.println(child.divide(parent));
        }

    }



}
