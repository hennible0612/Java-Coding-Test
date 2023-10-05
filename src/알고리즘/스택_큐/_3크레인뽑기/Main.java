package 알고리즘.스택_큐._3크레인뽑기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int x : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][x - 1] != 0) {
                    if (!stack.empty() && stack.peek() == board[i][x - 1]) {

                        answer += 2;
                        stack.pop();

                    } else {
                        stack.push(board[i][x - 1]);
                    }
                    board[i][x - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        int m = Integer.parseInt(bf.readLine());
        int[] move = new int[m];

        String[] line = bf.readLine().split(" ");

        for (int j = 0; j < m; j++) {
            move[j] = Integer.parseInt(line[j]);
        }
        System.out.println(solution(matrix, move));

    }
}
