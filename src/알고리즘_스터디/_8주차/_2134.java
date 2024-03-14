package 알고리즘_스터디._8주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 기존 창고의 층 수
        int m = Integer.parseInt(st.nextToken()); // 새 창고의 층 수
        int k = Integer.parseInt(st.nextToken()); // 인부의 수

        int[] oldWarehouse = new int[n];
        int[] newWarehouse = new int[m];

        // 기존 창고의 물품 개수 입력
        for (int i = 0; i < n; i++) {
            oldWarehouse[i] = Integer.parseInt(br.readLine());
        }

        // 새 창고의 물품 수용량 입력
        for (int i = 0; i < m; i++) {
            newWarehouse[i] = Integer.parseInt(br.readLine());
        }

        int totalMovedGoods = 0;
        long totalCost = 0;

        // 이전의 예시와 마찬가지로, 실제 문제 해결을 위한 최적화된 로직을 고려해야 합니다.
        // 단순한 접근법으로 구현된 예제입니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (oldWarehouse[i] > 0 && newWarehouse[j] > 0) {
                    int movedGoods = Math.min(oldWarehouse[i], newWarehouse[j]);
                    totalMovedGoods += movedGoods;
                    totalCost += movedGoods * (i + j + 2); // 층 이동 비용 계산, 1-indexed 가정
                    oldWarehouse[i] -= movedGoods;
                    newWarehouse[j] -= movedGoods;
                }
            }
        }

        System.out.println(totalMovedGoods + " " + totalCost);
    }
}
