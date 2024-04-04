package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17136_1 {

    static int[][] map = new int[10][10];
    static int[] paperCnt = {0, 5, 5, 5, 5, 5}; // 1 ~ 5 색종이에 현재 남은 수
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
            // 풀이 - dfs 완탐

        }
        ans = Integer.MAX_VALUE;
        dfs(0, 0, 0); // 좌표 0, 0 에서 0 사용

        // 풀이 - dfs 완탐
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);

    }

    // 현재 주어진 y, x 좌표에서 색종이를 붙이는 모든 경우를 따진다. (1 ~ 5)
    // dfs() 이어가면서 좌표 개행 등......
    static void dfs(int y, int x, int cnt) {
        // 기저조건
        if (y == 9 && x > 9) {
            // complete code
            ans = Math.min(ans, cnt);
            return;
        }
        // 가지 치기
        if (ans <= cnt) {
            return;
        }
        // 개행
        if (x > 9) {
            y = y + 1;
            x = 0;
        }

        // 탐색 시작
        if (map[y][x] == 1) { // 색종이를 놓을 수 있다.

            // 5 가지 색종이를 모두 고려, 남은 색종이 수도 함께
            // 1인칸에 색종이를 사용
            for (int i = 1; i <= 5; i++) { // i : 색종이 종류
                // 색종이가 남아 있고, 그 색종이를 붙일 수 있으면(canAttach())
                if (paperCnt[i] > 0 && canAttach(y, x, i)) {
                    // 위에서 따진 공간에 i 색종이 붙인다.
                    attach(y, x, i, 0);

                    // 남은 i 색종이 수를 감소
                    paperCnt[i]--;

                    // 색종이 너비만큼 오른쪽으로 이동, dfs() 계속 진행
                    dfs(y, x + i, cnt + 1);

                    // 위에서 따진 공간에 i 색종이 붙인다. (원복)
                    attach(y, x, i, 1);

                    // 남은 i 색종이 수를 감소(원복)
                    paperCnt[i]++;
                }
            }

        } else { // 색종이를 놓을 수 없다.
            dfs(y, x + 1, cnt);
        }
    }

    static void attach(int y, int x, int size, int num) {

        // 놓을 수 있는 공간을 탐색하면서 모두 1인지 확인
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                map[i][j] = num;
            }
        }
    }

    static boolean canAttach(int y, int x, int size) {
        // size 색종이를 붙이기에 10*10 range를 벗어나는지 확인
        if (y + size > 10 || x + size > 10) {
            return false;
        }
        // 놓을 수 있는 공간을 탐색하면서 모두 1인지 확인
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true; // 여기까지 오면 모두 1
    }


}
