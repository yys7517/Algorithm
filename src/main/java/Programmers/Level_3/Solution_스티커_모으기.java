package Programmers.Level_3;

public class Solution_스티커_모으기 {
    public int solution(int sticker[]) {
        int answer = 0;

        // 배열의 길이는 1이상 100_000
        if(sticker.length == 1) {
            return sticker[0];
        }

        int[] dp1 = new int[sticker.length];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        for(int i = 2; i < dp1.length - 1; i++) {
            dp1[i] = Math.max(dp1[i-2] + sticker[i] , dp1[i-1]);
        }

        int[] dp2 = new int[sticker.length];
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for(int i = 2; i < dp2.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i] , dp2[i - 1]);
        }

        return Math.max(dp1[dp1.length - 2], dp2[dp2.length - 1]);
    }
}
