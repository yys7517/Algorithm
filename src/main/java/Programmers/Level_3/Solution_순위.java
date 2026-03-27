package Programmers.Level_3;

public class Solution_순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        // winner[i][j] == true , i가 j를 이긴 것.
        boolean[][] isWinner = new boolean[n+1][n+1];
        for(int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            isWinner[winner][loser] = true;
        }

        // 정보가 파편화 되어있기 때문에, 플로이드-와샬을 사용하자.
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if( isWinner[i][k] && isWinner[k][j] ) {    // i가 k를 이겼고, k가 j를 이겼으면,
                        isWinner[i][j] = true;  //  i가 j를 이긴 것과 같다.
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            int winnerCount = 0;    // i를 이긴 사람
            int loserCount = 0;     // i한테 진 사람

            for(int j = 1; j <= n; j++) {
                if(i == j) continue;

                if(isWinner[i][j]) loserCount++;    // i가 j를 이겼나?
                if(isWinner[j][i]) winnerCount++;   // j가 i를 이겼나?
            }

            // 두 결과의 합이 n-1이면, 순위를 알 수 있음.
            if(winnerCount + loserCount == n - 1) answer++;
        }


        return answer;
    }
}
