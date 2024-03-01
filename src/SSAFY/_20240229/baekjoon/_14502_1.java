package SSAFY._20240229.baekjoon;//package _20240229.baekjoon;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//// comb + dfs
//public class _14502_1 {
//    static int N, M, max;
//    static int[][] map, copyMap;
//    // 벽을 세울 위치를 3개 조합으로 선정 <- 0인자리 <= 별도의 List를 이용
//    // 바이러스가 퍼지는 작업 수행 <- 2인 자리 <= 별도의 List를 이용
//    static List<int[]> zero = new ArrayList<>(); // <- 벽을 놓을 수 있는 조합의 src
//    static List<int[]> virus = new ArrayList<>();
//    static int zeroSize;
//    static Node[] wall = new Node[3]; // 벽이 놓이는 조합의 tgt
//
//    //delta
//    static int[] dy = {1, -1, 0, 0};
//    static int[] dx = {0, 0, -1, 1};
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        map = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(bf.readLine());
//            for (int j = 0; j < M; j++) {
//                int n = Integer.parseInt(st.nextToken());
//                map[i][j] = n;
//                if (n == 0) {
//                    zero.add(new Node(i, j));
//                } else if (n == 2) {
//                    virus.add(new Node(i, j));
//                }
//            }
//        }
//        max = Integer.MIN_VALUE;
//        zeroSize = zero.size();
//        comb(0, 0);
//        System.out.println(max);
//
//    }
//
//    private static void comb(int srcIdx, int tgtIdx) {
//        // 기저
//        if (tgtIdx == 3) {
//            check();
//            return;
//        }
//        if (srcIdx == zeroSize) {
//            return;
//        }
//        wall[tgtIdx] = zero.get(srcIdx);
//
//        comb(srcIdx + 1, tgtIdx + 1);//현재 선택 O
//        comb(srcIdx + 1, tgtIdx);//현재 선택 X
//
//    }
//
//    private static void check() {
//        // 작업할 자료 구조 초기화
//        copyMap = new int[N][M];
//        // map copy
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                copyMap[i][j] = map[i][j];
//            }
//        }
//        // 벽 3 `세우기
//        for (int i = 0; i < 3; i++) {
//            int y = wall[i].y;
//            int x = wall[i].x;
//            copyMap[y][x] = 1;
//        }
//
//        // 바이러스 퍼뜨리기
//        // BFS
//        // 초기 virus 를 queue 에 넣는다
//        for (Node n : virus) {
//            queue.offer(new Node(n.y, n.x));
//        }
//
//        while (!queue.isEmpty()) {
//            Node n = queue.poll();
//            for (int i = 0; i < 4; i++) {
//                int ny = n.y = dy[i];
//                int nx = n.x = dx[i];
//                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
//                    continue;
//                }
//                if (copyMap[ny][nx] == 0) {
//                    copyMap[ny][nx] = 2; // 바이러스 처리
//                    queue.offer(new Node(ny, nx));
//                }
//            }
//        }
//
//        // 안전지역 계산 후 max 갱신
//        int sum = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (copyMap[i][j] == 0) {
//                    sum++;
//                }
//            }
//        }
//        max = Math.max(max, sum);
//    }
//}
