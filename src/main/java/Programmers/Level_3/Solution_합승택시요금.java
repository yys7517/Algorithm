package Programmers.Level_3;

import java.util.*;

public class Solution_합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: fares) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];

            // 양방향
            adj.get(start).add(new int[] {end, cost});
            adj.get(end).add(new int[] {start, cost});
        }

        // 세 곳에서 다익스트라
        int[] distS = dikstra(n, s, adj);
        int[] distA = dikstra(n, a, adj);
        int[] distB = dikstra(n, b, adj);

        for(int i = 1; i <= n; i++) {
            // S, A, B 모두가 공통으로 못 가는 부분은 경유지가 될 수 없다.
            if(distS[i] == Integer.MAX_VALUE || distA[i] == Integer.MAX_VALUE || distB[i] == Integer.MAX_VALUE) {
                continue;
            }

            // i가 제3의 장소일 경우, (S->i) + (i->A) + (i->B), "합승하여" 경유지를 거치는 case  (입출력 예 #1)
            // i가 S일 경우, "합승하지 않고" 각자 가는 최단거리 (입출력 예 #2)
            // i가 A or B일 경우, A또는 B로 최적으로 간 이후에, 하나는 내리고, 하나는 다시 가는 경우 (입출력 예 #3)
            // (양방향이라 A -> i, i -> A는 같음)
            int sum = distS[i] + distA[i] + distB[i];
            answer = Math.min(answer, sum);
        }

        return answer;
    }

    static int[] dikstra(int n, int start, List<List<int[]>> adj) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 가중치 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1] );
        pq.add(new int[] {start, 0});

        while( !pq.isEmpty() ) {
            int[] curr = pq.poll();
            int now = curr[0];
            int cost = curr[1];

            if(dist[now] < cost) continue;

            for( int[] nextNode : adj.get(now) ) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                if( dist[next] > dist[now] + nextCost ) {
                    dist[next] = dist[now] + nextCost;
                    pq.add( new int[] { next, dist[next] });
                }
            }
        }

        return dist;
    }
}
