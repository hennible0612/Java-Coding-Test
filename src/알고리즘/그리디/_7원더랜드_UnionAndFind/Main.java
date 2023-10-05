package 알고리즘.그리디._7원더랜드_UnionAndFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] unf;
    public static int find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb; // a집합의 부모를 fb로 변경
        }

    }
    static class Edge implements Comparable<Edge> {
        private final int from;
        private final int to;
        private final int weight;

        private Edge(int f, int t, int w) {
            this.from = f;
            this.to = t;
            this.weight = w;
        }

        public int compareTo(Edge node) {
            return this.weight - node.weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // node 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++)  {
            unf[i] = i;
        }

        PriorityQueue<Edge> nodeArrayList = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int where = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodeArrayList.add(new Edge(from, where, weight));
        }

        int answer = 0;

        while (!nodeArrayList.isEmpty()) {
            Edge node = nodeArrayList.poll();
            int from = node.from;
            int to = node.to;
            int weight = node.weight;

            if (find(from) != find(to)) {
                answer += weight;
                union(from, to);
            }
        }
        System.out.println(answer);
    }
}
