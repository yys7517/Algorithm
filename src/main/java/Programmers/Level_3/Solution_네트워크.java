package Programmers.Level_3;

public class Solution_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            // 방문하지 않은 곳 부터 dfs 시작
            if( !visited[i] ) {
                answer++;

                dfs(i, n, computers, visited);
            }
        }

        return answer;
    }

    private static void dfs(int curr, int n, int[][] computers, boolean[] visited) {
        visited[curr] = true;

        for(int i = 0; i < n; i++) {
            // 방문한 적이 없고, 연결되어 있다면
            if( !visited[i] && computers[curr][i] == 1 ) {

                dfs(i, n, computers, visited);
            }
        }
    }
}
