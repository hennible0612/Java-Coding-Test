package A형.백준;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11660 {

    static int[][] accu;
    static int counter, N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        accu = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) { // 행(밑)
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) { // 열 (옆)
                accu[i][j] = accu[i -1][j] + accu[i][j - 1] - accu[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(accu[x2][y2] - accu[x1 - 1][y2] - accu[x2][y1 - 1] + accu[x1 - 1][y1 - 1]).append("\n");
        }
        System.out.println(sb);
    }
}

