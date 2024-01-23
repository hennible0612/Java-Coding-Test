package 알고리즘_스터디._1주차.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1546 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int array[] = new int[n];
        double sum = 0;
        double big = 0;

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            if (big < array[i]) {
                big = array[i];
            }
        }
        for (int i = 0; i < n; i++) {
            sum += (array[i] / big) * 100;
        }

        System.out.println(sum / n);
    }
}
