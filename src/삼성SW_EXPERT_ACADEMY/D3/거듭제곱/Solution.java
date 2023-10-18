package 삼성SW_EXPERT_ACADEMY.D3.거듭제곱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int i = 1; i <= T; i++) {
            bf.readLine();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int answer = recursion(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            System.out.println("#" + i + " " + answer);
        }
    }
    public static int recursion(int target, int depth) {
        if (depth == 1) {
            return target;
        }
        return target * recursion(target, depth - 1);
    }
}
