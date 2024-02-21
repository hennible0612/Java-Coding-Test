package SSAFY._20240221.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3289 {

	static int T, n, m;
	static int[] parent; // index : 원소, value : 부모원소, 최상위 부모 : index == value 동일하다
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			// 풀이
			parent = new int[n + 1]; // 0 dummy
			makeSet(); // 배열 만든다.

			sb.append("#").append(t).append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());
				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (op == 0) { // Union
					union(x, y);
				} else if (op == 1) { // 비교 출력
					if (findSet(x) == findSet(y)) {
						sb.append("1");

					} else {
						sb.append("0");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 보통 잘 안만든다
	static void makeSet() { // 모두가 서로소인 원소 1개를 갖는 집합 배열 구조
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	// 부모를 찾는 함수, 그냥 부모가 아님 "최상위" 부모임
	// pass compresstion은 아직 아님
	// parent[1] -> 999999
	// parent[2] -> 999999
	//
	static int findSet(int x) {
//		if (parent[x] == x) {
//			return x; // 최상위 (대포) 원소
//		} else { // x의 바로 위 부모가 최상위가 아니므로 다시 검색
//			return findSet(parent[x]);
//		}
		if (parent[x] == x) {
			return x;
		} else {
			// 완전 최상위 부모를 찾은 후 해당 parent에 입력해준다.
			return parent[x] = findSet(parent[x]);
		}
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		// 어떻게 합칠 것인가?
		// #1 앞 x가 부모가 되도록
//		parent[py] = px;
		// #2 크기를 비교해서 정한다
		if (px < py) {
			parent[py] = px;
		} else {
			parent[px] = py;
		}

	}
}
