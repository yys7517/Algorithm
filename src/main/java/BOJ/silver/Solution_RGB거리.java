package BOJ.silver;

import java.io.*;
import java.util.*;

public class Solution_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        int[][] dp = new int[N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // i, i-1, i+1 번 색은 같지 않아야 한다.
        // 그니까, 같은 j열의 비용을 사용하면 안된다.

        // dp 배열은 2차원 배열
        // dp[i][j] => i,j 를 칠한다는 조건으로 설정하자

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for(int i = 1; i < N; i++) {
            dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

        int answer = Math.min(
                Math.min(dp[N-1][0] , dp[N-1][1]),
                dp[N-1][2]
        );

        System.out.println(answer);
    }
}
