package SSAFY._20240221;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 인접 리스트를 사용한 구현
public class _13023_1 {

	static int N, M; // N: 사람의 수, M: 친구 관계의 수
	static List<List<Integer>> friends = new ArrayList<>(); // 각 사람의 친구 관계를 저장하는 인접 리스트

	static boolean[] visit; // 방문 여부를 체크하는 배열
	static boolean done; // 경로를 찾았는지 여부를 나타내는 플래그

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			friends.add(new ArrayList<>()); // 각 사람별 친구 리스트 초기화
		}

		// 친구 관계 입력 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			friends.get(a).add(b); // a의 친구 리스트에 b 추가
			friends.get(b).add(a); // b의 친구 리스트에 a 추가
		}
		visit = new boolean[N];

		// 모든 사람에 대해 DFS 수행
		for (int i = 0; i < N; i++) {
			visit[i] = true;
			dfs(i, 0); // DFS 시작, cnt는 0부터 시작
			if (done) { // 조건에 해당하는 경로를 찾은 경우
				System.out.println(1); // 1 출력 후 종료
				return;
			}
			visit[i] = false; // 방문 상태 초기화
		}
		System.out.println(0); // 조건에 해당하는 경로를 찾지 못한 경우 0 출력
	}

	// DFS 탐색 함수
	static void dfs(int num, int cnt) {
		if (cnt == 4) { // 4번 연결되었다면(ABCDE 관계), 조건 충족
			done = true;
			return;
		}
		List<Integer> numFriends = friends.get(num); // 현재 사람의 친구 리스트
		int size = numFriends.size();
		for (int i = 0; i < size; i++) {
			int n = numFriends.get(i);
			if (visit[n]) { // 이미 방문한 친구라면 스킵
				continue;
			}
			visit[n] = true;
			dfs(n, cnt + 1); // 다음 친구로 DFS 수행, 연결 횟수 증가
			visit[n] = false; // 방문 상태 초기화
		}
	}
}
