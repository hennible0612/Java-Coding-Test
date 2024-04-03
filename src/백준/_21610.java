package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _21610 {

    static int N, M;
    static int[][] map;
    //←, ↖, ↑, ↗, →, ↘, ↓, ↙

    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
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
//        for (boolean[] some : increasedWater) {
//            System.out.println(Arrays.toString(some));
//
//        }
        increasedWater[N - 1][1] = true;
        increasedWater[N - 1][2] = true;
        increasedWater[N][1] = true;
        increasedWater[N][2] = true;


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            // 방향
            int d = Integer.parseInt(st.nextToken());
            // 거리
            int s = Integer.parseInt(st.nextToken());

            move(d, s);

            waterCopy();

            raiseWater();
            for (int[] some : map) {
                System.out.println(Arrays.toString(some));

            }
            System.out.println("--------------------------");
        }
        calculateAnswer();
        System.out.println(answer);
    }

    private static void calculateAnswer() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                answer += map[i][j];
            }
        }
    }

    private static void raiseWater() {
        for (int i = 1; i <= N; i++) {
            Arrays.fill(increasedWater[i], false);
        }

        for (Location loc : locations) {
            increasedWater[loc.y][loc.x] = true;
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
        int[] dxx = {-1, 1, 1, -1};
        int[] dyy = {-1, -1, 1, 1};

        for (Location loc : locations) {
            int waterBuckets = 0;
            for (int i = 0; i < 4; i++) {
                int nx = loc.x + dxx[i];
                int ny = loc.y + dyy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && map[ny][nx] > 0) {
                    waterBuckets++;
                }
            }
            map[loc.y][loc.x] += waterBuckets;
        }
    }

    static void move(int direction, int distance) {
        // moveX, moveY 계산에 사용되는 dx, dy는 이미 매핑된 방향을 고려합니다.
        int moveX = dx[direction];
        int moveY = dy[direction];

        // 이동 후 물이 증가할 위치를 임시 저장할 배열
        ArrayList<Location> rainLocations = new ArrayList<>();

        for (Location loc : locations) {
            // 이동
            loc.x = (loc.x + moveX * distance + 100 * N - 1) % N + 1;
            loc.y = (loc.y + moveY * distance + 100 * N - 1) % N + 1;

            // 비가 내릴 위치를 임시 리스트에 추가
            rainLocations.add(new Location(loc.x, loc.y));
        }

        // 구름이 사라진다는 것을 표시하는 배열을 초기화
        for (boolean[] row : increasedWater) {
            Arrays.fill(row, false);
        }

        // 비가 내리는 위치에 물 증가
        for (Location loc : rainLocations) {
            map[loc.x][loc.y]++;
            increasedWater[loc.x][loc.y] = true; // 구름이 사라진 위치 표시
        }

        // 물복사버그 마법 시행
        waterCopy();

        // 구름 생성
        raiseWater();
    }


}
