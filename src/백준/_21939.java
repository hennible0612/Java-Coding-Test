package 백준;



// 문제 번호, 난이도
// 새로운 기능
// recommend x : x가 1인 경우 추천 문제 리스트에서 가장 어려운 문제의 번호를 출력한다.
// 만약 가장 어려운 문제가 여러개라면 문제 번호가 큰것으로 출력
// x가 -1인 경우 추천 문제 리스트에서 가장 쉬운 문제의번호를 출력
// 만약 가장 쉬운문제가 여러개라면 문제 버놓가 작은 것으로 출력
// add P L : 추천 문제 리스트에 난이도 L인 문제 번호 P를 추가
// 이전에 추천 문제 리스트에 있던 문제 번호가다른 난이도로 다시 들어 올 수 있다.
// solved P : 추천 문제 리스트에서 문제 번호 P를 제거

// 첫번째 줄에 추천 문제 리스트에 있는 문제 N이 주어진다.
// 두 번째 줄부터 N + 1줄까지 문제 번호 P와 난이도 L가 공백으로 구분되어 주어진다.
// N + 2줄을 입력되 ㄹ명령문의 개수 M이 주어진다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class _21939 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, TreeSet<Integer>> problemMap = new TreeMap<>();

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            // 있으면 새값은 추가하지 않는다.
            problemMap.putIfAbsent(L, new TreeSet<>());
            problemMap.get(L).add(P);

        }

        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            String command = st.nextToken();
            if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                problemMap.putIfAbsent(L, new TreeSet<>());
                problemMap.get(L).add(P);

            }

            if (command.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                for (Map.Entry<Integer, TreeSet<Integer>> entry : problemMap.entrySet()) {
                    TreeSet<Integer> set = entry.getValue();
                    set.remove(P);

                    // 난이도 제거시 Map 에서 완전 제거
                    if (set.isEmpty()) {
                        problemMap.remove(entry.getKey());
                        // break 하는 이유 컬렉션 구조가 변경이 됨 -> 안전하게 반복 힘들다.

                        break;
                    }
                }
            }

            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    if (!problemMap.isEmpty()) {
                        int lastKey = problemMap.lastKey();
                        TreeSet<Integer> lastSet = problemMap.get(lastKey);
                        System.out.println(lastSet.last());
                    }

                }
                if (x == -1) {
                    if (!problemMap.isEmpty()) {
                        int firstKey = problemMap.firstKey();
                        TreeSet<Integer> firstSet = problemMap.get(firstKey);
                        System.out.println(firstSet.first());
                    }
                }
            }
        }

    }

}

