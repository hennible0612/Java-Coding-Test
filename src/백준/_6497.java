package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _6497 {
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {

            StringTokenizer st = new StringTokenizer(bf.readLine());

            // m 집의 수 n 길의 수
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) {
                break;
            }

            ArrayList<Edge> edgeList = new ArrayList<>();

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int sum = 0;
            for (int i = 1; i <= n; i++) {

                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                sum += weight;
                edgeList.add(new Edge(from, to, weight));
            }

            int answer = 0;
            Collections.sort(edgeList);

            for (Edge edge : edgeList) {
                if (find(edge.x) != find(edge.y)) {
                    union(edge.x, edge.y);
                    answer += edge.z;
                }
            }
            sb.append(sum - answer).append("\n");

        }
        System.out.println(sb);

    }

    static int find( int v) {
        if (v == parent[v]) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    static void union(int v, int w) {
        int rootA = find(v);
        int rootB = find(w);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    static class Edge implements Comparable<Edge> {
        // x 집 y 집 z 미터
        int x;
        int y;
        int z;

        Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;

        }

        @Override
        public int compareTo(Edge o) {
            return this.z - o.z;
        }
    }
}
