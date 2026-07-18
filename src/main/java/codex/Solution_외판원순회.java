package codex;

import java.util.Arrays;

public class Solution_외판원순회 {
    // 0번 도시에서 출발
    // 모든 도시를 방문하고 다시 0으로 돌아와야 한다.

    // 그 때 최소 비용 return
    // costs[a][b] - a에서 b까지 이동하는 비용

    static int[][] dp;      // dp[current][mask] 현재 masking된 상태에서 돌아가기까지 하는 최소비용
    static int N;   // 도시의 개수

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 테스트 1
        int[][] costs1 = {
                {0, 7},
                {5, 0}
        };

        // 테스트 2
        int[][] costs2 = {
                {0, 2, 9},
                {1, 0, 6},
                {15, 7, 0}
        };

        // 테스트 3 - 실제 BOJ 외판원 순회 입력 예제
        int[][] costs3 = {
                {0, 10, 15, 20},
                {5, 0, 9, 10},
                {6, 13, 0, 12},
                {8, 8, 9, 0}
        };

//        System.out.println(solution(costs1));   // 기댓값: 12
//        System.out.println(solution(costs2));   // 기댓값: 17 , 0 → 2 → 1 → 0
        System.out.println(solution(costs3));   // 기댓값: 35
    }

    static int solution(int[][] costs) {
        N = costs.length;
        dp = new int[N][1 << N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int current = 0;
        int mask = 1 << 0;

        return dfs(costs, current, mask);
    }

    static int dfs(int[][] costs, int current, int mask) {
        int fullMask = ( 1 << N ) -1;

        if( mask == fullMask ) {    // 모든 도시를 방문했나?
            return costs[current][0] == 0 ? INF : costs[current][0];    // 출발점으로 다시 돌아가는 비용
        }

        if( dp[current][mask] != -1 ) {
            return dp[current][mask];
        }

        // 다음 도시로 이동
        int minCost = INF;
        for(int next = 0; next < N; next++) {

            // 이미 방문한 곳인가?
            if( ( mask & ( 1 << next ) ) != 0 ) continue;

            // 자기 자신으로 이동 X
            if( costs[current][next] == 0 ) continue;

            int nextMask = mask | ( 1 << next );

            int remain = dfs(costs, next, nextMask);
            if( remain == INF ) continue;   // 출발지로 돌아올 수 없는 경로인가?

            int totalCost = costs[current][next] + remain;

            minCost = Math.min(minCost, totalCost);
        }

        return dp[current][mask] = minCost;
    }
}
