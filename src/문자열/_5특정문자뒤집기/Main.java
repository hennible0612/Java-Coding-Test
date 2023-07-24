package 문자열._5특정문자뒤집기;

import java.util.Scanner;

public class Main {
    public static String solution(String input) {
        char[] answer = input.toCharArray();
        char tmp =' ';
        int lt = 0, rt = answer.length - 1;
        while (lt < rt) {
            if(!Character.isAlphabetic(answer[lt]))
                lt++;
            else if (!Character.isAlphabetic(answer[rt])) {
                rt--;
            }
            else {
                tmp = answer[lt];
                answer[lt] = answer[rt];
                answer[rt] = tmp;
                lt++;
                rt--;
            }
        }
        // String은 객체 이니까 new
        return new String(answer);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }
}