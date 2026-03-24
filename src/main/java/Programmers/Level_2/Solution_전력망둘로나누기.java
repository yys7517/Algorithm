package Programmers.Level_2;

import java.util.*;

public class Solution_전력망둘로나누기 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];

            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        for(int[] wire: wires) {
            // 하나씩 지우고 BFS나 DFS 돌려서 개수 세보기
            int start = wire[0];
            int end = wire[1];

            // 하나 끊기
            adj.get(start).remove(Integer.valueOf(end));
            adj.get(end).remove(Integer.valueOf(start));

            int count1 = bfs(adj, n);
            int count2 = n - count1;

            answer = Math.min(answer, Math.abs(count1 - count2));

            // 다시 연결해주기
            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        return answer;
    }

    static int bfs(List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n+1];
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while( !queue.isEmpty() ) {
            int now = queue.poll();
            count++;

            for( int next : adj.get(now) ) {
                if( !visited[next] ) {
                    queue.add(next);
                    visited[next] = true;
                }
            }// End bfs for
        } // End bfs while

        return count;
    }// End bfs
}
