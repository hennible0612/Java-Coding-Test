package 문자열._3문장속단어;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static String solution(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        String answer = "";
        int max = 0;
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (temp.length() > max) {
                max = temp.length();
                answer = temp;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(solution(str));
    }
}

