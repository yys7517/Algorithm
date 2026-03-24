package Programmers.Level_3;

import java.util.*;

public class Solution_부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length]; // 출발 인원 수만큼
        Arrays.fill(answer, -1);

        // sources - 부대원 위치
        // destination - 도착지점
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] road: roads) {
            int start = road[0];
            int end = road[1];

            // 양방향 (왕복 가능), 가중치 1
            adj.get(start).add(new int[] {end, 1});
            adj.get(end).add(new int[] {start, 1});
        }

        // 양방향이므로, 목적지에서 출발하면!
        // 모든 부대원들이 목적지로 돌아올 수 있는지, 있다면 얼마나 걸리는지 다익스트라 한 번만에 알 수 있다.
        int[] dist = dikstra( adj, n, destination);

        for(int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]] == Integer.MAX_VALUE ? -1 : dist[sources[i]];
        }

        return answer;
    }

    static int[] dikstra( List<List<int[]>> adj, int n, int start ) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[] {start, 0});

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        while( !pq.isEmpty() ) {
            int[] curr = pq.poll();
            int now = curr[0];
            int cost = curr[1];

            if( dist[now] < cost ) continue;

            for( int[] nextNode : adj.get(now) ) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                if( dist[next] > dist[now] + nextCost ) {
                    dist[next] = dist[now] + nextCost;
                    pq.add(new int[] { next, dist[next] });
                }
            }
        }

        return dist;
    }
}
