package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _13905 {

    // N 집수 M 다리수
    static int N, M;
    // S Start E end
    static int S, E;
    // 집
    static ArrayList<ArrayList<Edge>> arrayList;
    static ArrayList<ArrayList<Edge>> map;
    static PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 집번호1, 집번호2, 다리무게제한
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 시작위치
        st = new StringTokenizer(bf.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();
        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<>());
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arrayList.get(start).add(new Edge(start, to, weight));
            arrayList.get(to).add(new Edge(to, start, weight));
        }

        visited = new boolean[N + 1];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(S, S,0));
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (visited[edge.to]) {
                continue;
            }
            visited[edge.to] = true;
            map.get(edge.start).add(new Edge(edge.start, edge.to, edge.weight));
            map.get(edge.to).add(new Edge(edge.to, edge.start, edge.weight));
            for (Edge nextEdge : arrayList.get(edge.to)) {
                if (!visited[nextEdge.to]) {
                    priorityQueue.add(nextEdge);
                }
            }

        }
        int max = Integer.MIN_VALUE;
        for (Edge edge : map.get(E)) {
            max = Math.max(edge.weight, max);
        }
        System.out.println(max);
    }



    static class Edge implements Comparable<Edge> {
        int start;
        int to;
        int weight;

        public Edge(int start, int to, int weight) {
            this.start = start;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return o.weight - this.weight;
        }
    }
}
