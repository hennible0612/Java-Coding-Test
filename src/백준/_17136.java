package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17136 {
    static int[][] map = new int[10][10];
    static boolean[][] visited = new boolean[10][10];

    static int answer = 0;

    static int[] squares = {0, 5, 5, 5, 5, 5};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    backTrack(i, j, 1);
                }
            }
        }
        System.out.println(answer);
    }

    private static void backTrack(int y, int x, int size) {

        if (size == 6) {
            answer = -1;
            return;
        }
        if (!check(y, x, size)) {
            unCheck(y, x, size);
            check(y, x, size + 1);
        } else {
            check(y, x, size);
        }

    }

    private static boolean check(int y, int x, int size) {
        for (int i = y; i < size; i++) {
            for (int j = x; j < size; j++) {
                if (i >= 0 && i < 10 && j >= 0 && j < 10 && map[i][j] == 1) {
                    return false;
                } else {
                    visited[i][j] = true;
                }
            }
        }
        answer++;
        squares[size]--;
        return squares[size] != -1;
    }

    private static void unCheck(int y, int x, int size) {
        for (int i = y; i < size; i++) {
            for (int j = x; j < size; j++) {
                visited[i][j] = false;
            }
        }
        answer--;
        squares[size]++;
    }
}
