package Programmers.Level_3;

public class Solution_도둑질 {
    public int solution(int[] money) {
        int answer = 0;

        // 첫 번째 집을 터는 기준
        int[] dp1 = new int[money.length];
        dp1[0] = money[0];
        dp1[1] = money[0];

        for(int i = 2; i < dp1.length - 1; i++) {
            dp1[i] = Math.max(dp1[i-2] + money[i] , dp1[i-1]);
        }

        int[] dp2 = new int[money.length];
        dp2[0] = 0;
        dp2[1] = money[1];

        for(int i = 2; i < dp2.length; i++) {
            dp2[i] = Math.max(dp2[i-2] + money[i] , dp2[i-1]);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < dp1.length; i++) {
            max = Math.max(max, Math.max(dp1[i], dp2[i]));
        }

        return max;
    }
}
