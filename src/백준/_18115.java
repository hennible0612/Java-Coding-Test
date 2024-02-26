package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _18115 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] commands = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> deck = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            int command = commands[i];
            if (command == 1) {
                deck.addFirst(N - i);
            } else if (command == 2) {
                int first = deck.removeFirst();
                deck.addFirst(N - i);
                deck.addFirst(first);
            } else if (command == 3) {
                deck.addLast(N - i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deck.isEmpty()) {
            sb.append(deck.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}

