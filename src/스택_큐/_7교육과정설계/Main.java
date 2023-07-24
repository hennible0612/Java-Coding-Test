package 스택_큐._7교육과정설계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String target = bf.readLine();
        String given = bf.readLine();

        char[] charArr = target.toCharArray();

        Queue<Character> queue = new LinkedList<>();
        for (char x : target.toCharArray()) {
            queue.offer(x);
        }

        for (char c : given.toCharArray()) {
            if(queue.isEmpty()){
                break;
            }
            if(c == queue.peek()){
                queue.remove();
            }
        }
        if (!queue.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }


    }
}
