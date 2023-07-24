package 배열._6뒤집은_소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return rev;
    }

    public static List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for (int x : arr) {
            x = reverse(x);
            if (isPrime(x)) {
                answer.add(x);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] num_array = bf.readLine().split(" ");
        int[] int_array = new int[n];
        for (int i = 0; i < n; i++) {
            int_array[i] = Integer.parseInt(num_array[i]);
        }

        for (int answer : solution(int_array)) {
            System.out.println(answer);
        }
    }
}

