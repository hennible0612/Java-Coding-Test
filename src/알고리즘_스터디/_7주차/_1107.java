package 알고리즘_스터디._7주차;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1107 {
    static int target;

    static int N;
    static int M;

    static ArrayList<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 현재 100번
        target = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < M; i++) {
            numbers.remove(Integer.valueOf(st.nextToken()));

        }
        getMaxNumber();
    }

    private static void getMaxNumber() {

    }
}

