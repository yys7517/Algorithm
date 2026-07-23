package Programmers.Level_3;

public class Solution_등굣길 {
    public int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[n+1][m+1];

        for(int[] point: puddles) {
            int r = point[1];
            int c = point[0];

            dp[r][c] = -1;
        }

        // 출발점
        dp[1][1] = 1;

        for(int r = 1; r <= n; r++) {
            for(int c = 1; c <= m; c++) {
                // 출발점은 이미 1로 초기화
                if(r == 1 && c == 1) continue;

                // 물웅덩이
                if(dp[r][c] == -1) continue;

                // 오른쪽과 아래 쪽으로만 이동 가능하다 => (r, c)로 이동 가능한 경로의 수 => (r-1, c) , (r, c-1)로 이동한 경로의 수의 합과 같다.
                int top = dp[r-1][c] == -1? 0 : dp[r-1][c];
                int left = dp[r][c-1] == -1? 0 :dp[r][c-1];

                dp[r][c] = Math.max(top + left, 0) % 1_000_000_007;
            }
        }

        return dp[n][m];
    }
}
