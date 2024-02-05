package A형.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493 {

	public static void main(String[] args) throws Exception {
		// N개의 탑
		// 각 탑 왼쪽 방향으로 레이저 발사
		// 탑 모두 레이저 수신기 있음
		// 하나의 탑에서 발사된 레이저는 단 하나의 탑에서만 수신 가능
		// 6 9 5 7 4
		// 4 -> 7 7 -> 9 5 -> 9 9x 6x
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		StringTokenizer st = new StringTokenizer(bf.readLine());

		int[] array = new int[N];
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			array[i] = temp;
			hashMap.put(temp, 0);
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			int number = array[i];
			if (stack.isEmpty()) {
				stack.push(number);
			} else {
				boolean flag = true;
				while (flag) {
//					System.out.println(stack.peek());
//					number = array[i];

					if (stack.peek() <= number) {
						int target = stack.pop();
						hashMap.replace(target, i);
						stack.push(number);
						continue;
					} else {
						stack.push(number);
						flag = false;
						continue;

					}
//					if(stack.isEmpty()) {
//						stack.push(number);
//						continue;
//					}
				}
			}

		}
		for (int i : array) {
			System.out.print(hashMap.get(i) + " ");
		}
	}

}
