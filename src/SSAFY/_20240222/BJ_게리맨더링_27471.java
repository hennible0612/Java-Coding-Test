package SSAFY._20240222;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_게리맨더링_27471 {

    static int N, min; // N: 구역의 수, min: 두 선거구 인구 차이의 최소값
    static int[][] matrix; // 구역의 인구수와 인접한 구역 정보를 저장
    static boolean[] select; // 부분집합 생성 시, 선거구 A에 포함되는지 여부
    static boolean[] visit; // BFS 수행 시, 각 구역의 방문 여부
    static Queue<Integer> queue = new ArrayDeque<>(); // BFS를 위한 큐

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 구역의 수 입력

        matrix = new int[N + 1][N + 1]; // 인접 행렬 초기화
        select = new boolean[N + 1]; // 선택 배열 초기화
        visit = new boolean[N + 1]; // 방문 배열 초기화
        min = Integer.MAX_VALUE; // 최소값을 최대로 설정하여 초기화

        // 각 구역의 인구수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            matrix[i][0] = Integer.parseInt(st.nextToken());
        }

        // 각 구역별 인접한 구역 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // i 구역에 인접한 구역의 수
            for (int j = 1; j <= n; j++) {
                int v = Integer.parseInt(st.nextToken());
                matrix[i][j] = v; // 인접한 구역 번호 저장
            }
        }

        // 모든 가능한 선거구 분할 방법 탐색
        subset(1);

        // 결과 출력
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    // 선거구 분할의 유효성을 검사하고, 인구 차이를 계산하는 함수
    static void check() {
        Arrays.fill(visit, false); // 방문 배열 초기화
        queue.clear(); // 큐 초기화

        // 선거구 A의 연결성 확인
        for (int i = 1; i <= N; i++) {
            if (select[i]) { // 선거구 A에 포함된 구역을 찾아 BFS 시작
                visit[i] = true;
                queue.offer(i);
                break;
            }
        }

        // 선거구 A가 비어있지 않은 경우 BFS 수행
        if (!queue.isEmpty()) {
            bfs(select);
        }

        // 선거구 B의 연결성 확인
        for (int i = 1; i <= N; i++) {
            if (!select[i]) { // 선거구 B에 포함된 구역을 찾아 BFS 시작
                visit[i] = true;
                queue.offer(i);
                break;
            }
        }

        // 선거구 B가 비어있지 않은 경우 BFS 수행
        if (!queue.isEmpty()) {
            bfs(select);
        }

        // 모든 구역이 연결되었는지 확인
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) return; // 연결되지 않은 구역이 있으면 리턴
        }

        // 인구 차이 계산
        calculateDifference();
    }

    // BFS를 수행하여 선거구 내의 구역들이 모두 연결되어 있는지 확인
    static void bfs(boolean[] select) {
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int i = 1; i <= N; i++) {
                int adj = matrix[v][i];
                if (adj != 0 && !visit[adj] && select[adj] == select[v]) {
                    visit[adj] = true;
                    queue.offer(adj);
                }
            }
        }
    }

    // 인구 차이를 계산하고 min 값을 갱신
    static void calculateDifference() {
        int sumA = 0, sumB = 0;
        for (int i = 1; i <= N; i++) {
            if (select[i]) sumA += matrix[i][0];
            else sumB += matrix[i][0];
        }
        min = Math.min(min, Math.abs(sumA - sumB));
    }

    // 모든 가능한 선거구 분할 방법을 생성하는 부분집합 함수
    static void subset(int srcIdx) {
        if (srcIdx == N + 1) {
            check(); // 생성된 부분집합에 대해 검사
            return;
        }
        select[srcIdx] = true;
        subset(srcIdx + 1);
        select[srcIdx] = false;
        subset(srcIdx + 1);
    }
}














