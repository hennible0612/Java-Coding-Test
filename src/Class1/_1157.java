package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        char result = '?';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) > max) {
                max = map.get(ch);
                result = ch;
            } else if (map.get(ch) == max) {
                result = '?';
            }
        }

        System.out.println(result);

    }

}
