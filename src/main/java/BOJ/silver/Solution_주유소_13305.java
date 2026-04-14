package BOJ.silver;

import java.io.*;
import java.util.*;

public class Solution_주유소_13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long answer;
        long minCost;
        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < N; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        long[] cost = new long[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long[] dp = new long[N+1];
        dp[0] = 0;
        dp[1] = 0;

        minCost = cost[1];

        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + minCost * dist[i-1];

            minCost = Math.min(minCost, cost[i]);
        }

        answer = dp[N];
        System.out.println(answer);
    }
}
