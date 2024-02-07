package 알고리즘_스터디._3주차.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630 {
    static int[][] map;
    static int white = 0;
    static int black = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, N);
        sb.append(white).append("\n").append(black);
        System.out.println(sb);

        
    }

    private static void recursion(int x, int y, int size) {
        if (checkColor(x, y, size)) {
            if (map[x][y] == 0){
                white++;
            }
            else {
                black++;
            }
            return;
        }

        int tempSize = size / 2;
        recursion(x, y, tempSize); // 1
        recursion(x, y + tempSize, tempSize); // 2
        recursion(x + tempSize, y, tempSize); // 3
        recursion(x + tempSize, y + tempSize, tempSize); //
    }

    //색깔 체크
    public static boolean checkColor(int x, int y, int size) {
        int color = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}
