package 삼성SW_EXPERT_ACADEMY.D1.최대수구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 31, 30, 31, 30, 31, 31};  // 각 월의 일수

        for (int i = 0; i < testCase; i++) {
            String date = br.readLine();
            String year = date.substring(0, 4);
            String month = date.substring(4, 6);
            String day = date.substring(6);

            int monthValue = Integer.parseInt(month);
            int dayValue = Integer.parseInt(day);

            if (monthValue < 1 || monthValue > 12 || dayValue < 1 || dayValue > daysInMonth[monthValue]) {
                System.out.println("#" + (i + 1) + " -1");
            } else {
                System.out.println("#" + (i + 1) + " " + year + "/" + month + "/" + day);
            }
        }
    }
}