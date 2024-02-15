package SSAFY._20240214.백준;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1992 {

    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        map = new char[N][];

        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
        }

        System.out.println(compression(0, 0, N));
    }

    static String compression(int x, int y, int size) {
        char color = map[y][x];
        boolean sameColor = true;

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != color) {
                    sameColor = false;
                    break;
                }
            }
            if (!sameColor) {
                break;
            }
        }

        if (sameColor) {
            return String.valueOf(color);
        } else {
            int newSize = size / 2;
            return "(" +
                    compression(x, y, newSize) +
                    compression(x + newSize, y, newSize) +
                    compression(x, y + newSize, newSize) +
                    compression(x + newSize, y + newSize, newSize) +
                    ")";
        }
    }
}
