package 두포인터_슬라이딩윈도우._6최대길이연속부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String[] str1 = bf.readLine().split(" ");
        int[] int_array = new int[n];
        for (int i = 0; i < n; i++) {
            int_array[i] = Integer.parseInt(str1[i]);
        }


        int answer = 0, cnt = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (int_array[rt] == 0) {
                cnt++;
            }
            while (cnt > m) {
                // 0 찾을때 까지 lt증가
                if (int_array[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);

        }
        System.out.println(answer);

    }
}
