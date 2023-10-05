package 알고리즘.배열._9격자판_최대합;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    public static int solution(int[][] graph) {
//        ArrayList<Integer> answer = new ArrayList<>();
//        int x = 0;
//        int y = 0;
//        int middle = 0;
//        for (int i = 0; i < graph.length; i++) {
//            x = 0;
//            y = 0;
//            for (int j = 0; j < graph.length; j++) {
//                x += graph[i][j];
//                y += graph[j][i];
//                if (i == j) {
//                    middle += graph[i][j];
//                }
//            }
//            answer.add(x);
//            answer.add(y);
//        }
//        answer.add(middle);
//
//        int max = Collections.max(answer);;
//
//        return max;
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bf.readLine()); // 첫 줄에서 배열의 크기를 읽습니다.
//        int[][] array = new int[n][n]; // n x n 크기의 2차원 배열을 생성합니다.
//
//        for (int i = 0; i < n; i++) { // 각 줄을 읽어서
//            String[] temp_line = bf.readLine().split(" "); // 공백을 기준으로 분할합니다.
//            for (int j = 0; j < n; j++) { // 각 값을
//                array[i][j] = Integer.parseInt(temp_line[j]); // 정수로 변환하여 배열에 저장합니다.
//            }
//        }
//        System.out.println(solution(array));
//
//    }
//}
import java.util.Scanner;

public class Main {
    public static int solution(int[][] arrays) {
        int answer = Integer.MIN_VALUE;

        int diagonal1 = 0;
        int diagonal2 = 0;
        for (int i = 0; i < arrays.length; i++) {
            int tmpX = 0;
            int tmpY = 0;
            for (int j = 0; j < arrays.length; j++) {
                tmpX += arrays[i][j];
                tmpY += arrays[j][i];

                if(i == j) diagonal1 += arrays[i][j];
                if(Math.abs(i-j) == arrays.length -1) diagonal2 += arrays[i][j];
            }
            int tmp = Math.max(tmpX, tmpY);
            answer = Math.max(tmp, answer);
        }
        answer = Math.max(Math.max(diagonal1,diagonal2), answer);


        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] arrays = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrays[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(arrays));

        return;
    }
}