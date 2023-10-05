package 알고리즘.해쉬._1학급회장;

import java.io.BufferedReader;
import java.util.HashMap;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int n = Integer.parseInt(bf.readLine());
        String line = bf.readLine();
        char[] array = line.toCharArray();
        for (char x : array) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }

        System.out.println(hashMap.containsKey('A'));
        System.out.println(hashMap.remove('A'));
        System.out.println(hashMap.size());

        int max = 0;
        char answer =  ' ';
        for (char x : hashMap.keySet()) {

            if (hashMap.get(x) > max) {
                max = hashMap.get(x);
                answer = x;
            }
        }
        System.out.println(answer);

    }
}
