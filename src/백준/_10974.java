package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10974 {
    static int[] numbers;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        numbers = new int[N];
        selected = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }
        recursion(0);
        System.out.println(sb);

    }

    static void recursion(int depth) {
        if(depth == N){
            for (int i : selected) {

                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]){
                continue;

            }
            selected[depth] = numbers[i];
            visited[i] = true;
            recursion(depth + 1);
            visited[i] = false;
        }
    }
}
