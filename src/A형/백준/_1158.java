package A형.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] answer = new int[N];

		Deque queue = new ArrayDeque<>();
		for(int i = 1; i<=N; i++) {
			queue.add(i);
		}

		
		int counter = 1;
		int cnt = 0;
		while(!queue.isEmpty()) {
			if(counter == K) {
				counter = 1;
				answer[cnt] = (int) queue.poll();
				cnt++;
			}else {
				queue.add(queue.poll());
				counter++;
			}
		}
		
		sb.append("<");
		for(int i = 0; i< N - 1; i++) {
			sb.append(answer[i]);
			sb.append(", ");
		}
		sb.append(answer[N - 1]);
		sb.append(">");
		System.out.println(sb);
	
	}
}
