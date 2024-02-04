package 알고리즘_스터디._3주차.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bf.readLine());

        HashSet<Integer> S = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();
            int x = 0;

            switch (command) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    S.add(x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    S.remove(x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if (S.contains(x)) {
                        sb.append("1");
                    }else{
                        sb.append("0");
                    }
                    sb.append("\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if (S.contains(x)) {
                        S.remove(x);
                    } else {
                        S.add(x);
                    }
                    break;
                case "all":
                    S.clear();
                    for (int j = 1; j <= 20; j++) {
                        S.add(j);
                    }
                    break;
                case "empty":
                    S.clear();
                    break;

            }

        }
        System.out.println(sb);
    }
}
