package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = bf.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        ArrayList<Word> words = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            words.add(new Word(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(words);

        for (Word word : words) {
            sb.append(word.word).append("\n");

        }
        System.out.println(sb);
    }

    static class Word implements Comparable<Word> {
        String word;
        int count;
        int length;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
            this.length = word.length();
        }

        @Override
        public int compareTo(Word o) {
            if (this.count == o.count) {
                if (this.length == o.length) {
                    return this.word.compareTo(o.word);
                }
                return  o.length - this.length;
            }
            return o.count - this.count;
        }
    }
}
