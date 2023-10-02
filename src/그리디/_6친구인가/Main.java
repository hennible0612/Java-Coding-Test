package 그리디._6친구인가;

import java.util.Scanner;

public class Main {
    // 집합 표현
    static int[] unf;

    public static int Find(int v) {
        if (v == unf[v]){ // index 번호화 배열값이 똑같다면 v의 집합 번호를 return
            return v;
        } else { // ex) 1 2모두 부모가 2다 가정하자
            // v가 1일시 부모가 2이므로 else로 온다
            // else로 온후 v의 부모 find(unf[1]) 즉, find(2)가 된다
            // 2의 부모는 2이므로 2가 return 이된다.
            return unf[v] = Find(unf[v]);
        }
    }

    public static void Union(int a, int b) {
        int fa = Find(a); // a의 집합
        int fb = Find(b); // b의 집합
        if (fa != fb) {
            unf[fa] = fb; // a집합의 부모를 fb로 변경
        }
    }

    public static void main(String[] args) {

        // 입력
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        // 각자 다른 집합으로 초기화
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++)  {
            unf[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            // a랑 b를 한 집합으로 만들어라
            Union(a, b);
        }
        int a = kb.nextInt();
        int b = kb.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if (fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
