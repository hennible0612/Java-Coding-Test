//package SSAFY._20240229.baekjoon;
//
//// N이 주어지면 (2 <= N <= 16) <= 순열 <= 단순한 순열로 풀면 시간 초과
//// BitMasking + Memoization
//
//// #1 1-2-3-4-5 도시
////    1-3-2-5-4-1 처럼 순환 구조이므로 왼쪽의 방문의 결과 (비용)는 3-2-5-4-1-3 ... 모두같다.
//// 결과적으로 1번 도시에서 출발하는 경우만 따지면 된다. ! 수 감소
//
//// #2 현재까지 방문한 도시 -> BitMaking
////    0001 => 1번 도시 방문
////    1010 => 2번 4번 도시 방문
////    정수 1개로 최대 N 개 도시의 방문 여부를 표현 문제 X
//
//// #3 순열의 경우의 수를 줄이기 위해 memoization 활용 ???
////    memoi[i][j] <= 현재 i번째 도시를 방문, 거쳐온 도시가 BitMasking(j) 로 표현
////                <=  value ?? 남은 도시를 방문하는 최소 비용
//// 1,2,3,4,5,6,7 도시가 있을 때
//// memoi[3][1100101] => 1,3,6,7 도시를 방문, 현재는 3 일때, 남은 도시2, 4, 5를 방문하는 최소 비용
//// memoi[3][1100101] => 100 이라면, 3전에 방문한 1,6,7의 방문순서와 상관없이 동일
//
//// memoi[3][1100101]의 갑슨 남은, 2,4,5를 다음로 각각방문하는 과정으 ㅣ최소비용으로 갱신
//// (2) + (2 | 4|5|) + memoi[2][1100111], memoi[2][1100101], memo[5][1110101])
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class _10971 {
//    static int N, allMask, INF = 9_999_999;
//    static int[][] W;
//    static int[][] memoi;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(bf.readLine());
//        allMask = (1 << N) - 1; // 11111 <= 1 << 5 : 100000 => -1 해서 11111
//        W = new int[N][N];
//        memoi = new int[N][allMask];
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(bf.readLine());
//            for (int j = 0; j < N; j++) {
//                W[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        System.out.println(tsp(0, 1));
//    }
//
//    private static boolean tsp(int idx, int allMask) {
//
//    }
//
//}
