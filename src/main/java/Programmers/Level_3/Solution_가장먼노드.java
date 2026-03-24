package Programmers.Level_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_가장먼노드 {
    public int solution(int n, int[][] edges) {
        int answer = 0;

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // 간선 가중치 정보가 주어지지 않았고, 간선의 개수가 가장 많은 노드가 가장 멀리 떨어진것 = 가중치 1로 두자
        for(int[] edge: edges) {
            int start = edge[0];
            int end = edge[1];

            // 간선은 양방향
            adj.get(start).add(new int[] {end, 1});
            adj.get(end).add(new int[] {start, 1});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;    // 1번 노드에서 출발

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1] );
        pq.add(new int[] {1,0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int now = curr[0];
            int cost = curr[1];

            if(dist[now] < cost) continue;

            for( int[] nextNode: adj.get(now) ) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                if(dist[next] > dist[now] + nextCost) {
                    dist[next] = dist[now] + nextCost;
                    pq.add( new int[] { next, dist[next] });
                }
            }
        }

        int maxDist = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            // System.out.println(dist[i]);
            if(maxDist < dist[i]) maxDist = dist[i];
        }

        for(int i = 1; i <= n; i++) {
            if(dist[i] == maxDist) answer++;
        }

        return answer;
    }
}
