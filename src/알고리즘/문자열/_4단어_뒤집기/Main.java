package 알고리즘.문자열._4단어_뒤집기;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scn.next();
        }
        for (String x : solution(n, str)) {
            System.out.println(x);

        }
    }
}