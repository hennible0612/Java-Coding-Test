package 삼성SW_EXPERT_ACADEMY.D2.달팽이숫자;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//class Solution {
//    static int[][] map;
//    static  int n;
//
//    static int size;
//    public static void main(String args[]) throws Exception {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(bf.readLine());
//        for (int i = 0; i < n; i++) {
//            size = Integer.parseInt(bf.readLine());
//            map = new int[size][size];
//            fill();
//            System.out.println("#" + (i + 1));
//            for (int p = 0; p < size; p++) {
//                for (int j = 0; j < size; j++) {
//                    System.out.print(map[p][j] + " ");
//                }
//                System.out.println("");
//            }
//        }
//    }
//
//    static int[] dx = {0, 1, 0, -1};
//    static int[] dy = {1, 0, -1, 0};
//
//    public static void fill() {
//        int counter = 1;
//        int x = 0, y = 0, dir = 0;
//
//        while (counter <= size * size) {
//            if (x >= 0 && y >= 0 && x < size && y < size && map[x][y] == 0) {
//                map[x][y] = counter++;
//                x += dx[dir];
//                y += dy[dir];
//            } else {
//                //x,y, size 부분 넘어갔기 때문
//                x -= dx[dir];
//                y -= dy[dir];
//                dir = (dir + 1) % 4;
//                x += dx[dir];
//                y += dy[dir];
//            }
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static int[][] map;
    static int size;

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            size = Integer.parseInt(bf.readLine());
            map = new int[size][size];
            fill(0, 0, 0, 1);

            System.out.println("#" + (tc + 1));
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void fill(int x, int y, int dir, int counter) {
        if (x < 0 || y < 0 || x >= size || y >= size || map[x][y] != 0) {
            return;
        }

        map[x][y] = counter;

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || ny < 0 || nx >= size || ny >= size || map[nx][ny] != 0) {
            dir = (dir + 1) % 4;  // 방향 전환
            nx = x + dx[dir];
            ny = y + dy[dir];
        }

        fill(nx, ny, dir, counter + 1);
    }
}


