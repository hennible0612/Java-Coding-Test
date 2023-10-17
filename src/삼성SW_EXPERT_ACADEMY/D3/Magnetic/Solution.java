package 삼성SW_EXPERT_ACADEMY.D3.Magnetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = 10;
        for (int T = 1; T <= TestCase; T++) {
            int[][] graph = new int[100][100];
            int answer = 0;
            bf.readLine();
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < 100; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < 100; i++) {
                int state = 0;
                for (int j = 0; j < 100; j++) {
                    if (graph[j][i] == 1) {
                        state = 1;
                    } else if (graph[j][i] == 2) {
                        if (state == 1) {
                            answer++;
                        }
                        state = 2;
                    }

                }

            }
            System.out.println("#" + T + " " + answer);
        }
    }
}
