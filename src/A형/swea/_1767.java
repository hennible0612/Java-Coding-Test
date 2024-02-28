package A형.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1767 {

    static int N;
    static int[][] map;
    static List<CPU> list;
    static int connected;
    static int lines;
    static int numberOfCPU;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine().trim());
        for (int TEST_CASE = 1; TEST_CASE <= T; TEST_CASE++) {
            N = Integer.parseInt(bf.readLine().trim());
            map = new int[N][N];
            list = new ArrayList<>();
            numberOfCPU = 0;
            lines = Integer.MAX_VALUE;
            connected = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine().trim());
                for (int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 1) {
                        if (i == 0 || j == 0 || j == N - 1 || i == N - 1) {
                            list.add(new CPU(i, j, true));
                        } else {
                            list.add(new CPU(i, j, false));
                        }
                        numberOfCPU += 1;
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 0;
                    }
                }
            }
            dfs(0, map, 0);
            sb.append("#").append(TEST_CASE).append(" ").append(lines).append("\n");

        }
        System.out.println(sb);
    }

    private static void dfs(int index, int[][] map, int on) {
        if (index == list.size()) {
            if(connected < on) {
                connected = on;
                lines = countLines(map); // 전선의 총 길이 계산
            } else if (connected == on) {
                lines = Math.min(lines, countLines(map));
            }

            return;
        }
        CPU cpu = list.get(index);
        for (int i = 0; i < 4; i++) {
            int[][] child = copyMap(map);
            if (!checkMap(child, i, cpu)) {
                continue;
            } else {
                dfs(i + 1, child, on + 1);
            }
        }
    }

    private static boolean checkMap(int[][] child, int d, CPU cpu) {

        int nx = cpu.x - dx[d];
        int ny = cpu.y - dy[d];


        while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
            if (child[ny][nx] != 0) {
                return false;
            }

            child[ny][nx] = 2;
            nx += dx[d];
            ny += dy[d];
        }
        return (nx >= 0 && ny >= 0 && nx < N && ny < N) || (nx == -1 || ny == -1 || nx == N || ny == N);
    }

    static class CPU {
        int x, y;
        boolean isWall;

        CPU(int x, int y, boolean isWall) {
            this.x = x;
            this.y = y;
            this.isWall = isWall;
        }
    }

    private static int countLines(int[][] map) {
        int totalLines = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) totalLines++;
            }
        }
        return totalLines;
    }

    static int[][] copyMap(int[][] origin) {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }
}
