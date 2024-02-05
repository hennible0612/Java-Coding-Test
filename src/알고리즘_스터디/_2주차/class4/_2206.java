package 알고리즘_스터디._2주차.class4;


package 알고리즘_스터디._2주차.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206 {
    // 맵의 상태와 방문 여부를 저장하는 변수들
    static int[][] map;
    static boolean[][][] visited;

    // 상하좌우 이동을 위한 배열
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 맵의 크기
    static int N;
    static int M;

    // 최단 거리 저장 변수, 불가능할 경우 -1로 초기화
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 맵의 크기 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 맵 상태 입력
        map = new int[N][M];
        visited = new boolean[N][M][2]; // 벽을 부순 상태와 안 부순 상태를 관리하기 위한 3차원 배열

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0'; // 문자를 숫자로 변환하여 저장
            }
        }

        Queue<Tank> tankQueue = new LinkedList<>();
        tankQueue.add(new Tank(0, 0, 1, true));
        visited[0][0][1] = true;

        while (!tankQueue.isEmpty()) {
            Tank tank = tankQueue.poll(); // 큐에서 하나의 요소를 꺼냄
            int cur_x = tank.x;
            int cur_y = tank.y;

            // 목표 달성
            if (cur_x == N -1 && cur_y == M -1) {
                answer = tank.distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                // 맵의 범위를 벗어나거나 이미 방문한 경우 탈탈탈출
                //visited[nx][ny][1] 부수지 않고 도달
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][tank.ammo ? 1 : 0]) {
                    continue;
                }

                // 벽이 있는 경우
                if (map[nx][ny] == 1 && tank.ammo) {
                    visited[nx][ny][1] = true; // 벽을 부수고 이동한 상태로 방문 표시
                    tankQueue.add(new Tank(nx, ny, tank.distance + 1, false)); // 벽을 부순 상태로 큐에 추가
                } else if (map[nx][ny] == 0) { // 벽이 없는 경우
                    visited[nx][ny][tank.ammo ? 1 : 0] = true; // 현재 상태를 유지하며 방문 표시
                     tankQueue.add(new Tank(nx, ny, tank.distance + 1, tank.ammo)); // 큐에 추가
                }
            }
        }
        System.out.println(answer); // 최단 거리 출력, 불가능한 경우 -1 출력
    }

    static class Tank {
        int x, y; // 현재 위치
        int distance; // 시작점으로부터의 거리
        boolean ammo; // 벽을 부술 수 있는지의 여부

        public Tank(int x, int y, int distance, boolean ammo) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.ammo = ammo;
        }
    }
}
