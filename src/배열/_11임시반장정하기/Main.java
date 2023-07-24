package 배열._11임시반장정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int solution(int n, int[][] graph) {
        int leader = 1;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    for (int k = 0; k < 5; k++) {
                        if (graph[i][k] == graph[j][k]) {
                            count++;
                            break;
                        }
                    }
                }
            }

            if (count > maxCount) {
                maxCount = count;
                leader = i + 1;
            }
        }
        return leader;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[][] graph = new int[n][5];

        for (int i = 0; i < n; i++) {
            String[] temp_line = bf.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(temp_line[j]);
            }
        }
        System.out.println(solution(n, graph));
    }
}
