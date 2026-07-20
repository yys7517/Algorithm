package codex;

import java.util.Arrays;

public class Solution_냅색연습 {
    public static void main(String[] args) {
        // [무게 - 가치]
        int[][] items = {
                {6, 13},
                {4, 8},
                {3, 6},
                {5, 12}
        };

        System.out.println(solution(7, items));   // 14
        System.out.println(solution(10, items)); // 21
        System.out.println(solution(2, items));  // 0
    }

    static int solution(int capacity, int[][] items) {
        int N = items.length;   // 아이템 개수
        int[][] dp = new int[N+1][capacity+1];  // dp[i][j] = i번째 아이템까지 확인했을 때, 그리고 현재 배낭의 최대 무게가 j일 때, 가질 수 있는 최대 가치

        for(int i = 1; i <= N; i++) {
            int itemWeight = items[i-1][0];
            int itemValue = items[i-1][1];

            // 현재 배낭 무게 weight
            for(int weight = 1; weight <= capacity; weight++) {
                if( weight < itemWeight ) {
                    // 현재 배낭에 담을 수 있는 최대 무게보다 아이템이 더 무겁다면
                    // 담지 않는다.
                    dp[i][weight] = dp[i-1][weight];    // 이전 아이템까지 확인했을 때, 최대 가질 수 있는 가치와 같다.
                } else {
                    // 현재 물건을 담을 수 있다.
                    // 하지만, 지금까지 담은 물건과 현재 물건을 같이 담을 수도 있기 때문에
                    // 현재 물건을 담는 경우와
                    // 담지 않는 경우로 나뉠 수 있다.
                    dp[i][weight] = Math.max(
                            dp[i-1][weight - itemWeight] + itemValue,   // 현재 물건을 담는다.
                            dp[i-1][weight] // 현재 물건을 담지 않는다.
                    );
                }
            }
        }

        return dp[N][capacity]; // 모든 아이템을 확인했고, 배낭의 무게가 capacity일 때, 가질 수 있는 최대 가치
    }
}
