package 알고리즘_스터디._2주차.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1238 {
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

    static final int INF = Integer.MAX_VALUE;
    static int V, E, X;
    static List<List<Node>> graph, reverseGraph;
    static int[] distToX, distFromX;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        //Edge 입력
        for(int i =0; i< E; i++){
            st = new StringTokenizer(bf.readLine());
            // u : 시작, v : 목적지, w : weight, cost
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
            reverseGraph.get(v).add(new Node(u, w));
        }

        distToX = dijkstra(graph, X);
        distFromX = dijkstra(reverseGraph, X);

        int maxTime = 0;
        for (int i = 1; i <= V; i++) {
            maxTime = Math.max(maxTime, distToX[i] + distFromX[i]);
        }

        System.out.println(maxTime);
    }

    public static int[] dijkstra(List<List<Node>> graph, int start){
        // 각각 노드까지의 길이 무한으로
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);

        // 시작점은 0
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작점 위치 큐에 추가
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            // 현위치 정보 가지고온다
            Node current = pq.poll();
            int currentNode = current.vertex;
            int weight = current.cost;

            // 다른 경로에서 더 짧은 거리 찾았다면 패스
            if(dist[currentNode] < weight){
                continue;

            }

            // 현 위치에 인접한 모든 정점 순회
            for (Node node : graph.get(currentNode)) {
                // 현재 정점을 거쳐 인접 정점으로 가는 거리가 기존에 알려진 거리보다짧을 경우 업데이트
                if (dist[node.vertex] > dist[currentNode] + node.cost) {
                    //업데이트후 인접 정ㅂ점을 큐에 추가 
                    dist[node.vertex] = dist[currentNode] + node.cost;
                    pq.add(new Node(node.vertex, dist[node.vertex]));

                }
            }
        }

        return dist;
    }
}
