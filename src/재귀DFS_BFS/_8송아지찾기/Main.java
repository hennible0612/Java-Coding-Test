package 재귀DFS_BFS._8송아지찾기;

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//public class Main {
//    static class Node {
//        int pos;
//        int count;
//
//        public Node(int pos, int count) {
//            this.pos = pos;
//            this.count = count;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int S = sc.nextInt(); // 위치
//        int E = sc.nextInt(); // target
//        System.out.println(bfs(S, E));
//    }
//
//    public static int bfs(int S, int E) {
//        int[] visited = new int[10001];
//        int[] moves = {-1, 1, 5};
//        Queue<Node> queue = new LinkedList<>();
//
//        queue.offer(new Node(S, 0)); // 시작점 추가
//
//        while (!queue.isEmpty()) {
//            Node currNode = queue.poll(); // 새로운 노드
//            int curr = currNode.pos; // currnode 위치
//            int cnt = currNode.count; // currnode moves 카운트
//
//            if (curr == E) { // target 에 갈시 count return
//                return cnt;
//            }
//
//            for (int move : moves) { // 총 3개의 움직임
//                int nextPos = curr + move;
//
//                if (nextPos >= 1 && nextPos <= 10000 && visited[nextPos] == 0) {
//                    visited[nextPos] = 1; // 발견한 곳은 안가기 위해
//                    queue.offer(new Node(nextPos, cnt + 1));
//                }
//            }
//        }
//
//        return -1;  // 이 부분은 실행되지 않아야 합니다 (문제에서 답은 항상 존재한다고 했기 때문에)
//    }
//
//
//}

import java.util.*;

class Main {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10001]; // 넣었던건 넣지 않는다
        ch[s] = 1;
        Q.offer(s); // q에 시작 위치 삽입
        int L = 0; // 레벨 ==> 답
        while (!Q.isEmpty()) {
            int len = Q.size(); // 각 레벨 마다의 노드(원소의 개수)
            for (int i = 0; i < len; i++) { // q에 있는 만큼
                int x = Q.poll(); // q에 있는거 꺼내기
                // moves
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j]; // dist[j] 즉, 3가지 move중 하나 더해줌
                    if (nx == e) { // target이면
                        return L + 1;
                    }
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s, e));
    }
}