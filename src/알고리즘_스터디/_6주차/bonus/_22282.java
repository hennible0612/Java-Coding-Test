package 알고리즘_스터디._6주차.bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class _22282 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); 
        Integer[] citations = new Integer[n];

        for (int i = 0; i < n; i++) {
            citations[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(citations, Collections.reverseOrder());

        int hIndex = 0;

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }

        System.out.println(hIndex);
    }

}
