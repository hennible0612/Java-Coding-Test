package 삼성SW_EXPERT_ACADEMY.D2.패턴마디의길이;


import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String text = bf.readLine();
            for (int j = 1; j <= text.length(); j++) {
                String str1 = text.substring(0, j);
                String str2 = text.substring(j, j + j);
                if (str1.equals(str2)) {
                    System.out.println("#" + (i + 1 + " " + str1.length()));
                    break;
                }
            }
        }
    }
}


