package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5800 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int i = 1; i <= K; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] scores = new int[N];

            for (int j = 0; j < N; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores);

            int maxScore = scores[N - 1];
            int minScore = scores[0];
            int largestGap = 0;

            for (int j = 1; j < N; j++) {
                int gap = scores[j] - scores[j - 1];
                if (gap > largestGap) {
                    largestGap = gap;
                }
            }

            System.out.println("Class " + i);
            System.out.println("Max " + maxScore + ", Min " + minScore + ", Largest gap " + largestGap);
        }
    }
}
