import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "AABBAABAABBAA";  // 예시 문자열
        int K = 2;                  // 바꿀 수 있는 B의 개수

        List<Integer> bIndices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                bIndices.add(i);
            }
        }

        if (bIndices.size() <= K) {
            System.out.println(s.length());
            return;
        }

        int maxLen = 0;
        bIndices.add(0, -1); // 시작을 위한 -1 추가
        bIndices.add(s.length()); // 끝을 위한 문자열 길이 추가

        for (int i = 1; i + K < bIndices.size(); i++) {
            int len = bIndices.get(i + K) - bIndices.get(i - 1) - K;
            maxLen = Math.max(maxLen, len);
        }

        System.out.println(maxLen);
    }
}
