package 알고리즘_스터디._3주차.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1753 {
    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(bf.readLine());

        graph = new List[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        dijkstra(K);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF");
            } else {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.vertex]) {
                continue;
            }
            visited[current.vertex] = true;

            for (Node node : graph[current.vertex]) {
                if (dist[node.vertex] > dist[current.vertex] + node.cost) {
                    dist[node.vertex] = dist[current.vertex] + node.cost;
                    pq.offer(new Node(node.vertex, dist[node.vertex]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}
