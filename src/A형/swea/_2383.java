package A형.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Person {
    int r, c;
    int[] time = new int[2];

    Person(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Stair {
    int r, c, length;

    Stair(int r, int c, int length) {
        this.r = r;
        this.c = c;
        this.length = length;
    }
}

public class _2383 {
    static int N, minTime;
    static ArrayList<Person> persons;
    static Stair[] stairs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            persons = new ArrayList<>();
            stairs = new Stair[2];

            int stairIndex = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value == 1) {
                        persons.add(new Person(i, j));
                    } else if (value > 1) {
                        stairs[stairIndex++] = new Stair(i, j, value);
                    }
                }
            }

            // Calculate distance from each person to each stair
            for (Person person : persons) {
                for (int i = 0; i < 2; i++) {
                    person.time[i] = Math.abs(person.r - stairs[i].r) + Math.abs(person.c - stairs[i].c) + 1; // +1 for entering the stair
                }
            }

            minTime = Integer.MAX_VALUE;
            simulate(0, new int[persons.size()]);

            System.out.println("#" + tc + " " + minTime);
        }
    }

    // Simulate all possible combinations of stair selection for each person
    static void simulate(int index, int[] selectedStairs) {
        if (index == persons.size()) {
            minTime = Math.min(minTime, calculateTime(selectedStairs));
            return;
        }

        for (int i = 0; i < 2; i++) {
            selectedStairs[index] = i;
            simulate(index + 1, selectedStairs);
        }
    }

    // Calculate time to complete moving for a given combination of stair selection
    static int calculateTime(int[] selectedStairs) {
        int[] endTime = new int[2];
        int[] stairQueue = new int[2];

        for (int i = 0; i < persons.size(); i++) {
            int stairNum = selectedStairs[i];
            int arrivalTime = persons.get(i).time[stairNum];
            int waitTime = Math.max(0, stairQueue[stairNum] - arrivalTime);
            int departureTime = arrivalTime + waitTime + stairs[stairNum].length;

            endTime[stairNum] = Math.max(endTime[stairNum], departureTime);
            stairQueue[stairNum] = departureTime;
        }

        return Math.max(endTime[0], endTime[1]);
    }
}
