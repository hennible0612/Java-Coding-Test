package 배열._7점수계산;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] answers = new int[N];
        for(int i = 0; i < N; i++) {
            answers[i] = sc.nextInt();
        }

        int score = 0;
        int consecutive = 0;
        for(int i = 0; i < N; i++) {
            if(answers[i] == 1) {
                consecutive++;
                score += consecutive;
            } else {
                consecutive = 0;
            }
        }

        System.out.println(score);
        sc.close();
    }
}