package SSAFY._20240227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {
    static class Node implements Comparable<Node> {

        int from, to, weight;

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.from - o.from;
        }

    }


    static ArrayList<ArrayList<Node>> arrayLists;
    static int[] distanceArray;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점
        int E = Integer.parseInt(st.nextToken()); // 간선
        int K = Integer.parseInt(bf.readLine()); // 시작정점
        arrayLists = new ArrayList<>();
        distanceArray = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(distanceArray, Integer.MIN_VALUE);

        for (int i = 0; i <= V; i++) {
            arrayLists.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arrayLists.get(from).add(new Node(from, to, weight));
        }

        dijkstra(K);

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0, 0));
        distanceArray[start] = 0;
        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            for (Node node : arrayLists.get(current.from)) {
//                if(node.weight + current.weight >= )
            }
        }
    }
}
