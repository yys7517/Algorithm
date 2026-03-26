package Programmers.Level_3;

import java.util.*;

public class Solution_합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];

            // 양방향이다.
            adj.get(start).add(new int[] {end, cost});
            adj.get(end).add(new int[] {start, cost});
        }

        // S -> i + i -> A + i -> B (입출력 1)
        // S -> A + S -> B (입출력 2) -> 합승 x
        // S -> B + B -> A (입출력 3)

        int[] distS = dikstra(s, adj, n);
        int[] distA = dikstra(a, adj, n);
        int[] distB = dikstra(b, adj, n);

        // 경유지를 for문으로 설정, i값에 따라, 경유지가 없어지기도 해야함.. 잘 생각해보자..
        // S -> i + i -> A + i -> B (입출력 1)
        // S -> A + S -> B (입출력 2) -> 합승 x
        // S -> B + B -> A (입출력 3)
        for(int i = 1; i <= n; i++) {
            // i == S 일때, A-S + B-S -> (합승x + 입출력 2)
            // i == A일때, S-A + A-B -> (합승 + 입출력 3)
            // i == B일때, S-B + A-B -> (합승 + 입출력 3)
            // i값이 제 4의 영역일 때, (경유지일 때) S -> i + i -> A + i -> B (입출력 1)
            int sum = distS[i] + distA[i] + distB[i];
            answer = Math.min(answer, sum);
        }

        return answer;
    }

    static int[] dikstra(int start, List<List<int[]>> adj, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add( new int[] {start, 0} );

        while( !pq.isEmpty() ) {
            int[] currNode = pq.poll();
            int now = currNode[0];
            int cost = currNode[1];

            if( dist[now] < cost ) continue;

            for( int[] nextNode : adj.get(now) ) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                if( dist[next] > dist[now] + nextCost ) {
                    dist[next] = dist[now] + nextCost;
                    pq.add( new int[] { next, dist[next] } );
                }
            }
        }

        return dist;
    }
}
