package A형.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2563 {

    static int answer = 0;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        map = new int[101][101];
        for(int i =0; i< N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            paint(x, y);
        }
        System.out.println(answer);

    }
    static void paint(int x, int y){
        for(int i = x; i < x + 10; i++){
            for(int j = y; j < y + 10; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    answer++;
                }
            }
        }
    }
}
