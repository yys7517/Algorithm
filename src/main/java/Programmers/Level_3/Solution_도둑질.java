package Programmers.Level_3;

public class Solution_도둑질 {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;

        // ex) money = [1,10,20,4,40]

        // 첫 번째 집을 터는 기준, 마지막 집을 못 턴다.
        // [1,10,20,4,40] -> [1,10,20,4] -> [0,1,10,20,4] ( 0 + money[0] ~ money[n-2] )
        int[] first = new int[n];
        first[0] = 0;
        first[1] = money[0];

        for(int i = 2; i < n; i++) {
            first[i] = Math.max( first[i-1], first[i-2] + money[i-1] );
        }

        // 마지막 집을 터는 기준, 첫 번째 집을 못 턴다.
        // [1,10,20,4,40] -> [10,20,4,40] -> [0,10,20,4,40] ( 0 + money[1] ~ money[n-1] )
        int[] last = new int[n];
        last[0] = 0;
        last[1] = money[1];

        for(int i = 2; i < n; i++) {
            last[i] = Math.max( last[i-1], last[i-2] + money[i] );
        }

        answer = Math.max( last[n-1], first[n-1] );

        return answer;
    }
}
