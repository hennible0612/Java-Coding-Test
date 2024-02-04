package 알고리즘_스터디._3주차.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); 
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] command = bf.readLine().split(" ");

            switch (command[0]) {
                case "push":
                    queue.offer(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    Integer item = queue.poll();
                    if (item == null) {
                        System.out.println(-1);
                    } else {
                        System.out.println(item);
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    Integer frontItem = queue.peek();
                    if (frontItem == null) {
                        System.out.println(-1);
                    } else {
                        System.out.println(frontItem);
                    }
                    break;
                case "back":
                    Integer backItem = queue.peekLast();
                    if (backItem == null) {
                        System.out.println(-1);
                    } else {
                        System.out.println(backItem);
                    }
                    break;
            }
        }
    }
}
