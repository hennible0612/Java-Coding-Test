package SSAFY._20240220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2252 {

	static int N, M;
	static int[] topo; // 진입 차수 관리
	static List<List<Integer>> graph = new ArrayList<>(); // 순서 연결

	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		topo = new int[N + 1]; // 0 dummy
		// 인접리스트 만들기
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B); // 리스트 추가
			// 위에 추가했으니 진입 차수도 증가시킴
			topo[B]++;

		}
		// bfs <= 진입차수가 0인 정점 (학생)을 모두 queue 에 넣고 시작
		// 출력은 "꺼내면서 만들면된다"
		// queue 에서 꺼내서 이동할 수 있는 (학생 순서를 세우는 - 꺼낸 학생 뒤에 오는 학생)
		// 정점으로 이동하면서 그 저정의 진입 차수를 1개 줄인다.
		// 만약 줄이고 난뒤 진입 차수가 0이 되면 '큐 queue' 에 추가 .
		for (int i = 1; i <= N; i++) {
			if (topo[i] == 0) { // 진입 차수가 0이면 추가
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int no = queue.poll();
			// 출력완성
			sb.append(no).append(" ");
			// 꺼낸 번호에서 갈수이는 번호 탐색
			List<Integer> list = graph.get(no);
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int temp = list.get(i);
				// no 에 연결된 차수 감소
				topo[temp]--;
				// 줄인게 0이되면 
				if(topo[temp] == 0) {
					queue.offer(temp);
				}
			}
		}
		System.out.println(sb);
	}
}
