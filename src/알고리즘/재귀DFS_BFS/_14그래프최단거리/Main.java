package 알고리즘.재귀DFS_BFS._14그래프최단거리;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        int[] distance = bfs(graph, 1);

        // 출력: 1번 정점부터 각 정점까지의 최단 거리
        for (int i = 1; i <= n; i++) {
            System.out.println("Distance from 1 to " + i + ": " + distance[i]);
        }
    }

    public static int[] bfs(List<Integer>[] graph, int start) {
        // 길이를 저자할 알고리즘.배열
        int[] distance = new int[graph.length];
        // 우선 -1로 초기화
        Arrays.fill(distance, -1);  // 초기 거리를 -1로 설정 (방문하지 않은 정점을 표시)

        // 큐 생성과 시작점 추가
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            // 해당 노드에서 갈수 있는 모든 노드들
            for (int neighbor : graph[current]) {
                // 아직 방문하지 않은 정점이라면
                if (distance[neighbor] == -1) {
                    queue.add(neighbor);
                    // 현재 정점의 거리에서 +1d을 하여 이웃에게 저장
                    distance[neighbor] = distance[current] + 1;
                }
            }
        }
        return distance;
    }
}
