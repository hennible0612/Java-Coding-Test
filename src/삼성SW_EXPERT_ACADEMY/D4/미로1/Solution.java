package 삼성SW_EXPERT_ACADEMY.D4.미로1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int map[][];

    static int answer;

    static int target_x;
    static int target_y;

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {

            int start_x = 0;
            int start_y = 0;
            target_x = 0;
            target_y = 0;
            answer = 0;
            bf.readLine();
            map = new int[16][16];

            for (int i = 0; i < 16; i++) {
                String line = bf.readLine();

                for (int j = 0; j < 16; j++) {
                    int temp = line.charAt(j) - '0';
                    map[i][j] = temp;
                    if (temp == 2) {
                        start_x = i;
                        start_y = j;
                    }
                    if (temp == 3) {
                        target_x = i;
                        target_y = j;
                    }
                }
            }
            dfs(start_x, start_y);
            System.out.println("#" + test_case + " " + answer);

        }
    }

    public static void dfs(int x, int y) {
        if (x < 0 || x >= 16 || y < 0 || y >= 16 || map[x][y] == 1) {
            return;
        }

        if (map[x][y] == 3) {
            answer = 1;
            return;
        }

        map[x][y] = 1;

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
//        map[x][y] = 0;

    }
}
