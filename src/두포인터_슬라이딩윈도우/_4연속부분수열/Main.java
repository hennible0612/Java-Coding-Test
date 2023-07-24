package 두포인터_슬라이딩윈도우._4연속부분수열;

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

        int answer = 0;
        int temp = 0;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            temp += int_array[i];
            if (temp == m) {
                answer++;
                i = counter;
                counter++;
                temp = 0;
            } else if (temp > m) {
                i = counter;
                counter++;
                temp = 0;
            }

        }
        System.out.println(answer);


    }
}
