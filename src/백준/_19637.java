package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;
import java.util.StringTokenizer;



public class _19637 {
    static class Title {
        String name;
        int score;

        public Title(String name, int upperBound) {
            this.name = name;
            this.score = upperBound;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Title[] titles = new Title[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int upperBound = Integer.parseInt(st.nextToken());
            titles[i] = new Title(name, upperBound);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(bf.readLine());
            String titleName = getTitleName(titles, power);
            sb.append(titleName).append('\n');
        }

        System.out.print(sb);
    }

    public static String getTitleName(Title[] titles, int power) {
        for (Title title : titles) {
            if (power <= title.score) {
                return title.name;
            }
        }
        return "";
    }
}
