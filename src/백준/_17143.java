package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17143 {
    static int[][] map;
    static int[][] sharkNumber;
    static int R, C, M;
    static ArrayList<Shark> arrayList;
    static int answer;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // 크기 R,C
        // 각 칸 최대 한마리 상어
        //1 초동안 일어나는 일
        // 낚시왕 오른쪽으로 한 칸이동
        // 낚시왕 열에있는 상어 중 땅과 제일 가까운 상어잡는다.
        // 상어 이동
        // 상어 입력으로 주어진 속도로 이동 속도 단위 칸/초 , 격자 넘을시 반대로바꿔서 이동
        // 상어 이동 후 칸에 2마리 이상있을시 큰상어가 다 먹음
        // direction 1 위 2 아래 3 오른쪽 4 왼쪽

        //입력
        // 크기 R, C 상어의 수 M
        // r, c, s, direction, z
        // 상어 위치 r, c
        // 속력 s
        // 이동방향 d
        // 크기 z
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new int[R][C];
        sharkNumber = new int[R][C];
        arrayList = new ArrayList<>();
        arrayList.add(new Shark(0, 0, 0, 0, 0, 0, false));

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            arrayList.add(new Shark(i, r, c, s, d, z, false));


        }

        // 인간 무빙
        for (int i = 0; i < C; i++) {
            catchShark(i);
            moveSharks();

        }
    }

    private static void moveSharks() {
        ArrayList<Shark> newSharks = new ArrayList<>();
        int[][] map = new int[R][C];

        for (Shark shark : arrayList) {
            int move = shark.speed;

            if (shark.direction < 2) { // 상하 이동
                move = move % ((R - 1) * 2);
            } else { // 좌우 이동
                move = move % ((C - 1) * 2);
            }

            for (int i = 0; i < move; i++) {
                if (shark.locY + dy[shark.direction] < 0 || shark.locY + dy[shark.direction] >= R || shark.locX + dx[shark.direction] < 0 || shark.locX + dx[shark.direction] >= C) {
                    shark.direction = shark.direction % 2 == 0 ? shark.direction + 1 : shark.direction - 1;
                }
                shark.locY += dy[shark.direction];
                shark.locX += dx[shark.direction];
            }

            if (map[shark.locY][shark.locX] == 0 || newSharks.get(map[shark.locY][shark.locX] - 1).size < shark.size) {
                if (map[shark.locY][shark.locX] != 0) {
                    newSharks.set(map[shark.locY][shark.locX] - 1, shark);
                } else {
                    newSharks.add(shark);
                    map[shark.locY][shark.locX] = newSharks.size();
                }
            }
        }
        arrayList = new ArrayList<>(newSharks);
    }
    private static void catchShark(int index) {
        for (int i = 0; i < R; i++) {
            if (map[i][index] >= 1) {
                Shark shark = arrayList.get(map[i][index]);
                answer += shark.size;
                shark.status = true;
                map[i][index] = 0;
                sharkNumber[i][index] = 0;
                break;
            }
        }
    }

    static class Shark {
        int index;
        int locY;
        int locX;
        int speed;
        int direction;
        int size;
        boolean status;

        public Shark(int index, int locY, int locX, int speed, int direction, int size, boolean status) {
            this.index = index;
            this.locY = locY;
            this.locX = locX;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
            this.status = status;
        }
    }
}