package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1197 {
    static int V;
    static int E;


    static ArrayList<ArrayList<Edge>> arrayList;
    static boolean[] visited;

    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();
        visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i < E ; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            arrayList.get(A).add(new Edge(B, C));
            arrayList.get(B).add(new Edge(A, C));
        }


        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(1, 0));
        answer = 0;
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (visited[edge.to]){
                continue;

            }
            visited[edge.to] = true;
            answer += edge.weight;

            for (Edge nextEdge : arrayList.get(edge.to)) {
                if (!visited[nextEdge.to]) {
                    priorityQueue.add(nextEdge);
                }
            }
        }
        System.out.println(answer);

    }

    static class Edge implements Comparable<Edge> {

        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
