package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class _8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int score = 1;
            int answer = 0;
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'O') {
                    answer += score;
                    score += 1;
                } else {
                    score = 1;
                }
            }
            System.out.println(answer);
        }
    }
}
