package BOJ.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_평범한배낭 {
    static int N, K;
//    static int answer;
    static int[][] items;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        items = new int[N+1][2];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int W = Integer.parseInt(st.nextToken()); // 무게
            int V = Integer.parseInt(st.nextToken()); // 가치

            items[i][0] = W;
            items[i][1] = V;
        }

        dp = new int[N+1][K+1];

        for(int i = 1; i <= N; i++) {
            int weight = items[i][0];
            int value = items[i][1];

            for(int j = 1; j <= K; j++) {
                if(j < weight) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + value);
                }
            }
        }

        // dfs(depth, weight, currVal);

        System.out.println(dp[N][K]);
    }


    // static void dfs(int depth, int weight, int currVal) {
    //   if( depth == N ) {
    //     answer = Math.max(answer, currVal);
    //     return;
    //   }

    //   // 물건을 집을 때
    //   if( weight + items[depth][0] <= K ) {
    //     dfs( depth + 1, weight + items[depth][0], currVal + items[depth][1] );
    //   }

    //   // 물건을 안 집을 때
    //   if(weight <= K) {
    //     dfs( depth + 1, weight, currVal );
    //   }
    // }
}
