package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1717 {
    static int n, m;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int aParent = findParent(a);
                int bParent = findParent(b);

                if (aParent == bParent) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
            if (command == 0) {
                union(a, b);
            }

        }
        System.out.println(sb);
    }

    public static int findParent(int x) {
        if(parent[x] != x){
            parent[x] = findParent(parent[x]);

        }
        return parent[x];
    }

    public static void union(int x, int y) {
        int rootX = findParent(x);
        int rootY = findParent(y);
        if(rootX != rootY){
            parent[rootX] = rootY;
        }
    }
}
