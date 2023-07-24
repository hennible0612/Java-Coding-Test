package 해쉬._2아나그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        String line1 = bf.readLine();
        String line2 = bf.readLine();
        char[] array1 = line1.toCharArray();
        char[] array2 = line2.toCharArray();
        for (int i = 0; i < array2.length; i++) {
            hashMap1.put(array1[i], hashMap1.getOrDefault(array1[i], 0) + 1);
            hashMap2.put(array2[i], hashMap2.getOrDefault(array2[i], 0) + 1);
        }

        String answer = "YES";
        for (char x : hashMap1.keySet()) {
            if (hashMap2.containsKey(x)) {
                if (!Objects.equals(hashMap2.get(x), hashMap1.get(x))) {
                    answer = "NO";
                }
            } else {
                answer = "NO";
            }

        }
        System.out.println(answer);

        // 두번째 방법
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : line1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);

        }
        for (char x : line2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                answer = "NO";
            }
            map.put(x, map.get(x) + 1);
        }
        System.out.println(answer);


    }
}
