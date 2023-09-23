package 정렬._7좌표정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class Point implements Comparable<Point> {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) { // 정렬 기준
        if (this.x == p.x) { //p가 다음값
            return this.y - p.y; //오름차순일시 음수값 return
        } else {
            return this.x - p.x; // x 오름차순
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> arr = new ArrayList<>();


        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            arr.add( new Point(x, y));
        }
        Collections.sort(arr);

        for (Point o : arr) {
            System.out.println(o.x + " " + o.y);
        }
    }
}
