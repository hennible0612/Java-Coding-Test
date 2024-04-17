package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16953 {

    //2 162 -> 5
//        2 → 4 → 8 → 81 → 162
//
//4 42 -> -1
//100 40021 -> 5
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int answer = 1;

        while (true) {
            if(B == A){
                break;
            }
            if(B < A){
                answer = -1;
                break;
            }
            if (B % 10 == 1) {
                B = B / 10;
            }else if (B % 2 == 1) {
                answer = -1;
                break;
            }else{
                B = B / 2;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
