package Programmers.Level_3;

public class Solution_스티커_모으기 {
    public int solution(int[] sticker) {
        int answer = 0;
        int n = sticker.length;

        // sticker는 원형으로 연결된 스티커의 각 칸에 적힌 숫자가 순서대로 들어있는 배열로, 길이(N)는 1 이상 100,000 이하
        if( n == 1 ) return sticker[0];

        // 첫 번째 스티커를 사용하는 경우, 마지막 스티커를 사용하지 않는다.
        // [1, 3, 2, 5, 4] -> [0, 1, 3, 2, 5] ( 0 + sticker[0] ~ sticker[n-2] )
        int[] first = new int[n];
        first[0] = 0;
        first[1] = sticker[0];
        for(int i = 2; i < n; i++) {
            first[i] = Math.max( first[i-1], first[i-2] + sticker[i-1] );
        }

        // 마지막 스티커를 사용하는 경우
        // [1, 3, 2, 5, 4] -> [0, 3, 2, 5, 4] ( 0 + sticker[1] ~ sticker[n-1] )
        int[] last = new int[n];
        last[0] = 0;
        last[1] = sticker[1];

        for(int i = 2; i < n; i++) {
            last[i] = Math.max( last[i-1], last[i-2] + sticker[i] );
        }

        answer = Math.max( last[n-1], first[n-1] );

        return answer;
    }
}
