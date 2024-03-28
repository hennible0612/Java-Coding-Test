package 알고리즘_스터디._10주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _14500 {


    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        long[] memoi = new long[101];
        memoi[1] = 1;
        memoi[2] = 1;
        memoi[3] = 1;
        memoi[4] = 2;
        memoi[5] = 2;

        for (int i = 6; i <= 100; i++) {
            memoi[i] = memoi[i - 1] + memoi[i - 5];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            System.out.println(memoi[N]);
        }
    }
}
