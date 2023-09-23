package 백준;



//https://www.acmicpc.net/problem/2776
//이분탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());

        for (int i = 0; i < test_case; i++) {
            HashSet<String> set = new HashSet<>();
            int n = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                set.add(st.nextToken());
            }
            int m = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for (int p = 0; p < m; p++) {
                if (set.contains(st.nextToken())) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
