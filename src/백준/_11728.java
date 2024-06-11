package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class _11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arrayList);


        StringBuilder sb = new StringBuilder();
        for (int i : arrayList) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}