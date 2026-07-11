package Programmers.Level_3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_네트워크 {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            // 방문하지 않은 곳 부터 dfs 시작
            if( !visited[i] ) {
                answer++;
                dfs(i, n, computers);
            }
        }

        return answer;
    }

    static void dfs(int curr, int n, int[][] computers) {
        visited[curr] = true;

        for(int i = 0; i < n; i++) {
            // 방문한 적이 없고, 연결되어 있다면
            if( !visited[i] && computers[curr][i] == 1 ) {
                dfs(i, n, computers);
            }
        }
    }

    static void bfs(int start, int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int i = 0; i < n; i++) {
                if( computers[curr][i] == 1 && !visited[i] ) {  // 연결되어 있지만, 방문하지 않은 정점인가?
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
