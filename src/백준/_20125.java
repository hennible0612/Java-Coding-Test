package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20125 {
    // 심장 위치 x y
    // 왼쪽팔, 오른쪽 팔, 허리, 왼쪽다리, 오른쪽 다리
    static char[][] human;
    static int leftHand, rightHand, waist, leftLeg, rightLeg;
    static int heartX, heartY;
    static int legStartX, legStartY;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        human = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < N; j++) {
                human[i][j] = line.charAt(j);
            }
        }
        Solution();


    }

    private static void Solution() {
        findHeart();
        calculateWaist();
        calculateLeftArm();
        calculateRightArm();
        calculateRightLeg();
        calculateLeftLeg();

        System.out.println((heartY + 1) + " " + (heartX + 1));
        System.out.println(leftHand + " " + rightHand + " " + waist + " " + leftLeg + " " + rightLeg);

    }

    private static void calculateLeftLeg() {
        int nx = legStartX - 1;
        int ny = legStartY + 1;
        int total = 0;

        while (nx >= 0 && nx < N && ny >= 0 && ny < N && human[ny][nx] == '*') {
            total += 1;
            ny += 1;
        }
        leftLeg = total;
    }

    private static void calculateRightLeg() {
        int nx = legStartX + 1;
        int ny = legStartY + 1;
        int total = 0;

        while (nx >= 0 && nx < N && ny >= 0 && ny < N && human[ny][nx] == '*') {
            total += 1;
            ny += 1;
        }
        rightLeg = total;
    }

    private static void calculateRightArm() {
        int total = 0;
        int nx = heartX + 1;
        while (nx >= 0 && nx < N && human[heartY][nx] == '*') {
            total += 1;
            nx += 1;
        }

        rightHand = total;
    }

    private static void calculateLeftArm() {
        int total = 0;
        int nx = heartX - 1;
        while (nx >= 0 && nx < N && human[heartY][nx] == '*') {
            total += 1;
            nx -= 1;
        }

        leftHand = total;

    }

    private static void calculateWaist() {
        int total = 0;
        int ny = heartY + 1;
        while (ny >= 0 && ny < N && human[ny][heartX] == '*') {
            total += 1;
            ny += 1;
        }
        legStartX = heartX;
        legStartY = ny - 1;
        waist = total;
    }


    private static void findHeart() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int counter = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }
                    if (human[ny][nx] == '*') {
                        counter++;
                    }
                }
                if (counter == 4) {
                    heartX = j;
                    heartY = i;
                }
            }
        }
    }
}
