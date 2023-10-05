package 알고리즘.DFS_BFS_활용._1합이같은부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static String answer = "NO";
    static int total = 0;
    static boolean flag = false;
    static int n;
    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            list.add(value);
            total += value;
        }
        // 시작점
        dfs(list, 0, 0);
        System.out.println(answer);

    }

    public static void dfs(ArrayList<Integer> list, int level, int sum) {
        // flag == return 이면 답을 찾으니 더 깊게 안가기 위해
        if (flag) {
            return;
        }


        if (level == n) { //레벨 끝까지 가면
            if ((total - sum) == sum) { // 답이면 flag true
                answer = "YES";
                flag = true;
            }
            return;
        } else {// 다음레벨로 이동, 추가하거나 뺐다
            dfs(list, level + 1, sum + list.get(level));
            dfs(list, level + 1, sum);
        }
    }
}
