package A형.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15686 {

    public static int N;
    public static int M;
    public static int minDistance = Integer.MAX_VALUE;
    static List<int[]> houses;
    static List<int[]> chickens;


    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    houses.add(new int[]{i, j});
                } else if (temp == 2){
                    chickens.add(new int[]{i, j});
                }
            }
        }

        recursion(0, new ArrayList<>());
        System.out.println(minDistance);

    }

    public static void recursion(int counter, List<int[]> chickenHouses) {
        // m 일 경우 탈출
        if (chickenHouses.size() == M) {
            minDistance = Math.min(minDistance, calculateDistance(chickenHouses));
            return;
        }

        for (int i = counter; i < chickens.size(); i++) {
            chickenHouses.add(chickens.get(i));
            recursion(i + 1, chickenHouses);
            chickenHouses.remove(chickenHouses.size() - 1);
        }
    }

    // 거리 계산용
    private static int calculateDistance(List<int[]> chickenHouses) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int distance = Integer.MAX_VALUE;
            for (int[] chicken : chickenHouses) {
                distance = Math.min(distance, Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]));
            }
            totalDistance += distance;
        }
        return totalDistance;
    }
}
