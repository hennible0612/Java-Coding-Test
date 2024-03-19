package A형.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _21610 {

    static int N, M;
    static int[][] map;
    //←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static boolean[][] increasedWater;
    static ArrayList<Location> locations;

    static int answer;

    static class Location {
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        locations = new ArrayList<>();
        answer = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        increasedWater = new boolean[N + 1][N + 1];
        locations.add(new Location(1, N - 1));
        locations.add(new Location(2, N - 1));
        locations.add(new Location(1, N));
        locations.add(new Location(2, N));
        increasedWater[1][N - 1] = true;
        increasedWater[2][N - 1] = true;
        increasedWater[1][N] = true;
        increasedWater[2][N] = true;


        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                Arrays.fill(increasedWater[j], false);
            }

            st = new StringTokenizer(bf.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            move(d, s);
            waterCopy();
            raiseWater();
        }
        caculateAnswer();
        System.out.println(answer);
    }

    private static void caculateAnswer() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                answer += map[i][j];
            }
        }
    }

    private static void raiseWater() {

        for (Location loc : locations) {
            increasedWater[loc.x][loc.y] = true;
        }

        locations.clear();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] >= 2 && !increasedWater[i][j]) {
                    locations.add(new Location(i, j));
                    map[i][j] -= 2;
                }
            }
        }
    }

    private static void waterCopy() {
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};

        for (Location loc : locations) {
            int waterBuckets = 0;
            for (int i = 0; i < 4; i++) {
                int nx = loc.x + dx[i];
                int ny = loc.y + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && map[nx][ny] > 0) {
                    waterBuckets++;
                }
            }
            map[loc.x][loc.y] += waterBuckets;
        }
    }

    static void move(int direction, int distance) {
        ArrayList<Location> newLocations = new ArrayList<>();
        for (Location loc : locations) {
            // 이동거리 계산
            int moveX = dx[direction - 1] * distance;
            int moveY = dy[direction - 1] * distance;
            // 넘어갈 경우 대비 위치 조정
            int nx = (loc.x + moveX - 1 + N) % N + 1;
            int ny = (loc.y + moveY - 1 + N) % N + 1;

            newLocations.add(new Location(nx, ny));
        }

        for (Location loc : newLocations) {
            map[loc.x][loc.y] += 1;
            increasedWater[loc.x][loc.y] = true;
        }

        locations.clear();
        locations.addAll(newLocations);
    }

}
