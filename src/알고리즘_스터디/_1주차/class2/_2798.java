package 알고리즘_스터디._1주차.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2798 {

    public static int answer;
    public static int M;
    public static int N;
    public static int[] cards;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        recursion(0, 0, 0);
        System.out.println(answer);

    }

    public static void recursion(int index, int counter, int sum) {
        if (counter == 3) {
            if (sum > M) {
                return;
            }
            answer = Math.max(answer, sum);

            return;
        }

        if(index == N){
            return;
        }

        recursion(index + 1, counter, sum);
        recursion(index + 1, counter + 1, sum += cards[index]);
    }
}
