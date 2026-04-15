package BOJ.gold;

import java.util.*;
import java.io.*;
public class Solution_RGB거리2 {
    static int N;
    static int INF = 1000 * 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int[][] cost = new int[N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;

        for(int i = 0; i < 3; i++) {
            int[][] dp = new int[N][3];

            // map[0][1], map[0][2], map[0][3] 중 하나 선택하여 구할 수 있는 비용 모두 구하기
            for(int j = 0; j < 3; j++) {
                if( i == j ) dp[0][j] = cost[0][j];  // 처음에 색상 하나 고르기
                else dp[0][j] = INF;                // 처음에 고른 색상 외에 INF로 설정.
            }

            for(int j = 1; j < N; j++) {
                dp[j][0] = cost[j][0] + Math.min( dp[j-1][1], dp[j-1][2] );
                dp[j][1] = cost[j][1] + Math.min( dp[j-1][0], dp[j-1][2] );
                dp[j][2] = cost[j][2] + Math.min( dp[j-1][0], dp[j-1][1] );
            }

            // for(int j = 0; j < N; j++) {
            //   for(int k = 0; k < 3; k++) {
            //     System.out.print(dp[j][k] + " ");
            //   }
            //   System.out.println();
            // }

            // N-1행에서, 첫 번째 행에서 선택한 색상과 값은 색상은 최소 비용에서 제외
            for(int j = 0; j < 3; j++) {
                if( i != j ) {
                    answer = Math.min( answer, dp[N-1][j] );
                }
            }
        }

        System.out.println(answer);
    }
}
