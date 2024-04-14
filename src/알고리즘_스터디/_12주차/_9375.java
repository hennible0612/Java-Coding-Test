package 알고리즘_스터디._12주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(bf.readLine());
            HashMap<String, Integer> clothesMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                st.nextToken();
                String type = st.nextToken();


                clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int val : clothesMap.values()) {
                result *= (val + 1); // 선택 수
            }
            System.out.println(result - 1);
        }
    }
}