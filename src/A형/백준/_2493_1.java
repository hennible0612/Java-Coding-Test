package A형.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//자료구조 (탑) 높이, 위치 int[]
// ArrayDeque + StringBuilder
public class _2493_1 {

	static ArrayDeque<int[]> stack = new ArrayDeque<>();
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// N개의 탑
		// 각 탑 왼쪽 방향으로 레이저 발사
		// 탑 모두 레이저 수신기 있음
		// 하나의 탑에서 발사된 레이저는 단 하나의 탑에서만 수신 가능
		// 6 9 5 7 4
		// 4 -> 7 7 -> 9 5 -> 9 9x 6x
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// N개의 탑을 입력을 받으면서 한 개씩 바로 처리
		// 유의 미한 탑은 stasck에 넣고(탑의 신호를 받을 수 있는...);
		// 무의미한 탑은 stack 에서 꺼낸다(탑의 신호를 받을 수 없는...
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= height) { // 현재 탑의 신호를 받을 수 있는팁
					sb.append((stack.peek()[0])).append(" ");
					break;
				}
				// 이전(앞서 있는 탑)이 현재 탑보다 작으면 이후 탑에서 보내는 신호를
				// 받을 수 없는 것들은 뺸다
				stack.pop();
			}

			// 현재 기준 탑이 가능 높은 경우
			if (stack.isEmpty()) {
				sb.append("0 ");
			}
			// 현재 탑을 stack에 넣고 다음 탑을 고려
			stack.push(new int[] { i, height }); // 위치, 높이
		}
		System.out.println(sb);
	}

}
