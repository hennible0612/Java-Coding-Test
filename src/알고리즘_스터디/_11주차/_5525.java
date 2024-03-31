package 알고리즘_스터디._11주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5525 {
    static int N ;
    static int M;
    static char[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] IOI = {'I', 'O', 'I'};

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        S = bf.readLine().toCharArray();
        int counter = 0;
        int answer = 0;

        for (int i = 1; i < M - 1; i++) {
            if (S[i - 1] == 'I' && S[i] == 'O' && S[i + 1] == 'I') {
                counter++;
                if (counter == N) {
                    answer++;
                    counter--;
                }
                i += 1;

            }else {
                counter = 0;
            }

        }
        System.out.println(answer);
    }
}
