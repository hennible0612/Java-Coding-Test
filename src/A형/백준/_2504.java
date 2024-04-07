package A형.백준;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class _2504 {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        solution(s);
        System.out.println(answer);
    }

    private static void solution(String s) {
        ArrayDeque<Character> bracketStack = new ArrayDeque<>();
        ArrayDeque<Integer> valueStack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[') {
                bracketStack.push(ch);
                valueStack.push(-1); // 새 괄호 쌍의 시작을 표시
            } else {
                if (bracketStack.isEmpty()) {
                    return;
                }
                char open = bracketStack.pop();
                int value = 0;
                while (!valueStack.isEmpty() && valueStack.peek() != -1) {
                    value += valueStack.pop();
                }
                if (!valueStack.isEmpty()) {
                    valueStack.pop();
                }

                if (ch == ')' && open == '(') {
                    valueStack.push(value == 0 ? 2 : value * 2);
                } else if (ch == ']' && open == '[') {
                    valueStack.push(value == 0 ? 3 : value * 3);
                } else {
                    return; // 올바르지 않은 괄호 쌍
                }
            }
        }

        int totalValue = 0;
        while (!valueStack.isEmpty()) {
            if (valueStack.peek() == -1) { // 올바르지 않은 괄호 쌍 확인
                return;
            }
            totalValue += valueStack.pop();
        }

        if (bracketStack.isEmpty()) {
            answer = totalValue;
        }
    }
}
