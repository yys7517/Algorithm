package Programmers.Level_3;

import java.util.*;

public class Solution_합승택시요금 {
    // 방법 1. 합승해서, 경유 지점에서 내려서 각자 집으로 간다. (경유 지점이 A or B가 될 수 있다.)
    // 방법 2. 그냥 합승하지 않고, 각자 집으로 간다.

    // 위 방법 중 최소 비용이 나오는 방법을 선택, 최소 비용을 return

    // s - 출발 지점
    // n - 지점 갯수 (지점 번호: 1 ~ n)
    // a - A 집
    // b - B 집
    // fares - [v1,v2,cost] - 지점 v1, v2 연결, 및 비용 정보

    static ArrayList<ArrayList<int[]>> adj;
    static int N;
    static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;

        // 인접 리스트 연결
        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] fare: fares) {
            int v1 = fare[0];
            int v2 = fare[1];
            int cost = fare[2];

            adj.get(v1).add(new int[] {v2, cost});
            adj.get(v2).add(new int[] {v1, cost});
        }

        int[] costS = dijkstra(s);
        int[] costA = dijkstra(a);
        int[] costB = dijkstra(b);

        // 최소 비용
        int min = Integer.MAX_VALUE;

        // 경유지를 i라고 할 때
        for(int i = 1; i <= n; i++) {
            // (S -> i) + (i -> A) + (i -> B) 가 모두 필요한 비용이 된다.

            // i = S 이면, 합승을 하지 않고, 각자 가는 것으로 볼 수 있고..
            // i != S이면, 합승을 해서, 경유지에서, A, B가 각자 이동하는 것
            // i = A or B이면, A나 B의 집으로 같이 간 후, 각자 이동

            if( costS[i] == INF || costA[i] == INF || costB[i] == INF ) continue;

            min = Math.min( min , costS[i] + costA[i] + costB[i] );
        }

        return min;
    }

    static int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] {start, 0});

        int[] costs = new int[N+1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        costs[start] = 0;

        while(!pq.isEmpty()) {
            int[] currNode = pq.poll();
            int curr = currNode[0];
            int cost = currNode[1];

            if( costs[curr] < cost ) continue;

            for(int[] nextNode: adj.get(curr)) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                if( costs[next] > costs[curr] + nextCost ) {
                    costs[next] = costs[curr] + nextCost;
                    pq.add(new int[] {next, costs[next]} );
                }
            }
        }

        return costs;
    }
}
