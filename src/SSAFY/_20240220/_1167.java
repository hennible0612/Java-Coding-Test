package SSAFY._20240220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1167 {
	static class Node {
		int to, weight;

		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + "]";
		}

	}

	static ArrayList<ArrayList<Node>> arrayList;
	static boolean[] visited;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(bf.readLine());

		arrayList = new ArrayList<>();
		visited = new boolean[V + 1];

		for (int i = 0; i <= V; i++) {
			arrayList.add(new ArrayList<>());

		}

		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int target = Integer.parseInt(st.nextToken());
			while (st.hasMoreElements()) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == -1) {
					break;
				} else {
					arrayList.get(target).add(new Node(temp, Integer.parseInt(st.nextToken())));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			dfs(i, 0);
		}
		System.out.println(answer);
	}

	static void dfs(int start, int weight) {
		if(visited[start]) {
			answer = Math.max(answer, weight);
			return;
		}
		visited[start] = true;
		ArrayList<Node> nodeList = arrayList.get(start);
		for(Node node : nodeList) {
			
			dfs(node.to, weight + node.weight);
			visited[start] = false;
			
		}
	}
}
