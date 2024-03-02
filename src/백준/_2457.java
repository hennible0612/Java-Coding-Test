package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2457 {
    static class Flower implements Comparable<Flower> {
        int start, end;

        Flower(int start, int end) {

            this.start = start;
            this.end = end;
        }

        // start가 빠른순 그리고 start가 같다면 end가 높은순
        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start) {
                return o.end - this.end; //end 기준 내림차순
            }
            return this.start - o.start; // start기준 오름차순
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Flower[] flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            // 하나로 합치는 이유 -> 비교를 더쉽게 하기 위해
            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;
            flowers[i] = new Flower(start, end);
        }

        Arrays.sort(flowers);

        int count = 0; // 선택된 꽃의 개수
        int lastEnd = 301; // 마지막으로 선택된 꽃이 지는 날, 초기값은 3월 1일
        int maxEnd = 301; // 현재 고려 중인 꽃들 중에서 가장 늦게 지는 날
        int index = 0; // 현재 탐색 중인 꽃의 인덱스
        boolean possible = false; // 11월 30일까지 꽃을 계속 볼 수 있는지 여부

        while (lastEnd <= 1130) { // 1130 까지 갔다면 만족한다
            possible = false;
            for (int i = index; i < N; i++) {
                // 현재 꽃의 시작 날짜가 마지막으로 선택된 꽃이 지는 날보다 늦다면 탐색 종료
                // !! 한가지 이상 피어 있어야하는데 불가 하기 때문
                if (flowers[i].start > lastEnd) {
                    break;
                }
                // 현재 고려 중인 꽃이 지금까지 고려한 꽃들보다 늦게 진다면, 선택
                if (flowers[i].end > maxEnd) {
                    maxEnd = flowers[i].end; // 현재 꽃으로 날짜 초기화
                    index = i;
                    possible = true;
                }
            }
            if (!possible) { // 더 이상 선택할 수 있는 꽃이 없다면 반복 종료
                break;
            }

            // 마지막으로 선택된 꽃을 업데이트하고, 선택된 꽃의 개수를 증가, 다음꽅을 찾아야하기 때문
            lastEnd = maxEnd;
            count++;
            index++; // 다음 꽃부터 탐색을 계속
        }
        // 최종적으로 11월 30일까지 꽃을 볼 수 없다면 0 출력, 가능하다면 선택된 꽃의 개수 출력
        if (lastEnd <= 1130) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }
}



