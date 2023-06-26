package Class1;

import java.util.Scanner;

public class _2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();

        if(M < 45) {
            H--; // 45분 미만이면 시간을 하나 감소
            M = 60 - (45 - M); // 60에서 45분을 뺀 나머지 시간을 더함
            if(H < 0) { // 만약 시간이 0 미만이면 23으로 설정
                H = 23;
            }
        } else {
            M -= 45; // 분에서 45분을 뺌
        }

        System.out.println(H + " " + M);
    }
}
