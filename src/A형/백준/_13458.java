package A형.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13458 {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //시험장의 수
        int N = Integer.parseInt(bf.readLine());

        int[] array = new int[N];

        // 각 시험장에 있는 응시자의 수
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        // B 총감독관이 한 시험장에서 감사할 수 있는 응시자의 수
        // C 부감독관이 한 시험장에서 감시할 수 있는 응시자의 수
        st = new StringTokenizer(bf.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long answer = 0;
        for (int temp : array) {
            answer++;
            int remaining = temp - B;
            if (remaining > 0) {
                answer += (remaining + C - 1) / C;
            }
        }
        System.out.println(answer);
    }
}
