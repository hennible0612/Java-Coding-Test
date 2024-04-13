package 백준;

// 가장 긴 스트릭
// 최장 스트릭 내에서 더 작은 개수의 스트릭 프리지 사용
// 최장 스트릭을 시작한 날짜가 더 이른 친구?
// 스트릭 프리즈 사용한 날짜 제외하고 스트릭 달성에 실패한 날짜수 가 적은 치눅

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _29737  {
    static int n, m;
    static PriorityQueue<Human> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            Human human = new Human(bf.readLine());
            for (int j = 0; j < 7; j++) {
                String line = bf.readLine();

                for (int k = 0; k < m; k++) {
                    char curStatus = line.charAt(k);
                    if (curStatus == 'O') {
                        human.updateStreak(j);
                    } else if (curStatus == 'X') {
                        human.resetStreak();
                    } else if (curStatus == 'F') {
                        human.incrementFreeze();
                    }
                }
            }
            priorityQueue.offer(human);
        }
        int rank = 1;
        while (!priorityQueue.isEmpty()) {
            Human human = priorityQueue.poll();
            System.out.println(rank + ". " + human.humanName);
            rank++;
        }
    }


    static class Human implements Comparable<Human> {
        String humanName;
        int longestStreak = 0;
        int currentStreak = 0;
        int leastUsedStreakFreeze = 0;
        int currentFreeze = 0;
        int startDayOfCurrentStreak = 0;
        int startDayOfLongestStreak = 0;
        int streakFail = 0;

        public Human(String humanName) {
            this.humanName = humanName;
        }

        public void updateStreak(int day) {
            if (currentStreak == 0) {
                startDayOfCurrentStreak = day;
                currentFreeze = 0;
            }
            currentStreak++;
            if (currentStreak > longestStreak ||
                    (currentStreak == longestStreak && currentFreeze < leastUsedStreakFreeze) ||
                    (currentStreak == longestStreak && currentFreeze == leastUsedStreakFreeze && startDayOfCurrentStreak < startDayOfLongestStreak)) {
                longestStreak = currentStreak;
                leastUsedStreakFreeze = currentFreeze;
                startDayOfLongestStreak = startDayOfCurrentStreak;
            }
        }


        public void resetStreak() {
            if (currentStreak > 0) {
                streakFail += currentStreak;
            }
            currentStreak = 0;
        }

        public void incrementFreeze() {
            currentFreeze++;
            if (currentStreak > 0) {
                leastUsedStreakFreeze++;
            } else {
                streakFail++;
            }
        }

        @Override
        public int compareTo(Human o) {
            // 가장긴 스트릭
            if (this.longestStreak != o.longestStreak) {
                return o.longestStreak - this.longestStreak;
            } else if (this.leastUsedStreakFreeze != o.leastUsedStreakFreeze) {
            // 최장 스트릭 내에서 더 적은 개수의 스트릭 프리즈 사용
            return this.leastUsedStreakFreeze - o.leastUsedStreakFreeze;
            } else if (this.startDayOfLongestStreak != o.startDayOfLongestStreak) {
                // 최장 스트릭을 시작한 날짜가 더 이른 친구
                return this.startDayOfLongestStreak - o.startDayOfLongestStreak;
            } else if (this.streakFail != o.streakFail) {
                // 스트픽 프리즈 사용한 날짜를 제외하고 스트릭 달성에 실패한 날짜 수가 적은 친구
                return this.streakFail - o.streakFail;
            } else {
                return this.humanName.compareTo(o.humanName);
            }
        }

    }
}

