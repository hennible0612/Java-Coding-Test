package SSAFY._20240229.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1767 {
    static int N;
    static int max;
    static int totalCnt;
    static int min;
    static int[][] map;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};
    static ArrayList<int[]> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(bf.readLine().trim());
            map = new int[N][N];
            list = new ArrayList<>();
            max = 0;
            totalCnt = 0;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    // 비가장자리코어 리스트에 담기
                    if (i > 0 && i < N - 1 && j > 0 && j < N - 1 && map[i][j] == 1) {
                        list.add(new int[]{i, j});
                        totalCnt++; // 비가장자리코어 수 증가
                    }
                } // 멕시노스 셀 정보 입력 및 비가장자리 코어리스트 생성

            }
            go(0, 0, 0);
            System.out.println("#" + tc + " " + min);

        }

    }

    //cCnt : 코어갯수, lCnt : 전선 길이의합
    static void go(int index, int cCnt, int lCnt) { //현재 코어로 전선처리 시도
        if (cCnt + (totalCnt - index) < max) {
            return;
        }
        if (index == totalCnt) {
            if (max < cCnt) {
                max = cCnt;
                min = lCnt;
            } else if (max == cCnt) {
                if (min > lCnt) {
                    min = lCnt;
                }
            }
            return;
        }
        int[] cur = list.get(index);
        int r = cur[0];
        int c = cur[1];
        //4방으로 시도
        for (int d = 0; d < 4; d++) {
            if (isAvailable(r, c, d)) {
                int len = setStatus(r, c, d, 2); //전선놓기
                go(index + 1, cCnt + 1, lCnt + len); //다음코어가기
                setStatus(r, c, d, 0);//전선 지우기
            }
        }
        // 전선 놓지 않기
        go(index + 1, cCnt, lCnt);
    }

    // r, c 위치에서 d방향으로 전선 놓기가 가능한지 체크
    static boolean isAvailable(int r, int c, int d) {
        int nr = r;
        int nc = c;
        while (true) {
            nr += dr[d];
            nc += dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                return true;
            }
            if (map[nr][nc] > 0) {
                return false;
            }
        }
    }

    // 전선 체크는 안함, 갈수 있는 곳 체크는 다른곳에서한다
    static int setStatus(int r, int c, int d, int s) { // r,c 코어위치에서 d방향으로 s(전선 : 2 ,빈칸 : 0)로 set
        int nr = r;
        int nc = c;
        int cnt = 0;
        while (true) {
            nr += dr[d];
            nc += dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                break;
            }
            map[nr][nc] = s;
            cnt++; // 처리한 빈칸 수
        }
        return cnt;
    }
}












