package 삼성SW_EXPERT_ACADEMY.D3.퍼팩트셔플;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int length = Integer.parseInt(bf.readLine());
            ArrayList<String> arrayList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int i = 0; i < length; i++) {
                arrayList.add(st.nextToken());
            }

            int mid = (length + 1) / 2;  // 홀수인 경우 첫 번째 부분이 한 장 더 많도록 설정
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < mid; i++) {
                System.out.print(arrayList.get(i) + " ");  // 첫 번째 부분의 카드 출력
                if (i + mid < length) {
                    System.out.print(arrayList.get(i + mid) + " ");  // 두 번째 부분의 카드 출력
                }
            }
            System.out.println();
        }
    }
}
