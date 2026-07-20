package Programmers.Level_3;

public class Solution_정수삼각형 {
    class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;

            int row = triangle.length;
            int col = triangle[row-1].length;

            int[][] dp = new int[row][col];
            dp[0][0] = triangle[0][0];

            // 삼각형의 높이는 1 이상 500 이하입니다.
            // dp[1][0] = triangle[0][0] + triangle[1][0];
            // dp[1][1] = triangle[0][0] + triangle[1][1];

//         dp[2][0] = dp[1][0] + triangle[2][0];
//         dp[2][1] = Math.max(dp[1][0], dp[1][1]) + triangle[2][1];
//         dp[2][2] = dp[1][1] + triangle[2][2];

//         dp[3][0] = dp[2][0] + triangle[3][0];
//         dp[3][1] = Math.max(dp[2][0], dp[2][1]) + triangle[3][1];
//         dp[3][2] = Math.max(dp[2][1], dp[2][2]) + triangle[3][2];
//         dp[3][3] = dp[2][2] + triangle[3][3];

//         dp[4][0] = dp[3][0] + triangle[4][0];
//         dp[4][1] = Math.max(dp[3][0], dp[3][1]) + triangle[4][1];

            for(int r = 1; r < row; r++) {
                for(int c = 0; c <= r; c++) {
                    dp[r][c] += triangle[r][c];

                    if( c == 0 ) { // 가장 왼쪽
                        dp[r][c] += dp[r-1][0];
                    } else if( c == r ) {   // 가장 오른쪽
                        dp[r][c] += dp[r-1][c-1];
                    } else { // 가운데
                        dp[r][c] += Math.max(dp[r-1][c-1], dp[r-1][c]);
                    }
                }
            }

            answer = -1;

            for(int c = 0; c < col; c++) {
                answer = Math.max(answer, dp[row-1][c]);
            }

            return answer;
        }
    }
}
