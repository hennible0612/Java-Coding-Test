package 삼성SW_EXPERT_ACADEMY.D3.암호문1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 10;
        for (int T = 1; T <= testCase; T++) {
            bf.readLine();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            ArrayList<String> arrayList = new ArrayList<>();
            while (st.hasMoreTokens()) {
                arrayList.add(st.nextToken());
            }
            bf.readLine();
            st = new StringTokenizer(bf.readLine());
            while (st.hasMoreTokens()) {
                String command = st.nextToken();
                if (command.equals("I")) {
                    int index = Integer.parseInt(st.nextToken());
                    int length = Integer.parseInt(st.nextToken());
                    ArrayList<String> newList = new ArrayList<>();
                    for (int i = 0; i < length; i++) {
                        newList.add(st.nextToken());
                    }
                    arrayList.addAll(index, newList);
                }
            }
            System.out.print("#" + T + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(arrayList.get(i) + " ");
            }
            System.out.println("");
        }
    }
}
