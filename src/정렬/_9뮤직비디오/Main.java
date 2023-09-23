package 정렬._9뮤직비디오;

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
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int mid = 0;
        int low = Arrays.stream(array).max().getAsInt();
        int high = n - 1;
        int answer = -1;

        for (int x : array) {
            high += x;
        }


        while (low <= high) {
            mid = (low + high) / 2;
            if (count(array, mid) <= m) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);

    }

    public static int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for(int x : arr) {
            if(sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }
}
