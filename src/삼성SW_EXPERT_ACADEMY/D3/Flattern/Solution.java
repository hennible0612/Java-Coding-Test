package 삼성SW_EXPERT_ACADEMY.D3.Flattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int i = 1; i <= T; i++) {

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int switch_time = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 100; j++) {
                int temp = Integer.parseInt(st.nextToken());
                treeMap.put(temp, treeMap.getOrDefault(temp, 0) + 1);
            }

            for (int j = 0; j < switch_time; j++) {
                int lowest = treeMap.firstKey();
                int highest = treeMap.lastKey();

                treeMap.put(highest, treeMap.get(highest) - 1);
                if (treeMap.get(highest) == 0) {
                    treeMap.remove(highest);
                }
                treeMap.put(lowest, treeMap.get(lowest) - 1);
                if (treeMap.get(lowest) == 0) {
                    treeMap.remove(lowest);
                }

                treeMap.put(highest - 1, treeMap.getOrDefault(highest - 1, 0) + 1);
                treeMap.put(lowest + 1, treeMap.getOrDefault(lowest + 1, 0) + 1);
            }

            System.out.println("#" + i + " " + (treeMap.lastKey() - treeMap.firstKey()));
        }
    }
}