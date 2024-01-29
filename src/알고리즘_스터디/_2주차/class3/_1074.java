package 알고리즘_스터디._2주차.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 못풀었음
//
public class _1074 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(recursion(N, r, c));
    }

    public static int recursion(int size, int r, int c){

        if (size == 0){
            return 0;
        }

        // 격자를 4등분할 때 각 부분 격자의 크기를 계산
        // 계산이유 재귀를 통해 r,c 위치 찾는다
        // 결국에는 재귀를 통해 z 이므로 0, 1, 2, 3를 반환 받은 후 계산한다
        int half = (int) Math.pow(2, size - 1);

        // (r, c)의 위치에 따라 해당 사분면을 재귀적으로 탐색합니다.
        if (r < half && c < half) {
            // 왼쪽 상단 사분면
            return recursion(size - 1, r, c);
        } else if (r < half && c >= half) {
            // 오른쪽 상단 사분면
            return half * half + recursion(size - 1, r, c - half);
        } else if (r >= half && c < half) {
            // 왼쪽 하단 사분면
            return 2 * half * half + recursion(size - 1, r - half, c);
        } else {
            // 오른쪽 하단 사분면
            return 3 * half * half + recursion(size - 1, r - half, c - half);
        }
    }
}
