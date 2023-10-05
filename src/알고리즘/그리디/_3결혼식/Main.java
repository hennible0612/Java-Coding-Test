package 알고리즘.그리디._3결혼식;

import java.util.*;
import java.io.*;

public class Main {

    static class Room implements Comparable<Room> {

        int start;
        char type;

        public Room(int start, char type) {
            this.start = start;
            this.type = type;
        }

        public int compareTo(Room room) {
            if (this.start == room.start) {
                return this.type - room.type;
            }
            return this.start - room.start;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        ArrayList<Room> roomArrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            roomArrayList.add(new Room(start, 's'));
            roomArrayList.add(new Room(end, 'e'));
        }
        Collections.sort(roomArrayList);
        int answer = Integer.MIN_VALUE;

        int counter = 0;
        for (Room room : roomArrayList) {
            if (room.type == 's') {
                counter++;
            } else {
                counter--;
            }
            answer = Math.max(answer, counter);


        }
        System.out.println(answer);

    }
}
