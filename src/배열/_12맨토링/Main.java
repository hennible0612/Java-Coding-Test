package 배열._12맨토링;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);  // 학생 수
        int m = Integer.parseInt(str[1]);  // 테스트 횟수

        int[][] test = new int[m][n];  // 각 테스트의 결과를 저장할 2차원 배열
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                test[i][j] = Integer.parseInt(str[j]);
            }
        }

        int answer = 0;
        // 각 학생 쌍에 대해 모든 테스트를 확인
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;  // 동일한 학생이면 건너뜀
                boolean mentor = true;
                for (int k = 0; k < m; k++) {
                    int pi = 0, pj = 0;
                    for (int l = 0; l < n; l++) {
                        if (test[k][l] == i) pi = l;
                        if (test[k][l] == j) pj = l;
                    }
                    if (pi > pj) {  // 특정 테스트에서 학생 A가 학생 B보다 순위가 낮으면 멘토가 될 수 없음
                        mentor = false;
                        break;
                    }
                }
                if (mentor) answer++;
            }
        }
        System.out.println(answer);
    }
}
