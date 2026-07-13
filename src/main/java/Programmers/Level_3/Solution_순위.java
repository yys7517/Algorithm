package Programmers.Level_3;

public class Solution_순위 {
    // 선수의 수 n
    public int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] isWinner = new boolean[n+1][n+1];

        for(int[] result: results) {
            // a가 b를 이겼다
            int a = result[0];
            int b = result[1];

            isWinner[a][b] = true;
        }

        for(int mid = 1; mid <= n; mid++) {
            for(int start = 1; start <= n; start++) {
                for(int end = 1; end <= n; end++) {
                    // k가 i를 이기고, i가 j를 이겼다면, k는 j도 이길 수 있는 것과 같다.
                    if( isWinner[start][mid] && isWinner[mid][end] ) isWinner[start][end] = true;
                }
            }
        }

        // 정확하게 순위를 매길 수 있는 선수의 수?
        // 자신이 이긴 사람의 수 + 자신이 진 사람의 수 = n-1 일 때만, 정확하게 순위를 매길 수 있다.
        for(int me = 1; me <= n; me++) {
            int winCount = 0;
            int loseCount = 0;

            for(int enemy = 1; enemy <= n; enemy++) {
                if( me == enemy ) continue;

                if(isWinner[me][enemy]) winCount++;  // 자신이 이겼나
                if(isWinner[enemy][me]) loseCount++; // 자신이 졌나?
            }

            if(winCount + loseCount == n-1) answer++;
        }

        return answer;
    }
}
