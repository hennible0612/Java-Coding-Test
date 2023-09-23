package DFS_BFS_활용._5동전교환;

import java.io.*;
import java.util.*;

public class Main {
    public static int answer = Integer.MAX_VALUE;
    public static ArrayList<Integer> coins;

    public static int max;
    public static int[] dp;  // 메모이제이션을 위한 배열
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        coins = new ArrayList<>();

        while (st.hasMoreTokens()) {
            coins.add(Integer.parseInt(st.nextToken()));
        }

        max = Integer.parseInt(bf.readLine());

        dp = new int[max + 1];   // 초기값을 -1로 설정
        Arrays.fill(dp, -1);  // 초기값을 -1로 설정

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int level, int current_value) {

        // 더하는 값이 max 보다 크면 탈출 가지치기: 이미 answer보다 많은 동전을 사용한 경우
        if (level >= answer || current_value > max) {
            return;
        }
        // 더한 값이 max이똑같다면 answer 비교

        if (current_value == max) {
            answer = Math.min(level, answer);
            return;
        }

        // 메모이제이션 적용: 이미 계산한 경우
        if (dp[current_value] != -1 && dp[current_value] <= level) {
            return;
        }

        // 현재 상태 저장 (메모이제이션)
        dp[current_value] = level;

        for (int i = 0; i < coins.size(); i++) {
            int new_value = current_value + coins.get(i);
            dfs(level + 1, new_value);
        }



    }
}
