package Programmers.Level_2;

import java.util.*;

public class Solution_리코쳇로봇 {
    static int rows;
    static int cols;

    public int solution(String[] board) {
        int answer = 0;

        rows = board.length;
        cols = board[0].length();

        int sx = 0;
        int sy = 0;

        int ex = 0;
        int ey = 0;

        char[][] map = new char[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                map[i][j] = board[i].charAt(j);

                if( map[i][j] == 'R' ) {
                    sx = i;
                    sy = j;
                }

                if( map[i][j] == 'G' ) {
                    ex = i;
                    ey = j;
                }
            }
        }

        int dist = bfs(map, sx, sy, ex, ey);

        return dist;
    }

    static int bfs(char[][] map, int sx, int sy, int ex, int ey) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sx, sy, 0});

        boolean[][] visited = new boolean[rows][cols];
        visited[sx][sy] = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            if( x == ex && y == ey ) return dist;

            for(int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                // 쭉 미끄러져 이동
                while(true) {
                    nx += dx[i];
                    ny += dy[i];

                    if( nx < 0 || ny < 0 || nx >= rows || ny >= cols ) break;
                    if( map[nx][ny] == 'D' ) break;
                }

                // 좌표를 벗어났거나, 장애물일 때, while문이 종료되므로, 한 칸 다시 돌아온다.
                nx -= dx[i];
                ny -= dy[i];

                if( visited[nx][ny] ) continue;

                q.offer(new int[] {nx, ny, dist + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}
