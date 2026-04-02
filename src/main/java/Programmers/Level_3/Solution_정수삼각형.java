package Programmers.Level_3;

public class Solution_정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[0][0] + triangle[1][0];
        dp[1][1] = triangle[0][0] + triangle[1][1];

        for(int i = 2; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                dp[i][j] += triangle[i][j];

                if( j == 0 ) {
                    dp[i][j] += dp[i-1][0];
                } else {
                    dp[i][j] += Math.max( dp[i-1][j] , dp[i-1][j-1] );
                }

                answer = Math.max( answer, dp[i][j] );
            }
        }

        return answer;
    }
}
