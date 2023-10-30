package 삼성SW_EXPERT_ACADEMY.D3.암호문3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            // 총 암호문 수
            int numberOfCipher = Integer.parseInt(bf.readLine());
            // 암호문 종류
            ArrayList<String> arrayList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < numberOfCipher; i++) {
                arrayList.add(st.nextToken());
            }
            // 총 명령어 수
            int numberOfCommand = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            while (st.hasMoreTokens()) {
                String command = st.nextToken();
                if ((command).equals("I")) {
                    int index = Integer.parseInt(st.nextToken());
                    int length = Integer.parseInt(st.nextToken());
                    ArrayList<String> newList = new ArrayList<>();
                    for (int i = 0; i < length; i++) {
                        newList.add(st.nextToken());
                    }
                    arrayList.addAll(index, newList);
                } else if ((command).equals("D")) {
                    int index = Integer.parseInt(st.nextToken());
                    int length = Integer.parseInt(st.nextToken());
                    for (int i = index; i < length; i++) {
                        arrayList.remove(i);
                    }
                } else if ((command).equals("A")) {
                    int length = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < length; i++) {
                        arrayList.add(st.nextToken());
                    }
                }
            }
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(arrayList.get(i) + " ");
            }
            System.out.println();
        }
    }
}
