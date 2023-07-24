package 문자열._12암호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static String solution(Integer n, String str) {
        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i) == '#' ? '1' : '0');

            if (i % 7 == 6) {
                // 2진수 변환
                int decimal = Integer.parseInt(temp.toString(), 2);
                answer.append((char) decimal);
                temp.setLength(0);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        String cipher = br.readLine();
        System.out.println(solution(n, cipher));
    }
}
