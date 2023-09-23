package 정렬._6장난꾸러기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        Integer[] array = new Integer[n];
        Integer[] array1 = new Integer[n];
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            array[i] = temp;
            array1[i] = temp;
        }
        int[] answer = new int[2];
        Arrays.sort(array);
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(array1[i])) {
                answer[idx++] = i + 1;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);

    }
}
