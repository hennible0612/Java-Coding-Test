package 알고리즘.정렬._10마구간정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int answer = 0;
        int lt = 1;
        int rt = array[n - 1];
        int mid;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            int distance = count(array, mid);
            if (distance >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }

        }
        System.out.println(answer);
    }

    public static int count(int[] arr, int mid) {
        int counter = 1;
        int temp;
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i] - arr[p];

            if (mid <= temp) {
                p = i;
                counter++;
            }
        }

        return counter;
    }
}
