package SSAFY._20240227;

import java.util.Scanner;

public class FibonacciTest {
    static long callCnt1, callCnt2;

    static long fibo1(int n) {
        callCnt1++;
        if (n < 2) {
            return n;
        }
        return fibo1(n - 1) + fibo1(n - 2);
    }

    static long[] memo;

    static long fibo2(int n) {
        callCnt2++;
        // 메모 안되어 있으면 계산후 메모하기
        if (n >= 2 && memo[n] == 0) {
            memo[n] = fibo2(n - 1) + fibo2(n - 2);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        memo = new long[N + 1]; // 0으로 자동초기화 (메모되지 않은 상태)
        // 처음 조건
        memo[0] = 0;
        memo[1] = 1;

        System.out.println(fibo2(N)); //메모이제이션
        System.out.println("함수 호출 횟수 : " + callCnt2);
        System.out.println(fibo1(N));
        System.out.println("함수 호출 횟수 : " + callCnt1);

        
    }
}
