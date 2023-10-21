package 삼성SW_EXPERT_ACADEMY.D3.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//public class Solution {
//    public static int answer;
//
//    public static int[] board;
//    public static void main(String[] args) throws Exception {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int test_case = 10;
//
//        for (int T = 1; T <= test_case; T++) {
//            int answer = 0;
//            Integer.parseInt(bf.readLine());
//            char[] target = bf.readLine().toCharArray();
//            char[] line = bf.readLine().toCharArray();
//            int counter = 0;
//            for (char a : line) {
//                if (a == target[counter]) {
//                    if (counter == target.length - 1) {
//                        answer++;
//                        counter = 0;
//                    } else {
//                        counter++;
//                    }
//                } else {
//                    if (counter > 0 && target[0] == a) {
//                        counter = 0;
//                        counter++;
//                    } else {
//                        counter = 0;
//                    }
//                }
//            }
//            System.out.println("#" + T + " " + answer);
//
//        }
//    }
//
//}

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int test_case = 10; // 테스트 케이스 개수
        for (int T = 1; T <= test_case; T++) {
            int answer = 0;

            // 테스트 케이스 번호는 사용하지 않으므로 읽기만 함
            bf.readLine();
            String target = bf.readLine(); // 찾을 문자열
            String line = bf.readLine(); // 검색할 문장

            int index = 0;
            while ((index = line.indexOf(target, index)) != -1) {
                answer++;
                index += target.length(); // 찾은 문자열 다음부터 다시 검색
            }
            System.out.println("#" + T + " " + answer);
        }
    }
}