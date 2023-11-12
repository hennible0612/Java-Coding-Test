package 삼성SW_EXPERT_ACADEMY.D3.GNS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            bf.readLine();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            HashMap<String, Integer> hashMap = new LinkedHashMap<>();
            hashMap.put("ZRO",0);
            hashMap.put("ONE", 0);
            hashMap.put("TWO", 0);
            hashMap.put("THR", 0);
            hashMap.put("FOR", 0);
            hashMap.put("FIV", 0);
            hashMap.put("SIX",0);
            hashMap.put("SVN", 0);
            hashMap.put("EGT", 0);
            hashMap.put("NIN", 0);

            while (st.hasMoreTokens()) {
                String temp = st.nextToken();
                hashMap.put(temp, hashMap.get(temp) + 1);
            }
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                System.out.print("#" + test_case + " ");
                for (int i = 0; i < entry.getValue(); i++) {
                    System.out.print(entry.getKey() + " ");
                }
                System.out.println();
            }
        }
    }
}
