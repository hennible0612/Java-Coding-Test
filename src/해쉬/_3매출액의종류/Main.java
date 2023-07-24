package 해쉬._3매출액의종류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bf.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);
        String[] array = bf.readLine().split(" ");

        HashMap<String, Integer> hash = new HashMap<>();


        for (int i = 0; i < k; i++) {
            hash.put(array[i], hash.getOrDefault(array[i], 0) + 1);
        }

        System.out.print(hash.size() + " ");

        for (int i = k; i < n; i++) {
            // 값추가
            hash.put(array[i], hash.getOrDefault(array[i], 0) + 1);
            // 맨왼쪽 값 1하락
            hash.put(array[i - k], hash.get(array[i - k]) - 1);
            if (hash.get(array[i - k]) == 0) {
                hash.remove(array[i - k]);
            }
            System.out.print(hash.size() + " ");
        }
    }
}
