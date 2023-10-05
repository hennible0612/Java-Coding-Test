package 알고리즘.배열._8등수_구하기;

import java.util.*;
import java.io.*;


public class Main {

    public static Map<Integer, Integer> solution(int n, int[] array, Integer[] scores) {
        Arrays.sort(scores, Collections.reverseOrder() );
        Map<Integer, Integer> scoreToRank = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (!scoreToRank.containsKey(scores[i])) {
                scoreToRank.put(scores[i], rank);
            }
            rank++;
        }

        return scoreToRank;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String[] temp_line = bf.readLine().split(" ");
        int[] array = new int[n];
        Integer[] scores = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(temp_line[i]);
            scores[i] = Integer.parseInt(temp_line[i]);
        }
        Map<Integer, Integer> scoreToRank =solution(n, array, scores);
        for (int i = 0; i < n; i++) {
            System.out.print(scoreToRank.get(array[i]) + " ");
        }
    }
}
