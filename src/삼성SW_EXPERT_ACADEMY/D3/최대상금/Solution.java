package 삼성SW_EXPERT_ACADEMY.D3.최대상금;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static char[] number_array;
    static int switch_time;
    static int answer;

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            answer = 0;
            number_array = st.nextToken().toCharArray();
            switch_time = Integer.parseInt(st.nextToken());

            if(number_array.length < switch_time) {
                switch_time = number_array.length;
            }
            dfs(0, 0);

            System.out.println("#" + i + " " + answer);
        }
    }

    public static void dfs(int start, int level) {

        // level 도달시 탈출
        if (level == switch_time) {
            StringBuilder result = new StringBuilder();
            for (Character s : number_array)
                result.append(s);
            answer = Math.max(answer, Integer.parseInt(result.toString()));
            return;
        }
        for (int i = start; i < number_array.length; i++) {
            for (int j = i + 1; j < number_array.length; j++) {
                char temp = number_array[i];
                number_array[i] = number_array[j];
                number_array[j] = temp;

                dfs(i, level + 1);

                temp = number_array[i];
                number_array[i] = number_array[j];
                number_array[j] = temp;
            }
        }

    }
}