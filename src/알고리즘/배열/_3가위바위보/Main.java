package 알고리즘.배열._3가위바위보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String solution(Integer n, int[] A, int[] B) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                answer += "D";
            } else if ((A[i] == 1 && B[i] == 3) || (A[i] == 2 && B[i] == 1) || (A[i] == 3 && B[i] == 2)) {
                answer += "A";
            } else {
                answer += "B";
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        String[] inputA = bf.readLine().split(" ");
        String[] inputB = bf.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inputA[i]);
            B[i] = Integer.parseInt(inputB[i]);
        }
        System.out.println(solution(N, A, B));
    }
}
