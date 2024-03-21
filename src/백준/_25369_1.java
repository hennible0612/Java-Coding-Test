package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25369_1 {
    static int n;
    static int[] aCards;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        // 선택한 n장의 카드의 수를 입력받아 배열에 저장
        StringTokenizer st = new StringTokenizer(bf.readLine());
        aCards = new int[n];
        for (int i = 0; i < n; i++) {
            aCards[i] = Integer.parseInt(st.nextToken());
        }


        // 친구가 선택할 카드 집합 B 찾기
        int[] result = Solution();


        // 결과 정렬 및 출력
        if (result.length == 1 && result[0] == -1) {
            System.out.println("-1");
        } else {
            Arrays.sort(result);
            for (int card : result) {
                System.out.print(card + " ");
            }
        }
    }

    private static int[] Solution() {
        // target 설정
        int pA = 1;
        for (int card : aCards) {
            pA *= card;
        }

        int minP = Integer.MAX_VALUE;
        int[] minSet = new int[n];
        boolean found = false;

        // 모든 경우의 수
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                // 카드수 하나일시
                if (n == 1) {
                    int pB = i; // 1 ~ 9까지
                    if (pB > pA && pB < minP) { // 조건 검사
                        minP = pB;
                        minSet[0] = i;
                        found = true;
                    }
                } else if (n == 2) {
                    int pB = i * j; // 집합 B의 곱 P(B) 계산
                    if (pB > pA && pB < minP) { // 조건 검사
                        minP = pB;
                        minSet[0] = i;
                        minSet[1] = j;
                        found = true;
                    }
                }
                // 여기에 더 많은 카드를 고려하는 루프 추가 가능
            }
        }

        if (!found) {
            return new int[]{-1}; // {-1} 반환
        }
        return minSet; // 조건을 만족하는 최소 집합 B 반환
    }
}
