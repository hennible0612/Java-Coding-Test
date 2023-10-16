package 삼성SW_EXPERT_ACADEMY.D2.Base64Decoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= t; i++) {
            String encodedString = bf.readLine();
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            String decodedString = new String(decodedBytes);

            System.out.println("#" + i + " " + decodedString);
        }
    }
}
