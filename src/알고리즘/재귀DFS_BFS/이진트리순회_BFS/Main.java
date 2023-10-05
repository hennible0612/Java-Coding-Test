package 알고리즘.재귀DFS_BFS.이진트리순회_BFS;

import java.util.*;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Main {
    Node root;

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        int L = 0;
        while (!Q.isEmpty()) { // 큐에 있을때 동안
            int len = Q.size(); // 큐에 있는 길이만큼
            System.out.print(L + " : "); // 큐에 있는 길이만큼
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll(); // 빼기
                System.out.print(cur.data + " "); // 뺀 노드의 데이터 출력
                if (cur.lt != null) Q.add(cur.lt); // 왼쪽 확인 있다면 큐에 추가
                if (cur.rt != null) Q.add(cur.rt);// 오른쪽 확인 있다면 큐에 추가
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}