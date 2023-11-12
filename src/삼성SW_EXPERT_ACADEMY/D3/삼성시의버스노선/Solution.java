package 삼성SW_EXPERT_ACADEMY.D3.삼성시의버스노선;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] stopCounts = new int[5001];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int Ai = Integer.parseInt(st.nextToken());
                int Bi = Integer.parseInt(st.nextToken());
                for (int stop = Ai; stop <= Bi; stop++) {
                    stopCounts[stop]++;
                }
            }

            int P = Integer.parseInt(br.readLine().trim());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ");

            for (int i = 0; i < P; i++) {
                int Cj = Integer.parseInt(br.readLine().trim());
                sb.append(stopCounts[Cj]).append(" ");
            }
            System.out.println(sb.toString().trim()); // 결과 출력
        }

        br.close();
    }
}
