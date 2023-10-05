package 알고리즘.해쉬._4모든아나그램찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] s = bf.readLine().toCharArray();
        char[] t = bf.readLine().toCharArray();
        int answer = 0;

        int size = t.length;
        HashMap<Character, Integer> hash = new HashMap<>();
        HashMap<Character, Integer> hash2 = new HashMap<>();


        for (int i = 0; i < size; i++) {
            hash.put(s[i], hash.getOrDefault(s[i], 0) + 1);
            hash2.put(t[i], hash2.getOrDefault(t[i], 0) + 1);
        }
        if (hash.equals(hash2)) {
            answer++;
        }

        for (int i = size; i < s.length; i++) {

            hash.put(s[i], hash.getOrDefault(s[i], 0) + 1);

            hash.put(s[i - size], hash.get(s[i - size]) - 1);
            if (hash.get(s[i - size]) == 0) {
                hash.remove(s[i - size]);
            }
            if (hash.equals(hash2)) {
                answer++;
            }

        }
        System.out.println(answer);


    }

}
