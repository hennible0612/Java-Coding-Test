package SSAFY._20240223.swea;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//10
//2 섬의 수
//0 0 x좌표
//0 100 y좌표
//1.0 e세율

// 세율 계산
public class _1251 {

    private static class Node implements Comparable<Node> {
        int no;
        long w;

        public Node(int no, long w) {
            this.no = no;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // 섬의 갯수
            int N = Integer.parseInt(bf.readLine());
            // X, Y를 저장하기 위한 Point
            Point[] land = new Point[N];
            boolean[] visited = new boolean[N];
            // 섬들의 x좌표 입력
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                land[i] = new Point(0, 0); // Point 초기화
                land[i].x = Integer.parseInt(st.nextToken());
            }
            //섬들의 y 좌표 입력
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                land[i].y = Integer.parseInt(st.nextToken());
            }
        }

    }
}
