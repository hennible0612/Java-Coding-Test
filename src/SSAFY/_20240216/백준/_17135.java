package SSAFY._20240216.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _17135 {
    static int N, M;
    static int[][] map;
    static int D;
    static int[] archerLoc;
    static int maxKill = 0;
    public static void main(String[] args) throws Exception {
        // 3명의 궁수 하나의 칸 최대 하나의 궁수
        // 각각 턴 궁수는 적하나 공격
        // 모든 궁수 동시 공격
        // D 이하닝 적중 가장 가까운 적
        // 동일 거리스 왼쪽에 있는애 공격
//        공격받으면 사망
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        archerLoc = new int[M];
        map = new int[N + 1][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setArcherLoc(0, 0);
        System.out.println(maxKill);
    }
    static void setArcherLoc(int start, int depth){
        if(depth == 3){
            simulate();
            return;
        }

        for(int i = start; i < M; i++){
            archerLoc[i] = 1;
            setArcherLoc(i+ 1, depth + 1);
            archerLoc[i] = 0;

        }


    }

    private static void simulate() {
        int[][] tempMap = new int[N + 1][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, M);
        }

        int killCount = 0;
        for (int turn = 0; turn < N; turn++) {
            List<int[]> targets = new ArrayList<>();

            for (int loc = 0; loc < M; loc++) {
                if (archerLoc[loc] == 1) {
                    int[] target = findTarget(tempMap, loc);
                    if (target != null) {
                        targets.add(target);
                    }
                }
            }

            for (int[] t : targets) {
                if (tempMap[t[0]][t[1]] == 1) {
                    tempMap[t[0]][t[1]] = 0;
                    killCount++;
                }
            }

            moveEnemies(tempMap);
        }


        maxKill = Math.max(maxKill, killCount);

    }

    static void moveEnemies(int[][] map) {
        for (int i = N - 1; i > 0; i--) {
//            src: 원본 배열
//            srcPos: 원본 배열에서 복사 시작할 시작 인덱스
//            dest: 목적지 배열
//            destPos: 목적지 배열에서 복사를 시작할 시작 인덱스
//            length: 복사할 요소의 수
            System.arraycopy(map[i - 1], 0, map[i], 0, M);
        }
        Arrays.fill(map[0], 0);
    }


    private static int[] findTarget(int[][] map, int archerColumn) {
        int minDistance = D + 1;
        int[] target = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int distance = Math.abs(N - i) + Math.abs(archerColumn - j);
                    if (distance <= D) {
                        if (distance < minDistance || (distance == minDistance && (target == null || j < target[1]))) {
                            minDistance = distance;
                            target = new int[]{i, j};
                        }
                    }
                }
            }
        }
        return target;
    }
}
