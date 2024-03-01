package SSAFY._20240223.baekjoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열 9!??? <= 1 번 번수가 4번타자 고정 이용 8! 로 줄여야.
// 시뮬레이션 + 안타 등 점수 계산
// game, 순열 <- bit 활용
public class 야구_17281_순열 {
    static int N, ans;
    static int[][] inning;
    static int[] src = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    static int[] tgt = new int[9];

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        inning = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 9; j++) {
                inning[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        perm(0, 0); // bitmask
        System.out.println(ans);

    }

    static void perm(int tgtIdx, int mask) {
        /// 기저 조건
        if (tgtIdx == 9) {
            // complete code
            game();
            return;
        }
        for (int i = 1; i < inning.length; i++) { // 0 번 빼고
            if ((mask & 1 << i) != 0) {
                continue;
            }
            if (tgtIdx == 3) { // 4번 타자 자리
                tgt[3] = 0;
                perm(tgtIdx + 1, mask);
            }else {
                tgt[tgtIdx] = src[i];
                perm(tgtIdx + 1, mask | 1 << i);
            }
        }
    }
    static void game() {
        // game 변수 초기화
        int score = 0;
        int player = 0;
        // N 이닝동안 반복
        for (int i = 0; i < N; i++) {
            // 이닝 변수 초기화
            int base = 0; //base 상태 <= bit 0 0 0 0  0 0 0 0
            int out = 0; // out count

            for (int j = 0; j < 9; j++) {

            }
        }
    }
}










