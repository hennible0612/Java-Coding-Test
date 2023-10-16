package 삼성SW_EXPERT_ACADEMY.D2.간단한소인수분해;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] array = {2, 3, 5, 7, 11};

        for (int i = 1; i <= n; i++) {
            int[] answer = new int[5];
            int number = Integer.parseInt(bf.readLine());
            int counter = 0;
            while (number != 1 && counter < 5) {

                if ((number % array[counter]) == 0) {
                    number = number / array[counter];
                    answer[counter]++;
                } else {
                    counter++;
                }
            }

            System.out.print("#" + i + " ");
            for (int num : answer) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }
}
