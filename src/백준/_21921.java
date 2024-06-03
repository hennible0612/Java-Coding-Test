package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21921 {

    static int N, X;
    static int maxNum, numCount;

    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        array = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        maxNum = 0;
        numCount = 0;

        for (int i = 0; i < X; i++) {
            maxNum += array[i];
        }
        numCount++;

        int tempNum = maxNum;
        for (int i = X; i < N; i++) {
            tempNum -= array[i - X];
            tempNum += array[i];
            if (tempNum == maxNum) {
                numCount++;
            }
            if (tempNum > maxNum) {
                maxNum = tempNum;
                numCount = 1;
            }
        }

        if (maxNum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxNum);
            System.out.println(numCount);
        }
    }
}
