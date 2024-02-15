package SSAFY._20240214.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 결과가 데이터로 주어진 문제 <= 이 결과의 유효성을 따지는 문제
// 두 팀의 시합 모든 경우에 대해 진행, 주어진 결과 데이터를 검증
/*
0 0 0 0 0
1 2 3 4 5
1 1 1 1
2 3 4 5
2 2 2
3 4 5
3 3
4 5
4
5

 */
// 단계별로 시합진행 -> 마지막 경기 까지 가면서 주어진 데이터 검증
// 마지막 경기까지 문제 없으면 성공

// 매경기에서 가능한 3가지 완탐 진행 => 승, 무, 패
public class _6987 {

    static int[] win, lose, draw;// 주어지는 결과데이터 <- 검증대상 <= index는 팀 구별
    static int[][] game; // 순서대로 진행할 게임 별 <= win, lose, draw 의 index와 동일한 index

    static boolean result;
    static StringBuilder sb = new StringBuilder();

    // 2팀씩 계속 대결하면서 검증
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        win = new int[6];
        lose = new int[6];
        draw = new int[6];
        game = new int[15][2];

        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                game[idx][0] = i;
                game[idx][1] = j;
                idx++;
            }
        }
//		for(int i = 0; i< 15; i++) {
//			System.out.println(Arrays.toString(game[i]));
//
//		}
        // 4가지 테케
        for (int i = 0; i < 4; i++) {
            result = false;
            int sum = 0;

            StringTokenizer st = new StringTokenizer(bf.readLine());
            // 18 -> 6 / 6 / 6;
            for (int j = 0; j < 6; j++) {
                sum += win[j] = Integer.parseInt(st.nextToken());
                sum += draw[j] = Integer.parseInt(st.nextToken());
                sum += lose[j] = Integer.parseInt(st.nextToken());
            }

            // 초기 가지치기
            if (sum != 30) {
                sb.append("0 ");
                continue;
            }

            //dfs 완탐
            dfs(0); // 맨 앞 경기 부터 진행
            if (result) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int idx) { // game[] 의 index
        if (idx == 15) {
            result = true;
            return;
        }

        // 현재 (idx) 경기를 진행 승, 무, 패
        int teamA = game[idx][0];
        int teamB = game[idx][1];

        // 아래 세가지 경우 중 유효한 경우에만 dfs를 이어간다.
        //A 승리 <= 검증 데이터에서 win[teamA]--, lose[teamB]--
        if (win[teamA] > 0 && lose[teamB] > 0) {
            win[teamA]--;
            lose[teamB]--;
            dfs(idx + 1);
            win[teamA]++;
            lose[teamB]++;
        }
        //B 승리
        if (win[teamB] > 0 && lose[teamA] > 0) {
            win[teamB]--;
            lose[teamA]--;
            dfs(idx + 1);
            win[teamB]++;
            lose[teamA]++;
        }
        //무승부
        if (draw[teamA] > 0 && draw[teamB] > 0) {
            draw[teamA]--;
            draw[teamB]--;
            dfs(idx + 1);
            draw[teamA]++;
            draw[teamB]++;
        }
    }

}