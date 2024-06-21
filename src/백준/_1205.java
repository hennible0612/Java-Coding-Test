package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] scores = new int[N];

        if (N == 0) {
            System.out.println(1);
            return;

        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        if (N == P && scores[N - 1] >= newScore) {
            System.out.println(-1);
        } else {
            int rank = 1;
            boolean inserted = false;
            for (int i = 0; i < N; i++) {
                if (newScore < scores[i]) {
                    rank++;
                } else {
                    if (newScore == scores[i] && !inserted) {
                        inserted = true;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(rank);
        }

    }
}
