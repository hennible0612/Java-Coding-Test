package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _2660 {

    static int N;
    static int[][] distanceMap;
    static int INF = 100001;

    public static void main(String[] args) throws Exception {

//    각 회원은 다른 회원들과 가까운 정도에 따라 점수를 받는다.
//    어느 회원이 다른 모든 회원과 친구이면 1점
//    어느 회원의 점수가 2점이면, 다른 모든 회원이 친구이거나 친구의 친구이다.
//    어느 회원의 점수가 3점이면 다른 모든 회원이 친구이거나 친구의 친구이거나 친구의 친구의 친구임을 말한다.

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        distanceMap = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if (i == j) {
                    distanceMap[i][j] = 0;

                } else {
                    distanceMap[i][j] = INF;
                }
            }
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int to =Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            if(to == -1 && from == -1){
                break;
            }

            distanceMap[to][from] = 1;
            distanceMap[from][to] = 1;

        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    distanceMap[i][j] = Math.min(distanceMap[i][j], distanceMap[i][k] + distanceMap[k][j]);
                }
            }
        }

        int minScore = INF;
        int[] scores = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int maxDistance = 0;
            for (int j = 1; j <= N; j++) {
                if (distanceMap[i][j] > maxDistance) {
                    maxDistance = distanceMap[i][j];
                }
            }
            scores[i] = maxDistance;
            minScore = Math.min(minScore, maxDistance);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if (scores[i] == minScore) {
                list.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minScore).append(" ").append(list.size()).append("\n");
        Collections.sort(list);
        for (int tt : list) {

            sb.append(tt).append(" ");
        }
        System.out.println(sb);
    }
}


















