package 삼성SW_EXPERT_ACADEMY.D3.회문2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws Exception {
        int TEST_CASE = 10;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int T = 1; T <= TEST_CASE; T++) {
            bf.readLine();
            char[][] graph = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String line = bf.readLine();
                for (int j = 0; j < 100; j++) {
                    graph[i][j] = line.charAt(j);
                }
            }

            int maxLength = 0;

            for (int i = 0; i < 100; i++) {
                for (int j = 100; j > 0; j--) {
                    for (int k = 0; k <= 100 - j; k++) {
                        // check rows
                        String rowStr = new String(graph[i], k, j);
                        if (isPalindrome(rowStr)) {
                            maxLength = Math.max(maxLength, j);
                        }

                        // check columns
                        StringBuilder colStr = new StringBuilder();
                        for (int l = 0; l < j; l++) {
                            colStr.append(graph[k + l][i]);
                        }
                        if (isPalindrome(colStr.toString())) {
                            maxLength = Math.max(maxLength, j);
                        }
                    }
                }
            }
            System.out.println("#" + T + " " + maxLength);

        }
    }

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
