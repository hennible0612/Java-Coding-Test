package 알고리즘.스택_큐._6공주구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int a = Integer.parseInt(st.nextToken());  // 첫 번째 토큰을 int로 변환합니다.
        int b = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= a; i++) {
            queue.add(i);
        }
        int counter = 0;
        while (queue.size() != 1) {
            int temp = queue.remove();
            counter++;
            if (counter / b == 1) {
                counter = 0;
            } else {
                queue.add(temp);
            }

        }

        System.out.println(queue.remove());
    }
}
