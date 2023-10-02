package DFS_BFS_활용._15피자_배달거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<int[]> hs = new ArrayList<>();
    static ArrayList<int[]> pz = new ArrayList<>();

    //L => Level 최대 조합수까지 올라간다
    //s => 시작 인덱스
    public static void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (int[] h : hs) {
                int dis = Integer.MAX_VALUE; // 최소값 찾아야하니 최대값으로 초기화
                for (int i : combi) {

                    int[] p = pz.get(i);
                    dis = Math.min(dis, Math.abs(h[0] - p[0]) + Math.abs(h[1] - p[1]));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    hs.add(new int[]{i, j});
                }
                else if (tmp == 2){
                    pz.add(new int[]{i, j});
                }
            }
        }
        len = pz.size();
        combi = new int[m];
        DFS(0, 0);
        System.out.println(answer);
    }
}
