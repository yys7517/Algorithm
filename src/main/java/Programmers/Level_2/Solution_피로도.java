package Programmers.Level_2;

public class Solution_피로도 {
    static int maxCount = Integer.MIN_VALUE;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        dfs(k, dungeons, 0, visited);

        return maxCount;
    }

    static void dfs(int k, int[][] dungeons, int count, boolean[] visited) {
        maxCount = Math.max(maxCount, count);

        for(int i = 0; i < dungeons.length; i++) {
            int min = dungeons[i][0];
            int cost = dungeons[i][1];

            if( !visited[i] && k >= min ) {

                visited[i] = true;
                dfs(k-cost, dungeons, count + 1, visited);

                visited[i] = false;
            }
        }
    }
}
