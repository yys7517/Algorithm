package BOJ.silver;

import java.io.*;
import java.util.*;

public class Solution_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][] dp = new int[N][3];

        int min = Integer.MAX_VALUE;
        int minJ = -1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        // i, i-1, i+1 번 색은 같지 않아야 한다.
        // 그니까, 같은 j열의 비용을 사용하면 안된다.

        // dp 배열은 2차원 배열
        // dp[i][j] => i,j 를 칠한다는 조건으로 설정하자

        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];

        dp[1][0] = Math.min(dp[0][1], dp[0][2]) + map[1][0];
        dp[1][1] = Math.min(dp[0][0], dp[0][2]) + map[1][1];
        dp[1][2] = Math.min(dp[0][0], dp[0][1]) + map[1][2];

        for(int i = 2; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][j] = map[i][j];

                if(j == 0) {
                    dp[i][j] += Math.min(dp[i-1][1], dp[i-1][2]);
                } else if( j == 1 ) {
                    dp[i][j] += Math.min(dp[i-1][0], dp[i-1][2]);
                } else {
                    dp[i][j] += Math.min(dp[i-1][0], dp[i-1][1]);
                }
            }
        }

        int answer = Math.min( Math.min(dp[N-1][0] , dp[N-1][1]), dp[N-1][2] );

        System.out.println(answer);
    }
}
