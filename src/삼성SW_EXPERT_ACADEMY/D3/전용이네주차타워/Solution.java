package 삼성SW_EXPERT_ACADEMY.D3.전용이네주차타워;


import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken()); // 주차 공간의 수
            int m = Integer.parseInt(st.nextToken()); // 차량의 수

            int[] ratePerWeight = new int[n]; // 각 주차 공간의 단위 무게당 요금
            for (int i = 0; i < n; i++) {
                ratePerWeight[i] = Integer.parseInt(bf.readLine());
            }

            int[] carWeights = new int[m]; // 각 차량의 무게
            for (int i = 0; i < m; i++) {
                carWeights[i] = Integer.parseInt(bf.readLine());
            }

            boolean[] parkingSlots = new boolean[n]; // 주차 공간의 상태 (주차되어 있으면 true)
            int[] parkedCars = new int[n]; // 각 주차 공간에 주차된 차량의 번호
            Queue<Integer> waitingQueue = new LinkedList<>(); // 대기 중인 차량 큐
            int totalIncome = 0; // 총 수입

            for (int i = 0; i < 2 * m; i++) {
                int car = Integer.parseInt(bf.readLine());
                if (car > 0) {
                    // 차량이 주차장에 들어옴
                    car--;
                    boolean parked = false;
                    for (int j = 0; j < n; j++) {
                        if (!parkingSlots[j]) {
                            parkingSlots[j] = true;
                            parkedCars[j] = car; // 주차된 차량 번호 저장
                            totalIncome += ratePerWeight[j] * carWeights[car];
                            parked = true;
                            break;
                        }
                    }
                    if (!parked) {
                        waitingQueue.add(car);
                    }
                } else {
                    // 차량이 주차장에서 나감
                    car = -car - 1;
                    for (int j = 0; j < n; j++) {
                        if (parkedCars[j] == car) { // 주차된 차량 찾기
                            parkingSlots[j] = false;
                            if (!waitingQueue.isEmpty()) {
                                int waitingCar = waitingQueue.poll();
                                parkingSlots[j] = true;
                                parkedCars[j] = waitingCar; // 새로운 차량 주차
                                totalIncome += ratePerWeight[j] * carWeights[waitingCar];
                            }
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + totalIncome);
        }
    }
}

