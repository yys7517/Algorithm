package codex;

import java.util.Arrays;

public class Solution_외판원순회연습 {
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

        System.out.println(solution(costs1));   // 기댓값: 12
        System.out.println(solution(costs2));   // 기댓값: 17 , 0 → 2 → 1 → 0
        System.out.println(solution(costs3));   // 기댓값: 35
    }

    static int N;
    static int[][] dp;
    static final int INF = Integer.MAX_VALUE;

    static int solution(int[][] costs) {
        N = costs.length;;
        dp = new int[N][1 << N];    // dp[i][1 << n] - 현재 도시 i까지 이동할 때, 현재 방문 상태가 1 << n 일 때, 드는 최소 비용
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int current = 0;
        int mask = 1 << 0;

        return dfs(costs, current, mask);
    }

    static int dfs(int[][] costs, int current, int mask) {
        int fullMask = (1 << N) - 1;

        if( mask == fullMask ) {
            // 모두 방문했으면, 다시 출발지로 돌아가야 한다.
            // 돌아갈 수 없는 경로라면, INF(돌아갈 수 없음)을 리턴
            return costs[current][0] == 0 ? INF : costs[current][0];
        }

        // 메모이제이션, 이미 저장된 값이 있다면, 리턴
        if( dp[current][mask] != -1 ) {
            return dp[current][mask];
        }

        int minCost = INF;

        // 다음 도시 방문
        for(int next = 1; next < N; next++) {
            // 방문 체크
            if( (mask & ( 1 << next) ) != 0 ) continue;

            if( costs[current][next] == 0 ) continue;   // 갈 수 없는 경로라면

            int nextMask = mask | ( 1 << next );

            int remain = dfs(costs, next, nextMask);    // 현재 도시에서 더 가야하는데, 드는 비용
            if( remain == INF ) continue;       // 모든 도시를 방문하고, 출발지로 돌아올 수 없는 경로라면, skip

            int totalCost = costs[current][next] + remain;  // 현재 -> next 비용 + 나머지 비용

            minCost = Math.min(minCost, totalCost);
        }

        return dp[current][mask] = minCost;
    }
}
