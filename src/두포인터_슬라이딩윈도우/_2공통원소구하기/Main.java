package 두포인터_슬라이딩윈도우._2공통원소구하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Main {
    public static ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);

        int p1 = 0;
        int p2 = 0;
        // 각각의 크기 까지
        while (p1 < n && p2 < m) {
            // 2개다 똑같으면 카운터 증가 및 answer에 추가
            if (a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            } else if (a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(scn.nextInt());
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList2.add(scn.nextInt());
        }
        long startTime = System.currentTimeMillis();

        arrayList.retainAll(arrayList2);
        Collections.sort(arrayList);
        for (int x : arrayList) {
            System.out.println(x);
        }

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        System.out.println("Execution time in milliseconds: " + executionTime);
        System.out.println(arrayList);
    }
}
