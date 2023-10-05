package 알고리즘.그리디._5다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    // 가중치를 기준으로 Edge 객체들을 비교
    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 준비
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 노드와 간선의 수를 입력받음
        int node_num = Integer.parseInt(st.nextToken()); // 노드의 수
        int node_line = Integer.parseInt(st.nextToken()); // 간선의 수

        // 그래프를 인접 리스트로 표현하기 위한 리스트
        ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();

        // 인접 리스트 초기화
        for (int i = 0; i <= node_num; i++) {
            adjList.add(new ArrayList<>());
        }

        // 간선 정보를 입력받아 인접 리스트를 구성
        for (int i = 0; i < node_line; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList.get(from).add(new Edge(to, weight));
        }

        // 최단 거리를 저장할 알고리즘.배열, 초기에는 모든 거리를 무한대로 설정
        int answer[] = new int[node_num + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);

        // 우선순위 큐를 이용한 다익스트라 알고리즘 구현
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0)); // 시작 노드를 우선순위 큐에 추가
        answer[1] = 0; // 시작 노드의 최단 거리는 0

        // 우선순위 큐가 빌 때까지 실행
        while (!pq.isEmpty()) {
            // 우선순위 큐이니 가장 거리가 짧은 노드가 나온다
            Edge cur = pq.poll(); // 현재 가장 가까운 노드를 꺼냄
            int curNode = cur.vex;
            int curDist = cur.cost;

            // 이미 처리된 노드는 스킵
            if (curDist > answer[curNode]) continue;

            // 현재 노드와 인접한 노드들의 거리를 갱신
            for (Edge next : adjList.get(curNode)) {
                // 현재 노드(curNode)에 인접한 노드(nextNode)와 그 간선의 가중치(next[1])를 가져옴
                int nextNode = next.vex;
                // 현재 노드에서 인접한 노드까지의 총 거리를 계산
                int nextDist = curDist + next.cost;
                // 만약 새롭게 계산한 거리(nextDist)가 기존의 거리(answer[nextNode])보다 작다면 갱신
                if (answer[nextNode] > nextDist) {
                    // 최단 거리를 새로운 거리로 업데이트
                    answer[nextNode] = nextDist;
                    // 새롭게 갱신된 거리 정보를 우선순위 큐에 추가
                    // 이렇게 하면 나중에 이 노드가 다시 검사될 때 최단 거리가 반영됨
                    pq.add(new Edge(next.vex, nextDist));
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= node_num; i++) {
            System.out.println(i + " : " + (answer[i] == Integer.MAX_VALUE ? "INF" : answer[i]));
        }

    }
}
//6 9
//1 2 12
//1 3 4
//2 1 2
//2 3 5
//2 5 5
//3 4 5
//4 2 2
//4 5 5
//6 4 5
