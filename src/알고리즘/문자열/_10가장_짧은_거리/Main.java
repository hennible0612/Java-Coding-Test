package 알고리즘.문자열._10가장_짧은_거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        String s = inputs[0];
        char t = inputs[1].charAt(0);

        int[] result = new int[s.length()];
        int dist = 1000;  // 충분히 큰 값으로 초기화

        // 왼쪽에서 오른쪽으로 스캔
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                dist = 0;
            } else {
                dist++;
            }
            result[i] = dist;
        }

        dist = 1000;  // 다시 충분히 큰 값으로 초기화

        // 오른쪽에서 왼쪽으로 스캔
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                dist = 0;
            } else {
                dist++;
            }
            result[i] = Math.min(result[i], dist);
        }

        // 결과 출력
        for (int i = 0; i < s.length(); i++) {
            System.out.print(result[i] + " ");
        }
    }

}