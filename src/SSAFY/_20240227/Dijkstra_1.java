package SSAFY._20240227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_1 {
    static int V, E, K;
    static List<List<Edge>> adjList = new ArrayList<>();
    static int[] cost;// 시작 정점으로부터의 최소 비용 관리
    static boolean[] visited; // 꺼낼때
    static PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
    static StringBuilder sb = new StringBuilder();
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(bf.readLine());

        visited = new boolean[V + 1];
        cost = new int[V + 1];

        // cost, adjList 초기하ㅗ
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
            cost[i] = INF;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList.get(v1).add(new Edge(v2, w));
        }
        // 풀이
        dijkstra();

        for (int i = 1; i <= V; i++) {
            sb.append(cost[i] == INF ? "INF" : cost[i]).append("\n");
        }
        System.out.println(sb);

    }

    private static void dijkstra() {
        // 시작 정점 K
        cost[K] = 0;
        priorityQueue.offer(new Edge(K, 0));
        while (!priorityQueue.isEmpty()) {

            // 최소비용 정점
            Edge e = priorityQueue.poll();
            if (visited[e.v]) {
                continue;
            }

            //추가 가지치기
            if (cost[e.v] < e.c) {
                continue;
            }

            visited[e.v] = true;
            // 꺼낸 e.v로부터 갈수 이쓴ㄴ 다른 정점을 고려
            for (Edge ne : adjList.get(e.v)) { //해당 노드가 갈수 있는 모든 Edge
                if (ne.c + cost[e.v] < cost[ne.v]) {
                    cost[ne.v] = ne.c + cost[e.v];
                    //더 좋은 경쟁을 위해 해당 정점 추가
                    priorityQueue.add(new Edge(ne.v, cost[ne.v]));
                }
            }
        }
    }

    static class Edge {
        int v, c; //정점과 거기로 가는 비용

        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
