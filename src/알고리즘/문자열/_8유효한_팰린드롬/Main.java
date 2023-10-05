package 알고리즘.문자열._8유효한_팰린드롬;

import java.io.*;

public class Main {
    public static String solution(String str) {
        String answer = "NO";
        str = str.replaceAll("[^a-zA-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equalsIgnoreCase(tmp)) {
            answer = "YES";
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        System.out.println(solution(str));

    }
}
