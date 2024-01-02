package 삼성SW_EXPERT_ACADEMY.D4.괄호짝짓기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int length = Integer.parseInt(bf.readLine());

            Stack<Character> stack = new Stack<>();

            String target = bf.readLine();
            boolean isValid = true;

            for (int i = 0; i < length; i++) {
                char temp = target.charAt(i);
                if (temp == '{' || temp == '(' || temp == '<' || temp == '[') {
                    stack.add(temp);
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    if (temp == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (temp == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (temp == '>' && stack.peek() == '<') {
                        stack.pop();
                    } else if (temp == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("#" + test_case + " " + 1);
            } else {
                System.out.println("#" + test_case + " " + 0);
            }
        }
    }
}
