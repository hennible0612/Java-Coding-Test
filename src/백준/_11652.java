package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long temp = Long.parseLong(bf.readLine());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        List<Node> list = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list);
        System.out.print(list.get(0).number);
    }

    static class Node implements Comparable<Node> {
        long number;
        int frequency;

        public Node(long number, int frequency) {
            this.number = number;
            this.frequency = frequency;
        }

        public int compareTo(Node node) {
            if (this.frequency != node.frequency) {
                return node.frequency - this.frequency;
            }
            return Long.compare(this.number, node.number);
        }
    }
}