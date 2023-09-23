package DFS_BFS_활용._6순열구하기;

import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer> numbers;
    public static int[] pm;
    public static int[] checker;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()); // level
        m = Integer.parseInt(st.nextToken());

        numbers = new ArrayList<>();

        st = new StringTokenizer(bf.readLine());

        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        pm = new int[m];
        checker = new int[n];

        dfs(0);
    }

    public static void dfs(int level) {
        if (level == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println(" ");
        } else {
            for (int i = 0; i < n; i++) {

                if (checker[i] == 0) {
                    pm[level] = numbers.get(i);
                    checker[i] = 1;
                    dfs(level + 1);
                    checker[i] = 0;
                }
            }
        }
    }
}
