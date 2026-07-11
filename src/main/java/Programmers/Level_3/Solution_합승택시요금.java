package Programmers.Level_3;

import java.util.*;

public class Solution_합승택시요금 {
    // 지점의 개수 n
    // 출발지점 s

    // a, b - 도착지점

    // fares - 예상 택시 요금 [출발지, 도착지, 요금]
    // 요금 - 가중치
    // 다익스트라

    static ArrayList<ArrayList<int[]>> adj;
    static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;

        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < fares.length; i++) {
            int[] info = fares[i];
            int from = info[0];
            int to = info[1];
            int cost = info[2];

            adj.get(from).add(new int[] {to, cost});
            adj.get(to).add(new int[] {from , cost});
        }

        int[] distS = dijkstra(n, s); // 출발지에서 각 지점까지의 거리를 다 찾아보자.
        int[] distA = dijkstra(n, a);
        int[] distB = dijkstra(n, b);

        // 경유지 어떻게 ?? >> 하나씩 다 돌아보자..
        for( int i = 1; i <= n; i++ ) {
            // i를 경유지라고 했을 때

            // distS[i] = 출발지 - 경유지
            // distA[i] = 경유지 - A
            // distB[i] = 경유지 - B

            // 만약, 아예 합승을 하지 않고 각자 이동하는 경우의 예상 택시요금이 더 낮다면, 합승을 하지 않아도 됩니다.
            // 합승을 안하고 가는 경우, 경유지를 거쳐 가는 경우 >> 둘 중 최소 요금을 return

            // 경유지가 출발지인 경우는 체크할 필요 없을듯
            // 출발해서 갈 수 없는 경유지라면? skip
            // **** A랑 B에서도 갈 수 있는 경유지인지 체크해야함 *****
            if( distS[i] == INF || distA[i] == INF || distB[i] == INF ) continue;

            // 합승을 하지 않는 경우 - distS[a] + distS[b]
            // 합승을 하는 경우 - 경유지가 어디인가?

            answer = Math.min( answer, distS[i] + distA[i] + distB[i] );
        }

        return answer;
    }

    static int[] dijkstra(int n, int start) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a[1], b[1]));

        dist[start] = 0;
        pq.add(new int[] {start, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int v = curr[0];
            int cost = curr[1];

            if( dist[v] < cost ) continue;

            for( int[] nextNode: adj.get(v) ) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                if( dist[next] > dist[v] + nextCost ) {
                    dist[next] = dist[v] + nextCost;
                    pq.add(new int[] {next, dist[next]});
                }
            }
        } // End While


        return dist;
    }
}
