package Programmers.Level_3;

import java.util.*;

public class Solution_경주로_건설 {
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static final int INF = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        int answer = INF;

        int n = board.length;

        int[][][] costs = new int[n][n][4];  // 4가지의 방향을 통해, 특정 정점에 도착하기 까지 든 비용
        for(int i = 0; i < costs.length; i++) {
            for(int j = 0; j < costs[i].length; j++) {
                Arrays.fill(costs[i][j], INF);
            }
        }

        // (정점 x, 정점 y, 방향, 비용)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[3], b[3]));

        // 시작점에서는 우측이랑, 아래 방향으로만 이동 가능

        costs[0][0][1] = 0; // 방향 1: 하단
        costs[0][0][3] = 0; // 방향 3: 우측

        pq.add(new int[] {0,0,1,0});
        pq.add(new int[] {0,0,3,0});

        while(!pq.isEmpty()) {
            // (정점 x, 정점 y, 방향, 비용)
            int[] curr = pq.poll();

            int x = curr[0];
            int y = curr[1];
            int dir = curr[2];
            int cost = curr[3];

            if( costs[x][y][dir] < cost ) continue;

            for(int nextDir = 0; nextDir < 4; nextDir++) {
                int nx = x + dx[nextDir];
                int ny = y + dy[nextDir];

                // 이동 가능한지?
                if( nx < 0 || ny < 0 || nx >= n || ny >= n ) continue;
                if( board[nx][ny] == 1 ) continue;      // 벽이면 skip


                int nCost = cost + 100; // 도로의 길이는 100

                // 코너이면 비용이 500만큼 더 추가 : 이전 방향과 달라지면, 코너가 생긴다.
                if(dir != nextDir) nCost += 500;

                // 최소 비용 갱신
                if( costs[nx][ny][nextDir] > nCost ) {
                    costs[nx][ny][nextDir] = nCost;
                    pq.add(new int[] {nx, ny, nextDir, nCost});
                }
            }
        }

        for(int i = 0; i < 4; i++) {
            answer = Math.min(answer, costs[n-1][n-1][i]);
        }

        return answer;
    }
}
