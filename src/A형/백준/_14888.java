package A형.백준;

import java.io.*;
import java.util.*;

public class _14888 {

    static int max_value = Integer.MIN_VALUE;
    static int min_value = Integer.MAX_VALUE;
    static int[] operationArray;
    static int[] numberArray;
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        numberArray = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            numberArray[i] = Integer.parseInt(st.nextToken());
        }

        // + - x /
        operationArray = new int[4];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < 4; i++) {
            operationArray[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(numberArray[0], 1);

        System.out.println(max_value);
        System.out.println(min_value);
    }

    public static void backtrack(int number, int idx) {
        // 틸출 조건
        if(N == idx ) {
            max_value = Math.max(max_value, number );
            min_value = Math.min( min_value, number);
            return;
        }
        // 사칙연산에 대해 트리형태로
        for(int i = 0; i < 4; i++) {

            if(operationArray[i] > 0) {
                // 해당 operation 사용했으니 --
                operationArray[i]--;

                if(i == 0) {
                    backtrack(number + numberArray[idx], idx + 1);
                }else if(i == 1) {
                    backtrack(number - numberArray[idx], idx + 1);
                }else if(i == 2) {
                    backtrack(number * numberArray[idx], idx + 1);
                }else if(i == 3) {
                    backtrack(number / numberArray[idx], idx + 1);
                }
                // 복구
                operationArray[i]++;
            }
        }

    }
}