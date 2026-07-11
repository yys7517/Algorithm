package Programmers.Level_3;

import java.util.*;

public class Solution_부대복귀 {
    // 가중치는 모두 1로 동일... 굳이 다익스트라? BFS로 풀이해도 될듯
    // 총 지역 수 n
    // roads는 간선 정보 - [출발지, 도착지]

    // destination - 복귀해야 할 곳 도착지

    // sources는 출발 부대이고
    // sources 순서대로 복귀할 수 있는 최단 시간을 return

    // 출발지가 여러 개이고, 도착지가 하나이다.
    // roads에 있는 길 정보는, 왕복이 가능하다.
    // 그냥 도착지에서 출발했을 때, 각 지점에 도착하는 데에 걸린 시간을 구하면 더 편리하다.

    static ArrayList<ArrayList<int[]>> adj;
    static final int INF = Integer.MAX_VALUE;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.length; i++) {
            int[] info = roads[i];

            int from = info[0];
            int to = info[1];

            adj.get(from).add(new int[] {to, 1});
            adj.get(to).add(new int[] {from, 1});
        }

        int[] dist = bfs(n, sources, destination);

        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i++) {
            int num = sources[i];

            answer[i] = dist[num] < INF ? dist[num] : -1;   // 갱신되지 않은 곳은 못 가는 곳이므로, -1
        }

        return answer;
    }

    // 도착지에서 출발하는 다익스트라, 거리 배열을 구하자
    static int[] bfs(int n, int[] destinations, int start) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        // Queue<int[]> q = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();

        // q.add(new int[] {start, 0});
        q.add(start);
        dist[start] = 0;

//         while(!q.isEmpty()) {
//             int[] curr = q.poll();
//             int v = curr[0];
//             int cost = curr[1];

//             if (dist[v] < cost) continue;

//             for( int[] nextNode: adj.get(v) ) {
//                 int next = nextNode[0];
//                 int nextCost = nextNode[1];

//                 if( dist[next] > dist[v] + nextCost ) {
//                     dist[next] = dist[v] + nextCost;
//                     q.add(new int[] { next, dist[next] });
//                 }
//             }
//         }

        while(!q.isEmpty()) {
            int curr = q.poll();

            for( int[] nextNode : adj.get(curr) ) {
                int next = nextNode[0];

                // 이미 INF가 아니고, 최소 거리를 찾았으면, 그게 최단거리다. 왜냐하면, 가중치가 모두 1로 같은 BFS
                if( dist[next] != INF ) continue;

                dist[next] = dist[curr] + 1;
                q.add(next);
            }
        }

        return dist;
    }
}
