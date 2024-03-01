package SSAFY._20240223.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _15961 {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int answer = 0;

        int numberOfDishes = Integer.parseInt(st.nextToken());
        int numberOfSushi = Integer.parseInt(st.nextToken());
        int dishStreak = Integer.parseInt(st.nextToken());
        int couponNum = Integer.parseInt(st.nextToken());

        int[] sushiArr = new int[numberOfDishes];
        for (int i = 0; i < numberOfDishes; i++) {
            sushiArr[i] = Integer.parseInt(bf.readLine());
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        int maxTypes = 0;

        //초기값 설정
        for (int i = 0; i < dishStreak; i++) {
            countMap.put(sushiArr[i], countMap.getOrDefault(sushiArr[i], 0) + 1);
        }

        // 초기 maxType
        maxTypes = countMap.size();
        if (!countMap.containsKey(couponNum)) { // 만약 쿠포 스시 없을 경우
            maxTypes++;
        }

        //슬라이딩 윈도우
        for (int i = 1; i < numberOfDishes; i++) {
            int prevIndex = (i - 1) % numberOfDishes;
            int newIndex = (i + dishStreak - 1) % numberOfDishes;

            // 이전 초밥 제거
            if (countMap.get(sushiArr[prevIndex]) == 1) {
                //스시 사망 1이니까
                countMap.remove(sushiArr[prevIndex]);
            } else {
                // 목숨 - 1
                countMap.put(sushiArr[prevIndex], countMap.get(sushiArr[prevIndex]) - 1);
            }
            // 새로운 초밥 추가하너가 목숨 더해줌
            countMap.put(sushiArr[newIndex], countMap.getOrDefault(sushiArr[newIndex], 0) + 1);

            int currentTypes = countMap.size();
            if (!countMap.containsKey(couponNum)) {
                currentTypes++;
            }
            maxTypes  = Math.max(maxTypes, currentTypes);
        }
        System.out.println(maxTypes );
    }
}
