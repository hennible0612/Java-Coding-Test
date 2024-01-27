package A형.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] justArray = new int[n];
        int[] answerArray = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            justArray[i] = Integer.parseInt(st.nextToken());
        }



        int answer = 1;
        answerArray[0] = justArray[0];
        for (int i = 0; i < n; i++) {

            int targetPosition = Arrays.binarySearch(answerArray, 0, answer, justArray[i]);

            if (targetPosition < 0) {
                targetPosition = -(targetPosition + 1); //삽입 지점
            }

            answerArray[targetPosition] = justArray[i];

            if (targetPosition == answer) {
                answer++;
            }

        }
        System.out.println(answer);

    }
}
