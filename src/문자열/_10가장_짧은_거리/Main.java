package 문자열._10가장_짧은_거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String solution(String str) {
        str = str + " ";
        char[] array = str.toCharArray();
        StringBuilder answer = new StringBuilder();
        char curChar = array[0];
        int counter = 1;
        for (int i = 1; i < array.length; i++) {
            if (curChar != array[i]) {
                answer.append(curChar);
                if (counter > 1) {
                    answer.append(counter);
                }
                counter = 1;
            } else {
                counter++;
            }
            curChar = array[i];
        }
        return answer.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }

}
