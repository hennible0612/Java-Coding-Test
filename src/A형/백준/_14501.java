package A형.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 총 상담 가능 일수 입력
        int[] T = new int[N + 2]; // 각 상담을 완료하는데 걸리는 시간
        int[] P = new int[N + 2]; // 각 상담을 했을 때 받을 수 있는 금액
        int[] dp = new int[N + 2]; // dp[i] 는 1일 부터 시작해서 얻을 수 있는 최대 이익 =

        // 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken()); // 상담 일수
            P[i] = Integer.parseInt(st.nextToken()); // 돈
        }

        // 뒤에서부터 앞으로 순회하며 dp 배열 채우기
        // 뒤에서 부터 하는 이유는 상담 못하는 날짜를 빼기 위해서

        for (int i = N; i > 0; i--) {
            // 1일에 상담을 시작할 경우, 다음 상담을 시작할 수 있는 날짜
            int next = i + T[i];
            if (next <= N + 1) {
                // 상담을 진행할 경우와 진행하지 않을 경우 중 더 큰 값을 dp[i]에 저장
                // 즉, i일쨰의 이득 + 상담이 끝난 다음날 부터의 총이득 , i 일째 상담하지 않고 다음 날로 갔을 때의 이득
                dp[i] = Math.max(P[i] + dp[next], dp[i + 1]);
            } else {
                // 상담 기간이 남은 일수를 초과할 경우, 상담을 진행하지 않는 것만 고려
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]); // 첫째날부터 시작하여 얻을 수 있는 최대 이익 출력
    }
}
