package 삼성SW_EXPERT_ACADEMY.D4.가능한시험점수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static int[] scores;
    static int n;

    static HashSet<Integer> hashSet;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            hashSet = new HashSet<>();
            n = Integer.parseInt(bf.readLine());
            visited = new boolean[10001];

            scores = new int[n];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println("#" + test_case + " " + hashSet.size());

        }
    }

    private static void dfs(int index, int count) {
        if (visited[count]) {
            return;
        }
        visited[count] = true;
        hashSet.add(count);
        if (index == n) {
            return;

        }

        dfs(index + 1, count + scores[index]);
        dfs(index + 1, count);
    }
}
