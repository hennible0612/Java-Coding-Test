package 알고리즘.스택_큐._4후위식_연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String string = bf.readLine();
        char[] char_array = string.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char x : char_array) {
            if (x == '+' || x == '-' || x == '/' || x == '*') {
                int a = stack.pop();
                int b = stack.pop();
                if (x == '+') {
                    stack.push(b + a);
                } else if (x == '-') {
                    stack.push(b - a);
                } else if (x == '*') {
                    stack.push(b * a);
                } else {
                    stack.push(b / a);
                }
            }  else {
                stack.push(Integer.parseInt(String.valueOf(x)));

            }
        }
        System.out.println(stack.pop());

    }
}
