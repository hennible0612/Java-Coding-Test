package 알고리즘.재귀DFS_BFS._12경로탐색DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    private static int pathsCount;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {  // 1부터 시작하는 정점들을 고려하기 위해 n+1 크기로 초기화
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
        }

        visited = new boolean[n + 1];
        pathsCount = 0;
        dfs(1, 5);

        // 모든 경로의 가지 수 출력
        System.out.println("Total paths from 1 to " + 5 + ": " + pathsCount);

    }

    private static void dfs(int current, int destination) {
        if (current == destination) {
            pathsCount++;
            return;
        }

        visited[current] = true;

        for (int next : graph.get(current)) {
            if (!visited[next]) {
                dfs(next, destination);
            }
        }

        visited[current] = false;
    }
}
//5 9
//1 2
//1 3
//1 4
//2 1
//2 3
//2 5
//3 4
//4 2
//4 5