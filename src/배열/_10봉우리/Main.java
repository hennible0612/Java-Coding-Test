package 배열._10봉우리;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] grid = new int[N+2][N+2];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                boolean peak = true;
                for(int dir=0; dir<4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if(grid[i][j] <= grid[nx][ny]) {
                        peak = false;
                        break;
                    }
                }
                if(peak) count++;
            }
        }

        System.out.println(count);
        scanner.close();
    }
}
