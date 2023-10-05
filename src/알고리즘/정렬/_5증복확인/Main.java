package 알고리즘.정렬._5증복확인;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        String answer = "U";
        for (int x : array) {
            if (hashMap.containsKey(x)) {
                answer = "D";
                break;
            }
            hashMap.put(x, x);
        }
        System.out.println(answer);
    }
}
