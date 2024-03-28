package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1043 {
    static int N, M;

    static int[] parent;
    static boolean[] party;
    static int answer;

    public static void main(String[] args) throws Exception {
        // N 사람의 수 M 파티의 수
        // 진실을 아는 사람의 수
        // 각 파티마다 오는 사람들

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        party = new boolean[M];
        parent = new int[N + 1];

        // 부모 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        //진실그룹
        st = new StringTokenizer(bf.readLine());
        int truthCount = Integer.parseInt(st.nextToken()); //진실 아는 사람들
        for (int i = 0; i < truthCount; i++) {
            int truthPerson = Integer.parseInt(st.nextToken());
            union(0, truthPerson); // 부모가 0
        }

        int[][] parties = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            parties[i] = new int[partySize]; // 크기 설정
            for (int j = 0; j < partySize; j++) {
                parties[i][j] = Integer.parseInt(st.nextToken());
                if (j > 0) { // 첫 번째 사람과 나머지 사람을 union
                    union(parties[i][0], parties[i][j]);
                }
            }
        }

        int answer = 0;
        for (int[] party : parties) {
            boolean canLie = true; // 이 파티에서 거짓말을 할 수 있는지
            for (int person : party) {

                if (find(person) == find(0)) { // 진실을 아는 사람과 연결되어 있다면
                    canLie = false;
                    break;
                }
            }
            if (canLie){
                answer++;
            }
        }
        System.out.println(answer);


    }

    // find 함수 : 특정 요소가 속한 그룹의 대표 찾기
    static int find(int x) {
        if (x == parent[x]) {
            return x; // 자기 자신인 경우 반환
        }
        return parent[x] = find(parent[x]);
    }

    //union 함수 : 두 요소가 속한 그룹을 합침
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
}
