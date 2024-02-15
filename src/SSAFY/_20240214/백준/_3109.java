package SSAFY._20240214.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 파이프를 동시에 놓아야한다 (이전에 놓은 파이프가 다음 파이프에 영향을 미친다.
// 이미 파이프가 있는 자리에 놓을수 없다.
// 왼쪽 --> 오른쪽 이동의 우선순위 우상 -> 우 -> 우하로 <= 위에서 아래포 행을 올라가면서 파이프를 놓아 볼것이므로
// visit <- 동일 좌표 재 방문 금지를 위해 사용 이 문제의 경우 필요 X
public class _3109 {

    static int R;
    static int C;
    static char[][] map;

    static int[] dy = {-1, 0, 1};

    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];

        for (int i = 0; i < R; i++) {
            map[i] = bf.readLine().toCharArray();
        }

        // 위에서 아래로 각 행병로 따진다.
        for (int i = 0; i < R; i++) {
            // dfs() 로 파이프를 놓아가는데 마지막 까지 도달하면(C-1)까지 도달시 return 실패시 false;
            if (dfs(i, 0)) {
                answer++;
            }
        }
        System.out.println(answer);

    }

    static boolean dfs(int y, int x) {
        // 다음 좌표
        int nx = x + 1;
        // 기저 조건
        if (nx == C - 1) {
            return true;
        }
        for (int d = 0; d < 3; d++) {
            int ny = y + dy[d];
            if (ny < 0 || ny >= R || map[ny][nx] == 'x') {
                continue;
            }
            //다음 방문에서 다시 방문하지 않도록
            map[ny][nx] = 'x'; // 성공해도 실패해도 방문 X
            if (dfs(ny, nx)) {
                return true;
            }
        }
        return false;
    }
}