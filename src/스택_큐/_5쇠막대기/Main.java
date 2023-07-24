package 스택_큐._5쇠막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String string = bf.readLine();
        char[] char_array = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        int counter = 0;
        int answer = 0;

        for (char x : char_array) {
            if (x == '(') {
                stack.push('(');
                counter++;
            } else {
                counter--;
                if (stack.peek() == '(') {
                    answer += counter;
                } else {
                    answer += 1;
                }
                stack.push(')');
            }

        }
        System.out.println(answer);
    }
}
