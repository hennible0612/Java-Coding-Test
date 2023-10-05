package 알고리즘.그리디._7원더랜드_Prim_PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int unf[];

    public static class Edge implements Comparable<Edge> {
        private final int from;
        private final int weight;

        private Edge(int t, int w) {
//            this.from = f;
            this.from = t;
            this.weight = w;
        }

        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // node 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수

        boolean[] nodeList = new boolean[n + 1];

        ArrayList<PriorityQueue<Edge>> edgeArrayList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            edgeArrayList.add(new PriorityQueue<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int where = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeArrayList.get(from).add(new Edge(where, weight));
            edgeArrayList.get(where).add(new Edge(from, weight));

        }

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        // 시작점 추가
        pQ.offer(new Edge(1, 0));
        int answer = 0;
        while (!pQ.isEmpty()) {
            // 현재 edge
            Edge ce = pQ.poll();
            int ev = ce.from;
            if (!nodeList[ev]) {
                nodeList[ev] = true;
                answer += ce.weight;
                // 갈수있는 모든 정점들
                for (Edge ob : edgeArrayList.get(ev)) {
                    // 간곳이 아니라면 pQ에 추가
                    if (!nodeList[ob.from]) {
                        pQ.offer(new Edge(ob.from, ob.weight));
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
