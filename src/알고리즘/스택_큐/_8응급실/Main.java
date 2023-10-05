package 알고리즘.스택_큐._8응급실;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] line = bf.readLine().split(" ");

        Queue<Pair> queue = new LinkedList<>();

        int answer = 1;

        for (int i = 0; i < n; i++) {
            queue.offer(new Pair(i, Integer.parseInt(line[i])));
        }
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            for (Pair x : queue) {
                if (x.second > temp.second) {
                    queue.offer(temp);
                    temp = null;
                    break;

                }
            }
            if (temp != null) {
                if (temp.first == m) {
                    break;
                } else {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
