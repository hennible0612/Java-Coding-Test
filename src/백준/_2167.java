package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2167 {
    static StringBuilder sb = new StringBuilder();

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            calculateAnswer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.print(sb);


    }

    static void calculateAnswer(int startX, int startY, int targetX, int targetY) {
        int sum = 0;
        for (int i = startX - 1; i < targetX; i++) {
            for (int j = startY - 1; j < targetY; j++) {
                sum += map[i][j];
            }
        }
        sb.append(sum).append("\n");
    }


}
