package 문자열._4단어_뒤집기;

import java.util.ArrayList;
import java.util.Scanner;

public class Reverse {
    public static ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            // 문자열을 char 배열로 바꿈
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() - 1;
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            //배열을 String으로
            String tmp = String.valueOf(s);
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
