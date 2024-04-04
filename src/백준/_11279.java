package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _11279 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2 - e1);
        for (int i = 0; i < N; i++) {
            int command = Integer.parseInt(bf.readLine());
            if (command == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }else{
                pq.add(command);
            }
        }
        System.out.println(sb);
    }
}
