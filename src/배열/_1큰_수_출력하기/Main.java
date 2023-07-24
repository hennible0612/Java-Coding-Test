package 배열._1큰_수_출력하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> solution(Integer n, int[] arr) {

        ArrayList<Integer> answer = new ArrayList<>();
        int temp = arr[0];

        for (int x : arr) {
            if (temp <= x) {
                answer.add(x);

            }
            temp = x;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        String[] numString = br.readLine().split(" ");
        int[] numArray = new int[n];
        for (int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(numString[i]);
        }
        for (int x : solution(n, numArray)) {
            System.out.println(x + " ");
        }

    }
}