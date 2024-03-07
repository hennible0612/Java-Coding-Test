package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11403 {
    static int N;

    static int[][] distanceMap;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        distanceMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                distanceMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
    }

    private static void solution() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (distanceMap[i][k] == 1 && distanceMap[k][j] == 1) {
                        distanceMap[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(distanceMap[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}