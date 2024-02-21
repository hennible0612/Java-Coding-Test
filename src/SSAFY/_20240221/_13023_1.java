package SSAFY._20240221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 인접 리스트 
public class _13023_1 {

	static int N, M;
	static List<List<Integer>> friends = new ArrayList<>();

	static boolean[] visit;
	static boolean done; // 완료

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			friends.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			friends.get(a).add(b);
			friends.get(b).add(a);
		}
		visit = new boolean[N];
		// 풀이
		// 모든 사람의 친구 관계에서 연속인 연결이 생기는지 따져본다.
		for (int i = 0; i < N; i++) {
			visit[i] = true;
			dfs(i, 0);
			if (done) { // 찾았으면 탐색 X 출력하고 main() 정리
				System.out.println(1);
				return;
			}
			visit[i] = false;
		}
		System.out.println(0);
	}

	// 현재 친구번호, 이전 단계까지의 연속된 연결 갯수
	static void dfs(int num, int cnt) {
		// 기저 조건
		if (cnt == 4) {
			done = true;
			return;
		}
		List<Integer> numFriends = friends.get(num); // num 에서 연결된 다른 친구들
		int size = numFriends.size();
		for (int i = 0; i < size; i++) {
			int n = numFriends.get(i);
			if (visit[n]) {
				continue;
			}
			visit[n] = true;
			dfs(n, cnt + 1);
			visit[n] = false;
		}
		for (int n : friends.get(num)) {
			if (visit[n]) {
				continue;
			}
			visit[n] = true;
			dfs(n, cnt + 1);
			visit[n] = false;
		}
		friends.get(num).forEach((n) -> {
			if (!visit[n]) {
				visit[n] = true;
				dfs(n, cnt + 1);
				visit[n] = false;
			}
		});

	}
}
