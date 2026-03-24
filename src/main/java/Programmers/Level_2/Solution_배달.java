package Programmers.Level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_배달 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 1 ~ N 까지 이동거리 저장 배열
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;    // 1번에서 출발

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] info : road) {
            int start = info[0];
            int end = info[1];
            int cost = info[2];

            // 양방향 통행 가능
            adj.get(start).add(new int[] {end, cost});
            adj.get(end).add(new int[] {start, cost});
        }

        // cost 기준 오름차순 정렬, cost가 짧은 값 부터
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {1, 0});

        while( !pq.isEmpty() ) {
            int[] curr = pq.poll();

            int now = curr[0];
            int cost = curr[1];

            if(dist[now] < cost) continue;

            // 이동 가능한 곳
            for( int[] nextNode : adj.get(now) ) {
                int next = nextNode[0];
                int nextCost = nextNode[1];

                // 거리 값 새로 갱신
                if( dist[next] > dist[now] + nextCost ) {
                    dist[next] = dist[now] + nextCost;

                    pq.add(new int[] { next, dist[next] });
                }
            }
        }

        // 1~N까지 K 시간 이하로 이동이 가능한 곳
        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}
