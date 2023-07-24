package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String word = bf.readLine();

        List<String> str_array = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            str_array.add(word.substring(i));
        }
        Collections.sort(str_array);

        for (String answer : str_array) {
            System.out.println(answer);
        }

    }
}
