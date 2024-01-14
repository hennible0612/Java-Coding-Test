package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
public class _5430 {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 총 수행할 수
        int t = Integer.parseInt(bf.readLine());


        for (int i = 0; i < t; i++) {
            boolean flag = true;
            // 명령어
            String commands = bf.readLine();
            // 길이
            int arr_length = Integer.parseInt(bf.readLine());
            // 입력
            String input = bf.readLine();
            String[] numbersStr = input.substring(1, input.length() - 1).split(",");
            // 파싱할거
            Deque<Integer> deque = new ArrayDeque<>();
            for (String s : numbersStr) {
                if (!s.equals("")) {
                    deque.add(Integer.parseInt(s.trim()));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char c : commands.toCharArray()) {
                if (c == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }


            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
