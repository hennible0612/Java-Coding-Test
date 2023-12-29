package 삼성SW_EXPERT_ACADEMY.D3.의석이의세로로말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[] gyuCards, inCards, selected;
    static boolean[] isSelected;
    static int win, lose;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[][] graph = new String[5][15];
            for (int i = 0; i < 5; i++) {
                String temp = bf.readLine();
                for (int j = 0; j < temp.length(); j++) {

                    graph[i][j] = graph[i][j] = Character.toString(temp.charAt(j));
                }
            }
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    if(graph[j][i] != null) {
                        System.out.print(graph[j][i]);
                    }

                }
            }
            System.out.println();
        }
    }
}