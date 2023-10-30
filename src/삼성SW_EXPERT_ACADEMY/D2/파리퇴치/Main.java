package 삼성SW_EXPERT_ACADEMY.D2.파리퇴치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int mapSize = Integer.parseInt(st.nextToken());
            int bugSize = Integer.parseInt(st.nextToken());

            int[][] map = new int[mapSize][mapSize];
            for (int j = 0; j < mapSize; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int l = 0; l < mapSize; l++) {
                    map[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;

            for (int j = 0; j <= mapSize - bugSize; j++) {
                for (int l = 0; l <= mapSize - bugSize; l++) {
                    answer = Math.max(answer, getBugPoint(map, j, l, bugSize));
                }
            }
            System.out.println("#" + (i + 1) + " " + answer);
        }
    }

    private static int getBugPoint(int[][] map, int startX, int startY, int bugSize) {

        int tempMax = 0;
        for (int i = 0; i < bugSize; i++) {
            for (int j = 0; j < bugSize; j++) {
                tempMax += map[startX + i][startY + j];
            }
        }
        return tempMax;
    }
}
