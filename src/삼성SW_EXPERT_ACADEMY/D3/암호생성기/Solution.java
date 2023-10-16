package 삼성SW_EXPERT_ACADEMY.D3.암호생성기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int i = 1; i <= T; i++) {
            Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Queue<Integer> queue = new LinkedList<>();

            while (st.hasMoreTokens()) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            int counter = 1;

            while (true) {
                int tmp = queue.poll();
                if (tmp - counter <= 0) {
                    queue.offer(0);
                    break;
                } else {
                    queue.offer(tmp - counter);
                }
                counter = (counter % 5) + 1;
            }

            System.out.print("#" + i + " ");
            for (int a : queue) {
                System.out.print(a + " ");
            }
            System.out.println("");

        }
    }
}