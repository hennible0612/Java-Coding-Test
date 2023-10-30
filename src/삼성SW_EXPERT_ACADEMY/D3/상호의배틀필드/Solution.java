package 삼성SW_EXPERT_ACADEMY.D3.상호의배틀필드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    // N E S W
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int curDirection;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int TEST_CASE = 1; TEST_CASE <= T; TEST_CASE++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
            int startx = 0;
            int starty = 0;

            for (int i = 0; i < H; i++) {
                String line = bf.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (line.charAt(j) == '<' || line.charAt(j) == '>' || line.charAt(j) == '^'
                            || line.charAt(j) == 'v') {
                        startx = i;
                        starty = j;
                        if (line.charAt(j) == '^') curDirection = 0;
                        if (line.charAt(j) == '>') curDirection = 1;
                        if (line.charAt(j) == 'v') curDirection = 2;
                        if (line.charAt(j) == '<') curDirection = 3;
                    }
                }
            }

            Integer comandNumber = Integer.parseInt(bf.readLine()); // 아래 숫자 용 버리는용
            String commands = bf.readLine();


            for (int i = 0; i < comandNumber; i++) {
                char command = commands.charAt(i);

                switch(command) {
                    case 'U':
                        curDirection = 0;
                        if (startx + dx[curDirection] >= 0 && map[startx + dx[curDirection]][starty] == '.') {
                            map[startx][starty] = '.';
                            startx += dx[curDirection];
                        }
                        map[startx][starty] = '^';
                        break;
                    case 'D':
                        curDirection = 2;
                        if (startx + dx[curDirection] < H && map[startx + dx[curDirection]][starty] == '.') {
                            map[startx][starty] = '.';
                            startx += dx[curDirection];
                        }
                        map[startx][starty] = 'v';
                        break;
                    case 'L':
                        curDirection = 3;
                        if (starty + dy[curDirection] >= 0 && map[startx][starty + dy[curDirection]] == '.') {
                            map[startx][starty] = '.';
                            starty += dy[curDirection];
                        }
                        map[startx][starty] = '<';
                        break;
                    case 'R':
                        curDirection = 1;
                        if (starty + dy[curDirection] < W && map[startx][starty + dy[curDirection]] == '.') {
                            map[startx][starty] = '.';
                            starty += dy[curDirection];
                        }
                        map[startx][starty] = '>';
                        break;
                    case 'S':
                        int nx = startx + dx[curDirection];
                        int ny = starty + dy[curDirection];
                        while (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                            if (map[nx][ny] == '*') {
                                map[nx][ny] = '.';
                                break;
                            } else if (map[nx][ny] == '#') {
                                break;
                            }
                            nx += dx[curDirection];
                            ny += dy[curDirection];
                        }
                        break;
                }
            }
            System.out.print("#" + TEST_CASE + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

        }
    }
}
