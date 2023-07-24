package 정렬._4LRU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] int_array = new int[s];
        int[] process = new int[s];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            process[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : process) {

        }

    }
}

