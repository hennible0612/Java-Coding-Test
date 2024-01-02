package 삼성SW_EXPERT_ACADEMY.D3.규영이와인영이의카드게임;


import java.io.*;
import java.util.*;

public class Solution {
    static int[] gyuCards, inCards, selected;
    static boolean[] isSelected;
    static int win, lose;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            gyuCards = new int[9];
            inCards = new int[9];
            // 선택된 카드들
            selected = new int[9];
            // 선택 확인
            isSelected = new boolean[9];
            win = 0;
            lose = 0;

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < 9; i++) {
                // cards 저장
                gyuCards[i] = Integer.parseInt(st.nextToken());
            }

            int index = 0;
            for (int i = 1; i <= 18; i++) {
                if (!contains(gyuCards, i)) {
                    // 없는 카드목록은 inCards에 저장
                    inCards[index++] = i;
                }
            }

            permute(0);
            System.out.println("#" + test_case + " " + win + " " + lose);
        }
    }

    private static void permute(int count) {
        // 재귀 탈출
        if (count == 9) {
            int gyuScore = 0, inScore = 0;
            for (int i = 0; i < 9; i++) {
                if (gyuCards[i] > selected[i]) {
                    gyuScore += gyuCards[i] + selected[i];
                } else if (gyuCards[i] < selected[i]) {
                    inScore += gyuCards[i] + selected[i];
                }
            }
            if (gyuScore > inScore) win++;
            else if (gyuScore < inScore) lose++;
            return;
        }

        // 선택된게 아니라면
        // dfs로 여러 조합 탄생
        for (int i = 0; i < 9; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                // 선택된 카드들에 추가
                selected[count] = inCards[i];
                for (int something : selected) {
                    System.out.print(something + " ");
                }
                permute(count + 1); // 다음 카드 선택을 위한 재귀 호출
                isSelected[i] = false; // 백트래킹
            }
        }
    }

    private static boolean contains(int[] array, int key) {
        for (int i : array) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }
}
