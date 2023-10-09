package 삼성SW_EXPERT_ACADEMY.D2.어디에단어가들어갈수있을까;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for (int i = 0; i < N; i++) {
                int consecutive = 0;
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1) {
                        consecutive++;
                    } else {
                        if (consecutive == K) {
                            count++;
                        }
                        consecutive = 0;
                    }
                }
                if (consecutive == K) {
                    count++;
                }
            }

            for (int j = 0; j < N; j++) {
                int consecutive = 0;
                for (int i = 0; i < N; i++) {
                    if (board[i][j] == 1) {
                        consecutive++;
                    } else {
                        if (consecutive == K) {
                            count++;
                        }
                        consecutive = 0;
                    }
                }
                if (consecutive == K) {
                    count++;
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}