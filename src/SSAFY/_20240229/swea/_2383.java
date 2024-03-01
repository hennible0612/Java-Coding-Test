package SSAFY._20240229.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _2383 {

    static int N;
    static int[][] map;
    static boolean[] allocatePeople;
    static int totalPeople;
    static ArrayList<People> peopleArrayList;
    static ArrayList<Gate> gateArrayList;
    static int answer;

    static class People {
        int x;
        int y;
        People(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Gate {
        int x;
        int y;
        int minute;

        Gate(int x, int y, int minute) {
            this.x = x;
            this.y = y;
            this.minute = minute;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TEST_CASE = Integer.parseInt(bf.readLine());
        for (int T = 1; T <= TEST_CASE; T++) {
            N = Integer.parseInt(bf.readLine());
            map = new int[N][N];
            peopleArrayList = new ArrayList<>();
            gateArrayList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1) {

                        peopleArrayList.add(new People(j, i));
                    } else if (input > 1) {
                        // 탈출구 입력
                        gateArrayList.add(new Gate(j, i, input));
                    }
                }
            }
            totalPeople = peopleArrayList.size();
            System.out.println(totalPeople);
            allocatePeople = new boolean[totalPeople];
            answer = Integer.MAX_VALUE;
            solution();
            System.out.println(answer);
        }
    }

    private static void solution() {
        subset(0);
    }


    private static void subset(int idx) {
        if (idx == totalPeople) {
            solveProblem();
            System.out.println(Arrays.toString(allocatePeople));
            return;
        }
        allocatePeople[idx] = true;
        subset(idx + 1);
        allocatePeople[idx] = false;
        subset(idx + 1);
    }

    static class PeopleInStair implements Comparable<PeopleInStair> {
        int number;
        int timePassed;

        PeopleInStair(int number, int timePassed) {
            this.number = number;
            this.timePassed = timePassed;
        }

        @Override
        public int compareTo(PeopleInStair o) {
            return this.timePassed - o.timePassed;
        }
    }
    private static void solveProblem() {
        int[] timeArray = new int[totalPeople];
        People people;
        Gate gate;
        for (int i = 0; i < totalPeople; i++) {
            people = peopleArrayList.get(i);
            if (allocatePeople[i]) {
                gate = gateArrayList.get(0); //true
            } else {
                gate = gateArrayList.get(1);
            }
            timeArray[i] = Math.abs(people.x - gate.x) + Math.abs(people.y - gate.y);
        }
        PriorityQueue<PeopleInStair> gateArray1 = new PriorityQueue<>(); //true
        PriorityQueue<PeopleInStair> gateArray2 = new PriorityQueue<>();

        int counter = 0;
        int minute = 0;
        while (counter != totalPeople) {
            if (!gateArray1.isEmpty()) {
                for (int i = 0; i < gateArray1.size(); i++) {
                    PeopleInStair peopleInStair = gateArray1.poll();
                    peopleInStair.timePassed -= 1;
                    if (peopleInStair.timePassed == 0) {
                        counter++;
                    } else {
                        gateArray1.add(peopleInStair);
                    }
                }

            }
            if (!gateArray2.isEmpty()) {
                for (int i = 0; i < gateArray2.size(); i++) {
                    PeopleInStair peopleInStair = gateArray2.poll();
                    peopleInStair.timePassed -= 1;
                    if (peopleInStair.timePassed == 0) {
                        counter++;
                    } else {
                        gateArray2.add(peopleInStair);
                    }
                }
            }

            for (int i = 0; i < totalPeople; i++) {
                timeArray[i] -= 1;
                if (timeArray[i] == 0) {
                    People people1 = peopleArrayList.get(i);
                    if (allocatePeople[i]) {
                        if (gateArray1.size() < 3) {
                            gateArray1.add(new PeopleInStair(i, 3));

                        }
                    }else{
                        if (gateArray2.size() < 3) {
                            gateArray2.add(new PeopleInStair(i, 3));
                        }
                    }
                }
            }
            minute++;
        }
        answer = Math.min(answer, minute);
    }
}
