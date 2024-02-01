package A형.백준;

package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _12891 {
    static int S, P, ans;
    static char[] dna;

    static int minA, minC, minG, minT;

    // 빈도수 배열 A ~ T ( 이중 4개 문자 위치 외 배열은 dummy )
    static int[] cnt = new int[20];

    public static void main(String[] args) throws IOException {
        // 입력
        // S 문자열의 길이
        // P 부분문자열의 길이
        // 두번째 줄에는 민호가 임의로 만든 DNS 문자열이 주어진다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        dna = bf.readLine().toCharArray();

        st = new StringTokenizer(bf.readLine());
        minA = Integer.parseInt(st.nextToken());
        minC = Integer.parseInt(st.nextToken());
        minG = Integer.parseInt(st.nextToken());
        minT = Integer.parseInt(st.nextToken());

        solve();
        System.out.println(ans);
    }

    // 문자열을 쭉 처리하면서 유현한지 검증
    static void solve() {
        // 맨 앞 P 개 처리 <= P개중 ACGT 에 해당하는 문자이면 각각 해당하는 cntA, cntG.. 증가
        for (int i = 0; i < P; i++) {
            cnt[dna[i] - 'A']++;
        }
        checker();
        // P 이후 한개씩 처리
        // 이전 P개 중 맨 앞 문자는 제거, 새문자가 맨 뒤에 추가
        for (int i = P; i < S; i++) {
            cnt[dna[i - P] - 'A']--;
            cnt[dna[i] - 'A']++;
            checker();
        }
    }
    // 현재 각 문자의 cnt가 최소 조건을 만족하는지 확인 ans 증가
    static void checker() {
        if (cnt[0] >= minA && cnt[2] >= minC && cnt[6] >= minG && cnt[19] >= minT) {
            ans++;
        }
    }
}
