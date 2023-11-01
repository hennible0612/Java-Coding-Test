package 삼성SW_EXPERT_ACADEMY.D3.한빈이와SpotMart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int answer;
    static int counter;

    static int maxWeightOfSnack;
    static int[] snacks;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());

        for (int TEST_CASE = 1; TEST_CASE <= test_case; TEST_CASE++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int numberOfSnack = Integer.parseInt(st.nextToken());
            maxWeightOfSnack = Integer.parseInt(st.nextToken());
            snacks = new int[numberOfSnack];
            st = new StringTokenizer(bf.readLine());
            answer = 0;
            counter = 0;
            for (int i = 0; i < numberOfSnack; i++) {
                snacks[i] = Integer.parseInt(st.nextToken());
            }
            recursion(0, 0, 0);
        }

    }

    public static void recursion(int idx, int weight, int counter) {

        if (counter < 2 && weight > maxWeightOfSnack) {
            return;
        } else {

            answer = Math.max(answer, weight);
        }

        recursion(idx + 1, weight, counter);
        weight += snacks[idx];
        recursion(idx + 1, weight, counter += 1);




    }
}
