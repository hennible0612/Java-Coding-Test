package 삼성SW_EXPERT_ACADEMY.D4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    int x, y, time;

    Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Solution {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우 이동

    static int answer;
    static void bfs(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0, 0)); // 시작점 추가
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == n - 1 && current.y == n - 1) { // 도착지에 도달한 경우
                if (current.time < answer) {
                    answer = current.time;
                }
            }

            for (int[] dir : dirs) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                if (newX >= 0 && newY >= 0 && newX < n && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new Point(newX, newY, current.time + grid[newX][newY]));
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(bf.readLine());
            int[][] grid = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = bf.readLine();
                for (int j = 0; j < N; j++) {
                    grid[i][j] = line.charAt(j) - '0'; // 문자를 숫자로 변환
                }
            }
            answer = Integer.MAX_VALUE;
            bfs(grid);
            System.out.println("#" + test_case + " " + answer);
        }
    }
}