package 두포인터_슬라이딩윈도우._5연속된_자연수으_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int answer = 0;
        int temp = 0;
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            if ((n + 1)/ 2 < i) {
                break;
            }
            temp += i;
            if (temp == n) {
                answer++;
                counter++;
                i = counter;
                temp = 0;
            } else if (temp > n) {
                counter++;
                i = counter;
                temp = 0;

            }
        }
        System.out.println(answer);

    }
}
