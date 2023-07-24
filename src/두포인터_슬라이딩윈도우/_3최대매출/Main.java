package 두포인터_슬라이딩윈도우._3최대매출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String[] str1  = bf.readLine().split(" ");
        int[] int_array = new int[n];
        for (int i = 0; i < n; i++) {
            int_array[i] = Integer.parseInt(str1[i]);
        }


        int start = 0;
        for (int i = 0; i < m; i++) {
            start += int_array[i];
        }
        int temp = start;
        for (int i = m; i < n; i++) {
            temp += int_array[i] - int_array[i - m];
            start = Math.max(start, temp);

        }
        System.out.println(start);

//        int starter = 0;
//        int answer = 0;
//        while (starter + m <= n) {
//            int temp = 0;
//            for (int i = starter; i < starter + m; i++) {
//                temp += int_array[i];
//            }
//            if (temp >= answer) {
//                answer = temp;
//            }
//            starter++;
//        }
//        System.out.println(answer);
    }
}
