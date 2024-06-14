package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _7596 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int counter = 1;
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = bf.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            ArrayList<String> songs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                line = bf.readLine();
                if (line != null && !line.isEmpty()) {
                    songs.add(line);
                }
            }

            Collections.sort(songs, String.CASE_INSENSITIVE_ORDER);
            sb.append(counter++).append("\n");
            for (String song : songs) {
                sb.append(song).append("\n");
            }
        }
        System.out.println(sb);
    }
}
