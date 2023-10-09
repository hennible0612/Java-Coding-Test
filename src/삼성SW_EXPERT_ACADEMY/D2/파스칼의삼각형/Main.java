package 삼성SW_EXPERT_ACADEMY.D2.파스칼의삼각형;


import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(bf.readLine());
            System.out.println("#" + (i + 1));
            System.out.println("1");

            for (int j = 1; j < m; j++) {
                System.out.print("1 ");
                for (int l = 1; l < j; l++) {
                    System.out.print(j + " ");
                }
                System.out.println("1 ");
            }
        }
    }
}


