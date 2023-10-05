package 알고리즘.스택_큐._1올바른괄호;

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
        String answer ="YES";
        for (char x : char_arr) {
            if (x == '(') {
                stack.push(x);
            }
            if (x == ')') {
                if (stack.empty()) {
                    answer = "NO";
                    break;
                } else {
                    stack.pop();
                }

            }
        }


        if (!stack.empty()) {
            answer = "NO";
        }
        System.out.println(answer);


    }
}
