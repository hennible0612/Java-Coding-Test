package 알고리즘_스터디._2주차.class2;

import java.util.Scanner;

public class _1259 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int num = scanner.nextInt();
            if (num == 0){
                break;
            }

            if (isPalindrome(num)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean isPalindrome(int number) {
        String numStr = Integer.toString(number);
        int length = numStr.length();

        for (int i = 0; i < length / 2; i++) {
            if (numStr.charAt(i) != numStr.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}