package 알고리즘_스터디._11주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20040 {

    static int[] parent;
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());

            if (!union(temp1, temp2)) {
                answer = i + 1;
                break;
            }
        }
        System.out.println(answer);
    }

    static int find(int num1) {
        if (parent[num1] == num1) {
            return num1;
        }
        return parent[num1] = find(parent[num1]);
    }

    public static boolean union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent == yParent) {
            return false;
        } else {
            parent[xParent] = yParent;
        }
        return true;
    }
}
