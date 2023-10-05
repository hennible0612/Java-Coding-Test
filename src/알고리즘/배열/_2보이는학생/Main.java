package 알고리즘.배열._2보이는학생;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static Integer solution(Integer n, int[] arr) {

        int answer = 1;
        int start = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > start) {
                start = arr[i];
                answer++;
            }
        }
        return answer;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        String[] numString = bf.readLine().split(" ");
        int[] numArray = new int[n];

        for (int i = 0; i < numString.length; i++) {
            numArray[i] = Integer.parseInt(numString[i]);
        }
        System.out.println(solution(n, numArray));
    }
}
