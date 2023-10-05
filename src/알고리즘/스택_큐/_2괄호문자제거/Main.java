package 알고리즘.스택_큐._2괄호문자제거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        char[] char_arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char x : char_arr) {
            if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                if (!stack.empty()) {
                    stack.pop();

                }
            } else {
                if (stack.empty()) {
                    stringBuilder.append(x);
                }
            }
        }

        System.out.println(stringBuilder);



    }
}
