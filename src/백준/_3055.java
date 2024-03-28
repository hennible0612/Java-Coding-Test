package 백준;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import javax.sound.midi.Soundbank;

// . 비이었는 곳
// * 물차있는곳
// X 는 돌
// D 비버굴
// S 고슴도치

// 고슴 도치 매분 4방향 이동
// 물과 인접한 칸은 '매분 비어 있는' 칸으로 확장
// 물과 고슴도치는 돌을 통과 할 수 없다,
// 고슴도치 물차있는 구역 이동 X
// 물 비버굴 이동 불가능
public class _3055 {
    static int n, m;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static ArrayDeque<Node> waterMove = new ArrayDeque<>();
    static ArrayDeque<Node> hedgeHog = new ArrayDeque<>();
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < m; j++) {
                char temp = line.charAt(j);
                if (temp == '*') {
                    waterMove.add(new Node(i, j));
                } else if (temp == 'S') {
                    hedgeHog.add(new Node(i, j));
                    visited[i][j] = true;
                }
                map[i][j] = temp;
            }
        }
        System.out.println(Solution());

    }
    //    // 물 움직이기
    private static String Solution() {
        int time = 0;

        while (!hedgeHog.isEmpty()) {
            //물크기 만큼 움직임
            //한번에 진행
            int waterSize = waterMove.size();
            for (int i = 0; i < waterSize; i++) {
                Node water = waterMove.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = water.x + dx[j];
                    int ny = water.y + dy[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == '.') {
                        map[ny][nx] = '*';
                        waterMove.add(new Node(ny, nx));
                    }
                }
            }

            int hedgeHogSize = hedgeHog.size();
            for (int i = 0; i < hedgeHogSize; i++) {
                Node hog = hedgeHog.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = hog.x + dx[j];
                    int ny = hog.y + dy[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (map[ny][nx] == 'D') {
                            return String.valueOf(time + 1);
                        }
                        if (!visited[ny][nx] && map[ny][nx] == '.') {
                            visited[ny][nx] = true;
                            hedgeHog.add(new Node(ny, nx));
                        }
                    }
                }
            }
            if (hedgeHog.isEmpty()) { // 갈수 있는 곳 X
                return "KAKTUS";
            }
            time++;
        }
        return "KAKTUS";
    }

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}


