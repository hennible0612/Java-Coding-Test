package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class _20055 {
    static int N, K;
    static int counter;
    static int beltSize;
    static ArrayList<BeltBlock> beltBlocks;
    static int answer;
    static int start = 0;
    static int end;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        beltBlocks = new ArrayList<>();
        counter = 0;
        answer = 0;
        beltSize = N * 2;
        end = N - 1;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < beltSize; i++) {
            beltBlocks.add(new BeltBlock(Integer.parseInt(st.nextToken()), false));
        }

        while (counter < K) {
            moveBelt();
            moveRobot();
            setRobot();
            answer++;
        }
        System.out.println(answer);

    }

    private static void setRobot() {
        int setIndex = start;
        if (beltBlocks.get(setIndex).durability > 0) {
            beltBlocks.get(setIndex).robotStatus = true;
            beltBlocks.get(setIndex).durability--;
            if (beltBlocks.get(setIndex).durability == 0) {
                counter++;
            }
        }
    }

    private static void moveBelt() {
        //오른쪽으로 distance만큼 회전 시킴
        // 양수면 오른쪽 음수면 왼쪽
//        Collections.rotate(beltBlocks, 1); // 시간 초 과
        start = (start - 1 + N * 2) % (N * 2);
        end = (end - 1 + N * 2) % (N * 2);
        if (beltBlocks.get(end).robotStatus) {
            beltBlocks.get(end).robotStatus = false; // 내리는 위치에 도달한 로봇 제거
        }
    }

    private static void moveRobot() {
        for (int i = 1; i < N; i++) {
            int currIndex = (end - i + N * 2) % (N * 2);
            int nextIndex = (currIndex + 1) % (N * 2);
            if (beltBlocks.get(currIndex).robotStatus && !beltBlocks.get(nextIndex).robotStatus
                    && beltBlocks.get(nextIndex).durability > 0) {
                beltBlocks.get(currIndex).robotStatus = false;
                beltBlocks.get(nextIndex).robotStatus = true;
                beltBlocks.get(nextIndex).durability--;
                if (beltBlocks.get(nextIndex).durability == 0) {
                    counter++;
                }
            }
        }
        if (beltBlocks.get(end).robotStatus) {
            beltBlocks.get(end).robotStatus = false; // 내리는 위치에 도달한 로봇 제거
        }

    }

    static class BeltBlock {
        int durability;
        boolean robotStatus;

        public BeltBlock(int durability, boolean robotStatus) {
            this.durability = durability;
            this.robotStatus = robotStatus;
        }
    }

}
