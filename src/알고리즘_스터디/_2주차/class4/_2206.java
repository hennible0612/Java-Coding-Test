package 알고리즘_스터디._2주차.class4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class _2206 {
    static int[][] map;
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken())

        Queue<Tank> tankQueue = new LinkedList<>();

//		각각 탱크 상태 큐에 넣고 ??? 뿌순 경우랑 뿌수지 않은 경우 넣기??
//		{좌표 x, 좌표 y, 이동거리, 탄약 }

        while (!tankQueue.isEmpty()) {

        }

    }
    static class Tank {
        int x;
        int y;
        int distance;
        boolean ammo;
        public Tank(int x, int y, int distance, boolean ammo){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.ammo = ammo;
        }

    }
}
//0100
//1110
//1000
//0000
//0111
//0000

//0000
//1110
//1000
//0000
//0111
//0000

// 위치에서 부수거나 안부수기
//