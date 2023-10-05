package 알고리즘.그리디._2회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Room implements Comparable<Room> {
    int start;
    int end;
     public Room(int s, int e) {
         this.start = s;
         this.end = e;
     }

    public int compareTo(Room r) {
        if (this.start == r.start) {
            // 음수가 된다면 `앞 부분이 작고 뒷부분이 크다`
            return this.end - r.end;  // 시작 시간이 같을 경우, 끝나는 시간으로 알고리즘.정렬
        }
        return this.start - r.start;  // 시작 시간으로 오름차순 알고리즘.정렬
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Room> arrayList = new ArrayList<>();

        int n = Integer.parseInt(bf.readLine());
        // 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            arrayList.add(new Room(temp, temp2));
        }

        Collections.sort(arrayList);

        int counter = 1;
        int end = arrayList.get(0).end;

        for (int i = 1; i < n; i++) {
            Room room = arrayList.get(i);
            if (room.start >= end) {
                counter++;
                end = room.end;
            } else if(room.end < end){
                end = room.end;
            }
        }

        System.out.println(counter);
    }
}
