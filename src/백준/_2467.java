package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2467 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 전체 용액의 수
        int[] solutions = new int[N]; // 용액의 특성값을 저장할 배열

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken()); // 용액의 특성값 입력
        }

        int left = 0, right = N - 1; // 투 포인터 초기화: 배열의 양 끝
        int closestSum = Integer.MAX_VALUE; // 0에 가장 가까운 용액의 합 초기값
        int solution1 = 0, solution2 = 0; // 결과를 저장할 두 용액의 특성값

        while (left < right) {
            int sum = solutions[left] + solutions[right]; // 현재 포인터에서의 용액 두 개의 합

            // 현재 합이 이전의 가장 가까운 합보다 0에 더 가까우면 결과 업데이트
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
                solution1 = solutions[left];
                solution2 = solutions[right];
            }

            // 합을 조절하여 0에 더 가까워지도록 포인터 이동
            if (sum < 0) {
                left++; // 합이 음수이면 왼쪽 포인터를 오른쪽으로 이동
            } else {
                right--; // 합이 양수이면 오른쪽 포인터를 왼쪽으로 이동
            }
        }

        // 결과 출력
        System.out.println(solution1 + " " + solution2);
    }
}
