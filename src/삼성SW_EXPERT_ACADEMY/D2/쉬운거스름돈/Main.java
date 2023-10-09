package 삼성SW_EXPERT_ACADEMY.D2.쉬운거스름돈;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] money_array = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for (int i = 0; i < n; i++) {
            int money = Integer.parseInt(bf.readLine());
            int[] answer_array = new int[money_array.length];
            for (int j = 0; j < money_array.length; j++) {

                answer_array[j] = money / money_array[j];
                money = money % money_array[j];
            }
            System.out.println("#" + (i + 1));
            for (int answer : answer_array) {
                System.out.print(answer + " ");

            }
            System.out.println("");

        }
    }
}