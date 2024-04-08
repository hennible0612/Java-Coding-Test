package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        parent = new int[N + 1];


        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        int M = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int start = Integer.parseInt(st.nextToken());
        int startParent = findParent(start);
        String answer = "YES";
        for (int i = 1; i < M; i++) {
            int toParent = findParent(Integer.parseInt(st.nextToken()));
            if(startParent != toParent){
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);

    }
    public static int findParent(int x){
        if(parent[x] != x){
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x,int y){
        int rootX = findParent(x);
        int rootY = findParent(y);
        if(rootX != rootY){
            parent[rootX] = rootY;
        }
    }

}
