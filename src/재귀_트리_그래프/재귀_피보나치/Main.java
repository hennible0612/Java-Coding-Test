package 재귀_트리_그래프.재귀_피보나치;

//import java.util.*;
//public class Main {
//    public static int recursion(int n) {
//
//        if (n == 1 || n == 2) {
//            return 1;
//        } else {
//            return recursion(n - 2) + recursion(n - 1);
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int a = scn.nextInt();
//        int result = recursion(a);
//
//        System.out.println(result);
//    }
//}


import java.util.*;
public class Main {
    private static int[] memo;
    public static int recursion(int n) {

        if (n == 1 || n == 2) {
            return 1;
        } else if (memo[n] != 0) {
            return memo[n];
        } else {
            memo[n] = recursion(n - 2) + recursion(n - 1);
            return memo[n];
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();

        memo = new int[a + 1];
        int result = recursion(a);

        System.out.println(result);
    }
}