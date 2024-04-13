package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            rotate(arr, N, M);
        }

        for (int[] row : arr) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] arr, int N, int M) {
        int layers = Math.min(N, M) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int temp = arr[layer][layer];
            // 위
            for (int i = layer; i < M - layer - 1; i++) {
                arr[layer][i] = arr[layer][i + 1];
            }

            //오른
            for (int i = layer; i < N - layer - 1; i++) {
                arr[i][M - layer - 1] = arr[i + 1][M - layer - 1];
            }

            // 아래
            for (int i = M - layer - 1; i > layer; i--) {
                arr[N - layer - 1][i] = arr[N - layer - 1][i - 1];
            }

            // 왼
            for (int i = N - layer - 1; i > layer + 1; i--) {
                arr[i][layer] = arr[i - 1][layer];
            }

            arr[layer + 1][layer] = temp;
        }
    }
}
