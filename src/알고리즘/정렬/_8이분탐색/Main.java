package 알고리즘.정렬._8이분탐색;

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
        Arrays.sort(array);
        int mid = 0;
        int low = 0;
        int high = n - 1;
        int answer = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == m) {
                answer = mid;
                break;
            } else if (array[mid] > m) { // target m이 더 작을경우
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer+1);

    }
}
