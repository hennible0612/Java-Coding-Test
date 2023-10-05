package 알고리즘.문자열._1문자찾기;


import java.util.Scanner;

public class _1 {
    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
//        System.out.println(str + " " + t);
//        for (int i = 0; i < str.length(); i++) {
//            if(str.charAt(i) == t){
//                answer++;
//            }
//        }
        // string to 문자배열 .toCharArray()

        for (char x : str.toCharArray()) {
            if (x == t) {
                answer++;

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _1 T = new _1();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0); // 0번에 있는거 가져와라
        System.out.println(T.solution(str, c));

    }
}
