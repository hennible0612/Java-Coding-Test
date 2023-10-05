package 알고리즘.재귀_트리_그래프.재귀함수_스택프레임;

public class Main {
    private static void DFS(int i) {

        if (i == 0) {
            return;
        } else {
            System.out.println(i);
            DFS(i - 1);
        }


    }

    public static void main(String[] args) {
        DFS(3);
    }


}
