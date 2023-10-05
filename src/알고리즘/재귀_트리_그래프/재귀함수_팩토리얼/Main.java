package 알고리즘.재귀_트리_그래프.재귀함수_팩토리얼;

import java.util.*;
public class Main {
    public static int recursion(int a) {
        if (a == 0) {
            return 1;
        } else {

            return recursion(a - 1) * a;

        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int result = recursion(a);

        System.out.println(result);
    }
}