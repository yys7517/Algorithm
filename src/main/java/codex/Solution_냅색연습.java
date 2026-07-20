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
        int[][] dp = new int[items.length + 1][capacity+1];   // dp[i][j] = 배낭의 무게가 i일 때, j번째까지 아이템을 확인했을 때 최대 가치

        for(int i = 1; i <= items.length; i++) {
            int itemWeight = items[i-1][0];
            int itemValue = items[i-1][1];

            for(int weight = 0; weight <= capacity; weight++) {
                if( weight >= itemWeight ) {
                    // 현재 물건을 담는다.
                    dp[i][weight] = Math.max(
                            dp[i-1][weight - itemWeight] + itemValue,   // 현재 물건의 무게만큼 빠졌을 때 가치와, 현재 물건의 가치의 합
                            dp[i-1][weight]         // 이전 물건까지 확인했을 때 최대 가치
                    );
                } else {
                    // 담지 않는다.
                    dp[i][weight] = dp[i-1][weight];    // 이전 물건까지 확인했을 때, 최대 가질 수 있는 값과 같다.
                }
            }
        }

        return dp[items.length][capacity];  // 배낭이 capacity만큼 담을 수 있을 때, 모든 아이템을 확인해서, 최대 가치를 구하라.
    }
}
