package 삼성SW_EXPERT_ACADEMY.D3.비밀번호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int length = Integer.parseInt(st.nextToken());
            String cipher = st.nextToken();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cipher);

            for (int i = 0; i < stringBuilder.length() - 1; i++) {
                if (i < 0) {
                    i = 0;
                }
                char temp = stringBuilder.charAt(i);
                if (temp == stringBuilder.charAt(i + 1)) {
                    stringBuilder.deleteCharAt(i + 1);
                    stringBuilder.deleteCharAt(i);
                    i -= 2;
                }
            }
            System.out.println("#" + test_case + " " + stringBuilder.toString());
        }
    }
}
