package Programmers.Level_2;

public class Solution_2xn타일링 {
    public int solution(int n) {
//         int answer = 0;
//         return answer;

        // 세로2, 가로가 n

        // 가로의 길이가 2, 세로의 길이가 1인 직사각형 타일

        // 넓이 = 2 * n
        // 들어가는 타일의 수는

        // n의 값에 따라 방법의 수를 저장하는 dp
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;

        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000007 ;
        }

        return dp[n];
    }
}
