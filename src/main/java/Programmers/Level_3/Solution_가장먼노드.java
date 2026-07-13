package Programmers.Level_3;

import java.util.*;

public class Solution_가장먼노드 {
    // 노드의 개수 n
    // edges - [a, b] 노드 a,b 사이에 간선이 있다
    // 1번 노드에서 가장 멀리 떨어진 노드의 갯수는?

    // 다익스트라로, 1번 노드에서 출발해서, 각 노드에 가는 거리를 구하자.
    // 근데 그냥 BFS로 구할 수 있을듯
    // 간선의 가중치가 모두 1로 동일해서

    static ArrayList<ArrayList<Integer>> adj;

    public int solution(int n, int[][] edges) {
        int answer = 0;

        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            adj.get(from).add(to);
            adj.get(to).add(from);
        }


        dist[1] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int next: adj.get(curr) ) {
                if(dist[next] != -1) continue;      // 이미 방문한 곳이면, 스킵

                dist[next] = dist[curr] + 1;
                q.add(next);
            }
        }

        int max = -1;

        for(int i = 1; i <= n; i++) {
            if( dist[i] == -1 ) continue;   // 방문되지 않은 곳, 갈 수 없는 정점이다.
            max = Math.max( max , dist[i] );
        }

        for(int i = 1; i <= n; i++) {
            if( dist[i] == -1 ) continue;   // 방문되지 않은 곳, 갈 수 없는 정점이다.
            if( dist[i] == max ) answer++;
        }

        return answer;
    }
}
