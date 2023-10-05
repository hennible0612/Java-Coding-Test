package 알고리즘.DFS_BFS_활용._2바둑이_승차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int answer;
    static int limit;
    static int n;
    static ArrayList<Integer> list;
    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        limit = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());  // 배열의 길이
        answer = 0;
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(bf.readLine()));
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int total, int index) {
        if (total > limit) {
            return;
        }
        if (index == n) {
            answer = Math.max(answer, total);

            return;
        } else {
            dfs(total + list.get(index), index + 1);
            dfs(total, index + 1);
        }

    }
}
