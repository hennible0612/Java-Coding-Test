package 삼성SW_EXPERT_ACADEMY.D2.압축풀기;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(bf.readLine());
            ArrayList<String> alphaArrayList = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String cTemp = st.nextToken();
                int iTemp = Integer.parseInt(st.nextToken());
                for (int p = 0; p < iTemp; p++) {
                    alphaArrayList.add(cTemp);
                }
            }
            System.out.println("#" + i);
            int counter = 0;
            for (int j = 0; j < alphaArrayList.size(); j++) {
                System.out.print(alphaArrayList.get(j));
                counter++;
                if (counter == 10) {
                    System.out.println("");
                    counter = 0;
                }
            }
            System.out.println("");
        }
    }
}
