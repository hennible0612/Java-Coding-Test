package A형.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630 {
	static int N;
	static int[][] map;
	static boolean[][] checker;

	static int white;
	static int black;

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];

		white = 0;
		black = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(checker(0, 0, 8, 8));
		
		

	}

	public static boolean checker(int startX, int startY, int endX, int endY) {
		int checkNumber = map[startX][startY];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != checkNumber) {
					return false;
				}
			}
		}
		return true;

	}
}
