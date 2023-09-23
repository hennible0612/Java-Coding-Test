package 재귀_트리_그래프.재귀함수_이진수출력;

import java.util.*;
// 클래스 정의
public class Main {
    // 재귀 함수 정의: 입력된 10진수를 2진수로 변환하여 문자열로 반환
    public static String recursion(int a) {
        if (a == 0) {
            // 입력값이 0일 때는 더 이상 나눌 수 없으므로 빈 문자열을 반환
            return "";
        } else {
            // 입력값이 0이 아닐 때는 a를 2로 나눈 몫에 대해 재귀 호출을 하고,
            // a를 2로 나눈 나머지를 문자열로 변환하여 앞의 결과에 추가
            return recursion(a / 2) + Integer.toString(a % 2);

        }
    }

    // 메인 함수: 프로그램 실행시 가장 먼저 호출되는 함수
    public static void main(String[] args) {
        // 콘솔 입력을 받기 위한 Scanner 객체 생성
        Scanner scn = new Scanner(System.in);
        // 콘솔로부터 정수 a를 입력받음
        int a = scn.nextInt();
        // 재귀 함수를 호출하여 a를 2진수 문자열로 변환
        String result = recursion(a);
        // 만약 변환 결과가 빈 문자열일 경우, a가 0이었음을 의미하므로 결과를 "0"으로 설정
        if (result.length() == 0) {
            result = "0";
        }
        // 2진수 변환 결과 출력
        System.out.println(result);
    }
}
