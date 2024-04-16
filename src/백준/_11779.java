package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11779 {
    static int n, m;
    static int[] dist;
    static int A, B;
    static ArrayList<ArrayList<Node>> arrayList;
    static int[] way;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        dist = new int[n + 1];
        way = new int[n + 1];
        arrayList = new ArrayList<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        StringTokenizer st;

        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arrayList.get(from).add(new Node(from, to, cost));
        }

        st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dijkstra(A);
        calculateAnswer();
    }

    private static void calculateAnswer() {
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = B; i != A; i = way[i]) {
            path.add(i);
        }
        path.add(A);

        Collections.reverse(path);

        sb.append(dist[B]).append("\n").append(path.size()).append("\n");
        for (int city : path) {
            sb.append(city).append(" ");
        }
        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        pq.offer(new Node(start, 0, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.from]) {
                continue;
            }

            visited[node.from] = true;

            for (Node neighbor : arrayList.get(node.from)) {
                if (dist[neighbor.to] > dist[node.from] + neighbor.cost) {
                    dist[neighbor.to] = dist[node.from] + neighbor.cost;
                    way[neighbor.to] = node.from;
                    pq.offer(new Node(neighbor.to, 0, dist[neighbor.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

        Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
