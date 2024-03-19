import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] W;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        tsp(0, 0, 0);
        System.out.println(minCost);
    }

    public static void tsp(int current, int cost, int depth) {
        if (depth == N - 1) {
            if (W[current][0] > 0) {
                minCost = Math.min(minCost, cost + W[current][0]);
            }
            return;
        }

        for (int next = 0; next < N; next++) {
            if (!visited[next] && W[current][next] > 0) {
                visited[next] = true;
                tsp(next, cost + W[current][next], depth + 1);
                visited[next] = false;
            }
        }
    }
}
