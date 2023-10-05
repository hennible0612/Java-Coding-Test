package 알고리즘.정렬.삽입정렬;

import java.util.*;

class Main {
    public static int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for (j = i - 1; j >= 0; j--) { // 하나씩 추가함으로 역순으로 내려간다.
                if (arr[j] > tmp) arr[j + 1] = arr[j];
                else break;  // tmp가 더크면
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for (int x : solution(n, arr)) System.out.print(x + " ");
    }
}