package 알고리즘.그리디._1씨름선수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Player implements Comparable<Player> {
    int height;
    int weight;

    Player(int height, int weight) {
        this.height = height;
        this.weight = weight;

    }

    public int compareTo(Player o) {
        return o.height - this.height; // 키가 큰 순서로 알고리즘.정렬

    }

}

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Player[] players = new Player[n];

        // 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            players[i] = new Player(height, weight);
        }

        Arrays.sort(players); //객체를 정렬할 수 있는 이유는 Comparable를 구현했기 때문이다. 순서는 키순

        int cnt = 1; // 가장 키가 큰 사람은 무조건 선발이 가능하다
        int maxWeight = players[0].weight; // 키가 가장 큰 선수의 몸무게를 초기 최대 몸무게로 설정

        // 정렬도니ㅣ 배열을 순회하며 몸무게를 체크
        for (int i = 1; i < n; i++) {
            // 현재 선수의 몸무게가 이전까지의 최대 몸무게보다 크면 선발
            if (players[i].weight > maxWeight) {
                maxWeight = players[i].weight; // 최대 몸무게 업데이트
                cnt++; // 선발된 선수 수 증가
            }

        }
        System.out.println(cnt);


    }
}
