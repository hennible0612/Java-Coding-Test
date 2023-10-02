package 그리디._4최대수입스케쥴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Lecture implements Comparable<Lecture> {
        int money;
        int day;

        public Lecture(int money, int day) {
            this.money = money;
            this.day = day;
        }


        // 큰날짜 우선으로 정렬
        public int compareTo(Lecture lecture) {
            return lecture.day - this.day;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        // 값들을 넣을 우선순위큐
        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        // 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            pq.add(new Lecture(money, day));
        }

        // 특정 날짜의 값들을 담을 arrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        int answer = 0;
        for (int i = n; i > 0; i--) {
            // 최대 day, n부터 루프가 내려가면서
            // 해당 날짜의 값을 arrayList에 ㅊ추가
            while (!pq.isEmpty() && pq.peek().day == i) {
                arrayList.add(pq.poll().money);
            }

            if (!arrayList.isEmpty()) {
                // arrayList에 가장 큰값 가져온다
                int max = Collections.max(arrayList);
                answer += max; // 더한다
                // arrayList에 가장 큰값 뺸다
                arrayList.remove(Integer.valueOf(max));
            }
        }
        System.out.println(answer);
    }
}
