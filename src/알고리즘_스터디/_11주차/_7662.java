package 알고리즘_스터디._11주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _7662 {
    static int T;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        // 정수만 저장하는 이중 우선순위 큐, 큐에 저장된 데이터 중 최댓값과 최솟값을 출력하는 프로그램을 작성하라
        // 큐에 적용될 일련의 연산이 주어질때 이를 처리한 후 최종적으로 Q에 저장된 데이터중 최댓값과 최솟값을 출력하는 프로그램
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(bf.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    treeMap.put(number, treeMap.getOrDefault(number, 0) + 1);
                } else {
                    if (!treeMap.isEmpty()) {
                        int key = (number == 1) ? treeMap.lastKey() : treeMap.firstKey();

                        if (treeMap.get(key) > 1) {
                            treeMap.put(key, treeMap.get(key) - 1);
                        } else {
                            treeMap.remove(key);
                        }
                    }
                }
            }

            if (!treeMap.isEmpty()) {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
            } else {
                sb.append("EMPTY").append("\n");
            }
        }
        System.out.println(sb);
    }
}

