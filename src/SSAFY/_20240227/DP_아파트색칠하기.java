package SSAFY._20240227;

import java.util.Arrays;

public class DP_아파트색칠하기 {
    static int memoi[] = new int[9]; // 0 dummy
    public static void main(String[] args) {
        // 현 단계의 수 = 이전 단계의 수 + 이전 단계의 노란색 수
        // 현 단계의 수 = 이전 단계의 수 + 더 이전 단계의 수
        memoi[1] = 2;
        memoi[2] = 3;

        for (int i = 3; i <= 8; i++) { // range 3 --> 8
            memoi[i] = memoi[i - 1] + memoi[i - 2];
        }
        System.out.println(memoi[8]);
        System.out.println(Arrays.toString(memoi));

    }
}
