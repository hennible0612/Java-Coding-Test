package SSAFY._20240222.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _1238 {
    static int[][] matrix;
    static boolean[] visited;
    static int answer;
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Integer> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = 1; T <= 10; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dataLength = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            matrix = new int[101][101];
            visited = new boolean[101];
            queue = new ArrayDeque<>();

            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                matrix[from][to] = 1;
            }

            bfs(start);
            sb.append("#").append(T).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void bfs(int start) {
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = 0; // 계속 max 초기화 왜 냐하면 동시에 가니까

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int j = 1; j < 101; j++) {
                    if (matrix[current][j] == 1 && !visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                        max = Math.max(max, j);
                    }
                }
            }

            if (!queue.isEmpty()) {
                answer = max;
            }
        }
    }
}

