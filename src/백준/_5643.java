package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _5643 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> arrayListNormal = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> arrayListBack = new ArrayList<>();
    static boolean[] visited;
    static int back;
    static int normal;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            arrayListNormal.add(new ArrayList<>());
            arrayListBack.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arrayListNormal.get(from).add(to);
            arrayListBack.get(to).add(from);
        }
        for (int i = 1; i <= N; i++) {
            normal = 0;
            back = 0;
            visited = new boolean[N + 1];
            dfsNormal(i);
            visited = new boolean[N + 1];
            dfsBack(i);
//            System.out.println("-------------");
//            System.out.println(normal + " " + back);
            if (normal + back == N - 1) {

                answer++;
            }

        }
        System.out.println(answer);

    }

    private static void dfsNormal(int i) {

        if (visited[i]) {
            return;
        }
        visited[i] = true;

        for (int n : arrayListNormal.get(i)) {
            if (!visited[n]) {
                normal++;
            }
            dfsNormal(n);
        }
    }

    private static void dfsBack(int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int n : arrayListBack.get(i)) {
            if (!visited[n]) {
                back++;
            }
            dfsBack(n);
        }
    }
}
