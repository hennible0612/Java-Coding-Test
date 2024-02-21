package SSAFY._20240221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1759 {


    static int L, C;
    static char[] characters;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        characters = new char[C];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < C; i++) {
            characters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(characters);

        combination(0, 0, 0, 0, new StringBuilder());
        System.out.println(sb);

    }


    static void combination(int index, int start, int vowelCount, int constantCount, StringBuilder current) {
        // 탈출
        if (index == L) {
            if (vowelCount >= 1 && constantCount >= 2) {
                sb.append(current.toString()).append('\n');
            }
            return;
        }
        // 콤비네이션
        for (int i = start; i < C; i++) {
            current.append(characters[i]);
            if (isVowel(characters[i])) {
                combination(index + 1, i + 1, vowelCount + 1, constantCount, current);
            } else {
                combination(index + 1, i + 1, vowelCount, constantCount + 1, current);

            }
            current.deleteCharAt(current.length() - 1);
        }
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';

    }
}
