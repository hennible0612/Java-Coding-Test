package SSAFY._20240220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _2636 {
	static class Node {
		int x, y;
		int status;

		Node(int x, int y, int status) {
			this.x = x;
			this.y = y;
			this.status = status;
		}
	}

	static int N, M;
	static int[][] map;
	static int[][] map2;
	static int leftOver;
	static int leftHour;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		map2 = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				map2[i][j] = temp;

			}
		}
		leftOver = 0;
		leftHour = 0;
		checkMelt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("---------------------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map2[i][j] + " ");

			}
			System.out.println();

		}
	}

	static void checkMelt() {

		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0, 0));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 1) {
					map[ny][nx] = 4;
					map2[ny][nx] = 0;
				} else if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 0) {
					queue.add(new Node(nx, ny, 0));
				}

			}
		}

	}

}
