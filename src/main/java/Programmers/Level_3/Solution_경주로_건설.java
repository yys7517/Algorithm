package Programmers.Level_3;

import java.util.*;

public class Solution_경주로_건설 {
    // 상 하 좌 우
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static final int INF = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;

        // 그 정점에, 어떤 방향으로 도착했는지, 모든 경우의 수, 정점에 도착할 수 있는 최단 거리를 모두 기록
        int[][][] dist = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        // pq의 요소
        // (정점x, 정점y, 방향, 거리)
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> Integer.compare(a[3], b[3]) );

        pq.add( new int[] {0,0,1,0} );  // (0,0)에서 아래로 출발
        pq.add( new int[] {0,0,3,0} );  // (0,0)에서 우측으로 출발

        dist[0][0][1] = 0;
        dist[0][0][3] = 0;

        // dx[1], dy[1] - 하단
        // dx[3], dy[3] - 우측
        // 출발점에서는, 우측과 하단으로만 출발할 수 있다.

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int dir = curr[2];
            int cost = curr[3];

            // 지금 갱신하려는 값이 최단거리가 아니면 skip
            if( dist[x][y][dir] < cost ) continue;

            for(int nextDir = 0; nextDir < 4; nextDir++) {
                int nx = x + dx[nextDir];
                int ny = y + dy[nextDir];

                // 이동 가능한지 확인
                if( nx < 0 || ny < 0 || nx >= n || ny >= n ) continue;
                if( board[nx][ny] == 1 ) continue;  //  벽이면 안됨

                int nCost = cost + 100;
                if( dir != nextDir ) nCost += 500;

                if( dist[nx][ny][nextDir] > nCost ) {
                    dist[nx][ny][nextDir] = nCost;
                    pq.add(new int[] {nx, ny, nextDir, nCost});
                }
            }
        }

//         return Math.min(
//             dist[n-1][n-1][0],
//             Math.min( dist[n-1][n-1][1],
//                     Math.min( dist[n-1][n-1][2], dist[n-1][n-1][3] )
//             )
//         );

        return Arrays.stream(dist[n-1][n-1]).min().getAsInt();
    }
}
