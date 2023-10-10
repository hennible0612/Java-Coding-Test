package 삼성SW_EXPERT_ACADEMY.D2.날짜계산기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        int[] calender = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start_month = Integer.parseInt(st.nextToken());
            int start_day = Integer.parseInt(st.nextToken());
            int end_month = Integer.parseInt(st.nextToken());
            int end_day = Integer.parseInt(st.nextToken());
            int answer = 0;
            answer += calender[start_month] - start_day + 1;
            answer -= calender[end_month] - end_day;

            for (int j = start_month + 1; j < end_month; j++) {
                answer += calender[j];
            }

            System.out.println("#" + i + " " + (answer));

        }
    }

}
