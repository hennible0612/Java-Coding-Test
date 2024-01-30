package A형.백준;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649 {


    static boolean[] checker;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        checker = new boolean[N];
        recursion(0);

    }

    static void recursion(int start) {
        if(checker[start]) {
            return;
        }

        checker[start] = true;

        if(start >= M) {
            for(int i = 0; i < N; i++) {
                if(checker[i]) {
                    System.out.print(i + 1 + " ");
                }
                System.out.println();
            }
            return;
        }

        recursion(start + 1);
        recursion(start);



    }
}
