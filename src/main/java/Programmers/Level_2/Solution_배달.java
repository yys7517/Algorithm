package Programmers.Level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_배달 {
    // 양방향 통행 가능
    // 가중치가 모두 다름

    // N개의 마을

    // 1번에서 출발

    // K시간 이하로 배달이 가능한 곳만 간다.
    // 배달이 가능한 곳의 개수를 return

    // road - [마을 a, 마을 b, 거리]

    static ArrayList<ArrayList<int[]>> adj;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < road.length; i++) {
            int[] info = road[i];
            int from = info[0];
            int to = info[1];
            int cost = info[2];

            adj.get(from).add( new int[] { to, cost });
            adj.get(to).add(new int[] { from, cost });
        }

        answer = dijkstra(N, K);

        return answer;
    }

    static int dijkstra(int N, int K) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a[1], b[1]) );  // 가중치 가까운 순으로 정렬

        // 시작점은 1이다.
        dist[1] = 0;
        pq.add(new int[] { 1, 0 });

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int v = curr[0];
            int cost = curr[1];

            if( dist[v] < cost ) continue;  // v로 갈 수 있는 시간 중, 이미 구한 값이 더 최소 값이라면 skip

            for( int[] nextNode: adj.get(v) ) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                if( dist[next] > dist[v] + nextCost ) {
                    dist[next] = dist[v] + nextCost;
                    pq.add(new int[] { next, dist[next] });
                }
            }
        }

        // dist 배열을 완성했으면

        // K 이하로 배달 가능한 마을의 수
        int count = 0;
        for(int i = 1; i <= N; i++) {
            if( dist[i] <= K ) count++;
        }

        return count;
    }
}
