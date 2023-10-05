package 알고리즘.DFS_BFS_활용._3최대점수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int limit;

    static int answer;
    static List<List<Integer>> lists;
    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        lists = new ArrayList<>();  // 리스트의 리스트

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            List<Integer> tempList = new ArrayList<>();
            tempList.add(Integer.parseInt(st.nextToken()));
            tempList.add(Integer.parseInt(st.nextToken()));
            lists.add(tempList);
        }


        dfs(0,0, 0);
        System.out.println(answer);

    }

    public static void dfs(int index, int score, int time) {
        if (time > limit) {
            return;
        }

        if (index == n || time == limit) {
            answer = Math.max(answer, score);
            return;
        } else {
            int newScore = score + lists.get(index).get(0);
            int newTime = time + lists.get(index).get(1);
            dfs(index + 1, newScore, newTime);
            dfs(index + 1, score, time);

        }
    }

}
