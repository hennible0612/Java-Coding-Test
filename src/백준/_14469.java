package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14469 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[][] cows = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows, (a, b) -> a[0] - b[0]);

        int currentTime = 0;
        for (int i = 0; i < N; i++) {
            if (currentTime <= cows[i][0]) {
                currentTime = cows[i][0] + cows[i][1];
            }else {
                currentTime += cows[i][1];
            }

        }
        System.out.println(currentTime);
    }
}
